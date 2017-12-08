package com.lantern.feed.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.k;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.R.style;
import com.lantern.feed.b.m;

public final class bm
  extends Dialog
{
  private Context a;
  private FrameLayout b;
  private FrameLayout c;
  private WebView d;
  private ImageView e;
  private TextView f;
  private ImageView g;
  private CountDownTimer h;
  private m i;
  
  public bm(Context paramContext)
  {
    super(paramContext, R.style.WkFeedFullScreenDialog);
    this.a = paramContext;
  }
  
  public final void a(m paramm)
  {
    h.a("setPopData", new Object[0]);
    this.i = paramm;
    show();
    int m = this.a.getResources().getDisplayMetrics().widthPixels;
    int j = this.a.getResources().getDisplayMetrics().heightPixels;
    label175:
    label203:
    label274:
    int k;
    if (this.i.b() == 1)
    {
      paramm = new FrameLayout.LayoutParams(m * paramm.j() / 100, j * paramm.k() / 100);
      paramm.gravity = 17;
      this.b.setLayoutParams(paramm);
      if (this.i.b() == 1)
      {
        if (this.c.getVisibility() != 0) {
          this.c.setVisibility(0);
        }
        if (this.e.getVisibility() != 8) {
          this.e.setVisibility(8);
        }
        this.d.loadDataWithBaseURL(this.i.c(), this.i.u(), "text/html", "utf-8", null);
        if (!this.i.l()) {
          break label419;
        }
        if (this.g.getVisibility() != 0) {
          this.g.setVisibility(0);
        }
        if (this.i.i() <= 0) {
          break label492;
        }
        this.h = new bn(this, this.i.i() * 1000);
        if (this.i.b() != 2) {
          break label443;
        }
        if (this.f.getVisibility() != 0) {
          this.f.setVisibility(0);
        }
        this.h.start();
      }
    }
    else
    {
      if (this.i.b() != 2) {
        break label528;
      }
      j = paramm.j();
      k = paramm.k();
      if (paramm.o() <= 0) {
        break label530;
      }
      m = m * paramm.o() / 100;
      k = k * m / j;
      j = m;
    }
    label419:
    label443:
    label492:
    label528:
    label530:
    for (;;)
    {
      paramm = new FrameLayout.LayoutParams(j, k);
      paramm.gravity = 17;
      this.b.setLayoutParams(paramm);
      break;
      if (this.i.b() != 2) {
        break label175;
      }
      if (this.e.getVisibility() != 0) {
        this.e.setVisibility(0);
      }
      if (this.c.getVisibility() != 8) {
        this.c.setVisibility(8);
      }
      this.e.setImageBitmap(this.i.t());
      break label175;
      if (this.g.getVisibility() == 8) {
        break label203;
      }
      this.g.setVisibility(8);
      break label203;
      if (this.i.b() != 1) {
        break label274;
      }
      if (this.h != null) {
        this.h.cancel();
      }
      if (this.f.getVisibility() == 8) {
        break label274;
      }
      this.f.setVisibility(8);
      break label274;
      if (this.h != null) {
        this.h.cancel();
      }
      if (this.f.getVisibility() == 8) {
        break label274;
      }
      this.f.setVisibility(8);
      break label274;
      break;
    }
  }
  
  public final void dismiss()
  {
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCancelable(false);
    setContentView(R.layout.feed_pop_window);
    this.b = ((FrameLayout)findViewById(R.id.pop_content));
    this.c = ((FrameLayout)findViewById(R.id.pop_webview_layout));
    this.d = ((WebView)findViewById(R.id.pop_webview));
    this.d.setScrollbarFadingEnabled(true);
    this.d.setScrollBarStyle(33554432);
    paramBundle = this.d.getSettings();
    paramBundle.setLoadsImagesAutomatically(true);
    try
    {
      paramBundle.setJavaScriptEnabled(true);
      paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
      paramBundle.setUserAgentString(null);
      Object localObject = paramBundle.getUserAgentString();
      paramBundle.setUserAgentString((String)localObject + " wkbrowser " + k.a(this.a) + " " + k.b(this.a));
      paramBundle.setPluginState(WebSettings.PluginState.ON);
      paramBundle.setLightTouchEnabled(false);
      paramBundle.setSaveFormData(false);
      paramBundle.setSavePassword(false);
      paramBundle.setNeedInitialFocus(false);
      paramBundle.setSupportMultipleWindows(true);
      paramBundle.setLoadWithOverviewMode(true);
      paramBundle.setSupportZoom(false);
      paramBundle.setDisplayZoomControls(false);
      paramBundle.setUseWideViewPort(true);
      paramBundle.setAllowFileAccess(true);
      paramBundle.setAppCacheEnabled(true);
      paramBundle.setDatabaseEnabled(true);
      paramBundle.setDomStorageEnabled(true);
      paramBundle.setGeolocationEnabled(true);
      this.d.setDownloadListener(new bo(this));
      localObject = new WkFeedPopDialog.3(this);
      paramBundle = new bp(this);
      this.d.setWebViewClient((WebViewClient)localObject);
      this.d.setWebChromeClient(paramBundle);
      this.e = ((ImageView)findViewById(R.id.pop_image));
      this.e.setOnClickListener(new bq(this));
      this.f = ((TextView)findViewById(R.id.pop_count));
      this.g = ((ImageView)findViewById(R.id.pop_close));
      this.g.setOnClickListener(new br(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final void show()
  {
    super.show();
    getWindow().setWindowAnimations(R.style.dialogWindowNoAnim);
    a.e().onEvent("nfwshow", String.valueOf(this.i.a()));
    this.i.v();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */