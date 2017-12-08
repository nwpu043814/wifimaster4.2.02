package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

final class ak
{
  final HandlerThread a;
  final j b;
  final Handler c;
  long d;
  long e;
  long f;
  long g;
  long h;
  long i;
  long j;
  long k;
  int l;
  int m;
  int n;
  
  ak(j paramj)
  {
    this.b = paramj;
    this.a = new HandlerThread("Picasso-Stats", 10);
    this.a.start();
    at.a(this.a.getLooper());
    this.c = new a(this.a.getLooper(), this);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    int i1 = at.a(paramBitmap);
    this.c.sendMessage(this.c.obtainMessage(paramInt, i1, 0));
  }
  
  final void a()
  {
    this.c.sendEmptyMessage(0);
  }
  
  final void a(Bitmap paramBitmap)
  {
    a(paramBitmap, 2);
  }
  
  final void b(Bitmap paramBitmap)
  {
    a(paramBitmap, 3);
  }
  
  private static final class a
    extends Handler
  {
    private final ak a;
    
    public a(Looper paramLooper, ak paramak)
    {
      super();
      this.a = paramak;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        aa.a.post(new al(this, paramMessage));
      }
      for (;;)
      {
        return;
        paramMessage = this.a;
        paramMessage.d += 1L;
        continue;
        paramMessage = this.a;
        paramMessage.e += 1L;
        continue;
        ak localak = this.a;
        long l = paramMessage.arg1;
        localak.m += 1;
        localak.g = (l + localak.g);
        int i = localak.m;
        localak.j = (localak.g / i);
        continue;
        localak = this.a;
        l = paramMessage.arg1;
        localak.n += 1;
        localak.h = (l + localak.h);
        i = localak.m;
        localak.k = (localak.h / i);
        continue;
        localak = this.a;
        paramMessage = (Long)paramMessage.obj;
        localak.l += 1;
        localak.f += paramMessage.longValue();
        i = localak.l;
        localak.i = (localak.f / i);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */