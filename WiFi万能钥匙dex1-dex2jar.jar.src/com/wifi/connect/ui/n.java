package com.wifi.connect.ui;

import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;
import com.wifi.connect.model.b;
import java.text.SimpleDateFormat;
import java.util.Date;

final class n
  implements com.bluefay.b.a
{
  n(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    h.a("backup retcode:%d, retmsg:%s, data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if ((paramObject instanceof b))
    {
      paramString = (b)paramObject;
      if (paramString.c()) {
        if (paramString.a != 0) {
          break label108;
        }
      }
    }
    label108:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramString = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(System.currentTimeMillis()));
        new com.wifi.backup.b.a(ConnectFragment.O(this.a)).a(paramString);
        e.a(R.string.tips_backup_ap_success);
      }
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */