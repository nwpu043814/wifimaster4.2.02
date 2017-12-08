package com.linksure.apservice.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int d = -1;
  private int e = 0;
  
  g(f paramf, View paramView1, View paramView2) {}
  
  public final void onGlobalLayout()
  {
    int j = 0;
    Object localObject = new Rect();
    this.a.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.getRootView().getHeight();
    int k = ((Rect)localObject).bottom - ((Rect)localObject).top;
    if (this.e == 0) {
      this.e = k;
    }
    if ((this.b != null) && (this.b.getPaddingTop() != 0)) {
      this.b.setPadding(this.b.getPaddingLeft(), 0, this.b.getPaddingRight(), this.b.getPaddingBottom());
    }
    k = this.e - k;
    if (this.d != k) {
      if (this.c.a != null)
      {
        if (k / i <= 0.2D) {
          break label170;
        }
        i = 1;
        localObject = this.c.a;
        if (i == 0) {
          break label175;
        }
      }
    }
    label170:
    label175:
    for (i = j;; i = 1)
    {
      ((f.a)localObject).b(i, k);
      this.d = k;
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */