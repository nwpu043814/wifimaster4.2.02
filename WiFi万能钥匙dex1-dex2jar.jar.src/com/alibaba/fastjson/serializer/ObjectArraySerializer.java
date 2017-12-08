package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class ObjectArraySerializer
  implements ObjectSerializer
{
  public static final ObjectArraySerializer instance = new ObjectArraySerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    int i = 0;
    paramType = null;
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    Object[] arrayOfObject = (Object[])paramObject1;
    if (paramObject1 == null) {
      if (localSerializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        localSerializeWriter.write("[]");
      }
    }
    int j;
    for (;;)
    {
      return;
      localSerializeWriter.writeNull();
      continue;
      int k = arrayOfObject.length;
      j = k - 1;
      if (j == -1)
      {
        localSerializeWriter.append("[]");
      }
      else
      {
        SerialContext localSerialContext = paramJSONSerializer.getContext();
        paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
        for (;;)
        {
          Object localObject;
          try
          {
            localSerializeWriter.append('[');
            if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat))
            {
              paramJSONSerializer.incrementIndent();
              paramJSONSerializer.println();
              if (i < k)
              {
                if (i != 0)
                {
                  localSerializeWriter.write(',');
                  paramJSONSerializer.println();
                }
                paramJSONSerializer.write(arrayOfObject[i]);
                i++;
                continue;
              }
              paramJSONSerializer.decrementIdent();
              paramJSONSerializer.println();
              localSerializeWriter.write(']');
              paramJSONSerializer.setContext(localSerialContext);
              break;
            }
            i = 0;
            paramObject2 = null;
            paramObject1 = paramType;
            if (i >= j) {
              break label307;
            }
            localObject = arrayOfObject[i];
            if (localObject == null)
            {
              localSerializeWriter.append("null,");
              i++;
              continue;
            }
            if (paramJSONSerializer.containsReference(localObject))
            {
              paramJSONSerializer.writeReference(localObject);
              localSerializeWriter.append(',');
              continue;
            }
            paramType = localObject.getClass();
          }
          finally
          {
            paramJSONSerializer.setContext(localSerialContext);
          }
          if (paramType == paramObject1)
          {
            ((ObjectSerializer)paramObject2).write(paramJSONSerializer, localObject, null, null);
          }
          else
          {
            paramObject2 = paramJSONSerializer.getObjectWriter(paramType);
            ((ObjectSerializer)paramObject2).write(paramJSONSerializer, localObject, null, null);
            paramObject1 = paramType;
          }
        }
        label307:
        paramObject1 = arrayOfObject[j];
        if (paramObject1 != null) {
          break;
        }
        localSerializeWriter.append("null]");
        paramJSONSerializer.setContext(localSerialContext);
      }
    }
    if (paramJSONSerializer.containsReference(paramObject1)) {
      paramJSONSerializer.writeReference(paramObject1);
    }
    for (;;)
    {
      localSerializeWriter.append(']');
      break;
      paramJSONSerializer.writeWithFieldName(paramObject1, Integer.valueOf(j));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ObjectArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */