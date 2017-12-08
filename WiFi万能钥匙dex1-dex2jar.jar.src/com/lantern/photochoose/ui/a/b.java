package com.lantern.photochoose.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.lantern.photochoose.b.f;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private List<com.lantern.photochoose.a.a> a;
  private List<String> b;
  private Context c;
  private int d;
  private boolean e = false;
  private int f = 0;
  private int g = 9;
  private View.OnClickListener h;
  private a i;
  
  public b(Context paramContext, List<com.lantern.photochoose.a.a> paramList)
  {
    this.a = paramList;
    this.c = paramContext;
    this.d = ((f.a(this.c) - f.a(this.c, 4.0F)) / 3);
  }
  
  public final com.lantern.photochoose.a.a a(int paramInt)
  {
    com.lantern.photochoose.a.a locala;
    if (this.e) {
      if (paramInt == 0) {
        locala = null;
      }
    }
    for (;;)
    {
      return locala;
      locala = (com.lantern.photochoose.a.a)this.a.get(paramInt - 1);
      continue;
      locala = (com.lantern.photochoose.a.a)this.a.get(paramInt);
    }
  }
  
  public final void a(a parama)
  {
    this.i = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final List<String> b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void c()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public final void c(int paramInt)
  {
    this.f = paramInt;
    if (this.f == 1)
    {
      this.b = new ArrayList();
      this.h = new c(this);
    }
  }
  
  public final int getCount()
  {
    if (this.e) {}
    for (int j = this.a.size() + 1;; j = this.a.size()) {
      return j;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.e)) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramView = LayoutInflater.from(this.c).inflate(R.layout.settings_photo_item_camera_layout, null);
      paramView.setTag(null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.d, this.d));
      return paramView;
    }
    label140:
    com.lantern.photochoose.a.a locala;
    if (paramView == null)
    {
      paramViewGroup = new b((byte)0);
      paramView = LayoutInflater.from(this.c).inflate(R.layout.settings_photo_item_photo_layout, null);
      b.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.imageview_photo));
      b.b(paramViewGroup, (ImageView)paramView.findViewById(R.id.checkmark));
      b.a(paramViewGroup, paramView.findViewById(R.id.mask));
      b.a(paramViewGroup, (FrameLayout)paramView.findViewById(R.id.wrap_layout));
      paramView.setTag(paramViewGroup);
      b.a(paramViewGroup).setImageResource(R.drawable.settings_photo_ic_photo_loading);
      locala = a(paramInt);
      if (this.f != 1) {
        break label289;
      }
      b.b(paramViewGroup).setOnClickListener(this.h);
      b.a(paramViewGroup).setTag(locala.a());
      b.c(paramViewGroup).setVisibility(0);
      if ((this.b == null) || (!this.b.contains(locala.a()))) {
        break label269;
      }
      b.c(paramViewGroup).setSelected(true);
      b.d(paramViewGroup).setVisibility(0);
    }
    for (;;)
    {
      com.lantern.photochoose.b.a.a().a(locala.a(), b.a(paramViewGroup), this.d);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label140;
      label269:
      b.c(paramViewGroup).setSelected(false);
      b.d(paramViewGroup).setVisibility(8);
      continue;
      label289:
      b.c(paramViewGroup).setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public static abstract interface a
  {
    public abstract void d();
  }
  
  private final class b
  {
    private ImageView b;
    private ImageView c;
    private View d;
    private FrameLayout e;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/ui/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */