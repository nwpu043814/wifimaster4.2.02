package com.lantern.wifitools.apgrade.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;

public class ApGradeStarBigViewGroup
  extends RelativeLayout
{
  private View a;
  private TextView b;
  private RatingBar c;
  
  public ApGradeStarBigViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = LayoutInflater.from(paramContext).inflate(R.layout.wifitools_apgrade_stars_big_layout, this);
    this.b = ((TextView)this.a.findViewById(R.id.big_star_text));
    this.c = ((RatingBar)this.a.findViewById(R.id.big_star_ratingbar));
    this.c.setOnRatingBarChangeListener(new b(this));
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setVisibility(8);
      if (paramInt != 1) {
        break label40;
      }
      this.b.setText(R.string.apgrade_star1);
    }
    for (;;)
    {
      return;
      this.b.setVisibility(0);
      break;
      label40:
      if (paramInt == 2) {
        this.b.setText(R.string.apgrade_star2);
      } else if (paramInt == 3) {
        this.b.setText(R.string.apgrade_star3);
      } else if (paramInt == 4) {
        this.b.setText(R.string.apgrade_star4);
      } else if (paramInt == 5) {
        this.b.setText(R.string.apgrade_star5);
      } else if (paramInt == 0) {
        this.b.setText("");
      }
    }
  }
  
  public final String a()
  {
    return String.valueOf((int)this.c.getRating());
  }
  
  public final void a(int paramInt)
  {
    this.c.setRating(paramInt);
    b(paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.setIsIndicator(paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/widget/ApGradeStarBigViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */