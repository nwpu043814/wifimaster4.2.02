package com.lantern.download.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView.OnChildClickListener;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.lantern.dm.R.anim;
import com.lantern.dm.R.id;
import com.lantern.dm.R.layout;
import com.lantern.dm.R.string;
import com.lantern.download.utils.PinnedExpandableListView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DownloadFragment
  extends Fragment
{
  private PinnedExpandableListView g;
  private ViewGroup h;
  private CheckBox i;
  private Button j;
  private com.lantern.core.d.a k;
  private a l;
  private a m;
  private HashSet<Long> n;
  private View.OnClickListener o = new d(this);
  private ExpandableListView.OnChildClickListener p = new e(this);
  
  private void a(Map<Long, Boolean> paramMap, boolean paramBoolean)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (paramBoolean)
        {
          this.n.add(localEntry.getKey());
          paramMap.put(localEntry.getKey(), Boolean.valueOf(true));
          this.i.setChecked(true);
        }
        else
        {
          this.n.clear();
          paramMap.put(localEntry.getKey(), Boolean.valueOf(false));
          this.i.setChecked(false);
        }
      }
    }
  }
  
  private int c()
  {
    return this.l.getChildrenCount(0) + this.l.getChildrenCount(1);
  }
  
  private Menu d(int paramInt)
  {
    u localu = new u(this.e);
    if (paramInt == 0) {
      localu.add(100, 1001, 0, R.string.download_edit_list);
    }
    for (;;)
    {
      return localu;
      localu.add(100, 1001, 0, R.string.download_cancel_list);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.n = new HashSet();
    this.k = new com.lantern.core.d.a(this.e);
    this.m = new a();
    this.l = new a(this.e, this.k);
    this.e.getContentResolver().registerContentObserver(com.lantern.core.model.a.a, true, this.m);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.dm_download_list, paramViewGroup, false);
    this.h = ((ViewGroup)paramViewGroup.findViewById(R.id.load_selection_menu));
    this.i = ((CheckBox)paramViewGroup.findViewById(R.id.load_checkbox_select));
    this.j = ((Button)paramViewGroup.findViewById(R.id.load_deselect_all));
    this.g = ((PinnedExpandableListView)paramViewGroup.findViewById(R.id.download_expandablelistview));
    this.g.a(paramLayoutInflater.inflate(R.layout.dm_download_group, this.g, false));
    this.g.setAdapter(this.l);
    this.g.setOnChildClickListener(this.p);
    this.j.setOnClickListener(this.o);
    this.i.setOnClickListener(this.o);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.getContentResolver().unregisterContentObserver(this.m);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 1001) && (c() > 0))
    {
      if (this.h.getVisibility() != 0) {
        break label95;
      }
      a(a, d(0));
      this.h.setVisibility(8);
      this.h.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.dm_footer_disappear));
    }
    for (;;)
    {
      this.l.a(this.h.getVisibility());
      this.l.notifyDataSetChanged();
      return super.onOptionsItemSelected(paramMenuItem);
      label95:
      a(a, d(1));
      a(this.l.b(), false);
      this.h.setVisibility(0);
      this.h.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.dm_footer_appear));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(R.string.download_file_manager);
    a(a, d(0));
  }
  
  private final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      DownloadFragment.a(DownloadFragment.this).a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/DownloadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */