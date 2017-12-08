package com.alipay.a.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a
{
  public static Class a(Type paramType)
  {
    for (;;)
    {
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      if (!(paramType instanceof ParameterizedType)) {
        break;
      }
      paramType = ((ParameterizedType)paramType).getRawType();
    }
    throw new IllegalArgumentException("TODO");
  }
  
  public static boolean a(Class paramClass)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramClass.isPrimitive()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!paramClass.equals(String.class))
      {
        bool1 = bool2;
        if (!paramClass.equals(Integer.class))
        {
          bool1 = bool2;
          if (!paramClass.equals(Long.class))
          {
            bool1 = bool2;
            if (!paramClass.equals(Double.class))
            {
              bool1 = bool2;
              if (!paramClass.equals(Float.class))
              {
                bool1 = bool2;
                if (!paramClass.equals(Boolean.class))
                {
                  bool1 = bool2;
                  if (!paramClass.equals(Short.class))
                  {
                    bool1 = bool2;
                    if (!paramClass.equals(Character.class))
                    {
                      bool1 = bool2;
                      if (!paramClass.equals(Byte.class))
                      {
                        bool1 = bool2;
                        if (!paramClass.equals(Void.class)) {
                          bool1 = false;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */