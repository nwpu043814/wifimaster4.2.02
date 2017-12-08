package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import java.security.AccessController;
import java.security.ProtectionDomain;

public class ASMClassLoader
  extends ClassLoader
{
  private static ProtectionDomain DOMAIN = (ProtectionDomain)AccessController.doPrivileged(new ASMClassLoader.1());
  
  public ASMClassLoader()
  {
    super(getParentClassLoader());
  }
  
  static ClassLoader getParentClassLoader()
  {
    ClassLoader localClassLoader1 = Thread.currentThread().getContextClassLoader();
    if (localClassLoader1 != null) {}
    for (;;)
    {
      try
      {
        localClassLoader1.loadClass(JSON.class.getName());
        return localClassLoader1;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
      ClassLoader localClassLoader2 = JSON.class.getClassLoader();
    }
  }
  
  public Class<?> defineClassPublic(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return defineClass(paramString, paramArrayOfByte, paramInt1, paramInt2, DOMAIN);
  }
  
  public boolean isExternalClass(Class<?> paramClass)
  {
    boolean bool = false;
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = this;
    if (localClassLoader == null) {}
    for (;;)
    {
      return bool;
      do
      {
        paramClass = paramClass.getParent();
        if (paramClass == null) {
          break;
        }
      } while (paramClass != localClassLoader);
      continue;
      bool = true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/ASMClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */