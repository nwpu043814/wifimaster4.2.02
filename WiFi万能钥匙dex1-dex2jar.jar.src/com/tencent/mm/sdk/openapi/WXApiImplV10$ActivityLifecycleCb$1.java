package com.tencent.mm.sdk.openapi;

import android.util.Log;
import com.tencent.wxop.stat.e;

class WXApiImplV10$ActivityLifecycleCb$1
  implements Runnable
{
  WXApiImplV10$ActivityLifecycleCb$1(WXApiImplV10.ActivityLifecycleCb paramActivityLifecycleCb) {}
  
  public void run()
  {
    if ((WXApiImplV10.access$100() != null) && (WXApiImplV10.ActivityLifecycleCb.access$200(this.this$0)))
    {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
      e.d(WXApiImplV10.ActivityLifecycleCb.access$300(this.this$0), "onBackground_WX");
      WXApiImplV10.ActivityLifecycleCb.access$202(this.this$0, false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/openapi/WXApiImplV10$ActivityLifecycleCb$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */