package ct;

import android.os.SystemClock;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class ax
{
  public int a = 1;
  public int b = 1;
  public int c = 20000;
  public ArrayList d = null;
  public ArrayList e = null;
  public String f = "dispatcher.3g.qq.com";
  public Socket g;
  public int h;
  public int i;
  public int j;
  public s k;
  private int l = 3;
  private int m = 0;
  private boolean n = false;
  private int o = 0;
  private boolean p = false;
  private int q;
  
  public ax()
  {
    int[] arrayOfInt = d.a;
    this.g = null;
    this.h = 0;
    this.q = 0;
    this.i = -1;
    this.j = -1;
  }
  
  private static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList != null)
    {
      localArrayList = paramArrayList;
      if (paramArrayList.size() > 0)
      {
        if (paramInt1 < paramArrayList.size()) {
          break label27;
        }
        localArrayList = paramArrayList;
      }
    }
    for (;;)
    {
      return localArrayList;
      label27:
      paramInt2 = Math.min(paramInt2, paramArrayList.size() - paramInt1);
      localArrayList = paramArrayList;
      if (paramInt2 > 0)
      {
        localArrayList = new ArrayList(paramInt2);
        paramArrayList = paramArrayList.subList(paramInt1, paramInt1 + paramInt2);
        for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
        {
          s locals = (s)paramArrayList.get(paramInt1);
          localArrayList.add(new s(locals.a, locals.b));
        }
      }
    }
  }
  
  public static void a(int[] paramArrayOfInt)
  {
    paramArrayOfInt.clone();
  }
  
  public final void a()
  {
    boolean bool;
    if ((this.d == null) || (this.d.size() <= 0))
    {
      bool = true;
      this.n = bool;
      if (this.e != null) {
        break label272;
      }
      bool = true;
      label33:
      this.p = bool;
      bb.a("SocketConnectorImpl", "doConnect...");
    }
    for (;;)
    {
      if (((!this.n) || (!this.p)) && (this.q <= this.l))
      {
        this.q += 1;
        if (!this.n)
        {
          long l1 = SystemClock.elapsedRealtime();
          localObject = a(this.d, this.m, this.a);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            this.m += ((ArrayList)localObject).size();
            if (this.m < this.d.size()) {}
          }
          else
          {
            this.n = true;
          }
          this.g = aw.a((ArrayList)localObject, this.c);
          this.i = 0;
          this.j = ((int)(SystemClock.elapsedRealtime() - l1));
          bb.a("SocketConnectorImpl", "use IpList, dnsTime: 0 ,connectTime：" + this.j);
          if ((this.g == null) || (!this.g.isConnected()) || (this.g.isClosed())) {
            break label505;
          }
          this.k = new s(this.g.getInetAddress().getHostAddress(), this.g.getPort());
          this.h = 0;
        }
      }
      else
      {
        return;
        bool = false;
        break;
        label272:
        bool = false;
        break label33;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = localArrayList;
      if (!this.p)
      {
        localObject = localArrayList;
        if (this.e != null)
        {
          localObject = localArrayList;
          if (this.e.size() > 0)
          {
            localObject = localArrayList;
            if (this.o < this.e.size())
            {
              localArrayList = a(this.e, this.o, this.b);
              if ((localArrayList == null) || (localArrayList.size() <= 0)) {
                break label493;
              }
              this.o += localArrayList.size();
              localObject = localArrayList;
              if (this.o < this.e.size()) {
                break label411;
              }
              localObject = localArrayList;
            }
          }
        }
        this.p = true;
      }
      for (;;)
      {
        label411:
        localObject = aw.a((ArrayList)localObject, this.f, this.c);
        if (localObject != null) {
          this.g = ((av)localObject).c;
        }
        this.i = aw.a;
        this.j = aw.b;
        bb.a("SocketConnectorImpl", "use IpList DNS parallel , dnsTime:" + this.i + ",connectTime：" + this.j);
        break;
        label493:
        this.p = true;
        localObject = localArrayList;
      }
      label505:
      if (ba.e()) {
        this.h = -3;
      }
      try
      {
        Thread.sleep(3000L);
        for (;;)
        {
          this.g = null;
          break;
          this.h = -4;
          try
          {
            Thread.sleep(5000L);
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */