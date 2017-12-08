package com.lantern.browser.comment.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import com.bluefay.b.h;
import com.lantern.browser.at;
import com.lantern.browser.comment.b.b.a;
import com.lantern.browser.comment.b.g;
import com.lantern.browser.comment.b.g.a;
import com.lantern.browser.comment.e.i;
import com.lantern.browser.comment.ui.WkCommentToolBar;
import com.lantern.browser.ui.WkDetailBottomLayout;
import com.lantern.browser.ui.j.a;
import com.lantern.core.f;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private Context a;
  private HandlerThread b;
  private Handler c;
  private Handler d;
  private WkDetailBottomLayout e;
  private WkCommentToolBar f;
  private at g;
  private com.lantern.browser.comment.b.b h;
  private g i;
  private FrameLayout.LayoutParams j;
  private String k;
  private boolean l = false;
  private int m;
  private b n;
  private a o;
  private String p;
  private com.bluefay.d.b q;
  private com.bluefay.d.b r;
  private List<String> s;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HandlerThread("comment");
    this.b.start();
    this.c = new Handler(this.b.getLooper(), new b(this));
    this.d = new Handler(Looper.getMainLooper(), new c(this));
    this.r = new d(this, new int[] { 128300 });
    com.lantern.core.c.addListener(this.r);
    this.n = new e(this);
    this.o = new l(this);
    this.j = new FrameLayout.LayoutParams(-1, -2);
    this.j.gravity = 80;
    this.h = new com.lantern.browser.comment.b.b(this.a);
    this.h.a(this.n);
    this.h.setOnDismissListener(new m(this));
    this.i = new g(this.a);
    this.i.a(this.n);
  }
  
  private void a(int paramInt, String paramString)
  {
    try
    {
      if (this.c != null) {
        if (this.b.getLooper() != null)
        {
          Message localMessage = this.c.obtainMessage(paramInt);
          a(localMessage, paramString);
          localMessage.sendToTarget();
        }
      }
      for (;;)
      {
        return;
        h.a("comment thread handler is null");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  private static void a(Message paramMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("NEWS_ID", paramString);
    paramMessage.setData(localBundle);
  }
  
  private static List<com.lantern.browser.comment.d.n> c(String paramString)
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("newsId", paramString);
    paramString = f.a().a("cdshost");
    if (paramString != null)
    {
      paramString = String.format("%s%s", new Object[] { paramString, "/relate.do" });
      paramString = com.bluefay.b.d.a(paramString, (Map)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString);
        if (((JSONObject)localObject1).optInt("retCd") != 0) {
          break label254;
        }
        localJSONArray = ((JSONObject)localObject1).optJSONArray("result");
        if (localJSONArray != null)
        {
          i1 = localJSONArray.length();
          if (i1 <= 0) {
            break label254;
          }
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>();
          i2 = 0;
          paramString = (String)localObject1;
          if (i2 >= i1) {
            break label242;
          }
        }
      }
      catch (Exception localException1)
      {
        JSONArray localJSONArray;
        int i1;
        int i2;
        Object localObject3;
        paramString = null;
      }
      try
      {
        localObject3 = localJSONArray.optJSONObject(i2);
        if (localObject3 != null)
        {
          com.lantern.browser.comment.d.n localn = new com/lantern/browser/comment/d/n;
          localn.<init>();
          paramString = ((JSONObject)localObject3).optString("id");
          String str = ((JSONObject)localObject3).optString("title");
          localObject3 = ((JSONObject)localObject3).optString("url");
          localn.a(paramString);
          localn.b(str);
          localn.c((String)localObject3);
          ((List)localObject1).add(localn);
        }
        i2++;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramString = localException1;
          localObject2 = localException2;
        }
      }
      paramString = String.format("%s%s", new Object[] { "https://cds.51y5.net", "/relate.do" });
      break;
      i1 = 0;
    }
    h.a(localException1);
    for (;;)
    {
      label242:
      return paramString;
      Object localObject2;
      label254:
      paramString = null;
    }
  }
  
  private int d(String paramString)
  {
    int i1 = 0;
    if (!paramString.equals(this.k)) {
      return i1;
    }
    Object localObject = com.lantern.core.c.getServer().s();
    ((HashMap)localObject).put("newsId", paramString);
    paramString = f.b();
    if (paramString != null)
    {
      paramString = String.format("%s%s", new Object[] { paramString, "/comment/news/qryCommentCount.do" });
      label60:
      paramString = com.bluefay.b.d.a(paramString, (Map)localObject);
    }
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        if (((JSONObject)localObject).optInt("retCd") != 0) {
          break label157;
        }
        i1 = ((JSONObject)localObject).optInt("count");
      }
      catch (JSONException paramString)
      {
        boolean bool;
        i1 = -1;
        paramString.printStackTrace();
      }
      try
      {
        bool = ((JSONObject)localObject).optBoolean("cmt", true);
        if (bool) {
          break;
        }
        i1 = -2;
      }
      catch (JSONException paramString)
      {
        continue;
      }
      paramString = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/news/qryCommentCount.do" });
      break label60;
      break;
      label157:
      i1 = -1;
    }
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.k)) {}
    for (;;)
    {
      return;
      Object localObject = new HashMap();
      ((Map)localObject).put("newsId", this.k);
      com.lantern.analytics.a.e().onEvent("ddhotcli", new JSONObject((Map)localObject).toString());
      Intent localIntent = new Intent("wifi.intent.action.COMMENT_DETAIL");
      localIntent.setPackage(this.a.getPackageName());
      localIntent.putExtra("NEWS_ID", this.k);
      String str;
      if (this.g != null)
      {
        localObject = this.g.l();
        str = com.lantern.browser.c.b.b((String)localObject, "replySequence");
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        localIntent.putExtra("NEWS_REPLY_COMMENT_SEQUNCE", Integer.parseInt(str));
        localIntent.putExtra("NEWS_TITLE", this.g.m());
        localIntent.putExtra("NEWS_URL", (String)localObject);
        this.a.startActivity(localIntent);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          h.a(localNumberFormatException);
        }
      }
    }
  }
  
  private void f()
  {
    if ((this.f != null) && (this.f.getVisibility() != 8)) {
      this.f.setVisibility(8);
    }
    g();
  }
  
  private void g()
  {
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public final void a()
  {
    this.k = "";
    f();
  }
  
  public final void a(at paramat)
  {
    this.g = paramat;
  }
  
  public final void a(WkCommentToolBar paramWkCommentToolBar)
  {
    this.f = paramWkCommentToolBar;
    if (this.f != null) {
      this.f.a(this.o);
    }
  }
  
  public final void a(WkDetailBottomLayout paramWkDetailBottomLayout)
  {
    this.e = paramWkDetailBottomLayout;
    if (this.e != null) {
      this.e.a(this.n);
    }
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    if ((!paramString.equals(this.k)) || (!this.l))
    {
      this.k = paramString;
      this.l = true;
      this.f.a(0);
      g();
      Object localObject = this.g.l();
      paramString = this.k;
      if (("true".equals(com.lantern.browser.c.b.b((String)localObject, "tcmt"))) && (!TextUtils.isEmpty(paramString)) && ((this.s == null) || (this.s.isEmpty()) || (!this.s.contains(paramString))))
      {
        if (this.s == null) {
          this.s = new ArrayList();
        }
        this.s.add(paramString);
        if ((this.a instanceof Activity))
        {
          localObject = ((Activity)this.a).getIntent();
          paramString = null;
          if (localObject != null) {
            paramString = ((Intent)localObject).getStringExtra("from");
          }
          if (!"mailbox_list".equals(paramString)) {
            break label244;
          }
          com.lantern.analytics.a.e().onEvent("msgcli");
        }
      }
    }
    for (;;)
    {
      e();
      a(2, this.k);
      a(5, this.k);
      if (!com.bluefay.a.e.c(this.a)) {
        break;
      }
      com.lantern.browser.comment.e.j.a().b();
      break;
      break;
      label244:
      if ("mailbox_push".equals(paramString)) {
        com.lantern.analytics.a.e().onEvent("msgpcli");
      }
    }
  }
  
  public final void b()
  {
    this.b.quit();
    if (this.q != null) {
      com.lantern.core.c.removeListener(this.q);
    }
    com.lantern.core.c.removeListener(this.r);
    com.lantern.browser.comment.f.b.a().b();
  }
  
  public final void b(String paramString)
  {
    this.h.dismiss();
    this.h.a();
    String str1;
    String str2;
    if (this.g != null)
    {
      str1 = this.g.l();
      str2 = this.g.m();
    }
    for (;;)
    {
      com.lantern.browser.comment.d.j localj = new com.lantern.browser.comment.d.j();
      localj.f(p.e(this.a));
      localj.b(paramString);
      localj.e(p.b(null));
      localj.d(p.c(null));
      localj.c(p.d(this.a));
      localj.d(-1);
      localj.a(System.currentTimeMillis());
      new i(this.k, str2, str1, localj, new n(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
      str2 = null;
      str1 = null;
    }
  }
  
  public final b c()
  {
    return this.n;
  }
  
  public final a d()
  {
    return this.o;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
  
  public abstract class b
    implements b.a, g.a, j.a
  {
    public b() {}
    
    public abstract void b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */