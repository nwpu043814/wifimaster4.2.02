package com.lantern.browser.comment.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.a.e;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.c.b;
import com.lantern.browser.comment.d.i;
import com.lantern.browser.comment.d.j;
import java.util.List;

public class WkCommentFloorView
  extends LinearLayout
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static int k = 0;
  private Context l;
  private i m;
  private boolean n;
  private a o;
  
  public WkCommentFloorView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentFloorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentFloorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    int i6;
    int i3;
    int i2;
    int i5;
    label63:
    j localj;
    int i4;
    int i1;
    label101:
    Object localObject1;
    Object localObject2;
    if (this.m.d() == 0) {
      if (this.m.b().size() >= 10)
      {
        this.n = true;
        List localList = this.m.b();
        i6 = localList.size();
        int i8 = getChildCount();
        i3 = 0;
        i2 = 0;
        i5 = 0;
        if (i5 >= i6) {
          break label1732;
        }
        localj = (j)localList.get(i5);
        i4 = i5 + 1;
        if (i4 != i6) {
          break label1107;
        }
        i1 = c.a;
        if (i1 == 0) {
          break label1829;
        }
        localObject1 = null;
        if (i8 != 0) {
          localObject1 = getChildAt(i3);
        }
        localObject2 = null;
        if (localObject1 != null) {
          break label1161;
        }
        if (i1 != 0)
        {
          localObject2 = new LinearLayout(this.l);
          ((LinearLayout)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          ((LinearLayout)localObject2).setOrientation(1);
          Object localObject4 = new RelativeLayout(this.l);
          Object localObject3 = new TextView(this.l);
          ((TextView)localObject3).setGravity(17);
          ((TextView)localObject3).setTextSize(10.0F);
          ((TextView)localObject3).setTextColor(-6710887);
          ((TextView)localObject3).setIncludeFontPadding(false);
          ((TextView)localObject3).setBackgroundResource(R.drawable.news_comment_order_bg);
          ((TextView)localObject3).setId(10001);
          ((TextView)localObject3).setMinWidth(c);
          localObject1 = new RelativeLayout.LayoutParams(-2, d);
          ((RelativeLayout.LayoutParams)localObject1).setMargins(1, c, 0, 0);
          ((RelativeLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
          Object localObject5 = new TextView(this.l);
          ((TextView)localObject5).setGravity(17);
          ((TextView)localObject5).setTextSize(14.0F);
          ((TextView)localObject5).setTextColor(-6710887);
          ((TextView)localObject5).setIncludeFontPadding(false);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, ((TextView)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject1).setMargins(e, g, 0, 0);
          ((RelativeLayout)localObject4).addView((View)localObject5, (ViewGroup.LayoutParams)localObject1);
          WkCommentLikeButton localWkCommentLikeButton = new WkCommentLikeButton(this.l);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, c, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11);
          ((RelativeLayout)localObject4).addView(localWkCommentLikeButton, (ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2));
          ExpandableTextView localExpandableTextView = new ExpandableTextView(this.l);
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).setMargins(h, e, c, f);
          ((LinearLayout)localObject2).addView(localExpandableTextView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new b((byte)0);
          ((b)localObject1).e = ((View)localObject4);
          ((b)localObject1).a = ((TextView)localObject3);
          ((b)localObject1).b = ((TextView)localObject5);
          ((b)localObject1).c = localWkCommentLikeButton;
          ((b)localObject1).d = localExpandableTextView;
          localObject3 = new LinearLayout(this.l);
          ((LinearLayout)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, i));
          ((LinearLayout)localObject3).setOrientation(0);
          ((LinearLayout)localObject3).setGravity(17);
          localObject4 = new TextView(this.l);
          ((TextView)localObject4).setTextSize(14.0F);
          ((TextView)localObject4).setTextColor(-3881788);
          ((TextView)localObject4).setText(R.string.comment_click_to_open_up);
          ((TextView)localObject4).setGravity(1);
          ((TextView)localObject4).setIncludeFontPadding(false);
          ((LinearLayout)localObject3).addView((View)localObject4);
          localObject5 = new ImageView(this.l);
          ((ImageView)localObject5).setImageResource(R.drawable.news_comment_openup);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).setMargins(j, 0, 0, 0);
          ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject4);
          ((LinearLayout)localObject3).setOnClickListener(new w(this));
          ((LinearLayout)localObject2).addView((View)localObject3);
          ((b)localObject1).f = ((View)localObject3);
          localObject4 = new ExpandableTextView(this.l);
          localObject3 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
          ((LinearLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
          ((b)localObject1).g = ((ExpandableTextView)localObject4);
          ((LinearLayout)localObject2).setTag(localObject1);
          a(localj, (b)localObject1, i1);
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          addView((View)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label791:
      label952:
      int i7;
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof b))
        {
          localObject2 = (b)localObject2;
          if (i1 == c.b)
          {
            ((b)localObject2).a.setText(String.valueOf(i4));
            ((b)localObject2).b.setText(b.a(localj.c(), localj.i()));
            ((b)localObject2).c.a(localj);
            ((b)localObject2).d.a(localj.b());
            ((b)localObject2).d.a(new z(this, localj));
            ((b)localObject2).c.a(new aa(this));
            ((View)localObject1).setOnTouchListener(new ac(this, new GestureDetectorCompat(this.l, new ab(this, (b)localObject2, i4))));
          }
        }
        else
        {
          if (!this.n) {
            break label1814;
          }
          if (i4 < i6 - 1) {
            break label1801;
          }
          i7 = 5;
          i1 = 5 - (i6 - i4);
          i4 = i7;
          label983:
          if (i1 != 1) {
            break label1293;
          }
          ((ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, b, 0, 0);
          label1005:
          if (i1 != i4) {
            break label1337;
          }
          ((View)localObject1).setBackgroundDrawable(null);
          ((View)localObject1).setPadding(0, 0, 0, 0);
          label1026:
          if (((View)localObject1).getParent() == null) {
            addView((View)localObject1);
          }
          i2++;
        }
      }
      for (i1 = i3 + 1;; i1 = i3)
      {
        i5++;
        i3 = i1;
        break label63;
        this.n = false;
        break;
        if ((this.m.b().size() >= 10) && (this.m.d() == 1))
        {
          this.n = true;
          break;
        }
        this.n = false;
        break;
        label1107:
        if (this.n)
        {
          if (i4 == 3)
          {
            i1 = c.c;
            break label101;
          }
          if ((i4 < 3) || (i4 == i6 - 1))
          {
            i1 = c.b;
            break label101;
          }
          i1 = 0;
          break label101;
        }
        i1 = c.b;
        break label101;
        label1161:
        localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof b)) {
          a(localj, (b)localObject2, i1);
        }
        a((View)localObject1);
        break label791;
        if (i1 != c.a) {
          break label952;
        }
        ((b)localObject2).g.a(localj.b());
        ((b)localObject2).g.a(new ad(this, localj));
        localObject2 = new GestureDetectorCompat(this.l, new ae(this, (b)localObject2, i4));
        ((View)localObject1).setOnTouchListener(null);
        ((View)((View)localObject1).getParent().getParent()).setOnTouchListener(new af(this, (GestureDetectorCompat)localObject2));
        break label952;
        label1293:
        if (i4 == i1)
        {
          ((ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, j, 0, 0);
          break label1005;
        }
        ((ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, 0, 0, 0);
        break label1005;
        label1337:
        if (i4 > 6)
        {
          if (i1 == 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_2);
            break label1026;
          }
          if (i1 == i4 - 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_6);
            break label1026;
          }
          if (i1 == i4 - 2)
          {
            a((View)localObject1, R.drawable.news_comment_bg_5);
            break label1026;
          }
          if (i1 == i4 - 3)
          {
            a((View)localObject1, R.drawable.news_comment_bg_4);
            break label1026;
          }
          if (i1 == i4 - 4)
          {
            a((View)localObject1, R.drawable.news_comment_bg_3);
            break label1026;
          }
          if (i1 == i4 - 5)
          {
            a((View)localObject1, R.drawable.news_comment_bg_11);
            break label1026;
          }
          a((View)localObject1, R.drawable.news_comment_bg_12);
          break label1026;
        }
        if (i4 == 6)
        {
          if (i1 == 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_1);
            break label1026;
          }
          if (i1 == 2)
          {
            a((View)localObject1, R.drawable.news_comment_bg_3);
            break label1026;
          }
          if (i1 == 3)
          {
            a((View)localObject1, R.drawable.news_comment_bg_4);
            break label1026;
          }
          if (i1 == 4)
          {
            a((View)localObject1, R.drawable.news_comment_bg_5);
            break label1026;
          }
          if (i1 != 5) {
            break label1026;
          }
          a((View)localObject1, R.drawable.news_comment_bg_6);
          break label1026;
        }
        if (i4 == 5)
        {
          if (i1 == 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_7);
            break label1026;
          }
          if (i1 == 2)
          {
            a((View)localObject1, R.drawable.news_comment_bg_4);
            break label1026;
          }
          if (i1 == 3)
          {
            a((View)localObject1, R.drawable.news_comment_bg_5);
            break label1026;
          }
          if (i1 != 4) {
            break label1026;
          }
          a((View)localObject1, R.drawable.news_comment_bg_6);
          break label1026;
        }
        if (i4 == 4)
        {
          if (i1 == 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_8);
            break label1026;
          }
          if (i1 == 2)
          {
            a((View)localObject1, R.drawable.news_comment_bg_5);
            break label1026;
          }
          if (i1 != 3) {
            break label1026;
          }
          a((View)localObject1, R.drawable.news_comment_bg_6);
          break label1026;
        }
        if (i4 == 3)
        {
          if (i1 == 1)
          {
            a((View)localObject1, R.drawable.news_comment_bg_9);
            break label1026;
          }
          if (i1 != 2) {
            break label1026;
          }
          a((View)localObject1, R.drawable.news_comment_bg_6);
          break label1026;
        }
        if (i4 != 2) {
          break label1026;
        }
        a((View)localObject1, R.drawable.news_comment_bg_10);
        break label1026;
        label1732:
        if (i2 > k) {
          k = i2;
        }
        i1 = getChildCount();
        if (i1 > i2)
        {
          i1--;
          if (i1 >= i2)
          {
            localObject1 = getChildAt(i1);
            if (localObject1 != null)
            {
              if (i1 < k) {
                break label1792;
              }
              removeViewInLayout((View)localObject1);
            }
            for (;;)
            {
              i1--;
              break;
              label1792:
              b((View)localObject1);
            }
          }
        }
        return;
        label1801:
        i7 = 5;
        i1 = i4;
        i4 = i7;
        break label983;
        label1814:
        i1 = i4;
        i4 = i6;
        break label983;
      }
      label1829:
      localObject1 = null;
    }
  }
  
  private void a(Context paramContext)
  {
    this.l = paramContext;
    setOrientation(1);
    if (a == 0)
    {
      a = e.a(this.l, 46.0F);
      b = e.a(this.l, 8.0F);
      c = e.a(this.l, 16.0F);
      d = e.a(this.l, 12.0F);
      f = e.a(this.l, 7.0F);
      g = e.a(this.l, 13.0F);
      e = e.a(this.l, 6.0F);
      h = e.a(this.l, 22.0F);
      i = e.a(this.l, 42.0F);
      j = e.a(this.l, 10.0F);
    }
  }
  
  private static void a(View paramView)
  {
    if (paramView.getVisibility() != 0) {
      paramView.setVisibility(0);
    }
  }
  
  private static void a(View paramView, int paramInt)
  {
    paramView.setBackgroundResource(paramInt);
    Rect localRect = new Rect();
    paramView.getBackground().getPadding(localRect);
    paramView.setPadding(localRect.left, localRect.top, localRect.right, 0);
  }
  
  private static void a(j paramj, b paramb, int paramInt)
  {
    if (paramInt == c.b)
    {
      a(paramb.e);
      a(paramb.d);
      b(paramb.f);
      b(paramb.g);
      if (paramj.l() == 1)
      {
        paramb.d.a(Integer.MAX_VALUE);
        if (paramj.p() != 1) {
          break label81;
        }
        paramb.d.a(true);
      }
    }
    for (;;)
    {
      return;
      paramb.d.a(5);
      break;
      label81:
      paramb.d.a(false);
      continue;
      if (paramInt == c.c)
      {
        b(paramb.e);
        b(paramb.d);
        a(paramb.f);
        b(paramb.g);
      }
      else if (paramInt == c.a)
      {
        b(paramb.e);
        b(paramb.d);
        b(paramb.f);
        a(paramb.g);
        if (paramj.l() == 1) {
          paramb.g.a(Integer.MAX_VALUE);
        }
        for (;;)
        {
          if (paramj.p() != 1) {
            break label213;
          }
          paramb.g.a(true);
          break;
          paramb.g.a(5);
        }
        label213:
        paramb.g.a(false);
      }
    }
  }
  
  private static void b(View paramView)
  {
    if (paramView.getVisibility() != 8) {
      paramView.setVisibility(8);
    }
  }
  
  public final void a(i parami)
  {
    this.m = parami;
    a();
  }
  
  public final void a(a parama)
  {
    this.o = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(i parami, int paramInt);
  }
  
  private final class b
  {
    TextView a;
    TextView b;
    WkCommentLikeButton c;
    ExpandableTextView d;
    View e;
    View f;
    ExpandableTextView g;
    
    private b() {}
  }
  
  private static enum c {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentFloorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */