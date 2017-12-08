package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;
import java.util.Calendar;

public class TimeDeserializer
  implements ObjectDeserializer
{
  public static final TimeDeserializer instance = new TimeDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = paramDefaultJSONParser.getLexer();
    if (paramType.token() == 16)
    {
      paramType.nextToken(4);
      if (paramType.token() != 4) {
        throw new JSONException("syntax error");
      }
      paramType.nextTokenWithColon(2);
      if (paramType.token() != 2) {
        throw new JSONException("syntax error");
      }
      l = paramType.longValue();
      paramType.nextToken(13);
      if (paramType.token() != 13) {
        throw new JSONException("syntax error");
      }
      paramType.nextToken(16);
      paramDefaultJSONParser = new Time(l);
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramType = paramDefaultJSONParser.parse();
      if (paramType == null)
      {
        paramDefaultJSONParser = null;
      }
      else
      {
        paramDefaultJSONParser = paramType;
        if (!(paramType instanceof Time)) {
          if ((paramType instanceof Number))
          {
            paramDefaultJSONParser = new Time(((Number)paramType).longValue());
          }
          else
          {
            if (!(paramType instanceof String)) {
              break label250;
            }
            paramType = (String)paramType;
            if (paramType.length() != 0) {
              break;
            }
            paramDefaultJSONParser = null;
          }
        }
      }
    }
    paramDefaultJSONParser = new JSONScanner(paramType);
    if (paramDefaultJSONParser.scanISO8601DateIfMatch()) {}
    for (long l = paramDefaultJSONParser.getCalendar().getTimeInMillis();; l = Long.parseLong(paramType))
    {
      paramDefaultJSONParser.close();
      paramDefaultJSONParser = new Time(l);
      break;
    }
    label250:
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/TimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */