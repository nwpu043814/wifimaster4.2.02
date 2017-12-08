package com.wifipay.common.net;

import com.wifipay.common.net.annotations.Host;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class RpcFactory
{
  private static RpcInvocationHandler a(String paramString, Class paramClass)
  {
    Class localClass = paramClass;
    if (paramClass == null) {
      localClass = RpcInvocationHandler.class;
    }
    try
    {
      paramClass = localClass.getConstructor(new Class[] { String.class });
      paramClass.setAccessible(true);
      paramString = (RpcInvocationHandler)paramClass.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("Failed to create InvocationHandler. ", paramString);
    }
  }
  
  private static RpcInvocationHandler a(String paramString, Class paramClass, boolean paramBoolean)
  {
    Class localClass = paramClass;
    if (paramClass == null) {
      localClass = RpcInvocationHandler.class;
    }
    try
    {
      paramClass = localClass.getConstructor(new Class[] { String.class, Boolean.class });
      paramClass.setAccessible(true);
      paramString = (RpcInvocationHandler)paramClass.newInstance(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("Failed to create InvocationHandler. ", paramString);
    }
  }
  
  public static Object create(Class paramClass1, Class paramClass2, boolean paramBoolean)
  {
    String str = ((Host)paramClass1.getAnnotation(Host.class)).value();
    if (paramBoolean) {}
    for (paramClass2 = a(str, paramClass2, paramBoolean);; paramClass2 = a(str, paramClass2)) {
      return Proxy.newProxyInstance(paramClass1.getClassLoader(), new Class[] { paramClass1 }, paramClass2);
    }
  }
  
  public static Object create(Class paramClass, boolean paramBoolean)
  {
    Object localObject = ((Host)paramClass.getAnnotation(Host.class)).value();
    ClassLoader localClassLoader = paramClass.getClassLoader();
    localObject = new RpcInvocationHandler((String)localObject, Boolean.valueOf(paramBoolean));
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, (InvocationHandler)localObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/RpcFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */