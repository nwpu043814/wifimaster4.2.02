package com.alipay.android.a.a.a;

import android.os.Looper;
import com.alipay.android.a.a.a.a.d;
import com.alipay.android.a.a.a.a.f;
import com.alipay.d.a.a.a.a;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
{
  private static final ThreadLocal a = new ThreadLocal();
  private static final ThreadLocal b = new ThreadLocal();
  private byte c = 0;
  private AtomicInteger d;
  private c e;
  
  public e(c paramc)
  {
    this.e = paramc;
    this.d = new AtomicInteger();
  }
  
  public final Object a(Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool = true;
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper())) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IllegalThreadStateException("can't in main thread call rpc .");
    }
    Object localObject1 = (a)paramMethod.getAnnotation(a.class);
    if (paramMethod.getAnnotation(com.alipay.d.a.a.a.b.class) != null) {}
    Type localType;
    for (;;)
    {
      localType = paramMethod.getGenericReturnType();
      paramMethod.getAnnotations();
      a.set(null);
      b.set(null);
      if (localObject1 != null) {
        break;
      }
      throw new IllegalStateException("OperationType must be set.");
      bool = false;
    }
    localObject1 = ((a)localObject1).a();
    i = this.d.incrementAndGet();
    try
    {
      if (this.c == 0)
      {
        Object localObject2 = new com/alipay/android/a/a/a/a/e;
        ((com.alipay.android.a.a.a.a.e)localObject2).<init>(i, (String)localObject1, paramArrayOfObject);
        if (b.get() != null) {
          ((f)localObject2).a(b.get());
        }
        paramArrayOfObject = ((f)localObject2).a();
        localObject2 = new com/alipay/android/a/a/a/r;
        ((r)localObject2).<init>(this.e.a(), paramMethod, i, (String)localObject1, paramArrayOfObject, bool);
        paramArrayOfObject = (byte[])((af)localObject2).a();
        b.set(null);
        paramMethod = new com/alipay/android/a/a/a/a/d;
        paramMethod.<init>(localType, paramArrayOfObject);
        paramMethod = paramMethod.a();
        if (localType != Void.TYPE) {
          a.set(paramMethod);
        }
      }
      return a.get();
    }
    catch (b paramMethod)
    {
      paramMethod.a((String)localObject1);
      throw paramMethod;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */