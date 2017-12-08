package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class FieldSerializer
{
  private final String double_quoted_fieldPrefix;
  protected final FieldInfo fieldInfo;
  private final String single_quoted_fieldPrefix;
  private final String un_quoted_fieldPrefix;
  private boolean writeNull = false;
  
  public FieldSerializer(FieldInfo paramFieldInfo)
  {
    this.fieldInfo = paramFieldInfo;
    paramFieldInfo.setAccessible(true);
    this.double_quoted_fieldPrefix = ("\"" + paramFieldInfo.getName() + "\":");
    this.single_quoted_fieldPrefix = ("'" + paramFieldInfo.getName() + "':");
    this.un_quoted_fieldPrefix = (paramFieldInfo.getName() + ":");
    paramFieldInfo = (JSONField)paramFieldInfo.getAnnotation(JSONField.class);
    if (paramFieldInfo != null)
    {
      paramFieldInfo = paramFieldInfo.serialzeFeatures();
      int j = paramFieldInfo.length;
      for (int i = 0; i < j; i++) {
        if (paramFieldInfo[i] == SerializerFeature.WriteMapNullValue) {
          this.writeNull = true;
        }
      }
    }
  }
  
  public Field getField()
  {
    return this.fieldInfo.getField();
  }
  
  public Method getMethod()
  {
    return this.fieldInfo.getMethod();
  }
  
  public String getName()
  {
    return this.fieldInfo.getName();
  }
  
  public Object getPropertyValue(Object paramObject)
  {
    return this.fieldInfo.get(paramObject);
  }
  
  public boolean isWriteNull()
  {
    return this.writeNull;
  }
  
  public void writePrefix(JSONSerializer paramJSONSerializer)
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.getWriter();
    if (paramJSONSerializer.isEnabled(SerializerFeature.QuoteFieldNames)) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
        localSerializeWriter.write(this.single_quoted_fieldPrefix);
      }
    }
    for (;;)
    {
      return;
      localSerializeWriter.write(this.double_quoted_fieldPrefix);
      continue;
      localSerializeWriter.write(this.un_quoted_fieldPrefix);
    }
  }
  
  public abstract void writeProperty(JSONSerializer paramJSONSerializer, Object paramObject);
  
  public abstract void writeValue(JSONSerializer paramJSONSerializer, Object paramObject);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */