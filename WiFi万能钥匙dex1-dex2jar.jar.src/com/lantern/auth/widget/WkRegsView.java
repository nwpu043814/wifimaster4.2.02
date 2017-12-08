package com.lantern.auth.widget;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.material.f;
import com.lantern.account.R.layout;
import com.lantern.account.R.string;
import com.lantern.auth.utils.WkPublicParamsInterface;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WkRegsView
  extends FrameLayout
{
  private Context a;
  private WebView b;
  private ProgressBar c;
  private Runnable d;
  private f e;
  private Handler f;
  private com.bluefay.b.a g;
  private String h;
  private String i;
  private String j;
  
  public WkRegsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkRegsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public WkRegsView(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext);
    this.h = paramString1;
    this.j = paramString2;
    this.i = (paramString3 + "6");
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    com.lantern.analytics.a.e().onEvent("REG_PAGE", com.lantern.auth.g.a(this.h));
    this.a = paramContext;
    this.f = new Handler();
    this.b = new WebView(this.a);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.c = ((ProgressBar)LayoutInflater.from(this.a).inflate(R.layout.auth_progressbar, null));
    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, e.a(this.a, 4.0F)));
    addView(this.b);
    addView(this.c);
    String str;
    if (TextUtils.isEmpty(com.lantern.core.c.getServer().g())) {
      str = this.a.getString(R.string.auth_loading_code);
    }
    for (;;)
    {
      try
      {
        paramContext = new com/bluefay/material/f;
        paramContext.<init>(this.a);
        this.e = paramContext;
        this.e.a(str);
        this.e.setCanceledOnTouchOutside(false);
        this.e.show();
        new a().execute(new Void[0]);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      b();
    }
  }
  
  private void b()
  {
    this.c.setVisibility(0);
    this.b.setWebChromeClient(new h(this));
    Object localObject1 = this.b.getSettings();
    ((WebSettings)localObject1).setLoadsImagesAutomatically(true);
    ((WebSettings)localObject1).setJavaScriptEnabled(true);
    ((WebSettings)localObject1).setJavaScriptCanOpenWindowsAutomatically(true);
    ((WebSettings)localObject1).setUserAgentString(null);
    ((WebSettings)localObject1).setDefaultTextEncodingName("UTF-8");
    ((WebSettings)localObject1).setPluginState(WebSettings.PluginState.ON);
    ((WebSettings)localObject1).setLightTouchEnabled(false);
    ((WebSettings)localObject1).setSaveFormData(false);
    ((WebSettings)localObject1).setSavePassword(false);
    ((WebSettings)localObject1).setNeedInitialFocus(false);
    ((WebSettings)localObject1).setSupportMultipleWindows(true);
    ((WebSettings)localObject1).setLoadWithOverviewMode(true);
    ((WebSettings)localObject1).setBuiltInZoomControls(true);
    ((WebSettings)localObject1).setSupportZoom(false);
    ((WebSettings)localObject1).setUseWideViewPort(true);
    ((WebSettings)localObject1).setAllowFileAccess(true);
    ((WebSettings)localObject1).setAppCacheEnabled(true);
    ((WebSettings)localObject1).setDatabaseEnabled(true);
    ((WebSettings)localObject1).setDomStorageEnabled(true);
    ((WebSettings)localObject1).setGeolocationEnabled(true);
    this.b.addJavascriptInterface(new WkRegisterInterface(), "client");
    this.b.addJavascriptInterface(new WkPublicParamsInterface(), "WiFikey");
    localObject1 = this.b;
    Object localObject2 = com.lantern.core.c.getServer().s();
    String str = new JSONObject((Map)localObject2).toString();
    ((HashMap)localObject2).clear();
    localObject2 = com.lantern.core.c.getServer();
    str = com.lantern.core.n.a(Uri.encode(str.trim(), "UTF-8"), ((o)localObject2).l(), ((o)localObject2).m());
    StringBuilder localStringBuilder = new StringBuilder(com.lantern.auth.h.b());
    localStringBuilder.append("origin=1&lang=").append(com.lantern.core.k.c()).append("&ed=").append(str).append("&et=").append("a").append("&appId=").append(((o)localObject2).k()).append("&thirdAppId=").append(this.h);
    localObject2 = localStringBuilder.toString();
    com.bluefay.b.h.a("url=" + (String)localObject2, new Object[0]);
    ((WebView)localObject1).loadUrl((String)localObject2);
    this.b.setWebViewClient(new WebViewClientHandler());
  }
  
  public final void a()
  {
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    this.g = parama;
  }
  
  class WebViewClientHandler
    extends WebViewClient
  {
    WebViewClientHandler() {}
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      WkRegsView.e(WkRegsView.this).addView(WkRegsView.d(WkRegsView.this));
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (((Activity)WkRegsView.c(WkRegsView.this)).isFinishing()) {}
      for (;;)
      {
        return;
        paramWebView = new k.a(WkRegsView.c(WkRegsView.this));
        paramWebView.a(WkRegsView.c(WkRegsView.this).getString(R.string.browser_ssl_title));
        paramWebView.b(WkRegsView.c(WkRegsView.this).getString(R.string.browser_ssl_msg));
        paramWebView.a(WkRegsView.c(WkRegsView.this).getString(R.string.browser_ssl_continue), new m(this, paramSslErrorHandler));
        paramWebView.b(WkRegsView.c(WkRegsView.this).getString(R.string.browser_btn_cancel), new n(this, paramSslErrorHandler));
        paramWebView.c().show();
      }
    }
  }
  
  public class WkRegisterInterface
  {
    public WkRegisterInterface() {}
    
    public void webAuthorToken(String paramString)
    {
      com.bluefay.b.h.a("webAuthorToken " + paramString, new Object[0]);
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        try
        {
          Object localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(paramString);
          Object localObject2 = ((JSONObject)localObject1).optString("sessionId");
          String str2 = ((JSONObject)localObject1).optString("uhid");
          String str3 = ((JSONObject)localObject1).optString("mobile");
          paramString = ((JSONObject)localObject1).optString("nickName");
          String str1 = ((JSONObject)localObject1).optString("headImgUrl");
          localObject1 = ((JSONObject)localObject1).optString("userToken");
          p.g(WkRegsView.c(WkRegsView.this), (String)localObject2);
          localObject2 = new com/lantern/core/model/g;
          ((com.lantern.core.model.g)localObject2).<init>();
          ((com.lantern.core.model.g)localObject2).a = str3;
          ((com.lantern.core.model.g)localObject2).b = str2;
          ((com.lantern.core.model.g)localObject2).c = com.bluefay.a.c.d(WkRegsView.c(WkRegsView.this));
          ((com.lantern.core.model.g)localObject2).d = paramString;
          ((com.lantern.core.model.g)localObject2).h = ((String)localObject1);
          com.lantern.core.c.getServer().a((com.lantern.core.model.g)localObject2);
          p.k(WkRegsView.c(WkRegsView.this), str1);
          com.lantern.core.h.b();
          WkRegsView.a(WkRegsView.this, str2);
          return;
        }
        catch (Exception paramString)
        {
          WkRegsView.b(WkRegsView.this, "1004");
          continue;
        }
        WkRegsView.b(WkRegsView.this, "1003");
      }
    }
  }
  
  final class a
    extends AsyncTask<Void, Void, Void>
  {
    a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/WkRegsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */