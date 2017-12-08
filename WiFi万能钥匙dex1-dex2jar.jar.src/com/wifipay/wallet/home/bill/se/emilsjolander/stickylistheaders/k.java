package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class k
  extends i
{
  private a a;
  private List<View> b;
  private int c;
  private Rect d = new Rect();
  private Field e;
  private boolean f = true;
  private boolean g = false;
  
  public k(Context paramContext)
  {
    super(paramContext);
    try
    {
      paramContext = AbsListView.class.getDeclaredField("mSelectorRect");
      paramContext.setAccessible(true);
      this.d = ((Rect)paramContext.get(this));
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.e = AbsListView.class.getDeclaredField("mSelectorPosition");
        this.e.setAccessible(true);
      }
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void b(View paramView)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramView);
  }
  
  private void c()
  {
    if (!this.d.isEmpty())
    {
      int i = d();
      if (i >= 0)
      {
        Object localObject = getChildAt(i - b());
        if ((localObject instanceof j))
        {
          j localj = (j)localObject;
          localObject = this.d;
          i = localj.getTop();
          ((Rect)localObject).top = (localj.e + i);
        }
      }
    }
  }
  
  private int d()
  {
    int i;
    if (this.e == null)
    {
      i = 0;
      if (i >= getChildCount()) {
        break label67;
      }
      if (getChildAt(i).getBottom() == this.d.bottom) {
        i += b();
      }
    }
    for (;;)
    {
      return i;
      i++;
      break;
      try
      {
        i = this.e.getInt(this);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        i = -1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          label67:
          localIllegalAccessException.printStackTrace();
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  boolean a(View paramView)
  {
    if (this.b == null) {}
    for (boolean bool = false;; bool = this.b.contains(paramView)) {
      return bool;
    }
  }
  
  public void addFooterView(View paramView)
  {
    super.addFooterView(paramView);
    b(paramView);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addFooterView(paramView, paramObject, paramBoolean);
    b(paramView);
  }
  
  int b()
  {
    int i = getFirstVisiblePosition();
    if (Build.VERSION.SDK_INT >= 11) {
      return i;
    }
    int j = 0;
    label17:
    if (j < getChildCount()) {
      if (getChildAt(j).getBottom() >= 0) {
        j += i;
      }
    }
    for (;;)
    {
      i = j;
      if (!this.f)
      {
        i = j;
        if (getPaddingTop() > 0)
        {
          i = j;
          if (j > 0)
          {
            i = j;
            if (getChildAt(0).getTop() > 0) {
              i = j - 1;
            }
          }
        }
      }
      break;
      j++;
      break label17;
      j = i;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    c();
    if (this.c != 0)
    {
      paramCanvas.save();
      Rect localRect = paramCanvas.getClipBounds();
      localRect.top = this.c;
      paramCanvas.clipRect(localRect);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
    }
    for (;;)
    {
      this.a.a(paramCanvas);
      return;
      super.dispatchDraw(paramCanvas);
    }
  }
  
  protected void layoutChildren()
  {
    if (!this.g) {
      super.layoutChildren();
    }
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    View localView = paramView;
    if ((paramView instanceof j)) {
      localView = ((j)paramView).a;
    }
    return super.performItemClick(localView, paramInt, paramLong);
  }
  
  public boolean removeFooterView(View paramView)
  {
    if (super.removeFooterView(paramView)) {
      this.b.remove(paramView);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    this.f = paramBoolean;
    super.setClipToPadding(paramBoolean);
  }
  
  static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */