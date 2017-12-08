package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class TimestampDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final TimestampDeserializer instance = new TimestampDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramType = null;
    if (paramObject2 == null) {}
    for (;;)
    {
      return paramType;
      if ((paramObject2 instanceof Date))
      {
        paramType = new Timestamp(((Date)paramObject2).getTime());
      }
      else if ((paramObject2 instanceof Number))
      {
        paramType = new Timestamp(((Number)paramObject2).longValue());
      }
      else
      {
        if (!(paramObject2 instanceof String)) {
          break;
        }
        paramObject1 = (String)paramObject2;
        if (((String)paramObject1).length() != 0)
        {
          paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
          try
          {
            paramDefaultJSONParser = paramDefaultJSONParser.parse((String)paramObject1);
            paramType = new java/sql/Timestamp;
            paramType.<init>(paramDefaultJSONParser.getTime());
          }
          catch (ParseException paramDefaultJSONParser)
          {
            paramType = new Timestamp(Long.parseLong((String)paramObject1));
          }
        }
      }
    }
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/TimestampDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */