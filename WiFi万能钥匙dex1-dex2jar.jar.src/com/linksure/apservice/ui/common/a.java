package com.linksure.apservice.ui.common;

import android.os.Bundle;
import bluefay.app.m;
import com.linksure.apservice.utils.d;

public class a
  extends m
{
  public static boolean e = false;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    com.linksure.apservice.a.f.b.a();
    com.linksure.apservice.utils.a.a(this);
    com.linksure.apservice.a.e.a(getApplicationContext());
    com.linksure.apservice.utils.e.a(getApplicationContext());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.linksure.apservice.utils.a.a();
  }
  
  protected void onPause()
  {
    super.onPause();
    d.a(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    d.a(this, new b(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */