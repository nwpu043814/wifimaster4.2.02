package com.wifi.connect.ui;

import android.net.wifi.WifiConfiguration;
import com.bluefay.b.h;
import com.lantern.core.g.r.a;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.b.v;
import com.wifi.connect.model.AccessPoint;

final class o
  implements com.bluefay.b.a
{
  o(ConnectFragment paramConnectFragment, boolean paramBoolean1, WkAccessPoint paramWkAccessPoint, int paramInt, boolean paramBoolean2, boolean paramBoolean3, String paramString1, boolean paramBoolean4, WifiConfiguration paramWifiConfiguration, AccessPoint paramAccessPoint, String paramString2, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject;
    if (paramObject == null)
    {
      localObject = "null";
      h.a("result,retCode:%s,retmsg:%s,response:%s", new Object[] { Integer.valueOf(paramInt), paramString, localObject });
      if (paramInt != 1) {
        break label476;
      }
      if (this.a) {
        com.lantern.analytics.a.e().onEvent("nnlcs");
      }
      com.wifi.connect.e.a.a(paramInt, paramString, paramObject);
      ConnectFragment.P(this.n);
      ConnectFragment.a(this.n, this.b, 1);
      ConnectFragment.d(this.n).b(true);
      if (!(paramObject instanceof r.a)) {
        break label258;
      }
      paramString = ((r.a)paramObject).b;
      label105:
      if (this.c != 1) {
        break label298;
      }
      com.lantern.analytics.a.e().onEvent("conbyuserown_s");
      ConnectFragment.Q(this.n);
      if (!this.d) {
        break label263;
      }
      new v(ConnectFragment.S(this.n)).a(this.e, this.b, this.f, ConnectFragment.R(this.n));
      label172:
      paramInt = 2;
    }
    for (;;)
    {
      label174:
      if (this.c != 0)
      {
        if (this.k)
        {
          h.a("backup now", new Object[0]);
          new com.wifi.connect.b.a(ConnectFragment.Y(this.n)).a(this.l, this.b, paramString, ConnectFragment.X(this.n));
        }
      }
      else {
        label230:
        ConnectFragment.a(this.n, paramInt, this.i);
      }
      for (;;)
      {
        return;
        localObject = Integer.valueOf(((r.a)paramObject).a);
        break;
        label258:
        paramString = null;
        break label105;
        label263:
        new v(ConnectFragment.T(this.n)).a(this.b, this.f, ConnectFragment.R(this.n));
        break label172;
        label298:
        if (this.c == 2)
        {
          ConnectFragment.Q(this.n);
          if (!ConnectFragment.J(this.n))
          {
            new v(ConnectFragment.U(this.n)).b(this.g, this.b, this.f, ConnectFragment.R(this.n));
            paramInt = 3;
            break label174;
          }
          if (this.h == null) {
            break label809;
          }
          this.i.d(this.j);
          new v(ConnectFragment.V(this.n)).a(this.g, this.b, this.i.d(), ConnectFragment.J(this.n), ConnectFragment.R(this.n));
          paramInt = 5;
          break label174;
        }
        if (this.c != 0) {
          break label809;
        }
        paramInt = 100;
        if (!ConnectFragment.W(this.n)) {
          break label174;
        }
        paramInt = 1;
        break label174;
        com.wifi.backup.a.a.b().a(this.b, this.f);
        break label230;
        label476:
        if ((paramInt == 0) || (paramInt == 2))
        {
          if ((this.c == 2) && (this.h != null) && (ConnectFragment.J(this.n)))
          {
            ConnectFragment.R(this.n).a(paramInt, "share", Boolean.valueOf(false));
            paramInt = 2;
          }
          for (;;)
          {
            ConnectFragment.P(this.n);
            if (this.c == 1) {
              com.lantern.analytics.a.e().onEvent("conbyuserown_f");
            }
            if ((this.c == 1) || (this.c == 2)) {
              ConnectFragment.k(this.n, this.i);
            }
            ConnectFragment.a(this.n, this.b, 0);
            ConnectFragment.d(this.n).b(false);
            ConnectFragment.Z(this.n);
            if ((paramInt == 0) && (this.c != 1)) {
              com.wifi.connect.a.b.b().a(this.b.a(), this.b.b());
            }
            if ((!this.m) || (paramInt != 0) || (!(paramObject instanceof r.a)) || (((r.a)paramObject).a != 10003) || (ConnectFragment.aa(this.n) == null) || (!ConnectFragment.aa(this.n).a.equals(this.b.a))) {
              break;
            }
            if ((!this.n.isDetached()) && (!this.n.isHidden())) {
              break label745;
            }
            h.a("Fragment isDetached");
            break;
            com.wifi.connect.e.a.a(paramInt, paramString, paramObject);
          }
          label745:
          if (((bluefay.app.b)ConnectFragment.ab(this.n)).c()) {
            h.a("Activity isDestoryed");
          } else {
            ConnectFragment.a(this.n, ConnectFragment.aa(this.n), ConnectFragment.ac(this.n), true);
          }
        }
        else
        {
          ConnectFragment.a(this.n, this.b, 3);
        }
      }
      label809:
      paramInt = -1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */