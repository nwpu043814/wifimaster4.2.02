package com.lantern.permission.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;
import java.util.Map;

final class e
  implements AdapterView.OnItemClickListener
{
  e(CheckSettingFragment paramCheckSettingFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new Bundle();
    paramAdapterView = (Map)CheckSettingFragment.a(this.a).get(paramInt);
    paramView.putString("html", paramAdapterView.get("html").toString());
    paramView.putInt("appName", Integer.parseInt(paramAdapterView.get("name").toString()));
    CheckSettingDetailActivity.a(CheckSettingFragment.b(this.a), paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */