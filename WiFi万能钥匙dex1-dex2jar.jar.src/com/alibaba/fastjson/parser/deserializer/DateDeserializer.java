package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final DateDeserializer instance = new DateDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      paramType = null;
    }
    for (;;)
    {
      return paramType;
      paramType = (Type)paramObject2;
      if (!(paramObject2 instanceof Date)) {
        if ((paramObject2 instanceof Number))
        {
          paramType = new Date(((Number)paramObject2).longValue());
        }
        else
        {
          if (!(paramObject2 instanceof String)) {
            break;
          }
          paramObject1 = (String)paramObject2;
          if (((String)paramObject1).length() == 0)
          {
            paramType = null;
          }
          else
          {
            paramObject2 = new JSONScanner((String)paramObject1);
            try
            {
              if (((JSONScanner)paramObject2).scanISO8601DateIfMatch(false))
              {
                paramType = ((JSONScanner)paramObject2).getCalendar().getTime();
                ((JSONScanner)paramObject2).close();
              }
              else
              {
                ((JSONScanner)paramObject2).close();
                paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
              }
            }
            finally
            {
              try
              {
                paramType = paramDefaultJSONParser.parse((String)paramObject1);
              }
              catch (ParseException paramDefaultJSONParser)
              {
                paramType = new Date(Long.parseLong((String)paramObject1));
              }
              paramDefaultJSONParser = finally;
              ((JSONScanner)paramObject2).close();
              throw paramDefaultJSONParser;
            }
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/DateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */