package com.wifi.connect.plugin.magickey.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import bluefay.app.k.a;
import bluefay.widget.BLCheckBox;
import com.bluefay.b.h;
import com.bluefay.material.f;
import com.lantern.core.g.j;
import com.lantern.core.g.r.a;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.R.id;
import com.wifi.connect.plugin.magickey.R.layout;
import com.wifi.connect.plugin.magickey.R.string;
import com.wifi.connect.plugin.magickey.b.d;
import com.wifi.connect.plugin.magickey.d.c;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
  implements al
{
  private Context a;
  private com.lantern.core.g.r b;
  private WkAccessPoint c;
  private com.wifi.connect.plugin.magickey.b.b d;
  private d[] e;
  private int[] f;
  private int g = 0;
  private com.bluefay.b.a h;
  private boolean i;
  private String j;
  private com.wifi.connect.plugin.magickey.c.a k;
  private f l;
  private String m;
  private String n;
  private String o;
  private boolean p;
  private Handler q = new q(this);
  private com.bluefay.b.a r = new z(this);
  private com.bluefay.b.a s = new aa(this);
  private com.bluefay.b.a t = new ab(this);
  private com.bluefay.b.a u = new ac(this);
  private com.bluefay.b.a v = new ad(this);
  private com.bluefay.b.a w = new ae(this);
  
  public p(Context paramContext)
  {
    this.a = paramContext;
    this.b = new com.lantern.core.g.r(this.a);
    this.b.a();
  }
  
  private void a(WkAccessPoint paramWkAccessPoint)
  {
    this.p = false;
    this.h.a(3, null, c(30015));
    if (!com.bluefay.a.a.c(this.a))
    {
      this.k.j = System.currentTimeMillis();
      this.k.k = false;
      this.k.l = "";
      if (Build.VERSION.SDK_INT >= 21) {
        if (com.lantern.auth.utils.a.b(this.a)) {
          a(this.u);
        }
      }
    }
    for (;;)
    {
      return;
      this.u.a(0, null, Integer.valueOf(10104));
      continue;
      if (t.g(this.a))
      {
        new com.wifi.connect.plugin.magickey.d.b(this.u).execute(new String[0]);
      }
      else
      {
        b(this.u);
        continue;
        if (com.bluefay.a.a.a(this.a))
        {
          j.a().a(this.v);
        }
        else
        {
          this.k.j = System.currentTimeMillis();
          this.k.k = true;
          this.k.l = "g";
          a(paramWkAccessPoint, this.w);
        }
      }
    }
  }
  
  private static boolean a(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof bluefay.app.b)) && (!((bluefay.app.b)paramContext).c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      this.k.P = System.currentTimeMillis();
      this.k.N = true;
      if ((this.e != null) && (this.d != null))
      {
        paramInt = this.d.l();
        if (paramInt >= 0)
        {
          this.e[paramInt] = new d(0, "");
          this.f[paramInt] = u.d(this.a, this.c);
        }
        this.k.v = this.d.d.size();
        this.k.w = paramInt;
      }
      this.q.sendEmptyMessageDelayed(3, 2000L);
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        this.k.P = System.currentTimeMillis();
        this.k.N = false;
        paramInt = 10000;
        if ((paramObject instanceof r.a)) {
          paramInt = ((r.a)paramObject).a;
        }
        this.k.O = String.valueOf(paramInt);
        if ((this.e != null) && (this.d != null))
        {
          int i1 = this.d.l();
          if (i1 >= 0)
          {
            this.e[i1] = new d(paramInt, paramString);
            this.f[i1] = u.d(this.a, this.c);
          }
          this.k.v = this.d.d.size();
          this.k.w = i1;
        }
        this.q.sendEmptyMessageDelayed(3, 2000L);
      }
    }
  }
  
  private static at.a c(int paramInt)
  {
    return new at.a(paramInt);
  }
  
  public final void a()
  {
    this.i = true;
    r.a locala = new r.a(10009, u.b(this.a, this.c));
    b(0, "CANCELED", locala);
    a(0, locala);
    this.h.a(0, "CANCELED", locala);
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof r.a)))
    {
      paramObject = ((r.a)paramObject).b;
      new com.lantern.core.g.r(this.a).b((WifiConfiguration)paramObject, null);
    }
  }
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ArrayList localArrayList;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (paramInt == 1) {
      if ((this.d != null) && (this.d.h()) && (this.e != null))
      {
        localArrayList = new ArrayList();
        localObject1 = this.c.a;
        localObject3 = this.c.b;
        paramString = this.d.a;
        localObject2 = u.a(this.a, this.c);
        for (paramInt = 0; paramInt < this.e.length; paramInt++) {
          if (this.e[paramInt] != null)
          {
            paramObject = new com.wifi.connect.plugin.magickey.c.b();
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).b = ((String)localObject1);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).c = ((String)localObject3);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).e = paramString;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).h = ((ArrayList)localObject2);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).f = this.e[paramInt].a;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).g = this.e[paramInt].b;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).a = this.d.a(paramInt).c;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).d = this.d.a(paramInt).a;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).k = com.lantern.core.k.h(this.a);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).l = com.lantern.core.k.i(this.a);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).m = this.d.a(paramInt).d;
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).n = String.valueOf(this.f[paramInt]);
            ((com.wifi.connect.plugin.magickey.c.b)paramObject).o = String.valueOf(this.d.b);
            localArrayList.add(paramObject);
          }
        }
        new Handler().postDelayed(new af(this, localArrayList), 1500L);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt == 0) && (this.d != null) && (this.d.h()) && (this.e != null))
      {
        localArrayList = new ArrayList();
        paramString = this.c.a;
        paramObject = this.c.b;
        localObject2 = this.d.a;
        localObject1 = u.a(this.a, this.c);
        for (paramInt = 0; paramInt < this.e.length; paramInt++) {
          if (this.e[paramInt] != null)
          {
            localObject3 = new com.wifi.connect.plugin.magickey.c.b();
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).b = paramString;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).c = ((String)paramObject);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).e = ((String)localObject2);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).h = ((ArrayList)localObject1);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).f = this.e[paramInt].a;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).g = this.e[paramInt].b;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).a = this.d.a(paramInt).c;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).d = this.d.a(paramInt).a;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).k = com.lantern.core.k.h(this.a);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).l = com.lantern.core.k.i(this.a);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).m = this.d.a(paramInt).d;
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).n = String.valueOf(this.f[paramInt]);
            ((com.wifi.connect.plugin.magickey.c.b)localObject3).o = String.valueOf(this.d.b);
            h.a("srssi reportTranceConn " + ((com.wifi.connect.plugin.magickey.c.b)localObject3).n + " mQpts " + ((com.wifi.connect.plugin.magickey.c.b)localObject3).o + " mReport.mRetSysTime " + this.k.t, new Object[0]);
            localArrayList.add(localObject3);
          }
        }
        new Handler().postDelayed(new ag(this, localArrayList), 1500L);
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    if ((this.a instanceof Activity)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (!a(this.a)) {}
      for (;;)
      {
        return;
        if (i1 != 0) {
          break;
        }
        parama.a(0, null, Integer.valueOf(10104));
      }
      this.h.a(3, null, c(30011));
      k.a locala = new k.a(this.a);
      locala.a(R.string.connect_open_mobile_network_magic_dia_title);
      locala.b(R.string.connect_open_mobile_network_magic_dia_msg);
      locala.a(R.string.connect_open_mobile_network_magic_dia_ok, new r(this, parama));
      locala.a(new s(this, parama));
      if ((this.a instanceof Activity)) {
        locala.c().show();
      }
      for (;;)
      {
        com.lantern.analytics.a.e().onEvent("qo5m");
        break;
        parama = locala.c();
        parama.getWindow().setType(2010);
        parama.show();
      }
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, com.bluefay.b.a parama)
  {
    ArrayList localArrayList = u.a(this.a, paramWkAccessPoint);
    new c(this.j, paramWkAccessPoint, localArrayList, this.m, this.n, parama).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString, com.bluefay.b.a parama)
  {
    long l2 = 0L;
    localObject6 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    localObject7 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    localObject8 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    JSONObject localJSONObject = null;
    String str = null;
    Object localObject11 = null;
    localObject10 = null;
    Object localObject20 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    localObject2 = localObject20;
    localObject9 = localObject10;
    localObject4 = localJSONObject;
    localObject3 = localObject8;
    localObject1 = localObject7;
    bool1 = bool2;
    Object localObject5 = localObject6;
    l1 = l2;
    if (paramString != null)
    {
      localObject2 = localObject20;
      localObject9 = localObject10;
      localObject4 = localJSONObject;
      localObject3 = localObject8;
      localObject1 = localObject7;
      bool1 = bool2;
      localObject5 = localObject6;
      l1 = l2;
      if (paramString.length() > 0)
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject16;
        bool2 = bool3;
        localObject5 = localObject18;
        l3 = l2;
      }
    }
    try
    {
      localJSONObject = new org/json/JSONObject;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject16;
      bool2 = bool3;
      localObject5 = localObject18;
      l3 = l2;
      localJSONObject.<init>(paramString);
      l1 = l2;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject16;
      bool2 = bool3;
      localObject5 = localObject18;
      l3 = l2;
      if (localJSONObject.has("cacheTime"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject16;
        bool2 = bool3;
        localObject5 = localObject18;
        l3 = l2;
        l1 = localJSONObject.getLong("cacheTime");
      }
      bool1 = bool4;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject16;
      bool2 = bool3;
      localObject5 = localObject18;
      l3 = l1;
      if (localJSONObject.has("hasKey"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject16;
        bool2 = bool3;
        localObject5 = localObject18;
        l3 = l1;
        bool1 = localJSONObject.getBoolean("hasKey");
      }
      paramString = (String)localObject19;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject16;
      bool2 = bool1;
      localObject5 = localObject18;
      l3 = l1;
      if (localJSONObject.has("qid"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject16;
        bool2 = bool1;
        localObject5 = localObject18;
        l3 = l1;
        paramString = localJSONObject.getString("qid");
      }
      localObject1 = localObject17;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject16;
      bool2 = bool1;
      localObject5 = paramString;
      l3 = l1;
      if (localJSONObject.has("pos"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject16;
        bool2 = bool1;
        localObject5 = paramString;
        l3 = l1;
        localObject1 = localJSONObject.getString("pos");
      }
      localObject3 = localObject15;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject14;
      localObject6 = localObject1;
      bool2 = bool1;
      localObject5 = paramString;
      l3 = l1;
      if (localJSONObject.has("apRefId"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject14;
        localObject6 = localObject1;
        bool2 = bool1;
        localObject5 = paramString;
        l3 = l1;
        localObject3 = localJSONObject.getString("apRefId");
      }
      localObject2 = localObject13;
      localObject9 = localObject12;
      localObject8 = str;
      localObject7 = localObject3;
      localObject6 = localObject1;
      bool2 = bool1;
      localObject5 = paramString;
      l3 = l1;
      if (localJSONObject.has("recommand"))
      {
        localObject9 = localObject12;
        localObject8 = str;
        localObject7 = localObject3;
        localObject6 = localObject1;
        bool2 = bool1;
        localObject5 = paramString;
        l3 = l1;
        localObject2 = localJSONObject.optString("recommand");
      }
      localObject4 = localObject11;
      localObject9 = localObject2;
      localObject8 = str;
      localObject7 = localObject3;
      localObject6 = localObject1;
      bool2 = bool1;
      localObject5 = paramString;
      l3 = l1;
      if (localJSONObject.has("ccId"))
      {
        localObject9 = localObject2;
        localObject8 = str;
        localObject7 = localObject3;
        localObject6 = localObject1;
        bool2 = bool1;
        localObject5 = paramString;
        l3 = l1;
        localObject4 = localJSONObject.getString("ccId");
      }
      localObject9 = localObject2;
      localObject8 = localObject4;
      localObject7 = localObject3;
      localObject6 = localObject1;
      bool2 = bool1;
      localObject5 = paramString;
      l3 = l1;
      str = localJSONObject.optString("nearby");
      localObject9 = str;
      localObject5 = paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        h.a(paramString);
        localObject2 = localObject9;
        localObject9 = localObject10;
        localObject4 = localObject8;
        localObject3 = localObject7;
        localObject1 = localObject6;
        bool1 = bool2;
        l1 = l3;
        continue;
        a(paramWkAccessPoint);
      }
    }
    this.j = ((String)localObject5);
    this.k = new com.wifi.connect.plugin.magickey.c.a();
    this.k.f = bool1;
    this.k.h = l1;
    this.k.i = ((String)localObject1);
    this.k.Q = ((String)localObject2);
    this.m = ((String)localObject3);
    this.n = ((String)localObject4);
    this.o = ((String)localObject9);
    paramString = this.k;
    this.c = paramWkAccessPoint;
    this.h = parama;
    this.g = 0;
    this.i = false;
    this.h.a(3, null, c(30012));
    paramString.c = paramWkAccessPoint.a;
    paramString.d = paramWkAccessPoint.b;
    paramString.e = paramWkAccessPoint.d;
    parama = com.wifi.connect.plugin.magickey.database.a.a().b(paramWkAccessPoint.a);
    this.h.a(3, null, c(30013));
    if (parama != null)
    {
      this.h.a(3, null, c(30014));
      this.d = parama;
      this.d.m();
      this.e = new d[this.d.d.size()];
      this.f = new int[this.d.d.size()];
      paramString.g = true;
      this.q.obtainMessage(1, 1, this.d.l() + 1, this.d.i()).sendToTarget();
      return;
    }
  }
  
  public final void b(com.bluefay.b.a parama)
  {
    this.h.a(3, null, c(30010));
    if ((this.a instanceof Activity)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (!a(this.a)) {}
      for (;;)
      {
        return;
        if (i1 == 0)
        {
          parama.a(0, null, Integer.valueOf(10100));
        }
        else
        {
          k.a locala = new k.a(this.a);
          locala.a(R.string.dialog_whether_open_mobile_conn_title);
          Object localObject = LayoutInflater.from(this.a).inflate(R.layout.mobile_network_auto_enable_confirm, null);
          locala.a((View)localObject);
          localObject = (BLCheckBox)((View)localObject).findViewById(R.id.confirm_checkbox);
          ((BLCheckBox)localObject).setChecked(t.g(this.a));
          locala.a(R.string.btn_yes, new w(this, (BLCheckBox)localObject, parama));
          locala.b(R.string.btn_no, new x(this, parama));
          locala.a(new y(this, parama));
          if ((this.a instanceof Activity))
          {
            locala.c().show();
          }
          else
          {
            parama = locala.c();
            parama.getWindow().setType(2010);
            parama.show();
          }
        }
      }
    }
  }
  
  public final boolean b()
  {
    if (this.d != null) {}
    for (boolean bool = this.d.c;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */