package com.alibaba.fastjson;

class JSONStreamContext
{
  static final int ArrayValue = 1005;
  static final int PropertyKey = 1002;
  static final int PropertyValue = 1003;
  static final int StartArray = 1004;
  static final int StartObject = 1001;
  private final JSONStreamContext parent;
  private int state;
  
  public JSONStreamContext(JSONStreamContext paramJSONStreamContext, int paramInt)
  {
    this.parent = paramJSONStreamContext;
    this.state = paramInt;
  }
  
  public JSONStreamContext getParent()
  {
    return this.parent;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSONStreamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */