package com.lantern.webox.authz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bluefay.app.ViewPagerFragment;
import bluefay.app.k.a;
import bluefay.app.u;
import bluefay.widget.BLCheckBox;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.cc;
import com.lantern.core.g.j;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.handler.ContentFetchHandler;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class AuthzFragment
  extends ViewPagerFragment
  implements cc, com.lantern.webox.event.c
{
  private TextView g;
  private View h;
  private ProgressBar i;
  private TranslateAnimation j;
  private View k;
  private RelativeLayout l;
  private WkBrowserWebView m;
  private TextView n;
  private k o;
  private l p;
  private m q;
  private boolean r = false;
  private com.lantern.webox.b.e s = new com.lantern.webox.b.e(getClass());
  
  private Menu a(boolean paramBoolean)
  {
    u localu = new u(this.e);
    if (paramBoolean) {}
    for (int i1 = R.string.browser_btn_done;; i1 = R.string.browser_btn_cancel)
    {
      localu.add(1001, 1001, 0, i1);
      return localu;
    }
  }
  
  private void c()
  {
    this.o.a(false);
    this.m.a(new WebEvent(this.m, 105));
    this.k.setBackgroundColor(Color.parseColor("#FF0285F0"));
    this.g.setText(R.string.webox_authz_start_tip);
    this.n.setText(17039360);
    this.h.setVisibility(0);
    this.h.startAnimation(this.j);
  }
  
  private void d()
  {
    this.o.a(true);
    this.m.a(new WebEvent(this.m, 105));
    this.k.setBackgroundColor(Color.parseColor("#FFCCCCCC"));
    this.g.setText(R.string.webox_authz_stop_tip);
    this.n.setText(R.string.webox_authz_start);
    this.j.cancel();
    this.h.setVisibility(4);
  }
  
  private boolean e()
  {
    boolean bool = false;
    WebBackForwardList localWebBackForwardList = this.m.copyBackForwardList();
    if (localWebBackForwardList == null) {}
    for (;;)
    {
      return bool;
      int i1 = localWebBackForwardList.getCurrentIndex();
      com.bluefay.b.h.a("canGoBack index:" + i1, new Object[0]);
      if (i1 > 2) {
        bool = true;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt, String paramString) {}
  
  public final void a(Context paramContext) {}
  
  public final void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  public final boolean a(WebView paramWebView, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new AuthzFragment.6(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    this.m.loadUrl(paramString);
    return true;
  }
  
  public final void b(Context paramContext) {}
  
  public final void f() {}
  
  public final void g() {}
  
  public final void h() {}
  
  public final void i() {}
  
  public final void j()
  {
    Activity localActivity = getActivity();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public final void k() {}
  
  public final void l() {}
  
  public final void m() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(false);
    this.q = new m();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.q.c = paramBundle.getString("ssid");
      this.q.d = paramBundle.getString("bssid");
      this.q.f = com.lantern.core.c.getServer().e();
      this.q.g = com.lantern.core.c.getServer().d();
      paramBundle = paramBundle.getString("ext");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {
        this.q.i = true;
      }
    }
    this.o = ((k)com.lantern.webox.d.a(k.class));
    this.o.a(false);
    this.o.a(getArguments());
    com.lantern.browser.m.a().a(this.e);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.webox_authz, paramViewGroup, false);
    this.l = ((RelativeLayout)paramLayoutInflater.findViewById(R.id.errorLayout));
    this.l.setVisibility(4);
    paramLayoutInflater.findViewById(R.id.reloadButton).setOnClickListener(new d(this));
    this.m = ((WkBrowserWebView)paramLayoutInflater.findViewById(R.id.webox));
    this.m.a(this);
    this.m.a(this);
    this.m.getSettings().setCacheMode(2);
    this.i = ((ProgressBar)paramLayoutInflater.findViewById(R.id.weboxprogress));
    new ContentFetchHandler(this.m);
    new f(this.m);
    this.p = new l(this.m);
    this.m.loadUrl(this.o.f() + "&time=" + System.currentTimeMillis());
    this.g = ((TextView)paramLayoutInflater.findViewById(R.id.notice));
    this.k = paramLayoutInflater.findViewById(R.id.statusBar);
    this.n = ((TextView)paramLayoutInflater.findViewById(R.id.modeButton));
    this.n.setOnClickListener(new e(this));
    this.h = paramLayoutInflater.findViewById(R.id.progressBar);
    paramViewGroup = getActivity().getWindow().getWindowManager().getDefaultDisplay();
    paramBundle = new DisplayMetrics();
    paramViewGroup.getMetrics(paramBundle);
    int i1 = paramBundle.widthPixels + 70;
    this.h.getLayoutParams().width = i1;
    this.j = new TranslateAnimation(-i1, 0.0F, 0.0F, 0.0F);
    this.j.setDuration(3200L);
    this.j.setRepeatCount(-1);
    this.j.setFillEnabled(false);
    paramViewGroup = this.k;
    if (this.o.b())
    {
      i1 = 0;
      paramViewGroup.setVisibility(i1);
      if (this.o.a(getActivity())) {
        break label396;
      }
      c();
    }
    for (;;)
    {
      return paramLayoutInflater;
      i1 = 8;
      break;
      label396:
      d();
      paramBundle = new k.a(getActivity());
      paramBundle.a(R.string.webox_authz_title);
      paramViewGroup = getActivity().getLayoutInflater().inflate(R.layout.webox_authz_confirm, null);
      BLCheckBox localBLCheckBox = (BLCheckBox)paramViewGroup.findViewById(R.id.confirm_checkbox);
      if (!this.o.a(getActivity())) {
        bool = true;
      }
      localBLCheckBox.setChecked(bool);
      localBLCheckBox.a(new a(this));
      paramBundle.a(paramViewGroup);
      paramBundle.a(17039370, new b(this));
      paramBundle.b(17039360, new c(this));
      paramBundle.d();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    new StringBuilder("[authz]onDestroy ").append(this);
    if (this.m != null) {
      this.m.d();
    }
    try
    {
      m localm = this.q;
      localm.b = System.currentTimeMillis();
      com.lantern.analytics.a.e().b("005017", localm.b());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.r)
    {
      Context localContext = this.e;
      Intent localIntent = new Intent();
      localIntent.setClassName("com.snda.wifilocating", "com.wifi.connect.service.MsgService");
      Message localMessage = Message.obtain();
      localMessage.what = 128100;
      localMessage.arg1 = 1;
      localMessage.arg2 = 1;
      localMessage.obj = null;
      Bundle localBundle = new Bundle();
      localBundle.putString("retmsg", "success");
      localBundle.putString("ssid", "");
      localBundle.putString("pkg", "com.wifi.connect.plugin.webauth");
      localMessage.setData(localBundle);
      localIntent.putExtra("msg", localMessage);
      localContext.getApplicationContext().startService(localIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (!this.r)
      {
        getActivity().setResult(1, getActivity().getIntent());
        this.q.a();
      }
      break;
    }
    for (;;)
    {
      a();
      boolean bool1 = super.onOptionsItemSelected(paramMenuItem);
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if (e())
        {
          this.m.goBack();
          bool1 = bool2;
          continue;
          if (e())
          {
            this.m.goBack();
            bool1 = bool2;
          }
          else
          {
            if (!this.r)
            {
              getActivity().setResult(1, getActivity().getIntent());
              this.q.a();
            }
            a();
            bool1 = bool2;
            continue;
            bool1 = bool2;
            if (this.m.canGoForward())
            {
              this.m.goForward();
              bool1 = bool2;
            }
          }
        }
      }
      com.lantern.analytics.a.e().onEvent("conbyweb5");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = b();
    if (paramView != null)
    {
      paramView.d(1);
      paramView.c(0);
      paramView.a();
      paramView.f(R.drawable.framework_title_bar_back_button_white);
      paramView.b(false);
      paramView.e(R.drawable.framework_title_bar_forward_button_white);
      paramView.a(false);
    }
    a(a, a(false));
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    int i1 = 1;
    if (paramWebEvent.getType() != 103)
    {
      if (paramWebEvent.getType() != 102) {
        break label35;
      }
      com.bluefay.b.h.a("auth error", new Object[0]);
      d();
    }
    for (;;)
    {
      return;
      label35:
      if (paramWebEvent.getType() == 101) {}
      try
      {
        paramWebEvent = new java/util/HashMap;
        paramWebEvent.<init>();
        paramWebEvent.put("ssid", bp.a(this.e));
        paramWebEvent.put("bssid", bp.b(this.e));
        Object localObject1 = com.lantern.analytics.a.e();
        Object localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramWebEvent);
        ((com.lantern.analytics.a)localObject1).onEvent("autoc1", ((JSONObject)localObject2).toString());
        this.r = true;
        paramWebEvent = this.q;
        if (paramWebEvent.i) {}
        for (paramWebEvent.h = 101;; paramWebEvent.h = 1)
        {
          com.lantern.core.h.a(1);
          getActivity().setResult(0);
          a(a, a(true));
          com.lantern.analytics.a.e().onEvent("conbyweb4");
          localObject2 = this.e;
          localObject1 = PreferenceManager.getDefaultSharedPreferences((Context)localObject2);
          paramWebEvent = ((SharedPreferences)localObject1).getString("httpauth_ssid", "");
          localObject1 = ((SharedPreferences)localObject1).getString("httpauth_bssid", "");
          localObject2 = j.b((Context)localObject2);
          if ((localObject2 == null) || (TextUtils.isEmpty(paramWebEvent)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!paramWebEvent.equals(((WkAccessPoint)localObject2).a)) || (!((String)localObject1).equals(((WkAccessPoint)localObject2).b))) {
            break label670;
          }
          if (i1 == 0) {
            break;
          }
          com.lantern.analytics.a.e().onEvent("http_wc");
          break;
        }
        if (paramWebEvent.getType() == 9)
        {
          paramWebEvent = (String)((HashMap)paramWebEvent.getData()).get("failingUrl");
          if (Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)").matcher(paramWebEvent).find()) {
            com.bluefay.b.h.a("onReceivedError ignore this error", new Object[0]);
          }
          if ((paramWebEvent.startsWith("http://")) || (paramWebEvent.startsWith("https://")) || (paramWebEvent.startsWith("file://")))
          {
            this.m.setVisibility(4);
            this.l.setVisibility(0);
            this.i.setVisibility(4);
            a(a, a(false));
            continue;
          }
          com.bluefay.b.h.a("onReceivedError ignore this error", new Object[0]);
          continue;
        }
        if (paramWebEvent.getType() == 1)
        {
          i1 = ((Integer)paramWebEvent.getData()).intValue();
          this.i.setProgress(i1);
          if (i1 == 100)
          {
            this.i.setVisibility(4);
            this.p.a();
            continue;
          }
          if (i1 <= 10) {
            continue;
          }
          paramWebEvent = this.m.getTitle();
          this.q.e = this.m.getUrl();
          if (TextUtils.isEmpty(paramWebEvent)) {
            continue;
          }
          if (!bp.g(paramWebEvent))
          {
            this.m.setVisibility(0);
            this.l.setVisibility(4);
            continue;
          }
          this.m.setVisibility(4);
          this.l.setVisibility(0);
          a(a, a(false));
          continue;
        }
        if (paramWebEvent.getType() == 5)
        {
          this.i.setVisibility(4);
          this.p.a();
          continue;
        }
        if (paramWebEvent.getType() == 4)
        {
          this.i.setVisibility(0);
          continue;
        }
        if (paramWebEvent.getType() != 11) {
          continue;
        }
        paramWebEvent = b();
        if (paramWebEvent == null) {
          continue;
        }
        if (e()) {
          paramWebEvent.b(true);
        }
        for (;;)
        {
          if (!this.m.canGoForward()) {
            break label658;
          }
          paramWebEvent.a(true);
          break;
          paramWebEvent.b(false);
        }
        label658:
        paramWebEvent.a(false);
      }
      catch (Exception paramWebEvent)
      {
        for (;;)
        {
          continue;
          label670:
          i1 = 0;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/AuthzFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */