package com.wifi.connect.d;

import android.content.Context;
import android.os.AsyncTask;
import com.bluefay.b.h;
import com.c.a.a.a.c.a.a.a.a.a;
import com.c.a.a.a.c.a.a.a.a.a.a;
import com.c.a.a.a.c.a.a.a.a.a.b;
import com.c.a.a.a.c.a.a.a.a.a.b.a;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import java.util.ArrayList;

public final class d
  extends AsyncTask<String, Integer, Integer>
{
  private ArrayList<WkAccessPoint> a;
  private com.bluefay.b.a b;
  private com.wifi.connect.model.c c;
  private String d = "";
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public d(ArrayList<WkAccessPoint> paramArrayList, com.bluefay.b.a parama)
  {
    this.a = paramArrayList;
    this.b = parama;
    this.e = f.e();
    this.f = f.f();
    this.g = f.j();
    this.h = f.a().a("query_timeout", true);
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 0;
    h.a("queryApKeyPB:" + paramBoolean1 + " " + paramBoolean2);
    if (!com.lantern.core.c.getServer().a("00302001", paramBoolean1)) {
      if (paramBoolean2)
      {
        this.d = "10011";
        h.c(this.d);
      }
    }
    for (;;)
    {
      return i;
      this.d = "10010";
      break;
      Object localObject = com.lantern.core.c.getServer().v();//apurl
      byte[] arrayOfByte = a(com.bluefay.d.a.getAppContext(), this.a);
      com.lantern.core.c.getServer();
      arrayOfByte = o.a("00302001", arrayOfByte);
      if (this.h) {
        new e(this).start();
      }
      for (localObject = com.lantern.core.e.a((String)localObject, arrayOfByte, 10000, 20000);; localObject = com.lantern.core.e.a((String)localObject, arrayOfByte, 30000, 30000))
      {
        if ((localObject != null) && (localObject.length != 0)) {
          break label184;
        }
        this.d = "10001";
        h.c(this.d);
        break;
      }
      label184:
      h.a(com.bluefay.b.c.a((byte[])localObject), new Object[0]);
      try
      {
        this.c = com.wifi.connect.model.c.a(this.a, (byte[])localObject, new String[] { "00302001" });
        i = j;
        if (paramBoolean1)
        {
          i = j;
          if (!paramBoolean2) {
            if (!this.c.d())
            {
              i = j;
              if (!this.c.e()) {}
            }
            else
            {
              com.lantern.core.c.getServer().b("00302001", this.c.b());
              i = a(true, true);
            }
          }
        }
      }
      catch (Exception localException)
      {
        h.a(localException);
        this.c = null;
        this.d = "10004";
        i = 0;
      }
    }
  }
  
  private static byte[] a(Context paramContext, ArrayList<WkAccessPoint> paramArrayList)
  {
    a.a.a locala = a.a.l();
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      a.a.b.a locala1 = a.a.b.l();
      locala1.b(((WkAccessPoint)paramArrayList.get(i)).b());
      locala1.c(((WkAccessPoint)paramArrayList.get(i)).d);
      locala1.a(((WkAccessPoint)paramArrayList.get(i)).c);
      locala1.a(((WkAccessPoint)paramArrayList.get(i)).a());
      locala.a((a.a.b)locala1.c());
    }
    locala.c(k.i(paramContext));
    locala.b(k.h(paramContext));
    locala.a(k.f(paramContext));
    return ((a.a)locala.c()).b();
  }
  
  protected final void onCancelled()
  {
    super.onCancelled();
    h.a("onCancelled");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */