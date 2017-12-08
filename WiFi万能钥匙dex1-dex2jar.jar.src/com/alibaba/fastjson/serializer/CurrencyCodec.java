package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Currency;

public class CurrencyCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CurrencyCodec instance = new CurrencyCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = (String)paramDefaultJSONParser.parse();
    if ((paramDefaultJSONParser == null) || (paramDefaultJSONParser.length() == 0)) {}
    for (paramDefaultJSONParser = null;; paramDefaultJSONParser = Currency.getInstance(paramDefaultJSONParser)) {
      return paramDefaultJSONParser;
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeString(((Currency)paramObject1).getCurrencyCode());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/CurrencyCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */