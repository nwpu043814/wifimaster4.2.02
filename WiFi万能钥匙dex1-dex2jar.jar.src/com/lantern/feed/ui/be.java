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
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class be
  extends a
{
  private WkImageView p;
  private WkImageView q;
  private WkImageView r;
  
  public be(Context paramContext)
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
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65543);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, this.f.getId());
    localLayoutParams.leftMargin = d.a(this.d, 15.0F);
    localLayoutParams.rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, localLayoutParams);
    this.p = new WkImageView(this.d);
    this.p.setId(65537);
    localLayoutParams = new RelativeLayout.LayoutParams(o, n);
    localLayoutParams.addRule(9);
    paramContext.addView(this.p, localLayoutParams);
    this.q = new WkImageView(this.d);
    this.q.setId(65538);
    localLayoutParams = new RelativeLayout.LayoutParams(o, n);
    localLayoutParams.addRule(14);
    paramContext.addView(this.q, localLayoutParams);
    this.r = new WkImageView(this.d);
    this.r.setId(65537);
    localLayoutParams = new RelativeLayout.LayoutParams(o, n);
    localLayoutParams.addRule(11);
    paramContext.addView(this.r, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, paramContext.getId());
    localLayoutParams.addRule(11);
    this.h.addView(this.g, localLayoutParams);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    localLayoutParams.addRule(3, paramContext.getId());
    localLayoutParams.addRule(0, this.g.getId());
    localLayoutParams.leftMargin = d.a(this.d, 15.0F);
    localLayoutParams.rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, localLayoutParams);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      if (!paramg.m()) {
        break label57;
      }
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
    }
    for (;;)
    {
      this.j.a(paramg.l());
      return;
      label57:
      this.f.setTextColor(paramg.d());
    }
  }
  
  public final void c()
  {
    super.c();
    List localList = this.k.t();
    String str1;
    String str5;
    String str4;
    int i;
    String str2;
    String str3;
    if ((localList != null) && (localList.size() > 0))
    {
      int j = localList.size();
      str1 = "";
      str5 = "";
      str4 = "";
      i = j;
      if (j > 3) {
        i = 3;
      }
      if (i != 3) {
        break label167;
      }
      str1 = (String)localList.get(0);
      str2 = (String)localList.get(1);
      str3 = (String)localList.get(2);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        this.p.a(str1, o, n);
      }
      if (!TextUtils.isEmpty(str2)) {
        this.q.a(str2, o, n);
      }
      if (!TextUtils.isEmpty(str3)) {
        this.r.a(str3, o, n);
      }
      return;
      label167:
      if (i == 2)
      {
        str1 = (String)localList.get(0);
        str2 = (String)localList.get(1);
        str3 = str4;
      }
      else
      {
        str2 = str5;
        str3 = str4;
        if (i == 1)
        {
          str1 = (String)localList.get(0);
          str2 = str5;
          str3 = str4;
        }
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.setImageDrawable(null);
    this.q.setImageDrawable(null);
    this.r.setImageDrawable(null);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */