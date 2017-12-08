package com.lantern.wifitools.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.lantern.wifitools.R.drawable;

public class CustomImageView
  extends View
{
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private Rect d;
  private Rect e;
  private Rect f;
  private Paint g;
  private int h;
  
  public CustomImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CustomImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CustomImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.h = ((int)(getResources().getDisplayMetrics().density * 2.0F));
    this.a = BitmapFactory.decodeResource(getResources(), R.drawable.speed_result_progress);
    this.b = BitmapFactory.decodeResource(getResources(), R.drawable.speed_result_progress_bottom);
    this.c = BitmapFactory.decodeResource(getResources(), R.drawable.speed_result);
    this.g = new Paint(1);
    this.g.setFilterBitmap(true);
    this.g.setDither(true);
    this.f = new Rect(0, 0, this.b.getWidth(), this.b.getHeight());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, this.f, this.f, this.g);
    paramCanvas.drawBitmap(this.a, this.d, this.e, this.g);
    paramCanvas.drawBitmap(this.c, this.f, this.f, this.g);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/CustomImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */