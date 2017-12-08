package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Locale;

public class LocaleCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final LocaleCodec instance = new LocaleCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = (String)paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      paramDefaultJSONParser = null;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser = paramDefaultJSONParser.split("_");
      if (paramDefaultJSONParser.length == 1) {
        paramDefaultJSONParser = new Locale(paramDefaultJSONParser[0]);
      } else if (paramDefaultJSONParser.length == 2) {
        paramDefaultJSONParser = new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1]);
      } else {
        paramDefaultJSONParser = new Locale(paramDefaultJSONParser[0], paramDefaultJSONParser[1], paramDefaultJSONParser[2]);
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      return;
      paramJSONSerializer.write(((Locale)paramObject1).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/LocaleCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */