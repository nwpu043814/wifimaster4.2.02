package com.bluefay.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.bluefay.framework.R.styleable;

public class FixScaleLayout
  extends FrameLayout
{
  private float a = 0.5625F;
  
  public FixScaleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixScaleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FixScaleLayout, paramInt, 0);
    this.a = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    switch (i)
    {
    default: 
      paramInt2 = 0;
    }
    i = (int)(paramInt2 / this.a);
    measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    setMeasuredDimension(paramInt2, i);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/FixScaleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */