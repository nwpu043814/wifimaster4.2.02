package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.string;
import com.lantern.feed.d.d;
import com.lantern.widget.WkFeedStarSmallViewGroup;

public final class bw
  extends LinearLayout
{
  private Context a;
  private WkFeedStarSmallViewGroup b;
  
  public bw(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = new WkFeedStarSmallViewGroup(this.a);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    addView(this.b, paramContext);
    if (this.a.getResources().getDisplayMetrics().widthPixels >= 720)
    {
      TextView localTextView = new TextView(this.a);
      localTextView.setText(R.string.feed_service_grade_tip);
      localTextView.setTextColor(getResources().getColor(R.color.feed_service_grade_tip));
      localTextView.setTextSize(12.0F);
      localTextView.setMaxLines(1);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramContext.leftMargin = d.a(this.a, 5.0F);
      addView(localTextView, paramContext);
    }
  }
  
  public final void a(String paramString)
  {
    this.b.a(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */