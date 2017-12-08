package c.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bq
  implements Serializable
{
  private List a;
  private short b;
  private short c;
  
  public bq()
  {
    this.a = new ArrayList(1);
    this.b = 0;
    this.c = 0;
  }
  
  public bq(bq parambq)
  {
    try
    {
      this.a = ((List)((ArrayList)parambq.a).clone());
      this.b = parambq.b;
      this.c = parambq.c;
      return;
    }
    finally {}
  }
  
  public bq(bt parambt)
  {
    this();
    b(parambt);
  }
  
  private static String a(Iterator paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramIterator.hasNext())
    {
      bt localbt = (bt)paramIterator.next();
      localStringBuffer.append("[");
      localStringBuffer.append(localbt.b());
      localStringBuffer.append("]");
      if (paramIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
  
  private Iterator a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        k = this.a.size();
        int j;
        Object localObject1;
        if (paramBoolean1)
        {
          j = k - this.b;
          if (j == 0)
          {
            localObject1 = Collections.EMPTY_LIST.iterator();
            return (Iterator)localObject1;
          }
        }
        else
        {
          j = this.b;
          continue;
        }
        if (paramBoolean1)
        {
          if (!paramBoolean2)
          {
            localObject1 = new java/util/ArrayList;
            ((ArrayList)localObject1).<init>(j);
            if (!paramBoolean1) {
              break label184;
            }
            ((List)localObject1).addAll(this.a.subList(i, j));
            if (i != 0) {
              ((List)localObject1).addAll(this.a.subList(0, i));
            }
            localObject1 = ((List)localObject1).iterator();
            continue;
          }
          if (this.c >= j) {
            this.c = 0;
          }
          i = this.c;
          this.c = ((short)(i + 1));
          continue;
        }
        i = k - this.b;
      }
      finally {}
      continue;
      label184:
      ((List)localObject2).addAll(this.a.subList(i, k));
    }
  }
  
  private void b(bt parambt)
  {
    if (!(parambt instanceof bp)) {
      if (this.b == 0) {
        this.a.add(parambt);
      }
    }
    for (;;)
    {
      return;
      this.a.add(this.a.size() - this.b, parambt);
      continue;
      this.a.add(parambt);
      this.b = ((short)(this.b + 1));
    }
  }
  
  public final void a(bt parambt)
  {
    bt localbt1;
    for (;;)
    {
      bt localbt2;
      try
      {
        if (this.a.size() == 0)
        {
          b(parambt);
          return;
        }
        localbt2 = e();
        if (!parambt.a(localbt2))
        {
          parambt = new java/lang/IllegalArgumentException;
          parambt.<init>("record does not match rrset");
          throw parambt;
        }
      }
      finally {}
      localbt1 = parambt;
      if (parambt.j() != localbt2.j())
      {
        if (parambt.j() <= localbt2.j()) {
          break;
        }
        localbt1 = parambt.k();
        localbt1.a(localbt2.j());
      }
      if (!this.a.contains(localbt1)) {
        b(localbt1);
      }
    }
    for (int i = 0;; i++)
    {
      localbt1 = parambt;
      if (i >= this.a.size()) {
        break;
      }
      localbt1 = ((bt)this.a.get(i)).k();
      localbt1.a(parambt.j());
      this.a.set(i, localbt1);
    }
  }
  
  public final int b()
  {
    return e().h();
  }
  
  public final Iterator c()
  {
    try
    {
      Iterator localIterator = a(true, true);
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long d()
  {
    try
    {
      long l = e().j();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final bt e()
  {
    try
    {
      if (this.a.size() == 0)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("rrset is empty");
        throw localIllegalStateException;
      }
    }
    finally {}
    bt localbt = (bt)this.a.get(0);
    return localbt;
  }
  
  public String toString()
  {
    if (this.a.size() == 0) {}
    for (Object localObject = "{empty}";; localObject = ((StringBuffer)localObject).toString())
    {
      return (String)localObject;
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("{ ");
      ((StringBuffer)localObject).append(e().f() + " ");
      ((StringBuffer)localObject).append(d() + " ");
      ((StringBuffer)localObject).append(m.b(e().i()) + " ");
      ((StringBuffer)localObject).append(ct.b(e().h()) + " ");
      ((StringBuffer)localObject).append(a(a(true, false)));
      if (this.b > 0)
      {
        ((StringBuffer)localObject).append(" sigs: ");
        ((StringBuffer)localObject).append(a(a(false, false)));
      }
      ((StringBuffer)localObject).append(" }");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */