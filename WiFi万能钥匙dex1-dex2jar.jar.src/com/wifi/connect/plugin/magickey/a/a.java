package com.wifi.connect.plugin.magickey.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import bluefay.app.k.a;
import bluefay.widget.BLCheckBox;
import com.lantern.core.g.r;
import com.lantern.core.g.r.a;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.R.id;
import com.wifi.connect.plugin.magickey.R.layout;
import com.wifi.connect.plugin.magickey.R.string;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements al
{
  private Context a;
  private r b;
  private WkAccessPoint c;
  private com.wifi.connect.plugin.magickey.b.b d;
  private int e = 0;
  private com.bluefay.b.a f;
  private boolean g;
  private String h;
  private com.wifi.connect.plugin.magickey.c.a i;
  private com.bluefay.material.f j;
  private String k;
  private String l;
  private Handler m = new b(this);
  private com.bluefay.b.a n = new h(this);
  private com.bluefay.b.a o = new i(this);
  private com.bluefay.b.a p = new j(this);
  private com.bluefay.b.a q = new k(this);
  private com.bluefay.b.a r = new l(this);
  private com.bluefay.b.a s = new m(this);
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new r(this.a);
    this.b.a();
  }
  
  private void a(WkAccessPoint paramWkAccessPoint)
  {
    this.f.a(3, null, b(30015));
    if (!com.bluefay.a.a.c(this.a))
    {
      this.i.j = System.currentTimeMillis();
      this.i.k = false;
      this.i.l = "";
      if (Build.VERSION.SDK_INT >= 21) {
        a(this.q);
      }
    }
    for (;;)
    {
      return;
      if (t.g(this.a))
      {
        new com.wifi.connect.plugin.magickey.d.b(this.q).execute(new String[0]);
      }
      else
      {
        b(this.q);
        continue;
        if (com.bluefay.a.a.a(this.a))
        {
          com.lantern.core.g.j.a().a(this.r);
        }
        else
        {
          this.i.j = System.currentTimeMillis();
          this.i.k = true;
          this.i.l = "g";
          a(paramWkAccessPoint, this.s);
        }
      }
    }
  }
  
  private static at.a b(int paramInt)
  {
    return new at.a(paramInt);
  }
  
  private void b(int paramInt, Object paramObject)
  {
    if (paramInt == 1)
    {
      this.i.P = System.currentTimeMillis();
      this.i.N = true;
      this.m.sendEmptyMessageDelayed(3, 2000L);
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        this.i.P = System.currentTimeMillis();
        this.i.N = false;
        if ((paramObject instanceof r.a)) {
          this.i.O = ((r.a)paramObject).a;
        }
        this.m.sendEmptyMessageDelayed(3, 2000L);
      }
    }
  }
  
  public final void a()
  {
    this.g = true;
    r.a locala = new r.a(10009, u.b(this.a, this.c));
    b(0, locala);
    a(0, locala);
    this.f.a(0, "CANCELED", locala);
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof r.a)))
    {
      paramObject = ((r.a)paramObject).b;
      new r(this.a).b((WifiConfiguration)paramObject, null);
    }
  }
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {
      if ((this.d != null) && (this.d.h()))
      {
        paramString = new com.wifi.connect.plugin.magickey.c.b();
        paramString.f = "0";
        paramString.b = this.c.a;
        paramString.c = this.c.b;
        paramString.e = this.d.a;
        paramString.a = this.d.a(0).c;
        paramString.d = this.d.a(0).a;
        paramString.h = u.a(this.a, this.c);
        paramString.k = com.lantern.core.k.h(this.a);
        paramString.l = com.lantern.core.k.i(this.a);
        paramString.m = this.d.a(0).d;
        new Handler().postDelayed(new n(this, paramString), 1500L);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt == 0) && (this.d != null) && (this.d.h()))
      {
        com.wifi.connect.plugin.magickey.c.b localb = new com.wifi.connect.plugin.magickey.c.b();
        localb.f = "10000";
        if ((paramObject instanceof r.a)) {
          localb.f = ((r.a)paramObject).a;
        }
        localb.g = paramString;
        localb.b = this.c.a;
        localb.c = this.c.b;
        localb.e = this.d.a;
        localb.a = this.d.a(0).c;
        localb.d = this.d.a(0).a;
        localb.h = u.a(this.a, this.c);
        localb.k = com.lantern.core.k.h(this.a);
        localb.l = com.lantern.core.k.i(this.a);
        localb.m = this.d.a(0).d;
        new Handler().postDelayed(new o(this, localb), 1500L);
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    this.f.a(3, null, b(30011));
    k.a locala = new k.a(this.a);
    locala.a(R.string.dialog_manually_enable_mobile_connection_title);
    locala.b(R.string.dialog_manually_enable_mobile_connection_message);
    locala.a(R.string.btn_iknow, new c(this, parama));
    locala.a(new d(this, parama));
    if ((this.a instanceof Activity)) {
      locala.c().show();
    }
    for (;;)
    {
      return;
      parama = locala.c();
      parama.getWindow().setType(2010);
      parama.show();
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, com.bluefay.b.a parama)
  {
    ArrayList localArrayList = u.a(this.a, paramWkAccessPoint);
    new com.wifi.connect.plugin.magickey.d.c(this.h, paramWkAccessPoint, localArrayList, this.k, this.l, parama).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString, com.bluefay.b.a parama)
  {
    long l4 = 0L;
    localObject1 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    localObject2 = null;
    Object localObject10 = null;
    String str1 = null;
    localObject3 = null;
    Object localObject9 = null;
    String str2 = null;
    localObject8 = null;
    localObject7 = localObject8;
    localObject5 = localObject3;
    localObject6 = localObject2;
    bool3 = bool2;
    localObject4 = localObject1;
    l3 = l4;
    if (paramString != null)
    {
      localObject7 = localObject8;
      localObject5 = localObject3;
      localObject6 = localObject2;
      bool3 = bool2;
      localObject4 = localObject1;
      l3 = l4;
      if (paramString.length() > 0)
      {
        localObject3 = localObject9;
        localObject1 = localObject10;
        bool2 = bool4;
        localObject2 = localObject11;
        l2 = l4;
      }
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localObject3 = localObject9;
      localObject1 = localObject10;
      bool2 = bool4;
      localObject2 = localObject11;
      l2 = l4;
      localJSONObject.<init>(paramString);
      long l1 = l4;
      localObject3 = localObject9;
      localObject1 = localObject10;
      bool2 = bool4;
      localObject2 = localObject11;
      l2 = l4;
      if (localJSONObject.has("cacheTime"))
      {
        localObject3 = localObject9;
        localObject1 = localObject10;
        bool2 = bool4;
        localObject2 = localObject11;
        l2 = l4;
        l1 = localJSONObject.getLong("cacheTime");
      }
      localObject3 = localObject9;
      localObject1 = localObject10;
      bool2 = bool4;
      localObject2 = localObject11;
      l2 = l1;
      if (localJSONObject.has("hasKey"))
      {
        localObject3 = localObject9;
        localObject1 = localObject10;
        bool2 = bool4;
        localObject2 = localObject11;
        l2 = l1;
        bool1 = localJSONObject.getBoolean("hasKey");
      }
      paramString = (String)localObject12;
      localObject3 = localObject9;
      localObject1 = localObject10;
      bool2 = bool1;
      localObject2 = localObject11;
      l2 = l1;
      if (localJSONObject.has("qid"))
      {
        localObject3 = localObject9;
        localObject1 = localObject10;
        bool2 = bool1;
        localObject2 = localObject11;
        l2 = l1;
        paramString = localJSONObject.getString("qid");
      }
      localObject3 = localObject9;
      localObject1 = localObject10;
      bool2 = bool1;
      localObject2 = paramString;
      l2 = l1;
      if (localJSONObject.has("pos"))
      {
        localObject3 = localObject9;
        localObject1 = localObject10;
        bool2 = bool1;
        localObject2 = paramString;
        l2 = l1;
        str1 = localJSONObject.getString("pos");
      }
      localObject3 = localObject9;
      localObject1 = str1;
      bool2 = bool1;
      localObject2 = paramString;
      l2 = l1;
      if (localJSONObject.has("apRefId"))
      {
        localObject3 = localObject9;
        localObject1 = str1;
        bool2 = bool1;
        localObject2 = paramString;
        l2 = l1;
        str2 = localJSONObject.getString("apRefId");
      }
      localObject7 = localObject8;
      localObject5 = str2;
      localObject6 = str1;
      bool3 = bool1;
      localObject4 = paramString;
      l3 = l1;
      localObject3 = str2;
      localObject1 = str1;
      bool2 = bool1;
      localObject2 = paramString;
      l2 = l1;
      if (localJSONObject.has("ccId"))
      {
        localObject3 = str2;
        localObject1 = str1;
        bool2 = bool1;
        localObject2 = paramString;
        l2 = l1;
        localObject7 = localJSONObject.getString("ccId");
        l3 = l1;
        localObject4 = paramString;
        bool3 = bool1;
        localObject6 = str1;
        localObject5 = str2;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramString);
        localObject7 = localObject8;
        localObject5 = localObject3;
        localObject6 = localObject1;
        bool3 = bool2;
        localObject4 = localObject2;
        l3 = l2;
        continue;
        a(paramWkAccessPoint);
      }
    }
    this.h = ((String)localObject4);
    this.i = new com.wifi.connect.plugin.magickey.c.a();
    this.i.f = bool3;
    this.i.h = l3;
    this.i.i = ((String)localObject6);
    this.k = ((String)localObject5);
    this.l = ((String)localObject7);
    paramString = this.i;
    this.c = paramWkAccessPoint;
    this.f = parama;
    this.e = 0;
    this.g = false;
    this.f.a(3, null, b(30012));
    paramString.c = paramWkAccessPoint.a;
    paramString.d = paramWkAccessPoint.b;
    paramString.e = paramWkAccessPoint.d;
    this.f.a(3, null, b(30013));
    parama = com.wifi.connect.plugin.magickey.database.a.a().b(paramWkAccessPoint.a);
    if (parama != null)
    {
      this.f.a(3, null, b(30014));
      this.d = parama;
      paramString.g = true;
      this.m.sendEmptyMessage(1);
      return;
    }
  }
  
  public final void b(com.bluefay.b.a parama)
  {
    this.f.a(3, null, b(30010));
    k.a locala = new k.a(this.a);
    locala.a(R.string.dialog_whether_open_mobile_conn_title);
    Object localObject = LayoutInflater.from(this.a).inflate(R.layout.mobile_network_auto_enable_confirm, null);
    locala.a((View)localObject);
    localObject = (BLCheckBox)((View)localObject).findViewById(R.id.confirm_checkbox);
    ((BLCheckBox)localObject).setChecked(t.g(this.a));
    locala.a(R.string.btn_yes, new e(this, (BLCheckBox)localObject, parama));
    locala.b(R.string.btn_no, new f(this, parama));
    locala.a(new g(this, parama));
    if ((this.a instanceof Activity)) {
      locala.c().show();
    }
    for (;;)
    {
      return;
      parama = locala.c();
      parama.getWindow().setType(2010);
      parama.show();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */