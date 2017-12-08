package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Type;
import java.util.Date;

public class JSONLibDataFormatSerializer
  implements ObjectSerializer
{
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {
      paramJSONSerializer.getWriter().writeNull();
    }
    for (;;)
    {
      return;
      paramObject2 = (Date)paramObject1;
      paramObject1 = new JSONObject();
      ((JSONObject)paramObject1).put("date", Integer.valueOf(((Date)paramObject2).getDate()));
      ((JSONObject)paramObject1).put("day", Integer.valueOf(((Date)paramObject2).getDay()));
      ((JSONObject)paramObject1).put("hours", Integer.valueOf(((Date)paramObject2).getHours()));
      ((JSONObject)paramObject1).put("minutes", Integer.valueOf(((Date)paramObject2).getMinutes()));
      ((JSONObject)paramObject1).put("month", Integer.valueOf(((Date)paramObject2).getMonth()));
      ((JSONObject)paramObject1).put("seconds", Integer.valueOf(((Date)paramObject2).getSeconds()));
      ((JSONObject)paramObject1).put("time", Long.valueOf(((Date)paramObject2).getTime()));
      ((JSONObject)paramObject1).put("timezoneOffset", Integer.valueOf(((Date)paramObject2).getTimezoneOffset()));
      ((JSONObject)paramObject1).put("year", Integer.valueOf(((Date)paramObject2).getYear()));
      paramJSONSerializer.write(paramObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONLibDataFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */