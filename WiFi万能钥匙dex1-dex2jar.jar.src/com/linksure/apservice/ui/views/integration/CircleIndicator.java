package com.linksure.apservice.ui.views.integration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.styleable;

public class CircleIndicator
  extends LinearLayout
{
  private ViewPager a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = R.drawable.aps_indicator_light;
  private int f = R.drawable.aps_indicator_light;
  private int g = -1;
  private final ViewPager.OnPageChangeListener h = new a(this);
  private DataSetObserver i = new b(this);
  
  public CircleIndicator(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public CircleIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CircleIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    removeAllViews();
    int n = this.a.getAdapter().getCount();
    if (n <= 0) {
      return;
    }
    int m = this.a.getCurrentItem();
    int k = getOrientation();
    int j = 0;
    label37:
    if (j < n)
    {
      if (m != j) {
        break label63;
      }
      a(k, this.e);
    }
    for (;;)
    {
      j++;
      break label37;
      break;
      label63:
      a(k, this.f);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = new View(getContext());
    localView.setBackgroundResource(paramInt2);
    addView(localView, this.c, this.d);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    if (paramInt1 == 0)
    {
      localLayoutParams.leftMargin = this.b;
      localLayoutParams.rightMargin = this.b;
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = this.b;
      localLayoutParams.bottomMargin = this.b;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleIndicator);
      this.c = paramContext.getDimensionPixelSize(0, -1);
      this.d = paramContext.getDimensionPixelSize(1, -1);
      this.b = paramContext.getDimensionPixelSize(2, -1);
      this.e = paramContext.getResourceId(3, R.drawable.aps_indicator_light);
      this.f = paramContext.getResourceId(4, this.e);
      setOrientation(0);
      setGravity(17);
      paramContext.recycle();
    }
    if (this.c < 0)
    {
      j = b();
      this.c = j;
      if (this.d >= 0) {
        break label176;
      }
      j = b();
      label112:
      this.d = j;
      if (this.b >= 0) {
        break label184;
      }
      j = b();
      label129:
      this.b = j;
      if (this.e != 0) {
        break label192;
      }
      j = R.drawable.aps_indicator_light;
      label145:
      this.e = j;
      if (this.f != 0) {
        break label200;
      }
    }
    label176:
    label184:
    label192:
    label200:
    for (int j = this.e;; j = this.f)
    {
      this.f = j;
      return;
      j = this.c;
      break;
      j = this.d;
      break label112;
      j = this.b;
      break label129;
      j = this.e;
      break label145;
    }
  }
  
  private int b()
  {
    return (int)(getResources().getDisplayMetrics().density * 5.0F + 0.5F);
  }
  
  public final void a(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
    if ((this.a != null) && (this.a.getAdapter() != null))
    {
      this.g = -1;
      a();
      this.a.setOnPageChangeListener(this.h);
      this.h.onPageSelected(this.a.getCurrentItem());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/CircleIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */