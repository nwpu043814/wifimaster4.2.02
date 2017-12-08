package com.wifi.connect.ui;

import android.os.Bundle;
import bluefay.app.b;
import com.lantern.connect.R.anim;
import com.qihoo.util.StubApp1053578832;

public class TopViewNearbyApActivity
  extends b
{
  static
  {
    StubApp1053578832.interface11(96);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.connect_top_in, R.anim.connect_top_out);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onPause()
  {
    super.onPause();
    finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/TopViewNearbyApActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */