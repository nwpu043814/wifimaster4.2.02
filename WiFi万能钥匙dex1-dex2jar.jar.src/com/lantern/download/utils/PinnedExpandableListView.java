package com.lantern.download.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.bluefay.b.h;

public class PinnedExpandableListView
  extends ExpandableListView
{
  private View a;
  private int b;
  private int c;
  private boolean d;
  private float e;
  private float f;
  private int g = -1;
  private a h;
  private ExpandableListView.OnGroupClickListener i = new a(this);
  private AbsListView.OnScrollListener j = new b(this);
  
  public PinnedExpandableListView(Context paramContext)
  {
    super(paramContext);
    setOnScrollListener(this.j);
    setOnGroupClickListener(this.i);
  }
  
  public PinnedExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(this.j);
    setOnGroupClickListener(this.i);
  }
  
  public PinnedExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnScrollListener(this.j);
    setOnGroupClickListener(this.i);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (this.h == null) || (((ExpandableListAdapter)this.h).getGroupCount() == 0)) {}
    View localView;
    do
    {
      for (;;)
      {
        return;
        paramInt2 = this.h.a(paramInt1, paramInt2, this);
        h.a("state:%s", new Object[] { Integer.valueOf(paramInt2) });
        switch (paramInt2)
        {
        default: 
          break;
        case 0: 
          this.d = false;
          break;
        case 1: 
          this.h.a(this.a, paramInt1);
          if (this.a.getTop() != 0) {
            this.a.layout(0, 0, this.b, this.c);
          }
          this.d = true;
        }
      }
      localView = getChildAt(0);
    } while (localView == null);
    paramInt2 = localView.getBottom();
    int k = this.a.getHeight();
    if (paramInt2 < k) {
      paramInt2 -= k;
    }
    for (;;)
    {
      this.h.a(this.a, paramInt1);
      if (this.a.getTop() != paramInt2)
      {
        h.a("y:%s", new Object[] { Integer.valueOf(paramInt2) });
        this.a.layout(0, paramInt2, this.b, this.c + paramInt2);
      }
      this.d = true;
      break;
      paramInt2 = 0;
    }
  }
  
  public final void a(View paramView)
  {
    this.a = paramView;
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.a != null) {
      setFadingEdgeLength(0);
    }
    requestLayout();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.d) && (this.a != null))
    {
      h.a("dispatchDraw:%s", new Object[] { "dispatchDraw" });
      drawChild(paramCanvas, this.a, getDrawingTime());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    long l = getExpandableListPosition(getFirstVisiblePosition());
    paramInt2 = ExpandableListView.getPackedPositionGroup(l);
    paramInt1 = ExpandableListView.getPackedPositionChild(l);
    h.a("flatPostion:%s", new Object[] { Long.valueOf(l) });
    h.a("groupPos:%s", new Object[] { Integer.valueOf(paramInt2) });
    h.a("childPos:%s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.a != null) && (this.h != null) && (this.h.a(paramInt2, paramInt1, this) != this.g))
    {
      this.g = this.h.a(paramInt2, paramInt1, this);
      this.a.layout(0, 0, this.b, this.c);
    }
    a(paramInt2, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null)
    {
      measureChild(this.a, paramInt1, paramInt2);
      this.b = this.a.getMeasuredWidth();
      this.c = this.a.getMeasuredHeight();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.d) {}
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
        this.e = paramMotionEvent.getX();
        this.f = paramMotionEvent.getY();
        if ((this.e > this.b) || (this.f > this.c)) {
          break;
        }
        bool1 = bool2;
      }
      float f3 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f4 = Math.abs(f3 - this.e);
      float f1 = Math.abs(f2 - this.f);
      if ((f3 > this.b) || (f2 > this.c) || (f4 > this.b) || (f1 > this.c)) {
        break;
      }
      bool1 = bool2;
    } while (this.a == null);
    int k = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(getFirstVisiblePosition()));
    h.a("pinned click state:%s", new Object[] { Integer.valueOf(this.h.b(k)) });
    if (this.h.b(k) == 1)
    {
      this.h.b(k, 0);
      expandGroup(k);
    }
    for (;;)
    {
      setSelectedGroup(k);
      bool1 = bool2;
      break;
      this.h.b(k, 1);
      collapseGroup(k);
    }
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    super.setAdapter(paramExpandableListAdapter);
    this.h = ((a)paramExpandableListAdapter);
    int m = paramExpandableListAdapter.getGroupCount();
    h.a("count:%s", new Object[] { Integer.valueOf(m) });
    for (int k = 0; k < m; k++) {
      expandGroup(k);
    }
  }
  
  public static abstract interface a
  {
    public abstract int a(int paramInt1, int paramInt2, ExpandableListView paramExpandableListView);
    
    public abstract void a(View paramView, int paramInt);
    
    public abstract int b(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/download/utils/PinnedExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */