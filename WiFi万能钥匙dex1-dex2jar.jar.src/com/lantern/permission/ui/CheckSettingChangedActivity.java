package com.lantern.permission.ui;

import android.os.Bundle;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class CheckSettingChangedActivity
  extends m
{
  public static boolean e = false;
  
  static
  {
    StubApp1053578832.interface11(38);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    e = false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingChangedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */