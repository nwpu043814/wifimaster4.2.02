package com.lantern.wifiseccheck.item;

public class CheckItemARP
  extends ICheckItem
{
  private boolean hasArp;
  
  public CheckItemARP()
  {
    initDefaultData();
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void initDefaultData()
  {
    this.hasArp = false;
  }
  
  public boolean isHasArp()
  {
    return this.hasArp;
  }
  
  public boolean isTimeOutType()
  {
    return false;
  }
  
  public void setHasArp(boolean paramBoolean)
  {
    this.hasArp = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemARP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */