package com.lantern.browser.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.ViewPagerFragment;
import bluefay.app.u;
import com.bluefay.b.h;
import com.bluefay.material.MaterialProgressBar;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.material.SwipeRefreshLayout.a;
import com.lantern.browser.R.color;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserJsInterface;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.cb;
import com.lantern.browser.cc;
import com.lantern.browser.cd;
import com.lantern.browser.m;
import com.lantern.core.config.AppStoreConf;
import com.lantern.core.config.LinkedForwardConf;
import com.lantern.core.config.RecommendLinkConf;
import com.lantern.core.config.RedDotConf;
import com.lantern.core.g.k.a;
import com.lantern.core.g.k.b;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.webox.event.WebEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class WkBrowserFeedFragment
  extends ViewPagerFragment
  implements cc, com.lantern.webox.event.c
{
  private b A = new b((byte)0);
  private Handler B = new a(this);
  private k.a C = new d(this);
  private RelativeLayout g;
  private WkBrowserWebView h;
  private SwipeRefreshLayout i;
  private MaterialProgressBar j;
  private RelativeLayout k;
  private int l = 2;
  private String m = "";
  private String n = "";
  private String o = "";
  private List<String> p = new ArrayList();
  private BroadcastReceiver q;
  private int r = 0;
  private boolean s = false;
  private float t;
  private boolean u;
  private Bitmap v;
  private Bitmap w;
  private Bitmap x;
  private HashMap<String, String> y = new HashMap();
  private b z = new b((byte)0);
  
  private static boolean a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    if (localCalendar.get(5) != Calendar.getInstance().get(5)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private String b(String paramString)
  {
    String str2 = (String)this.y.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = bp.c(paramString);
    }
    return str1;
  }
  
  private void d()
  {
    a(R.string.browser_tab_title);
    b(-1);
    u localu = new u(this.e);
    Object localObject1 = (AppStoreConf)com.lantern.core.config.d.a(this.e).a(AppStoreConf.class);
    if (localObject1 != null) {}
    for (boolean bool = ((AppStoreConf)localObject1).d();; bool = true)
    {
      Object localObject2;
      Object localObject3;
      if ((com.lantern.core.f.g()) && (bool))
      {
        if (localObject1 != null)
        {
          localObject1 = localu.add(101, 10001, 0, ((AppStoreConf)localObject1).g());
          if (!com.lantern.core.g.k.a().d(k.b.t)) {
            break label436;
          }
          localObject2 = this.e;
          localObject3 = this.e;
          if ((this.v == null) || (this.v.isRecycled())) {
            this.v = BitmapFactory.decodeResource(((Context)localObject3).getResources(), R.drawable.browser_icon_appstore);
          }
          ((MenuItem)localObject1).setIcon(cd.a((Context)localObject2, this.v));
        }
      }
      else {
        label154:
        if (com.lantern.core.f.a().a("recommend", false))
        {
          localObject2 = (RecommendLinkConf)com.lantern.core.config.d.a(this.e).a(RecommendLinkConf.class);
          if ((this.u) && ((this.x == null) || (this.x.isRecycled())))
          {
            localObject1 = ((RecommendLinkConf)localObject2).f();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject3 = new File((String)localObject1);
              if (!((File)localObject3).exists()) {
                break label449;
              }
              localObject1 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
              BitmapFactory.decodeFile(((File)localObject3).getAbsolutePath(), (BitmapFactory.Options)localObject1);
              int i1 = Math.max(((BitmapFactory.Options)localObject1).outHeight, ((BitmapFactory.Options)localObject1).outWidth);
              ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
              ((BitmapFactory.Options)localObject1).inSampleSize = ((int)(i1 / (33.0F * this.t)));
              ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
              ((BitmapFactory.Options)localObject1).inPurgeable = true;
              ((BitmapFactory.Options)localObject1).inInputShareable = true;
              localObject1 = BitmapFactory.decodeFile(((File)localObject3).getAbsolutePath(), (BitmapFactory.Options)localObject1);
              label323:
              this.x = ((Bitmap)localObject1);
            }
          }
          localObject1 = ((RecommendLinkConf)localObject2).e();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label454;
          }
          localObject1 = localu.add(101, 10002, 0, R.string.browser_btn_recommend);
          label358:
          if (!com.lantern.core.g.k.a().d(k.b.u)) {
            break label535;
          }
          if ((this.x == null) || (this.x.isRecycled())) {
            break label472;
          }
          ((MenuItem)localObject1).setIcon(cd.a(this.e, this.x));
        }
      }
      for (;;)
      {
        a(a, localu);
        return;
        localObject1 = localu.add(101, 10001, 0, R.string.browser_btn_appstore);
        break;
        label436:
        ((MenuItem)localObject1).setIcon(R.drawable.browser_icon_appstore);
        break label154;
        label449:
        localObject1 = null;
        break label323;
        label454:
        localObject1 = localu.add(101, 10002, 0, (CharSequence)localObject1);
        break label358;
        label472:
        localObject3 = this.e;
        localObject2 = this.e;
        if ((this.w == null) || (this.w.isRecycled())) {
          this.w = BitmapFactory.decodeResource(((Context)localObject2).getResources(), R.drawable.browser_icon_recommend);
        }
        ((MenuItem)localObject1).setIcon(cd.a((Context)localObject3, this.w));
        continue;
        label535:
        if ((this.x != null) && (!this.x.isRecycled()) && (this.u)) {
          ((MenuItem)localObject1).setIcon(new BitmapDrawable(this.e.getResources(), this.x));
        } else {
          ((MenuItem)localObject1).setIcon(R.drawable.browser_icon_recommend);
        }
      }
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      this.h.a(false);
      this.r = 0;
      this.B.removeMessages(1);
      this.B.sendEmptyMessageDelayed(1, 30000L);
      this.i.a(false);
      this.j.setVisibility(0);
      localObject2 = c();
      localObject1 = b((String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.h.getSettings().setCacheMode(1);
        this.h.loadDataWithBaseURL((String)localObject2, (String)localObject1, "text/html", "utf-8", null);
        this.B.sendEmptyMessageDelayed(3, 500L);
        this.A.a = com.lantern.core.k.n(this.e);
        if (!"w".equals(this.A.a)) {
          break label245;
        }
        this.A.b = bp.c(this.e);
      }
      for (this.A.c = bp.d(this.e);; this.A.c = "")
      {
        this.B.removeMessages(6);
        this.B.sendEmptyMessageDelayed(6, 300000L);
        this.z.a = this.A.a;
        this.z.b = this.A.b;
        this.z.c = this.A.c;
        return;
        this.B.sendEmptyMessage(3);
        break;
        label245:
        this.A.b = "";
      }
    }
    c();
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>();
        if (paramInt != 1) {
          break label428;
        }
        ((JSONObject)localObject1).put("refresh", "manual");
        ((JSONObject)localObject1).put("netModel", this.A.a);
        ((JSONObject)localObject1).put("ssid", this.A.b);
        ((JSONObject)localObject1).put("bssid", this.A.c);
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("loadNews ");
        h.a(((JSONObject)localObject1).toString(), new Object[0]);
        WkBrowserWebView localWkBrowserWebView = this.h;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("androidInterface.moreLatestNews(");
        localWkBrowserWebView.a(((JSONObject)localObject1).toString() + ");");
        com.lantern.analytics.a.e().onEvent("drf1");
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
      break;
      label428:
      if (paramInt == 2) {
        localException.put("refresh", "timeout");
      }
    }
  }
  
  private RelativeLayout e()
  {
    if ((this.k == null) || (this.k.getParent() == null))
    {
      this.k = new RelativeLayout(this.e);
      this.k.setVisibility(4);
      Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      this.g.addView(this.k, 1, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.e);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.k.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new ImageView(this.e);
      ((ImageView)localObject3).setId(1048583);
      ((ImageView)localObject3).setImageResource(R.drawable.browser_error);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.e);
      ((TextView)localObject2).setId(1048584);
      ((TextView)localObject2).setText(R.string.browser_load_error_notice);
      ((TextView)localObject2).setTextSize(15.0F);
      ((TextView)localObject2).setTextColor(this.e.getResources().getColor(R.color.error_text));
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).topMargin = ((int)(3.0F * this.t));
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RelativeLayout.LayoutParams)localObject4).addRule(3, ((ImageView)localObject3).getId());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new Button(this.e);
      ((Button)localObject4).setText(R.string.browser_load_error_refresh);
      ((Button)localObject4).setTextSize(15.0F);
      ((Button)localObject4).setTextColor(this.e.getResources().getColor(R.color.error_text));
      ((Button)localObject4).setBackgroundResource(R.drawable.browser_button_solid);
      ((Button)localObject4).setPadding(0, 0, 0, 0);
      ((Button)localObject4).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams((int)(90.0F * this.t), (int)(30.0F * this.t));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(20.0F * this.t));
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((TextView)localObject2).getId());
      ((Button)localObject4).setOnClickListener(new f(this));
      ((RelativeLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
    }
    return this.k;
  }
  
  private void n()
  {
    if ((this.g.getChildCount() > 0) && (this.i.getVisibility() == 0))
    {
      this.i.setVisibility(4);
      e().setVisibility(0);
      com.lantern.analytics.a.e().onEvent("dloadfai");
    }
  }
  
  private void o()
  {
    if ((this.g.getChildCount() > 0) && (this.i.getVisibility() == 4))
    {
      this.i.setVisibility(0);
      e().setVisibility(4);
    }
  }
  
  public final void a(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt, String paramString) {}
  
  public final void a(Context paramContext)
  {
    d();
    this.B.sendEmptyMessage(5);
    if (((RedDotConf)com.lantern.core.config.d.a(this.e).a(RedDotConf.class)).e())
    {
      this.s = true;
      com.lantern.core.g.k.a().b(this.C);
      if (a(p.b(this.e)))
      {
        com.lantern.core.g.k.a().a(k.b.t);
        p.b(this.e, System.currentTimeMillis());
      }
      if (a(p.a(this.e)))
      {
        com.lantern.core.g.k.a().a(k.b.u);
        p.a(this.e, System.currentTimeMillis());
      }
    }
    com.lantern.analytics.a.e().onEvent("disin");
  }
  
  public final void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  public final void a(String paramString)
  {
    this.y.put(c(), paramString);
  }
  
  public final boolean a(WebView paramWebView, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new WkBrowserFeedFragment.3(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    h.a("shouldOverrideUrlLoading url:" + paramString, new Object[0]);
    if ((paramString.startsWith("http://wifi02.51y5.net/wifi/apromote.do")) || (paramString.startsWith("http://static.51y5.net/znews/content/feed")) || (paramString.startsWith("http://static.51y5.net/znews-cache/content/feed")) || (paramString.startsWith("http://apk.leisou.net/apromote.php")) || (paramString.startsWith("http://news.51y5.net/news")) || (paramString.startsWith("http://demo.o2o.lianwifi.com/")) || ((!TextUtils.isEmpty(this.o)) && (paramString.startsWith(this.o))))
    {
      paramWebView = bp.f(com.lantern.core.c.getInstance().getApplicationContext());
      if (paramString.contains("?"))
      {
        paramWebView = paramString + "&" + paramWebView;
        if (!this.p.contains(paramWebView)) {
          this.p.add(paramWebView);
        }
        this.h.loadUrl(paramWebView);
        this.B.removeMessages(1);
        this.B.sendEmptyMessageDelayed(1, 30000L);
      }
    }
    for (;;)
    {
      return true;
      paramWebView = paramString + "?" + paramWebView;
      break;
      if ((!bp.a(this.h, paramString)) && (isVisible())) {
        bp.c(paramWebView.getContext(), paramString);
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    com.lantern.analytics.a.e().onEvent("disout");
    if (this.s)
    {
      this.s = false;
      com.lantern.core.g.k.a().a(this.C);
    }
  }
  
  public final String c()
  {
    Object localObject;
    int i1;
    String str;
    if ((TextUtils.isEmpty(this.m)) || (this.m.startsWith("http://wifi02.51y5.net/wifi/apromote.do")) || (!TextUtils.isEmpty(this.o)))
    {
      this.p.clear();
      localObject = (LinkedForwardConf)com.lantern.core.config.d.a(com.lantern.core.c.getInstance().getApplicationContext()).a(LinkedForwardConf.class);
      this.l = ((LinkedForwardConf)localObject).e();
      if (!TextUtils.isEmpty(this.o))
      {
        this.m = this.o;
        if (TextUtils.isEmpty(this.m))
        {
          this.m = "http://wifi02.51y5.net/wifi/apromote.do";
          this.l = 2;
        }
        this.p.add(this.m);
      }
    }
    else
    {
      localObject = this.m;
      i1 = ((String)localObject).indexOf("?");
      if (!bp.d(com.lantern.core.c.getInstance().getApplicationContext(), (String)localObject)) {
        break label280;
      }
      str = "appid=" + com.lantern.core.c.getServer().k();
      if (i1 != -1) {
        break label252;
      }
      localObject = (String)localObject + "?" + str;
    }
    for (;;)
    {
      h.a("getNewsUrl url:" + (String)localObject + " mNewsUrl:" + this.m, new Object[0]);
      return (String)localObject;
      this.m = ((LinkedForwardConf)localObject).d();
      break;
      label252:
      localObject = (String)localObject + "&" + str;
      continue;
      label280:
      str = bp.f(com.lantern.core.c.getInstance().getApplicationContext());
      if (i1 == -1) {}
      for (str = (String)localObject + "?" + str;; str = (String)localObject + "&" + str)
      {
        if (str.contains("nativeComment")) {
          break label382;
        }
        localObject = str + "?nativeComment=true";
        break;
      }
      label382:
      localObject = str;
      if (str.contains("nativeComment=false"))
      {
        localObject = str.substring(0, str.indexOf("nativeComment=false"));
        str = str.substring(str.indexOf("nativeComment=false") + 19);
        localObject = (String)localObject + "nativeComment=true" + str;
      }
    }
  }
  
  public final void f()
  {
    new Handler(Looper.getMainLooper()).post(new e(this));
  }
  
  public final void g()
  {
    if (this.h != null) {
      this.h.a(true);
    }
  }
  
  public final void h() {}
  
  public final void i() {}
  
  public final void j() {}
  
  public final void k() {}
  
  public final void l() {}
  
  public final void m() {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.u = true;
    this.t = paramActivity.getResources().getDisplayMetrics().density;
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = new RelativeLayout(this.e);
    m.a().a(this.e);
    this.q = new a((byte)0);
    paramLayoutInflater = new IntentFilter();
    paramLayoutInflater.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramLayoutInflater.addAction("wifi.intent.action.BROWSER_FEED_TEST");
    if (com.lantern.core.c.isDebugable()) {
      paramLayoutInflater.addAction("wifi.intent.action.BROWSER_JS_INJECT");
    }
    this.e.registerReceiver(this.q, paramLayoutInflater);
    this.h = cb.a(this.e);
    this.h.a(this);
    this.h.a(this);
    new WkBrowserJsInterface();
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.i = new SwipeRefreshLayout(this.e);
    this.i.addView(this.h, paramLayoutInflater);
    this.i.a(new c((byte)0));
    this.g.addView(this.i, paramLayoutInflater);
    this.j = new MaterialProgressBar(this.e);
    this.j.setVisibility(4);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(14);
    paramLayoutInflater.topMargin = ((int)(8.0F * this.t));
    this.g.addView(this.j, paramLayoutInflater);
    this.B.sendEmptyMessageDelayed(4, 5000L);
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.u = false;
      this.e.unregisterReceiver(this.q);
      this.B.removeMessages(1);
      this.B.removeMessages(2);
      this.B.removeMessages(3);
      this.B.removeMessages(4);
      this.B.removeMessages(6);
      this.B.removeMessages(7);
      this.h.d();
      this.h = null;
      if ((this.v != null) && (!this.v.isRecycled()))
      {
        this.v.recycle();
        this.v = null;
      }
      if ((this.w != null) && (!this.w.isRecycled()))
      {
        this.w.recycle();
        this.w = null;
      }
      if ((this.x != null) && (!this.x.isRecycled()))
      {
        this.x.recycle();
        this.x = null;
      }
      this.g.removeAllViews();
      String str2 = c();
      String str1 = b(str2);
      if (!TextUtils.isEmpty(str1)) {
        bp.b(str2, str1);
      }
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
  
  public void onDetach()
  {
    super.onDetach();
    this.u = false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      try
      {
        d();
        com.lantern.core.g.k.a().b(k.b.t);
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("wifi.intent.action.APPSTORE_MAIN");
        localIntent.setPackage(this.e.getPackageName());
        this.e.startActivity(localIntent);
        com.lantern.analytics.a.e().onEvent("bbxin_d");
      }
      catch (Exception localException) {}
      continue;
      com.lantern.core.g.k.a().b(k.b.u);
      RecommendLinkConf localRecommendLinkConf = (RecommendLinkConf)com.lantern.core.config.d.a(this.e).a(RecommendLinkConf.class);
      bp.c(this.e, localRecommendLinkConf.d());
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (isVisible()) {
      this.B.sendEmptyMessage(5);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    h.a("onViewCreated", new Object[0]);
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    if (this.h == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      Object localObject1;
      switch (paramWebEvent.getType())
      {
      default: 
        break;
      case 0: 
        paramWebEvent = paramWebEvent.getData().toString();
        localObject2 = Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)");
        localObject1 = Pattern.compile("\\.(jpg|jpeg|gif|png|bmp)");
        localObject2 = ((Pattern)localObject2).matcher(paramWebEvent);
        if (((Pattern)localObject1).matcher(paramWebEvent).find())
        {
          this.B.removeMessages(1);
          this.j.setVisibility(4);
        }
        if (((Matcher)localObject2).find()) {
          this.h.j().a(this.h);
        }
        break;
      case 4: 
        o();
        break;
      case 5: 
        localObject2 = this.h.getTitle();
        localObject1 = paramWebEvent.getData().toString();
        h.a("onPageFinished title:" + (String)localObject2 + " url:" + paramWebEvent.getData(), new Object[0]);
        this.j.setVisibility(4);
        if (((String)localObject1).startsWith((String)this.p.get(this.p.size() - 1)))
        {
          this.B.removeMessages(1);
          com.lantern.analytics.a.e().onEvent("dloadsuc");
          this.h.loadUrl("javascript:WiFikey.getHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bp.g((String)localObject2))) {
          n();
        }
        break;
      case 1: 
        int i1 = ((Integer)paramWebEvent.getData()).intValue();
        if (i1 > this.r) {
          this.r = i1;
        }
        if (i1 > 10)
        {
          paramWebEvent = this.h.getTitle();
          if (!TextUtils.isEmpty(paramWebEvent))
          {
            h.a("onProgressChanged title:" + paramWebEvent, new Object[0]);
            if (bp.g(paramWebEvent)) {
              break label455;
            }
            o();
          }
        }
        while (i1 == 100)
        {
          h.a("onProgressChanged newProgress:" + i1, new Object[0]);
          this.B.removeMessages(1);
          this.j.setVisibility(4);
          this.h.loadUrl("javascript:WiFikey.getHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
          break;
          n();
        }
      case 3: 
        this.h.j().a(this.h);
        break;
      case 9: 
        h.a("onReceivedError " + paramWebEvent.getData().toString(), new Object[0]);
        break;
      case 300: 
        label455:
        if ("feedCompleted".equals(((Map)paramWebEvent.getData()).get("type"))) {
          this.i.a(false);
        }
        break;
      }
    }
  }
  
  private final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) {
          break label489;
        }
        if ((WkBrowserFeedFragment.a(WkBrowserFeedFragment.this) != null) && (WkBrowserFeedFragment.a(WkBrowserFeedFragment.this).i())) {
          break label42;
        }
      }
      for (;;)
      {
        return;
        label42:
        paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        h.a("extra_network_info:%s", new Object[] { paramContext });
        if (paramContext != null) {
          if (paramContext.isConnected())
          {
            if (paramContext.getType() == 1)
            {
              paramContext = new WkBrowserFeedFragment.b(WkBrowserFeedFragment.this, (byte)0);
              paramContext.a = "w";
              paramContext.b = bp.c(WkBrowserFeedFragment.n(WkBrowserFeedFragment.this));
              paramContext.c = bp.d(WkBrowserFeedFragment.o(WkBrowserFeedFragment.this));
              if (paramContext.b == null) {
                paramContext.b = "";
              }
              if (paramContext.c == null) {
                paramContext.c = "";
              }
              if ((!paramContext.a.equals(WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a)) || (!paramContext.b.equals(WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).b)) || (!paramContext.c.equals(WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).c)))
              {
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a = paramContext.a;
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).b = paramContext.b;
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).c = paramContext.c;
                WkBrowserFeedFragment.a(WkBrowserFeedFragment.this, 1);
                h.a("NETWORK_STATE_CHANGED_ACTION networkStateChanged w", new Object[0]);
              }
            }
            else if (paramContext.getType() == 0)
            {
              paramContext = new WkBrowserFeedFragment.b(WkBrowserFeedFragment.this, (byte)0);
              paramContext.a = "g";
              if (!paramContext.a.equals(WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a))
              {
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a = paramContext.a;
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).b = paramContext.b;
                WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).c = paramContext.c;
                WkBrowserFeedFragment.a(WkBrowserFeedFragment.this, 1);
                h.a("NETWORK_STATE_CHANGED_ACTION networkStateChanged g", new Object[0]);
              }
            }
          }
          else if ((paramContext.getState() == NetworkInfo.State.DISCONNECTED) && ("".equals(com.lantern.core.k.n(WkBrowserFeedFragment.q(WkBrowserFeedFragment.this)))) && (!"".equals(WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a)))
          {
            WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).a = "";
            WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).b = "";
            WkBrowserFeedFragment.p(WkBrowserFeedFragment.this).c = "";
            WkBrowserFeedFragment.a(WkBrowserFeedFragment.this, 1);
            h.a("NETWORK_STATE_CHANGED_ACTION networkStateChanged offline", new Object[0]);
            continue;
            label489:
            if ("wifi.intent.action.BROWSER_FEED_TEST".equals(paramContext))
            {
              paramContext = paramIntent.getStringExtra("feed_test");
              if ((TextUtils.isEmpty(paramContext)) || (!bp.a(paramContext)))
              {
                Toast.makeText(WkBrowserFeedFragment.r(WkBrowserFeedFragment.this), "请输入正确的地址", 0).show();
              }
              else
              {
                WkBrowserFeedFragment.c(WkBrowserFeedFragment.this, paramContext);
                Toast.makeText(WkBrowserFeedFragment.s(WkBrowserFeedFragment.this), "feed地址更新成功", 0).show();
              }
            }
            else if ("wifi.intent.action.BROWSER_JS_INJECT".equals(paramContext))
            {
              paramContext = paramIntent.getStringExtra("js_inject");
              if ((TextUtils.isEmpty(paramContext)) || (!bp.a(paramContext)))
              {
                Toast.makeText(WkBrowserFeedFragment.t(WkBrowserFeedFragment.this), "请输入正确的地址", 0).show();
              }
              else
              {
                WkBrowserFeedFragment.d(WkBrowserFeedFragment.this, paramContext);
                new Thread(new g(this, paramContext)).start();
              }
            }
          }
        }
      }
    }
  }
  
  private final class b
  {
    String a = "";
    String b = "";
    String c = "";
    
    private b() {}
  }
  
  private final class c
    implements SwipeRefreshLayout.a
  {
    private c() {}
    
    public final void a()
    {
      if (!WkBrowserFeedFragment.a(WkBrowserFeedFragment.this).i()) {
        WkBrowserFeedFragment.a(WkBrowserFeedFragment.this, 0);
      }
      for (;;)
      {
        return;
        switch (WkBrowserFeedFragment.v(WkBrowserFeedFragment.this))
        {
        default: 
          WkBrowserFeedFragment.a(WkBrowserFeedFragment.this, 0);
          break;
        case 1: 
        case 2: 
          WkBrowserFeedFragment.h(WkBrowserFeedFragment.this).removeMessages(6);
          WkBrowserFeedFragment.h(WkBrowserFeedFragment.this).sendEmptyMessageDelayed(6, 300000L);
          WkBrowserFeedFragment.h(WkBrowserFeedFragment.this).sendEmptyMessageDelayed(2, 15000L);
          try
          {
            JSONObject localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>();
            localJSONObject.put("refresh", "auto");
            localJSONObject.put("netModel", com.lantern.core.k.n(WkBrowserFeedFragment.w(WkBrowserFeedFragment.this)));
            localJSONObject.put("ssid", bp.a(WkBrowserFeedFragment.x(WkBrowserFeedFragment.this)));
            localJSONObject.put("bssid", bp.b(WkBrowserFeedFragment.y(WkBrowserFeedFragment.this)));
            WkBrowserWebView localWkBrowserWebView = WkBrowserFeedFragment.a(WkBrowserFeedFragment.this);
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("androidInterface.moreLatestNews(");
            localWkBrowserWebView.a(localJSONObject.toString() + ");");
            com.lantern.analytics.a.e().onEvent("drf1");
          }
          catch (Exception localException)
          {
            h.a(localException);
          }
        }
      }
    }
    
    public final void b()
    {
      h.a("onStart", new Object[0]);
      WkBrowserFeedFragment.c(WkBrowserFeedFragment.this).setVisibility(4);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */