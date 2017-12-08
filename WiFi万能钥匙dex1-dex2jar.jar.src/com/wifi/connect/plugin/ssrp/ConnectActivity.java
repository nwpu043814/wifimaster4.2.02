package com.wifi.connect.plugin.ssrp;

import android.os.Bundle;
import bluefay.R.anim;
import bluefay.app.b;
import com.lantern.core.model.WkAccessPoint;
import com.qihoo.util.StubApp1053578832;

public class ConnectActivity
  extends b
{
  private com.bluefay.b.a e = new a(this);
  private WkAccessPoint f;
  private com.wifi.connect.plugin.ssrp.b.h g;
  private com.wifi.connect.plugin.ssrp.b.a h;
  
  static
  {
    StubApp1053578832.interface11(92);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.framework_dialog_enter, R.anim.framework_dialog_exit);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    if (this.g != null) {
      this.g.a();
    }
    com.bluefay.b.h.a("set progress null", new Object[0]);
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/ConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */