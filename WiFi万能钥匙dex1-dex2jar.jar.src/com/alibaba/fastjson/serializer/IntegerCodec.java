package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)paramObject).token() == 8)
    {
      ((JSONLexer)paramObject).nextToken(16);
      paramObject = null;
      return (T)paramObject;
    }
    if (((JSONLexer)paramObject).token() == 2)
    {
      int i = ((JSONLexer)paramObject).intValue();
      ((JSONLexer)paramObject).nextToken(16);
      paramDefaultJSONParser = Integer.valueOf(i);
    }
    for (;;)
    {
      paramObject = paramDefaultJSONParser;
      if (paramType != AtomicInteger.class) {
        break;
      }
      paramObject = new AtomicInteger(paramDefaultJSONParser.intValue());
      break;
      if (((JSONLexer)paramObject).token() == 3)
      {
        paramDefaultJSONParser = ((JSONLexer)paramObject).decimalValue();
        ((JSONLexer)paramObject).nextToken(16);
        paramDefaultJSONParser = Integer.valueOf(paramDefaultJSONParser.intValue());
      }
      else
      {
        paramDefaultJSONParser = TypeUtils.castToInt(paramDefaultJSONParser.parse());
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    paramObject1 = (Number)paramObject1;
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
      paramJSONSerializer.writeInt(((Number)paramObject1).intValue());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/IntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */