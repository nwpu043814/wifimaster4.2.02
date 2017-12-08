package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;

final class NumberFieldSerializer
  extends FieldSerializer
{
  public NumberFieldSerializer(FieldInfo paramFieldInfo)
  {
    super(paramFieldInfo);
  }
  
  public final void writeProperty(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    writePrefix(paramJSONSerializer);
    writeValue(paramJSONSerializer, paramObject);
  }
  
  public final void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramJSONSerializer.write('0');
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramJSONSerializer.append(paramObject.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/NumberFieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */