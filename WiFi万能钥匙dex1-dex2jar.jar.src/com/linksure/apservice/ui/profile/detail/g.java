package com.linksure.apservice.ui.profile.detail;

import android.app.Dialog;
import android.os.Message;
import com.bluefay.d.b;
import com.linksure.apservice.R.string;

final class g
  extends b
{
  g(ProfileFragment paramProfileFragment, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    ProfileFragment.a(this.a, this.a.a(this.a.getString(R.string.aps_follow_entering)));
    ProfileFragment.a(this.a).show();
    ProfileFragment.b(this.a).e();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/detail/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */