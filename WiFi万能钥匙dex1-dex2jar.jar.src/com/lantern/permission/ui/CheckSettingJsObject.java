package com.lantern.permission.ui;

import android.content.Context;

public class CheckSettingJsObject
{
  private Context mContext;
  private int systemThpe;
  
  public CheckSettingJsObject(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getPhType()
  {
    return this.systemThpe;
  }
  
  public void openSysSetting()
  {
    a.a().a(this.mContext);
  }
  
  public void setSystemThpe(int paramInt)
  {
    this.systemThpe = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingJsObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */