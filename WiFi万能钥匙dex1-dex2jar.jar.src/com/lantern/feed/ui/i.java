package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.core.o;
import com.lantern.feed.R.anim;
import com.lantern.feed.R.color;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.R.string;
import com.lantern.feed.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class i
  extends FrameLayout
{
  private Context a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private GridView f;
  private LinearLayout g;
  private PopupWindow h;
  private g i;
  private List<com.lantern.feed.b.d> j;
  private List<com.lantern.feed.b.d> k = new ArrayList();
  private boolean l;
  private String m;
  private String n;
  private Animation o;
  private Animation p;
  
  public i(Context paramContext, PopupWindow paramPopupWindow)
  {
    super(paramContext);
    this.a = paramContext;
    this.h = paramPopupWindow;
    this.m = this.a.getResources().getString(R.string.feed_dislike_tip_start);
    this.n = this.a.getResources().getString(R.string.feed_dislike_tip_end);
    setOnClickListener(new j(this));
  }
  
  private HashMap<String, String> a(String paramString)
  {
    h.a("start buildFeedDislikeParams", new Object[0]);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appInfo", com.lantern.feed.d.d.a(com.lantern.core.c.getInstance().getApplicationContext()));
      localJSONObject.put("extInfo", com.lantern.feed.d.d.b(com.lantern.core.c.getInstance().getApplicationContext()));
      String str1 = this.i.a();
      localJSONObject.put("id", str1);
      String str2 = this.i.r();
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        localJSONObject.put("itemId", str2);
      }
      localJSONObject.put("dislike", paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
    paramString = com.lantern.core.c.getServer();
    h.a("buildFeedDislikeParams signparams", new Object[0]);
    paramString = paramString.a("cds005001", localJSONObject);
    h.a("buildFeedDislikeParams done", new Object[0]);
    return paramString;
  }
  
  public final List<com.lantern.feed.b.d> a()
  {
    return this.k;
  }
  
  public final void a(g paramg, View paramView)
  {
    int i2 = 1;
    h.a("setDataToView " + paramg.g(), new Object[0]);
    this.l = false;
    this.k.clear();
    this.i = paramg;
    this.j = this.i.W();
    Object localObject;
    if (this.j.size() == 1)
    {
      inflate(this.a, R.layout.feed_dislike_no_items_layout, this);
      this.e = ((TextView)findViewById(R.id.dislike_default));
      this.e.setText(((com.lantern.feed.b.d)this.j.get(0)).b());
      this.e.setOnClickListener(new k(this));
      measure(0, 0);
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      paramg = (FrameLayout.LayoutParams)this.e.getLayoutParams();
      paramg.leftMargin = (localObject[0] - this.e.getMeasuredWidth() - com.lantern.feed.d.d.a(this.a, 2.0F));
      paramg.topMargin = (localObject[1] + paramView.getPaddingTop() - (this.e.getMeasuredHeight() - (paramView.getMeasuredHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom())) / 2);
      this.e.setLayoutParams(paramg);
      return;
    }
    inflate(this.a, R.layout.feed_dislike_layout, this);
    setBackgroundColor(getResources().getColor(R.color.feed_dislike_bg));
    this.b = ((ImageView)findViewById(R.id.top_arrow));
    this.c = ((ImageView)findViewById(R.id.bottom_arrow));
    this.d = ((TextView)findViewById(R.id.dislike_tip));
    this.e = ((TextView)findViewById(R.id.dislike_default));
    this.e.setText(((com.lantern.feed.b.d)this.j.get(0)).b());
    this.e.setOnClickListener(new l(this));
    this.f = ((GridView)findViewById(R.id.dislike_grid));
    this.f.setOnItemClickListener(new m(this));
    this.f.setAdapter(new com.lantern.feed.b.c(this.j));
    this.g = ((LinearLayout)findViewById(R.id.dislike_layout));
    paramg = new int[2];
    paramView.getLocationOnScreen(paramg);
    int i1 = getContext().getResources().getDisplayMetrics().heightPixels;
    int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
    int i4 = i3 - com.lantern.feed.d.d.a(this.a, 30.0F);
    if (paramg[1] > i1 / 2)
    {
      this.b.setVisibility(8);
      label489:
      measure(0, 0);
      localObject = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      if (paramg[1] <= i1 / 2) {
        break label771;
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = (i1 - paramg[1]);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i1 = paramg[0] - (this.c.getMeasuredWidth() - (paramView.getMeasuredWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight())) / 2 - com.lantern.feed.d.d.a(this.a, 15.0F);
      if (this.c.getMeasuredWidth() + i1 <= i4 - com.lantern.feed.d.d.a(this.a, 6.0F)) {
        break label957;
      }
      i1 = i4 - com.lantern.feed.d.d.a(this.a, 6.0F) - this.c.getMeasuredWidth();
    }
    label671:
    label689:
    label771:
    label913:
    label925:
    label954:
    label957:
    for (;;)
    {
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i1 = 1;
      if (paramg[0] + paramView.getMeasuredWidth() == i3)
      {
        if (i1 == 0) {
          break label925;
        }
        if (i2 == 0) {
          break label913;
        }
        i2 = R.anim.feed_dislike_scale_down_show;
        i1 = R.anim.feed_dislike_scale_up_hide;
        if ((i2 != 0) && (i1 != 0))
        {
          this.o = AnimationUtils.loadAnimation(getContext(), i2);
          this.p = AnimationUtils.loadAnimation(getContext(), i1);
          this.p.setAnimationListener(new n(this));
        }
        if (this.o == null) {
          break;
        }
        this.g.startAnimation(this.o);
        break;
        this.c.setVisibility(8);
        break label489;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramg[1];
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i1 = paramg[0] - (this.b.getMeasuredWidth() - (paramView.getMeasuredWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight())) / 2 - com.lantern.feed.d.d.a(this.a, 15.0F);
        if (this.b.getMeasuredWidth() + i1 <= i4 - com.lantern.feed.d.d.a(this.a, 6.0F)) {
          break label954;
        }
        i1 = i4 - com.lantern.feed.d.d.a(this.a, 6.0F) - this.b.getMeasuredWidth();
      }
      for (;;)
      {
        localObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i1 = 0;
        break;
        i2 = 0;
        break label671;
        i2 = R.anim.feed_dislike_scale_down_center_show;
        i1 = R.anim.feed_dislike_scale_up_center_hide;
        break label689;
        if (i2 != 0)
        {
          i2 = R.anim.feed_dislike_scale_up_show;
          i1 = R.anim.feed_dislike_scale_down_hide;
          break label689;
        }
        i2 = R.anim.feed_dislike_scale_up_center_show;
        i1 = R.anim.feed_dislike_scale_down_center_hide;
        break label689;
      }
    }
  }
  
  public final boolean b()
  {
    return this.l;
  }
  
  public final void c()
  {
    if (this.g != null) {
      if (this.p != null) {
        this.g.startAnimation(this.p);
      }
    }
    for (;;)
    {
      return;
      this.h.dismiss();
      continue;
      if (this.e != null) {
        this.h.dismiss();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */