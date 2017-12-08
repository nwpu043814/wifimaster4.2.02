package com.lantern.favorite;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lantern.core.c;
import com.lantern.core.favorite.WkSceneFavorite;
import com.qihoo.util.StubApp1053578832;
import java.util.ArrayList;
import java.util.Iterator;

public class SyncService
  extends Service
{
  private static String a = "a0000000000000000000000000000001";
  private static final int[] b = { 128202 };
  private com.bluefay.d.b c = new b(this, b);
  
  static
  {
    StubApp1053578832.interface11(16);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    c.addListener(this.c);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.removeListener(this.c);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  private static final class a
    extends Thread
  {
    private Context a;
    
    private a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public final void run()
    {
      a locala1 = new a(this.a, SyncService.a());
      Object localObject = locala1.a();
      a locala2 = new a(this.a);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          locala2.b((WkSceneFavorite)((Iterator)localObject).next());
        }
        locala1.b();
      }
      locala2.c();
      locala1.c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/SyncService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */