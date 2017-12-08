package ct;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  implements cs
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public ArrayList h;
  public int i;
  public int j;
  public int k;
  public String l;
  public String m;
  public s n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  
  public final h a()
  {
    long l2 = SystemClock.elapsedRealtime();
    Object localObject1 = new bg();
    ba.b();
    if (!ba.e())
    {
      this.k = -4;
      this.l = "Network fail before schedule";
      localObject1 = null;
    }
    for (;;)
    {
      return (h)localObject1;
      this.f = bc.b(this.h.toString());
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("taskVersionCode", b.a.b().c.a);
      ((Map)localObject2).put("imei", bc.a());
      ((Map)localObject2).put("reqKey", this.f);
      localObject2 = new ai(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g, (Map)localObject2);
      ((bg)localObject1).b("#halley-proxy.HalleyDispatchService");
      ((bg)localObject1).a("srvDispatch");
      ((bg)localObject1).a("request", localObject2);
      localObject1 = j.a((bg)localObject1);
      ((au)localObject1).b();
      this.o = ba.e();
      this.n = ((au)localObject1).e();
      this.p = ((au)localObject1).h();
      this.q = ((au)localObject1).f();
      this.r = ((au)localObject1).i();
      this.s = ((au)localObject1).g();
      h localh;
      if ((((au)localObject1).c() == 0) && (((au)localObject1).a() != null))
      {
        localObject1 = ((au)localObject1).a();
        localObject2 = new aj();
        try
        {
          localObject2 = (aj)((bg)localObject1).b("response", localObject2);
          if (localObject2 != null) {
            break label374;
          }
          this.k = -8;
          this.l = "Response is Null";
          localObject1 = null;
        }
        catch (Exception localException)
        {
          bb.a("ScheduleRequestImpl", "wup decode fail.", localException);
          this.k = -8;
          this.m = localException.getClass().getSimpleName();
          this.l = bc.a(localException);
          localh = null;
        }
        continue;
        label374:
        localh = new h();
        Object localObject3 = ba.a();
        long l1 = SystemClock.elapsedRealtime();
        if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
        {
          Map localMap = ((aj)localObject2).a;
          if ((localMap != null) && (localMap.size() > 0))
          {
            localObject3 = new t(this.g);
            Iterator localIterator1 = localMap.keySet().iterator();
            while (localIterator1.hasNext())
            {
              Object localObject4 = (String)localIterator1.next();
              if (localMap.get(localObject4) != null)
              {
                Object localObject5 = ((ak)localMap.get(localObject4)).a;
                localObject4 = new t.a((String)localObject4, l1, ((ak)((aj)localObject2).a.get(localObject4)).b);
                Iterator localIterator2 = ((ArrayList)localObject5).iterator();
                while (localIterator2.hasNext())
                {
                  String str = (String)localIterator2.next();
                  localObject5 = new s();
                  if (((s)localObject5).a(str)) {
                    ((t.a)localObject4).c.add(localObject5);
                  } else {
                    bb.c("ScheduleRequestImpl", "parse ipPort fail. ipPort:" + str);
                  }
                }
                ((t)localObject3).a((t.a)localObject4);
              }
            }
            localh.a = ((t)localObject3);
          }
        }
        for (;;)
        {
          if (((aj)localObject2).c != null) {
            localh.b = new e(((aj)localObject2).c);
          }
          if (((aj)localObject2).b != null) {
            localh.c = new d(((aj)localObject2).b);
          }
          this.t = ((int)(SystemClock.elapsedRealtime() - l2));
          break;
          localh.a = null;
          this.k = -9;
          this.l = ("req apn:" + this.g + ",current apn:" + (String)localObject3);
        }
      }
      else
      {
        this.k = localh.c();
        this.m = localh.d();
        localh = null;
      }
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */