package com.wifipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.analysis.analytics.ALInterface;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.modelpay.PayReq;
import com.wifipay.sdk.util.c;
import java.util.HashMap;

public class WifiPayActivity
  extends Activity
{
  private WebView a;
  private e b;
  private a c;
  private LinearLayout d;
  private String e;
  
  static
  {
    StubApp1053578832.interface11(100);
  }
  
  private void a()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      finish();
    }
    for (;;)
    {
      return;
      PayReq localPayReq = new PayReq();
      localPayReq.fromBundle(localBundle);
      this.e = localPayReq.merchantOrderNo;
      c.a("kyo", "jSessionID = " + localPayReq.jSessionID);
      this.c.b.a(a.d.a);
      a(localPayReq.jSessionID);
    }
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (this.a == null) {
      this.c.c.a(new h(this, localHashMap, paramString));
    }
    for (;;)
    {
      return;
      this.c.c.a(new i(this, localHashMap, paramString));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    b(paramString2);
    this.a = com.wifipay.sdk.util.h.a(this, paramString1, paramString2);
    paramString1 = new LinearLayout.LayoutParams(-1, -1);
    this.d.addView(this.a, paramString1);
    this.b = new e(b());
    this.a.setWebViewClient(this.b);
    this.a.setWebChromeClient(new d());
  }
  
  private a b()
  {
    if (this.c == null) {
      this.c = new a(this);
    }
    return this.c;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null)) {
      this.c.c(paramString);
    }
  }
  
  private void c()
  {
    this.c.b.a(a.d.e, a.d.p, a.d.r, new j(this), a.d.q, null);
  }
  
  public void finish()
  {
    super.finish();
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed()
  {
    if (this.a != null) {
      if (this.a.canGoBack()) {
        this.a.goBack();
      }
    }
    for (;;)
    {
      return;
      c();
      continue;
      super.onBackPressed();
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.a("kyo", "onDestroy");
    if (this.a != null)
    {
      this.a.clearCache(true);
      this.a.clearHistory();
      ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.a);
      }
      this.a.removeAllViews();
      this.a.destroy();
      this.a = null;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.c.b(paramIntent))
    {
      c.a("kyo", "onNewIntent NOT WX result");
      setIntent(paramIntent);
      a();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    ALInterface.onPause(this, "WifiPayActivity");
  }
  
  protected void onResume()
  {
    super.onResume();
    this.c.f();
    ALInterface.onResume(this, "WifiPayActivity");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/WifiPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */