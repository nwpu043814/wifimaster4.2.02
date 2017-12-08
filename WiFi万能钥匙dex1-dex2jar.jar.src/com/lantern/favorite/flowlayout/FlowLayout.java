package com.lantern.favorite.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.lantern.favorite.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout
  extends ViewGroup
{
  protected List<List<View>> a = new ArrayList();
  protected List<Integer> b = new ArrayList();
  protected List<Integer> c = new ArrayList();
  private int d;
  private List<View> e = new ArrayList();
  
  public FlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TagFlowLayout);
    this.d = paramContext.getInt(2, -1);
    paramContext.recycle();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.e.clear();
    int j = getWidth();
    paramInt1 = 0;
    paramInt2 = 0;
    int k = getChildCount();
    paramInt3 = 0;
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    while (paramInt3 < k)
    {
      localView = getChildAt(paramInt3);
      i = paramInt2;
      paramInt4 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        paramInt4 = paramInt2;
        i = paramInt1;
        if (n + paramInt1 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin > j - getPaddingLeft() - getPaddingRight())
        {
          this.b.add(Integer.valueOf(paramInt2));
          this.a.add(this.e);
          this.c.add(Integer.valueOf(paramInt1));
          i = 0;
          paramInt4 = localMarginLayoutParams.topMargin + m + localMarginLayoutParams.bottomMargin;
          this.e = new ArrayList();
        }
        paramInt1 = i + (n + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
        paramInt2 = localMarginLayoutParams.topMargin;
        i = Math.max(paramInt4, localMarginLayoutParams.bottomMargin + (paramInt2 + m));
        this.e.add(localView);
        paramInt4 = paramInt1;
      }
      paramInt3++;
      paramInt2 = i;
      paramInt1 = paramInt4;
    }
    this.b.add(Integer.valueOf(paramInt2));
    this.c.add(Integer.valueOf(paramInt1));
    this.a.add(this.e);
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int i = this.a.size();
    paramInt3 = 0;
    if (paramInt3 < i)
    {
      this.e = ((List)this.a.get(paramInt3));
      k = ((Integer)this.b.get(paramInt3)).intValue();
      paramInt4 = ((Integer)this.c.get(paramInt3)).intValue();
      switch (this.d)
      {
      default: 
        label448:
        paramInt4 = 0;
        label451:
        if (paramInt4 < this.e.size())
        {
          localView = (View)this.e.get(paramInt4);
          if (localView.getVisibility() == 8) {
            break label620;
          }
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          n = localMarginLayoutParams.leftMargin + paramInt1;
          m = localMarginLayoutParams.topMargin + paramInt2;
          localView.layout(n, m, localView.getMeasuredWidth() + n, localView.getMeasuredHeight() + m);
          paramInt1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt1;
        }
        break;
      }
    }
    label620:
    for (;;)
    {
      paramInt4++;
      break label451;
      paramInt1 = getPaddingLeft();
      break label448;
      paramInt1 = (j - paramInt4) / 2 + getPaddingLeft();
      break label448;
      paramInt1 = j - paramInt4 + getPaddingLeft();
      break label448;
      paramInt3++;
      paramInt2 += k;
      break;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i9 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int j = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    int i8 = getChildCount();
    int i4 = 0;
    View localView;
    int n;
    if (i4 < i8)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8)
      {
        if (i4 != i8 - 1) {
          break label355;
        }
        j = Math.max(k, j);
        i += m;
        n = m;
        m = k;
        k = n;
      }
    }
    for (;;)
    {
      i4++;
      n = m;
      m = k;
      k = n;
      break;
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      n = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i2 = localView.getMeasuredHeight();
      int i1 = localMarginLayoutParams.topMargin;
      i1 = localMarginLayoutParams.bottomMargin + (i2 + i1);
      int i3;
      if (k + n > i6 - getPaddingLeft() - getPaddingRight())
      {
        i3 = Math.max(j, k);
        i2 = i + m;
      }
      for (;;)
      {
        k = i1;
        m = n;
        i = i2;
        j = i3;
        if (i4 != i8 - 1) {
          break;
        }
        j = Math.max(n, i3);
        i = i2 + i1;
        k = i1;
        m = n;
        break;
        i1 = Math.max(m, i1);
        n = k + n;
        i2 = i;
        i3 = j;
      }
      if (i9 == 1073741824)
      {
        paramInt1 = i6;
        if (i7 != 1073741824) {
          break label340;
        }
      }
      label340:
      for (paramInt2 = i5;; paramInt2 = getPaddingTop() + i + getPaddingBottom())
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        paramInt1 = getPaddingLeft() + j + getPaddingRight();
        break;
      }
      label355:
      n = m;
      m = k;
      k = n;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/flowlayout/FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */