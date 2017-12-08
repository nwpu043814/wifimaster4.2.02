package com.linksure.apservice.integration.photochoose.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.linksure.apservice.integration.photochoose.b.f;

public class SquareImageView
  extends ImageView
{
  Context a;
  int b;
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = ((f.a(this.a) - f.a(this.a, 4.0F)) / 3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.b, this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/widget/SquareImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */