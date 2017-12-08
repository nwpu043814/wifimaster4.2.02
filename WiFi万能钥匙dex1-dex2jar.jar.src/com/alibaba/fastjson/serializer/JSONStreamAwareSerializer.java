package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONStreamAware;
import java.lang.reflect.Type;

public class JSONStreamAwareSerializer
  implements ObjectSerializer
{
  public static JSONStreamAwareSerializer instance = new JSONStreamAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    ((JSONStreamAware)paramObject1).writeJSONString(paramJSONSerializer);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONStreamAwareSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */