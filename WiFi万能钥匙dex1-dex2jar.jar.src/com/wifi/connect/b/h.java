package com.wifi.connect.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.lantern.analytics.a;

final class h
  implements DialogInterface.OnClickListener
{
  h(d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    d.k(this.a);
    new com.wifi.connect.d.d(d.c(this.a), d.d(this.a)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    a.e().onEvent("qa5qry_Y");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */