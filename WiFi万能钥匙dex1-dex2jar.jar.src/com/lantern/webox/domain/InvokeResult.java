package com.lantern.webox.domain;

public class InvokeResult
{
  public static final int STATUS_CANCEL = 2;
  public static final int STATUS_ERROR = 1;
  public static final int STATUS_SUCCESS = 0;
  private Object data;
  private int status;
  
  public InvokeResult() {}
  
  public InvokeResult(int paramInt, Object paramObject)
  {
    this.status = paramInt;
    this.data = paramObject;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setData(Object paramObject)
  {
    this.data = paramObject;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/domain/InvokeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */