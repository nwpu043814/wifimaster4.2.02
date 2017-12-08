package ct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class x
{
  private static String d = "bott";
  private s a;
  private String b;
  private List c = new ArrayList();
  
  public x(ab paramab)
  {
    if ((paramab.q == 0) || (!paramab.b)) {
      this.c.add(a(paramab));
    }
    for (;;)
    {
      return;
      if (!ba.c)
      {
        Object localObject = i.a();
        if (localObject != null)
        {
          localObject = ((a)localObject).a(paramab.c);
          if (localObject != null)
          {
            this.a = ((t.a)localObject).d;
            List localList = ((t.a)localObject).c;
            this.b = ((t.a)localObject).b;
            localObject = localList;
            if (localList != null)
            {
              localObject = localList;
              if (localList.size() > paramab.q) {
                localObject = localList.subList(0, paramab.q);
              }
            }
            boolean bool = a((List)localObject, this.a);
            if ((this.b != null) && (!this.b.contains(d)))
            {
              this.c.addAll((Collection)localObject);
              if ((this.a != null) && (!bool)) {
                this.c.add(this.a);
              }
              this.c.add(a(paramab));
            }
            for (;;)
            {
              this.c.size();
              break;
              if ((this.a != null) && (!bool)) {
                this.c.add(this.a);
              }
              this.c.add(a(paramab));
              this.c.addAll((Collection)localObject);
            }
          }
          this.c.add(a(paramab));
        }
        else
        {
          this.c.add(a(paramab));
        }
      }
      else
      {
        this.c.add(a(paramab));
      }
    }
  }
  
  private static s a(ab paramab)
  {
    if (paramab.e != null) {}
    for (paramab = new s(paramab.c, paramab.e[0]);; paramab = new s(paramab.c, -1)) {
      return paramab;
    }
  }
  
  private static boolean a(List paramList, s params)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (!((s)paramList.next()).a(params));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final s a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final List c()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */