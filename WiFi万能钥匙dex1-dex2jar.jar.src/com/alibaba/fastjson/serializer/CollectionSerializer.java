package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionSerializer
  implements ObjectSerializer
{
  public static final CollectionSerializer instance = new CollectionSerializer();
  
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
      Object localObject = (Collection)paramObject1;
      SerialContext localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName))
      {
        if (HashSet.class != localObject.getClass()) {
          break label187;
        }
        localSerializeWriter.append("Set");
      }
      for (;;)
      {
        int j;
        try
        {
          localSerializeWriter.append('[');
          paramObject1 = ((Collection)localObject).iterator();
          if (((Iterator)paramObject1).hasNext())
          {
            paramObject2 = ((Iterator)paramObject1).next();
            j = i + 1;
            if (i != 0) {
              localSerializeWriter.append(',');
            }
            if (paramObject2 == null)
            {
              localSerializeWriter.writeNull();
              i = j;
              continue;
              label187:
              if (TreeSet.class != localObject.getClass()) {
                continue;
              }
              localSerializeWriter.append("TreeSet");
              continue;
            }
            localObject = paramObject2.getClass();
            if (localObject == Integer.class)
            {
              localSerializeWriter.writeInt(((Integer)paramObject2).intValue());
              i = j;
              continue;
            }
            if (localObject == Long.class)
            {
              localSerializeWriter.writeLong(((Long)paramObject2).longValue());
              if (localSerializeWriter.isEnabled(SerializerFeature.WriteClassName))
              {
                localSerializeWriter.write('L');
                i = j;
              }
            }
            else
            {
              paramJSONSerializer.getObjectWriter((Class)localObject).write(paramJSONSerializer, paramObject2, Integer.valueOf(j - 1), paramType);
              i = j;
              continue;
            }
          }
          else
          {
            localSerializeWriter.append(']');
            paramJSONSerializer.setContext(localSerialContext);
            break;
          }
        }
        finally
        {
          paramJSONSerializer.setContext(localSerialContext);
        }
        i = j;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/CollectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */