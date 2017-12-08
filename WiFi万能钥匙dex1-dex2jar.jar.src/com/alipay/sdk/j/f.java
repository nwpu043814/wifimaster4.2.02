package com.alipay.sdk.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

final class f
  implements ServiceConnection
{
  f(e parame) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (e.a(this.a))
    {
      e.a(this.a, IAlixPay.Stub.asInterface(paramIBinder));
      e.a(this.a).notify();
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    e.a(this.a, null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */