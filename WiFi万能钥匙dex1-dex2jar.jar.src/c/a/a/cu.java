package c.a.a;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

final class cu
  implements Serializable
{
  private TreeSet a = new TreeSet();
  
  private cu() {}
  
  public cu(q paramq)
  {
    this();
    while (paramq.b() > 0)
    {
      if (paramq.b() < 2) {
        throw new db("invalid bitmap descriptor");
      }
      int k = paramq.g();
      if (k < -1) {
        throw new db("invalid ordering");
      }
      int m = paramq.g();
      if (m > paramq.b()) {
        throw new db("invalid bitmap");
      }
      for (int i = 0; i < m; i++)
      {
        int n = paramq.g();
        if (n != 0) {
          for (int j = 0; j < 8; j++) {
            if ((1 << 7 - j & n) != 0) {
              this.a.add(av.c(k * 256 + i * 8 + j));
            }
          }
        }
      }
    }
  }
  
  private static void a(s params, TreeSet paramTreeSet, int paramInt)
  {
    int i = (((Integer)paramTreeSet.last()).intValue() & 0xFF) / 8 + 1;
    int[] arrayOfInt = new int[i];
    params.b(paramInt);
    params.b(i);
    paramTreeSet = paramTreeSet.iterator();
    while (paramTreeSet.hasNext())
    {
      paramInt = ((Integer)paramTreeSet.next()).intValue();
      int j = (paramInt & 0xFF) / 8;
      arrayOfInt[j] = (1 << 7 - paramInt % 8 | arrayOfInt[j]);
    }
    for (paramInt = 0; paramInt < i; paramInt++) {
      params.b(arrayOfInt[paramInt]);
    }
  }
  
  public final void a(s params)
  {
    if (this.a.size() == 0) {
      return;
    }
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.a.iterator();
    int i = -1;
    label31:
    int m;
    int k;
    if (localIterator.hasNext())
    {
      m = ((Integer)localIterator.next()).intValue();
      k = m >> 8;
      if (k == i) {
        break label125;
      }
      j = k;
      if (localTreeSet.size() > 0)
      {
        a(params, localTreeSet, i);
        localTreeSet.clear();
      }
    }
    label125:
    for (int j = k;; j = i)
    {
      localTreeSet.add(new Integer(m));
      i = j;
      break label31;
      a(params, localTreeSet, i);
      break;
    }
  }
  
  public final boolean a()
  {
    return this.a.isEmpty();
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(ct.b(((Integer)localIterator.next()).intValue()));
      if (localIterator.hasNext()) {
        localStringBuffer.append(' ');
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */