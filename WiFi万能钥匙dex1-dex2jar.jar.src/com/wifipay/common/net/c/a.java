package com.wifipay.common.net.c;

import com.wifipay.common.net.HttpManager;
import com.wifipay.common.net.b.k;
import com.wifipay.common.net.b.n;
import com.wifipay.common.net.b.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public abstract class a
  implements d
{
  protected n a = n.a();
  protected String b;
  protected int c = 1;
  protected int d = -1;
  protected int e = -1;
  protected Map f;
  protected Map g;
  protected String h;
  protected boolean i;
  private k j;
  
  public a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  private boolean e()
  {
    if (!com.wifipay.common.net.a.b.a(HttpManager.getInstance().mContext)) {
      this.j.b(new com.wifipay.common.net.b.a.b());
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public a a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public a a(Map paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (this.f == null) {
        this.f = new HashMap();
      }
      this.f.putAll(paramMap);
    }
    return this;
  }
  
  public String a()
  {
    return this.h;
  }
  
  public a b()
  {
    this.j = d();
    if (e())
    {
      this.j.a(new com.wifipay.common.net.b.a(60000, 0, 1.0F));
      this.j.a(this.h);
      HttpManager.getInstance().getRequestQueue().a(this.j);
    }
    return this;
  }
  
  public a b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public a b(Map paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (this.g == null) {
        this.g = new HashMap();
      }
      this.g.putAll(paramMap);
    }
    return this;
  }
  
  public Object c()
  {
    Object localObject1 = null;
    if (this.i) {}
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = this.a.get();
        localObject1 = localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
      }
    }
  }
  
  protected abstract k d();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */