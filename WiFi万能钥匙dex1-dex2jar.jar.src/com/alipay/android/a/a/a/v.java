package com.alipay.android.a.a.a;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class v
  extends FutureTask
{
  v(u paramu, Callable paramCallable, aa paramaa)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    y localy = this.a.a();
    if (localy.f() == null) {
      super.done();
    }
    for (;;)
    {
      return;
      try
      {
        get();
        if ((!isCancelled()) && (!localy.h())) {
          continue;
        }
        localy.g();
        if ((isCancelled()) && (isDone())) {
          continue;
        }
        cancel(false);
      }
      catch (InterruptedException localInterruptedException)
      {
        String.valueOf(localInterruptedException);
      }
      catch (ExecutionException localExecutionException)
      {
        if ((localExecutionException.getCause() != null) && ((localExecutionException.getCause() instanceof t)))
        {
          localExecutionException.getCause();
          continue;
        }
        String.valueOf(localExecutionException);
      }
      catch (CancellationException localCancellationException)
      {
        localExecutionException.g();
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occured while executing http request", localThrowable);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */