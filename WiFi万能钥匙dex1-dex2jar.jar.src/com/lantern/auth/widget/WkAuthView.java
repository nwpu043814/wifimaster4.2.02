package com.lantern.auth.widget;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Handler;
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
import bluefay.app.k;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.lantern.account.R.layout;
import com.lantern.account.R.string;
import com.lantern.auth.utils.WkPublicParamsInterface;
import com.lantern.core.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WkAuthView
  extends FrameLayout
{
  private Context a;
  private WebView b;
  private ProgressBar c;
  private Runnable d;
  private Handler e;
  private com.bluefay.b.a f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  private WkAuthView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WkAuthView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkAuthView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public WkAuthView(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramContext);
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramString5;
    if (paramString6 != null) {}
    for (;;)
    {
      this.l = paramString6;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.k = paramString1;
      a(paramContext);
      return;
      paramString6 = "";
    }
  }
  
  private void a(Context paramContext)
  {
    com.lantern.analytics.a.e().onEvent("AUTH_PAGE", com.lantern.auth.g.a(this.l));
    this.a = paramContext;
    this.e = new Handler();
    this.b = new WebView(this.a);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.c = ((ProgressBar)LayoutInflater.from(this.a).inflate(R.layout.auth_progressbar, null));
    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, e.a(this.a, 4.0F)));
    addView(this.b);
    addView(this.c);
    this.c.setVisibility(0);
    this.b.setWebChromeClient(new a(this));
    paramContext = this.b.getSettings();
    if (Build.VERSION.SDK_INT >= 21) {
      e.a(paramContext, "setMixedContentMode", new Object[] { Integer.valueOf(0) });
    }
    paramContext.setLoadsImagesAutomatically(true);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setJavaScriptCanOpenWindowsAutomatically(true);
    paramContext.setUserAgentString(null);
    paramContext.setDefaultTextEncodingName("UTF-8");
    paramContext.setPluginState(WebSettings.PluginState.ON);
    paramContext.setLightTouchEnabled(false);
    paramContext.setSaveFormData(false);
    paramContext.setSavePassword(false);
    paramContext.setNeedInitialFocus(false);
    paramContext.setSupportMultipleWindows(true);
    paramContext.setLoadWithOverviewMode(true);
    paramContext.setBuiltInZoomControls(true);
    paramContext.setSupportZoom(false);
    paramContext.setUseWideViewPort(true);
    paramContext.setAllowFileAccess(true);
    paramContext.setAppCacheEnabled(true);
    paramContext.setDatabaseEnabled(true);
    paramContext.setDomStorageEnabled(true);
    paramContext.setGeolocationEnabled(true);
    this.b.addJavascriptInterface(new WkAuthorizedInterface(), "client");
    this.b.addJavascriptInterface(new WkPublicParamsInterface(), "WiFikey");
    for (;;)
    {
      try
      {
        WebView localWebView = this.b;
        paramContext = com.lantern.core.f.a(c.getAppContext()).a("ssohost");
        if (paramContext == null) {
          continue;
        }
        paramContext = String.format("%s%s", new Object[] { paramContext, "/sso/oauth2/confirm_auth.do" });
        localWebView.postUrl(paramContext, b().getBytes("UTF-8"));
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      this.b.setWebViewClient(new WebViewClientHandler());
      return;
      paramContext = String.format("%s%s", new Object[] { "https://sso.51y5.net", "/sso/oauth2/confirm_auth.do" });
    }
  }
  
  private String b()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("key=");
      localObject = URLEncoder.encode(this.g) + "&appName=" + URLEncoder.encode(this.h) + "&appIcon=" + URLEncoder.encode(this.i) + "&srcReq=" + URLEncoder.encode(this.j) + "&src=" + URLEncoder.encode(this.k) + "&thirdAppId=" + this.l;
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str = "";
      }
    }
  }
  
  public final void a()
  {
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    this.f = parama;
  }
  
  class WebViewClientHandler
    extends WebViewClient
  {
    WebViewClientHandler() {}
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      WkAuthView.e(WkAuthView.this).addView(WkAuthView.d(WkAuthView.this));
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (((Activity)WkAuthView.c(WkAuthView.this)).isFinishing()) {}
      for (;;)
      {
        return;
        paramWebView = new k.a(WkAuthView.c(WkAuthView.this));
        paramWebView.a(WkAuthView.c(WkAuthView.this).getString(R.string.browser_ssl_title));
        paramWebView.b(WkAuthView.c(WkAuthView.this).getString(R.string.browser_ssl_msg));
        paramWebView.a(WkAuthView.c(WkAuthView.this).getString(R.string.browser_ssl_continue), new f(this, paramSslErrorHandler));
        paramWebView.b(WkAuthView.c(WkAuthView.this).getString(R.string.browser_btn_cancel), new g(this, paramSslErrorHandler));
        paramWebView.c().show();
      }
    }
  }
  
  public class WkAuthorizedInterface
  {
    public WkAuthorizedInterface() {}
    
    public void webAuthorLogin(String paramString)
    {
      if ((paramString != null) && (paramString.length() > 4)) {
        WkAuthView.a(WkAuthView.this, paramString);
      }
      for (;;)
      {
        return;
        WkAuthView.b(WkAuthView.this, "1001");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/WkAuthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */