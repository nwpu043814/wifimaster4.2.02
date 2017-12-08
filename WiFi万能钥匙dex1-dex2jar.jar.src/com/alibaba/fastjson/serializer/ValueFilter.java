package com.alibaba.fastjson.serializer;

public abstract interface ValueFilter
  extends SerializeFilter
{
  public abstract Object process(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ValueFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */