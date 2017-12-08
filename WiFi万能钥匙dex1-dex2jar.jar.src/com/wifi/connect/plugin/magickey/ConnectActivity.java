package com.wifi.connect.plugin.magickey;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import bluefay.R.anim;
import com.lantern.core.model.WkAccessPoint;
import com.qihoo.util.StubApp1053578832;
import com.wifi.connect.plugin.magickey.a.al;
import com.wifi.connect.plugin.magickey.a.am;

public class ConnectActivity
  extends bluefay.app.b
{
  private Handler e = new Handler();
  private com.bluefay.b.a f = new a(this);
  private DialogInterface.OnClickListener g = new e(this);
  private DialogInterface.OnCancelListener h = new f(this);
  private DialogInterface.OnCancelListener i = new g(this);
  private DialogInterface.OnClickListener j = new h(this);
  private DialogInterface.OnClickListener k = new i(this);
  private DialogInterface.OnCancelListener l = new j(this);
  private DialogInterface.OnClickListener m = new k(this);
  private DialogInterface.OnClickListener n = new l(this);
  private WkAccessPoint o;
  private al p;
  private am q;
  private DialogInterface.OnCancelListener r = new b(this);
  private DialogInterface.OnClickListener s = new c(this);
  private DialogInterface.OnClickListener t = new d(this);
  
  static
  {
    StubApp1053578832.interface11(90);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.framework_dialog_enter, R.anim.framework_dialog_exit);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    if (this.q != null) {
      this.q.a(true);
    }
    com.bluefay.b.h.a("set progress null", new Object[0]);
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/ConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */