package ct;

import android.content.Context;
import java.io.File;

final class bo$1
  extends Thread
{
  bo$1(bo parambo) {}
  
  public final void run()
  {
    File localFile = new File(this.a.a.getFilesDir(), "libtencentloc.so");
    if ((localFile.exists()) && (localFile.length() > 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localFile.delete();
        this.a.b();
      }
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */