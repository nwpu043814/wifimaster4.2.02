package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.core.imageloader.a;
import com.lantern.core.imageloader.c;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.d.d;

public final class bu
  extends FrameLayout
{
  private Context a;
  private WkImageView b;
  private ImageView c;
  
  public bu(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setBackgroundColor(getResources().getColor(R.color.translucent));
    this.b = new WkImageView(this.a);
    this.b.a(0);
    addView(this.b, new FrameLayout.LayoutParams(d.a(this.a, 46.0F), d.a(this.a, 46.0F)));
    this.c = new ImageView(this.a);
    this.c.setVisibility(4);
    this.c.setImageResource(R.drawable.connect_success);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 85;
    addView(this.c, paramContext);
  }
  
  public final void a()
  {
    this.b.setImageDrawable(null);
    if (this.c.getVisibility() != 4) {
      this.c.setVisibility(4);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.c.getVisibility() != 4) {
      this.c.setVisibility(4);
    }
    c.a(this.a, paramString, this.b, new bv(this), new a(), this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */