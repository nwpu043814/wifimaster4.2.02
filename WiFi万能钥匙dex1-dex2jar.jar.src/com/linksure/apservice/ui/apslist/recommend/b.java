package com.linksure.apservice.ui.apslist.recommend;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.linksure.apservice.b.a;
import com.linksure.apservice.ui.home.ApServiceActivity;
import com.linksure.apservice.ui.profile.ProfileActivity;

final class b
  implements AdapterView.OnItemClickListener
{
  b(RecommendFragment paramRecommendFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = this.a;
    paramAdapterView = (a)paramAdapterView.getAdapter().getItem(paramInt);
    Intent localIntent;
    if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.k)))
    {
      if (!paramAdapterView.e) {
        break label93;
      }
      localIntent = new Intent(paramView.getActivity(), ApServiceActivity.class);
      localIntent.putExtra("aps_id", paramAdapterView.k);
      localIntent.putExtra("refer", "rcmd");
      paramView.startActivity(localIntent);
    }
    for (;;)
    {
      com.linksure.apservice.utils.b.a("saadnnacli", paramAdapterView.k);
      return;
      label93:
      localIntent = new Intent(paramView.getActivity(), ProfileActivity.class);
      localIntent.putExtra("obj", paramAdapterView);
      paramView.startActivity(localIntent);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/recommend/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */