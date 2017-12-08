package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public class LongCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static LongCodec instance = new LongCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.getLexer();
    long l;
    if (((JSONLexer)paramObject).token() == 2)
    {
      l = ((JSONLexer)paramObject).longValue();
      ((JSONLexer)paramObject).nextToken(16);
    }
    for (paramObject = Long.valueOf(l);; paramObject = TypeUtils.castToLong(paramDefaultJSONParser))
    {
      paramDefaultJSONParser = (DefaultJSONParser)paramObject;
      if (paramType == AtomicLong.class) {}
      for (paramDefaultJSONParser = new AtomicLong(((Long)paramObject).longValue());; paramDefaultJSONParser = null)
      {
        return paramDefaultJSONParser;
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser != null) {
          break;
        }
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        ((SerializeWriter)paramObject2).write('0');
      }
    }
    for (;;)
    {
      return;
      ((SerializeWriter)paramObject2).writeNull();
      continue;
      long l = ((Long)paramObject1).longValue();
      ((SerializeWriter)paramObject2).writeLong(l);
      if ((paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) && (l <= 2147483647L) && (l >= -2147483648L) && (paramType != Long.class)) {
        ((SerializeWriter)paramObject2).write('L');
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/LongCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */