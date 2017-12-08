package com.b.b;

public final class r<K, V>
{
  private final a<K, V> a;
  private final K b;
  private final V c;
  
  private r(ak.a parama1, K paramK, ak.a parama2, V paramV)
  {
    this.a = new a(parama1, paramK, parama2, paramV);
    this.b = paramK;
    this.c = paramV;
  }
  
  private static <K, V> int a(a<K, V> parama, K paramK, V paramV)
  {
    return k.a(parama.a, 1, paramK) + k.a(parama.c, 2, paramV);
  }
  
  public static <K, V> r<K, V> a(ak.a parama1, K paramK, ak.a parama2, V paramV)
  {
    return new r(parama1, paramK, parama2, paramV);
  }
  
  private static <T> T a(g paramg, j paramj, ak.a parama, T paramT)
  {
    switch (s.a[parama.ordinal()])
    {
    default: 
      paramg = k.a(paramg, parama);
    case 1: 
    case 2: 
      for (;;)
      {
        return paramg;
        parama = ((u)paramT).i();
        paramg.a(parama, paramj);
        paramg = parama.d();
        continue;
        paramg = Integer.valueOf(paramg.n());
      }
    }
    throw new RuntimeException("Groups are not allowed in maps.");
  }
  
  public final int a(int paramInt, K paramK, V paramV)
  {
    return h.g(paramInt) + h.l(a(this.a, paramK, paramV));
  }
  
  public final void a(h paramh, int paramInt, K paramK, V paramV)
  {
    paramh.a(paramInt, 2);
    paramh.c(a(this.a, paramK, paramV));
    a locala = this.a;
    k.a(paramh, locala.a, 1, paramK);
    k.a(paramh, locala.c, 2, paramV);
  }
  
  public final void a(t<K, V> paramt, g paramg, j paramj)
  {
    int i = paramg.c(paramg.s());
    Object localObject1 = this.a.b;
    Object localObject2 = this.a.d;
    int j;
    do
    {
      for (;;)
      {
        j = paramg.a();
        if (j == 0) {
          break label124;
        }
        if (j == ak.a(1, this.a.a.b()))
        {
          localObject1 = a(paramg, paramj, this.a.a, localObject1);
        }
        else
        {
          if (j != ak.a(2, this.a.c.b())) {
            break;
          }
          localObject2 = a(paramg, paramj, this.a.c, localObject2);
        }
      }
    } while (paramg.b(j));
    label124:
    paramg.a(0);
    paramg.d(i);
    paramt.put(localObject1, localObject2);
  }
  
  static final class a<K, V>
  {
    public final ak.a a;
    public final K b;
    public final ak.a c;
    public final V d;
    
    public a(ak.a parama1, K paramK, ak.a parama2, V paramV)
    {
      this.a = parama1;
      this.b = paramK;
      this.c = parama2;
      this.d = paramV;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */