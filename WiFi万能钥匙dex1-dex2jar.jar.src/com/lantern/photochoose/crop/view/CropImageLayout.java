package com.lantern.photochoose.crop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.lantern.settings.R.drawable;

public class CropImageLayout
  extends RelativeLayout
{
  private CropZoomableImageView a;
  private CropImageBorderView b;
  private int c = 20;
  
  public CropImageLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new CropZoomableImageView(paramContext);
    this.b = new CropImageBorderView(paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    addView(this.a, paramContext);
    addView(this.b, paramContext);
    this.a.setImageResource(R.drawable.common_actionbar_logo);
  }
  
  public final Bitmap a()
  {
    return this.a.b();
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
    this.a.a();
    this.a.invalidate();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/view/CropImageLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */