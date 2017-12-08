package com.wifi.connect.ui;

import android.os.Bundle;
import android.view.MotionEvent;
import bluefay.R.anim;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class ShowHostGuideActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(95);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.framework_activity_close_enter, R.anim.framework_activity_open_exit);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ShowHostGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */