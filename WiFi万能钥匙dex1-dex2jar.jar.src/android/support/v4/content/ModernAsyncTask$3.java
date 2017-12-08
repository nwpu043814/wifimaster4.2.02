package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ModernAsyncTask$3
  extends FutureTask<Result>
{
  ModernAsyncTask$3(ModernAsyncTask paramModernAsyncTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    try
    {
      Object localObject = get();
      ModernAsyncTask.access$400(this.this$0, localObject);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("AsyncTask", localInterruptedException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      for (;;)
      {
        ModernAsyncTask.access$400(this.this$0, null);
      }
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localThrowable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/ModernAsyncTask$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */