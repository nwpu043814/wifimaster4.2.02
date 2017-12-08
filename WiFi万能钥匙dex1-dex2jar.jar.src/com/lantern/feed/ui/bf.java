package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.d.d;

public class bf
  extends RelativeLayout
{
  protected Context a;
  protected float b;
  protected LinearLayout c;
  protected TextView d;
  
  public bf(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = getResources().getDisplayMetrics().density;
    setBackgroundColor(getResources().getColor(R.color.feed_tip_bg));
    paramContext = new View(this.a);
    paramContext.setId(4097);
    paramContext.setBackgroundColor(getResources().getColor(R.color.feed_list_divider));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 2);
    localLayoutParams.addRule(12);
    addView(paramContext, localLayoutParams);
    this.c = new LinearLayout(this.a);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, d.a(this.a, 40.0F) - 2);
    localLayoutParams.addRule(2, paramContext.getId());
    localLayoutParams.addRule(14);
    addView(this.c, localLayoutParams);
    this.d = new TextView(this.a);
    this.d.setIncludeFontPadding(false);
    this.d.setTextSize(15.0F);
    this.d.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    this.c.addView(this.d, paramContext);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */