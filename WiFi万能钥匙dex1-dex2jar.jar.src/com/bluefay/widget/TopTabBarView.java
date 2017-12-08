package com.bluefay.widget;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class TopTabBarView
  extends LinearLayout
  implements View.OnClickListener
{
  private FragmentManager a;
  private h b;
  private HashMap<String, g> c = new HashMap();
  private ArrayList<g> d = new ArrayList();
  private g e;
  private Drawable f;
  private int g;
  private int h;
  private float i;
  
  public TopTabBarView(Context paramContext)
  {
    super(paramContext);
    if (this.f != null)
    {
      this.g = this.f.getIntrinsicWidth();
      this.h = this.f.getIntrinsicHeight();
    }
  }
  
  public TopTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.f != null)
    {
      this.g = this.f.getIntrinsicWidth();
      this.h = this.f.getIntrinsicHeight();
    }
  }
  
  public void onClick(View paramView)
  {
    g localg = (g)paramView.getTag();
    paramView = null;
    if (this.a != null) {
      paramView = this.a.beginTransaction().disallowAddToBackStack();
    }
    if (this.e == localg) {
      if (this.b != null) {
        this.b.a(this.e);
      }
    }
    for (;;)
    {
      if ((paramView != null) && (!paramView.isEmpty())) {
        paramView.commitAllowingStateLoss();
      }
      return;
      if (this.e != null)
      {
        findViewWithTag(this.e).setSelected(false);
        if (this.b != null) {
          this.b.b(this.e, paramView);
        }
      }
      this.e = localg;
      if (this.e != null)
      {
        findViewWithTag(this.e).setSelected(true);
        if (this.b != null) {
          this.b.a(this.e, paramView);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject;
    int j;
    if ((this.e != null) && (this.f != null))
    {
      localObject = this.e;
      j = 0;
      if (j >= this.d.size()) {
        break label155;
      }
      if (this.d.get(j) != localObject) {
        break label149;
      }
    }
    for (;;)
    {
      localObject = getChildAt(j);
      int k = getWidth();
      j = getHeight();
      k = (int)(k / this.d.size() * this.i);
      int m = (((View)localObject).getWidth() - this.g) / 2;
      m = ((View)localObject).getLeft() + m + k;
      k = this.h;
      int n = this.g;
      this.f.setBounds(m, j - k, n + m, j);
      this.f.draw(paramCanvas);
      return;
      label149:
      j++;
      break;
      label155:
      j = -1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/TopTabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */