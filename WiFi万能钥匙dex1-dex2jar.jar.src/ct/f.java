package ct;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class f
  implements a, o, Runnable
{
  public String a = null;
  public String b = null;
  public String c = null;
  private Set d = null;
  private BlockingQueue e = null;
  private q f;
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    bb.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = new CopyOnWriteArraySet();
    this.d.add("dispatcher.3g.qq.com");
    this.e = new ArrayBlockingQueue(1);
    this.f = r.a();
    k.a().a(this);
  }
  
  public final am a()
  {
    return b.a.b().b.f;
  }
  
  public final t.a a(String paramString)
  {
    if (this.d.contains(paramString))
    {
      t.a locala = u.a().a(paramString);
      if (locala != null)
      {
        paramString = locala;
        if (locala.b())
        {
          bb.c("AccessSchedulerImpl", "iplist was expired");
          paramString = locala;
        }
        return paramString;
      }
      bb.c("AccessSchedulerImpl", "getAccessIPListByDomainname... domain access info not found in db...");
    }
    for (;;)
    {
      paramString = null;
      break;
      bb.c("AccessSchedulerImpl", "getAccessIPListByDomainname...domain not registered. domain:" + paramString + ", registered domains:" + this.d);
    }
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        this.d.add(paramList);
      }
    }
  }
  
  public final void b()
  {
    bb.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
    bb.b("AccessSchedulerImpl", "addTask...");
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("before add, queue size:");
      bb.a("AccessSchedulerImpl", this.e.size());
      localObject = this.e;
      j localj = new ct/j;
      localj.<init>();
      boolean bool = ((BlockingQueue)localObject).add(localj);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("addTask ret:");
      bb.a("AccessSchedulerImpl", bool);
      bb.a("AccessSchedulerImpl", "after add, queue size:" + this.e.size());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        bb.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
      }
    }
  }
  
  public final void run()
  {
    bb.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
    for (;;)
    {
      try
      {
        u.a();
        bb.a("AccessSchedulerImpl", "try take a task...");
        this.e.take();
        bb.a("AccessSchedulerImpl", "task taked, try scheduler...");
        bb.b("AccessSchedulerImpl", "scheduler...begin");
        localObject1 = u.a();
        String str = ba.a();
        if ((TextUtils.isEmpty(str)) || (str.equals("unknown")))
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("updateApnUserTime... failed with apnName:");
          bb.c("AccessSchedulerStorageManager", str);
          str = "";
          if (!TextUtils.isEmpty(str)) {
            break label151;
          }
          bb.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
          continue;
        }
        ((u)localObject1).a.b(localThrowable);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("updateApnUseTime... apnName:");
      bb.b("AccessSchedulerStorageManager", localThrowable);
      continue;
      label151:
      if (!i.a)
      {
        bb.b("AccessSchedulerImpl", "schedulerOn is off. return");
      }
      else if (!u.a().a(this.d))
      {
        bb.b("AccessSchedulerImpl", "scheduler...no need scheduler. return");
      }
      else
      {
        g localg = new ct/g;
        localg.<init>();
        localg.b = p.b();
        localg.c = p.c();
        localg.d = p.d();
        localg.a = p.f();
        p.g();
        localg.e = p.e();
        localObject1 = this.d;
        Object localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        localg.h = ((ArrayList)localObject2);
        localg.h.addAll((Collection)localObject1);
        localg.g = ba.a();
        localg.i = ba.c();
        localg.j = ba.d();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("request info:");
        bb.a("AccessSchedulerImpl", localg.b + "," + localg.c + "," + localg.d + "," + localg.a + "," + localg.e + "," + localg.h + "," + null + "," + localg.i + "," + localg.j);
        localObject1 = localg.a();
        if (localObject1 != null)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("scheduler...response:");
          Object localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>("accessInfo:");
          bb.b("AccessSchedulerImpl", ((StringBuilder)localObject3).append(((h)localObject1).a).append(", sdkCfgInfo:").append(((h)localObject1).b).append(", sdkAccessInfo:").append(((h)localObject1).c).toString());
          u.a().a(((h)localObject1).a);
          localObject3 = b.a.b();
          localObject2 = ((h)localObject1).b;
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("updateSdkCfInfo...SdkCfgInfo:");
            bb.b("AccessSchedulerConfiguration", localObject2);
            if ((((e)localObject2).a < 2000) || (((e)localObject2).a > 60000))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>("updateSdkCfInfo...connectTimeout:");
              bb.c("AccessSchedulerConfiguration", ((e)localObject2).a + " is checked to 20s");
              ((e)localObject2).a = 20000;
            }
            if ((((e)localObject2).b < 2000) || (((e)localObject2).b > 60000))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>("updateSdkCfInfo...readTimeout:");
              bb.c("AccessSchedulerConfiguration", ((e)localObject2).b + " is checked to 20s");
              ((e)localObject2).b = 20000;
            }
            ((b.a)localObject3).b = ((e)localObject2);
            ((b.a)localObject3).b.b();
          }
          localObject2 = b.a.b();
          localObject1 = ((h)localObject1).c;
          if (localObject1 != null)
          {
            ((b.a)localObject2).a = ((d)localObject1);
            ((b.a)localObject2).a.b();
          }
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("scheduler...end. apn:");
        bb.b("AccessSchedulerImpl", null + ", retCode:" + localg.k + ",failInfo:" + localg.l);
        this.f.a(localg);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */