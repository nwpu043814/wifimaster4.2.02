package com.linksure.apservice.ui.common;

import android.os.Bundle;
import bluefay.app.m;
import com.lantern.analytics.a;
import com.qihoo.util.StubApp1053578832;

public class ImageViewerActivity
  extends m
{
  private String e;
  private String f;
  
  static
  {
    StubApp1053578832.interface11(75);
  }
  
  protected final boolean b()
  {
    return false;
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onPause()
  {
    super.onPause();
    a.a(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    a.b(this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/ImageViewerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */