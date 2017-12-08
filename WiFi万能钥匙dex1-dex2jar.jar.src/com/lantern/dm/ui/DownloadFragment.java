package com.lantern.dm.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView.OnChildClickListener;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.lantern.dm.R.anim;
import com.lantern.dm.R.id;
import com.lantern.dm.R.layout;
import com.lantern.dm.R.string;
import com.lantern.dm.utils.WkListView;
import java.util.HashSet;
import java.util.Set;

public class DownloadFragment
  extends Fragment
{
  private WkListView g;
  private b h;
  private boolean i = true;
  private long j = 0L;
  private Set<Long> k = new HashSet();
  private Cursor l;
  private Cursor m;
  private com.lantern.core.d.a n;
  private CheckBox o;
  private Button p;
  private ViewGroup q;
  private CompoundButton.OnCheckedChangeListener r = new c(this);
  private View.OnClickListener s = new d(this);
  private b.b t = new e(this);
  private b.b u = new f(this);
  private ExpandableListView.OnChildClickListener v = new g(this);
  
  private Menu a(boolean paramBoolean)
  {
    u localu = new u(this.e);
    if (paramBoolean) {
      localu.add(100, 1, 0, R.string.download_edit_list);
    }
    for (;;)
    {
      return localu;
      localu.add(100, 1, 0, R.string.download_cancel_list);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.n = new com.lantern.core.d.a(this.e);
    this.l = this.e.getContentResolver().query(com.lantern.core.model.a.a, null, "status!='200' AND is_visible_in_downloads_ui!='0'", null, null);
    this.m = this.e.getContentResolver().query(com.lantern.core.model.a.a, null, "status='200' AND is_visible_in_downloads_ui!='0'", null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.dm_down_list, paramViewGroup, false);
    this.q = ((ViewGroup)paramViewGroup.findViewById(R.id.load_selection_menu));
    this.o = ((CheckBox)paramViewGroup.findViewById(R.id.load_checkbox_select));
    this.o.setOnCheckedChangeListener(this.r);
    this.p = ((Button)paramViewGroup.findViewById(R.id.load_deselect_all));
    this.p.setOnClickListener(this.s);
    this.g = ((WkListView)paramViewGroup.findViewById(R.id.explistview));
    this.g.a(paramLayoutInflater.inflate(R.layout.dm_down_list_group_head, this.g, false));
    this.h = new b(this.e, this.l, this.m, this.g, this.n, this.t, this.u);
    this.g.setAdapter(this.h);
    this.g.setOnChildClickListener(this.v);
    this.g.expandGroup(0);
    this.g.expandGroup(1);
    return paramViewGroup;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1;
    if ((paramMenuItem.getItemId() == 1) && ((this.l.getCount() != 0) || (this.m.getCount() != 0)))
    {
      if (this.q.getVisibility() != 0) {
        break label115;
      }
      i1 = 1;
      if (i1 != 0) {
        break label120;
      }
      a(a, a(false));
      this.q.setVisibility(0);
      this.q.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.dm_footer_appear));
      this.h.a(true);
    }
    for (;;)
    {
      ((BaseAdapter)this.g.getAdapter()).notifyDataSetChanged();
      return super.onOptionsItemSelected(paramMenuItem);
      label115:
      i1 = 0;
      break;
      label120:
      a(a, a(true));
      this.q.setVisibility(8);
      this.q.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.dm_footer_disappear));
      this.h.a(false);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(R.string.download_file_manager);
    a(a, a(true));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/DownloadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */