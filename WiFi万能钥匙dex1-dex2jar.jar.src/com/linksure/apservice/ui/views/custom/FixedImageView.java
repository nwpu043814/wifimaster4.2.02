package com.linksure.apservice.ui.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.linksure.apservice.utils.j;

public class FixedImageView
  extends ImageView
{
  private static int a = 0;
  private static int b = 0;
  
  public FixedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public FixedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (a == 0)
    {
      a = (j.a(paramContext) - 180) / 2;
      b = j.a(paramContext, 120.0F);
    }
    setMaxHeight(b);
    setMaxWidth(a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/custom/FixedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */