package com.linksure.apservice.utils;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public final class a
{
  static Stack<WeakReference<Activity>> a = new Stack();
  
  public static void a()
  {
    if (!a.isEmpty()) {
      a.pop();
    }
  }
  
  public static void a(Activity paramActivity)
  {
    a.push(new WeakReference(paramActivity));
  }
  
  public static List<Activity> b()
  {
    Object localObject;
    if (a.isEmpty()) {
      localObject = Collections.EMPTY_LIST;
    }
    for (;;)
    {
      return (List<Activity>)localObject;
      localObject = new ArrayList();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
        if ((localActivity != null) && (!localActivity.isFinishing())) {
          ((List)localObject).add(localActivity);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */