package com.lantern.wifilocating.push.f;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.h;
import java.util.ArrayList;
import java.util.Iterator;

public class j
{
  private static j a;
  private BroadcastReceiver b = new k(this);
  private final ArrayList<Runnable> c = new ArrayList();
  private final ArrayList<Runnable> d = new ArrayList();
  
  private j()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    com.lantern.wifilocating.push.util.j.a(c.a(), this.b, localIntentFilter);
  }
  
  public static j a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        j localj = new com/lantern/wifilocating/push/f/j;
        localj.<init>();
        a = localj;
      }
      return a;
    }
    finally {}
  }
  
  private static void a(ArrayList<Runnable> paramArrayList)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(paramArrayList);
    paramArrayList.clear();
    paramArrayList = ((ArrayList)localObject).iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (Runnable)paramArrayList.next();
      try
      {
        ((Runnable)localObject).run();
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.c.add(paramRunnable);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */