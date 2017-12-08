package com.lantern.browser;

import android.os.Handler;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.location.LocationBean;
import com.lantern.core.location.LocationCallBack;

final class ac
  implements LocationCallBack
{
  ac(WkBrowserJsInterface paramWkBrowserJsInterface) {}
  
  public final void callback(LocationBean paramLocationBean)
  {
    if ((!TextUtils.isEmpty(WkBrowserJsInterface.access$000())) && (paramLocationBean != null))
    {
      h.a("LocationCallBack get location:" + paramLocationBean.getLat() + ", " + paramLocationBean.getLon(), new Object[0]);
      WkBrowserJsInterface.access$300().post(new ad(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */