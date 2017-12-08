package com.wifi.connect.plugin.magickey;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import com.qihoo.util.StubApp1053578832;
import com.wifi.connect.plugin.magickey.a.ah;
import com.wifi.connect.plugin.magickey.a.al;
import com.wifi.connect.plugin.magickey.a.as;
import com.wifi.connect.plugin.magickey.a.p;
import com.wifi.connect.plugin.magickey.c.e;

public class ConnectService
  extends Service
{
  private al a;
  private com.bluefay.b.a b = new m(this);
  
  static
  {
    StubApp1053578832.interface11(91);
  }
  
  private int a(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("ssid");
    if ((localObject2 == null) || (((String)localObject2).length() == 0)) {}
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          return 2;
          localObject1 = paramIntent.getStringExtra("bssid");
        } while ((localObject1 == null) || (((String)localObject1).length() == 0));
        j = paramIntent.getIntExtra("security", -1);
      } while (j == -1);
      i = paramIntent.getIntExtra("rssi", Integer.MAX_VALUE);
    } while (i == Integer.MAX_VALUE);
    localObject2 = new WkAccessPoint((String)localObject2, (String)localObject1);
    ((WkAccessPoint)localObject2).c = j;
    ((WkAccessPoint)localObject2).d = i;
    Object localObject1 = new Intent(this, ConnectActivity.class);
    ((Intent)localObject1).setFlags(268435456);
    ((Intent)localObject1).putExtra("ap", (Parcelable)localObject2);
    if (paramIntent.hasExtra("ext")) {}
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getStringExtra("ext");
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("ext:");
        h.a(paramIntent);
        if (paramIntent != null)
        {
          if (!paramIntent.startsWith("{")) {
            continue;
          }
          ((Intent)localObject1).putExtra("ext", paramIntent);
        }
      }
      catch (Exception paramIntent)
      {
        continue;
      }
      startActivity((Intent)localObject1);
      break;
      paramIntent = paramIntent.split("\\|");
      if (paramIntent.length > 0) {
        ((Intent)localObject1).putExtra("haskey", Boolean.parseBoolean(paramIntent[0]));
      }
      if (paramIntent.length >= 2) {
        ((Intent)localObject1).putExtra("cacheTime", Long.parseLong(paramIntent[1]));
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 2;
    h.b("intent:%s,flags:%d,startId:%d", new Object[] { paramIntent, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramInt1 = i;
    String str1;
    if (paramIntent != null)
    {
      str1 = paramIntent.getStringExtra("what");
      if (!"connect".equals(str1)) {
        break label63;
      }
      paramInt1 = a(paramIntent);
    }
    for (;;)
    {
      return paramInt1;
      label63:
      if ("connectNoUI".equals(str1))
      {
        str1 = paramIntent.getStringExtra("ssid");
        paramInt1 = i;
        if (str1 != null)
        {
          paramInt1 = i;
          if (str1.length() != 0)
          {
            String str2 = paramIntent.getStringExtra("bssid");
            paramInt1 = i;
            if (str2 != null)
            {
              paramInt1 = i;
              if (str2.length() != 0)
              {
                paramInt2 = paramIntent.getIntExtra("security", -1);
                paramInt1 = i;
                if (paramInt2 != -1)
                {
                  int j = paramIntent.getIntExtra("rssi", Integer.MAX_VALUE);
                  paramInt1 = i;
                  if (j != Integer.MAX_VALUE)
                  {
                    paramIntent = new WkAccessPoint(str1, str2);
                    paramIntent.c = paramInt2;
                    paramIntent.d = j;
                    this.a = new p(this);
                    this.a.a(paramIntent, null, this.b);
                    paramInt1 = i;
                  }
                }
              }
            }
          }
        }
      }
      else if ("cancelConnectNoUI".equals(str1))
      {
        paramInt1 = i;
        if (this.a != null)
        {
          this.a.a();
          this.a = null;
          paramInt1 = i;
        }
      }
      else if ("delete".equals(str1))
      {
        h.a("handleDeleteHistory", new Object[0]);
        str1 = paramIntent.getStringExtra("ssid");
        paramIntent = paramIntent.getStringExtra("bssid");
        paramInt1 = i;
        if (str1 != null)
        {
          paramInt1 = i;
          if (paramIntent != null)
          {
            ah.a(this).b(new WkAccessPoint(str1, paramIntent));
            paramInt1 = i;
          }
        }
      }
      else if ("deleteConfig".equals(str1))
      {
        h.a("handleDeleteConfig", new Object[0]);
        ah.a(this).b();
        paramInt1 = i;
      }
      else
      {
        paramInt1 = i;
        if ("submitEventLog".equals(str1)) {
          if (!com.bluefay.a.a.a(this))
          {
            h.c("No wifi connected, TraceConnectUploadTask not upload");
            paramInt1 = i;
          }
          else
          {
            as.a().a(new e());
            paramInt1 = i;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/ConnectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */