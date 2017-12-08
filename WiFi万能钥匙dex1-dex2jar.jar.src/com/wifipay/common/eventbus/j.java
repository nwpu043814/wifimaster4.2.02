package com.wifipay.common.eventbus;

import java.util.ArrayList;
import java.util.List;

final class j
{
  private static final List d = new ArrayList();
  Object a;
  p b;
  j c;
  
  private j(Object paramObject, p paramp)
  {
    this.a = paramObject;
    this.b = paramp;
  }
  
  static j a(p paramp, Object paramObject)
  {
    synchronized (d)
    {
      int i = d.size();
      if (i > 0)
      {
        j localj = (j)d.remove(i - 1);
        localj.a = paramObject;
        localj.b = paramp;
        localj.c = null;
        paramp = localj;
        return paramp;
      }
      paramp = new j(paramObject, paramp);
    }
  }
  
  static void a(j paramj)
  {
    paramj.a = null;
    paramj.b = null;
    paramj.c = null;
    synchronized (d)
    {
      if (d.size() < 10000) {
        d.add(paramj);
      }
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */