package com.lantern.core.g;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Message;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.model.WkAccessPoint;

final class s
  extends b
{
  s(r paramr, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 1;
    int i = paramMessage.what;
    h.a("handle what:" + i);
    switch (i)
    {
    }
    for (;;)
    {
      return;
      paramMessage = (Intent)paramMessage.obj;
      if (paramMessage.getIntExtra("supplicantError", -1) == 1)
      {
        if (r.a(this.a) != null)
        {
          r.b(this.a);
          r.c(this.a);
          r.a(this.a).a(0, "ERRORPWD", r.a(this.a, 10003));
          r.d(this.a);
        }
      }
      else
      {
        paramMessage = (SupplicantState)paramMessage.getParcelableExtra("newState");
        if ((r.a(this.a) != null) && (paramMessage != null))
        {
          r.a(this.a).a(3, paramMessage.toString(), null);
          continue;
          paramMessage = (NetworkInfo)((Intent)paramMessage.obj).getParcelableExtra("networkInfo");
          NetworkInfo.DetailedState localDetailedState = paramMessage.getDetailedState();
          if ((localDetailedState == NetworkInfo.DetailedState.CONNECTED) || (localDetailedState == NetworkInfo.DetailedState.DISCONNECTED)) {
            r.a(this.a, null);
          }
          String str;
          if (r.a(this.a) != null)
          {
            if (localDetailedState != NetworkInfo.DetailedState.CONNECTED) {
              break label619;
            }
            str = u.a(paramMessage.getExtraInfo());
            paramMessage = str;
            if (!u.c(str))
            {
              if ((str != null) && (str.length() > 0)) {
                continue;
              }
              paramMessage = r.e(this.a).getConnectionInfo();
              h.a("info:" + paramMessage);
              if ((paramMessage == null) || (paramMessage.getSSID() == null)) {
                continue;
              }
              str = u.a(paramMessage.getSSID());
              paramMessage = str;
              if (!u.a(str, r.f(this.a).SSID))
              {
                paramMessage = String.format("%s_%s", new Object[] { r.f(this.a).SSID, str });
                h.a("diff1:" + paramMessage);
                com.lantern.analytics.a.e().onEvent("diff1", paramMessage);
                continue;
              }
            }
            if (!u.a(paramMessage, r.f(this.a).SSID))
            {
              paramMessage = String.format("%s_%s", new Object[] { r.f(this.a).SSID, paramMessage });
              h.a("diff2:" + paramMessage);
              com.lantern.analytics.a.e().onEvent("diff2", paramMessage);
              continue;
            }
            r.b(this.a);
            r.c(this.a);
            r.a(this.a).a(1, "CONNECTED", r.a(this.a, 10001));
            r.d(this.a);
          }
          for (;;)
          {
            if (r.g(this.a) == null) {
              break label755;
            }
            if (localDetailedState != NetworkInfo.DetailedState.DISCONNECTED) {
              break label757;
            }
            r.b(this.a);
            r.c(this.a);
            r.g(this.a).a(1, "DISCONNECTED", r.a(this.a, 20001));
            r.h(this.a);
            break;
            label619:
            if (localDetailedState == NetworkInfo.DetailedState.FAILED)
            {
              r.b(this.a);
              r.c(this.a);
              r.a(this.a).a(0, "FAILED", r.a(this.a, 10000));
              r.d(this.a);
            }
            else if (localDetailedState == NetworkInfo.DetailedState.BLOCKED)
            {
              r.b(this.a);
              r.c(this.a);
              r.a(this.a).a(0, "BLOCKED", r.a(this.a, 10000));
              r.d(this.a);
            }
            else
            {
              r.a(this.a).a(3, localDetailedState.toString(), null);
            }
          }
          label755:
          continue;
          label757:
          r.g(this.a).a(3, localDetailedState.toString(), null);
          continue;
          r.b(this.a);
          r.c(this.a);
          if (r.a(this.a) != null)
          {
            r.a(this.a).a(0, "WIFI_ABNORMAL", r.a(this.a, 10008));
            r.d(this.a);
          }
          if (r.g(this.a) != null)
          {
            r.g(this.a).a(0, "WIFI_ABNORMAL", r.a(this.a, 10008));
            r.h(this.a);
          }
          if (r.i(this.a) != null)
          {
            r.i(this.a).a(0, "WIFI_ABNORMAL", r.a(this.a, 10008));
            r.j(this.a);
            continue;
            r.b(this.a);
            i = paramMessage.arg1;
            if ((i == 1) && (r.a(this.a) != null))
            {
              str = "TIME_OUT";
              int k = 10007;
              paramMessage = str;
              i = k;
              if (r.k(this.a))
              {
                paramMessage = str;
                i = k;
                if (r.l(this.a) != null)
                {
                  paramMessage = u.c(r.m(this.a), r.l(this.a));
                  if (paramMessage != null) {
                    break label1065;
                  }
                }
              }
              for (;;)
              {
                paramMessage = str;
                i = k;
                if (j != 0)
                {
                  paramMessage = "POOR_SIGNAL";
                  i = 10006;
                }
                r.a(this.a).a(0, paramMessage, r.a(this.a, i));
                r.d(this.a);
                break;
                label1065:
                if (!u.a(paramMessage.d)) {
                  j = 0;
                }
              }
            }
            if ((i == 2) && (r.g(this.a) != null))
            {
              r.g(this.a).a(0, "TIME_OUT", r.a(this.a, 10007));
              r.h(this.a);
              continue;
              if (r.i(this.a) != null)
              {
                r.i(this.a).a(1, "FORGETED", r.a(this.a, 30001));
                r.j(this.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */