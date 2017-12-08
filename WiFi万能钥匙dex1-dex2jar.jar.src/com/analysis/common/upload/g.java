package com.analysis.common.upload;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  List<k> a = new ArrayList();
  private Context b;
  
  public g(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  private void a(h paramh)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        k localk = (k)localIterator.next();
        int i;
        if (localk == null)
        {
          i = 0;
          if (i != 0) {
            localk.a(paramh);
          }
        }
        else
        {
          i = 1;
        }
      }
      finally {}
    }
    this.a.clear();
  }
  
  private void a(List<? extends k> paramList)
  {
    this.a.addAll(paramList);
  }
  
  public final int a()
  {
    int j = 0;
    if (this.a == null) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        j = this.a.size();
      }
      return j;
    }
  }
  
  public final void a(k paramk)
  {
    this.a.add(paramk);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */