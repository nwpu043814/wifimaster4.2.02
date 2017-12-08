package com.lantern.dm.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.bluefay.b.h;

public class WkListView
  extends ExpandableListView
  implements AbsListView.OnScrollListener, ExpandableListView.OnGroupClickListener
{
  private a a;
  private View b;
  private boolean c;
  private int d;
  private int e;
  private float f;
  private float g;
  private int h = -1;
  
  public WkListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WkListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOnScrollListener(this);
    setOnGroupClickListener(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.b == null) || (this.a == null) || (((ExpandableListAdapter)this.a).getGroupCount() == 0)) {}
    for (;;)
    {
      return;
      switch (this.a.a(paramInt1, paramInt2))
      {
      default: 
        break;
      case 0: 
        this.c = false;
        break;
      case 1: 
        this.a.a(this.b, paramInt1);
        if (this.b.getTop() != 0) {
          this.b.layout(0, 0, this.d, this.e);
        }
        this.c = true;
      }
    }
    int i = getChildAt(0).getBottom();
    paramInt2 = this.b.getHeight();
    if (i < paramInt2) {}
    for (paramInt2 = i - paramInt2;; paramInt2 = 0)
    {
      this.a.a(this.b, paramInt1);
      if (this.b.getTop() != paramInt2) {
        this.b.layout(0, paramInt2, this.d, this.e + paramInt2);
      }
      this.c = true;
      break;
    }
  }
  
  public final void a(View paramView)
  {
    this.b = paramView;
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.b != null) {
      setFadingEdgeLength(0);
    }
    requestLayout();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.c) {
      drawChild(paramCanvas, this.b, getDrawingTime());
    }
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    h.a("group click state:%s", new Object[] { Integer.valueOf(this.a.a(paramInt)) });
    if (this.a.a(paramInt) == 0)
    {
      this.a.b(paramInt, 1);
      paramExpandableListView.collapseGroup(paramInt);
    }
    for (;;)
    {
      paramExpandableListView.setSelectedGroup(paramInt);
      return true;
      if (this.a.a(paramInt) == 1)
      {
        this.a.b(paramInt, 0);
        paramExpandableListView.expandGroup(paramInt);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    long l = getExpandableListPosition(getFirstVisiblePosition());
    paramInt3 = ExpandableListView.getPackedPositionGroup(l);
    paramInt1 = ExpandableListView.getPackedPositionChild(l);
    paramInt2 = this.a.a(paramInt3, paramInt1);
    if ((this.b != null) && (this.a != null) && (paramInt2 != this.h))
    {
      this.h = paramInt2;
      this.b.layout(0, 0, this.d, this.e);
    }
    a(paramInt3, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b != null)
    {
      measureChild(this.b, paramInt1, paramInt2);
      this.d = this.b.getMeasuredWidth();
      this.e = this.b.getMeasuredHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = getExpandableListPosition(paramInt1);
    a(ExpandableListView.getPackedPositionGroup(l), ExpandableListView.getPackedPositionChild(l));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.c) {}
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      for (;;)
      {
        return bool1;
        performClick();
        this.f = paramMotionEvent.getX();
        this.g = paramMotionEvent.getY();
        if ((this.f > this.d) || (this.g > this.e)) {
          break;
        }
        bool1 = bool2;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f4 = Math.abs(f1 - this.f);
      float f3 = Math.abs(f2 - this.g);
      if ((f1 > this.d) || (f2 > this.e) || (f4 > this.d) || (f3 > this.e)) {
        break;
      }
      bool1 = bool2;
    } while (this.b == null);
    int i = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(getFirstVisiblePosition()));
    h.a("pinned click state:%s", new Object[] { Integer.valueOf(this.a.a(i)) });
    if (this.a.a(i) == 1)
    {
      this.a.b(i, 0);
      expandGroup(i);
    }
    for (;;)
    {
      setSelectedGroup(i);
      bool1 = bool2;
      break;
      this.a.b(i, 1);
      collapseGroup(i);
    }
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    this.a = ((a)paramExpandableListAdapter);
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt);
    
    public abstract int a(int paramInt1, int paramInt2);
    
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/utils/WkListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */