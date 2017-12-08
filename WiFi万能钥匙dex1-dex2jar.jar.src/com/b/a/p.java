package com.b.a;

final class p
  implements i
{
  private static boolean b(Class<?> paramClass)
  {
    boolean bool = true;
    int i;
    if (paramClass.isMemberClass()) {
      if ((paramClass.getModifiers() & 0x8) != 0)
      {
        i = 1;
        if (i != 0) {
          break label32;
        }
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label32:
      bool = false;
    }
  }
  
  public final boolean a(l paraml)
  {
    return b(paraml.c());
  }
  
  public final boolean a(Class<?> paramClass)
  {
    return b(paramClass);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */