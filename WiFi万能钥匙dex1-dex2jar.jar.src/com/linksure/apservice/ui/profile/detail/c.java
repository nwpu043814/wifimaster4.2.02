package com.linksure.apservice.ui.profile.detail;

import com.linksure.apservice.R.string;
import com.linksure.apservice.a.h;
import com.linksure.apservice.b.a;
import com.linksure.apservice.utils.d;

final class c
  implements h<String>
{
  c(b paramb) {}
  
  public final void a(com.linksure.apservice.a.d.a.b paramb)
  {
    b.a(this.a).a(false, true);
    b.a(this.a).g_(R.string.aps_follow_fail2);
    paramb.printStackTrace();
    d.a(paramb);
    com.linksure.apservice.utils.b.c("saifncncli", b.b(this.a).k, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/detail/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */