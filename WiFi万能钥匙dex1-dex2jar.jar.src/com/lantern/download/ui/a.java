package com.lantern.download.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.format.Formatter;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.id;
import com.lantern.dm.R.layout;
import com.lantern.dm.R.string;
import com.lantern.dm.a.c;
import com.lantern.download.utils.PinnedExpandableListView.a;
import java.io.File;
import java.util.HashMap;

public final class a
  extends BaseExpandableListAdapter
  implements PinnedExpandableListView.a
{
  private Cursor a;
  private Cursor b;
  private Context c;
  private com.lantern.core.d.a d;
  private int e = 8;
  private HashMap<Long, Boolean> f;
  private long g = 0L;
  private SparseIntArray h = new SparseIntArray();
  
  public a(Context paramContext, com.lantern.core.d.a parama)
  {
    this.c = paramContext;
    this.d = parama;
    this.f = new HashMap();
    this.a = this.c.getContentResolver().query(com.lantern.core.model.a.a, null, "status!='200' AND is_visible_in_downloads_ui!='0'", null, null);
    this.b = this.c.getContentResolver().query(com.lantern.core.model.a.a, null, "status='200' AND is_visible_in_downloads_ui!='0'", null, null);
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView = (TextView)paramView.findViewById(R.id.dm_download_group);
    if (paramInt == 0) {
      paramView.setText(this.c.getString(R.string.download_running_file) + "(" + this.a.getCount() + ")");
    }
    for (;;)
    {
      return;
      paramView.setText(this.c.getString(R.string.download_complete_notification) + "(" + this.b.getCount() + ")");
    }
  }
  
  public final int a(int paramInt1, int paramInt2, ExpandableListView paramExpandableListView)
  {
    int i = 0;
    int j = getChildrenCount(paramInt1);
    boolean bool = paramExpandableListView.isGroupExpanded(paramInt1);
    h.a("childCount:%s", new Object[] { Integer.valueOf(j) });
    h.a("childPosition:%s", new Object[] { Integer.valueOf(paramInt2) });
    h.a("expanded:%s", new Object[] { Boolean.valueOf(bool) });
    if (paramInt2 == j - 1) {
      paramInt1 = 2;
    }
    for (;;)
    {
      return paramInt1;
      if (paramInt2 == -1)
      {
        paramInt1 = i;
        if (!bool) {}
      }
      else
      {
        paramInt1 = 1;
      }
    }
  }
  
  public final Long a(int paramInt1, int paramInt2)
  {
    Long localLong;
    if ((paramInt1 == 0) && (this.a.getCount() > 0))
    {
      this.a.moveToPosition(paramInt2);
      localLong = Long.valueOf(this.a.getLong(this.a.getColumnIndex("_id")));
    }
    for (;;)
    {
      return localLong;
      if ((paramInt1 == 1) && (this.b.getCount() > 0))
      {
        this.b.moveToPosition(paramInt2);
        localLong = Long.valueOf(this.b.getLong(this.b.getColumnIndex("_id")));
      }
      else
      {
        localLong = Long.valueOf(0L);
      }
    }
  }
  
  public final void a()
  {
    this.a.requery();
    this.b.requery();
    notifyDataSetChanged();
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void a(View paramView, int paramInt)
  {
    a(paramInt, paramView);
  }
  
  public final int b(int paramInt)
  {
    if (this.h.keyAt(paramInt) >= 0) {}
    for (paramInt = this.h.get(paramInt);; paramInt = 0) {
      return paramInt;
    }
  }
  
  public final HashMap<Long, Boolean> b()
  {
    return this.f;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.h.put(paramInt1, paramInt2);
  }
  
  public final Cursor c()
  {
    return this.b;
  }
  
  public final long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public final View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    long l3;
    long l1;
    long l2;
    Object localObject1;
    int j;
    label341:
    int i;
    label351:
    label463:
    label489:
    label515:
    label579:
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(R.layout.dm_download_adapter, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((CheckBox)paramView.findViewById(R.id.dm_cb_item));
      paramViewGroup.b = ((ImageView)paramView.findViewById(R.id.dm_app_icon));
      paramViewGroup.c = ((Button)paramView.findViewById(R.id.dm_btn_swch));
      paramViewGroup.d = ((ProgressBar)paramView.findViewById(R.id.dm_progress_bar));
      paramViewGroup.e = ((TextView)paramView.findViewById(R.id.dm_app_name));
      paramViewGroup.f = ((TextView)paramView.findViewById(R.id.dm_down_progress));
      paramViewGroup.g = ((TextView)paramView.findViewById(R.id.dm_down_size));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setVisibility(this.e);
      if ((paramInt1 == 0) && (this.a.getCount() > 0))
      {
        this.a.moveToPosition(paramInt2);
        l3 = this.a.getLong(this.a.getColumnIndex("_id"));
        l1 = this.a.getLong(this.a.getColumnIndex("total_bytes"));
        l2 = this.a.getLong(this.a.getColumnIndex("current_bytes"));
        localObject1 = this.a.getString(this.a.getColumnIndex("icon"));
        j = this.a.getInt(this.a.getColumnIndex("status"));
        h.a("downloads status:" + j, new Object[0]);
        if (l1 != -1L) {
          break label855;
        }
        l1 = 0L;
        if (l1 > 0L) {
          break label858;
        }
        i = 0;
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setProgress(i);
        paramViewGroup.e.setText(this.a.getString(this.a.getColumnIndex("title")));
        paramViewGroup.f.setText(i + "%");
        paramViewGroup.c.setVisibility(0);
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label873;
        }
        c.a().a((String)localObject1, paramViewGroup.b);
        if (this.e != 8) {
          break label887;
        }
        this.f.put(Long.valueOf(l3), Boolean.valueOf(false));
        if (j != 190) {
          break label937;
        }
        paramViewGroup.g.setText(this.c.getString(R.string.download_waited_file));
        localObject1 = paramViewGroup.c;
        if ((j != 192) && (j != 190)) {
          break label1073;
        }
        ((Button)localObject1).setText(this.c.getString(R.string.download_pause_file));
        ((Button)localObject1).setTextColor(this.c.getResources().getColor(R.color.framework_list_fragment_tips_text_color));
        ((Button)localObject1).setBackgroundResource(R.drawable.dm_button_pause_bg);
        paramViewGroup.c.setOnClickListener(new b(this, j, l3, paramViewGroup));
      }
      if ((paramInt1 == 1) && (this.b.getCount() > 0))
      {
        this.b.moveToPosition(paramInt2);
        l1 = this.b.getLong(this.b.getColumnIndex("_id"));
        l2 = this.b.getLong(this.b.getColumnIndex("total_bytes"));
        localObject1 = this.b.getString(this.b.getColumnIndex("icon"));
        paramViewGroup.d.setVisibility(8);
        localObject2 = this.b.getString(this.b.getColumnIndex("title"));
        paramViewGroup.e.setText((CharSequence)localObject2);
        if (l2 == -1L) {
          break label1117;
        }
        paramViewGroup.f.setText(Formatter.formatFileSize(this.c, l2));
        label766:
        paramViewGroup.g.setText("");
        paramViewGroup.c.setVisibility(8);
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label1189;
        }
        c.a().a((String)localObject1, paramViewGroup.b);
        label813:
        if (this.e != 8) {
          break label1203;
        }
        this.f.put(Long.valueOf(l1), Boolean.valueOf(false));
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label855:
      break label341;
      label858:
      i = (int)(100L * l2 / l1);
      break label351;
      label873:
      paramViewGroup.b.setImageResource(R.drawable.dm_file_default_icon);
      break label463;
      label887:
      localObject1 = (Boolean)this.f.get(Long.valueOf(l3));
      if (localObject1 == null)
      {
        paramViewGroup.a.setChecked(false);
        break label489;
      }
      paramViewGroup.a.setChecked(((Boolean)localObject1).booleanValue());
      break label489;
      label937:
      if (j == 192)
      {
        paramViewGroup.g.setText(Formatter.formatFileSize(this.c, l1));
        break label515;
      }
      if (j == 193)
      {
        paramViewGroup.g.setText(this.c.getString(R.string.download_paused_file));
        break label515;
      }
      if (j == 195)
      {
        paramViewGroup.g.setText(this.c.getString(R.string.download_paused_file));
        break label515;
      }
      if (j == 498)
      {
        paramViewGroup.g.setText(this.c.getString(R.string.download_failed_storage));
        break label515;
      }
      paramViewGroup.g.setText(this.c.getString(R.string.download_failed));
      break label515;
      label1073:
      ((Button)localObject1).setText(this.c.getString(R.string.download_continu_file));
      ((Button)localObject1).setTextColor(this.c.getResources().getColor(R.color.framework_primary_color));
      ((Button)localObject1).setBackgroundResource(R.drawable.dm_button_resume_bg);
      break label579;
      label1117:
      localObject2 = new File(Uri.parse(Uri.fromFile(new File(this.b.getString(this.b.getColumnIndex("_data")))).toString()).getPath());
      paramViewGroup.f.setText(Formatter.formatFileSize(this.c, ((File)localObject2).length()));
      break label766;
      label1189:
      paramViewGroup.b.setImageResource(R.drawable.dm_file_default_icon);
      break label813;
      label1203:
      localObject1 = (Boolean)this.f.get(Long.valueOf(l1));
      if (localObject1 == null) {
        paramViewGroup.a.setChecked(false);
      } else {
        paramViewGroup.a.setChecked(((Boolean)localObject1).booleanValue());
      }
    }
  }
  
  public final int getChildrenCount(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = this.a.getCount();; paramInt = this.b.getCount()) {
      return paramInt;
    }
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
      localView = LayoutInflater.from(this.c).inflate(R.layout.dm_download_group, paramViewGroup, false);
    }
    a(paramInt, localView);
    return localView;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  public final boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  static final class a
  {
    CheckBox a;
    ImageView b;
    Button c;
    ProgressBar d;
    TextView e;
    TextView f;
    TextView g;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */