package com.linksure.apservice.ui.apslist.recommend;

import android.util.Log;
import com.linksure.apservice.a.d.a.b;
import com.linksure.apservice.a.h;
import com.linksure.apservice.b.a;
import com.linksure.apservice.utils.d;
import java.util.List;

final class j
  implements h<List<a>>
{
  j(f paramf) {}
  
  public final void a(b paramb)
  {
    f.a(this.a).a(false);
    Log.e("--->", "fail to load recommend aps:");
    paramb.printStackTrace();
    d.a(paramb);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/recommend/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */