package com.lantern.permission.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.lantern.settings.R.array;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckSettingAllFragment
  extends Fragment
{
  private ListView g;
  private Context h;
  private List<Map> i = new ArrayList();
  private Map<String, Object> j;
  private View k;
  private int[][] l;
  private int[] m;
  
  public CheckSettingAllFragment()
  {
    int i2 = R.drawable.settings_permission_setting_mimi_ico;
    int i4 = R.string.setting_xiaomi;
    int i5 = R.drawable.settings_permission_setting_360_ico;
    int i1 = R.string.setting_360;
    int i3 = R.drawable.settings_permission_setting_baidu_ico;
    int n = R.string.setting_baidu;
    this.l = new int[][] { { i2, i4 }, { i5, i1 }, { i3, n } };
    this.m = new int[] { R.array.app_check_setting_detail_xiaomi, R.array.app_check_setting_detail_360, R.array.app_check_setting_detail_baidu };
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(R.string.btn_back);
    this.h = getActivity();
    this.g = ((ListView)this.k.findViewById(R.id.check_setting_all_lv));
    int i1 = this.l.length;
    for (int n = 0; n < i1; n++)
    {
      this.j = new HashMap();
      this.j.put("ico", Integer.valueOf(this.l[n][0]));
      this.j.put("name", Integer.valueOf(this.l[n][1]));
      this.j.put("item", Integer.valueOf(this.m[n]));
      this.i.add(this.j);
    }
    this.g.setAdapter(new a((byte)0));
    this.g.setOnItemClickListener(new c(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.k == null) {
      this.k = paramLayoutInflater.inflate(R.layout.settings_permission_check_setting_all, paramViewGroup, false);
    }
    return this.k;
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
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return CheckSettingAllFragment.a(CheckSettingAllFragment.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return CheckSettingAllFragment.a(CheckSettingAllFragment.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Map localMap = (Map)CheckSettingAllFragment.a(CheckSettingAllFragment.this).get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(CheckSettingAllFragment.b(CheckSettingAllFragment.this)).inflate(R.layout.settings_permission_check_setting_item, null);
        paramViewGroup = new a((byte)0);
        a.a(paramViewGroup, (TextView)paramView.findViewById(R.id.act_check_app_name));
        a.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.act_check_app_ico));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        a.a(paramViewGroup).setText(Integer.parseInt(localMap.get("name").toString()));
        a.b(paramViewGroup).setBackgroundResource(Integer.parseInt(localMap.get("ico").toString()));
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private final class a
    {
      private TextView b;
      private ImageView c;
      
      private a() {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/permission/ui/CheckSettingAllFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */