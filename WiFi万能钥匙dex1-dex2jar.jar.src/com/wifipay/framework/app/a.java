package com.wifipay.framework.app;

import android.app.Activity;
import com.wifipay.common.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a
{
  private static volatile a a;
  private Map<String, a> b = new HashMap();
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public static void b()
  {
    if (a != null)
    {
      Object localObject = a.b.values();
      if ((localObject != null) && (!((Collection)localObject).isEmpty()))
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Activity localActivity = (Activity)((a)((Iterator)localObject).next()).get();
          if (localActivity != null) {
            localActivity.finish();
          }
        }
        a.b.clear();
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      String str = paramActivity.toString();
      Logger.v("recordActivity key = %s", new Object[] { str });
      if (!this.b.containsKey(str)) {
        this.b.put(str, new a(paramActivity));
      }
      Logger.v("recordActivity size = %d", new Object[] { Integer.valueOf(this.b.size()) });
    }
  }
  
  private class a
    extends WeakReference<Activity>
  {
    public a(Activity paramActivity)
    {
      super();
    }
    
    public String toString()
    {
      Object localObject = (Activity)get();
      if (localObject != null) {}
      for (localObject = localObject.toString();; localObject = super.toString()) {
        return (String)localObject;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */