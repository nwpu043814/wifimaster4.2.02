package com.wifi.backup.c;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.b.b.a.a.a;
import com.c.a.a.a.b.b.a.a.a.a;
import com.lantern.core.e;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private List<com.wifi.backup.c.a.a> b;
  private String c;
  private String d = "";
  
  public d(String paramString, com.bluefay.b.a parama)
  {
    this.a = parama;
    this.c = paramString;
    this.b = new ArrayList();
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {}
    for (int i = 10;; i = 0)
    {
      return i;
      if (com.lantern.core.c.getServer().a("00302007", paramBoolean1)) {
        break;
      }
    }
    com.bluefay.d.a.getAppContext();
    Object localObject = ((a.a)a.a.l().a(this.c).c()).b();
    com.lantern.core.c.getServer();
    localObject = o.a("00302007", (byte[])localObject);
    localObject = e.a(com.lantern.core.c.getServer().v(), (byte[])localObject);
    h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
    if ((localObject == null) || (localObject.length == 0)) {}
    for (i = 10;; i = 0)
    {
      try
      {
        com.lantern.core.c.getServer();
        localObject = o.b("00302007", (byte[])localObject);
        if (((com.lantern.core.h.a)localObject).c())
        {
          i = 1;
          break;
        }
        if ((paramBoolean1) && (!paramBoolean2) && ((((com.lantern.core.h.a)localObject).d()) || (((com.lantern.core.h.a)localObject).e())))
        {
          com.lantern.core.c.getServer().b("00302007", ((com.lantern.core.h.a)localObject).b());
          i = a(true, true);
          break;
        }
        this.d = ((com.lantern.core.h.a)localObject).b();
      }
      catch (Exception localException)
      {
        h.a(localException);
        i = 30;
      }
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */