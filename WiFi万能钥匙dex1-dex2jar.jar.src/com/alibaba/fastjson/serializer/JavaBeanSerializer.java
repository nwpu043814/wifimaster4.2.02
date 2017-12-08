package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer
  implements ObjectSerializer
{
  private final FieldSerializer[] getters;
  private final FieldSerializer[] sortedGetters;
  
  public JavaBeanSerializer(Class<?> paramClass)
  {
    this(paramClass, null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = TypeUtils.computeGetters(paramClass, paramMap, false).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(createFieldSerializer((FieldInfo)((Iterator)localObject).next()));
    }
    this.getters = ((FieldSerializer[])localArrayList.toArray(new FieldSerializer[localArrayList.size()]));
    localObject = new ArrayList();
    paramClass = TypeUtils.computeGetters(paramClass, paramMap, true).iterator();
    while (paramClass.hasNext()) {
      ((List)localObject).add(createFieldSerializer((FieldInfo)paramClass.next()));
    }
    this.sortedGetters = ((FieldSerializer[])((List)localObject).toArray(new FieldSerializer[((List)localObject).size()]));
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs)
  {
    this(paramClass, createAliasMap(paramVarArgs));
  }
  
  static Map<String, String> createAliasMap(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
    {
      String str = paramVarArgs[i];
      localHashMap.put(str, str);
    }
    return localHashMap;
  }
  
  public FieldSerializer createFieldSerializer(FieldInfo paramFieldInfo)
  {
    if (paramFieldInfo.getFieldClass() == Number.class) {}
    for (paramFieldInfo = new NumberFieldSerializer(paramFieldInfo);; paramFieldInfo = new ObjectFieldSerializer(paramFieldInfo)) {
      return paramFieldInfo;
    }
  }
  
  public FieldSerializer[] getGetters()
  {
    return this.getters;
  }
  
  protected boolean isWriteClassName(JSONSerializer paramJSONSerializer, Object paramObject1, Type paramType, Object paramObject2)
  {
    return paramJSONSerializer.isWriteClassName(paramType, paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      localSerializeWriter.writeNull();
    }
    for (;;)
    {
      return;
      if (!paramJSONSerializer.containsReference(paramObject1)) {
        break;
      }
      writeReference(paramJSONSerializer, paramObject1);
    }
    FieldSerializer[] arrayOfFieldSerializer;
    SerialContext localSerialContext;
    boolean bool;
    label82:
    char c1;
    if (localSerializeWriter.isEnabled(SerializerFeature.SortField))
    {
      arrayOfFieldSerializer = this.sortedGetters;
      localSerialContext = paramJSONSerializer.getContext();
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2);
      bool = paramJSONSerializer.isWriteAsArray(paramObject1, paramType);
      if (!bool) {
        break label427;
      }
      c2 = '[';
      if (!bool) {
        break label434;
      }
      c1 = ']';
    }
    int i;
    for (;;)
    {
      try
      {
        localSerializeWriter.append(c2);
        if ((arrayOfFieldSerializer.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
        {
          paramJSONSerializer.incrementIndent();
          paramJSONSerializer.println();
        }
        int j = 0;
        i = j;
        if (isWriteClassName(paramJSONSerializer, paramObject1, paramType, paramObject2))
        {
          i = j;
          if (paramObject1.getClass() != paramType)
          {
            localSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            paramJSONSerializer.write(paramObject1.getClass());
            i = 1;
          }
        }
        Object localObject;
        if (i != 0)
        {
          c2 = ',';
          if (FilterUtils.writeBefore(paramJSONSerializer, paramObject1, c2) != ',') {
            continue;
          }
          i = 1;
          j = 0;
          if (j >= arrayOfFieldSerializer.length) {
            break label527;
          }
          paramObject2 = arrayOfFieldSerializer[j];
          if (paramJSONSerializer.isEnabled(SerializerFeature.SkipTransientField))
          {
            paramType = ((FieldSerializer)paramObject2).getField();
            if (paramType != null)
            {
              k = i;
              if (Modifier.isTransient(paramType.getModifiers())) {
                continue;
              }
            }
          }
          int k = i;
          if (FilterUtils.applyName(paramJSONSerializer, paramObject1, ((FieldSerializer)paramObject2).getName()))
          {
            localObject = ((FieldSerializer)paramObject2).getPropertyValue(paramObject1);
            k = i;
            if (FilterUtils.apply(paramJSONSerializer, paramObject1, ((FieldSerializer)paramObject2).getName(), localObject))
            {
              String str = FilterUtils.processKey(paramJSONSerializer, paramObject1, ((FieldSerializer)paramObject2).getName(), localObject);
              paramType = FilterUtils.processValue(paramJSONSerializer, paramObject1, ((FieldSerializer)paramObject2).getName(), localObject);
              if ((paramType == null) && (!bool) && (!((FieldSerializer)paramObject2).isWriteNull()))
              {
                k = i;
                if (!paramJSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {}
              }
              else
              {
                if (i != 0)
                {
                  localSerializeWriter.append(',');
                  if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    paramJSONSerializer.println();
                  }
                }
                if (str == ((FieldSerializer)paramObject2).getName()) {
                  continue;
                }
                if (!bool) {
                  localSerializeWriter.writeFieldName(str);
                }
                paramJSONSerializer.write(paramType);
                k = 1;
              }
            }
          }
          j++;
          i = k;
          continue;
          arrayOfFieldSerializer = this.getters;
          break;
          label427:
          c2 = '{';
          break label82;
          label434:
          c1 = '}';
          continue;
        }
        c2 = '\000';
        continue;
        i = 0;
        continue;
        if (localObject != paramType)
        {
          if (!bool) {
            ((FieldSerializer)paramObject2).writePrefix(paramJSONSerializer);
          }
          paramJSONSerializer.write(paramType);
          continue;
        }
        if (bool) {
          break label517;
        }
      }
      catch (Exception paramObject1)
      {
        paramObject2 = new com/alibaba/fastjson/JSONException;
        ((JSONException)paramObject2).<init>("write javaBean error", (Throwable)paramObject1);
        throw ((Throwable)paramObject2);
      }
      finally
      {
        paramJSONSerializer.setContext(localSerialContext);
      }
      ((FieldSerializer)paramObject2).writeProperty(paramJSONSerializer, paramType);
      continue;
      label517:
      ((FieldSerializer)paramObject2).writeValue(paramJSONSerializer, paramType);
    }
    label527:
    if (i != 0) {}
    for (char c2 = ',';; c2 = '\000')
    {
      FilterUtils.writeAfter(paramJSONSerializer, paramObject1, c2);
      if ((arrayOfFieldSerializer.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
      {
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
      }
      localSerializeWriter.append(c1);
      paramJSONSerializer.setContext(localSerialContext);
      break;
    }
  }
  
  public void writeReference(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    paramJSONSerializer.writeReference(paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JavaBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */