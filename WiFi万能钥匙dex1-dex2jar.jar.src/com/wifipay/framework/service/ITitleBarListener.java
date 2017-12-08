package com.wifipay.framework.service;

public abstract interface ITitleBarListener
{
  public static final int TITLE_BAR_LEFT = 1;
  public static final int TITLE_BAR_RIGHT = 2;
  
  public abstract boolean onTitleClick(int paramInt);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/service/ITitleBarListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */