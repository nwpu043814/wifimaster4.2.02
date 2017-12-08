package com.wifipay.common.net.b.b;

import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.b.a.d;
import com.wifipay.common.net.b.a.h;
import com.wifipay.common.net.b.j;
import com.wifipay.common.net.b.k;
import com.wifipay.common.net.b.r;
import com.wifipay.common.net.b.u;
import com.wifipay.common.net.entitybase.BaseResp;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class b
  extends k
{
  private final Class a;
  
  public b(int paramInt, String paramString, Class paramClass, u paramu)
  {
    super(paramInt, paramString, paramu);
    this.a = paramClass;
  }
  
  protected r a(j paramj)
  {
    try
    {
      String str = new java/lang/String;
      str.<init>(paramj.b, g.a(paramj.c));
      Logger.v("tag = %s; response = %s", new Object[] { b(), str });
      BaseResp localBaseResp = (BaseResp)this.a.newInstance();
      localBaseResp.parse(str, paramj.c.containsKey("sourceApp"));
      paramj = r.a(localBaseResp);
      return paramj;
    }
    catch (UnsupportedEncodingException paramj)
    {
      for (;;)
      {
        paramj = r.a(new d(paramj));
      }
    }
    catch (InstantiationException paramj)
    {
      for (;;)
      {
        paramj = r.a(new d(paramj));
      }
    }
    catch (IllegalAccessException paramj)
    {
      for (;;)
      {
        paramj = r.a(new d(paramj));
      }
    }
  }
  
  public BaseResp d(h paramh)
  {
    String str;
    if ((paramh instanceof com.wifipay.common.net.b.a.b)) {
      str = "{\"resultCode\":\"-10001\",\"resultMessage\":\"网络异常\"}";
    }
    for (;;)
    {
      Logger.v("tag = %s; errorResponse = %s;  error = ", new Object[] { b(), str, paramh.getClass() });
      try
      {
        paramh = (BaseResp)this.a.newInstance();
      }
      catch (InstantiationException localInstantiationException1)
      {
        for (;;)
        {
          paramh = null;
          localInstantiationException1.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        for (;;)
        {
          paramh = null;
          localIllegalAccessException1.printStackTrace();
        }
      }
      try
      {
        paramh.parse(str, false);
        return paramh;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        break label88;
      }
      catch (InstantiationException localInstantiationException2)
      {
        break;
      }
      if ((paramh instanceof com.wifipay.common.net.b.a.g)) {
        str = "{\"resultCode\":\"-10002\",\"resultMessage\":\"请求超时\"}";
      } else {
        str = "{\"resultCode\":\"-10003\",\"resultMessage\":\"服务器异常\"}";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */