package com.wifi.connect.ui;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.g.j;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.a.e;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointKey;

final class c
  extends com.bluefay.d.b
{
  c(ConnectFragment paramConnectFragment, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    int i = paramMessage.what;
    h.a("handle what:" + i);
    Object localObject1;
    int j;
    Object localObject3;
    Object localObject4;
    String str1;
    String str3;
    String str2;
    String str4;
    switch (i)
    {
    default: 
    case 128101: 
    case 128102: 
    case 128036: 
    case 128035: 
    case 128030: 
      for (;;)
      {
        return;
        if (paramMessage.arg1 == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = (String)paramMessage.obj;
          h.b("ssid:%s, success:%s, security:%s", new Object[] { localObject1, Boolean.valueOf(bool), Integer.valueOf(paramMessage.arg2) });
          if (!bool) {
            break;
          }
          ConnectFragment.a(this.a, (String)localObject1, paramMessage.arg2);
          ConnectFragment.b(this.a, (String)localObject1, paramMessage.arg2);
          break;
        }
        ConnectFragment.a(this.a);
        continue;
        i = paramMessage.arg1;
        ConnectFragment.a(this.a, i, true);
        if (j.b(i))
        {
          ConnectFragment.b(this.a);
          continue;
          ConnectFragment.a(this.a, true);
          continue;
          i = paramMessage.arg1;
          ConnectFragment.a(this.a, false);
          ConnectFragment.a(this.a, i, false);
          if (j.b(i))
          {
            ConnectFragment.b(this.a);
            ConnectFragment.a(this.a, false, "");
            ConnectFragment.c(this.a);
            ConnectFragment.a(this.a);
          }
          else if (j.a(i))
          {
            paramMessage = ConnectFragment.d(this.a).b();
            if (paramMessage != null)
            {
              ConnectFragment.a(this.a, true, paramMessage.a);
              ConnectFragment.a(this.a, paramMessage);
            }
          }
        }
      }
    case 128100: 
      j = paramMessage.arg1;
      i = paramMessage.arg2;
      localObject1 = "";
      localObject3 = "";
      localObject4 = paramMessage.getData();
      if (localObject4 != null)
      {
        str1 = ((Bundle)localObject4).getString("retmsg");
        str3 = ((Bundle)localObject4).getString("ssid");
        str2 = ((Bundle)localObject4).getString("pkg");
        str4 = ((Bundle)localObject4).getString("bssid");
        if ((!TextUtils.isEmpty(str2)) && (str2.equals("com.wifi.connect.plugin.webauth")))
        {
          ConnectFragment.a(this.a);
          com.lantern.analytics.a.e().onEvent("excon");
          if (j != 1) {
            break label919;
          }
          com.lantern.analytics.a.e().onEvent("exconsuc");
          localObject4 = str1;
          localObject1 = str3;
          localObject3 = str4;
          localObject2 = str2;
        }
      }
      break;
    }
    for (;;)
    {
      h.a("retcode:%d, code:%d, retmsg:%s, ssid:%s, obj:%s, pkg:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localObject4, localObject1, paramMessage.obj, localObject2 });
      if (j == 1)
      {
        if (j.b(i))
        {
          ConnectFragment.a(this.a, i, true);
          ConnectFragment.b(this.a);
          ConnectFragment.a(this.a, false, "");
        }
        if (i != -100) {
          break;
        }
        paramMessage = ConnectFragment.e(this.a).getConnectionInfo();
        if (paramMessage != null)
        {
          i = paramMessage.getNetworkId();
          if (i != -1)
          {
            paramMessage = u.a(ConnectFragment.f(this.a), i);
            if (paramMessage != null)
            {
              localObject2 = new AccessPointKey(new WkAccessPoint(paramMessage));
              if (e.b().a((AccessPointKey)localObject2))
              {
                paramMessage = e.b().a((WkAccessPoint)localObject2);
                ((AccessPointKey)localObject2).k = paramMessage.k;
                ((AccessPointKey)localObject2).i = paramMessage.i;
                ((AccessPointKey)localObject2).j = paramMessage.j;
                ((AccessPointKey)localObject2).m = paramMessage.m;
                ((AccessPointKey)localObject2).l = paramMessage.l;
                ((AccessPointKey)localObject2).n = paramMessage.n;
                ((AccessPointKey)localObject2).o = paramMessage.o;
                if (e.b().d((WkAccessPoint)localObject2)) {
                  ((AccessPointKey)localObject2).p = "1";
                }
              }
              e.b().a((String)localObject1, (AccessPointKey)localObject2);
              break;
              if ((!TextUtils.isEmpty(str2)) && (str2.equals("com.wifi.connect.plugin.chinanet"))) {}
              switch (j)
              {
              default: 
                break;
              case 0: 
                com.lantern.analytics.a.e().onEvent("concnet0", str1);
                break;
              case 1: 
                com.lantern.analytics.a.e().onEvent("concnet1");
                break;
                if ((TextUtils.isEmpty(str2)) || (!str2.equals("com.wifi.connect.plugin.cmcc"))) {
                  break;
                }
                switch (j)
                {
                case 2: 
                default: 
                  break;
                case 0: 
                  com.lantern.analytics.a.e().onEvent("concmcc0", str1);
                  break;
                case 1: 
                  com.wifi.connect.b.ad.a = true;
                  com.lantern.analytics.a.e().onEvent("concmcc1");
                  break;
                case 3: 
                  com.lantern.analytics.a.e().onEvent("concmcc4", str1);
                  break;
                  label919:
                  localObject2 = str2;
                  localObject3 = str4;
                  localObject1 = str3;
                  localObject4 = str1;
                  if (j != 0) {
                    continue;
                  }
                  com.lantern.analytics.a.e().onEvent("exconfai", str1);
                  localObject2 = str2;
                  localObject3 = str4;
                  localObject1 = str3;
                  localObject4 = str1;
                }
                break;
              }
            }
          }
        }
        paramMessage = new AccessPointKey();
        paramMessage.c = 2;
        e.b().a((String)localObject1, paramMessage);
        break;
      }
      if (j == 0)
      {
        if ((i == 10100) || (i == 10101) || (i == 10102) || (i == 10103) || (i == 10104)) {
          break;
        }
        com.wifi.connect.a.b.b().a((String)localObject1, (String)localObject3);
        break;
      }
      if (j != 3) {
        break;
      }
      break;
      localObject1 = (NetworkInfo)((Intent)paramMessage.obj).getParcelableExtra("networkInfo");
      paramMessage = ((NetworkInfo)localObject1).getDetailedState();
      h.a("detailstate:" + paramMessage, new Object[0]);
      if (paramMessage == NetworkInfo.DetailedState.CONNECTED)
      {
        paramMessage = u.a(((NetworkInfo)localObject1).getExtraInfo());
        this.a.a(paramMessage, true);
        break;
      }
      if (paramMessage != NetworkInfo.DetailedState.DISCONNECTED) {
        break;
      }
      ConnectFragment.g(this.a);
      ConnectFragment.a(this.a, false, "");
      if (ConnectFragment.h(this.a)) {
        ConnectFragment.i(this.a);
      }
      if ((ConnectFragment.j(this.a).a()) || (ConnectFragment.d(this.a).a())) {
        break;
      }
      ConnectFragment.d(this.a).a(true);
      ConnectFragment.k(this.a);
      break;
      paramMessage = (WkAccessPoint)paramMessage.obj;
      ConnectFragment.a(this.a, paramMessage);
      break;
      paramMessage = (Bundle)paramMessage.obj;
      if ((paramMessage == null) || (!paramMessage.containsKey("path"))) {
        break;
      }
      ConnectFragment.a(this.a, paramMessage);
      break;
      localObject4 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */