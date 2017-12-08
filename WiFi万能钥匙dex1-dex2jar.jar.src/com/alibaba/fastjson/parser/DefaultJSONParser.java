package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.CollectionResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ListResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultJSONParser
  extends AbstractJSONParser
  implements Closeable
{
  public static final int NONE = 0;
  public static final int NeedToResolve = 1;
  public static final int TypeNameRedirect = 2;
  private static final Set<Class<?>> primitiveClasses;
  protected ParserConfig config;
  protected ParseContext context;
  private ParseContext[] contextArray = new ParseContext[8];
  private int contextArrayIndex = 0;
  private DateFormat dateFormat;
  private String dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
  private List<ExtraProcessor> extraProcessors = null;
  private List<ExtraTypeProvider> extraTypeProviders = null;
  protected final Object input;
  protected final JSONLexer lexer;
  private int resolveStatus = 0;
  private List<ResolveTask> resolveTaskList;
  protected final SymbolTable symbolTable;
  
  static
  {
    HashSet localHashSet = new HashSet();
    primitiveClasses = localHashSet;
    localHashSet.add(Boolean.TYPE);
    primitiveClasses.add(Byte.TYPE);
    primitiveClasses.add(Short.TYPE);
    primitiveClasses.add(Integer.TYPE);
    primitiveClasses.add(Long.TYPE);
    primitiveClasses.add(Float.TYPE);
    primitiveClasses.add(Double.TYPE);
    primitiveClasses.add(Boolean.class);
    primitiveClasses.add(Byte.class);
    primitiveClasses.add(Short.class);
    primitiveClasses.add(Integer.class);
    primitiveClasses.add(Long.class);
    primitiveClasses.add(Float.class);
    primitiveClasses.add(Double.class);
    primitiveClasses.add(BigInteger.class);
    primitiveClasses.add(BigDecimal.class);
    primitiveClasses.add(String.class);
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer)
  {
    this(paramJSONLexer, ParserConfig.getGlobalInstance());
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer, ParserConfig paramParserConfig)
  {
    this(null, paramJSONLexer, paramParserConfig);
  }
  
  public DefaultJSONParser(Object paramObject, JSONLexer paramJSONLexer, ParserConfig paramParserConfig)
  {
    this.lexer = paramJSONLexer;
    this.input = paramObject;
    this.config = paramParserConfig;
    this.symbolTable = paramParserConfig.getSymbolTable();
    paramJSONLexer.nextToken(12);
  }
  
  public DefaultJSONParser(String paramString)
  {
    this(paramString, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig)
  {
    this(paramString, new JSONScanner(paramString, JSON.DEFAULT_PARSER_FEATURE), paramParserConfig);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt)
  {
    this(paramString, new JSONScanner(paramString, paramInt), paramParserConfig);
  }
  
  public DefaultJSONParser(char[] paramArrayOfChar, int paramInt1, ParserConfig paramParserConfig, int paramInt2)
  {
    this(paramArrayOfChar, new JSONScanner(paramArrayOfChar, paramInt1, paramInt2), paramParserConfig);
  }
  
  private void addContext(ParseContext paramParseContext)
  {
    int i = this.contextArrayIndex;
    this.contextArrayIndex = (i + 1);
    if (i >= this.contextArray.length)
    {
      ParseContext[] arrayOfParseContext = new ParseContext[this.contextArray.length * 3 / 2];
      System.arraycopy(this.contextArray, 0, arrayOfParseContext, 0, this.contextArray.length);
      this.contextArray = arrayOfParseContext;
    }
    this.contextArray[i] = paramParseContext;
  }
  
  public final void accept(int paramInt)
  {
    JSONLexer localJSONLexer = getLexer();
    if (localJSONLexer.token() == paramInt)
    {
      localJSONLexer.nextToken();
      return;
    }
    throw new JSONException("syntax error, expect " + JSONToken.name(paramInt) + ", actual " + JSONToken.name(localJSONLexer.token()));
  }
  
  public final void accept(int paramInt1, int paramInt2)
  {
    JSONLexer localJSONLexer = getLexer();
    if (localJSONLexer.token() == paramInt1)
    {
      localJSONLexer.nextToken(paramInt2);
      return;
    }
    throw new JSONException("syntax error, expect " + JSONToken.name(paramInt1) + ", actual " + JSONToken.name(localJSONLexer.token()));
  }
  
  public void acceptType(String paramString)
  {
    JSONLexer localJSONLexer = this.lexer;
    localJSONLexer.nextTokenWithColon();
    if (localJSONLexer.token() != 4) {
      throw new JSONException("type not match error");
    }
    if (paramString.equals(localJSONLexer.stringVal()))
    {
      localJSONLexer.nextToken();
      if (localJSONLexer.token() == 16) {
        localJSONLexer.nextToken();
      }
      return;
    }
    throw new JSONException("type not match error");
  }
  
  public void addResolveTask(ResolveTask paramResolveTask)
  {
    if (this.resolveTaskList == null) {
      this.resolveTaskList = new ArrayList(2);
    }
    this.resolveTaskList.add(paramResolveTask);
  }
  
  public void checkListResolve(Collection paramCollection)
  {
    ResolveTask localResolveTask;
    if (this.resolveStatus == 1)
    {
      if (!(paramCollection instanceof List)) {
        break label62;
      }
      int i = paramCollection.size();
      paramCollection = (List)paramCollection;
      localResolveTask = getLastResolveTask();
      localResolveTask.setFieldDeserializer(new ListResolveFieldDeserializer(this, paramCollection, i - 1));
      localResolveTask.setOwnerContext(this.context);
      setResolveStatus(0);
    }
    for (;;)
    {
      return;
      label62:
      localResolveTask = getLastResolveTask();
      localResolveTask.setFieldDeserializer(new CollectionResolveFieldDeserializer(this, paramCollection));
      localResolveTask.setOwnerContext(this.context);
      setResolveStatus(0);
    }
  }
  
  public void checkMapResolve(Map paramMap, String paramString)
  {
    if (this.resolveStatus == 1)
    {
      paramMap = new MapResolveFieldDeserializer(paramMap, paramString);
      paramString = getLastResolveTask();
      paramString.setFieldDeserializer(paramMap);
      paramString.setOwnerContext(this.context);
      setResolveStatus(0);
    }
  }
  
  public void close()
  {
    JSONLexer localJSONLexer = getLexer();
    try
    {
      if ((isEnabled(Feature.AutoCloseSource)) && (localJSONLexer.token() != 20))
      {
        JSONException localJSONException = new com/alibaba/fastjson/JSONException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("not close json text, token : ");
        localJSONException.<init>(JSONToken.name(localJSONLexer.token()));
        throw localJSONException;
      }
    }
    finally
    {
      localJSONLexer.close();
    }
    localJSONLexer.close();
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    getLexer().config(paramFeature, paramBoolean);
  }
  
  public ParserConfig getConfig()
  {
    return this.config;
  }
  
  public ParseContext getContext()
  {
    return this.context;
  }
  
  public String getDateFomartPattern()
  {
    return this.dateFormatPattern;
  }
  
  public DateFormat getDateFormat()
  {
    if (this.dateFormat == null) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
    }
    return this.dateFormat;
  }
  
  public List<ExtraProcessor> getExtraProcessors()
  {
    if (this.extraProcessors == null) {
      this.extraProcessors = new ArrayList(2);
    }
    return this.extraProcessors;
  }
  
  public List<ExtraProcessor> getExtraProcessorsDirect()
  {
    return this.extraProcessors;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProviders()
  {
    if (this.extraTypeProviders == null) {
      this.extraTypeProviders = new ArrayList(2);
    }
    return this.extraTypeProviders;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProvidersDirect()
  {
    return this.extraTypeProviders;
  }
  
  public String getInput()
  {
    if ((this.input instanceof char[])) {}
    for (String str = new String((char[])this.input);; str = this.input.toString()) {
      return str;
    }
  }
  
  public ResolveTask getLastResolveTask()
  {
    return (ResolveTask)this.resolveTaskList.get(this.resolveTaskList.size() - 1);
  }
  
  public JSONLexer getLexer()
  {
    return this.lexer;
  }
  
  public Object getObject(String paramString)
  {
    int i = 0;
    if (i < this.contextArrayIndex) {
      if (!paramString.equals(this.contextArray[i].getPath())) {}
    }
    for (paramString = this.contextArray[i].getObject();; paramString = null)
    {
      return paramString;
      i++;
      break;
    }
  }
  
  public int getResolveStatus()
  {
    return this.resolveStatus;
  }
  
  public List<ResolveTask> getResolveTaskList()
  {
    if (this.resolveTaskList == null) {
      this.resolveTaskList = new ArrayList(2);
    }
    return this.resolveTaskList;
  }
  
  public List<ResolveTask> getResolveTaskListDirect()
  {
    return this.resolveTaskList;
  }
  
  public SymbolTable getSymbolTable()
  {
    return this.symbolTable;
  }
  
  public boolean isEnabled(Feature paramFeature)
  {
    return getLexer().isEnabled(paramFeature);
  }
  
  public Object parse()
  {
    return parse(null);
  }
  
  /* Error */
  public Object parse(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 171	com/alibaba/fastjson/parser/DefaultJSONParser:getLexer	()Lcom/alibaba/fastjson/parser/JSONLexer;
    //   7: astore 5
    //   9: aload 5
    //   11: invokeinterface 175 1 0
    //   16: tableswitch	default:+100->116, 2:+226->242, 3:+244->260, 4:+269->285, 5:+100->116, 6:+371->387, 7:+385->401, 8:+358->374, 9:+399->415, 10:+100->116, 11:+100->116, 12:+210->226, 13:+100->116, 14:+188->204, 15:+100->116, 16:+100->116, 17:+100->116, 18:+100->116, 19:+100->116, 20:+480->496, 21:+131->147, 22:+159->175
    //   116: new 179	com/alibaba/fastjson/JSONException
    //   119: dup
    //   120: new 181	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 335
    //   127: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload 5
    //   132: invokeinterface 338 1 0
    //   137: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 202	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: aload 5
    //   149: invokeinterface 177 1 0
    //   154: new 48	java/util/HashSet
    //   157: dup
    //   158: invokespecial 51	java/util/HashSet:<init>	()V
    //   161: astore 4
    //   163: aload_0
    //   164: aload 4
    //   166: aload_1
    //   167: invokevirtual 345	com/alibaba/fastjson/parser/DefaultJSONParser:parseArray	(Ljava/util/Collection;Ljava/lang/Object;)V
    //   170: aload 4
    //   172: astore_1
    //   173: aload_1
    //   174: areturn
    //   175: aload 5
    //   177: invokeinterface 177 1 0
    //   182: new 347	java/util/TreeSet
    //   185: dup
    //   186: invokespecial 348	java/util/TreeSet:<init>	()V
    //   189: astore 4
    //   191: aload_0
    //   192: aload 4
    //   194: aload_1
    //   195: invokevirtual 345	com/alibaba/fastjson/parser/DefaultJSONParser:parseArray	(Ljava/util/Collection;Ljava/lang/Object;)V
    //   198: aload 4
    //   200: astore_1
    //   201: goto -28 -> 173
    //   204: new 350	com/alibaba/fastjson/JSONArray
    //   207: dup
    //   208: invokespecial 351	com/alibaba/fastjson/JSONArray:<init>	()V
    //   211: astore 4
    //   213: aload_0
    //   214: aload 4
    //   216: aload_1
    //   217: invokevirtual 345	com/alibaba/fastjson/parser/DefaultJSONParser:parseArray	(Ljava/util/Collection;Ljava/lang/Object;)V
    //   220: aload 4
    //   222: astore_1
    //   223: goto -50 -> 173
    //   226: aload_0
    //   227: new 353	com/alibaba/fastjson/JSONObject
    //   230: dup
    //   231: invokespecial 354	com/alibaba/fastjson/JSONObject:<init>	()V
    //   234: aload_1
    //   235: invokevirtual 358	com/alibaba/fastjson/parser/DefaultJSONParser:parseObject	(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: astore_1
    //   239: goto -66 -> 173
    //   242: aload 5
    //   244: invokeinterface 362 1 0
    //   249: astore_1
    //   250: aload 5
    //   252: invokeinterface 177 1 0
    //   257: goto -84 -> 173
    //   260: aload 5
    //   262: aload_0
    //   263: getstatic 365	com/alibaba/fastjson/parser/Feature:UseBigDecimal	Lcom/alibaba/fastjson/parser/Feature;
    //   266: invokevirtual 276	com/alibaba/fastjson/parser/DefaultJSONParser:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   269: invokeinterface 369 2 0
    //   274: astore_1
    //   275: aload 5
    //   277: invokeinterface 177 1 0
    //   282: goto -109 -> 173
    //   285: aload 5
    //   287: invokeinterface 212 1 0
    //   292: astore 4
    //   294: aload 5
    //   296: bipush 16
    //   298: invokeinterface 141 2 0
    //   303: aload 4
    //   305: astore_1
    //   306: aload 5
    //   308: getstatic 372	com/alibaba/fastjson/parser/Feature:AllowISO8601DateFormat	Lcom/alibaba/fastjson/parser/Feature;
    //   311: invokeinterface 329 2 0
    //   316: ifeq -143 -> 173
    //   319: new 151	com/alibaba/fastjson/parser/JSONScanner
    //   322: dup
    //   323: aload 4
    //   325: invokespecial 373	com/alibaba/fastjson/parser/JSONScanner:<init>	(Ljava/lang/String;)V
    //   328: astore 5
    //   330: aload 5
    //   332: invokevirtual 377	com/alibaba/fastjson/parser/JSONScanner:scanISO8601DateIfMatch	()Z
    //   335: ifeq +20 -> 355
    //   338: aload 5
    //   340: invokevirtual 381	com/alibaba/fastjson/parser/JSONScanner:getCalendar	()Ljava/util/Calendar;
    //   343: invokevirtual 387	java/util/Calendar:getTime	()Ljava/util/Date;
    //   346: astore_1
    //   347: aload 5
    //   349: invokevirtual 388	com/alibaba/fastjson/parser/JSONScanner:close	()V
    //   352: goto -179 -> 173
    //   355: aload 5
    //   357: invokevirtual 388	com/alibaba/fastjson/parser/JSONScanner:close	()V
    //   360: aload 4
    //   362: astore_1
    //   363: goto -190 -> 173
    //   366: astore_1
    //   367: aload 5
    //   369: invokevirtual 388	com/alibaba/fastjson/parser/JSONScanner:close	()V
    //   372: aload_1
    //   373: athrow
    //   374: aload 5
    //   376: invokeinterface 177 1 0
    //   381: aload 4
    //   383: astore_1
    //   384: goto -211 -> 173
    //   387: aload 5
    //   389: invokeinterface 177 1 0
    //   394: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   397: astore_1
    //   398: goto -225 -> 173
    //   401: aload 5
    //   403: invokeinterface 177 1 0
    //   408: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   411: astore_1
    //   412: goto -239 -> 173
    //   415: aload 5
    //   417: bipush 18
    //   419: invokeinterface 141 2 0
    //   424: aload 5
    //   426: invokeinterface 175 1 0
    //   431: bipush 18
    //   433: if_icmpeq +14 -> 447
    //   436: new 179	com/alibaba/fastjson/JSONException
    //   439: dup
    //   440: ldc_w 397
    //   443: invokespecial 202	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   446: athrow
    //   447: aload 5
    //   449: bipush 10
    //   451: invokeinterface 141 2 0
    //   456: aload_0
    //   457: bipush 10
    //   459: invokevirtual 399	com/alibaba/fastjson/parser/DefaultJSONParser:accept	(I)V
    //   462: aload 5
    //   464: invokeinterface 362 1 0
    //   469: invokevirtual 405	java/lang/Number:longValue	()J
    //   472: lstore_2
    //   473: aload_0
    //   474: iconst_2
    //   475: invokevirtual 399	com/alibaba/fastjson/parser/DefaultJSONParser:accept	(I)V
    //   478: aload_0
    //   479: bipush 11
    //   481: invokevirtual 399	com/alibaba/fastjson/parser/DefaultJSONParser:accept	(I)V
    //   484: new 407	java/util/Date
    //   487: dup
    //   488: lload_2
    //   489: invokespecial 410	java/util/Date:<init>	(J)V
    //   492: astore_1
    //   493: goto -320 -> 173
    //   496: aload 4
    //   498: astore_1
    //   499: aload 5
    //   501: invokeinterface 413 1 0
    //   506: ifne -333 -> 173
    //   509: new 179	com/alibaba/fastjson/JSONException
    //   512: dup
    //   513: new 181	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 415
    //   520: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload 5
    //   525: invokeinterface 338 1 0
    //   530: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokespecial 202	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;)V
    //   539: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	DefaultJSONParser
    //   0	540	1	paramObject	Object
    //   472	17	2	l	long
    //   1	496	4	localObject1	Object
    //   7	517	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   330	347	366	finally
  }
  
  public <T> List<T> parseArray(Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    parseArray(paramClass, localArrayList);
    return localArrayList;
  }
  
  public void parseArray(Class<?> paramClass, Collection paramCollection)
  {
    parseArray(paramClass, paramCollection);
  }
  
  public void parseArray(Type paramType, Collection paramCollection)
  {
    parseArray(paramType, paramCollection, null);
  }
  
  public void parseArray(Type paramType, Collection paramCollection, Object paramObject)
  {
    if ((this.lexer.token() == 21) || (this.lexer.token() == 22)) {
      this.lexer.nextToken();
    }
    if (this.lexer.token() != 14) {
      throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token()));
    }
    Object localObject;
    ParseContext localParseContext;
    if (Integer.TYPE == paramType)
    {
      localObject = IntegerCodec.instance;
      this.lexer.nextToken(2);
      localParseContext = getContext();
      setContext(paramCollection, paramObject);
    }
    for (int i = 0;; i++)
    {
      try
      {
        if (!isEnabled(Feature.AllowArbitraryCommas)) {
          break label223;
        }
        while (this.lexer.token() == 16) {
          this.lexer.nextToken();
        }
        if (String.class != paramType) {
          break label194;
        }
      }
      finally
      {
        setContext(localParseContext);
      }
      localObject = StringCodec.instance;
      this.lexer.nextToken(4);
      break;
      label194:
      localObject = this.config.getDeserializer(paramType);
      this.lexer.nextToken(((ObjectDeserializer)localObject).getFastMatchToken());
      break;
      label223:
      if (this.lexer.token() == 15) {
        break label428;
      }
      if (Integer.TYPE != paramType) {
        break label296;
      }
      paramCollection.add(IntegerCodec.instance.deserialze(this, null, null));
      if (this.lexer.token() == 16) {
        this.lexer.nextToken(((ObjectDeserializer)localObject).getFastMatchToken());
      }
    }
    label296:
    if (String.class == paramType)
    {
      if (this.lexer.token() == 4)
      {
        paramObject = this.lexer.stringVal();
        this.lexer.nextToken(16);
      }
      for (;;)
      {
        paramCollection.add(paramObject);
        break;
        paramObject = parse();
        if (paramObject == null) {
          paramObject = null;
        } else {
          paramObject = paramObject.toString();
        }
      }
    }
    if (this.lexer.token() == 8) {
      this.lexer.nextToken();
    }
    for (paramObject = null;; paramObject = ((ObjectDeserializer)localObject).deserialze(this, paramType, Integer.valueOf(i)))
    {
      paramCollection.add(paramObject);
      checkListResolve(paramCollection);
      break;
    }
    label428:
    setContext(localParseContext);
    this.lexer.nextToken(16);
  }
  
  public final void parseArray(Collection paramCollection)
  {
    parseArray(paramCollection, null);
  }
  
  public final void parseArray(Collection paramCollection, Object paramObject)
  {
    JSONLexer localJSONLexer = getLexer();
    if ((localJSONLexer.token() == 21) || (localJSONLexer.token() == 22)) {
      localJSONLexer.nextToken();
    }
    if (localJSONLexer.token() != 14) {
      throw new JSONException("syntax error, expect [, actual " + JSONToken.name(localJSONLexer.token()) + ", pos " + localJSONLexer.pos());
    }
    localJSONLexer.nextToken(4);
    ParseContext localParseContext = getContext();
    setContext(paramCollection, paramObject);
    int i = 0;
    try
    {
      if (isEnabled(Feature.AllowArbitraryCommas)) {
        while (localJSONLexer.token() == 16) {
          localJSONLexer.nextToken();
        }
      }
      switch (localJSONLexer.token())
      {
      }
    }
    finally
    {
      setContext(localParseContext);
    }
    paramObject = parse();
    for (;;)
    {
      paramCollection.add(paramObject);
      checkListResolve(paramCollection);
      if (localJSONLexer.token() == 16) {
        localJSONLexer.nextToken(4);
      }
      i++;
      break;
      paramObject = localJSONLexer.integerValue();
      localJSONLexer.nextToken(16);
      continue;
      if (localJSONLexer.isEnabled(Feature.UseBigDecimal)) {}
      for (paramObject = localJSONLexer.decimalValue(true);; paramObject = localJSONLexer.decimalValue(false))
      {
        localJSONLexer.nextToken(16);
        break;
      }
      String str = localJSONLexer.stringVal();
      localJSONLexer.nextToken(16);
      paramObject = str;
      if (localJSONLexer.isEnabled(Feature.AllowISO8601DateFormat))
      {
        JSONScanner localJSONScanner = new com/alibaba/fastjson/parser/JSONScanner;
        localJSONScanner.<init>(str);
        paramObject = str;
        if (localJSONScanner.scanISO8601DateIfMatch()) {
          paramObject = localJSONScanner.getCalendar().getTime();
        }
        localJSONScanner.close();
        continue;
        paramObject = Boolean.TRUE;
        localJSONLexer.nextToken(16);
        continue;
        paramObject = Boolean.FALSE;
        localJSONLexer.nextToken(16);
        continue;
        paramObject = new com/alibaba/fastjson/JSONObject;
        ((JSONObject)paramObject).<init>();
        paramObject = parseObject((Map)paramObject, Integer.valueOf(i));
        continue;
        paramObject = new com/alibaba/fastjson/JSONArray;
        ((JSONArray)paramObject).<init>();
        parseArray((Collection)paramObject, Integer.valueOf(i));
        continue;
        paramObject = null;
        localJSONLexer.nextToken(4);
      }
    }
    localJSONLexer.nextToken(16);
    setContext(localParseContext);
    return;
    paramCollection = new com/alibaba/fastjson/JSONException;
    paramCollection.<init>("unclosed jsonArray");
    throw paramCollection;
  }
  
  public Object[] parseArray(Type[] paramArrayOfType)
  {
    Object localObject = null;
    if (this.lexer.token() == 8) {
      this.lexer.nextToken(16);
    }
    Object[] arrayOfObject;
    for (paramArrayOfType = (Type[])localObject;; paramArrayOfType = new Object[0])
    {
      return paramArrayOfType;
      if (this.lexer.token() != 14) {
        throw new JSONException("syntax error : " + this.lexer.tokenName());
      }
      arrayOfObject = new Object[paramArrayOfType.length];
      if (paramArrayOfType.length != 0) {
        break;
      }
      this.lexer.nextToken(15);
      if (this.lexer.token() != 15) {
        throw new JSONException("syntax error");
      }
      this.lexer.nextToken(16);
    }
    this.lexer.nextToken(2);
    int i = 0;
    label193:
    Type localType;
    boolean bool;
    if (i < paramArrayOfType.length)
    {
      if (this.lexer.token() == 8)
      {
        this.lexer.nextToken(16);
        localObject = null;
      }
      for (;;)
      {
        arrayOfObject[i] = localObject;
        if (this.lexer.token() == 15) {
          break label676;
        }
        if (this.lexer.token() == 16) {
          break label638;
        }
        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
        localType = paramArrayOfType[i];
        if ((localType == Integer.TYPE) || (localType == Integer.class))
        {
          if (this.lexer.token() == 2)
          {
            localObject = Integer.valueOf(this.lexer.intValue());
            this.lexer.nextToken(16);
          }
          else
          {
            localObject = TypeUtils.cast(parse(), localType, this.config);
          }
        }
        else
        {
          if (localType != String.class) {
            break;
          }
          if (this.lexer.token() == 4)
          {
            localObject = this.lexer.stringVal();
            this.lexer.nextToken(16);
          }
          else
          {
            localObject = TypeUtils.cast(parse(), localType, this.config);
          }
        }
      }
      if ((i != paramArrayOfType.length - 1) || (!(localType instanceof Class))) {
        break label718;
      }
      localObject = (Class)localType;
      bool = ((Class)localObject).isArray();
      localObject = ((Class)localObject).getComponentType();
    }
    for (;;)
    {
      if ((bool) && (this.lexer.token() != 14))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = this.config.getDeserializer((Type)localObject);
        int j = ((ObjectDeserializer)localObject).getFastMatchToken();
        if (this.lexer.token() != 15)
        {
          for (;;)
          {
            localArrayList.add(((ObjectDeserializer)localObject).deserialze(this, localType, null));
            if (this.lexer.token() != 16) {
              break;
            }
            this.lexer.nextToken(j);
          }
          if (this.lexer.token() != 15) {
            throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
          }
        }
        localObject = TypeUtils.cast(localArrayList, localType, this.config);
        break label193;
      }
      localObject = this.config.getDeserializer(localType).deserialze(this, localType, null);
      break label193;
      label638:
      if (i == paramArrayOfType.length - 1) {
        this.lexer.nextToken(15);
      }
      for (;;)
      {
        i++;
        break;
        this.lexer.nextToken(2);
      }
      label676:
      if (this.lexer.token() != 15) {
        throw new JSONException("syntax error");
      }
      this.lexer.nextToken(16);
      paramArrayOfType = arrayOfObject;
      break;
      label718:
      localObject = null;
      bool = false;
    }
  }
  
  public Object parseArrayWithType(Type paramType)
  {
    if (this.lexer.token() == 8)
    {
      this.lexer.nextToken();
      paramType = null;
    }
    for (;;)
    {
      return paramType;
      Object localObject1 = ((ParameterizedType)paramType).getActualTypeArguments();
      if (localObject1.length != 1) {
        throw new JSONException("not support type " + paramType);
      }
      localObject1 = localObject1[0];
      if ((localObject1 instanceof Class))
      {
        paramType = new ArrayList();
        parseArray((Class)localObject1, paramType);
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof WildcardType))
        {
          localObject2 = (WildcardType)localObject1;
          localObject1 = localObject2.getUpperBounds()[0];
          if (Object.class.equals(localObject1))
          {
            if (((WildcardType)localObject2).getLowerBounds().length == 0) {
              paramType = parse();
            } else {
              throw new JSONException("not support type : " + paramType);
            }
          }
          else
          {
            paramType = new ArrayList();
            parseArray((Class)localObject1, paramType);
          }
        }
        else
        {
          if ((localObject1 instanceof TypeVariable))
          {
            localObject2 = (TypeVariable)localObject1;
            Type[] arrayOfType = ((TypeVariable)localObject2).getBounds();
            if (arrayOfType.length != 1) {
              throw new JSONException("not support : " + localObject2);
            }
            localObject2 = arrayOfType[0];
            if ((localObject2 instanceof Class))
            {
              paramType = new ArrayList();
              parseArray((Class)localObject2, paramType);
              continue;
            }
          }
          if (!(localObject1 instanceof ParameterizedType)) {
            break;
          }
          localObject1 = (ParameterizedType)localObject1;
          paramType = new ArrayList();
          parseArray((Type)localObject1, paramType);
        }
      }
    }
    throw new JSONException("TODO : " + paramType);
  }
  
  public Object parseKey()
  {
    Object localObject;
    if (this.lexer.token() == 18)
    {
      localObject = this.lexer.stringVal();
      this.lexer.nextToken(16);
    }
    for (;;)
    {
      return localObject;
      localObject = parse(null);
    }
  }
  
  public JSONObject parseObject()
  {
    JSONObject localJSONObject = new JSONObject();
    parseObject(localJSONObject);
    return localJSONObject;
  }
  
  public <T> T parseObject(Class<T> paramClass)
  {
    return (T)parseObject(paramClass);
  }
  
  public <T> T parseObject(Type paramType)
  {
    ObjectDeserializer localObjectDeserializer = null;
    if (this.lexer.token() == 8)
    {
      this.lexer.nextToken();
      paramType = localObjectDeserializer;
    }
    for (;;)
    {
      return paramType;
      localObjectDeserializer = this.config.getDeserializer(paramType);
      try
      {
        paramType = localObjectDeserializer.deserialze(this, paramType, null);
      }
      catch (JSONException paramType)
      {
        throw paramType;
      }
      catch (Throwable paramType)
      {
        throw new JSONException(paramType.getMessage(), paramType);
      }
    }
  }
  
  public Object parseObject(Map paramMap)
  {
    return parseObject(paramMap, null);
  }
  
  public final Object parseObject(Map paramMap, Object paramObject)
  {
    JSONLexer localJSONLexer = this.lexer;
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new JSONException("syntax error, expect {, actual " + localJSONLexer.tokenName());
    }
    ParseContext localParseContext = getContext();
    int i = 0;
    int j;
    int k;
    Object localObject2;
    Object localObject1;
    try
    {
      localJSONLexer.skipWhitespace();
      j = localJSONLexer.getCurrent();
      k = j;
      if (isEnabled(Feature.AllowArbitraryCommas)) {
        for (;;)
        {
          k = j;
          if (j != 44) {
            break;
          }
          localJSONLexer.next();
          localJSONLexer.skipWhitespace();
          j = localJSONLexer.getCurrent();
        }
      }
      j = 0;
      if (k == 34)
      {
        localObject2 = localJSONLexer.scanSymbol(this.symbolTable, '"');
        localJSONLexer.skipWhitespace();
        localObject1 = localObject2;
        if (localJSONLexer.getCurrent() == ':') {
          break label577;
        }
        paramObject = new com/alibaba/fastjson/JSONException;
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>("expect ':' at ");
        ((JSONException)paramObject).<init>(localJSONLexer.pos() + ", name " + localObject2);
        throw ((Throwable)paramObject);
      }
    }
    finally
    {
      setContext(localParseContext);
    }
    if (k == 125)
    {
      localJSONLexer.next();
      localJSONLexer.resetStringPosition();
      localJSONLexer.nextToken();
      setContext(localParseContext);
      label276:
      return paramMap;
    }
    if (k == 39)
    {
      if (!isEnabled(Feature.AllowSingleQuotes))
      {
        paramMap = new com/alibaba/fastjson/JSONException;
        paramMap.<init>("syntax error");
        throw paramMap;
      }
      localObject1 = localJSONLexer.scanSymbol(this.symbolTable, '\'');
      localJSONLexer.skipWhitespace();
      if (localJSONLexer.getCurrent() != ':')
      {
        paramObject = new com/alibaba/fastjson/JSONException;
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>("expect ':' at ");
        ((JSONException)paramObject).<init>(localJSONLexer.pos());
        throw ((Throwable)paramObject);
      }
    }
    else
    {
      if (k == 26)
      {
        paramMap = new com/alibaba/fastjson/JSONException;
        paramMap.<init>("syntax error");
        throw paramMap;
      }
      if (k == 44)
      {
        paramMap = new com/alibaba/fastjson/JSONException;
        paramMap.<init>("syntax error");
        throw paramMap;
      }
      if (((k >= 48) && (k <= 57)) || (k == 45))
      {
        localJSONLexer.resetStringPosition();
        localJSONLexer.scanNumber();
        if (localJSONLexer.token() == 2) {}
        for (localObject2 = localJSONLexer.integerValue();; localObject2 = localJSONLexer.decimalValue(true))
        {
          localObject1 = localObject2;
          if (localJSONLexer.getCurrent() == ':') {
            break;
          }
          paramObject = new com/alibaba/fastjson/JSONException;
          paramMap = new java/lang/StringBuilder;
          paramMap.<init>("expect ':' at ");
          ((JSONException)paramObject).<init>(localJSONLexer.pos() + ", name " + localObject2);
          throw ((Throwable)paramObject);
        }
      }
      if ((k != 123) && (k != 91)) {
        break label663;
      }
      localJSONLexer.nextToken();
      localObject1 = parse();
      j = 1;
    }
    label577:
    label663:
    char c;
    do
    {
      if (j == 0)
      {
        localJSONLexer.next();
        localJSONLexer.skipWhitespace();
      }
      j = localJSONLexer.getCurrent();
      localJSONLexer.resetStringPosition();
      if (localObject1 != JSON.DEFAULT_TYPE_KEY) {
        break label949;
      }
      localObject2 = localJSONLexer.scanSymbol(this.symbolTable, '"');
      localObject1 = TypeUtils.loadClass((String)localObject2);
      if (localObject1 != null) {
        break label764;
      }
      paramMap.put(JSON.DEFAULT_TYPE_KEY, localObject2);
      break;
      if (!isEnabled(Feature.AllowUnQuotedFieldNames))
      {
        paramMap = new com/alibaba/fastjson/JSONException;
        paramMap.<init>("syntax error");
        throw paramMap;
      }
      localObject1 = localJSONLexer.scanSymbolUnQuoted(this.symbolTable);
      localJSONLexer.skipWhitespace();
      c = localJSONLexer.getCurrent();
    } while (c == ':');
    paramMap = new com/alibaba/fastjson/JSONException;
    paramObject = new java/lang/StringBuilder;
    ((StringBuilder)paramObject).<init>("expect ':' at ");
    paramMap.<init>(localJSONLexer.pos() + ", actual " + c);
    throw paramMap;
    label764:
    localJSONLexer.nextToken(16);
    if (localJSONLexer.token() == 13) {
      localJSONLexer.nextToken(16);
    }
    for (;;)
    {
      try
      {
        paramMap = this.config.getDeserializer((Type)localObject1);
        if ((paramMap instanceof ASMJavaBeanDeserializer))
        {
          paramObject = ((ASMJavaBeanDeserializer)paramMap).createInstance(this, (Type)localObject1);
          paramMap = (Map)paramObject;
          if (paramObject == null)
          {
            if (localObject1 != Cloneable.class) {
              continue;
            }
            paramMap = new HashMap();
          }
          setContext(localParseContext);
          break label276;
        }
        if (!(paramMap instanceof JavaBeanDeserializer)) {
          break label2029;
        }
        paramObject = ((JavaBeanDeserializer)paramMap).createInstance(this, (Type)localObject1);
        continue;
        paramMap = ((Class)localObject1).newInstance();
        continue;
        setResolveStatus(2);
      }
      catch (Exception paramMap)
      {
        paramObject = new com/alibaba/fastjson/JSONException;
        ((JSONException)paramObject).<init>("create instance error", paramMap);
        throw ((Throwable)paramObject);
      }
      if ((this.context != null) && (!(paramObject instanceof Integer))) {
        popContext();
      }
      paramMap = this.config.getDeserializer((Type)localObject1).deserialze(this, (Type)localObject1, paramObject);
      setContext(localParseContext);
      break label276;
      label949:
      if (localObject1 == "$ref")
      {
        localJSONLexer.nextToken(4);
        if (localJSONLexer.token() == 4)
        {
          localObject1 = localJSONLexer.stringVal();
          localJSONLexer.nextToken(13);
          paramObject = null;
          if ("@".equals(localObject1))
          {
            paramMap = (Map)paramObject;
            if (getContext() != null) {
              paramMap = getContext().getObject();
            }
          }
          while (localJSONLexer.token() != 13)
          {
            paramMap = new com/alibaba/fastjson/JSONException;
            paramMap.<init>("syntax error");
            throw paramMap;
            if ("..".equals(localObject1))
            {
              paramMap = localParseContext.getParentContext();
              if (paramMap.getObject() != null)
              {
                paramMap = paramMap.getObject();
              }
              else
              {
                localObject2 = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
                ((ResolveTask)localObject2).<init>(paramMap, (String)localObject1);
                addResolveTask((ResolveTask)localObject2);
                setResolveStatus(1);
                paramMap = (Map)paramObject;
              }
            }
            else if ("$".equals(localObject1))
            {
              for (paramMap = localParseContext; paramMap.getParentContext() != null; paramMap = paramMap.getParentContext()) {}
              if (paramMap.getObject() != null)
              {
                paramMap = paramMap.getObject();
              }
              else
              {
                localObject2 = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
                ((ResolveTask)localObject2).<init>(paramMap, (String)localObject1);
                addResolveTask((ResolveTask)localObject2);
                setResolveStatus(1);
                paramMap = (Map)paramObject;
              }
            }
            else
            {
              paramMap = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
              paramMap.<init>(localParseContext, (String)localObject1);
              addResolveTask(paramMap);
              setResolveStatus(1);
              paramMap = (Map)paramObject;
            }
          }
          localJSONLexer.nextToken(16);
          setContext(localParseContext);
          break label276;
        }
        paramObject = new com/alibaba/fastjson/JSONException;
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>("illegal ref, ");
        ((JSONException)paramObject).<init>(JSONToken.name(localJSONLexer.token()));
        throw ((Throwable)paramObject);
      }
      if (i == 0)
      {
        setContext(paramMap, paramObject);
        if ((this.context != null) && (!(paramObject instanceof Integer))) {
          popContext();
        }
        i = 1;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (paramMap.getClass() == JSONObject.class) {
          if (localObject1 != null) {
            break label1447;
          }
        }
        Object localObject3;
        label1447:
        for (localObject2 = "null";; localObject2 = localObject1.toString())
        {
          if (j != 34) {
            break label1457;
          }
          localJSONLexer.scanString();
          localObject1 = localJSONLexer.stringVal();
          localObject3 = localObject1;
          if (localJSONLexer.isEnabled(Feature.AllowISO8601DateFormat))
          {
            localObject3 = new com/alibaba/fastjson/parser/JSONScanner;
            ((JSONScanner)localObject3).<init>((String)localObject1);
            if (((JSONScanner)localObject3).scanISO8601DateIfMatch()) {
              localObject1 = ((JSONScanner)localObject3).getCalendar().getTime();
            }
            ((JSONScanner)localObject3).close();
            localObject3 = localObject1;
          }
          paramMap.put(localObject2, localObject3);
          localJSONLexer.skipWhitespace();
          j = localJSONLexer.getCurrent();
          if (j != 44) {
            break label1932;
          }
          localJSONLexer.next();
          break;
        }
        label1457:
        if (((j >= 48) && (j <= 57)) || (j == 45))
        {
          localJSONLexer.scanNumber();
          if (localJSONLexer.token() == 2) {}
          for (localObject1 = localJSONLexer.integerValue();; localObject1 = localJSONLexer.numberValue())
          {
            paramMap.put(localObject2, localObject1);
            break;
          }
        }
        if (j == 91)
        {
          localJSONLexer.nextToken();
          localObject1 = new com/alibaba/fastjson/JSONArray;
          ((JSONArray)localObject1).<init>();
          parseArray((Collection)localObject1, localObject2);
          paramMap.put(localObject2, localObject1);
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken();
            setContext(localParseContext);
            break label276;
          }
          if (localJSONLexer.token() == 16) {
            break label2023;
          }
          paramMap = new com/alibaba/fastjson/JSONException;
          paramMap.<init>("syntax error");
          throw paramMap;
        }
        if (j == 123)
        {
          localJSONLexer.nextToken();
          localObject1 = new com/alibaba/fastjson/JSONObject;
          ((JSONObject)localObject1).<init>();
          localObject1 = parseObject((Map)localObject1, localObject2);
          checkMapResolve(paramMap, localObject2.toString());
          if (paramMap.getClass() == JSONObject.class) {
            paramMap.put(localObject2.toString(), localObject1);
          }
          for (;;)
          {
            setContext(localParseContext, localObject1, localObject2);
            if (localJSONLexer.token() != 13) {
              break label1754;
            }
            localJSONLexer.nextToken();
            setContext(localParseContext);
            setContext(localParseContext);
            break;
            paramMap.put(localObject2, localObject1);
          }
          label1754:
          if (localJSONLexer.token() != 16)
          {
            paramObject = new com/alibaba/fastjson/JSONException;
            paramMap = new java/lang/StringBuilder;
            paramMap.<init>("syntax error, ");
            ((JSONException)paramObject).<init>(localJSONLexer.tokenName());
            throw ((Throwable)paramObject);
          }
        }
        else
        {
          localJSONLexer.nextToken();
          localObject3 = parse();
          localObject1 = localObject2;
          if (paramMap.getClass() == JSONObject.class) {
            localObject1 = localObject2.toString();
          }
          paramMap.put(localObject1, localObject3);
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken();
            setContext(localParseContext);
            break label276;
          }
          if (localJSONLexer.token() != 16)
          {
            paramMap = new com/alibaba/fastjson/JSONException;
            paramObject = new java/lang/StringBuilder;
            ((StringBuilder)paramObject).<init>("syntax error, position at ");
            paramMap.<init>(localJSONLexer.pos() + ", name " + localObject1);
            throw paramMap;
            label1932:
            if (j == 125)
            {
              localJSONLexer.next();
              localJSONLexer.resetStringPosition();
              localJSONLexer.nextToken();
              setContext(paramMap, paramObject);
              setContext(localParseContext);
              break label276;
            }
            paramMap = new com/alibaba/fastjson/JSONException;
            paramObject = new java/lang/StringBuilder;
            ((StringBuilder)paramObject).<init>("syntax error, position at ");
            paramMap.<init>(localJSONLexer.pos() + ", name " + localObject2);
            throw paramMap;
          }
        }
        label2023:
        break;
      }
      label2029:
      paramObject = null;
    }
  }
  
  public void parseObject(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    Map localMap = this.config.getFieldDeserializers(localClass);
    if ((this.lexer.token() != 12) && (this.lexer.token() != 16)) {
      throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
    }
    Object localObject1 = this.lexer.scanSymbol(this.symbolTable);
    if (localObject1 == null) {
      if (this.lexer.token() == 13) {
        this.lexer.nextToken(16);
      }
    }
    label119:
    FieldDeserializer localFieldDeserializer;
    for (;;)
    {
      return;
      if ((this.lexer.token() == 16) && (isEnabled(Feature.AllowArbitraryCommas))) {
        break label338;
      }
      localFieldDeserializer = (FieldDeserializer)localMap.get(localObject1);
      if (localFieldDeserializer != null) {
        break label250;
      }
      if (!isEnabled(Feature.IgnoreNotMatch)) {
        throw new JSONException("setter not found, class " + localClass.getName() + ", property " + (String)localObject1);
      }
      this.lexer.nextTokenWithColon();
      parse();
      if (this.lexer.token() != 13) {
        break;
      }
      this.lexer.nextToken();
    }
    label250:
    Object localObject2 = localFieldDeserializer.getFieldClass();
    localObject1 = localFieldDeserializer.getFieldType();
    if (localObject2 == Integer.TYPE)
    {
      this.lexer.nextTokenWithColon(2);
      localObject1 = IntegerCodec.instance.deserialze(this, (Type)localObject1, null);
    }
    for (;;)
    {
      localFieldDeserializer.setValue(paramObject, localObject1);
      if ((this.lexer.token() == 16) || (this.lexer.token() != 13)) {
        break;
      }
      this.lexer.nextToken(16);
      break label119;
      label338:
      break;
      if (localObject2 == String.class)
      {
        this.lexer.nextTokenWithColon(4);
        localObject1 = StringCodec.deserialze(this);
      }
      else if (localObject2 == Long.TYPE)
      {
        this.lexer.nextTokenWithColon(2);
        localObject1 = LongCodec.instance.deserialze(this, (Type)localObject1, null);
      }
      else
      {
        localObject2 = this.config.getDeserializer((Class)localObject2, (Type)localObject1);
        this.lexer.nextTokenWithColon(((ObjectDeserializer)localObject2).getFastMatchToken());
        localObject1 = ((ObjectDeserializer)localObject2).deserialze(this, (Type)localObject1, null);
      }
    }
  }
  
  public void popContext()
  {
    if (isEnabled(Feature.DisableCircularReferenceDetect)) {}
    for (;;)
    {
      return;
      this.context = this.context.getParentContext();
      this.contextArray[(this.contextArrayIndex - 1)] = null;
      this.contextArrayIndex -= 1;
    }
  }
  
  public void setConfig(ParserConfig paramParserConfig)
  {
    this.config = paramParserConfig;
  }
  
  public ParseContext setContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2)
  {
    if (isEnabled(Feature.DisableCircularReferenceDetect)) {}
    for (paramParseContext = null;; paramParseContext = this.context)
    {
      return paramParseContext;
      this.context = new ParseContext(paramParseContext, paramObject1, paramObject2);
      addContext(this.context);
    }
  }
  
  public ParseContext setContext(Object paramObject1, Object paramObject2)
  {
    if (isEnabled(Feature.DisableCircularReferenceDetect)) {}
    for (paramObject1 = null;; paramObject1 = setContext(this.context, paramObject1, paramObject2)) {
      return (ParseContext)paramObject1;
    }
  }
  
  public void setContext(ParseContext paramParseContext)
  {
    if (isEnabled(Feature.DisableCircularReferenceDetect)) {}
    for (;;)
    {
      return;
      this.context = paramParseContext;
    }
  }
  
  public void setDateFomrat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    this.dateFormat = null;
  }
  
  public void setResolveStatus(int paramInt)
  {
    this.resolveStatus = paramInt;
  }
  
  public static class ResolveTask
  {
    private final ParseContext context;
    private FieldDeserializer fieldDeserializer;
    private ParseContext ownerContext;
    private final String referenceValue;
    
    public ResolveTask(ParseContext paramParseContext, String paramString)
    {
      this.context = paramParseContext;
      this.referenceValue = paramString;
    }
    
    public ParseContext getContext()
    {
      return this.context;
    }
    
    public FieldDeserializer getFieldDeserializer()
    {
      return this.fieldDeserializer;
    }
    
    public ParseContext getOwnerContext()
    {
      return this.ownerContext;
    }
    
    public String getReferenceValue()
    {
      return this.referenceValue;
    }
    
    public void setFieldDeserializer(FieldDeserializer paramFieldDeserializer)
    {
      this.fieldDeserializer = paramFieldDeserializer;
    }
    
    public void setOwnerContext(ParseContext paramParseContext)
    {
      this.ownerContext = paramParseContext;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/DefaultJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */