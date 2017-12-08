package com.lantern.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import bluefay.app.k;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.browser.comment.ui.WkCommentToolBar;
import com.lantern.browser.ui.WkBrowserAppDetailFragment;
import com.lantern.browser.ui.WkBrowserAppStoreFragment;
import com.lantern.browser.ui.WkBrowserFragment;
import com.lantern.browser.ui.WkDetailBottomLayout;
import com.lantern.browser.ui.WkDetailContentLayout;
import com.lantern.core.config.d;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class at
  extends FrameLayout
{
  private RelativeLayout a;
  private Animation b;
  private ImageView c;
  private ProgressBar d;
  private bn e;
  private WkDetailContentLayout f;
  private RelativeLayout g;
  private WkCommentToolBar h;
  private Context i;
  private String j;
  private WkBrowserFragment k;
  private bg l = new bg();
  private bo m;
  private bd.a n;
  private int o = 0;
  private int p = 0;
  private k q;
  private String r;
  private com.lantern.browser.comment.c.a s;
  private int t = 1000;
  private int u = 15000;
  private int v = 30000;
  private String w = null;
  private int x = 0;
  private Handler y = new au(this);
  
  public at(WkBrowserFragment paramWkBrowserFragment, bg parambg)
  {
    super(paramWkBrowserFragment.h());
    this.k = paramWkBrowserFragment;
    this.i = paramWkBrowserFragment.h();
    this.l = parambg;
    this.e = new bn(this);
    this.s = new com.lantern.browser.comment.c.a(this.i);
    this.m = new bo(this.k.getActivity());
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    inflate(this.i, R.layout.browser_main_view, this);
    this.h = ((WkCommentToolBar)findViewById(R.id.browser_comment_toolbar));
    this.h.a(this.s.d());
    this.s.a(this.h);
    this.g = ((RelativeLayout)findViewById(R.id.browser_error_layout));
    ((Button)findViewById(R.id.browser_error_btn)).setOnClickListener(new av(this));
    this.a = ((RelativeLayout)findViewById(R.id.shimmer_logo));
    this.b = AnimationUtils.loadAnimation(this.i, R.anim.logo_anim);
    this.c = ((ImageView)findViewById(R.id.lighting_effect));
    y();
    this.f = ((WkDetailContentLayout)findViewById(R.id.browser_content));
    paramWkBrowserFragment = this.f.b();
    paramWkBrowserFragment.a(this.s.c());
    this.s.a(paramWkBrowserFragment);
    this.d = ((ProgressBar)findViewById(R.id.browser_progressbar));
    this.s.a(this);
    this.e.a(this.k.getActivity());
    this.n = new aw(this);
    bd.a(this.d, this.n);
    this.r = getResources().getString(R.string.browser_loading_title);
    if (!this.l.a()) {
      z().setDownloadListener(null);
    }
    paramWkBrowserFragment = d.a(this.i).a("errpage");
    if (paramWkBrowserFragment != null)
    {
      this.w = paramWkBrowserFragment.optString("url", this.w);
      this.t = paramWkBrowserFragment.optInt("rm_timeout", this.t);
      this.u = paramWkBrowserFragment.optInt("timeout_w", this.u);
      this.v = paramWkBrowserFragment.optInt("timeout_g", this.v);
    }
  }
  
  private int A()
  {
    WebBackForwardList localWebBackForwardList = z().copyBackForwardList();
    if ((localWebBackForwardList == null) || (localWebBackForwardList.getSize() <= 1))
    {
      i1 = -1;
      return i1;
    }
    String str = localWebBackForwardList.getCurrentItem().getUrl();
    int i1 = localWebBackForwardList.getCurrentIndex();
    int i2 = localWebBackForwardList.getCurrentIndex() - 1;
    label50:
    if (i2 >= 0) {
      if (str.equals(localWebBackForwardList.getItemAtIndex(i2).getUrl())) {}
    }
    for (;;)
    {
      i1 = i2;
      if (i2 != localWebBackForwardList.getCurrentIndex()) {
        break;
      }
      i1 = -1;
      break;
      i2--;
      break label50;
      i2 = i1;
    }
  }
  
  private boolean B()
  {
    at localat = null;
    bh localbh;
    if (this.e != null)
    {
      localbh = this.e.b();
      if (localbh != null) {
        localat = localbh.b();
      }
      if ((this.e != null) && (localbh != null) && (localat != null)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localbh = null;
      break;
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    h.a("showErrorPage aErrorCode::" + paramInt1 + " url:" + paramString1, new Object[0]);
    if (x()) {}
    for (;;)
    {
      return;
      this.x = 1;
      String str = this.w;
      if ((bp.b()) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString1)) && (!paramString1.startsWith(str)))
      {
        if (str.indexOf("?") == -1) {}
        for (str = str + "?url=" + URLEncoder.encode(paramString1);; str = str + "&url=" + URLEncoder.encode(paramString1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("url", paramString1);
          localHashMap.put("reason", paramString2);
          if ("timeout".equals(paramString2)) {
            localHashMap.put("rate", String.valueOf(paramInt2));
          }
          com.lantern.analytics.a.e().onEvent("broerrpv", new JSONObject(localHashMap).toString());
          c(str);
          break;
        }
      }
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      if (this.f.getVisibility() != 4)
      {
        this.f.setVisibility(4);
        this.y.removeMessages(1);
        if ((this.k instanceof WkBrowserAppStoreFragment)) {
          com.lantern.analytics.a.e().onEvent("bload0");
        } else if ((this.k instanceof WkBrowserAppDetailFragment)) {
          com.lantern.analytics.a.e().onEvent("bdload0");
        }
      }
    }
  }
  
  private boolean d(String paramString)
  {
    if ((!TextUtils.isEmpty(this.w)) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith(this.w))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean x()
  {
    if ((this.g != null) && (this.g.getVisibility() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void y()
  {
    if (!x())
    {
      this.a.setVisibility(0);
      this.c.startAnimation(this.b);
    }
  }
  
  private WkBrowserWebView z()
  {
    return this.e.b().a();
  }
  
  public final void a(int paramInt)
  {
    if (B()) {}
    for (;;)
    {
      return;
      h.a("progress:" + paramInt);
      this.o = paramInt;
      this.d.setProgress(Math.max(this.p, this.o));
      if (paramInt >= this.t) {
        this.y.removeMessages(1);
      }
      if (paramInt == 100)
      {
        this.d.setVisibility(4);
        this.y.removeMessages(1);
        bd.b();
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    WkDetailContentLayout localWkDetailContentLayout = this.f;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      localWkDetailContentLayout.scrollTo(0, 0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      n().a(paramInt1, paramInt2, paramIntent);
      continue;
      if (paramIntent != null)
      {
        String str = paramIntent.getStringExtra("callback");
        paramIntent = paramIntent.getStringExtra("param");
        if (!TextUtils.isEmpty(str)) {
          if (TextUtils.isEmpty(paramIntent)) {
            c("javascript:" + str + "();");
          } else {
            c("javascript:" + str + "('" + paramIntent + "');");
          }
        }
      }
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    this.j = paramString;
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 7) || (paramInt == 1) || (paramInt == 6) || (paramInt == 8))
    {
      localArrayList.add(getResources().getString(R.string.browser_pop_open_link));
      localArrayList.add(getResources().getString(R.string.browser_pop_copy_link));
    }
    for (;;)
    {
      paramString = new k.a(r());
      Object localObject = (FrameLayout)r().getLayoutInflater().inflate(R.layout.browser_popmenu, null, false);
      paramString.a((View)localObject);
      ListView localListView = (ListView)((FrameLayout)localObject).findViewById(R.id.popmenu_list);
      localObject = new bc(getContext(), localArrayList);
      localListView.setAdapter((ListAdapter)localObject);
      ((bc)localObject).notifyDataSetChanged();
      if (localArrayList.size() > 0)
      {
        this.q = paramString.d();
        localListView.setOnItemClickListener(new ax(this, localArrayList));
      }
      return;
      if (paramInt == 5)
      {
        localArrayList.add(getResources().getString(R.string.browser_pop_favorite));
        localArrayList.add(getResources().getString(R.string.browser_pop_save));
      }
    }
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    h.a("onReceivedError failingUrl:" + paramString2 + " errorCode:" + paramInt, new Object[0]);
    h.a("onReceivedError showErrorPage", new Object[0]);
    a(paramInt, paramString2, paramString1, -1);
  }
  
  public final void a(View paramView)
  {
    ((WkBrowserWebView)paramView).a(this);
    this.f.a(paramView);
  }
  
  public final void a(String paramString)
  {
    y();
    bd.a();
    this.o = 0;
    b(this.r);
    this.x = 0;
    this.y.removeMessages(1);
    Handler localHandler = this.y;
    int i1;
    if (e.c(this.i)) {
      if (e.b(this.i))
      {
        i1 = this.v;
        localHandler.sendEmptyMessageDelayed(1, i1);
        if ((!paramString.startsWith("http://c.wkanx.com/s?url=")) && (!paramString.endsWith(".apk")))
        {
          this.f.scrollTo(0, 0);
          if (this.s != null)
          {
            h.a("getNewsId " + paramString, new Object[0]);
            paramString = Uri.parse(paramString).getQueryParameter("newsId");
            h.a("getNewsId newsId:" + paramString, new Object[0]);
            if (TextUtils.isEmpty(paramString)) {
              break label197;
            }
            this.s.a(paramString);
          }
        }
      }
    }
    for (;;)
    {
      return;
      i1 = this.u;
      break;
      i1 = 15000;
      break;
      label197:
      this.s.a();
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString2);
    localHashMap.put("nm", bp.h(this.i));
    com.lantern.analytics.a.e().onEvent("broerrcd_" + paramString1, new JSONObject(localHashMap).toString());
    bp.a(this.i, paramString2, paramString1);
    a(0, paramString2, paramString1, -1);
  }
  
  public final boolean a()
  {
    if ((x()) || (d(l()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    int i3 = 300;
    int i2 = 100;
    boolean bool;
    if (((paramInt == 0) || (paramInt == 1) || (paramInt == 2)) && (!WkWeiXinUtil.isWXAppInstalledAndSupported()))
    {
      Toast.makeText(this.i, R.string.browser_weixin_tips, 0).show();
      bool = false;
      return bool;
    }
    if (!a())
    {
      String str = z().getTitle();
      if ((this.o > 25) && (!TextUtils.isEmpty(str)))
      {
        i1 = 1;
        label84:
        if (i1 != 1) {
          break label149;
        }
        if (paramInt != 100) {
          break label176;
        }
      }
    }
    for (int i1 = 100;; i1 = i3)
    {
      c(String.format("javascript:(function(win,undefined){var doc=document;var all=function(sel){return doc.querySelectorAll(sel)};var one=function(sel){return doc.querySelector(sel)};var getDesc=function(){var els=all(\"div, article\");var $content;var content=\"\";for(var i=0,len=els.length;i<els.length;i++){if(new RegExp(\"content\").test(els[i].id+\"-\"+els[i].className)){$content=els[i];i=len}}if($content){content=$content.innerText.replace(/(\\s*)/g,\"\").substring(0,88)}return content};var getImg=function(){var imgs=all(\"img\");var thumb=\"\";for(var i=0,len=imgs.length;i<imgs.length;i++){if(imgs[i].naturalHeight>=%d&&imgs[i].naturalWidth>=%d){thumb=imgs[i].src;i=len}}return thumb};var arr=[\"url\",\"type\",\"title\",\"description\",\"image\"];var data={};for(var i=0;i<arr.length;i++){var key=arr[i];if(one('meta[property=\"og:'+key+'\"]')){var val=one('meta[property=\"og:'+key+'\"]').getAttribute(\"content\");data[key]=val}else{if(key===\"url\"){data[key]=location.href}else{if(key===\"type\"){data[key]=\"news\"}else{if(key===\"title\"){data[key]=document.title}else{if(key===\"description\"){data[key]=getDesc()}else{if(key===\"image\"){data[key]=getImg()}}}}}}}var str=JSON.stringify(data);WiFikey.shareToWeixinCallback(str, \"%s\", %d)})(window);", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), paramString, Integer.valueOf(paramInt) }));
      for (;;)
      {
        bool = true;
        break;
        i1 = 0;
        break label84;
        label149:
        new Thread(new ay(this, z(), paramInt, paramString)).start();
      }
      label176:
      i2 = 300;
    }
  }
  
  public final ProgressBar b()
  {
    return this.d;
  }
  
  public final void b(View paramView)
  {
    this.f.b(paramView);
    if (this.k != null) {
      this.k.getActivity().finish();
    }
  }
  
  public final void b(String paramString)
  {
    if (this.k != null)
    {
      this.k.c(paramString);
      if (!bp.g(paramString)) {
        break label34;
      }
      a(0, l(), paramString, -1);
    }
    for (;;)
    {
      return;
      label34:
      if (this.x == 0)
      {
        if (this.f.getVisibility() != 0) {
          this.f.setVisibility(0);
        }
        if (this.g.getVisibility() != 4) {
          this.g.setVisibility(4);
        }
      }
    }
  }
  
  public final void c()
  {
    if (this.a.getVisibility() != 8)
    {
      this.c.clearAnimation();
      this.a.setVisibility(8);
      b(m());
    }
  }
  
  public final void c(String paramString)
  {
    z().loadUrl(paramString);
  }
  
  public final void d()
  {
    c();
    this.d.setVisibility(4);
  }
  
  public final void e()
  {
    Object localObject = this.e.b();
    int i1 = A();
    if (i1 >= 0)
    {
      h.a("onClickGoBack goBack", new Object[0]);
      localObject = z().copyBackForwardList();
      z().goBackOrForward(i1 - ((WebBackForwardList)localObject).getCurrentIndex());
    }
    for (;;)
    {
      return;
      if (this.e.a().size() > 1)
      {
        h.a("onClickGoBack closeTabWindow", new Object[0]);
        this.e.a((bh)localObject);
      }
      else
      {
        h.a("onClickGoBack finish", new Object[0]);
        r().finish();
      }
    }
  }
  
  public final void f()
  {
    p();
  }
  
  public final void g()
  {
    bh localbh = this.e.b();
    if (this.e.a().size() > 1) {
      this.e.a(localbh);
    }
    for (;;)
    {
      return;
      if (this.k != null) {
        this.k.getActivity().finish();
      }
    }
  }
  
  public final bn h()
  {
    return this.e;
  }
  
  public final bg i()
  {
    return this.l;
  }
  
  public final void j()
  {
    removeAllViews();
    this.y.removeMessages(1);
    this.e.c();
    this.e = null;
    this.k = null;
    if (this.q != null)
    {
      this.q.hide();
      this.q.dismiss();
      this.q = null;
    }
    this.s.b();
  }
  
  public final void k()
  {
    this.f.a();
    this.e.d();
  }
  
  public final String l()
  {
    if (B()) {}
    for (String str = "";; str = this.e.b().d()) {
      return str;
    }
  }
  
  public final String m()
  {
    return this.e.b().c();
  }
  
  public final bo n()
  {
    if (this.m == null) {
      this.m = new bo(this.i);
    }
    return this.m;
  }
  
  public final void o()
  {
    bd.b();
    this.y.removeMessages(1);
    this.d.setVisibility(4);
    c();
    if (!a())
    {
      if (!(this.k instanceof WkBrowserAppStoreFragment)) {
        break label48;
      }
      c("javascript:WiFikey.getBbxHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
    }
    for (;;)
    {
      return;
      label48:
      if ((this.k instanceof WkBrowserAppDetailFragment)) {
        c("javascript:WiFikey.getBbxDetailHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
      }
    }
  }
  
  public final void p()
  {
    WkBrowserWebView localWkBrowserWebView = z();
    String str = localWkBrowserWebView.getUrl();
    if ((!TextUtils.isEmpty(str)) && (!d(str))) {
      localWkBrowserWebView.reload();
    }
    for (;;)
    {
      return;
      e();
    }
  }
  
  public final WkBrowserFragment q()
  {
    return this.k;
  }
  
  public final Activity r()
  {
    Activity localActivity1 = null;
    if (this.k != null) {
      localActivity1 = this.k.getActivity();
    }
    Activity localActivity2 = localActivity1;
    if (localActivity1 == null)
    {
      localActivity2 = localActivity1;
      if ((this.i instanceof Activity)) {
        localActivity2 = (Activity)this.i;
      }
    }
    return localActivity2;
  }
  
  public final void s()
  {
    if ((this.e != null) && (this.e.b() != null) && (z() != null)) {
      z().onResume();
    }
  }
  
  public final void t()
  {
    try
    {
      ((InputMethodManager)this.i.getSystemService("input_method")).hideSoftInputFromWindow(this.e.b().b().getWindowToken(), 0);
      if ((this.e != null) && (this.e.b() != null) && (z() != null)) {
        z().onPause();
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
  
  public final void u()
  {
    this.y.removeMessages(1);
  }
  
  public final void v()
  {
    WkBrowserFragment localWkBrowserFragment;
    if (this.k != null)
    {
      localWkBrowserFragment = this.k;
      if (A() < 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      localWkBrowserFragment.a(bool);
      return;
    }
  }
  
  public final void w()
  {
    this.f.c();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */