package com.lantern.wifilocating.push.h;

import android.os.SystemClock;

public final class c
{
  public long a;
  public long b;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte)
  {
    if (-1L < 0L) {}
    for (this.b = 30000L;; this.b = -1L) {
      return;
    }
  }
  
  public final boolean a()
  {
    long l = SystemClock.elapsedRealtime();
    if (l - this.a >= this.b) {
      this.a = l;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */