package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class bg
  extends a
{
  private WkFeedVideoPlayer p = new WkFeedVideoPlayer(this.d);
  
  public bg(Context paramContext)
  {
    super(paramContext);
    this.p.setId(65543);
    int i = this.d.getResources().getDisplayMetrics().widthPixels;
    paramContext = new RelativeLayout.LayoutParams(i, (int)(i / 1.8F));
    paramContext.addRule(10);
    this.h.addView(this.p, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(3, this.p.getId());
    paramContext.addRule(11);
    this.h.addView(this.g, paramContext);
    this.j = new ai(this.d);
    this.j.setId(65542);
    paramContext = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    paramContext.addRule(3, this.p.getId());
    paramContext.addRule(0, this.g.getId());
    paramContext.leftMargin = d.a(this.d, 15.0F);
    paramContext.rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, paramContext);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      this.j.a(paramg.l());
      this.p.a(this.k, true, this.l);
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        this.p.a(str);
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.h();
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void f()
  {
    this.p.i();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */