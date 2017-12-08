package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public final class ListSerializer
  implements ObjectSerializer
{
  public static final ListSerializer instance = new ListSerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    int i = 0;
    boolean bool = paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName);
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if ((bool) && ((paramType instanceof ParameterizedType))) {}
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = null)
    {
      if (paramObject1 == null) {
        if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
          localSerializeWriter.write("[]");
        }
      }
      int j;
      SerialContext localSerialContext;
      Object localObject3;
      for (;;)
      {
        return;
        localSerializeWriter.writeNull();
        continue;
        localObject1 = (List)paramObject1;
        int k = ((List)localObject1).size();
        j = k - 1;
        if (j == -1)
        {
          localSerializeWriter.append("[]");
        }
        else
        {
          localSerialContext = paramJSONSerializer.getContext();
          paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
          if (k <= 1) {
            break;
          }
          for (;;)
          {
            try
            {
              if (!localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                break label313;
              }
              localSerializeWriter.append('[');
              paramJSONSerializer.incrementIndent();
              if (i >= k) {
                break;
              }
              if (i != 0) {
                localSerializeWriter.append(',');
              }
              paramJSONSerializer.println();
              Object localObject4 = ((List)localObject1).get(i);
              if (localObject4 != null)
              {
                if (paramJSONSerializer.containsReference(localObject4))
                {
                  paramJSONSerializer.writeReference(localObject4);
                  i++;
                }
                else
                {
                  localObject3 = paramJSONSerializer.getObjectWriter(localObject4.getClass());
                  localObject2 = new com/alibaba/fastjson/serializer/SerialContext;
                  ((SerialContext)localObject2).<init>(localSerialContext, paramObject1, paramObject2);
                  paramJSONSerializer.setContext((SerialContext)localObject2);
                  ((ObjectSerializer)localObject3).write(paramJSONSerializer, localObject4, Integer.valueOf(i), paramType);
                }
              }
              else {
                paramJSONSerializer.getWriter().writeNull();
              }
            }
            finally
            {
              paramJSONSerializer.setContext(localSerialContext);
            }
          }
          paramJSONSerializer.decrementIdent();
          paramJSONSerializer.println();
          localSerializeWriter.append(']');
          paramJSONSerializer.setContext(localSerialContext);
        }
      }
      label313:
      localSerializeWriter.append('[');
      i = 0;
      if (i < j)
      {
        localObject2 = ((List)localObject1).get(i);
        if (localObject2 == null) {
          localSerializeWriter.append("null,");
        }
        for (;;)
        {
          i++;
          break;
          localObject3 = localObject2.getClass();
          if (localObject3 == Integer.class)
          {
            localSerializeWriter.writeIntAndChar(((Integer)localObject2).intValue(), ',');
          }
          else
          {
            if (localObject3 != Long.class) {
              break label446;
            }
            long l = ((Long)localObject2).longValue();
            if (bool)
            {
              localSerializeWriter.writeLongAndChar(l, 'L');
              localSerializeWriter.write(',');
            }
            else
            {
              localSerializeWriter.writeLongAndChar(l, ',');
            }
          }
        }
        label446:
        localObject3 = new com/alibaba/fastjson/serializer/SerialContext;
        ((SerialContext)localObject3).<init>(localSerialContext, paramObject1, paramObject2);
        paramJSONSerializer.setContext((SerialContext)localObject3);
        if (paramJSONSerializer.containsReference(localObject2)) {
          paramJSONSerializer.writeReference(localObject2);
        }
        for (;;)
        {
          localSerializeWriter.append(',');
          break;
          paramJSONSerializer.getObjectWriter(localObject2.getClass()).write(paramJSONSerializer, localObject2, Integer.valueOf(i), paramType);
        }
      }
      Object localObject1 = ((List)localObject1).get(j);
      if (localObject1 == null) {
        localSerializeWriter.append("null]");
      }
      for (;;)
      {
        paramJSONSerializer.setContext(localSerialContext);
        break;
        localObject2 = localObject1.getClass();
        if (localObject2 == Integer.class)
        {
          localSerializeWriter.writeIntAndChar(((Integer)localObject1).intValue(), ']');
        }
        else
        {
          if (localObject2 != Long.class) {
            break label639;
          }
          if (bool)
          {
            localSerializeWriter.writeLongAndChar(((Long)localObject1).longValue(), 'L');
            localSerializeWriter.write(']');
          }
          else
          {
            localSerializeWriter.writeLongAndChar(((Long)localObject1).longValue(), ']');
          }
        }
      }
      label639:
      Object localObject2 = new com/alibaba/fastjson/serializer/SerialContext;
      ((SerialContext)localObject2).<init>(localSerialContext, paramObject1, paramObject2);
      paramJSONSerializer.setContext((SerialContext)localObject2);
      if (paramJSONSerializer.containsReference(localObject1)) {
        paramJSONSerializer.writeReference(localObject1);
      }
      for (;;)
      {
        localSerializeWriter.append(']');
        break;
        paramJSONSerializer.getObjectWriter(localObject1.getClass()).write(paramJSONSerializer, localObject1, Integer.valueOf(j), paramType);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */