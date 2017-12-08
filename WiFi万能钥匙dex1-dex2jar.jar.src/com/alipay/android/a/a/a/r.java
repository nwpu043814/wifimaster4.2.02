package com.alipay.android.a.a.a;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class r
  extends a
{
  private o g;
  
  public r(o paramo, Method paramMethod, int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(paramMethod, paramInt, paramString, paramArrayOfByte, "application/x-www-form-urlencoded", paramBoolean);
    this.g = paramo;
  }
  
  public final Object a()
  {
    Object localObject1 = new y(this.g.a());
    ((y)localObject1).a(this.b);
    ((y)localObject1).a(this.e);
    ((y)localObject1).a(this.f);
    ((y)localObject1).a("id", String.valueOf(this.d));
    ((y)localObject1).a("operationType", this.c);
    ((y)localObject1).a("gzip", String.valueOf(this.g.d()));
    ((y)localObject1).a(new BasicHeader("uuid", UUID.randomUUID().toString()));
    Object localObject2 = this.g.c().b();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((y)localObject1).a((Header)((Iterator)localObject2).next());
      }
    }
    new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(((y)localObject1).toString());
    try
    {
      localObject1 = (ae)this.g.b().a((ad)localObject1).get();
      if (localObject1 == null)
      {
        localObject1 = new com/alipay/android/a/a/a/b;
        ((b)localObject1).<init>(Integer.valueOf(9), "response is null");
        throw ((Throwable)localObject1);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new b(Integer.valueOf(13), "", localInterruptedException);
      byte[] arrayOfByte = localInterruptedException.b();
      return arrayOfByte;
    }
    catch (ExecutionException localExecutionException)
    {
      localObject2 = localExecutionException.getCause();
      t localt;
      if ((localObject2 != null) && ((localObject2 instanceof t)))
      {
        localt = (t)localObject2;
        int i = localt.a();
        switch (i)
        {
        }
        for (;;)
        {
          throw new b(Integer.valueOf(i), localt.b());
          i = 4;
          continue;
          i = 7;
          continue;
          i = 8;
          continue;
          i = 6;
          continue;
          i = 5;
          continue;
          i = 3;
          continue;
          i = 2;
          continue;
          i = 16;
          continue;
          i = 15;
        }
      }
      throw new b(Integer.valueOf(9), "", localt);
    }
    catch (CancellationException localCancellationException)
    {
      throw new b(Integer.valueOf(13), "", localCancellationException);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */