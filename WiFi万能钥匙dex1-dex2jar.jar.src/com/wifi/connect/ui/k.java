package com.wifi.connect.ui;

import bluefay.app.b;
import com.bluefay.b.h;
import com.wifi.connect.model.f;
import com.wifi.connect.widget.d;

final class k
  implements com.bluefay.b.a
{
  k(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    h.a("share retcode:%d, retmsg:%s, data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 2)
    {
      ConnectFragment.E(this.a);
      return;
    }
    if ((paramString != null) && (paramString.equals("share")))
    {
      if (!(paramObject instanceof f)) {
        break label417;
      }
      paramString = (f)paramObject;
      if ((!paramString.c()) || (!paramString.g())) {}
    }
    label204:
    label311:
    label316:
    label347:
    label378:
    label407:
    label417:
    for (boolean bool = true;; bool = false)
    {
      if ((ConnectFragment.F(this.a) != null) && ((ConnectFragment.G(this.a) instanceof b)) && (!((b)ConnectFragment.H(this.a)).c()))
      {
        paramString = new d(ConnectFragment.I(this.a), ConnectFragment.J(this.a), bool);
        paramString.setOnDismissListener(new l(this));
        paramString.show();
        break;
        ConnectFragment.E(this.a);
        break;
      }
      if ((paramObject instanceof f))
      {
        paramString = (f)paramObject;
        if (paramString.c())
        {
          if (10 != paramString.a) {
            break label311;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label316;
          }
          com.lantern.analytics.a.e().onEvent("keysh1");
        }
        for (;;)
        {
          if ((!paramString.c()) || (!paramString.g()) || (ConnectFragment.K(this.a) == null) || (!(ConnectFragment.L(this.a) instanceof b)) || (((b)ConnectFragment.M(this.a)).c())) {
            break label407;
          }
          paramString = new d(ConnectFragment.N(this.a), ConnectFragment.J(this.a), true);
          paramString.setOnDismissListener(new m(this));
          paramString.show();
          break;
          paramInt = 0;
          break label204;
          if (101 == paramString.b) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label347;
            }
            com.lantern.analytics.a.e().onEvent("keysh6");
            break;
          }
          if (102 == paramString.b) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label378;
            }
            com.lantern.analytics.a.e().onEvent("keysh8");
            break;
          }
          paramInt = i;
          if (100 == paramString.b) {
            paramInt = 1;
          }
          if (paramInt != 0) {
            com.lantern.analytics.a.e().onEvent("keysh2");
          }
        }
      }
      ConnectFragment.E(this.a);
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */