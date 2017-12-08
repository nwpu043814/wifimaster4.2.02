package com.lantern.wifitools.examination;

import android.os.Bundle;
import android.os.Handler;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.wifiseccheck.ExtraInfo;
import com.lantern.wifiseccheck.WifiSecCheckImpl.CheckModel;
import com.lantern.wifiseccheck.WifiSecCheckManager.WifiCheckListener;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifiseccheck.protocol.GpsCoordinate;
import com.lantern.wifitools.view.CustomTextView;

final class n
  extends WifiSecCheckManager.WifiCheckListener
{
  n(ExaminationFragment paramExaminationFragment, WifiSecCheckImpl.CheckModel paramCheckModel)
  {
    super(paramCheckModel);
  }
  
  public final void detectCount(int paramInt1, int paramInt2, int paramInt3)
  {
    ExaminationFragment.a(this.a).putInt("neighbors", paramInt1 + 1);
  }
  
  public final String getAppId()
  {
    return c.getServer().k();
  }
  
  public final String getConnChanid()
  {
    return c.getServer().b();
  }
  
  public final String getDhid()
  {
    return c.getServer().g();
  }
  
  public final GpsCoordinate getLocation()
  {
    GpsCoordinate localGpsCoordinate = new GpsCoordinate();
    try
    {
      localGpsCoordinate.setLatitude(Float.parseFloat(c.getServer().d()));
      localGpsCoordinate.setLongitude(Float.parseFloat(c.getServer().e()));
      return localGpsCoordinate;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        localGpsCoordinate.setLatitude(0.0F);
        localGpsCoordinate.setLongitude(0.0F);
      }
    }
  }
  
  public final Integer getNetWorkSpeed()
  {
    return Integer.valueOf(0);
  }
  
  public final int getSource()
  {
    return 1;
  }
  
  public final void onCheckError(int paramInt) {}
  
  public final void onCheckFinish(ApMarkResult paramApMarkResult, ExtraInfo paramExtraInfo)
  {
    if (this.a.getActivity() != null)
    {
      ((ExaminationActivity)this.a.getActivity()).a(paramApMarkResult);
      long l = System.currentTimeMillis() - ExaminationFragment.d(this.a);
      if (l >= 9500L) {
        break label87;
      }
      ExaminationFragment.e(this.a).a(100, (int)(9500L - l));
      ExaminationFragment.b(this.a).postDelayed(new o(this), 10000L - l);
    }
    for (;;)
    {
      return;
      label87:
      ExaminationFragment.e(this.a).a(100, 500);
      ExaminationFragment.b(this.a).postDelayed(new p(this), 600L);
    }
  }
  
  public final void onLoadCallback(ApNeighbourRes paramApNeighbourRes) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */