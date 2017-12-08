package com.lantern.feed.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.lantern.analytics.a;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.drawable;
import com.lantern.feed.a.aj;
import com.lantern.feed.b.r;
import com.lantern.feed.d.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class cd
  extends FrameLayout
  implements View.OnClickListener
{
  private r a;
  private WkImageView b;
  private cc c;
  private LinearLayout d;
  
  public cd(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    if (paramBoolean) {
      setPadding(0, d.a(paramContext, 7.0F), 0, d.a(paramContext, 7.0F));
    }
    this.d = new LinearLayout(paramContext);
    this.d.setOrientation(0);
    Object localObject = new FrameLayout.LayoutParams(-2, d.a(paramContext, 16.0F));
    addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.b = new WkImageView(paramContext);
    this.b.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(d.a(paramContext, 16.0F), d.a(paramContext, 16.0F));
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.c = new cc(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    this.d.addView(this.c, paramContext);
  }
  
  public final void a(r paramr)
  {
    this.a = paramr;
    this.c.a(this.a);
    if (!TextUtils.isEmpty(paramr.g()))
    {
      if (this.b.getVisibility() != 0) {
        this.b.setVisibility(0);
      }
      this.b.setImageDrawable(null);
      this.b.a(paramr.g(), d.a(getContext(), 16.0F), d.a(getContext(), 16.0F));
    }
    label135:
    for (;;)
    {
      if (d.a(this.a.e())) {
        setOnClickListener(this);
      }
      for (;;)
      {
        return;
        if (this.b.getVisibility() == 8) {
          break label135;
        }
        this.b.setVisibility(8);
        break;
        setOnClickListener(null);
        setClickable(false);
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    d.b(getContext(), this.a.e());
    paramView = new HashMap();
    paramView.put("newsId", this.a.f());
    paramView.put("url", this.a.e());
    paramView.put("title", this.a.a());
    a.e().onEvent("buyad", new JSONObject(paramView).toString());
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (!TextUtils.isEmpty(this.a.e())) {
        setBackgroundResource(0);
      }
      break;
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
    } while (TextUtils.isEmpty(this.a.e()));
    aj.a();
    int i;
    switch (this.a.i())
    {
    default: 
      i = R.drawable.feed_item_white;
    }
    for (;;)
    {
      setBackgroundResource(i);
      break;
      i = R.drawable.feed_item_white;
      continue;
      i = R.drawable.feed_item_yellowwhite;
      continue;
      i = R.drawable.feed_item_black;
      continue;
      i = R.drawable.feed_item_redwhite;
      continue;
      i = R.drawable.feed_item_red;
      continue;
      i = R.drawable.feed_item_yellow;
      continue;
      i = R.drawable.feed_item_yellowyellow;
      continue;
      i = R.drawable.feed_item_bluewhite;
      continue;
      i = R.drawable.feed_item_blue;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */