package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSeriliazer
  implements ObjectSerializer
{
  public static EnumerationSeriliazer instance = new EnumerationSeriliazer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    int i = 0;
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        localSerializeWriter.write("[]");
      }
      for (;;)
      {
        return;
        localSerializeWriter.writeNull();
      }
    }
    if ((paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) && ((paramType instanceof ParameterizedType))) {}
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = null)
    {
      Enumeration localEnumeration = (Enumeration)paramObject1;
      SerialContext localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
      try
      {
        localSerializeWriter.append('[');
        while (localEnumeration.hasMoreElements())
        {
          paramObject1 = localEnumeration.nextElement();
          int j = i + 1;
          if (i != 0) {
            localSerializeWriter.append(',');
          }
          if (paramObject1 == null)
          {
            localSerializeWriter.writeNull();
            i = j;
          }
          else
          {
            paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(j - 1), paramType);
            i = j;
          }
        }
        localSerializeWriter.append(']');
        paramJSONSerializer.setContext(localSerialContext);
        break;
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/EnumerationSeriliazer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */