package com.lantern.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.core.R.color;
import com.lantern.core.R.drawable;
import com.lantern.core.R.id;
import com.lantern.core.R.layout;
import com.lantern.core.R.string;

public class WkFeedStarSmallViewGroup
  extends RelativeLayout
{
  private View a;
  private TextView b;
  
  public WkFeedStarSmallViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WkFeedStarSmallViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = LayoutInflater.from(paramContext).inflate(R.layout.feed_stars_small_layout, this);
    this.b = ((TextView)this.a.findViewById(R.id.small_text));
  }
  
  public final void a(String paramString)
  {
    float f;
    try
    {
      f = Float.parseFloat(paramString);
      paramString = (ViewGroup)this.a.findViewById(R.id.small_star_image_layout);
      k = (int)Math.floor(f / 200.0F);
      int i = 0;
      if (f / 2.0F - k > 0.0F) {
        i = 1;
      }
      for (j = 1;; j++)
      {
        if (j >= 6) {
          break label196;
        }
        if (i != 0) {
          break label120;
        }
        if (j > k) {
          break;
        }
        ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.small_star_selected);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        int j;
        paramString.printStackTrace();
        f = 0.0F;
        continue;
        ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.small_star_gray);
        continue;
        label120:
        if (j <= k) {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.small_star_selected);
        } else if (j == k + 1) {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.small_star_half);
        } else {
          ((ImageView)paramString.getChildAt(j - 1)).setImageResource(R.drawable.small_star_gray);
        }
      }
    }
    label196:
    if (f != 0.0F) {
      this.b.setTextColor(getResources().getColor(R.color.star_yellow_text));
    }
    for (;;)
    {
      paramString = getResources().getString(R.string.star_widget_socre);
      this.b.setText(String.valueOf(Math.abs(f / 100.0F)) + paramString);
      return;
      this.b.setTextColor(getResources().getColor(R.color.star_gary_text));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/widget/WkFeedStarSmallViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */