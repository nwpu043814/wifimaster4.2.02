package com.alibaba.fastjson.serializer;

public class SerialContext
{
  private final Object fieldName;
  private final Object object;
  private final SerialContext parent;
  
  public SerialContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2)
  {
    this.parent = paramSerialContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
  }
  
  public Object getFieldName()
  {
    return this.fieldName;
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public SerialContext getParent()
  {
    return this.parent;
  }
  
  public String getPath()
  {
    String str;
    if (this.parent == null) {
      str = "$";
    }
    for (;;)
    {
      return str;
      if ((this.fieldName instanceof Integer)) {
        str = this.parent.getPath() + "[" + this.fieldName + "]";
      } else {
        str = this.parent.getPath() + "." + this.fieldName;
      }
    }
  }
  
  public String toString()
  {
    return getPath();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/SerialContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */