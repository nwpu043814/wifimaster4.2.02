package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.lantern.feed.R.color;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class bh
  extends a
{
  private WkFeedVideoPlayer p;
  
  public bh(Context paramContext)
  {
    super(paramContext);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(17.0F);
    this.f.setMaxLines(2);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    paramContext.leftMargin = d.a(this.d, 15.0F);
    paramContext.topMargin = d.a(this.d, 14.0F);
    paramContext.rightMargin = d.a(this.d, 15.0F);
    paramContext.bottomMargin = d.a(this.d, 5.0F);
    this.h.addView(this.f, paramContext);
    this.p = new WkFeedVideoPlayer(this.d);
    this.p.setId(65543);
    paramContext = new RelativeLayout.LayoutParams(b, m);
    paramContext.addRule(3, this.f.getId());
    paramContext.leftMargin = d.a(this.d, 15.0F);
    paramContext.rightMargin = d.a(this.d, 15.0F);
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
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      if (!paramg.m()) {
        break label73;
      }
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
    }
    for (;;)
    {
      this.j.a(paramg.l());
      this.p.a(this.k, false, this.l);
      return;
      label73:
      this.f.setTextColor(paramg.d());
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
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this.k.n();
    this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */