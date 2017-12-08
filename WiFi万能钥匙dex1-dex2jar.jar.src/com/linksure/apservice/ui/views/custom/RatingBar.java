package com.linksure.apservice.ui.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.linksure.apservice.R.styleable;

public class RatingBar
  extends LinearLayout
{
  private int a = 5;
  private int b = 0;
  private Drawable c;
  private Drawable d;
  private float e;
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RatingBar);
    try
    {
      this.a = paramContext.getInteger(0, 5);
      this.b = paramContext.getInteger(1, 0);
      this.c = paramContext.getDrawable(3);
      this.d = paramContext.getDrawable(2);
      this.e = paramContext.getDimension(4, 0.0F);
      paramContext.recycle();
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a()
  {
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    for (int i = 0; i < this.a; i++)
    {
      ImageView localImageView = new ImageView(getContext());
      localImageView.setAdjustViewBounds(true);
      localImageView.setPadding((int)this.e, 0, 0, 0);
      addView(localImageView, localLayoutParams);
    }
    a(this.b);
  }
  
  private void a(int paramInt)
  {
    int i;
    if (paramInt > this.a)
    {
      i = this.a;
      this.b = i;
      i = 0;
      label20:
      if (i >= this.a) {
        return;
      }
      if (i >= paramInt) {
        break label59;
      }
      ((ImageView)getChildAt(i)).setImageDrawable(this.c);
    }
    for (;;)
    {
      i++;
      break label20;
      i = paramInt;
      break;
      label59:
      ((ImageView)getChildAt(i)).setImageDrawable(this.d);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/custom/RatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */