package com.lantern.wifitools.examination;

import android.os.Bundle;
import bluefay.app.m;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.qihoo.util.StubApp1053578832;

public class ExaminationActivity
  extends m
{
  private ApMarkResult e;
  
  static
  {
    StubApp1053578832.interface11(67);
  }
  
  public final void a(ApMarkResult paramApMarkResult)
  {
    this.e = paramApMarkResult;
  }
  
  public final ApMarkResult f()
  {
    return this.e;
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/ExaminationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */