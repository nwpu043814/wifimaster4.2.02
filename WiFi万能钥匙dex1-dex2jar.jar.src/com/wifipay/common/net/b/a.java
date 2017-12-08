package com.wifipay.common.net.b;

import com.wifipay.common.net.b.a.h;

public class a
  implements t
{
  private int a;
  private int b;
  private final int c;
  private final float d;
  
  public a()
  {
    this(20000, 0, 1.0F);
  }
  
  public a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(h paramh)
  {
    this.b += 1;
    this.a = ((int)(this.a + this.a * this.d));
    if (!c()) {
      throw paramh;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected boolean c()
  {
    if (this.b <= this.c) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */