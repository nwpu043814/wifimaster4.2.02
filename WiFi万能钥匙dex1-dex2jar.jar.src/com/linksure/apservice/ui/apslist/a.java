package com.linksure.apservice.ui.apslist;

import android.os.Message;
import com.bluefay.d.b;
import com.linksure.apservice.ui.apslist.list.ApsListFragment;

final class a
  extends b
{
  a(ApsListActivity paramApsListActivity, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (!ApsListActivity.a(this.a).equals(ApsListFragment.class.getName())) {
      this.a.i();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */