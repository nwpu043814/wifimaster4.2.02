package com.b.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  static final j a = new j((byte)0);
  private static volatile boolean b = false;
  private static final Class<?> c = b();
  private final Map<Object, Object<?, ?>> d;
  
  j()
  {
    this.d = new HashMap();
  }
  
  private j(byte paramByte)
  {
    this.d = Collections.emptyMap();
  }
  
  public static j a()
  {
    return i.a();
  }
  
  private static Class<?> b()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */