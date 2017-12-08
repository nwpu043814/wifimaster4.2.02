package com.lantern.dm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lantern.core.d.a;
import com.lantern.dm.R.color;
import com.lantern.dm.R.drawable;
import com.lantern.dm.R.string;
import com.lantern.dm.a.c;
import com.lantern.dm.model.TaskItem;

public final class i
  extends CursorAdapter
{
  private Cursor a;
  private Context b;
  private a c;
  private b.b d;
  private boolean e;
  private long f = 0L;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  
  private i(Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.a = paramCursor;
    this.b = paramContext;
    this.g = this.a.getColumnIndexOrThrow("_id");
    this.j = this.a.getColumnIndexOrThrow("icon");
    this.k = this.a.getColumnIndexOrThrow("title");
    this.l = this.a.getColumnIndexOrThrow("status");
    this.h = this.a.getColumnIndexOrThrow("total_bytes");
    this.i = this.a.getColumnIndexOrThrow("current_bytes");
    this.m = this.a.getColumnIndexOrThrow("allowed_network_types");
  }
  
  public i(Context paramContext, Cursor paramCursor, a parama, b.b paramb)
  {
    this(paramContext, paramCursor);
    this.c = parama;
    this.d = paramb;
  }
  
  public final b.b a()
  {
    return this.d;
  }
  
  public final void a(View paramView)
  {
    b.d locald = (b.d)paramView.getTag();
    if (locald == null) {
      return;
    }
    label41:
    long l3;
    int i1;
    long l1;
    long l2;
    int i2;
    label198:
    label210:
    int n;
    if (this.e)
    {
      locald.a.setVisibility(0);
      locald.g.setVisibility(8);
      l3 = this.a.getLong(this.g);
      locald.a.setChecked(this.d.a(l3));
      ((TaskItem)paramView).a(l3);
      i1 = this.a.getInt(this.l);
      l1 = this.a.getLong(this.h);
      l2 = this.a.getLong(this.i);
      paramView = this.a.getString(this.k);
      String str = this.a.getString(this.j);
      i2 = this.a.getInt(this.m);
      if ((str == null) || (str.length() <= 0)) {
        break label393;
      }
      c.a().a(str, locald.b);
      if (l1 != -1L) {
        break label407;
      }
      l1 = 0L;
      if (l1 > 0L) {
        break label410;
      }
      n = 0;
      label219:
      locald.c.setText(paramView);
      locald.d.setProgress(n);
      locald.e.setText(n + "%");
      if (i1 != 190) {
        break label424;
      }
      locald.f.setText(this.b.getString(R.string.download_waited_file));
      label289:
      paramView = locald.g;
      if ((i1 != 192) && (i1 != 190)) {
        break label583;
      }
      paramView.setText(this.b.getString(R.string.download_pause_file));
      paramView.setTextColor(this.b.getResources().getColor(R.color.framework_list_fragment_tips_text_color));
      paramView.setBackgroundResource(R.drawable.dm_button_pause_bg);
    }
    for (;;)
    {
      locald.g.setOnClickListener(new j(this, i1, l3, locald));
      break;
      locald.a.setVisibility(8);
      locald.g.setVisibility(0);
      break label41;
      label393:
      locald.b.setImageResource(R.drawable.dm_file_default_icon);
      break label198;
      label407:
      break label210;
      label410:
      n = (int)(100L * l2 / l1);
      break label219;
      label424:
      if (i1 == 192)
      {
        locald.f.setText(Formatter.formatFileSize(this.b, l1));
        break label289;
      }
      if (i1 == 193)
      {
        locald.f.setText(this.b.getString(R.string.download_paused_file));
        break label289;
      }
      if (i1 == 195)
      {
        if (i2 == -1)
        {
          locald.f.setText(this.b.getString(R.string.download_paused_file));
          break label289;
        }
        locald.f.setText(this.b.getString(R.string.download_waiting));
        break label289;
      }
      if (i1 == 498)
      {
        locald.f.setText(this.b.getString(R.string.download_failed_storage));
        break label289;
      }
      locald.f.setText(this.b.getString(R.string.download_failed));
      break label289;
      label583:
      paramView.setText(this.b.getString(R.string.download_continu_file));
      paramView.setTextColor(this.b.getResources().getColor(R.color.framework_primary_color));
      paramView.setBackgroundResource(R.drawable.dm_button_resume_bg);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    a(paramView);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */