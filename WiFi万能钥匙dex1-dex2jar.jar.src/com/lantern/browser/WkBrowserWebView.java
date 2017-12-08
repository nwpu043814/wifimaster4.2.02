package com.lantern.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.bluefay.b.h;
import com.lantern.core.k;
import com.lantern.webox.domain.WebAppConfig;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.handler.WebViewClientHandler;
import com.lantern.webox.handler.g;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WkBrowserWebView
  extends WebView
  implements View.OnLongClickListener
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private boolean e = false;
  private cc f;
  private g g;
  private boolean h = false;
  private com.lantern.webox.event.b i;
  private Map<Object, Object> j;
  private WebAppConfig k;
  private boolean l = false;
  private int m;
  private boolean n = false;
  private com.lantern.webox.a o;
  private String p;
  private String q;
  private int r;
  private at s;
  private Handler t = new bx(this);
  private com.bluefay.d.b u = new by(this, new int[] { 128801 });
  
  public WkBrowserWebView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkBrowserWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkBrowserWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public WkBrowserWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (this.e) {}
    for (;;)
    {
      return;
      if ((paramContext instanceof Activity)) {
        this.q = ((Activity)paramContext).getIntent().getStringExtra("web_page_id");
      }
      if (TextUtils.isEmpty(this.q)) {
        this.q = UUID.randomUUID().toString();
      }
      this.a = paramContext;
      this.e = true;
      this.i = new com.lantern.webox.event.b();
      this.j = new ConcurrentHashMap();
      this.o = new com.lantern.webox.a(this);
      com.lantern.core.c.addListener(this.u);
      setOverScrollMode(2);
      setScrollbarFadingEnabled(true);
      setVerticalScrollBarEnabled(false);
      setHorizontalScrollBarEnabled(false);
      setOnLongClickListener(this);
      setDrawingCacheEnabled(true);
      setLayerType(0, null);
      this.g = new g(this, "WiFikey", WkBrowserJsInterface.class);
      new WebViewClientHandler(this);
      new com.lantern.webox.handler.e(this);
      new com.lantern.webox.handler.b(this);
      new com.lantern.webox.handler.d(this);
      paramContext = getSettings();
      if ((Build.VERSION.SDK_INT >= 19) && (com.bluefay.a.d.a(com.bluefay.d.a.getAppContext(), "wifikey_developer", "settings_pref_enable_webview_debug"))) {
        com.bluefay.a.e.a("android.webkit.WebView", "setWebContentsDebuggingEnabled", new Object[] { Boolean.valueOf(true) });
      }
      paramContext.setLoadsImagesAutomatically(true);
      try
      {
        paramContext.setJavaScriptEnabled(true);
        paramContext.setJavaScriptCanOpenWindowsAutomatically(true);
        paramContext.setUserAgentString(null);
        String str = paramContext.getUserAgentString();
        paramContext.setUserAgentString(str + " wkbrowser " + k.a(this.a) + " " + k.b(this.a));
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
        com.lantern.webox.d.a(com.lantern.webox.c.class);
        paramContext.setDatabasePath(com.lantern.webox.c.a(this.a));
        paramContext.setGeolocationDatabasePath(com.lantern.webox.c.c(this.a));
        paramContext.setAppCachePath(com.lantern.webox.c.b(this.a));
        paramContext.setAppCacheMaxSize(20971520L);
        getUrl();
        com.lantern.browser.c.a.a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
        }
      }
    }
  }
  
  private String e(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      String str = paramString;
      if (!paramString.startsWith("javascript:"))
      {
        str = paramString;
        if (!paramString.contains("://")) {
          str = "http://" + paramString;
        }
      }
      paramString = str;
      if (str.startsWith("http://"))
      {
        paramString = str;
        if (str.contains("newsId="))
        {
          paramString = str;
          if (!str.startsWith("http://c.wkanx.com/s?url="))
          {
            paramString = str;
            if (!str.endsWith(".apk"))
            {
              paramString = str;
              if (!bp.d(getContext(), str)) {
                if (!str.contains("nativeComment"))
                {
                  if (str.contains("?")) {
                    paramString = str + "&nativeComment=true";
                  } else {
                    paramString = str + "?nativeComment=true";
                  }
                }
                else
                {
                  paramString = str;
                  if (str.contains("nativeComment=false"))
                  {
                    paramString = str.substring(0, str.indexOf("nativeComment=false"));
                    str = str.substring(str.indexOf("nativeComment=false") + 19);
                    paramString = paramString + "nativeComment=true" + str;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final Object a(Object paramObject)
  {
    return this.j.get(paramObject);
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(at paramat)
  {
    this.s = paramat;
  }
  
  public final void a(cc paramcc)
  {
    this.f = paramcc;
  }
  
  public final void a(WebAppConfig paramWebAppConfig)
  {
    this.k = paramWebAppConfig;
  }
  
  public final void a(WebEvent paramWebEvent)
  {
    post(new ca(this, paramWebEvent));
  }
  
  public final void a(com.lantern.webox.event.c paramc)
  {
    this.i.a(paramc);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      this.j.remove(paramObject1);
    }
    for (;;)
    {
      return;
      this.j.put(paramObject1, paramObject2);
    }
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (!paramString.startsWith("javascript:")) {
        str = "javascript:" + paramString;
      }
      try
      {
        super.loadUrl(str);
      }
      catch (Exception paramString)
      {
        h.a(paramString);
      }
    }
  }
  
  public final void a(String paramString, String... paramVarArgs)
  {
    paramString = "javascript:" + paramString + "('";
    for (int i1 = 0; i1 <= 0; i1++)
    {
      String str = paramVarArgs[0];
      paramString = paramString + str;
    }
    paramString = paramString + "')";
    try
    {
      super.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    super.addJavascriptInterface(paramObject, paramString);
  }
  
  public final cc b()
  {
    return this.f;
  }
  
  public final void b(com.lantern.webox.event.c paramc)
  {
    this.i.b(paramc);
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final void c()
  {
    if (this.n)
    {
      this.n = false;
      super.setOnLongClickListener(new bz(this));
    }
  }
  
  public final void c(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean canGoBack()
  {
    return super.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    return super.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    return super.canGoForward();
  }
  
  public final void d()
  {
    if (this.h) {}
    for (;;)
    {
      return;
      try
      {
        this.h = true;
        com.lantern.core.c.removeListener(this.u);
        setDownloadListener(null);
        setWebChromeClient(null);
        setWebViewClient(null);
        this.f = null;
        this.s = null;
        WebEvent localWebEvent = new com/lantern/webox/event/WebEvent;
        localWebEvent.<init>(this, 7);
        a(localWebEvent);
        destroy();
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
    }
  }
  
  public final void d(String paramString)
  {
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")) || (paramString.startsWith("file"))) {
      this.b = paramString;
    }
  }
  
  public final WebAppConfig e()
  {
    return this.k;
  }
  
  public final com.lantern.webox.a f()
  {
    return this.o;
  }
  
  public final boolean g()
  {
    if (this.h) {
      h.b("[loadUrl]webview has destroyed!! " + getUrl());
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String getOriginalUrl()
  {
    String str2 = super.getOriginalUrl();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.b;
    }
    return str1;
  }
  
  public WebSettings getSettings()
  {
    return super.getSettings();
  }
  
  public String getTitle()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.c = super.getTitle();
    }
    return this.c;
  }
  
  public String getUrl()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      str = super.getUrl();
      if (str != null) {
        this.b = str;
      }
    }
    if (this.b == null) {}
    for (String str = "";; str = this.b) {
      return str;
    }
  }
  
  public void goBack()
  {
    super.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    super.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    super.goForward();
  }
  
  public final boolean h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    return this.l;
  }
  
  public final g j()
  {
    return this.g;
  }
  
  public final void k()
  {
    this.r = 0;
  }
  
  public final String l()
  {
    return this.q;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    requestFocus();
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = e(paramString1);
    d(paramString1);
    requestFocus();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      String str = e(paramString);
      paramString = new java/lang/StringBuilder;
      paramString.<init>("loadUrl url:");
      h.a(str, new Object[0]);
      d(str);
      this.c = null;
      requestFocus();
      super.loadUrl(str);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    paramString = e(paramString);
    d(paramString);
    requestFocus();
    super.loadUrl(paramString, paramMap);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = (int)(getContentHeight() * getScale());
    if ((this.s != null) && (i1 > this.s.getHeight())) {
      this.s.d();
    }
    if (this.m != i1)
    {
      if (this.f != null) {
        this.f.m();
      }
      this.m = i1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.t.obtainMessage();
    if (paramView != null) {
      paramView.setTarget(this.t);
    }
    try
    {
      requestFocusNodeHref(paramView);
      return false;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        h.a(paramView);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    int i1;
    int i2;
    float f2;
    float f1;
    if (this.r != 0)
    {
      i1 = this.r;
      i2 = getHeight();
      f2 = getContentHeight();
      f1 = getScale();
    }
    for (String str = String.format("%.3f", new Object[] { Float.valueOf((i1 + i2) / (f2 * f1)) });; str = "0")
    {
      com.lantern.browser.c.a.a(getUrl(), this.q, str);
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.lantern.browser.c.a.d(getUrl(), this.q);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f != null) {
      this.f.a(paramInt1, paramInt2);
    }
    if (paramInt2 > this.r) {
      this.r = paramInt2;
    }
    String str = getUrl();
    if ((str != null) && (str.equals(this.p))) {
      if (paramInt2 != paramInt4) {
        bp.a(this, paramInt2);
      }
    }
    for (;;)
    {
      return;
      this.p = str;
      if ((paramInt2 != 0) && (paramInt2 != paramInt4)) {
        bp.a(this, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (boolean bool = super.onTouchEvent(paramMotionEvent);; bool = true)
    {
      return bool;
      setOnLongClickListener(this);
      break;
      c();
    }
  }
  
  public void reload()
  {
    h.a("reload", new Object[0]);
    super.reload();
    com.lantern.browser.c.a.b(getUrl(), this.q);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    super.removeJavascriptInterface(paramString);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.n = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/WkBrowserWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */