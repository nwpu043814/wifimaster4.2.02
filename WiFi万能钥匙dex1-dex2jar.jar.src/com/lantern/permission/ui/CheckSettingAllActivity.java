package com.lantern.permission.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class CheckSettingAllActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(37);
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, CheckSettingAllActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingAllActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */