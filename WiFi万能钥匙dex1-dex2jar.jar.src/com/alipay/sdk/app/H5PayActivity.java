package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qihoo.util.StubApp1053578832;

public class H5PayActivity
  extends Activity
{
  private WebView a;
  private WebViewClient b;
  
  static
  {
    StubApp1053578832.interface11(0);
  }
  
  public void a()
  {
    try
    {
      synchronized (PayTask.a)
      {
        ???.notify();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void finish()
  {
    a();
    super.finish();
  }
  
  public void onBackPressed()
  {
    if (this.a.canGoBack()) {
      if (((c)this.b).c)
      {
        k localk = k.a(k.d.h);
        j.a = j.a(localk.h, localk.i, "");
        finish();
      }
    }
    for (;;)
    {
      return;
      j.a = j.a();
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.removeAllViews();
      ((ViewGroup)this.a.getParent()).removeAllViews();
    }
    try
    {
      this.a.destroy();
      this.a = null;
      if (this.b != null)
      {
        c localc = (c)this.b;
        localc.b = null;
        localc.a = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */