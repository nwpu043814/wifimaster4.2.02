package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.a.m;
import com.lantern.feed.b.g;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class a
  extends RelativeLayout
  implements View.OnClickListener
{
  protected static float a;
  protected static int b;
  protected static int c;
  protected static int m;
  protected static int n;
  protected static int o;
  protected Context d;
  protected int e = 8;
  protected TextView f;
  protected ImageView g;
  protected RelativeLayout h;
  protected View i;
  protected ai j;
  protected g k;
  protected String l;
  private int p;
  private int q;
  private int r;
  private int s;
  private PopupWindow t;
  private i u;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    if (a == 0.0F) {
      a = this.d.getResources().getDisplayMetrics().density;
    }
    if (b == 0) {
      b = this.d.getResources().getDisplayMetrics().widthPixels - com.lantern.feed.d.d.a(this.d, 30.0F);
    }
    if (m == 0) {
      m = (int)(b / 1.8F);
    }
    if ((n == 0) || (o == 0))
    {
      float f1 = (b - com.lantern.feed.d.d.b(this.d, 5.6F)) / 3.0F;
      o = (int)f1;
      n = (int)(f1 / 1.53F);
    }
    if (c == 0) {
      c = this.d.getResources().getDisplayMetrics().widthPixels - com.lantern.feed.d.d.a(this.d, 42.0F) - o;
    }
    this.g = new ImageView(this.d);
    this.g.setId(65545);
    this.g.setImageResource(R.drawable.feed_dislike);
    this.g.setPadding(com.lantern.feed.d.d.a(this.d, 2.0F), com.lantern.feed.d.d.a(this.d, 9.0F), com.lantern.feed.d.d.a(this.d, 15.0F), com.lantern.feed.d.d.a(this.d, 9.0F));
    this.g.setOnClickListener(new b(this));
    setBackgroundResource(R.drawable.feed_item_bg);
    setOnClickListener(this);
    this.h = new RelativeLayout(paramContext);
    this.h.setId(65552);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.h, paramContext);
    this.i = new View(this.d);
    this.i.setBackgroundColor(getResources().getColor(R.color.feed_list_divider));
    paramContext = new RelativeLayout.LayoutParams(-1, 2);
    paramContext.addRule(3, this.h.getId());
    paramContext.topMargin = (com.lantern.feed.d.d.a(this.d, 8.0F) - 2);
    paramContext.leftMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    paramContext.rightMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    addView(this.i, paramContext);
  }
  
  public static a a(Context paramContext, int paramInt, String paramString)
  {
    int i1 = 0;
    switch (1.a[(paramInt - 1)])
    {
    default: 
      paramContext = new ar(paramContext);
    }
    for (;;)
    {
      return paramContext;
      paramContext = new ar(paramContext);
      continue;
      if (!TextUtils.isEmpty(paramString))
      {
        int i2 = c;
        float f1 = com.lantern.feed.d.d.a(a);
        paramInt = i1;
        if (i2 > 0) {
          if (!TextUtils.isEmpty(paramString)) {
            break label166;
          }
        }
        label166:
        TextPaint localTextPaint;
        for (paramInt = i1;; paramInt = new StaticLayout(com.lantern.feed.d.d.d(paramString), localTextPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount())
        {
          if (paramInt < 3) {
            break label209;
          }
          paramContext = new au(paramContext);
          break;
          localTextPaint = new TextPaint();
          localTextPaint.setTextSize(f1);
        }
      }
      label209:
      paramContext = new av(paramContext);
      continue;
      paramContext = new be(paramContext);
      continue;
      paramContext = new ad(paramContext);
      continue;
      paramContext = new bh(paramContext);
      continue;
      paramContext = new au(paramContext);
      continue;
      paramContext = new av(paramContext);
      continue;
      paramContext = new as(paramContext);
      continue;
      paramContext = new ae(paramContext);
      continue;
      paramContext = new an(paramContext);
      continue;
      paramContext = new aj(paramContext);
      continue;
      paramContext = new d(paramContext);
      continue;
      paramContext = new cl(paramContext);
      continue;
      paramContext = new ba(paramContext);
      continue;
      paramContext = new bg(paramContext);
      continue;
      paramContext = new aw(paramContext);
    }
  }
  
  public final g a()
  {
    return this.k;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
    if (this.e == 0) {
      if ((!this.k.z()) && (this.k.o() != 0))
      {
        this.k.A();
        if (!TextUtils.isEmpty(this.l)) {
          break label61;
        }
        m.a().a(2, this.k);
      }
    }
    for (;;)
    {
      return;
      label61:
      com.lantern.feed.channel.a.a.a().a(2, this.k);
      continue;
      if ((this.k.b() == 2) && (this.k.o() == 1))
      {
        Object localObject = this.k.i(2);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.lantern.feed.b.b localb = (com.lantern.feed.b.b)((Iterator)localObject).next();
            localb.b(localb.c());
          }
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    if ((this.t != null) && (this.t.isShowing())) {
      this.u.c();
    }
    this.k = paramg;
    setBackgroundResource(this.k.y());
    if (this.k.W() != null) {
      if (this.g.getVisibility() != 0) {
        this.g.setVisibility(0);
      }
    }
    for (;;)
    {
      b(paramg);
      return;
      if (this.g.getVisibility() != 8) {
        this.g.setVisibility(8);
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.l = paramString;
  }
  
  protected final int b()
  {
    int i3 = b;
    int i2 = m;
    int i1 = i2;
    if (this.k.u() > 0) {
      if (this.k.s() > 0) {
        break label38;
      }
    }
    label38:
    float f1;
    for (i1 = i2;; i1 = (int)(i3 / f1))
    {
      return i1;
      float f2 = this.k.u() / this.k.s();
      if (f2 >= 1.8F)
      {
        f1 = f2;
        if (f2 <= 5.5F) {}
      }
      else
      {
        f1 = 1.8F;
      }
    }
  }
  
  public abstract void b(g paramg);
  
  public void c() {}
  
  public void d()
  {
    if ((this.t != null) && (this.t.isShowing())) {
      this.u.c();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.p = ((int)paramMotionEvent.getRawX());
      this.q = ((int)paramMotionEvent.getRawY());
      continue;
      this.r = ((int)paramMotionEvent.getRawX());
      this.s = ((int)paramMotionEvent.getRawY());
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        localJSONObject.put("down_x", this.p);
        localJSONObject.put("down_y", this.q);
        localJSONObject.put("up_x", this.r);
        localJSONObject.put("up_y", this.s);
        this.k.c(localJSONObject.toString());
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
    }
  }
  
  public abstract boolean e();
  
  public void onClick(View paramView)
  {
    if (this.k != null)
    {
      h.a("item onclick title:" + this.k.g() + " dataType:" + this.k.b(), new Object[0]);
      com.lantern.feed.d.d.a(this.d, this.k, this.k.e(0));
      if (!TextUtils.isEmpty(this.l)) {
        break label94;
      }
      m.a().a(3, this.k);
    }
    for (;;)
    {
      return;
      label94:
      com.lantern.feed.channel.a.a.a().a(3, this.k);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */