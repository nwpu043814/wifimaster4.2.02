package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSerializer
  implements ObjectSerializer
{
  public static MapSerializer instance = new MapSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull();
      return;
    }
    Object localObject1 = (Map)paramObject1;
    if ((localSerializeWriter.isEnabled(SerializerFeature.SortField)) && (!(localObject1 instanceof SortedMap)) && (!(localObject1 instanceof LinkedHashMap))) {}
    for (;;)
    {
      try
      {
        paramType = new java/util/TreeMap;
        paramType.<init>((Map)localObject1);
        localObject1 = paramType;
        if (!paramJSONSerializer.containsReference(paramObject1)) {
          break label86;
        }
        paramJSONSerializer.writeReference(paramObject1);
      }
      catch (Exception paramType) {}
    }
    label86:
    SerialContext localSerialContext = paramJSONSerializer.getContext();
    paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
    for (;;)
    {
      int i;
      ObjectSerializer localObjectSerializer;
      Object localObject2;
      try
      {
        localSerializeWriter.write('{');
        paramJSONSerializer.incrementIndent();
        if (!localSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
          break label800;
        }
        localSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
        localSerializeWriter.writeString(paramObject1.getClass().getName());
        i = 0;
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        localObjectSerializer = null;
        localObject2 = null;
        if (!localIterator.hasNext()) {
          break label755;
        }
        paramObject2 = (Map.Entry)localIterator.next();
        localObject3 = ((Map.Entry)paramObject2).getValue();
        paramType = ((Map.Entry)paramObject2).getKey();
        paramObject2 = paramJSONSerializer.getPropertyPreFiltersDirect();
        if ((paramObject2 != null) && (((List)paramObject2).size() > 0))
        {
          if ((paramType == null) || ((paramType instanceof String))) {
            if (!FilterUtils.applyName(paramJSONSerializer, paramObject1, (String)paramType)) {
              continue;
            }
          }
        }
        else
        {
          paramObject2 = paramJSONSerializer.getPropertyFiltersDirect();
          if ((paramObject2 != null) && (((List)paramObject2).size() > 0))
          {
            if ((paramType != null) && (!(paramType instanceof String))) {
              continue;
            }
            if (!FilterUtils.apply(paramJSONSerializer, paramObject1, (String)paramType, localObject3)) {
              continue;
            }
          }
          List localList = paramJSONSerializer.getNameFiltersDirect();
          paramObject2 = paramType;
          if (localList != null)
          {
            paramObject2 = paramType;
            if (localList.size() > 0)
            {
              if ((paramType != null) && (!(paramType instanceof String))) {
                continue;
              }
              paramObject2 = FilterUtils.processKey(paramJSONSerializer, paramObject1, (String)paramType, localObject3);
            }
          }
          localList = paramJSONSerializer.getValueFiltersDirect();
          paramType = (Type)localObject3;
          if (localList != null)
          {
            paramType = (Type)localObject3;
            if (localList.size() > 0)
            {
              if ((paramObject2 != null) && (!(paramObject2 instanceof String))) {
                continue;
              }
              paramType = FilterUtils.processValue(paramJSONSerializer, paramObject1, (String)paramObject2, localObject3);
            }
          }
          if ((paramType == null) && (!paramJSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue))) {
            continue;
          }
          if (!(paramObject2 instanceof String)) {
            continue;
          }
          localObject3 = (String)paramObject2;
          if (i == 0) {
            localSerializeWriter.write(',');
          }
          if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
            paramJSONSerializer.println();
          }
          localSerializeWriter.writeFieldName((String)localObject3, true);
          if (paramType != null) {
            break label693;
          }
          localSerializeWriter.writeNull();
          i = 0;
          continue;
        }
        if ((!paramType.getClass().isPrimitive()) && (!(paramType instanceof Number))) {
          continue;
        }
        if (!FilterUtils.applyName(paramJSONSerializer, paramObject1, JSON.toJSONString(paramType))) {
          continue;
        }
        continue;
        if ((!paramType.getClass().isPrimitive()) && (!(paramType instanceof Number))) {
          continue;
        }
        if (!FilterUtils.apply(paramJSONSerializer, paramObject1, JSON.toJSONString(paramType), localObject3)) {
          continue;
        }
        continue;
        if (!paramType.getClass().isPrimitive())
        {
          paramObject2 = paramType;
          if (!(paramType instanceof Number)) {
            continue;
          }
        }
        paramObject2 = FilterUtils.processKey(paramJSONSerializer, paramObject1, JSON.toJSONString(paramType), localObject3);
        continue;
        if (!paramObject2.getClass().isPrimitive())
        {
          paramType = (Type)localObject3;
          if (!(paramObject2 instanceof Number)) {
            continue;
          }
        }
        paramType = FilterUtils.processValue(paramJSONSerializer, paramObject1, JSON.toJSONString(paramObject2), localObject3);
        continue;
        continue;
        if (i == 0) {
          localSerializeWriter.write(',');
        }
        if ((localSerializeWriter.isEnabled(SerializerFeature.BrowserCompatible)) || (localSerializeWriter.isEnabled(SerializerFeature.WriteNonStringKeyAsString)))
        {
          paramJSONSerializer.write(JSON.toJSONString(paramObject2));
          localSerializeWriter.write(':');
          continue;
        }
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
      continue;
      label693:
      Object localObject3 = paramType.getClass();
      if (localObject3 == localObject2)
      {
        localObjectSerializer.write(paramJSONSerializer, paramType, paramObject2, null);
        i = 0;
      }
      else
      {
        localObjectSerializer = paramJSONSerializer.getObjectWriter((Class)localObject3);
        localObjectSerializer.write(paramJSONSerializer, paramType, paramObject2, null);
        localObject2 = localObject3;
        i = 0;
        continue;
        label755:
        paramJSONSerializer.setContext(localSerialContext);
        paramJSONSerializer.decrementIdent();
        if ((localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) && (((Map)localObject1).size() > 0)) {
          paramJSONSerializer.println();
        }
        localSerializeWriter.write('}');
        break;
        label800:
        i = 1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */