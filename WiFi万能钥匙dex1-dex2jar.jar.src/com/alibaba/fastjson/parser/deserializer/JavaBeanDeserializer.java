package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FilterUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaBeanDeserializer
  implements ObjectDeserializer
{
  private DeserializeBeanInfo beanInfo;
  private final Class<?> clazz;
  private final Map<String, FieldDeserializer> feildDeserializerMap = new IdentityHashMap();
  private final List<FieldDeserializer> fieldDeserializers = new ArrayList();
  private final List<FieldDeserializer> sortedFieldDeserializers = new ArrayList();
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    this(paramParserConfig, paramClass, paramClass);
  }
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType)
  {
    this.clazz = paramClass;
    this.beanInfo = DeserializeBeanInfo.computeSetters(paramClass, paramType);
    paramType = this.beanInfo.getFieldList().iterator();
    while (paramType.hasNext()) {
      addFieldDeserializer(paramParserConfig, paramClass, (FieldInfo)paramType.next());
    }
    paramParserConfig = this.beanInfo.getSortedFieldList().iterator();
    while (paramParserConfig.hasNext())
    {
      paramClass = (FieldInfo)paramParserConfig.next();
      paramClass = (FieldDeserializer)this.feildDeserializerMap.get(paramClass.getName().intern());
      this.sortedFieldDeserializers.add(paramClass);
    }
  }
  
  private void addFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    String str = paramFieldInfo.getName().intern();
    paramParserConfig = createFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    this.feildDeserializerMap.put(str, paramParserConfig);
    this.fieldDeserializers.add(paramParserConfig);
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    return paramParserConfig.createFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
  }
  
  /* Error */
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 121
    //   4: ifeq +49 -> 53
    //   7: aload_0
    //   8: getfield 43	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   11: invokevirtual 124	java/lang/Class:isInterface	()Z
    //   14: ifeq +39 -> 53
    //   17: aload_2
    //   18: checkcast 121	java/lang/Class
    //   21: astore_3
    //   22: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 134	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   28: astore_2
    //   29: new 136	com/alibaba/fastjson/JSONObject
    //   32: dup
    //   33: invokespecial 137	com/alibaba/fastjson/JSONObject:<init>	()V
    //   36: astore_1
    //   37: aload_2
    //   38: iconst_1
    //   39: anewarray 121	java/lang/Class
    //   42: dup
    //   43: iconst_0
    //   44: aload_3
    //   45: aastore
    //   46: aload_1
    //   47: invokestatic 143	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: areturn
    //   53: aload_0
    //   54: getfield 51	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   57: invokevirtual 147	com/alibaba/fastjson/util/DeserializeBeanInfo:getDefaultConstructor	()Ljava/lang/reflect/Constructor;
    //   60: ifnonnull +8 -> 68
    //   63: aconst_null
    //   64: astore_3
    //   65: goto -14 -> 51
    //   68: aload_0
    //   69: getfield 51	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   72: invokevirtual 147	com/alibaba/fastjson/util/DeserializeBeanInfo:getDefaultConstructor	()Ljava/lang/reflect/Constructor;
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 153	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   80: arraylength
    //   81: ifne +109 -> 190
    //   84: aload_2
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokevirtual 157	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_2
    //   93: aload_2
    //   94: astore_3
    //   95: aload_1
    //   96: getstatic 163	com/alibaba/fastjson/parser/Feature:InitStringFieldAsEmpty	Lcom/alibaba/fastjson/parser/Feature;
    //   99: invokevirtual 169	com/alibaba/fastjson/parser/DefaultJSONParser:isEnabled	(Lcom/alibaba/fastjson/parser/Feature;)Z
    //   102: ifeq -51 -> 51
    //   105: aload_0
    //   106: getfield 51	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:beanInfo	Lcom/alibaba/fastjson/util/DeserializeBeanInfo;
    //   109: invokevirtual 55	com/alibaba/fastjson/util/DeserializeBeanInfo:getFieldList	()Ljava/util/List;
    //   112: invokeinterface 61 1 0
    //   117: astore_1
    //   118: aload_2
    //   119: astore_3
    //   120: aload_1
    //   121: invokeinterface 67 1 0
    //   126: ifeq -75 -> 51
    //   129: aload_1
    //   130: invokeinterface 71 1 0
    //   135: checkcast 73	com/alibaba/fastjson/util/FieldInfo
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 173	com/alibaba/fastjson/util/FieldInfo:getFieldClass	()Ljava/lang/Class;
    //   143: ldc 86
    //   145: if_acmpne -27 -> 118
    //   148: aload_3
    //   149: aload_2
    //   150: ldc -81
    //   152: invokevirtual 179	com/alibaba/fastjson/util/FieldInfo:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   155: goto -37 -> 118
    //   158: astore_1
    //   159: new 181	com/alibaba/fastjson/JSONException
    //   162: dup
    //   163: new 183	java/lang/StringBuilder
    //   166: dup
    //   167: ldc -71
    //   169: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 43	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   176: invokevirtual 189	java/lang/Class:getName	()Ljava/lang/String;
    //   179: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: aload_1
    //   186: invokespecial 199	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: athrow
    //   190: aload_2
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: invokevirtual 203	com/alibaba/fastjson/parser/DefaultJSONParser:getContext	()Lcom/alibaba/fastjson/parser/ParseContext;
    //   201: invokevirtual 208	com/alibaba/fastjson/parser/ParseContext:getObject	()Ljava/lang/Object;
    //   204: aastore
    //   205: invokevirtual 157	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   208: astore_2
    //   209: goto -116 -> 93
    //   212: astore_1
    //   213: new 181	com/alibaba/fastjson/JSONException
    //   216: dup
    //   217: new 183	java/lang/StringBuilder
    //   220: dup
    //   221: ldc -71
    //   223: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: getfield 43	com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer:clazz	Ljava/lang/Class;
    //   230: invokevirtual 189	java/lang/Class:getName	()Ljava/lang/String;
    //   233: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: aload_1
    //   240: invokespecial 199	com/alibaba/fastjson/JSONException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	JavaBeanDeserializer
    //   0	244	1	paramDefaultJSONParser	DefaultJSONParser
    //   0	244	2	paramType	Type
    //   21	128	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   148	155	158	java/lang/Exception
    //   68	93	212	java/lang/Exception
    //   190	209	212	java/lang/Exception
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser, paramType, paramObject, null);
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken(16);
      paramType = null;
      return paramType;
    }
    ParseContext localParseContext = paramDefaultJSONParser.getContext();
    if (paramObject2 != null) {
      localParseContext = localParseContext.getParentContext();
    }
    for (;;)
    {
      Object localObject5 = null;
      Object localObject1 = null;
      String str = null;
      Object localObject4 = localObject1;
      Object localObject2 = paramObject2;
      try
      {
        if (localJSONLexer.token() == 13)
        {
          localObject4 = localObject1;
          localObject2 = paramObject2;
          localJSONLexer.nextToken(16);
          paramObject1 = paramObject2;
          if (paramObject2 == null)
          {
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramObject1 = createInstance(paramDefaultJSONParser, paramType);
          }
          paramDefaultJSONParser.setContext(localParseContext);
          paramType = (Type)paramObject1;
          break;
        }
        localObject4 = localObject1;
        localObject2 = paramObject2;
        if (localJSONLexer.token() == 14)
        {
          localObject4 = localObject1;
          localObject2 = paramObject2;
          if (localJSONLexer.isEnabled(Feature.SupportArrayToBean))
          {
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramType = deserialzeArrayMapping(paramDefaultJSONParser, paramType, paramObject1, paramObject2);
            paramDefaultJSONParser.setContext(localParseContext);
            break;
          }
        }
        localObject4 = localObject1;
        localObject2 = paramObject2;
        if (localJSONLexer.token() != 12)
        {
          localObject4 = localObject1;
          localObject2 = paramObject2;
          if (localJSONLexer.token() != 16)
          {
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramType = new java/lang/StringBuffer;
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramType.<init>("syntax error, expect {, actual ");
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramType = paramType.append(localJSONLexer.tokenName()).append(", pos ").append(localJSONLexer.pos());
            localObject4 = localObject1;
            localObject2 = paramObject2;
            if ((paramObject1 instanceof String))
            {
              localObject4 = localObject1;
              localObject2 = paramObject2;
              paramType.append(", fieldName ").append(paramObject1);
            }
            localObject4 = localObject1;
            localObject2 = paramObject2;
            paramObject1 = new com/alibaba/fastjson/JSONException;
            localObject4 = localObject1;
            localObject2 = paramObject2;
            ((JSONException)paramObject1).<init>(paramType.toString());
            localObject4 = localObject1;
            localObject2 = paramObject2;
            throw ((Throwable)paramObject1);
          }
        }
      }
      finally
      {
        paramObject2 = localObject2;
        localObject1 = localObject4;
        label381:
        if (localObject1 != null) {
          ((ParseContext)localObject1).setObject(paramObject2);
        }
        paramDefaultJSONParser.setContext(localParseContext);
      }
      localObject4 = localObject1;
      localObject2 = paramObject2;
      if (paramDefaultJSONParser.getResolveStatus() == 2)
      {
        localObject4 = localObject1;
        localObject2 = paramObject2;
        paramDefaultJSONParser.setResolveStatus(0);
      }
      localObject4 = str;
      localObject1 = localObject5;
      for (;;)
      {
        label438:
        label477:
        label516:
        try
        {
          str = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
          if (str == null) {
            if (localJSONLexer.token() == 13)
            {
              localJSONLexer.nextToken(16);
              if (paramObject2 != null) {
                break label1578;
              }
              if (localObject4 != null) {
                break label1354;
              }
            }
          }
        }
        finally {}
        try
        {
          paramType = createInstance(paramDefaultJSONParser, paramType);
          if (localObject1 != null) {
            break label1584;
          }
          localObject4 = localObject1;
          localObject2 = paramType;
          localObject1 = paramDefaultJSONParser.setContext(localParseContext, paramType, paramObject1);
          if (localObject1 != null) {
            ((ParseContext)localObject1).setObject(paramType);
          }
          paramDefaultJSONParser.setContext(localParseContext);
          break;
        }
        finally {}
        if ((localJSONLexer.token() != 16) || (!paramDefaultJSONParser.isEnabled(Feature.AllowArbitraryCommas)))
        {
          if ("$ref" == str)
          {
            localJSONLexer.nextTokenWithColon(4);
            if (localJSONLexer.token() == 4)
            {
              localObject2 = localJSONLexer.stringVal();
              if ("@".equals(localObject2))
              {
                paramType = localParseContext.getObject();
                localObject4 = localObject1;
                localObject2 = paramType;
                localJSONLexer.nextToken(13);
                localObject4 = localObject1;
                localObject2 = paramType;
                if (localJSONLexer.token() != 13)
                {
                  localObject4 = localObject1;
                  localObject2 = paramType;
                  paramObject1 = new com/alibaba/fastjson/JSONException;
                  localObject4 = localObject1;
                  localObject2 = paramType;
                  ((JSONException)paramObject1).<init>("illegal ref");
                  localObject4 = localObject1;
                  localObject2 = paramType;
                  throw ((Throwable)paramObject1);
                }
              }
              else
              {
                if ("..".equals(localObject2))
                {
                  paramType = localParseContext.getParentContext();
                  if (paramType.getObject() != null)
                  {
                    paramType = paramType.getObject();
                    continue;
                  }
                  localObject4 = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
                  ((DefaultJSONParser.ResolveTask)localObject4).<init>(paramType, (String)localObject2);
                  paramDefaultJSONParser.addResolveTask((DefaultJSONParser.ResolveTask)localObject4);
                  paramDefaultJSONParser.setResolveStatus(1);
                  paramType = (Type)paramObject2;
                  continue;
                }
                if ("$".equals(localObject2))
                {
                  paramType = localParseContext;
                  if (paramType.getParentContext() != null)
                  {
                    paramType = paramType.getParentContext();
                    continue;
                  }
                  if (paramType.getObject() != null)
                  {
                    paramType = paramType.getObject();
                    continue;
                  }
                  localObject4 = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
                  ((DefaultJSONParser.ResolveTask)localObject4).<init>(paramType, (String)localObject2);
                  paramDefaultJSONParser.addResolveTask((DefaultJSONParser.ResolveTask)localObject4);
                  paramDefaultJSONParser.setResolveStatus(1);
                  paramType = (Type)paramObject2;
                  continue;
                }
                paramType = new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;
                paramType.<init>(localParseContext, (String)localObject2);
                paramDefaultJSONParser.addResolveTask(paramType);
                paramDefaultJSONParser.setResolveStatus(1);
                paramType = (Type)paramObject2;
                continue;
              }
            }
            else
            {
              paramObject1 = new com/alibaba/fastjson/JSONException;
              paramType = new java/lang/StringBuilder;
              paramType.<init>("illegal ref, ");
              ((JSONException)paramObject1).<init>(JSONToken.name(localJSONLexer.token()));
              throw ((Throwable)paramObject1);
              break label381;
            }
            localObject4 = localObject1;
            localObject2 = paramType;
            localJSONLexer.nextToken(16);
            localObject4 = localObject1;
            localObject2 = paramType;
            paramDefaultJSONParser.setContext(localParseContext, paramType, paramObject1);
            if (localObject1 != null) {
              ((ParseContext)localObject1).setObject(paramType);
            }
            paramDefaultJSONParser.setContext(localParseContext);
            break;
          }
          if (JSON.DEFAULT_TYPE_KEY != str) {
            break label1084;
          }
          localJSONLexer.nextTokenWithColon(4);
          if (localJSONLexer.token() != 4) {
            break label1071;
          }
          localObject2 = localJSONLexer.stringVal();
          localJSONLexer.nextToken(16);
          if ((!(paramType instanceof Class)) || (!((String)localObject2).equals(((Class)paramType).getName()))) {
            break label1027;
          }
          if (localJSONLexer.token() == 13) {
            localJSONLexer.nextToken();
          }
        }
      }
      label1027:
      paramType = TypeUtils.loadClass((String)localObject2);
      paramType = paramDefaultJSONParser.getConfig().getDeserializer(paramType).deserialze(paramDefaultJSONParser, paramType, paramObject1);
      if (localObject1 != null) {
        ((ParseContext)localObject1).setObject(paramObject2);
      }
      paramDefaultJSONParser.setContext(localParseContext);
      break;
      label1071:
      paramType = new com/alibaba/fastjson/JSONException;
      paramType.<init>("syntax error");
      throw paramType;
      label1084:
      if ((paramObject2 == null) && (localObject4 == null))
      {
        localObject2 = createInstance(paramDefaultJSONParser, paramType);
        paramObject2 = localObject2;
        localObject5 = localObject4;
        if (paramObject2 == null)
        {
          localObject4 = localObject1;
          localObject2 = paramObject2;
          localObject5 = new java/util/HashMap;
          localObject4 = localObject1;
          localObject2 = paramObject2;
          ((HashMap)localObject5).<init>(this.fieldDeserializers.size());
        }
        localObject4 = localObject1;
        localObject2 = paramObject2;
        localObject1 = paramDefaultJSONParser.setContext(localParseContext, paramObject2, paramObject1);
        localObject2 = paramObject2;
        paramObject2 = localObject1;
        localObject4 = localObject5;
      }
      for (;;)
      {
        try
        {
          if (!parseField(paramDefaultJSONParser, str, localObject2, paramType, (Map)localObject4))
          {
            if (localJSONLexer.token() != 13) {
              break label1587;
            }
            localJSONLexer.nextToken();
            localObject1 = paramObject2;
            paramObject2 = localObject2;
            break label477;
          }
          if (localJSONLexer.token() == 16) {
            break label1587;
          }
          if (localJSONLexer.token() == 13)
          {
            localJSONLexer.nextToken(16);
            localObject1 = paramObject2;
            paramObject2 = localObject2;
            break label477;
          }
          if ((localJSONLexer.token() != 18) && (localJSONLexer.token() != 1)) {
            break label1343;
          }
          paramObject1 = new com/alibaba/fastjson/JSONException;
          paramType = new java/lang/StringBuilder;
          paramType.<init>("syntax error, unexpect token ");
          ((JSONException)paramObject1).<init>(JSONToken.name(localJSONLexer.token()));
          throw ((Throwable)paramObject1);
        }
        finally
        {
          localObject1 = paramObject2;
          paramObject2 = localObject2;
        }
        break label381;
        label1343:
        localObject1 = paramObject2;
        paramObject2 = localObject2;
        break label438;
        label1354:
        paramObject1 = this.beanInfo.getFieldList();
        int j = ((List)paramObject1).size();
        paramType = new Object[j];
        for (int i = 0; i < j; i++) {
          paramType[i] = ((Map)localObject4).get(((FieldInfo)((List)paramObject1).get(i)).getName());
        }
        paramObject1 = this.beanInfo.getCreatorConstructor();
        if (paramObject1 != null) {}
        for (;;)
        {
          try
          {
            paramType = this.beanInfo.getCreatorConstructor().newInstance(paramType);
            if (localObject1 != null) {
              ((ParseContext)localObject1).setObject(paramType);
            }
            paramDefaultJSONParser.setContext(localParseContext);
          }
          catch (Exception localException)
          {
            paramObject1 = new com/alibaba/fastjson/JSONException;
            paramType = new java/lang/StringBuilder;
            paramType.<init>("create instance error, ");
            ((JSONException)paramObject1).<init>(this.beanInfo.getCreatorConstructor().toGenericString(), localException);
            throw ((Throwable)paramObject1);
          }
          break label381;
          paramObject1 = this.beanInfo.getFactoryMethod();
          if (paramObject1 != null) {
            try
            {
              paramType = this.beanInfo.getFactoryMethod().invoke(null, paramType);
            }
            catch (Exception paramObject1)
            {
              paramType = new com/alibaba/fastjson/JSONException;
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>("create factory method error, ");
              paramType.<init>(this.beanInfo.getFactoryMethod().toString(), (Throwable)paramObject1);
              throw paramType;
            }
          } else {
            label1578:
            paramType = (Type)paramObject2;
          }
        }
        label1584:
        break label516;
        label1587:
        localObject1 = paramObject2;
        paramObject2 = localObject3;
        break label438;
        Object localObject3 = paramObject2;
        paramObject2 = localObject1;
      }
    }
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramObject1 = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)paramObject1).token() != 14) {
      throw new JSONException("error");
    }
    paramObject2 = createInstance(paramDefaultJSONParser, paramType);
    int j = this.sortedFieldDeserializers.size();
    int i = 0;
    if (i < j)
    {
      char c;
      label69:
      FieldDeserializer localFieldDeserializer;
      if (i == j - 1)
      {
        c = ']';
        localFieldDeserializer = (FieldDeserializer)this.sortedFieldDeserializers.get(i);
        paramType = localFieldDeserializer.getFieldClass();
        if (paramType != Integer.TYPE) {
          break label126;
        }
        localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanInt(c));
      }
      label126:
      label269:
      do
      {
        for (;;)
        {
          i++;
          break;
          c = ',';
          break label69;
          if (paramType == String.class)
          {
            localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanString(c));
          }
          else if (paramType == Long.TYPE)
          {
            localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanLong(c));
          }
          else if (paramType.isEnum())
          {
            localFieldDeserializer.setValue(paramObject2, ((JSONLexer)paramObject1).scanEnum(paramType, paramDefaultJSONParser.getSymbolTable(), c));
          }
          else
          {
            ((JSONLexer)paramObject1).nextToken(14);
            localFieldDeserializer.setValue(paramObject2, paramDefaultJSONParser.parseObject(localFieldDeserializer.getFieldType()));
            if (c != ']') {
              break label269;
            }
            if (((JSONLexer)paramObject1).token() != 15) {
              throw new JSONException("syntax error");
            }
            ((JSONLexer)paramObject1).nextToken(16);
          }
        }
      } while ((c != ',') || (((JSONLexer)paramObject1).token() == 16));
      throw new JSONException("syntax error");
    }
    ((JSONLexer)paramObject1).nextToken(16);
    return (T)paramObject2;
  }
  
  public Class<?> getClazz()
  {
    return this.clazz;
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public Map<String, FieldDeserializer> getFieldDeserializerMap()
  {
    return this.feildDeserializerMap;
  }
  
  void parseExtra(DefaultJSONParser paramDefaultJSONParser, Object paramObject, String paramString)
  {
    Object localObject = paramDefaultJSONParser.getLexer();
    if (!((JSONLexer)localObject).isEnabled(Feature.IgnoreNotMatch)) {
      throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + paramString);
    }
    ((JSONLexer)localObject).nextTokenWithColon();
    localObject = FilterUtils.getExtratype(paramDefaultJSONParser, paramObject, paramString);
    if (localObject == null) {}
    for (localObject = paramDefaultJSONParser.parse();; localObject = paramDefaultJSONParser.parseObject((Type)localObject))
    {
      FilterUtils.processExtra(paramDefaultJSONParser, paramObject, paramString, localObject);
      return;
    }
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    FieldDeserializer localFieldDeserializer = (FieldDeserializer)this.feildDeserializerMap.get(paramString);
    Object localObject = localFieldDeserializer;
    if (localFieldDeserializer == null)
    {
      Iterator localIterator = this.feildDeserializerMap.entrySet().iterator();
      do
      {
        localObject = localFieldDeserializer;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase(paramString));
      localObject = (FieldDeserializer)((Map.Entry)localObject).getValue();
    }
    if (localObject == null) {
      parseExtra(paramDefaultJSONParser, paramObject, paramString);
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      localJSONLexer.nextTokenWithColon(((FieldDeserializer)localObject).getFastMatchToken());
      ((FieldDeserializer)localObject).parseField(paramDefaultJSONParser, paramObject, paramType, paramMap);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */