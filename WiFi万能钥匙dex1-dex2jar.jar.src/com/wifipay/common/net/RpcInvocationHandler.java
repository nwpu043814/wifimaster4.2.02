package com.wifipay.common.net;

import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.annotations.Header;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.common.net.c.a;
import com.wifipay.common.net.c.b;
import com.wifipay.common.net.c.d;
import com.wifipay.common.net.entitybase.BaseResp;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RpcInvocationHandler
  implements InvocationHandler
{
  private boolean mBg;
  private String mHost;
  
  public RpcInvocationHandler(String paramString)
  {
    this(paramString, Boolean.valueOf(false));
  }
  
  public RpcInvocationHandler(String paramString, Boolean paramBoolean)
  {
    this.mHost = paramString;
    this.mBg = paramBoolean.booleanValue();
  }
  
  private void parseParams(Method paramMethod, Object[] paramArrayOfObject, d paramd, HashMap paramHashMap1, HashMap paramHashMap2)
  {
    paramMethod = paramMethod.getParameterAnnotations();
    if (paramArrayOfObject == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < paramArrayOfObject.length; i++)
      {
        paramd = paramArrayOfObject[i];
        if (paramd != null)
        {
          Object localObject1 = paramMethod[i];
          if (localObject1.length > 0)
          {
            int k = localObject1.length;
            int j = 0;
            if (j < k)
            {
              Object localObject2 = localObject1[j];
              Class localClass = ((Annotation)localObject2).annotationType();
              if (Param.class == localClass) {
                paramHashMap1.put(((Param)localObject2).value(), paramd.toString());
              }
              for (;;)
              {
                j++;
                break;
                if (Header.class == localClass) {
                  paramHashMap2.put(((Header)localObject2).value(), paramd.toString());
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected Map defaultHeaders(String paramString)
  {
    return Collections.emptyMap();
  }
  
  protected Map defaultParams(String paramString)
  {
    return Collections.emptyMap();
  }
  
  protected Map encryptParams(Map paramMap)
  {
    return paramMap;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getGenericReturnType();
    if (!BaseResp.class.isAssignableFrom((Class)paramObject)) {
      throw new IllegalArgumentException("Return type must be assignable from BaseResp.class");
    }
    paramObject = new b(this.mBg, (Class)paramObject);
    Object localObject = (OperationType)paramMethod.getAnnotation(OperationType.class);
    if (localObject == null) {
      throw new IllegalArgumentException("need OperationType annotation");
    }
    ((a)paramObject).b(((OperationType)localObject).value());
    Logger.v("zhao == %s", new Object[] { this.mHost + ((OperationType)localObject).value() });
    ((a)paramObject).a(this.mHost + ((OperationType)localObject).value());
    localObject = new HashMap();
    HashMap localHashMap = new HashMap();
    ((HashMap)localObject).putAll(defaultParams(((a)paramObject).a()));
    localHashMap.putAll(defaultHeaders(((a)paramObject).a()));
    parseParams(paramMethod, paramArrayOfObject, (d)paramObject, (HashMap)localObject, localHashMap);
    ((a)paramObject).b(localHashMap);
    ((a)paramObject).a(encryptParams((Map)localObject));
    ((a)paramObject).b();
    return ((a)paramObject).c();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/RpcInvocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */