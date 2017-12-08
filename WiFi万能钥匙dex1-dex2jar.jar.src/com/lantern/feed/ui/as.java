package com.lantern.feed.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.core.imageloader.c;
import com.lantern.feed.R.drawable;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class as
  extends a
{
  private WkImageView p;
  private int q;
  
  public as(Context paramContext)
  {
    super(paramContext);
    paramContext = new FrameLayout(this.d);
    paramContext.setId(65543);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject).topMargin = d.a(this.d, 14.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    this.p = new WkImageView(this.d, R.drawable.common_img_bg);
    this.p.setId(65537);
    localObject = new FrameLayout.LayoutParams(b, m);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    paramContext.addView(this.p, (ViewGroup.LayoutParams)localObject);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(20.0F);
    this.f.setSingleLine(true);
    this.f.setGravity(17);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 15.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramContext.addView(this.f, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localObject = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(0, this.g.getId());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, (ViewGroup.LayoutParams)localObject);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      this.f.setTextColor(paramg.d());
      this.f.setVisibility(8);
      this.j.a(paramg.l());
      this.q = b();
      if (this.q != this.p.getMeasuredHeight())
      {
        paramg = new FrameLayout.LayoutParams(b, this.q);
        paramg.gravity = 1;
        this.p.setLayoutParams(paramg);
      }
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        c.a(this.d, str, this.p, new at(this), null, b, this.q);
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.setImageDrawable(null);
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */