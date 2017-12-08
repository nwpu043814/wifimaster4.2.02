package com.linksure.apservice.ui.apslist;

import android.view.View;
import android.view.View.OnClickListener;
import com.linksure.apservice.ui.apslist.list.ApsListFragment;
import com.linksure.apservice.ui.apslist.recommend.RecommendFragment;

final class b
  implements View.OnClickListener
{
  b(ApsListActivity paramApsListActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.f();
    if (ApsListActivity.a(this.a).equals(ApsListFragment.class.getName())) {
      com.linksure.apservice.utils.b.d("saadmrcli");
    }
    for (;;)
    {
      return;
      if (ApsListActivity.a(this.a).equals(RecommendFragment.class.getName())) {
        com.linksure.apservice.utils.b.d("saadnmrcli");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */