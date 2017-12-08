package com.lantern.permission.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bluefay.app.Fragment;
import bluefay.app.b;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public class CheckSettingChangedFragment
  extends Fragment
{
  private View g;
  private TextView h;
  private TextView i;
  private Button j;
  private ImageView k;
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(R.string.btn_back);
    this.j = ((Button)this.g.findViewById(R.id.btn_changed));
    this.j.setOnClickListener(new d(this));
    this.h = ((TextView)this.g.findViewById(R.id.setting_permission_complete));
    this.i = ((TextView)this.g.findViewById(R.id.setting_permission_msg));
    this.k = ((ImageView)this.g.findViewById(R.id.setting_permission_complete_ico));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.g == null) {
      this.g = paramLayoutInflater.inflate(R.layout.settings_permission_check_setting_changed, paramViewGroup, false);
    }
    return this.g;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    b localb = (b)this.e;
    boolean bool;
    if (localb != null)
    {
      bool = localb.c();
      if ((!bool) && (this.h != null) && (this.j != null)) {
        break label45;
      }
    }
    for (;;)
    {
      return;
      bool = true;
      break;
      label45:
      if (a.a().b())
      {
        this.h.setText(getString(R.string.check_setting_changed_view_tutorial));
        this.i.setText(R.string.check_setting_changed_complete_configuration);
        this.k.setBackgroundResource(R.drawable.settings_permission_check_setting_changed_bg_fail);
      }
      else
      {
        this.h.setText(getString(R.string.check_setting_changed_repair));
        this.i.setText(R.string.check_setting_changed_complete_sucess);
        this.k.setBackgroundResource(R.drawable.settings_permission_check_setting_changed_bg);
        this.j.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingChangedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */