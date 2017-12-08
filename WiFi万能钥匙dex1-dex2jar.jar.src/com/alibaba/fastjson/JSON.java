package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.ThreadLocalCache;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class JSON
  implements JSONAware, JSONStreamAware
{
  public static int DEFAULT_GENERATE_FEATURE = SerializerFeature.QuoteFieldNames.getMask() | 0x0 | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingToString.getMask() | SerializerFeature.SortField.getMask();
  public static int DEFAULT_PARSER_FEATURE = 0;
  public static String DEFAULT_TYPE_KEY = "@type";
  public static String DEFFAULT_DATE_FORMAT;
  public static final String VERSION = "1.1.37";
  
  static
  {
    DEFAULT_PARSER_FEATURE = Feature.AutoCloseSource.getMask() | 0x0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
    DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  }
  
  public static void handleResovleTask(DefaultJSONParser paramDefaultJSONParser, Object paramObject)
  {
    List localList = paramDefaultJSONParser.getResolveTaskListDirect();
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = 0;
    label22:
    FieldDeserializer localFieldDeserializer;
    String str;
    if (i < j)
    {
      localObject = (DefaultJSONParser.ResolveTask)localList.get(i);
      localFieldDeserializer = ((DefaultJSONParser.ResolveTask)localObject).getFieldDeserializer();
      if (localFieldDeserializer != null)
      {
        paramObject = null;
        if (((DefaultJSONParser.ResolveTask)localObject).getOwnerContext() != null) {
          paramObject = ((DefaultJSONParser.ResolveTask)localObject).getOwnerContext().getObject();
        }
        str = ((DefaultJSONParser.ResolveTask)localObject).getReferenceValue();
        if (!str.startsWith("$")) {
          break label110;
        }
      }
    }
    label110:
    for (Object localObject = paramDefaultJSONParser.getObject(str);; localObject = ((DefaultJSONParser.ResolveTask)localObject).getContext().getObject())
    {
      localFieldDeserializer.setValue(paramObject, localObject);
      i++;
      break label22;
      break;
    }
  }
  
  public static final Object parse(String paramString)
  {
    return parse(paramString, DEFAULT_PARSER_FEATURE);
  }
  
  public static final Object parse(String paramString, int paramInt)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      DefaultJSONParser localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), paramInt);
      paramString = localDefaultJSONParser.parse();
      handleResovleTask(localDefaultJSONParser, paramString);
      localDefaultJSONParser.close();
    }
  }
  
  public static final Object parse(String paramString, Feature... paramVarArgs)
  {
    int i = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    for (int j = 0; j < k; j++) {
      i = Feature.config(i, paramVarArgs[j], true);
    }
    return parse(paramString, i);
  }
  
  public static final Object parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, int paramInt3)
  {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = ThreadLocalCache.getChars((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, localByteBuffer, paramArrayOfByte);
    paramCharsetDecoder = new DefaultJSONParser(arrayOfChar, paramArrayOfByte.position(), ParserConfig.getGlobalInstance(), paramInt3);
    paramArrayOfByte = paramCharsetDecoder.parse();
    handleResovleTask(paramCharsetDecoder, paramArrayOfByte);
    paramCharsetDecoder.close();
    return paramArrayOfByte;
  }
  
  public static final Object parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Feature... paramVarArgs)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    int i;
    for (paramArrayOfByte = null;; paramArrayOfByte = parse(paramArrayOfByte, paramInt1, paramInt2, paramCharsetDecoder, i))
    {
      return paramArrayOfByte;
      i = DEFAULT_PARSER_FEATURE;
      int k = paramVarArgs.length;
      for (int j = 0; j < k; j++) {
        i = Feature.config(i, paramVarArgs[j], true);
      }
    }
  }
  
  public static final Object parse(byte[] paramArrayOfByte, Feature... paramVarArgs)
  {
    return parse(paramArrayOfByte, 0, paramArrayOfByte.length, ThreadLocalCache.getUTF8Decoder(), paramVarArgs);
  }
  
  public static final JSONArray parseArray(String paramString)
  {
    Object localObject = null;
    DefaultJSONParser localDefaultJSONParser = null;
    if (paramString == null)
    {
      paramString = localDefaultJSONParser;
      return paramString;
    }
    localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer localJSONLexer = localDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      paramString = (String)localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      break;
      paramString = (String)localObject;
      if (localJSONLexer.token() != 20)
      {
        paramString = new JSONArray();
        localDefaultJSONParser.parseArray(paramString);
        handleResovleTask(localDefaultJSONParser, paramString);
      }
    }
  }
  
  public static final <T> List<T> parseArray(String paramString, Class<T> paramClass)
  {
    Object localObject = null;
    DefaultJSONParser localDefaultJSONParser = null;
    if (paramString == null)
    {
      paramString = localDefaultJSONParser;
      return paramString;
    }
    localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    paramString = localDefaultJSONParser.getLexer();
    if (paramString.token() == 8)
    {
      paramString.nextToken();
      paramString = (String)localObject;
    }
    for (;;)
    {
      localDefaultJSONParser.close();
      break;
      paramString = new ArrayList();
      localDefaultJSONParser.parseArray(paramClass, paramString);
      handleResovleTask(localDefaultJSONParser, paramString);
    }
  }
  
  public static final List<Object> parseArray(String paramString, Type[] paramArrayOfType)
  {
    Object localObject = null;
    DefaultJSONParser localDefaultJSONParser = null;
    if (paramString == null)
    {
      paramString = localDefaultJSONParser;
      return paramString;
    }
    localDefaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    paramString = localDefaultJSONParser.parseArray(paramArrayOfType);
    if (paramString == null) {}
    for (paramString = (String)localObject;; paramString = Arrays.asList(paramString))
    {
      handleResovleTask(localDefaultJSONParser, paramString);
      localDefaultJSONParser.close();
      break;
    }
  }
  
  public static final JSONObject parseObject(String paramString)
  {
    paramString = parse(paramString);
    if ((paramString instanceof JSONObject)) {}
    for (paramString = (JSONObject)paramString;; paramString = (JSONObject)toJSON(paramString)) {
      return paramString;
    }
  }
  
  public static final JSONObject parseObject(String paramString, Feature... paramVarArgs)
  {
    return (JSONObject)parse(paramString, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, TypeReference<T> paramTypeReference, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramTypeReference.getType(), ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass)
  {
    return (T)parseObject(paramString, paramClass, new Feature[0]);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramClass, ParserConfig.getGlobalInstance(), paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Class<T> paramClass, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramClass, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      int k = paramVarArgs.length;
      int j = 0;
      int i = paramInt;
      for (paramInt = j; paramInt < k; paramInt++) {
        i = Feature.config(i, paramVarArgs[paramInt], true);
      }
      paramVarArgs = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), i);
      paramString = paramVarArgs.parseObject(paramType);
      handleResovleTask(paramVarArgs, paramString);
      paramVarArgs.close();
    }
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, int paramInt, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, paramParserConfig, null, paramInt, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, ParseProcess paramParseProcess, int paramInt, Feature... paramVarArgs)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      int k = paramVarArgs.length;
      int j = 0;
      int i = paramInt;
      for (paramInt = j; paramInt < k; paramInt++) {
        i = Feature.config(i, paramVarArgs[paramInt], true);
      }
      paramParserConfig = new DefaultJSONParser(paramString, paramParserConfig, i);
      if ((paramParseProcess instanceof ExtraTypeProvider)) {
        paramParserConfig.getExtraTypeProviders().add((ExtraTypeProvider)paramParseProcess);
      }
      if ((paramParseProcess instanceof ExtraProcessor)) {
        paramParserConfig.getExtraProcessors().add((ExtraProcessor)paramParseProcess);
      }
      paramString = paramParserConfig.parseObject(paramType);
      handleResovleTask(paramParserConfig, paramString);
      paramParserConfig.close();
    }
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, ParseProcess paramParseProcess, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(String paramString, Type paramType, Feature... paramVarArgs)
  {
    return (T)parseObject(paramString, paramType, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static final <T> T parseObject(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Type paramType, Feature... paramVarArgs)
  {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = ThreadLocalCache.getChars((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    CharBuffer localCharBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, paramArrayOfByte, localCharBuffer);
    return (T)parseObject(arrayOfChar, localCharBuffer.position(), paramType, paramVarArgs);
  }
  
  public static final <T> T parseObject(byte[] paramArrayOfByte, Type paramType, Feature... paramVarArgs)
  {
    return (T)parseObject(paramArrayOfByte, 0, paramArrayOfByte.length, ThreadLocalCache.getUTF8Decoder(), paramType, paramVarArgs);
  }
  
  public static final <T> T parseObject(char[] paramArrayOfChar, int paramInt, Type paramType, Feature... paramVarArgs)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      paramArrayOfChar = null;
    }
    for (;;)
    {
      return paramArrayOfChar;
      int j = DEFAULT_PARSER_FEATURE;
      int k = paramVarArgs.length;
      for (int i = 0; i < k; i++) {
        j = Feature.config(j, paramVarArgs[i], true);
      }
      paramVarArgs = new DefaultJSONParser(paramArrayOfChar, paramInt, ParserConfig.getGlobalInstance(), j);
      paramArrayOfChar = paramVarArgs.parseObject(paramType);
      handleResovleTask(paramVarArgs, paramArrayOfChar);
      paramVarArgs.close();
    }
  }
  
  public static final Object toJSON(Object paramObject)
  {
    return toJSON(paramObject, ParserConfig.getGlobalInstance());
  }
  
  public static final Object toJSON(Object paramObject, ParserConfig paramParserConfig)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      if ((paramObject instanceof JSON))
      {
        localObject1 = (JSON)paramObject;
        continue;
      }
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        localObject1 = new JSONObject(((Map)paramObject).size());
        paramParserConfig = ((Map)paramObject).entrySet().iterator();
        while (paramParserConfig.hasNext())
        {
          paramObject = (Map.Entry)paramParserConfig.next();
          ((JSONObject)localObject1).put(TypeUtils.castToString(((Map.Entry)paramObject).getKey()), toJSON(((Map.Entry)paramObject).getValue()));
        }
        continue;
      }
      if ((paramObject instanceof Collection))
      {
        paramObject = (Collection)paramObject;
        localObject1 = new JSONArray(((Collection)paramObject).size());
        paramObject = ((Collection)paramObject).iterator();
        while (((Iterator)paramObject).hasNext()) {
          ((JSONArray)localObject1).add(toJSON(((Iterator)paramObject).next()));
        }
        continue;
      }
      Object localObject2 = paramObject.getClass();
      if (((Class)localObject2).isEnum())
      {
        localObject1 = ((Enum)paramObject).name();
        continue;
      }
      if (((Class)localObject2).isArray())
      {
        int j = Array.getLength(paramObject);
        localObject1 = new JSONArray(j);
        for (int i = 0; i < j; i++) {
          ((JSONArray)localObject1).add(toJSON(Array.get(paramObject, i)));
        }
        continue;
      }
      localObject1 = paramObject;
      if (paramParserConfig.isPrimitive((Class)localObject2)) {
        continue;
      }
      try
      {
        paramParserConfig = TypeUtils.computeGetters((Class)localObject2, null);
        localObject1 = new com/alibaba/fastjson/JSONObject;
        ((JSONObject)localObject1).<init>(paramParserConfig.size());
        paramParserConfig = paramParserConfig.iterator();
        while (paramParserConfig.hasNext())
        {
          FieldInfo localFieldInfo = (FieldInfo)paramParserConfig.next();
          localObject2 = toJSON(localFieldInfo.get(paramObject));
          ((JSONObject)localObject1).put(localFieldInfo.getName(), localObject2);
        }
      }
      catch (Exception paramObject)
      {
        throw new JSONException("toJSON error", (Throwable)paramObject);
      }
    }
  }
  
  public static final byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter, paramSerializeConfig);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toBytes("UTF-8");
      return (byte[])paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final byte[] toJSONBytes(Object paramObject, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toBytes("UTF-8");
      return (byte[])paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final String toJSONString(Object paramObject)
  {
    return toJSONString(paramObject, new SerializerFeature[0]);
  }
  
  public static final String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter, paramSerializeConfig);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toString();
      return (String)paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final String toJSONString(Object paramObject, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
      if (paramSerializeFilter != null)
      {
        if ((paramSerializeFilter instanceof PropertyPreFilter)) {
          localJSONSerializer.getPropertyPreFilters().add((PropertyPreFilter)paramSerializeFilter);
        }
        if ((paramSerializeFilter instanceof NameFilter)) {
          localJSONSerializer.getNameFilters().add((NameFilter)paramSerializeFilter);
        }
        if ((paramSerializeFilter instanceof ValueFilter)) {
          localJSONSerializer.getValueFilters().add((ValueFilter)paramSerializeFilter);
        }
        if ((paramSerializeFilter instanceof PropertyFilter)) {
          localJSONSerializer.getPropertyFilters().add((PropertyFilter)paramSerializeFilter);
        }
        if ((paramSerializeFilter instanceof BeforeFilter)) {
          localJSONSerializer.getBeforeFilters().add((BeforeFilter)paramSerializeFilter);
        }
        if ((paramSerializeFilter instanceof AfterFilter)) {
          localJSONSerializer.getAfterFilters().add((AfterFilter)paramSerializeFilter);
        }
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toString();
      return (String)paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final String toJSONString(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramObject = toJSONString(paramObject);; paramObject = toJSONString(paramObject, new SerializerFeature[] { SerializerFeature.PrettyFormat })) {
      return (String)paramObject;
    }
  }
  
  public static final String toJSONString(Object paramObject, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toString();
      return (String)paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final String toJSONStringWithDateFormat(Object paramObject, String paramString, SerializerFeature... paramVarArgs)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
      if (paramString != null) {
        localJSONSerializer.setDateFormat(paramString);
      }
      localJSONSerializer.write(paramObject);
      paramObject = localSerializeWriter.toString();
      return (String)paramObject;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public static final String toJSONStringZ(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs)
  {
    paramVarArgs = new SerializeWriter(paramVarArgs);
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(paramVarArgs, paramSerializeConfig);
      localJSONSerializer.write(paramObject);
      paramObject = paramVarArgs.toString();
      return (String)paramObject;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  public static final <T> T toJavaObject(JSON paramJSON, Class<T> paramClass)
  {
    return (T)TypeUtils.cast(paramJSON, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static final void writeJSONStringTo(Object paramObject, Writer paramWriter, SerializerFeature... paramVarArgs)
  {
    paramWriter = new SerializeWriter(paramWriter);
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(paramWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        localJSONSerializer.config(paramVarArgs[i], true);
      }
      localJSONSerializer.write(paramObject);
      return;
    }
    finally
    {
      paramWriter.close();
    }
  }
  
  public String toJSONString()
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      Object localObject1 = new com/alibaba/fastjson/serializer/JSONSerializer;
      ((JSONSerializer)localObject1).<init>(localSerializeWriter);
      ((JSONSerializer)localObject1).write(this);
      localObject1 = localSerializeWriter.toString();
      return (String)localObject1;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public String toString()
  {
    return toJSONString();
  }
  
  public void writeJSONString(Appendable paramAppendable)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      localJSONSerializer.write(this);
      paramAppendable.append(localSerializeWriter.toString());
      return;
    }
    catch (IOException localIOException)
    {
      paramAppendable = new com/alibaba/fastjson/JSONException;
      paramAppendable.<init>(localIOException.getMessage(), localIOException);
      throw paramAppendable;
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */