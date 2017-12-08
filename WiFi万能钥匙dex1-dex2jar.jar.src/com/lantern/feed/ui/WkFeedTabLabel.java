package com.lantern.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.bluefay.a.e;
import com.lantern.core.c;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import com.lantern.feed.a.m;
import com.lantern.feed.b.o;
import com.lantern.feed.b.q;
import com.lantern.feed.d.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class WkFeedTabLabel
  extends RelativeLayout
{
  private Context a;
  private ImageView b;
  private HorizontalScrollView c;
  private b d;
  private int e;
  private a f;
  private int g;
  private com.lantern.feed.b.a h;
  private String i;
  
  public WkFeedTabLabel(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WkFeedTabLabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public WkFeedTabLabel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    this.e = -1;
    this.g = getResources().getDisplayMetrics().widthPixels;
    this.c = new bz(this, this.a);
    this.c.setHorizontalScrollBarEnabled(false);
    this.c.setOverScrollMode(2);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.d = new b(this.a);
    localObject = new RelativeLayout.LayoutParams(-2, -1);
    this.c.addView(this.d, (ViewGroup.LayoutParams)localObject);
    localObject = new bx(this.a);
    o localo = new o();
    localo.b(getResources().getString(R.string.feed_tab_title));
    ((bx)localObject).a(localo);
    a((View)localObject);
    this.b = new ImageView(this.a);
    this.b.setImageResource(R.drawable.feed_tab_search);
    this.b.setOnClickListener(new ca(this));
    this.b.setVisibility(8);
    localObject = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.b, (ViewGroup.LayoutParams)localObject);
    a(0);
    c.addListener(new by(this, new int[] { 128402, 128403 }));
  }
  
  private void a(View paramView)
  {
    if (this.d != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      this.d.addView(paramView, localLayoutParams);
      paramView.setOnClickListener(this.d);
    }
  }
  
  public final void a(int paramInt)
  {
    if ((this.d == null) || (this.d.getMeasuredWidth() == 0)) {
      post(new cb(this, paramInt));
    }
    b localb;
    do
    {
      return;
      localb = this.d;
    } while ((paramInt < 0) || (paramInt >= localb.getChildCount()) || (localb.a.e == paramInt));
    if ((localb.a.e >= 0) && (localb.a.e < localb.getChildCount())) {
      localb.getChildAt(localb.a.e).setSelected(false);
    }
    localb.a.e = paramInt;
    localb.getChildAt(localb.a.e).setSelected(true);
    int k = localb.a.d.getMeasuredWidth();
    int m = localb.a.c.getScrollX();
    if (paramInt == 0) {
      localb.a.c.scrollTo(0, 0);
    }
    for (;;)
    {
      localb.postInvalidate();
      break;
      if (paramInt == localb.getChildCount() - 1)
      {
        localb.a.c.scrollTo(k - localb.a.g, 0);
      }
      else
      {
        int j = localb.getChildAt(localb.a.e).getLeft();
        paramInt = localb.getChildAt(localb.a.e).getRight();
        if (j < m)
        {
          j -= (paramInt - j >> 1);
          paramInt = j;
          if (j < 0) {
            paramInt = 0;
          }
          localb.a.c.scrollTo(paramInt, 0);
        }
        else if (paramInt > localb.a.g + m)
        {
          j = (paramInt - j >> 1) + (paramInt - (localb.a.g + m));
          paramInt = j;
          if (m + j + localb.a.g > k) {
            paramInt = k - localb.a.g - m;
          }
          localb.a.c.scrollBy(paramInt, 0);
        }
      }
    }
  }
  
  public final void a(com.lantern.feed.b.a parama)
  {
    this.h = parama;
    if (parama != null)
    {
      List localList = parama.a();
      this.d.removeAllViews();
      this.e = -1;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          o localo = (o)localIterator.next();
          bx localbx = new bx(this.a);
          localbx.a(localo);
          a(localbx);
        }
        if ((TextUtils.isEmpty(this.i)) && (this.h != null) && (!this.h.c())) {
          m.a().a(1, localList);
        }
      }
      if (parama.b() != 1) {
        break label140;
      }
      this.b.setVisibility(0);
    }
    for (;;)
    {
      return;
      label140:
      this.b.setVisibility(8);
    }
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(String paramString)
  {
    this.i = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
  
  public final class b
    extends FrameLayout
    implements View.OnClickListener
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final void onClick(View paramView)
    {
      bx localbx;
      int i;
      if ((paramView instanceof bx))
      {
        localbx = (bx)paramView;
        i = indexOfChild(paramView);
        if (i >= 0) {
          break label23;
        }
      }
      label23:
      do
      {
        return;
        if (WkFeedTabLabel.g(WkFeedTabLabel.this) != null) {
          WkFeedTabLabel.g(WkFeedTabLabel.this).a(i);
        }
        paramView = localbx.a();
      } while (paramView == null);
      if ((i != 0) && (WkFeedTabLabel.f(WkFeedTabLabel.this) != i))
      {
        if ((!paramView.d()) || (TextUtils.isEmpty(paramView.c()))) {
          break label246;
        }
        d.b(WkFeedTabLabel.h(WkFeedTabLabel.this), paramView.c());
      }
      for (;;)
      {
        com.lantern.feed.c.a.a("reddot", "", paramView.a());
        Object localObject = Message.obtain();
        ((Message)localObject).what = 128403;
        ((Message)localObject).obj = paramView.a();
        c.dispatch((Message)localObject);
        localObject = new HashMap();
        ((HashMap)localObject).put("id", paramView.a());
        ((HashMap)localObject).put("pos", String.valueOf(i));
        if (!TextUtils.isEmpty(WkFeedTabLabel.c(WkFeedTabLabel.this))) {
          ((HashMap)localObject).put("tabId", WkFeedTabLabel.c(WkFeedTabLabel.this));
        }
        paramView = localbx.b();
        if (paramView != null) {
          ((HashMap)localObject).put("notice", String.valueOf(paramView.b()));
        }
        com.lantern.analytics.a.e().onEvent("dtabcli", new JSONObject((Map)localObject).toString());
        break;
        label246:
        localObject = new Intent("wifi.intent.action.FEEDCHANNEL");
        ((Intent)localObject).putExtra("extra_channel_id", paramView.a());
        ((Intent)localObject).putExtra("extra_channel_title", paramView.b());
        ((Intent)localObject).setPackage(WkFeedTabLabel.h(WkFeedTabLabel.this).getPackageName());
        ((Intent)localObject).addFlags(268435456);
        e.a(WkFeedTabLabel.h(WkFeedTabLabel.this), (Intent)localObject);
      }
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt4 = getChildCount();
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt1 < paramInt4)
      {
        bx localbx = (bx)getChildAt(paramInt1);
        paramInt3 = localbx.getMeasuredWidth() + paramInt2;
        getChildAt(paramInt1).layout(paramInt2, 0, paramInt3, getHeight());
        if ((WkFeedTabLabel.a(WkFeedTabLabel.this) != null) && (!WkFeedTabLabel.a(WkFeedTabLabel.this).c()) && (!localbx.a().e()) && (WkFeedTabLabel.a(WkFeedTabLabel.this, localbx.getLeft(), localbx.getRight())))
        {
          localbx.a().f();
          if (!TextUtils.isEmpty(WkFeedTabLabel.c(WkFeedTabLabel.this))) {
            break label146;
          }
          m.a().a(localbx.a());
        }
        for (;;)
        {
          paramInt1++;
          paramInt2 = paramInt3;
          break;
          label146:
          com.lantern.feed.channel.a.a.a().a(localbx.a());
        }
      }
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 0;
      super.onMeasure(paramInt1, paramInt2);
      int n = View.MeasureSpec.getSize(paramInt2);
      int i1 = getChildCount();
      int m;
      int j;
      if (i1 > 0)
      {
        m = d.a(getContext(), 23.0F);
        int i2 = m * i1;
        i = 0;
        paramInt1 = 0;
        for (;;)
        {
          j = paramInt1;
          if (i >= i1) {
            break;
          }
          paramInt1 += getChildAt(i).getMeasuredWidth();
          j = paramInt1;
          if (paramInt1 + i2 > WkFeedTabLabel.d(WkFeedTabLabel.this)) {
            break;
          }
          i++;
        }
        if (j + i2 >= WkFeedTabLabel.d(WkFeedTabLabel.this)) {
          break label221;
        }
      }
      label221:
      for (int i = (WkFeedTabLabel.d(WkFeedTabLabel.this) - j) / i1;; i = m)
      {
        paramInt1 = 0;
        for (j = k; j < i1; j++)
        {
          k = getChildAt(j).getMeasuredWidth();
          getChildAt(j).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(k + i), 1073741824), paramInt2);
          paramInt1 += getChildAt(j).getMeasuredWidth();
        }
        if (paramInt1 > WkFeedTabLabel.d(WkFeedTabLabel.this)) {
          paramInt1 = WkFeedTabLabel.e(WkFeedTabLabel.this).getMeasuredWidth() + paramInt1;
        }
        for (;;)
        {
          setMeasuredDimension(paramInt1, n);
          return;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedTabLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */