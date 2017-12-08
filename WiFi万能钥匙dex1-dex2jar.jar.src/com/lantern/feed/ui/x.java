package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import com.lantern.feed.d.d;

public final class x
  extends bf
{
  private String e;
  
  public x(Context paramContext, String paramString)
  {
    super(paramContext);
    this.e = paramString;
    this.d.setTextColor(getResources().getColor(R.color.feed_tip_text));
    paramContext = new TextView(this.a);
    paramContext.setId(4098);
    paramContext.setIncludeFontPadding(false);
    paramContext.setTextSize(15.0F);
    paramContext.setTextColor(getResources().getColor(R.color.feed_tip_text));
    paramContext.setText(R.string.feed_tip_refresh);
    paramContext.setGravity(17);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.gravity = 16;
    paramString.leftMargin = d.a(getContext(), 10.0F);
    this.c.addView(paramContext, paramString);
    paramString = new ImageView(getContext());
    paramString.setImageResource(R.drawable.feed_last_read_refresh);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    paramContext.leftMargin = d.a(getContext(), 4.0F);
    this.c.addView(paramString, paramContext);
    setOnClickListener(new y(this));
  }
  
  public final void a(String paramString)
  {
    this.d.setText(String.format(getResources().getString(R.string.feed_tip_last), new Object[] { paramString }));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */