package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.util.Collection;

public class ObjectFieldSerializer
  extends FieldSerializer
{
  private ObjectSerializer fieldSerializer;
  private String format;
  private Class<?> runtimeFieldClass;
  boolean writeEnumUsingToString = false;
  boolean writeNullBooleanAsFalse = false;
  boolean writeNullListAsEmpty = false;
  boolean writeNullStringAsEmpty = false;
  private boolean writeNumberAsZero = false;
  
  public ObjectFieldSerializer(FieldInfo paramFieldInfo)
  {
    super(paramFieldInfo);
    paramFieldInfo = (JSONField)paramFieldInfo.getAnnotation(JSONField.class);
    if (paramFieldInfo != null)
    {
      this.format = paramFieldInfo.format();
      if (this.format.trim().length() == 0) {
        this.format = null;
      }
      SerializerFeature[] arrayOfSerializerFeature = paramFieldInfo.serialzeFeatures();
      int j = arrayOfSerializerFeature.length;
      int i = 0;
      if (i < j)
      {
        paramFieldInfo = arrayOfSerializerFeature[i];
        if (paramFieldInfo == SerializerFeature.WriteNullNumberAsZero) {
          this.writeNumberAsZero = true;
        }
        for (;;)
        {
          i++;
          break;
          if (paramFieldInfo == SerializerFeature.WriteNullStringAsEmpty) {
            this.writeNullStringAsEmpty = true;
          } else if (paramFieldInfo == SerializerFeature.WriteNullBooleanAsFalse) {
            this.writeNullBooleanAsFalse = true;
          } else if (paramFieldInfo == SerializerFeature.WriteNullListAsEmpty) {
            this.writeNullListAsEmpty = true;
          } else if (paramFieldInfo == SerializerFeature.WriteEnumUsingToString) {
            this.writeEnumUsingToString = true;
          }
        }
      }
    }
  }
  
  public void writeProperty(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    writePrefix(paramJSONSerializer);
    writeValue(paramJSONSerializer, paramObject);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    if (this.format != null) {
      paramJSONSerializer.writeWithFormat(paramObject, this.format);
    }
    for (;;)
    {
      return;
      if (this.fieldSerializer == null) {
        if (paramObject != null) {
          break label86;
        }
      }
      label86:
      for (this.runtimeFieldClass = this.fieldInfo.getFieldClass();; this.runtimeFieldClass = paramObject.getClass())
      {
        this.fieldSerializer = paramJSONSerializer.getObjectWriter(this.runtimeFieldClass);
        if (paramObject != null) {
          break label206;
        }
        if ((!this.writeNumberAsZero) || (!Number.class.isAssignableFrom(this.runtimeFieldClass))) {
          break label97;
        }
        paramJSONSerializer.getWriter().write('0');
        break;
      }
      label97:
      if ((this.writeNullStringAsEmpty) && (String.class == this.runtimeFieldClass))
      {
        paramJSONSerializer.getWriter().write("\"\"");
      }
      else if ((this.writeNullBooleanAsFalse) && (Boolean.class == this.runtimeFieldClass))
      {
        paramJSONSerializer.getWriter().write("false");
      }
      else if ((this.writeNullListAsEmpty) && (Collection.class.isAssignableFrom(this.runtimeFieldClass)))
      {
        paramJSONSerializer.getWriter().write("[]");
      }
      else
      {
        this.fieldSerializer.write(paramJSONSerializer, null, this.fieldInfo.getName(), null);
        continue;
        label206:
        if ((this.writeEnumUsingToString == true) && (this.runtimeFieldClass.isEnum()))
        {
          paramJSONSerializer.getWriter().writeString(((Enum)paramObject).name());
        }
        else
        {
          Class localClass = paramObject.getClass();
          if (localClass == this.runtimeFieldClass) {
            this.fieldSerializer.write(paramJSONSerializer, paramObject, this.fieldInfo.getName(), this.fieldInfo.getFieldType());
          } else {
            paramJSONSerializer.getObjectWriter(localClass).write(paramJSONSerializer, paramObject, this.fieldInfo.getName(), this.fieldInfo.getFieldType());
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ObjectFieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */