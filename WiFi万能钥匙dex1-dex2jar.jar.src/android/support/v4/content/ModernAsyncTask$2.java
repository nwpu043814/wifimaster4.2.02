package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class ModernAsyncTask$2
  extends ModernAsyncTask.WorkerRunnable<Params, Result>
{
  ModernAsyncTask$2(ModernAsyncTask paramModernAsyncTask)
  {
    super(null);
  }
  
  public Result call()
  {
    ModernAsyncTask.access$200(this.this$0).set(true);
    Process.setThreadPriority(10);
    return (Result)ModernAsyncTask.access$300(this.this$0, this.this$0.doInBackground(this.mParams));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/ModernAsyncTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */