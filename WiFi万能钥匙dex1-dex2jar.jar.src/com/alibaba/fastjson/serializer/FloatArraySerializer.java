package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class FloatArraySerializer
  implements ObjectSerializer
{
  public static final FloatArraySerializer instance = new FloatArraySerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        paramJSONSerializer.write("[]");
      }
    }
    int j;
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramObject1 = (float[])paramObject1;
      j = paramObject1.length - 1;
      if (j != -1) {
        break;
      }
      paramJSONSerializer.append("[]");
    }
    paramJSONSerializer.append('[');
    int i = 0;
    if (i < j)
    {
      f = paramObject1[i];
      if (Float.isNaN(f)) {
        paramJSONSerializer.writeNull();
      }
      for (;;)
      {
        paramJSONSerializer.append(',');
        i++;
        break;
        paramJSONSerializer.append(Float.toString(f));
      }
    }
    float f = paramObject1[j];
    if (Float.isNaN(f)) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      paramJSONSerializer.append(']');
      break;
      paramJSONSerializer.append(Float.toString(f));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FloatArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */