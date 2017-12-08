package com.lantern.settings.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView
  extends ListView
{
  public AbsListView.OnScrollListener a = new a(this);
  private int b;
  private int c;
  private boolean d;
  private a e;
  private View f;
  
  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(this.a);
  }
  
  public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnScrollListener(this.a);
  }
  
  public final void a()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      switch (this.e.a())
      {
      default: 
        break;
      case 0: 
        this.d = false;
        break;
      case 1: 
        if (this.f.getTop() != 0) {
          this.f.layout(0, 0, this.b, this.c);
        }
        this.d = true;
      }
    }
    View localView = getChildAt(0);
    int i = localView.getBottom();
    Log.d("PinnedHeaderListView", String.valueOf(localView.getHeight()));
    int j = this.f.getHeight();
    if (i < j) {
      i -= j;
    }
    for (;;)
    {
      if (this.f.getTop() != i) {
        this.f.layout(0, i, this.b, this.c + i);
      }
      this.d = true;
      break;
      i = 0;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.d) {
      drawChild(paramCanvas, this.f, getDrawingTime());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f != null)
    {
      this.f.layout(0, 0, this.b, this.c);
      getFirstVisiblePosition();
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.f != null)
    {
      measureChild(this.f, paramInt1, paramInt2);
      this.b = this.f.getMeasuredWidth();
      this.c = this.f.getMeasuredHeight();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.e = ((a)paramListAdapter);
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/PinnedHeaderListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */