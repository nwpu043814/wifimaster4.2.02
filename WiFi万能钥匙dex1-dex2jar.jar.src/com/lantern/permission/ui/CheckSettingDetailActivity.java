package com.lantern.permission.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class CheckSettingDetailActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(39);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("values", paramBundle);
    localIntent.setClass(paramContext, CheckSettingDetailActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */