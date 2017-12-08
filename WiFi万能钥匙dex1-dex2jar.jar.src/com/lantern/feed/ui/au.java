package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.lantern.feed.R.color;
import com.lantern.feed.b.g;
import com.lantern.feed.b.g.a;
import com.lantern.feed.d.c;
import com.lantern.feed.d.d;
import java.util.List;

public final class au
  extends a
{
  private WkImageView p;
  private ck q;
  
  public au(Context paramContext)
  {
    super(paramContext);
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65541);
    Object localObject1 = new FrameLayout(this.d);
    ((FrameLayout)localObject1).setId(65543);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = d.a(this.d, 12.0F);
    paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.p = new WkImageView(this.d);
    this.p.setId(65537);
    localObject2 = new FrameLayout.LayoutParams(o, n);
    ((FrameLayout)localObject1).addView(this.p, (ViewGroup.LayoutParams)localObject2);
    this.q = new ck(this.d);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).gravity = 85;
    ((FrameLayout.LayoutParams)localObject2).rightMargin = d.a(this.d, 4.0F);
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = d.a(this.d, 4.0F);
    ((FrameLayout)localObject1).addView(this.q, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout(this.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(0, ((FrameLayout)localObject1).getId());
    localLayoutParams.addRule(15);
    paramContext.addView((View)localObject2, localLayoutParams);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(17.0F);
    this.f.setMaxLines(3);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout)localObject2).addView(this.f, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = d.a(this.d, 12.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, -1, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject1);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localObject1 = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.g.getId());
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, -1, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      paramg.o(g.a.g);
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      if (!paramg.m()) {
        break label94;
      }
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
      this.j.a(paramg.l());
      if (paramg.j() <= 0) {
        break label108;
      }
      this.q.setVisibility(0);
      this.q.a(c.c(paramg.j()));
    }
    for (;;)
    {
      return;
      label94:
      this.f.setTextColor(paramg.d());
      break;
      label108:
      this.q.setVisibility(8);
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        this.p.a(str, o, n);
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
    this.k.n();
    this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */