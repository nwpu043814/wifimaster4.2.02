package com.b.a;

import com.b.a.b.b;
import java.lang.reflect.Type;

final class av
{
  private final i a;
  private final bb b;
  
  av(i parami)
  {
    Object localObject = parami;
    if (parami == null) {
      localObject = new at();
    }
    this.a = ((i)localObject);
    this.b = new bb(this.a);
  }
  
  public final void a(aw paramaw, a parama)
  {
    if (this.a.a(b.b(paramaw.a))) {}
    Object localObject1;
    label49:
    do
    {
      do
      {
        return;
      } while (parama.c(paramaw));
      localObject1 = paramaw.a();
      if (localObject1 != null) {
        break;
      }
      localObject1 = parama.b();
    } while (localObject1 == null);
    paramaw.a(localObject1);
    parama.a(paramaw);
    for (;;)
    {
      try
      {
        if (b.d(paramaw.a))
        {
          parama.a(localObject1, paramaw.a);
          parama.b(paramaw);
          break;
          break label49;
        }
        if (paramaw.a != Object.class) {
          break label184;
        }
        Class localClass = localObject1.getClass();
        if ((localClass == Object.class) || (localClass == String.class) || (az.a(localClass).isPrimitive()))
        {
          i = 1;
          if (i == 0) {
            break label184;
          }
          parama.b(localObject1);
          parama.b();
          continue;
        }
        int i = 0;
      }
      finally
      {
        parama.b(paramaw);
      }
      continue;
      label184:
      parama.a(localObject2);
      this.b.a(paramaw, parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(aw paramaw);
    
    public abstract void a(l paraml, Type paramType, Object paramObject);
    
    public abstract void a(Object paramObject);
    
    public abstract void a(Object paramObject, Type paramType);
    
    public abstract Object b();
    
    public abstract void b(aw paramaw);
    
    public abstract void b(l paraml, Type paramType, Object paramObject);
    
    public abstract void b(Object paramObject);
    
    public abstract boolean c(aw paramaw);
    
    public abstract boolean c(l paraml, Type paramType, Object paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */