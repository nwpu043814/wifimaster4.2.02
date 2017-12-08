package com.lantern.dm.ui;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lantern.dm.R.id;
import com.lantern.dm.R.layout;
import com.lantern.dm.R.string;
import com.lantern.dm.model.TaskItem;
import com.lantern.dm.utils.WkListView;
import com.lantern.dm.utils.WkListView.a;
import java.util.Iterator;
import java.util.Vector;

public final class b
  implements ExpandableListAdapter, WkListView.a
{
  private Context a;
  private WkListView b;
  private com.lantern.core.d.a c;
  private Vector<DataSetObserver> d;
  private Cursor e;
  private Cursor f;
  private a g;
  private i h;
  private String[] i = new String[2];
  private int[] j = { 0, 0 };
  private SparseIntArray k = new SparseIntArray();
  
  public b(Context paramContext, Cursor paramCursor1, Cursor paramCursor2, WkListView paramWkListView, com.lantern.core.d.a parama, b paramb1, b paramb2)
  {
    this.a = paramContext;
    this.e = paramCursor1;
    this.f = paramCursor2;
    this.b = paramWkListView;
    this.c = parama;
    this.d = new Vector();
    this.h = new i(this.a, this.e, this.c, paramb1);
    this.g = new a(this.a, this.f, paramb2);
    this.e.registerContentObserver(new a());
    this.e.registerDataSetObserver(new c((byte)0));
    this.f.registerContentObserver(new a());
    this.f.registerDataSetObserver(new c((byte)0));
    this.i[0] = this.a.getString(R.string.download_running_file);
    this.i[1] = this.a.getString(R.string.download_complete_notification);
    this.j[0] = this.e.getCount();
    this.j[1] = this.f.getCount();
  }
  
  public final int a(int paramInt)
  {
    if (this.k.keyAt(paramInt) >= 0) {}
    for (paramInt = this.k.get(paramInt);; paramInt = 0) {
      return paramInt;
    }
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == getChildrenCount(paramInt1) - 1) {
      paramInt1 = 2;
    }
    for (;;)
    {
      return paramInt1;
      if ((paramInt2 == -1) && (!this.b.isGroupExpanded(paramInt1))) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    String str = this.i[paramInt];
    ((TextView)paramView.findViewById(R.id.dm_tv_load_group)).setText(str);
    ((TextView)paramView.findViewById(R.id.dm_tv_load_count)).setText("(" + this.j[paramInt] + ")");
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
    this.h.a(paramBoolean);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.k.put(paramInt1, paramInt2);
  }
  
  public final Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public final long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public final View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramBoolean = false;
    if (paramView == null)
    {
      paramView = (TaskItem)LayoutInflater.from(this.a).inflate(R.layout.dm_down_task_adapter, paramViewGroup, false);
      paramView.setTag(new d(paramView));
    }
    for (;;)
    {
      d locald;
      if ((paramView != null) && ((paramView instanceof TaskItem)))
      {
        paramViewGroup = (TaskItem)paramView;
        locald = (d)paramViewGroup.getTag();
        if (locald != null)
        {
          if (paramInt1 != 0) {
            break label134;
          }
          paramViewGroup.a(this.h.a());
          locald.h.setVisibility(0);
          locald.d.setVisibility(0);
        }
      }
      if (paramInt1 == 0) {
        if (this.e.isClosed()) {
          label127:
          if (paramBoolean) {
            break label183;
          }
        }
      }
      label134:
      label183:
      label237:
      for (;;)
      {
        return paramView;
        paramViewGroup.a(this.g.a());
        locald.h.setVisibility(8);
        locald.d.setVisibility(8);
        break;
        paramBoolean = this.e.moveToPosition(paramInt2);
        break label127;
        this.h.a(paramView);
        continue;
        if (this.f.isClosed()) {}
        for (paramBoolean = false;; paramBoolean = this.f.moveToPosition(paramInt2))
        {
          if (!paramBoolean) {
            break label237;
          }
          this.g.a(paramView);
          break;
        }
      }
    }
  }
  
  public final int getChildrenCount(int paramInt)
  {
    return this.j[paramInt];
  }
  
  public final long getCombinedChildId(long paramLong1, long paramLong2)
  {
    return paramLong2;
  }
  
  public final long getCombinedGroupId(long paramLong)
  {
    return paramLong;
  }
  
  public final Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final int getGroupCount()
  {
    return 2;
  }
  
  public final long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a).inflate(R.layout.dm_down_list_group, paramViewGroup, false);
    }
    paramViewGroup = (TextView)localView.findViewById(R.id.dm_tv_load_group);
    paramView = (TextView)localView.findViewById(R.id.dm_tv_load_count);
    if (paramInt == 0)
    {
      paramViewGroup.setText(this.i[0]);
      paramView.setText("(" + this.j[0] + ")");
    }
    for (;;)
    {
      return localView;
      paramViewGroup.setText(this.i[1]);
      paramView.setText("(" + this.j[1] + ")");
    }
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  public final boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final void onGroupCollapsed(int paramInt) {}
  
  public final void onGroupExpanded(int paramInt) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.d.add(paramDataSetObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.d.remove(paramDataSetObserver);
  }
  
  private final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      if (b.a(b.this).isClosed()) {}
      for (;;)
      {
        return;
        b.a(b.this).requery();
        if (!b.b(b.this).isClosed()) {
          b.b(b.this).requery();
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, boolean paramBoolean);
    
    public abstract boolean a(long paramLong);
  }
  
  private final class c
    extends DataSetObserver
  {
    private c() {}
    
    public final void onChanged()
    {
      b.c(b.this)[0] = b.a(b.this).getCount();
      b.c(b.this)[1] = b.b(b.this).getCount();
      Iterator localIterator = b.d(b.this).iterator();
      while (localIterator.hasNext()) {
        ((DataSetObserver)localIterator.next()).onChanged();
      }
    }
  }
  
  static final class d
  {
    CheckBox a;
    ImageView b;
    TextView c;
    ProgressBar d;
    TextView e;
    TextView f;
    Button g;
    FrameLayout h;
    
    public d(View paramView)
    {
      this.a = ((CheckBox)paramView.findViewById(R.id.dm_cb_item));
      this.b = ((ImageView)paramView.findViewById(R.id.dm_app_icon));
      this.c = ((TextView)paramView.findViewById(R.id.dm_app_name));
      this.d = ((ProgressBar)paramView.findViewById(R.id.dm_progress_bar));
      this.e = ((TextView)paramView.findViewById(R.id.dm_down_speed));
      this.f = ((TextView)paramView.findViewById(R.id.dm_down_size));
      this.g = ((Button)paramView.findViewById(R.id.dm_btn_swch));
      this.h = ((FrameLayout)paramView.findViewById(R.id.dm_fl_swch));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */