package cm.pass.sdk.net;

import a.a.a.c.b;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import cm.pass.sdk.utils.j;

class i$1
  extends ConnectivityManager.NetworkCallback
{
  i$1(i parami) {}
  
  public void onAvailable(Network paramNetwork)
  {
    this.a.c = paramNetwork;
    cm.pass.sdk.utils.i locali = this.a.b;
    cm.pass.sdk.utils.i.a(paramNetwork);
    j.c(i.a, "onAvailable");
    i.a(this.a, paramNetwork);
    i.a(this.a).h();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/i$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */