package com.lantern.feed.channel.a;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.feed.a.m;
import com.lantern.feed.b.f;
import com.lantern.feed.b.i;
import com.lantern.feed.b.j;
import com.lantern.feed.b.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

public final class a
{
  private static a a;
  private HandlerThread b;
  private HandlerThread c;
  private Handler d;
  private Handler e;
  private Handler f;
  private com.lantern.feed.b.e g = new com.lantern.feed.b.e();
  private com.lantern.feed.b.g h = new com.lantern.feed.b.g();
  private a i;
  private String j;
  private String k;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private long o;
  private f p = new f(this.g);
  
  private a()
  {
    this.h.b(1);
    this.b = new HandlerThread("feedchannel");
    this.b.start();
    this.j = UUID.randomUUID().toString().replace("-", "");
    this.e = new Handler(this.b.getLooper(), new b(this));
    this.f = new Handler(Looper.getMainLooper(), new c(this));
    this.c = new HandlerThread("feedchanneldc");
    this.c.setPriority(10);
    this.c.start();
    this.d = new Handler(this.c.getLooper(), new d(this));
  }
  
  private int a(int paramInt)
  {
    int i1 = 1;
    if (paramInt == 0) {}
    for (;;)
    {
      return i1;
      if (paramInt == 1)
      {
        paramInt = this.g.a() - 1;
        if (paramInt == 0) {
          i1 = -1;
        } else if (paramInt != -1) {
          i1 = paramInt;
        }
      }
      else if (paramInt == 2)
      {
        i1 = this.g.b() + 1;
      }
    }
  }
  
  private Message a(int paramInt1, int paramInt2, String paramString)
  {
    h.a("processNewsData aType:" + paramInt1 + " aPageNo:" + paramInt2, new Object[0]);
    paramString = j.a(paramString);
    paramString.a(paramInt2);
    Object localObject = paramString.a();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.g.a(paramString.c());
    }
    h.a("processNewsData aType:" + paramInt1 + " aPageNo:" + paramString.d(), new Object[0]);
    List localList = paramString.a();
    localObject = new Message();
    ((Message)localObject).what = 7;
    ((Message)localObject).arg1 = paramInt1;
    if ((localList != null) && (localList.size() > 0))
    {
      paramInt1 = localList.size();
      h.a("processNewsData count:" + paramInt1, new Object[0]);
      ((Message)localObject).arg2 = paramInt1;
      ((Message)localObject).obj = paramString;
      localList = this.g.d();
      if ((localList == null) || (localList.size() == 0))
      {
        h.a("processNewsData convert to refresh", new Object[0]);
        ((Message)localObject).arg1 = 0;
      }
      if ((paramString.b() != null) && (paramString.b().size() > 0))
      {
        h.a("processNewsData find delete ids", new Object[0]);
        this.f.obtainMessage(33, paramString.b()).sendToTarget();
      }
      if (((Message)localObject).arg2 > 0)
      {
        if (((Message)localObject).arg1 != 0) {
          break label331;
        }
        this.g.a(1);
        this.g.b(1);
      }
    }
    for (;;)
    {
      return (Message)localObject;
      h.a("processNewsData failed", new Object[0]);
      ((Message)localObject).arg2 = 0;
      break;
      label331:
      if (((Message)localObject).arg1 == 2)
      {
        paramInt1 = paramString.d();
        this.g.b(paramInt1);
        if (paramInt1 == 1) {
          this.g.a(paramInt1);
        }
      }
      else if (((Message)localObject).arg1 == 1)
      {
        paramInt1 = paramString.d();
        this.g.a(paramInt1);
        if (paramInt1 == 1) {
          this.g.b(paramInt1);
        }
      }
    }
  }
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private HashMap<String, String> a(int paramInt, JSONObject paramJSONObject)
  {
    h.a("start buildFeedNewsUrlParams", new Object[0]);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appInfo", com.lantern.feed.d.d.a(com.lantern.core.c.getInstance().getApplicationContext()));
      localJSONObject1.put("extInfo", com.lantern.feed.d.d.b(com.lantern.core.c.getInstance().getApplicationContext()));
      JSONObject localJSONObject2 = com.lantern.feed.d.d.a();
      if (localJSONObject2 != null) {
        localJSONObject1.put("bizInfo", localJSONObject2);
      }
      if (paramJSONObject != null) {
        localJSONObject1.put("customInfo", paramJSONObject);
      }
      localJSONObject1.put("serialId", this.j);
      localJSONObject1.put("pageNo", String.valueOf(paramInt));
      localJSONObject1.put("ts", String.valueOf(System.currentTimeMillis()));
      localJSONObject1.put("loadType", "1");
      if (!TextUtils.isEmpty(this.k)) {
        localJSONObject1.put("channelId", this.k);
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        h.a(paramJSONObject);
      }
    }
    paramJSONObject = com.lantern.core.c.getServer();
    h.a("buildFeedNewsUrlParams signparams", new Object[0]);
    paramJSONObject = paramJSONObject.a("cds001001", localJSONObject1);
    h.a("buildFeedNewsUrlParams done", new Object[0]);
    return paramJSONObject;
  }
  
  private void a(int paramInt1, int paramInt2, List<com.lantern.feed.b.g> paramList)
  {
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramList;
    this.d.sendMessage(localMessage);
  }
  
  private void a(n paramn)
  {
    h.a("onReqNewsSuccess", new Object[0]);
    Object localObject = a(0, paramn.b(), paramn.d());
    this.f.sendMessage((Message)localObject);
    b localb = new b((byte)0);
    if (((Message)localObject).arg2 > 0)
    {
      int i2 = (int)((System.currentTimeMillis() - this.l) / 1000L);
      int i1 = i2;
      if ((System.currentTimeMillis() - this.l) % 1000L != 0L) {
        i1 = i2 + 1;
      }
      onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "refresh";
      localb.g = String.valueOf(paramn.b());
      a(localb);
    }
    for (;;)
    {
      return;
      localObject = new HashMap();
      a(paramn.d(), (HashMap)localObject);
      localb.a = "call0";
      localb.b = paramn.a();
      localb.f = "refresh";
      localb.g = String.valueOf(paramn.b());
      localb.e = paramn.c();
      localb.c = ((String)((HashMap)localObject).get("retCd"));
      localb.d = ((String)((HashMap)localObject).get("retMsg"));
      a(localb);
    }
  }
  
  private void a(b paramb)
  {
    String str = "";
    if (paramb.e != null) {
      str = new JSONObject(paramb.e).toString();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("pid", paramb.b);
    localHashMap.put("tabId", this.k);
    if (!TextUtils.isEmpty(paramb.c)) {
      localHashMap.put("retCd", paramb.c);
    }
    if (!TextUtils.isEmpty(paramb.d)) {
      localHashMap.put("retMsg", paramb.d);
    }
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("params", str);
    }
    if (!TextUtils.isEmpty(paramb.f)) {
      localHashMap.put("type", paramb.f);
    }
    if (!TextUtils.isEmpty(paramb.g)) {
      localHashMap.put("pageNo", paramb.g);
    }
    com.lantern.analytics.a.e().onEvent(paramb.a, new JSONObject(localHashMap).toString());
  }
  
  private static void a(String paramString, com.lantern.feed.b.g paramg)
  {
    String str = paramString;
    if (paramg != null) {
      str = com.lantern.feed.d.d.a(paramString, paramg);
    }
    new com.lantern.feed.a.a(str).execute(new String[0]);
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    m.a();
    new com.lantern.feed.a.g(m.c() + h() + String.format(Locale.getDefault(), "&f=feednative_%s&b=%s", new Object[] { paramString1, paramString2 })).execute(new String[0]);
  }
  
  private static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramHashMap.put("retCd", localJSONObject.optString("retCd", "0"));
      paramHashMap.put("retMsg", localJSONObject.optString("retMsg", ""));
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static void a(List<com.lantern.feed.b.g> paramList1, List<com.lantern.feed.b.g> paramList2, List<com.lantern.feed.b.g> paramList3)
  {
    if (paramList2.size() > 0)
    {
      if (paramList3.size() > 0)
      {
        paramList2 = paramList2.iterator();
        while (paramList2.hasNext())
        {
          com.lantern.feed.b.g localg1 = (com.lantern.feed.b.g)paramList2.next();
          if (paramList3.size() > 0)
          {
            com.lantern.feed.b.g localg2 = (com.lantern.feed.b.g)paramList3.get(0);
            localg2.f(localg1.o());
            localg2.g(localg1.p());
            paramList1.set(paramList1.indexOf(localg1), localg2);
            paramList3.remove(localg2);
            h.a("replaceModel:" + localg1.d(0) + " backupModel:" + localg2.d(0), new Object[0]);
          }
          else
          {
            h.a("replaceModels cannot find backup model:" + localg1.d(0), new Object[0]);
            paramList1.remove(localg1);
          }
        }
      }
      h.a("replaceModels no backup models", new Object[0]);
      paramList1.removeAll(paramList2);
    }
  }
  
  private void b(n paramn)
  {
    h.a("onReqLastestNewsSuccess", new Object[0]);
    Object localObject = a(1, paramn.b(), paramn.d());
    this.f.sendMessage((Message)localObject);
    b localb = new b((byte)0);
    if (((Message)localObject).arg2 > 0)
    {
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "up";
      localb.g = String.valueOf(paramn.b());
      a(localb);
    }
    HashMap localHashMap;
    if (((Message)localObject).arg1 == 1)
    {
      if (((Message)localObject).arg2 <= 0) {
        break label387;
      }
      int i2 = (int)((System.currentTimeMillis() - this.m) / 1000L);
      int i1 = i2;
      if ((System.currentTimeMillis() - this.m) % 1000L != 0L) {
        i1 = i2 + 1;
      }
      onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
      localHashMap = new HashMap();
      localHashMap.put("time", i1 + "s");
      localHashMap.put("tabId", this.k);
      com.lantern.analytics.a.e().onEvent("dhrf_s", new JSONObject(localHashMap).toString());
    }
    for (;;)
    {
      if (((Message)localObject).arg2 == 0)
      {
        localObject = new HashMap();
        a(paramn.d(), (HashMap)localObject);
        localb.a = "call0";
        localb.b = paramn.a();
        localb.f = "up";
        localb.g = String.valueOf(paramn.b());
        localb.e = paramn.c();
        localb.c = ((String)((HashMap)localObject).get("retCd"));
        localb.d = ((String)((HashMap)localObject).get("retMsg"));
        a(localb);
      }
      return;
      label387:
      localHashMap = new HashMap();
      localHashMap.put("tabId", this.k);
      com.lantern.analytics.a.e().onEvent("dhrf_f", new JSONObject(localHashMap).toString());
    }
  }
  
  private void b(List<com.lantern.feed.b.g> paramList)
  {
    h.a("onDeleteNews", new Object[0]);
    if (this.g.d().removeAll(paramList)) {
      this.p.notifyDataSetChanged();
    }
  }
  
  private void c(n paramn)
  {
    h.a("onReqMoreNewsSuccess", new Object[0]);
    Message localMessage = a(2, paramn.b(), paramn.d());
    this.f.sendMessage(localMessage);
    b localb = new b((byte)0);
    if (localMessage.arg2 > 0)
    {
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "down";
      localb.g = String.valueOf(paramn.b());
      a(localb);
    }
    if (localMessage.arg2 == 0)
    {
      HashMap localHashMap = new HashMap();
      a(paramn.d(), localHashMap);
      localb.a = "call0";
      localb.b = paramn.a();
      localb.f = "down";
      localb.g = String.valueOf(paramn.b());
      localb.e = paramn.c();
      localb.c = ((String)localHashMap.get("retCd"));
      localb.d = ((String)localHashMap.get("retMsg"));
      a(localb);
    }
    if (localMessage.arg1 == 2)
    {
      if (localMessage.arg2 <= 0) {
        break label383;
      }
      int i2 = (int)((System.currentTimeMillis() - this.n) / 1000L);
      int i1 = i2;
      if ((System.currentTimeMillis() - this.n) % 1000L != 0L) {
        i1 = i2 + 1;
      }
      onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
      paramn = new HashMap();
      paramn.put("time", i1 + "s");
      paramn.put("tabId", this.k);
      com.lantern.analytics.a.e().onEvent("dbrf_s", new JSONObject(paramn).toString());
    }
    for (;;)
    {
      return;
      label383:
      paramn = new HashMap();
      paramn.put("tabId", this.k);
      com.lantern.analytics.a.e().onEvent("dbrf_f", new JSONObject(paramn).toString());
    }
  }
  
  private String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      HashMap localHashMap = com.lantern.core.c.getServer().s();
      localStringBuilder.append("?v=").append((String)localHashMap.get("verCode"));
      localStringBuilder.append("&a=").append((String)localHashMap.get("appId"));
      localStringBuilder.append("&c=").append((String)localHashMap.get("chanId"));
      localStringBuilder.append("&u=").append((String)localHashMap.get("uhid"));
      localStringBuilder.append("&d=").append((String)localHashMap.get("dhid"));
      localStringBuilder.append("&ssid=").append(Uri.encode((String)localHashMap.get("capSsid")));
      localStringBuilder.append("&bssid=").append(Uri.encode((String)localHashMap.get("capBssid")));
      localStringBuilder.append("&t=").append(this.k);
      localStringBuilder.append("&_t=").append(System.currentTimeMillis());
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  private void i()
  {
    h.a("loadNewsFromNetInner", new Object[0]);
    this.l = System.currentTimeMillis();
    try
    {
      Object localObject2 = new com/bluefay/b/d;
      m.a();
      ((com.bluefay.b.d)localObject2).<init>(m.b());
      ((com.bluefay.b.d)localObject2).a(15000, 15000);
      HashMap localHashMap = a(a(0), null);
      localObject2 = ((com.bluefay.b.d)localObject2).b(localHashMap);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        h.a("loadNewsFromNetInner success", new Object[0]);
        n localn = new com/lantern/feed/b/n;
        localn.<init>();
        localn.a("cds001001");
        localn.a(1);
        localn.a(localHashMap);
        localn.b((String)localObject2);
        a(localn);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        h.a("loadNewsFromNetInner failed", new Object[0]);
        Object localObject1 = new Message();
        ((Message)localObject1).what = 7;
        ((Message)localObject1).arg1 = 0;
        ((Message)localObject1).arg2 = -1;
        this.f.sendMessage((Message)localObject1);
        localObject1 = new b((byte)0);
        ((b)localObject1).a = "call0";
        ((b)localObject1).b = "cds001001";
        ((b)localObject1).f = "refresh";
        ((b)localObject1).g = "1";
        ((b)localObject1).c = "-1";
        ((b)localObject1).d = "network error";
        a((b)localObject1);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.lantern.feed.b.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramg);
    a(paramInt1, paramInt2, localArrayList);
  }
  
  public final void a(int paramInt, com.lantern.feed.b.g paramg)
  {
    a(paramInt, -1, paramg);
  }
  
  public final void a(long paramLong)
  {
    h.a("onDownloadPaused id:" + paramLong, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 37;
    localMessage.obj = Long.valueOf(paramLong);
    this.e.sendMessage(localMessage);
  }
  
  public final void a(long paramLong, Uri paramUri)
  {
    h.a("onDownloadComplete id:" + paramLong, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 23;
    localMessage.arg1 = ((int)paramLong);
    localMessage.obj = paramUri;
    this.e.sendMessage(localMessage);
  }
  
  public final void a(com.lantern.feed.b.g paramg)
  {
    h.a("onDownloadStart " + paramg.d(0) + " id:" + paramg.D(), new Object[0]);
    this.g.a(paramg.D(), paramg);
    Message localMessage = new Message();
    localMessage.what = 36;
    localMessage.obj = paramg;
    this.e.sendMessage(localMessage);
  }
  
  public final void a(com.lantern.feed.b.o paramo)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramo);
    paramo = new Message();
    paramo.what = 5;
    paramo.arg1 = 2;
    paramo.obj = localArrayList;
    this.d.sendMessage(paramo);
  }
  
  public final void a(a parama)
  {
    this.i = parama;
  }
  
  public final void a(String paramString)
  {
    h.a("initFeedData", new Object[0]);
    this.k = paramString;
    this.g.c(this.k);
    this.e.sendEmptyMessage(19);
  }
  
  public final void a(List<com.lantern.feed.b.g> paramList)
  {
    a(1, -1, paramList);
  }
  
  public final void b()
  {
    h.a("loadLastestNews", new Object[0]);
    this.e.sendEmptyMessage(16);
    if (this.i != null) {
      this.i.a(1);
    }
  }
  
  public final void b(long paramLong)
  {
    h.a("onDownloadResumed id:" + paramLong, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 38;
    localMessage.obj = Long.valueOf(paramLong);
    this.e.sendMessage(localMessage);
  }
  
  public final void b(com.lantern.feed.b.g paramg)
  {
    Message localMessage = new Message();
    localMessage.what = 25;
    localMessage.obj = paramg;
    this.f.sendMessage(localMessage);
  }
  
  public final void b(String paramString)
  {
    h.a("loadNewsFromNet", new Object[0]);
    this.k = paramString;
    this.g.c(this.k);
    this.e.sendEmptyMessage(5);
  }
  
  public final void c()
  {
    h.a("loadMoreNews", new Object[0]);
    this.e.sendEmptyMessage(17);
    if (this.i != null) {
      this.i.a(2);
    }
  }
  
  public final void c(long paramLong)
  {
    h.a("onDownloadRemoved id:" + paramLong, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 39;
    localMessage.obj = Long.valueOf(paramLong);
    this.e.sendMessage(localMessage);
  }
  
  public final void c(String paramString)
  {
    h.a("onPackageAdd pkg:" + paramString, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 24;
    localMessage.obj = paramString;
    this.e.sendMessage(localMessage);
  }
  
  public final boolean c(com.lantern.feed.b.g paramg)
  {
    int i2 = this.g.b();
    int i1 = 200;
    if (com.bluefay.a.e.b(com.lantern.core.c.getAppContext())) {
      i1 = 40;
    }
    i1 = Math.min(i2 * 3, i1);
    i2 = this.g.d().indexOf(paramg);
    if (this.g.d().size() - i2 - 1 <= i1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void d()
  {
    a = null;
    this.f.removeMessages(7);
    this.e.sendEmptyMessage(3);
  }
  
  public final f e()
  {
    return this.p;
  }
  
  public final String f()
  {
    return this.k;
  }
  
  public final void onEvent(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = paramString;
    this.d.sendMessage(localMessage);
  }
  
  public final void onEvent(String paramString, int paramInt)
  {
    onEvent(paramString, String.valueOf(paramInt));
  }
  
  public final void onEvent(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = (paramString1 + ";" + paramString2);
    this.d.sendMessage(localMessage);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2, List<com.lantern.feed.b.g> paramList);
    
    public abstract void a(com.lantern.feed.b.g paramg);
    
    public abstract void b(com.lantern.feed.b.g paramg);
  }
  
  private final class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public HashMap<String, String> e;
    public String f;
    public String g;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */