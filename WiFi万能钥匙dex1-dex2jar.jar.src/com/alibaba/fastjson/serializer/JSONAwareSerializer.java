package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import java.lang.reflect.Type;

public class JSONAwareSerializer
  implements ObjectSerializer
{
  public static JSONAwareSerializer instance = new JSONAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer.getWriter().write(((JSONAware)paramObject1).toJSONString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONAwareSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */