package com.wifipay.common.eventbus;

final class k
{
  private j a;
  private j b;
  
  final j a()
  {
    try
    {
      j localj = this.a;
      if (this.a != null)
      {
        this.a = this.a.c;
        if (this.a == null) {
          this.b = null;
        }
      }
      return localj;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final j a(int paramInt)
  {
    try
    {
      if (this.a == null) {
        wait(paramInt);
      }
      j localj = a();
      return localj;
    }
    finally {}
  }
  
  final void a(j paramj)
  {
    if (paramj == null) {
      try
      {
        paramj = new java/lang/NullPointerException;
        paramj.<init>("null cannot be enqueued");
        throw paramj;
      }
      finally {}
    }
    if (this.b != null)
    {
      this.b.c = paramj;
      this.b = paramj;
    }
    for (;;)
    {
      notifyAll();
      return;
      if (this.a != null) {
        break;
      }
      this.b = paramj;
      this.a = paramj;
    }
    paramj = new java/lang/IllegalStateException;
    paramj.<init>("Head present, but no tail");
    throw paramj;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */