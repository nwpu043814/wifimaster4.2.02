package com.wifi.connect.b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import bluefay.app.b;
import bluefay.app.k.a;
import bluefay.widget.BLCheckBox;
import com.bluefay.b.h;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.core.g.j;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.d.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class d
{
  private Context a;
  private com.bluefay.b.a b;
  private ArrayList<WkAccessPoint> c;
  private com.wifi.connect.c.f d;
  private com.bluefay.material.f e;
  private boolean f;
  private boolean g;
  private com.bluefay.b.a h = new e(this);
  private com.bluefay.b.a i = new n(this);
  private com.bluefay.b.a j = new o(this);
  private com.bluefay.b.a k = new p(this);
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void b(com.bluefay.b.a parama)
  {
    if ((this.a instanceof b)) {}
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        parama.a(0, "10006", null);
      }
      for (;;)
      {
        return;
        if (((b)this.a).c())
        {
          h.c("Activity is not running");
          parama.a(0, "10008", null);
        }
        else
        {
          k.a locala = new k.a(this.a);
          locala.a(R.string.connect_open_mobile_network_dia_title);
          locala.b(R.string.connect_open_mobile_network_dia_msg);
          locala.a(R.string.connect_open_mobile_network_dia_ok, new k(this, parama));
          locala.a(new l(this, parama));
          locala.c().show();
          com.lantern.analytics.a.e().onEvent("qa5m");
        }
      }
    }
  }
  
  private void c(com.bluefay.b.a parama)
  {
    if ((this.a instanceof b)) {}
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        parama.a(0, "10006", null);
      }
      for (;;)
      {
        return;
        if (((b)this.a).c())
        {
          h.c("Activity is not running");
          parama.a(0, "10008", null);
        }
        else
        {
          parama.a(0, "10006", null);
          parama = new k.a(this.a);
          parama.a(LayoutInflater.from(this.a).inflate(R.layout.connect_dia_nosim, null));
          parama.a(R.string.connect_open_mobile_network_nosim_dia_ok, new m(this));
          parama.c().show();
          com.lantern.analytics.a.e().onEvent("qa5m_nosim");
        }
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    if ((this.a instanceof b)) {}
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        parama.a(0, "10005", null);
      }
      for (;;)
      {
        return;
        if (((b)this.a).c())
        {
          h.c("Activity is not running");
          parama.a(0, "10008", null);
        }
        else
        {
          k.a locala = new k.a(this.a);
          locala.a(R.string.dlg_whether_open_mobile_conn_title);
          Object localObject = LayoutInflater.from(this.a).inflate(R.layout.connect_enable_mobile_confirm, null);
          locala.a((View)localObject);
          localObject = (BLCheckBox)((View)localObject).findViewById(R.id.confirm_checkbox);
          ((BLCheckBox)localObject).setChecked(com.lantern.core.t.g(this.a));
          locala.a(R.string.btn_yes, new s(this, (BLCheckBox)localObject, parama));
          locala.b(R.string.btn_no, new t(this, parama));
          locala.a(new u(this, parama));
          locala.c().show();
        }
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama, int paramInt)
  {
    if ((this.a instanceof b)) {}
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        parama.a(0, String.valueOf(paramInt), null);
      }
      for (;;)
      {
        return;
        if (((b)this.a).c())
        {
          h.c("Activity is not running");
          parama.a(0, "10008", null);
        }
        else
        {
          k.a locala = new k.a(this.a);
          locala.a(R.string.dialog_manually_enable_mobile_connection_title_by_auto_failed);
          locala.b(R.string.dialog_manually_enable_mobile_connection_message_by_auto_failed);
          locala.a(R.string.btn_ok, new f(this, parama, paramInt));
          locala.a(new g(this, parama, paramInt));
          locala.c().show();
        }
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama, boolean paramBoolean)
  {
    a(com.lantern.core.g.u.a(this.a), parama, paramBoolean);
  }
  
  public final void a(ArrayList<WkAccessPoint> paramArrayList, com.bluefay.b.a parama, boolean paramBoolean)
  {
    this.g = false;
    this.f = paramBoolean;
    this.c = paramArrayList;
    this.b = parama;
    this.d = new com.wifi.connect.c.f();
    com.wifi.connect.c.f localf = this.d;
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WkAccessPoint localWkAccessPoint = (WkAccessPoint)((Iterator)localObject).next();
        localHashMap.put(localWkAccessPoint.a, localWkAccessPoint);
      }
    }
    Object localObject = localHashMap.values();
    if (localObject != null)
    {
      m = ((Collection)localObject).size();
      localf.c = m;
      this.d.d = paramArrayList.size();
      if ((this.c != null) && (this.c.size() != 0)) {
        break label308;
      }
      if (paramBoolean) {
        break label293;
      }
      if (!(this.a instanceof b)) {
        break label590;
      }
    }
    label293:
    label308:
    label590:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        this.h.a(0, "10007", null);
      }
      for (;;)
      {
        return;
        m = 0;
        break;
        if (((b)this.a).c())
        {
          h.c("Activity is not running");
          this.h.a(0, "10007", null);
        }
        else
        {
          paramArrayList = new k.a(this.a);
          paramArrayList.a(R.string.dialog_title_none_aps);
          paramArrayList.b(R.string.dialog_msg_none_aps);
          paramArrayList.a(R.string.dialog_btn_ok, new q(this));
          paramArrayList.a(new r(this));
          paramArrayList.d();
          continue;
          this.b.a(0, null, null);
          continue;
          if (!com.bluefay.a.a.c(this.a))
          {
            if (paramBoolean) {
              this.h.a(0, "10013", null);
            } else if (Build.VERSION.SDK_INT >= 21)
            {
              if (com.lantern.auth.utils.a.b(this.a)) {
                b(this.h);
              } else {
                c(parama);
              }
            }
            else if (com.lantern.core.t.g(this.a)) {
              new c(this.i).execute(new String[0]);
            } else {
              a(this.i);
            }
          }
          else if (com.bluefay.a.a.a(this.a)) {
            j.a().a(this.k);
          } else if (com.bluefay.a.a.b(this.a))
          {
            if (paramBoolean)
            {
              long l = com.bluefay.a.d.a(com.bluefay.d.a.getAppContext(), "sdk_common", "auto_query_time", 0L);
              if (System.currentTimeMillis() - l < 3600000L)
              {
                this.b.a(0, null, null);
              }
              else
              {
                new com.wifi.connect.d.d(this.c, this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                com.bluefay.a.d.b(com.bluefay.d.a.getAppContext(), "sdk_common", "auto_query_time", System.currentTimeMillis());
              }
            }
            else
            {
              new com.wifi.connect.d.d(this.c, this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
          }
          else {
            this.h.a(0, "10000", null);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */