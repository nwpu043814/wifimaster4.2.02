package com.lantern.dm.ui;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.dm.R.drawable;
import com.lantern.dm.a.c;
import com.lantern.dm.model.TaskItem;
import java.io.File;

public final class a
  extends CursorAdapter
{
  private Cursor a;
  private Context b;
  private boolean c;
  private b.b d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  
  public a(Context paramContext, Cursor paramCursor, b.b paramb)
  {
    super(paramContext, paramCursor);
    this.a = paramCursor;
    this.b = paramContext;
    this.d = paramb;
    this.e = this.a.getColumnIndexOrThrow("icon");
    this.f = this.a.getColumnIndexOrThrow("_id");
    this.g = this.a.getColumnIndexOrThrow("title");
    this.h = this.a.getColumnIndexOrThrow("total_bytes");
  }
  
  public final b.b a()
  {
    return this.d;
  }
  
  public final void a(View paramView)
  {
    b.d locald = (b.d)paramView.getTag();
    if (locald == null) {}
    for (;;)
    {
      return;
      label31:
      long l;
      String str;
      if (this.c)
      {
        locald.a.setVisibility(0);
        l = this.a.getLong(this.f);
        locald.a.setChecked(this.d.a(l));
        ((TaskItem)paramView).a(l);
        l = this.a.getLong(this.h);
        str = this.a.getString(this.g);
        paramView = this.a.getString(this.e);
        if ((paramView == null) || (paramView.length() <= 0)) {
          break label195;
        }
        c.a().a(paramView, locald.b);
      }
      for (;;)
      {
        locald.c.setText(str);
        locald.f.setText("");
        if (l <= 0L) {
          break label209;
        }
        locald.e.setText(Formatter.formatFileSize(this.b, l));
        break;
        locald.a.setVisibility(8);
        break label31;
        label195:
        locald.b.setImageResource(R.drawable.dm_file_default_icon);
      }
      label209:
      paramView = new File(Uri.parse(Uri.fromFile(new File(this.a.getString(this.a.getColumnIndex("_data")))).toString()).getPath());
      locald.e.setText(Formatter.formatFileSize(this.b, paramView.length()));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    a(paramView);
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */