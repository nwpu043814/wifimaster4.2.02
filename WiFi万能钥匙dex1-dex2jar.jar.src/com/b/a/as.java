package com.b.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

final class as
  implements i
{
  private final Collection<Integer> a = new HashSet();
  
  public as(int... paramVarArgs)
  {
    for (int i = 0; i < 2; i++)
    {
      int j = paramVarArgs[i];
      this.a.add(Integer.valueOf(j));
    }
  }
  
  public final boolean a(l paraml)
  {
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!paraml.a(((Integer)localIterator.next()).intValue()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(Class<?> paramClass)
  {
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */