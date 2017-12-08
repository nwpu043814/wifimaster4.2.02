package com.linksure.apservice.ui.views.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.linksure.apservice.R.styleable;

public class MaskLayout
  extends FrameLayout
{
  private NinePatchDrawable a;
  private Rect b = new Rect();
  private int c;
  
  public MaskLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ApsMaskLayout);
    try
    {
      this.c = paramContext.getResourceId(0, 0);
      paramContext.recycle();
      paramInt = this.c;
      this.a = ((NinePatchDrawable)getResources().getDrawable(paramInt));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.a != null)
    {
      this.b.set(0, 0, getWidth(), getHeight());
      this.a.setBounds(this.b);
      this.a.draw(paramCanvas);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/custom/MaskLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */