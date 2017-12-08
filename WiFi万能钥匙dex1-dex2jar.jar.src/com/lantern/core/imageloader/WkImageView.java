package com.lantern.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.lantern.core.R.drawable;

public class WkImageView
  extends ImageView
{
  private String a;
  private int b;
  private int c = -1;
  private int d;
  
  public WkImageView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public WkImageView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.d = paramInt;
    if (paramInt == 0) {
      this.d = R.drawable.common_img_small_bg;
    }
    if (this.d > 0) {
      setBackgroundResource(this.d);
    }
  }
  
  public WkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.a = null;
    this.b = -1;
    this.c = -1;
    if (this.d > 0) {
      setBackgroundResource(this.d);
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(this.a)) || (!this.a.equals(paramString)) || (this.c == -1))
      {
        c.a(getContext(), paramString, this, new e(this), null, paramInt1, paramInt2);
        this.a = paramString;
        this.c = 0;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
    if (this.d >= 0) {
      setBackgroundResource(this.d);
    }
  }
  
  public final void a(String paramString)
  {
    b(paramString, 0, 0);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    b(paramString, paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setImageDrawable(null);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      a();
    }
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      a();
    }
    for (;;)
    {
      super.setImageDrawable(paramDrawable);
      return;
      setBackgroundResource(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/WkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */