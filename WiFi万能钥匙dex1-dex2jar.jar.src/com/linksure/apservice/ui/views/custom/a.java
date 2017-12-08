package com.linksure.apservice.ui.views.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import com.linksure.apservice.R.color;
import com.linksure.apservice.utils.j;

public final class a
  extends ShapeDrawable
{
  private static int a = 0;
  private static int b = 0;
  
  public static ShapeDrawable a(Context paramContext)
  {
    if (b == 0)
    {
      a = (j.a(paramContext) - j.a(paramContext, 160.0F)) / 2;
      b = j.a(paramContext, 120.0F);
    }
    a locala = new a();
    locala.getPaint().setColor(paramContext.getResources().getColor(R.color.aps_lllight_gray));
    return locala;
  }
  
  public final int getIntrinsicHeight()
  {
    return b;
  }
  
  public final int getIntrinsicWidth()
  {
    return a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/custom/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */