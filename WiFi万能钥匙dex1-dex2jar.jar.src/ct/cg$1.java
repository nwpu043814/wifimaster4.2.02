package ct;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

final class cg$1
  implements Runnable
{
  cg$1(cg paramcg, Handler paramHandler) {}
  
  public final void run()
  {
    this.b.a.clear();
    cg localcg = this.b;
    Handler localHandler = this.a;
    LinkedBlockingQueue localLinkedBlockingQueue = localcg.a;
    localObject1 = null;
    for (;;)
    {
      if (localcg.g) {}
      for (;;)
      {
        try
        {
          localObject2 = (cg.a)localLinkedBlockingQueue.take();
        }
        catch (IOException localIOException1)
        {
          Object localObject2;
          long l1;
          long l3;
          Object localObject4;
          long l2;
          continue;
        }
        catch (InterruptedException localInterruptedException2)
        {
          Object localObject3 = localObject1;
          continue;
          int i = 0;
          continue;
        }
        try
        {
          if (cg.a.d == localObject2)
          {
            b.a.a("TxRequestSender", "run: state=[shutdown]");
            return;
          }
          if (!b.a.c(localcg.b.a))
          {
            b.a.a("TxRequestSender", "run: disconnected! ignore request");
            localHandler.sendEmptyMessage(4998);
            localcg.a((cg.a)localObject2);
            localObject1 = localObject2;
            break;
          }
          b.a.a(((cg.a)localObject2).b);
          l1 = System.currentTimeMillis();
          localObject1 = localcg.b.a(cg.a.b((cg.a)localObject2), cg.a.a((cg.a)localObject2));
          l3 = System.currentTimeMillis();
          b.a.a((String)localObject1);
          localcg.c += 1L;
          localcg.d += cg.a.a((cg.a)localObject2).length;
          localObject4 = b.a.b(((String)localObject1).getBytes());
          l2 = localcg.e;
          if (localObject4 != null)
          {
            i = localObject4.length;
            localcg.e = (l2 + i);
            localObject4 = localHandler.obtainMessage();
            ((Message)localObject4).arg1 = ((int)(l3 - l1));
            ((cg.a)localObject2).c = l1;
            if (1 == cg.a.c((cg.a)localObject2))
            {
              ((Message)localObject4).obj = Pair.create(localObject1, localObject2);
              ((Message)localObject4).what = 4999;
              ((Message)localObject4).sendToTarget();
            }
            if (b.a.a(localcg.b.a)) {
              localcg.h.d();
            }
            localObject1 = localObject2;
            break;
          }
          i = 0;
        }
        catch (InterruptedException localInterruptedException1)
        {
          b.a.a("TxRequestSender", "run: thread is interrupted", localInterruptedException1);
          localObject1 = localObject2;
        }
        catch (IOException localIOException2)
        {
          localObject1 = localObject2;
          localObject2 = localIOException2;
        }
      }
    }
    b.a.a("TxRequestSender", "run: io error", (Throwable)localObject2);
    cg.a.d((cg.a)localObject1);
    localObject2 = localcg.a.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (cg.a.c((cg.a)((Iterator)localObject2).next()) != cg.a.c((cg.a)localObject1));
    i = 1;
    if ((cg.a.e((cg.a)localObject1) > 0) && (i == 0))
    {
      b.a.a("TxRequestSender", "retryIfNeed: times=" + cg.a.e((cg.a)localObject1));
      localcg.a.offer(localObject1);
    }
    for (;;)
    {
      localHandler.sendEmptyMessageDelayed(4998, 8000L);
      break;
      localcg.a((cg.a)localObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cg$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */