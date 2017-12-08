package com.b.a;

import com.b.a.b.b;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

final class aq
  implements au
{
  private static final bf a = ;
  private static final e b = new e(500);
  private final ay<q<?>> c;
  
  public aq(ay<q<?>> paramay)
  {
    this.c = paramay;
  }
  
  private static <T> T b(Type paramType)
  {
    try
    {
      Class localClass = b.b(paramType);
      Object localObject2 = b.a(localClass);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a.a(localClass);
      }
      return (T)localObject1;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + paramType + ". Register an InstanceCreator with Gson for this type may fix this problem.", localException);
    }
  }
  
  public final <T> T a(Type paramType)
  {
    q localq = (q)this.c.a(paramType);
    if (localq != null) {}
    for (paramType = localq.a(paramType);; paramType = b(paramType)) {
      return paramType;
    }
  }
  
  public final Object a(Type paramType, int paramInt)
  {
    return Array.newInstance(b.b(paramType), paramInt);
  }
  
  public final String toString()
  {
    return this.c.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */