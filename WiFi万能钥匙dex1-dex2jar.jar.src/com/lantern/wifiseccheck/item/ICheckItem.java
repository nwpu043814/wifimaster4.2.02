package com.lantern.wifiseccheck.item;

public abstract class ICheckItem
{
  public static final int TYPE_ITEM_ARP = 1;
  public static final int TYPE_ITEM_DNS = 2;
  public static final int TYPE_ITEM_LOCATION = 6;
  public static final int TYPE_ITEM_NEIGHBOR = 5;
  public static final int TYPE_ITEM_SSL = 4;
  public static final int TYPE_ITEM_WEBMD5 = 3;
  private boolean isFinish;
  
  public abstract int getType();
  
  public abstract void initDefaultData();
  
  public boolean isFinish()
  {
    return this.isFinish;
  }
  
  public abstract boolean isTimeOutType();
  
  public void setFinish(boolean paramBoolean)
  {
    this.isFinish = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/ICheckItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */