package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public class DateFormatDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final DateFormatDeserializer instance = new DateFormatDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramDefaultJSONParser = null;
    if (paramObject2 == null) {}
    for (;;)
    {
      return paramDefaultJSONParser;
      if (!(paramObject2 instanceof String)) {
        break;
      }
      paramType = (String)paramObject2;
      if (paramType.length() != 0) {
        paramDefaultJSONParser = new SimpleDateFormat(paramType);
      }
    }
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/DateFormatDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */