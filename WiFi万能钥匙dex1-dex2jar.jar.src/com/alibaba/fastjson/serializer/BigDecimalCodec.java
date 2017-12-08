package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser = new BigDecimal(l);
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (localJSONLexer.token() == 3)
      {
        paramDefaultJSONParser = localJSONLexer.decimalValue();
        localJSONLexer.nextToken(16);
      }
      else
      {
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser == null) {
          paramDefaultJSONParser = null;
        } else {
          paramDefaultJSONParser = TypeUtils.castToBigDecimal(paramDefaultJSONParser);
        }
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
      paramObject1 = (BigDecimal)paramObject1;
      paramJSONSerializer.write(((BigDecimal)paramObject1).toString());
      if ((paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) && (paramType != BigDecimal.class) && (((BigDecimal)paramObject1).scale() == 0)) {
        paramJSONSerializer.write('.');
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/BigDecimalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */