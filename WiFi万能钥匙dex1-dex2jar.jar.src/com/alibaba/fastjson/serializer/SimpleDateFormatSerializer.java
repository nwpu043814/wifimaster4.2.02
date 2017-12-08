package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatSerializer
  implements ObjectSerializer
{
  private final String pattern;
  
  public SimpleDateFormatSerializer(String paramString)
  {
    this.pattern = paramString;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {
      paramJSONSerializer.getWriter().writeNull();
    }
    for (;;)
    {
      return;
      paramObject1 = (Date)paramObject1;
      paramJSONSerializer.write(new SimpleDateFormat(this.pattern).format((Date)paramObject1));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/SimpleDateFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */