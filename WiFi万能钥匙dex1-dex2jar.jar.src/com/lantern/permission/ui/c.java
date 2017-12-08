package com.lantern.permission.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;
import java.util.Map;

final class c
  implements AdapterView.OnItemClickListener
{
  c(CheckSettingAllFragment paramCheckSettingAllFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new Bundle();
    paramAdapterView = (Map)CheckSettingAllFragment.a(this.a).get(paramInt);
    paramView.putInt("appName", Integer.parseInt(paramAdapterView.get("name").toString()));
    paramView.putInt("appIco", Integer.parseInt(paramAdapterView.get("ico").toString()));
    paramView.putInt("appSn", Integer.parseInt(paramAdapterView.get("item").toString()));
    CheckSettingDetailActivity.a(CheckSettingAllFragment.b(this.a), paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */