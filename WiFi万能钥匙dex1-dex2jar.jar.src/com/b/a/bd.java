package com.b.a;

import com.b.a.c.a;
import com.b.a.c.d;
import com.b.a.c.e;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class bd
{
  static z a(a parama)
  {
    i = 1;
    try
    {
      parama.g();
      i = 0;
      parama = b(parama);
    }
    catch (EOFException parama)
    {
      while (i != 0) {
        parama = ab.a();
      }
      throw new aa(parama);
    }
    catch (e parama)
    {
      throw new al(parama);
    }
    catch (IOException parama)
    {
      throw new aa(parama);
    }
    catch (NumberFormatException parama)
    {
      throw new al(parama);
    }
    return parama;
  }
  
  static void a(z paramz, boolean paramBoolean, d paramd)
  {
    if ((paramz == null) || ((paramz instanceof ab))) {
      if (paramBoolean) {
        paramd.g();
      }
    }
    for (;;)
    {
      return;
      if ((paramz instanceof ag))
      {
        paramz = paramz.q();
        if (paramz.r()) {
          paramd.a(paramz.b());
        } else if (paramz.a()) {
          paramd.c(paramz.m());
        } else {
          paramd.c(paramz.c());
        }
      }
      else
      {
        Object localObject;
        if ((paramz instanceof s))
        {
          paramd.c();
          paramz = paramz.p().iterator();
          while (paramz.hasNext())
          {
            localObject = (z)paramz.next();
            if ((localObject instanceof ab)) {
              paramd.g();
            } else {
              a((z)localObject, paramBoolean, paramd);
            }
          }
          paramd.d();
        }
        else
        {
          if (!(paramz instanceof ac)) {
            break;
          }
          paramd.e();
          Iterator localIterator = paramz.o().a().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramz = (z)((Map.Entry)localObject).getValue();
            if ((paramBoolean) || (!(paramz instanceof ab)))
            {
              paramd.b((String)((Map.Entry)localObject).getKey());
              a(paramz, paramBoolean, paramd);
            }
          }
          paramd.f();
        }
      }
    }
    throw new IllegalArgumentException("Couldn't write " + paramz.getClass());
  }
  
  private static z b(a parama)
  {
    switch (1.a[parama.g().ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      parama = new ag(parama.i());
    }
    for (;;)
    {
      return parama;
      parama = new ag(ag.a(parama.i()));
      continue;
      parama = new ag(Boolean.valueOf(parama.j()));
      continue;
      parama.k();
      parama = ab.a();
      continue;
      Object localObject = new s();
      parama.b();
      while (parama.f()) {
        ((s)localObject).a(b(parama));
      }
      parama.c();
      parama = (a)localObject;
      continue;
      localObject = new ac();
      parama.d();
      while (parama.f()) {
        ((ac)localObject).a(parama.h(), b(parama));
      }
      parama.e();
      parama = (a)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */