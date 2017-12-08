package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.layout;
import com.lantern.feed.R.string;
import com.lantern.feed.d.d;

public final class ab
  extends FrameLayout
{
  private Context a;
  private TextView b;
  private ProgressBar c;
  private float d;
  private String e;
  
  public ab(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramContext;
    this.e = paramString;
    this.d = getResources().getDisplayMetrics().density;
    setBackgroundColor(getResources().getColor(R.color.white));
    paramContext = new LinearLayout(this.a);
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 17;
    addView(paramContext, paramString);
    this.b = new TextView(this.a);
    this.b.setId(4097);
    this.b.setText(R.string.feed_list_load_more);
    this.b.setTextColor(getResources().getColor(R.color.feed_loading_text));
    this.b.setTextSize(10.0F);
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 16;
    paramContext.addView(this.b, paramString);
    paramContext.addView(new View(this.a), new FrameLayout.LayoutParams(d.a(this.a, 6.0F), -1));
    this.c = ((ProgressBar)LayoutInflater.from(this.a).inflate(R.layout.feed_progressbar_r, null));
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 16;
    paramContext.addView(this.c, paramString);
  }
  
  public final void a()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (this.c.getVisibility() != 0) {
      this.c.setVisibility(0);
    }
    this.b.setText(getResources().getString(R.string.feed_list_load_more));
    setOnClickListener(null);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.c.setVisibility(4);
      this.b.setText(R.string.feed_tip_load_more_failed);
      setOnClickListener(new ac(this));
    }
    for (;;)
    {
      return;
      setVisibility(8);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */