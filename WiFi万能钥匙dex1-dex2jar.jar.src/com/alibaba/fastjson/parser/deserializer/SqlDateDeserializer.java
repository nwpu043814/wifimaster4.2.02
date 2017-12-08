package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class SqlDateDeserializer
  extends AbstractDateDeserializer
  implements ObjectDeserializer
{
  public static final SqlDateDeserializer instance = new SqlDateDeserializer();
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2)
  {
    paramType = null;
    if (paramObject2 == null) {}
    for (;;)
    {
      return paramType;
      if ((paramObject2 instanceof java.util.Date))
      {
        paramType = new java.sql.Date(((java.util.Date)paramObject2).getTime());
        continue;
      }
      if ((paramObject2 instanceof Number))
      {
        paramType = new java.sql.Date(((Number)paramObject2).longValue());
        continue;
      }
      if ((paramObject2 instanceof String))
      {
        paramObject1 = (String)paramObject2;
        if (((String)paramObject1).length() == 0) {
          continue;
        }
        paramObject2 = new JSONScanner((String)paramObject1);
        try
        {
          long l;
          if (((JSONScanner)paramObject2).scanISO8601DateIfMatch()) {
            l = ((JSONScanner)paramObject2).getCalendar().getTimeInMillis();
          }
          for (;;)
          {
            ((JSONScanner)paramObject2).close();
            paramType = new java.sql.Date(l);
            break;
            paramDefaultJSONParser = paramDefaultJSONParser.getDateFormat();
            try
            {
              paramType = new java.sql.Date(paramDefaultJSONParser.parse((String)paramObject1).getTime());
            }
            catch (ParseException paramDefaultJSONParser)
            {
              l = Long.parseLong((String)paramObject1);
            }
          }
          throw new JSONException("parse error : " + paramObject2);
        }
        finally
        {
          ((JSONScanner)paramObject2).close();
        }
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/SqlDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */