package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ArraySerializer
  implements ObjectSerializer
{
  private final ObjectSerializer compObjectSerializer;
  private final Class<?> componentType;
  
  public ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer)
  {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        localSerializeWriter.write("[]");
      }
    }
    for (;;)
    {
      return;
      localSerializeWriter.writeNull();
      continue;
      Object[] arrayOfObject = (Object[])paramObject1;
      int j = arrayOfObject.length;
      paramType = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(paramType, paramObject1, paramObject2);
      for (;;)
      {
        try
        {
          localSerializeWriter.append('[');
          int i = 0;
          if (i >= j) {
            break;
          }
          if (i != 0) {
            localSerializeWriter.append(',');
          }
          paramObject1 = arrayOfObject[i];
          if (paramObject1 == null)
          {
            localSerializeWriter.append("null");
            i++;
          }
          else if (paramObject1.getClass() == this.componentType)
          {
            this.compObjectSerializer.write(paramJSONSerializer, paramObject1, Integer.valueOf(i), null);
          }
          else
          {
            paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(i), null);
          }
        }
        finally
        {
          paramJSONSerializer.setContext(paramType);
        }
      }
      localSerializeWriter.append(']');
      paramJSONSerializer.setContext(paramType);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */