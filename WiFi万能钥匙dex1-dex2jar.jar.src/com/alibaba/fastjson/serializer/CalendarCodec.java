package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

public class CalendarCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final CalendarCodec instance = new CalendarCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = (Date)DateDeserializer.instance.deserialze(paramDefaultJSONParser, paramType, paramObject);
    paramDefaultJSONParser = Calendar.getInstance();
    paramDefaultJSONParser.setTime(paramType);
    return paramDefaultJSONParser;
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.write(((Calendar)paramObject1).getTime());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/CalendarCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */