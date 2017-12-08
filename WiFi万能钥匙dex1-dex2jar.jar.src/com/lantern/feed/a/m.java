package com.lantern.feed.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.config.FeedNativeConf;
import com.lantern.feed.b.i;
import com.lantern.feed.b.k;
import com.lantern.feed.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

public final class m
{
  private static m a;
  private com.lantern.core.imageloader.f A;
  private com.lantern.core.imageloader.f B;
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
  private String l;
  private int m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s = 0L;
  private long t = 0L;
  private long u = 0L;
  private long v;
  private List<com.lantern.feed.b.t> w = new ArrayList();
  private com.lantern.feed.b.f x = new com.lantern.feed.b.f(this.g);
  private com.lantern.feed.b.m y;
  private k z;
  
  private m()
  {
    this.h.b(1);
    FeedNativeConf localFeedNativeConf = (FeedNativeConf)com.lantern.core.config.d.a(c.getAppContext()).a(FeedNativeConf.class);
    if (localFeedNativeConf != null)
    {
      this.n = localFeedNativeConf.e();
      this.o = localFeedNativeConf.f();
      this.p = localFeedNativeConf.g();
    }
    if (this.n > 0L)
    {
      l1 = this.n;
      this.n = l1;
      if (this.o <= 0L) {
        break label363;
      }
    }
    label363:
    for (long l1 = this.o;; l1 = 3600000L)
    {
      this.o = l1;
      h.a("mContentTime:" + this.o, new Object[0]);
      this.b = new HandlerThread("feed", -8);
      this.b.start();
      this.k = UUID.randomUUID().toString().replace("-", "");
      this.r = System.currentTimeMillis();
      this.e = new Handler(this.b.getLooper(), new n(this));
      this.f = new Handler(Looper.getMainLooper(), new r(this));
      this.A = new s(this);
      this.B = new t(this);
      this.c = new HandlerThread("feeddc");
      this.c.setPriority(10);
      this.c.start();
      this.d = new Handler(this.c.getLooper(), new u(this));
      return;
      l1 = 300000L;
      break;
    }
  }
  
  private void A()
  {
    h.a("loadTabFromNetInner", new Object[0]);
    HashMap localHashMap = w();
    new j(b(), localHashMap, new x(this, localHashMap)).execute(new String[] { "" });
  }
  
  private void B()
  {
    h.a("loadTagTemplateFromNetInner", new Object[0]);
    String str = com.lantern.core.f.a().a("feedhost");
    if (TextUtils.isEmpty(str)) {}
    for (str = "https://cds.51y5.net/feeds.do?pid=cds003001";; str = str + "feeds.do?pid=cds003001")
    {
      new g(str, new y(this)).execute(new String[] { "" });
      return;
    }
  }
  
  private void C()
  {
    h.a("loadNewsFromNetInner", new Object[0]);
    this.s = System.currentTimeMillis();
    try
    {
      Object localObject2 = new com/bluefay/b/d;
      ((com.bluefay.b.d)localObject2).<init>(b());
      ((com.bluefay.b.d)localObject2).a(15000, 15000);
      HashMap localHashMap = b(b(0), null);
      localObject2 = ((com.bluefay.b.d)localObject2).b(localHashMap);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        h.a("loadNewsFromNetInner success", new Object[0]);
        Object localObject3 = new org/json/JSONObject;
        ((JSONObject)localObject3).<init>((String)localObject2);
        localObject2 = ((JSONObject)localObject3).optString("cds001001", "");
        String str = ((JSONObject)localObject3).optString("cds001004", "");
        localObject3 = new com/lantern/feed/b/n;
        ((com.lantern.feed.b.n)localObject3).<init>();
        ((com.lantern.feed.b.n)localObject3).a("cds001001");
        ((com.lantern.feed.b.n)localObject3).a(1);
        ((com.lantern.feed.b.n)localObject3).a(localHashMap);
        ((com.lantern.feed.b.n)localObject3).b((String)localObject2);
        ((com.lantern.feed.b.n)localObject3).c(str);
        d((com.lantern.feed.b.n)localObject3);
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
        if (!TextUtils.isEmpty(this.l))
        {
          ((Message)localObject1).arg1 = this.m;
          this.m = 0;
          this.l = "";
          this.q = 0L;
        }
        this.f.sendMessage((Message)localObject1);
        localObject1 = new b((byte)0);
        ((b)localObject1).a = "call0";
        ((b)localObject1).b = "cds001001";
        ((b)localObject1).f = "refresh";
        ((b)localObject1).g = "1";
        ((b)localObject1).c = "-1";
        ((b)localObject1).d = "network error";
        b((b)localObject1);
        ((b)localObject1).b = "cds001004";
        b((b)localObject1);
      }
    }
  }
  
  private static boolean D()
  {
    boolean bool = false;
    String str = c.getAppContext().getSharedPreferences("wkfeed", 0).getString("popad", "");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str);
        str = ((JSONObject)localObject).optString("lastShow");
        localObject = ((JSONObject)localObject).optString("interval");
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("shouldShowPopAd lastTime:");
        h.a(str + " interval:" + (String)localObject, new Object[0]);
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (System.currentTimeMillis() - Long.valueOf(str).longValue() <= Long.valueOf((String)localObject).longValue() * 1000L))
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>("shouldShowPopAd ");
          h.a(System.currentTimeMillis() - Long.valueOf(str).longValue(), new Object[0]);
          return bool;
        }
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
      bool = true;
    }
  }
  
  private Message a(int paramInt, com.lantern.feed.b.n paramn)
  {
    h.a("processNewsData aType:" + paramInt + " aPageNo:" + paramn.b(), new Object[0]);
    i locali = com.lantern.feed.b.j.a(paramn.d());
    locali.a(paramn.b());
    Object localObject1 = locali.a();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (!TextUtils.isEmpty(paramn.e()))
      {
        localObject2 = com.lantern.feed.b.j.a(paramn.e());
        if ((((i)localObject2).a() != null) && (((i)localObject2).a().size() > 0))
        {
          ((List)localObject1).add(0, ((i)localObject2).a().get(0));
          localObject1 = new b((byte)0);
          ((b)localObject1).a = "call1";
          ((b)localObject1).b = "cds001004";
          ((b)localObject1).g = String.valueOf(paramn.b());
          b((b)localObject1);
        }
      }
      else
      {
        this.g.a(locali.c());
      }
    }
    else
    {
      h.a("processNewsData aType:" + paramInt + " aPageNo:" + locali.d(), new Object[0]);
      localObject1 = locali.a();
      paramn = new Message();
      paramn.what = 7;
      paramn.arg1 = paramInt;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label580;
      }
      int i1 = ((List)localObject1).size();
      h.a("processNewsData count:" + i1, new Object[0]);
      paramn.arg2 = i1;
      paramn.obj = locali;
      localObject1 = this.g.d();
      if ((paramInt != 0) && ((localObject1 == null) || (((List)localObject1).size() == 0)))
      {
        h.a("processNewsData convert to refresh", new Object[0]);
        paramn.arg1 = 0;
      }
      label357:
      if ((locali.b() != null) && (locali.b().size() > 0))
      {
        h.a("processNewsData find delete ids", new Object[0]);
        this.f.obtainMessage(33, locali.b()).sendToTarget();
      }
      if (paramn.arg2 <= 0) {
        break label674;
      }
      if (paramn.arg1 != 0) {
        break label598;
      }
      this.g.a(1);
      this.g.b(1);
      if (!TextUtils.isEmpty(this.l))
      {
        this.k = this.l;
        this.l = "";
        this.r = this.q;
        this.q = 0L;
      }
    }
    for (;;)
    {
      return paramn;
      localObject1 = new b((byte)0);
      localObject2 = new HashMap();
      a(paramn.e(), (HashMap)localObject2);
      ((b)localObject1).a = "call0";
      ((b)localObject1).b = "cds001004";
      ((b)localObject1).g = String.valueOf(paramn.b());
      ((b)localObject1).e = paramn.c();
      ((b)localObject1).c = ((String)((HashMap)localObject2).get("retCd"));
      ((b)localObject1).d = ((String)((HashMap)localObject2).get("retMsg"));
      b((b)localObject1);
      break;
      label580:
      h.a("processNewsData failed", new Object[0]);
      paramn.arg2 = 0;
      break label357;
      label598:
      if (paramn.arg1 == 2)
      {
        paramInt = locali.d();
        this.g.b(paramInt);
        if (paramInt == 1) {
          this.g.a(paramInt);
        }
      }
      else if (paramn.arg1 == 1)
      {
        paramInt = locali.d();
        this.g.a(paramInt);
        if (paramInt == 1)
        {
          this.g.b(paramInt);
          continue;
          label674:
          if (!TextUtils.isEmpty(this.l))
          {
            paramn.arg1 = this.m;
            this.m = 0;
            this.l = "";
            this.q = 0L;
          }
        }
      }
    }
  }
  
  public static m a()
  {
    if (a == null) {
      a = new m();
    }
    return a;
  }
  
  private HashMap<String, String> a(int paramInt, JSONObject paramJSONObject)
  {
    h.a("start buildUpdateApNewsUrlParams", new Object[0]);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      localJSONObject1.put("extInfo", com.lantern.feed.d.d.b(c.getInstance().getApplicationContext()));
      JSONObject localJSONObject2 = com.lantern.feed.d.d.a();
      if (localJSONObject2 != null) {
        localJSONObject1.put("bizInfo", localJSONObject2);
      }
      if (paramJSONObject != null) {
        localJSONObject1.put("customInfo", paramJSONObject);
      }
      paramJSONObject = this.k;
      if (!TextUtils.isEmpty(this.l)) {
        paramJSONObject = this.l;
      }
      localJSONObject1.put("serialId", paramJSONObject);
      localJSONObject1.put("pageNo", String.valueOf(paramInt));
      localJSONObject1.put("ts", String.valueOf(System.currentTimeMillis()));
      localJSONObject1.put("loadType", "1");
      if ((this.g != null) && (this.g.d() != null) && (this.g.d().size() > 0))
      {
        paramJSONObject = (com.lantern.feed.b.g)this.g.d().get(0);
        if (paramJSONObject.V() != 0) {
          localJSONObject1.put("prevId", paramJSONObject.a());
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        h.a(paramJSONObject);
      }
    }
    paramJSONObject = c.getServer();
    h.a("buildUpdateApNewsUrlParams signparams", new Object[0]);
    paramJSONObject = paramJSONObject.a("cds001004", localJSONObject1);
    h.a("buildUpdateApNewsUrlParams done", new Object[0]);
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
  
  private void a(com.lantern.feed.b.n paramn)
  {
    h.a("onReqFeedSuccess", new Object[0]);
    Object localObject1 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    String str1 = "";
    String str2 = "";
    localObject2 = str1;
    localObject5 = localObject4;
    Object localObject6 = localObject3;
    Object localObject8 = localObject1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        localJSONObject.<init>(paramn.d());
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        localObject1 = localJSONObject.optString("cds003001", "");
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        localObject3 = localJSONObject.optString("cds001002", "");
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        localObject4 = localJSONObject.optString("cds001001", "");
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        str1 = localJSONObject.optString("cds004001", "");
        localObject2 = str1;
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject8 = localObject1;
        String str3 = localJSONObject.optString("cds004002", "");
        localObject2 = str3;
        h.a(localException2);
      }
      catch (Exception localException2)
      {
        try
        {
          localObject6 = localJSONObject.optString("cds001004", "");
          localObject5 = localObject2;
          localObject2 = new com.lantern.feed.b.n();
          ((com.lantern.feed.b.n)localObject2).a("cds003001");
          ((com.lantern.feed.b.n)localObject2).a(paramn.c());
          ((com.lantern.feed.b.n)localObject2).b((String)localObject1);
          c((com.lantern.feed.b.n)localObject2);
          localObject1 = new com.lantern.feed.b.n();
          ((com.lantern.feed.b.n)localObject1).a("cds001002");
          ((com.lantern.feed.b.n)localObject1).a(paramn.c());
          ((com.lantern.feed.b.n)localObject1).b((String)localObject3);
          b((com.lantern.feed.b.n)localObject1);
          localObject1 = new com.lantern.feed.b.n();
          ((com.lantern.feed.b.n)localObject1).a("cds001001");
          ((com.lantern.feed.b.n)localObject1).a(1);
          ((com.lantern.feed.b.n)localObject1).a(paramn.c());
          ((com.lantern.feed.b.n)localObject1).b((String)localObject4);
          ((com.lantern.feed.b.n)localObject1).c((String)localObject6);
          d((com.lantern.feed.b.n)localObject1);
          localObject1 = new com.lantern.feed.b.n();
          ((com.lantern.feed.b.n)localObject1).a("cds004001");
          ((com.lantern.feed.b.n)localObject1).a(paramn.c());
          ((com.lantern.feed.b.n)localObject1).b(str1);
          localObject2 = new Message();
          ((Message)localObject2).what = 14;
          ((Message)localObject2).obj = localObject1;
          this.e.sendMessage((Message)localObject2);
          localObject1 = new com.lantern.feed.b.n();
          ((com.lantern.feed.b.n)localObject1).a("cds004002");
          ((com.lantern.feed.b.n)localObject1).a(paramn.c());
          ((com.lantern.feed.b.n)localObject1).b((String)localObject5);
          paramn = new Message();
          paramn.what = 41;
          paramn.obj = localObject1;
          this.e.sendMessage(paramn);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localObject5 = localObject2;
            localObject2 = localObject7;
            Object localObject7 = localException1;
          }
        }
        localException2 = localException2;
        str3 = "";
        localObject1 = localObject8;
        localObject3 = localObject6;
        localObject4 = localObject5;
        localObject5 = str3;
      }
      localObject6 = str2;
      localObject7 = localObject2;
    }
  }
  
  private static void a(String paramString, com.lantern.feed.b.g paramg)
  {
    String str = paramString;
    if (paramg != null) {
      str = com.lantern.feed.d.d.a(paramString, paramg);
    }
    new a(str).execute(new String[0]);
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
          com.lantern.feed.b.g localg2 = (com.lantern.feed.b.g)paramList2.next();
          if (paramList3.size() > 0)
          {
            com.lantern.feed.b.g localg1 = (com.lantern.feed.b.g)paramList3.get(0);
            localg1.f(localg2.o());
            localg1.g(localg2.p());
            paramList1.set(paramList1.indexOf(localg2), localg1);
            paramList3.remove(localg1);
            h.a("replaceModel:" + localg2.d(0) + " backupModel:" + localg1.d(0), new Object[0]);
          }
          else
          {
            h.a("replaceModels cannot find backup model:" + localg2.d(0), new Object[0]);
            paramList1.remove(localg2);
          }
        }
      }
      h.a("replaceModels no backup models", new Object[0]);
      paramList1.removeAll(paramList2);
    }
  }
  
  private int b(int paramInt)
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
  
  public static String b()
  {
    String str = com.lantern.core.f.a().a("feedhost");
    if (TextUtils.isEmpty(str)) {}
    for (str = "https://cds.51y5.net/feeds.sec";; str = str + "feeds.sec") {
      return str;
    }
  }
  
  private HashMap<String, String> b(int paramInt, JSONObject paramJSONObject)
  {
    h.a("start buildFeedNewsUrlParams", new Object[0]);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      localJSONObject.put("extInfo", com.lantern.feed.d.d.b(c.getInstance().getApplicationContext()));
      localObject = com.lantern.feed.d.d.a();
      if (localObject != null) {
        localJSONObject.put("bizInfo", localObject);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("customInfo", paramJSONObject);
      }
      paramJSONObject = this.k;
      if (!TextUtils.isEmpty(this.l)) {
        paramJSONObject = this.l;
      }
      localJSONObject.put("serialId", paramJSONObject);
      localJSONObject.put("pageNo", String.valueOf(paramInt));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis()));
      localJSONObject.put("loadType", "1");
      if ((this.g != null) && (this.g.d() != null) && (this.g.d().size() > 0))
      {
        paramJSONObject = (com.lantern.feed.b.g)this.g.d().get(0);
        if (paramJSONObject.V() != 0) {
          localJSONObject.put("prevId", paramJSONObject.a());
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Object localObject;
        h.a(paramJSONObject);
      }
    }
    localObject = c.getServer();
    h.a("buildFeedNewsUrlParams signparams", new Object[0]);
    paramJSONObject = "cds001001,cds001004";
    if (paramInt > 1) {
      paramJSONObject = "cds001001";
    }
    paramJSONObject = ((com.lantern.core.o)localObject).a(paramJSONObject, localJSONObject);
    h.a("buildFeedNewsUrlParams done", new Object[0]);
    return paramJSONObject;
  }
  
  private static void b(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      String str = "";
      if (paramb.e != null) {
        str = new JSONObject(paramb.e).toString();
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("pid", paramb.b);
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
      if (!TextUtils.isEmpty(paramb.h)) {
        localHashMap.put("dy", paramb.h);
      }
      com.lantern.analytics.a.e().onEvent(paramb.a, new JSONObject(localHashMap).toString());
    }
  }
  
  private void b(com.lantern.feed.b.n paramn)
  {
    h.a("onReqTabSuccess", new Object[0]);
    com.lantern.feed.b.a locala = p.a(paramn.d());
    b localb = new b((byte)0);
    Object localObject;
    if ((locala != null) && (locala.a() != null) && (locala.a().size() > 0))
    {
      h.a("onReqTabSuccess tabModels.size():" + locala.a().size() + " search:" + locala.b(), new Object[0]);
      localObject = new Message();
      ((Message)localObject).what = 6;
      ((Message)localObject).obj = locala;
      this.f.sendMessage((Message)localObject);
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramn.d();
      this.e.sendMessage((Message)localObject);
      localb.a = "call1";
      localb.b = paramn.a();
      b(localb);
    }
    for (;;)
    {
      return;
      h.a("onReqTabSuccess failed", new Object[0]);
      localObject = new HashMap();
      a(paramn.d(), (HashMap)localObject);
      localb.a = "call0";
      localb.b = paramn.a();
      localb.e = paramn.c();
      localb.c = ((String)((HashMap)localObject).get("retCd"));
      localb.d = ((String)((HashMap)localObject).get("retMsg"));
      b(localb);
    }
  }
  
  private void b(List<com.lantern.feed.b.g> paramList)
  {
    h.a("onDeleteNews", new Object[0]);
    if (this.g.d().removeAll(paramList)) {
      this.x.notifyDataSetChanged();
    }
  }
  
  public static String c()
  {
    if (com.lantern.core.f.a().b("feedrdtest") == 1) {}
    for (String str = "http://wifi98.51y5.net/wifiapi/rd.do";; str = "http://wifiapi02.51y5.net/wifiapi/rd.do") {
      return str;
    }
  }
  
  private void c(int paramInt)
  {
    this.l = UUID.randomUUID().toString().replace("-", "");
    this.q = System.currentTimeMillis();
    this.m = paramInt;
    h.a("loadNewsFromNet", new Object[0]);
    if ((this.w == null) || (this.w.size() == 0)) {
      f();
    }
    this.e.sendEmptyMessage(5);
    if ((this.i != null) && (TextUtils.isEmpty(this.l))) {
      this.i.a(0);
    }
    y();
  }
  
  private void c(com.lantern.feed.b.n paramn)
  {
    h.a("onReqTagTemplateSuccess", new Object[0]);
    Object localObject = com.lantern.feed.b.s.a(paramn.d());
    b localb = new b((byte)0);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      h.a("onReqTagTemplateSuccess array.size():" + ((List)localObject).size(), new Object[0]);
      this.w = ((List)localObject);
      localObject = new Message();
      ((Message)localObject).what = 28;
      ((Message)localObject).obj = paramn.d();
      this.e.sendMessage((Message)localObject);
      localb.a = "call1";
      localb.b = paramn.a();
      b(localb);
    }
    for (;;)
    {
      return;
      h.a("onReqTagTemplateSuccess failed", new Object[0]);
      localObject = new HashMap();
      a(paramn.d(), (HashMap)localObject);
      localb.a = "call0";
      localb.b = paramn.a();
      localb.e = paramn.c();
      localb.c = ((String)((HashMap)localObject).get("retCd"));
      localb.d = ((String)((HashMap)localObject).get("retMsg"));
      b(localb);
    }
  }
  
  private static void c(String paramString)
  {
    new a(paramString).execute(new String[0]);
  }
  
  private void c(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = (paramString1 + ";" + paramString2);
    this.d.sendMessage(localMessage);
  }
  
  private com.lantern.feed.b.g d(com.lantern.feed.b.g paramg)
  {
    h.a("insertUpdate ap news:" + paramg.d(0), new Object[0]);
    com.lantern.feed.b.g localg = (com.lantern.feed.b.g)this.g.d().get(0);
    if (localg.V() != 0) {
      this.g.d().remove(0);
    }
    for (;;)
    {
      this.g.d().add(0, paramg);
      return localg;
      int i1 = localg.o();
      Iterator localIterator = this.g.d().iterator();
      while (localIterator.hasNext())
      {
        localg = (com.lantern.feed.b.g)localIterator.next();
        if ((localg.c() == 1) || (localg.o() != i1)) {
          break;
        }
        localg.g(localg.p() + 1);
      }
      localg = null;
    }
  }
  
  private void d(com.lantern.feed.b.n paramn)
  {
    h.a("onReqNewsSuccess", new Object[0]);
    Object localObject = a(0, paramn);
    this.f.sendMessage((Message)localObject);
    b localb = new b((byte)0);
    if (((Message)localObject).arg2 > 0)
    {
      int i2 = (int)((System.currentTimeMillis() - this.s) / 1000L);
      int i1 = i2;
      if ((System.currentTimeMillis() - this.s) % 1000L != 0L) {
        i1 = i2 + 1;
      }
      onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "refresh";
      localb.g = String.valueOf(paramn.b());
      b(localb);
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
      b(localb);
    }
  }
  
  private static void d(String paramString1, String paramString2)
  {
    new g(c() + t() + String.format(Locale.getDefault(), "&f=feednative_%s&b=%s", new Object[] { paramString1, paramString2 })).execute(new String[0]);
  }
  
  private void e(com.lantern.feed.b.n paramn)
  {
    h.a("onReqLastestNewsSuccess", new Object[0]);
    Object localObject = a(1, paramn);
    this.f.sendMessage((Message)localObject);
    b localb = new b((byte)0);
    if (((Message)localObject).arg2 > 0)
    {
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "up";
      localb.g = String.valueOf(paramn.b());
      b(localb);
    }
    if (((Message)localObject).arg1 == 1)
    {
      if (((Message)localObject).arg2 <= 0) {
        break label365;
      }
      int i2 = (int)((System.currentTimeMillis() - this.t) / 1000L);
      int i1 = i2;
      if ((System.currentTimeMillis() - this.t) % 1000L != 0L) {
        i1 = i2 + 1;
      }
      onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
      HashMap localHashMap = new HashMap();
      localHashMap.put("time", i1 + "s");
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
        b(localb);
      }
      return;
      label365:
      com.lantern.analytics.a.e().onEvent("dhrf_f");
    }
  }
  
  private void f(com.lantern.feed.b.n paramn)
  {
    h.a("onReqMoreNewsSuccess", new Object[0]);
    Message localMessage = a(2, paramn);
    this.f.sendMessage(localMessage);
    b localb = new b((byte)0);
    if (localMessage.arg2 > 0)
    {
      localb.a = "call1";
      localb.b = paramn.a();
      localb.f = "down";
      localb.g = String.valueOf(paramn.b());
      b(localb);
      if (localMessage.arg1 == 2)
      {
        if (localMessage.arg2 <= 0) {
          break label357;
        }
        int i2 = (int)((System.currentTimeMillis() - this.u) / 1000L);
        int i1 = i2;
        if ((System.currentTimeMillis() - this.u) % 1000L != 0L) {
          i1 = i2 + 1;
        }
        onEvent("loadNewsTime", String.format(Locale.getDefault(), "p%d_%s", new Object[] { Integer.valueOf(paramn.b()), i1 + "s" }));
        paramn = new HashMap();
        paramn.put("time", i1 + "s");
        com.lantern.analytics.a.e().onEvent("dbrf_s", new JSONObject(paramn).toString());
      }
    }
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      a(paramn.d(), localHashMap);
      localb.a = "call0";
      localb.b = paramn.a();
      localb.f = "down";
      localb.g = String.valueOf(paramn.b());
      localb.e = paramn.c();
      localb.c = ((String)localHashMap.get("retCd"));
      localb.d = ((String)localHashMap.get("retMsg"));
      b(localb);
      break;
      label357:
      com.lantern.analytics.a.e().onEvent("dbrf_f");
    }
  }
  
  private static String t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      HashMap localHashMap = c.getServer().s();
      localStringBuilder.append("?v=").append((String)localHashMap.get("verCode"));
      localStringBuilder.append("&a=").append((String)localHashMap.get("appId"));
      localStringBuilder.append("&c=").append((String)localHashMap.get("chanId"));
      localStringBuilder.append("&u=").append((String)localHashMap.get("uhid"));
      localStringBuilder.append("&d=").append((String)localHashMap.get("dhid"));
      localStringBuilder.append("&ssid=").append(Uri.encode((String)localHashMap.get("capSsid")));
      localStringBuilder.append("&bssid=").append(Uri.encode((String)localHashMap.get("capBssid")));
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
  
  private HashMap<String, String> u()
  {
    h.a("start buildFeedPopUrlParams", new Object[0]);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      ((JSONObject)localObject).put("serialId", this.k);
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis()));
      com.lantern.core.o localo = c.getServer();
      h.a("buildFeedPopUrlParams signparams", new Object[0]);
      localObject = localo.a("cds004001", (JSONObject)localObject);
      h.a("buildFeedPopUrlParams done", new Object[0]);
      return (HashMap<String, String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  private HashMap<String, String> v()
  {
    h.a("start buildFeedPopAdUrlParams", new Object[0]);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      ((JSONObject)localObject).put("extInfo", com.lantern.feed.d.d.b(c.getInstance().getApplicationContext()));
      ((JSONObject)localObject).put("serialId", this.k);
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis()));
      com.lantern.core.o localo = c.getServer();
      h.a("buildFeedPopAdUrlParams signparams", new Object[0]);
      localObject = localo.a("cds004002", (JSONObject)localObject);
      h.a("buildFeedPopAdUrlParams done", new Object[0]);
      return (HashMap<String, String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  private HashMap<String, String> w()
  {
    h.a("start buildFeedTabUrlParams", new Object[0]);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      ((JSONObject)localObject).put("serialId", this.k);
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis()));
      com.lantern.core.o localo = c.getServer();
      h.a("buildFeedTabUrlParams signparams", new Object[0]);
      localObject = localo.a("cds001002", (JSONObject)localObject);
      h.a("buildFeedTabUrlParams done", new Object[0]);
      return (HashMap<String, String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  private HashMap<String, String> x()
  {
    h.a("start buildFeedUrlParams", new Object[0]);
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("appInfo", com.lantern.feed.d.d.a(c.getInstance().getApplicationContext()));
      ((JSONObject)localObject1).put("extInfo", com.lantern.feed.d.d.b(c.getInstance().getApplicationContext()));
      localObject2 = com.lantern.feed.d.d.a();
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("bizInfo", localObject2);
      }
      ((JSONObject)localObject1).put("serialId", this.k);
      ((JSONObject)localObject1).put("pageNo", "1");
      ((JSONObject)localObject1).put("ts", String.valueOf(System.currentTimeMillis()));
      ((JSONObject)localObject1).put("loadType", "1");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        h.a(localException);
      }
    }
    localObject2 = c.getServer();
    h.a("buildFeedUrlParams signparams", new Object[0]);
    localObject1 = ((com.lantern.core.o)localObject2).a("cds001001,cds001002,cds003001,cds004001,cds004002,cds001004", (JSONObject)localObject1);
    h.a("buildFeedUrlParams done", new Object[0]);
    return (HashMap<String, String>)localObject1;
  }
  
  private void y()
  {
    h.a("loadTabFromNet", new Object[0]);
    this.e.sendEmptyMessage(4);
  }
  
  private void z()
  {
    h.a("loadFeedFromNetInner", new Object[0]);
    this.s = System.currentTimeMillis();
    try
    {
      Object localObject2 = new com/bluefay/b/d;
      ((com.bluefay.b.d)localObject2).<init>(b());
      ((com.bluefay.b.d)localObject2).a(15000, 15000);
      HashMap localHashMap = x();
      String str = ((com.bluefay.b.d)localObject2).b(localHashMap);
      if (!TextUtils.isEmpty(str))
      {
        h.a("loadFeedFromNetInner success", new Object[0]);
        localObject2 = new com/lantern/feed/b/n;
        ((com.lantern.feed.b.n)localObject2).<init>();
        ((com.lantern.feed.b.n)localObject2).a(localHashMap);
        ((com.lantern.feed.b.n)localObject2).b(str);
        a((com.lantern.feed.b.n)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        h.a("loadFeedFromNetInner failed", new Object[0]);
        Object localObject1 = new Message();
        ((Message)localObject1).what = 7;
        ((Message)localObject1).arg1 = 0;
        ((Message)localObject1).arg2 = -1;
        this.f.sendMessage((Message)localObject1);
        localObject1 = new b((byte)0);
        ((b)localObject1).a = "call0";
        ((b)localObject1).b = "cds003001";
        ((b)localObject1).c = "-1";
        ((b)localObject1).d = "network error";
        b((b)localObject1);
        ((b)localObject1).b = "cds001002";
        b((b)localObject1);
        ((b)localObject1).b = "cds004001";
        b((b)localObject1);
        ((b)localObject1).b = "cds004002";
        b((b)localObject1);
        ((b)localObject1).g = "1";
        ((b)localObject1).f = "refresh";
        ((b)localObject1).b = "cds001001";
        b((b)localObject1);
        ((b)localObject1).b = "cds001004";
        b((b)localObject1);
      }
    }
  }
  
  public final com.lantern.feed.b.t a(int paramInt)
  {
    Object localObject;
    com.lantern.feed.b.t localt;
    if ((this.w != null) && (this.w.size() > 0))
    {
      localObject = this.w.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localt = (com.lantern.feed.b.t)((Iterator)localObject).next();
      } while (localt.a() != paramInt);
    }
    for (;;)
    {
      localObject = localt;
      if (localt == null) {
        localObject = new com.lantern.feed.b.t();
      }
      return (com.lantern.feed.b.t)localObject;
      localt = null;
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
  
  public final void a(int paramInt, List<com.lantern.feed.b.o> paramList)
  {
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramList;
    this.d.sendMessage(localMessage);
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
  
  public final void a(a parama)
  {
    this.i = parama;
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
    a(2, localArrayList);
  }
  
  public final void a(String paramString)
  {
    h.a("onPackageAdd pkg:" + paramString, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 24;
    localMessage.obj = paramString;
    this.e.sendMessage(localMessage);
  }
  
  public final void a(List<com.lantern.feed.b.g> paramList)
  {
    a(1, -1, paramList);
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
    h.a("onRemoveNews " + paramg.d(0), new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 25;
    localMessage.obj = paramg;
    this.f.sendMessage(localMessage);
  }
  
  public final void c(long paramLong)
  {
    h.a("onDownloadRemoved id:" + paramLong, new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 39;
    localMessage.obj = Long.valueOf(paramLong);
    this.e.sendMessage(localMessage);
  }
  
  public final boolean c(com.lantern.feed.b.g paramg)
  {
    int i2 = this.g.b();
    int i1 = 200;
    if (com.bluefay.a.e.b(c.getAppContext())) {
      i1 = 40;
    }
    i1 = Math.min(i2 * 3, i1);
    int i3 = this.g.d().indexOf(paramg);
    int i4 = this.g.d().size();
    h.a("canLoadMore title:" + paramg.d(0) + " end:" + i2 + " max:" + i1 + " index:" + i3 + " size:" + i4, new Object[0]);
    if (i4 - i3 - 1 <= i1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void d()
  {
    h.a("initFeedData", new Object[0]);
    this.e.sendEmptyMessage(19);
  }
  
  public final void e()
  {
    h.a("loadFeedFromNet", new Object[0]);
    this.e.sendEmptyMessage(26);
  }
  
  public final void f()
  {
    h.a("loadTagFromNet", new Object[0]);
    this.e.sendEmptyMessage(29);
  }
  
  public final void g()
  {
    h.a("loadLastestNews", new Object[0]);
    if (System.currentTimeMillis() - this.r >= this.p)
    {
      h.a("loadLastestNews news is old,refresh", new Object[0]);
      c(1);
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.a(1);
      }
      return;
      if ((this.w == null) || (this.w.size() == 0)) {
        f();
      }
      if ((this.g.g() == null) || (this.g.g().a() == null) || (this.g.g().a().size() == 0)) {
        this.e.sendEmptyMessage(4);
      }
      this.e.sendEmptyMessage(16);
    }
  }
  
  public final void h()
  {
    h.a("loadMoreNews", new Object[0]);
    if (System.currentTimeMillis() - this.r >= this.p)
    {
      h.a("loadMoreNews news is old,refresh", new Object[0]);
      c(2);
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.a(2);
      }
      return;
      if ((this.w == null) || (this.w.size() == 0)) {
        f();
      }
      this.e.sendEmptyMessage(17);
    }
  }
  
  public final void i()
  {
    h.a("updateApNews", new Object[0]);
    if ((this.g != null) && (this.g.a() != 0)) {
      this.e.sendEmptyMessage(20);
    }
  }
  
  public final void j()
  {
    h.a("mergeDataToUi", new Object[0]);
    this.e.sendEmptyMessage(15);
  }
  
  public final void k()
  {
    h.a("insertOrUpdateApNews", new Object[0]);
    this.e.sendEmptyMessage(22);
  }
  
  public final int l()
  {
    if (this.g != null) {}
    for (int i1 = this.g.b();; i1 = 1) {
      return i1;
    }
  }
  
  public final void m()
  {
    a = null;
    this.f.removeMessages(6);
    this.f.removeMessages(7);
    this.e.sendEmptyMessage(3);
  }
  
  public final void n()
  {
    h.a("onRemoveApNews", new Object[0]);
    Message localMessage = new Message();
    localMessage.what = 21;
    this.f.sendMessage(localMessage);
  }
  
  public final com.lantern.feed.b.f o()
  {
    return this.x;
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
  
  public final com.lantern.feed.b.a p()
  {
    if (this.g != null) {}
    for (com.lantern.feed.b.a locala = this.g.g();; locala = null) {
      return locala;
    }
  }
  
  public final long q()
  {
    return this.o;
  }
  
  public final void r()
  {
    SharedPreferences localSharedPreferences = c.getAppContext().getSharedPreferences("wkfeed", 0);
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("lastShow", System.currentTimeMillis());
      localJSONObject.put("interval", this.z.e());
      localSharedPreferences.edit().putString("popad", localJSONObject.toString()).apply();
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
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2, List<com.lantern.feed.b.g> paramList);
    
    public abstract void a(com.lantern.feed.b.a parama);
    
    public abstract void a(com.lantern.feed.b.g paramg);
    
    public abstract void a(k paramk);
    
    public abstract void a(com.lantern.feed.b.m paramm);
    
    public abstract void a(com.lantern.feed.b.u paramu);
    
    public abstract void a(List<String> paramList);
    
    public abstract void b(com.lantern.feed.b.g paramg);
    
    public abstract void b(com.lantern.feed.b.u paramu);
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
    public String h;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */