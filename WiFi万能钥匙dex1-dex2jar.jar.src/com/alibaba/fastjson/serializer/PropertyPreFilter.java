package com.alibaba.fastjson.serializer;

public abstract interface PropertyPreFilter
  extends SerializeFilter
{
  public abstract boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/PropertyPreFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */