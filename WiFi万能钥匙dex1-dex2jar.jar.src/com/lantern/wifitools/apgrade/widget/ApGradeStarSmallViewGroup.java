package com.lantern.wifitools.apgrade.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.wifitools.R.color;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;

public class ApGradeStarSmallViewGroup
  extends RelativeLayout
{
  private View a;
  private TextView b;
  
  public ApGradeStarSmallViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = LayoutInflater.from(paramContext).inflate(R.layout.wifitools_apgrade_stars_small_layout, this);
    this.b = ((TextView)this.a.findViewById(R.id.small_text));
  }
  
  public final void a(String paramString)
  {
    this.b.setText(paramString);
    try
    {
      f = Float.parseFloat(paramString);
      if (f != 0.0F)
      {
        this.b.setTextColor(getResources().getColor(R.color.grade_yellow_text));
        paramString = (ViewGroup)this.a.findViewById(R.id.small_star_image_layout);
        k = (int)Math.floor(f / 2.0F);
        int i = 0;
        if (f / 2.0F - k > 0.0F) {
          i = 1;
        }
        for (j = 1;; j++)
        {
          if (j >= 6) {
            return;
          }
          if (i != 0) {
            break label170;
          }
          if (j > k) {
            break;
          }
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.apgrade_tiny_star_selected);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        int j;
        paramString.printStackTrace();
        float f = 0.0F;
        continue;
        this.b.setTextColor(getResources().getColor(R.color.grade_gary_text));
        continue;
        ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.apgrade_tiny_star_gray);
        continue;
        label170:
        if (j <= k) {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.apgrade_tiny_star_selected);
        } else if (j == k + 1) {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.apgrade_tiny_star_half);
        } else {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.apgrade_tiny_star_gray);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/widget/ApGradeStarSmallViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */