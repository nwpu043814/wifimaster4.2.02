package com.lantern.location.mapt;

import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.location.LocationBean;
import com.lantern.core.o;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;

final class a
  implements TencentLocationListener
{
  a(WkLocationManagerT paramWkLocationManagerT) {}
  
  public final void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    this.a.stopLocation();
    if (paramInt == 0)
    {
      h.a("-------tencent map located success-------", new Object[0]);
      WkLocationManagerT.access$000(this.a, paramTencentLocation);
      paramTencentLocation = WkLocationManagerT.access$100(paramTencentLocation);
      if (paramTencentLocation != null)
      {
        c.getServer().e("t");
        c.getServer().a(String.valueOf(paramTencentLocation.getLon()), String.valueOf(paramTencentLocation.getLat()));
        WkLocationManagerT.access$200(this.a, paramTencentLocation);
      }
    }
    for (;;)
    {
      return;
      WkLocationManagerT.access$000(this.a, null);
    }
  }
  
  public final void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/location/mapt/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */