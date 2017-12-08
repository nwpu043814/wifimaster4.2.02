package com.lantern.photochoose.crop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class CropImageBorderView
  extends View
{
  private int a = 0;
  private int b;
  private int c;
  private int d = Color.parseColor("#FFFFFF");
  private int e = 1;
  private Paint f = new Paint();
  
  public CropImageBorderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageBorderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageBorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c = (getWidth() - this.a * 2);
    this.b = ((getHeight() - this.c) / 2);
    this.f.setColor(Color.parseColor("#AA000000"));
    this.f.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(0.0F, 0.0F, this.a, getHeight(), this.f);
    paramCanvas.drawRect(getWidth() - this.a, 0.0F, getWidth(), getHeight(), this.f);
    paramCanvas.drawRect(this.a, 0.0F, getWidth() - this.a, this.b, this.f);
    paramCanvas.drawRect(this.a, getHeight() - this.b, getWidth() - this.a, getHeight(), this.f);
    this.f.setColor(this.d);
    this.f.setStrokeWidth(this.e);
    this.f.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(this.a, this.b, getWidth() - this.a, getHeight() - this.b, this.f);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/view/CropImageBorderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */