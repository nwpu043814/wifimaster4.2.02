package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.wxop.stat.b.f;

final class z
  extends BroadcastReceiver
{
  z(g paramg) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (g.a(this.cm) != null) {
      g.a(this.cm).a(new ae(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */