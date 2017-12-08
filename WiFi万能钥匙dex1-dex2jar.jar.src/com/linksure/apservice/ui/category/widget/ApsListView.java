package com.linksure.apservice.ui.category.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class ApsListView
  extends ListView
{
  private boolean a;
  private boolean b = true;
  private View c;
  private ScaleAnimation d;
  private a e;
  private AbsListView.OnScrollListener f = new a(this);
  
  public ApsListView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ApsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ApsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.d = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 1.0F);
    this.d.setDuration(70L);
    this.d.setInterpolator(new LinearInterpolator());
    setOnScrollListener(this.f);
  }
  
  public final void a()
  {
    this.a = true;
    this.c.setVisibility(0);
    this.c.startAnimation(this.d);
  }
  
  public final void a(View paramView)
  {
    this.c = paramView;
  }
  
  public final void a(a parama)
  {
    this.e = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void b()
  {
    this.a = false;
    this.c.clearAnimation();
    this.c.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void d();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/widget/ApsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */