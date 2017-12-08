package com.lantern.wifitools.apgrade.ui;

import android.os.Bundle;
import android.view.MenuItem;
import bluefay.app.m;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.qihoo.util.StubApp1053578832;

public class ApGradeActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(66);
  }
  
  protected final boolean b()
  {
    return false;
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    h.a("onDestory", new Object[0]);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    h.a("onOptionsItemSelected id:" + i);
    if ((i == 16908332) || (i == 17039360))
    {
      a.e().onEvent("aprate0");
      onBackPressed();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    h.a("onPause", new Object[0]);
  }
  
  protected void onResume()
  {
    super.onResume();
    h.a("onResume", new Object[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/ApGradeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */