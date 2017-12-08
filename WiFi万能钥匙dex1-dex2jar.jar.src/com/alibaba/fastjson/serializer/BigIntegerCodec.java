package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigIntegerCodec instance = new BigIntegerCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser = new BigInteger(paramDefaultJSONParser);
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser = paramDefaultJSONParser.parse();
      if (paramDefaultJSONParser == null) {
        paramDefaultJSONParser = null;
      } else {
        paramDefaultJSONParser = TypeUtils.castToBigInteger(paramDefaultJSONParser);
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramJSONSerializer.write('0');
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramJSONSerializer.write(((BigInteger)paramObject1).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/BigIntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */