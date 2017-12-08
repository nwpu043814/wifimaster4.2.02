package com.bluefay.widget;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bluefay.app.t;
import com.bluefay.a.c;
import com.bluefay.b.h;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;

public class ActionBottomBarView
  extends RelativeLayout
{
  private Button a;
  private Button b;
  private LinearLayout c;
  private b d;
  private boolean e;
  private ObjectAnimator f;
  private ObjectAnimator g;
  private boolean h = true;
  private View.OnClickListener i = new a(this);
  
  public ActionBottomBarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ActionBottomBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = ((Button)LayoutInflater.from(getContext()).inflate(R.layout.framework_bottom_bar_button, this, false));
    this.a.setOnClickListener(this.i);
    paramContext = new RelativeLayout.LayoutParams(-2, -1);
    paramContext.addRule(9);
    addView(this.a, paramContext);
    this.c = ((LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.framework_bottom_bar_menu, this, false));
    paramContext = new RelativeLayout.LayoutParams(-2, -1);
    paramContext.addRule(13);
    this.h = c.a();
    if (this.h)
    {
      paramAttributeSet = new LayoutTransition();
      float f1 = getContext().getResources().getDimension(R.dimen.framework_action_bottom_bar_height);
      this.f = ObjectAnimator.ofFloat(null, "translationY", new float[] { f1, 0.0F }).setDuration(paramAttributeSet.getDuration(2));
      this.g = ObjectAnimator.ofFloat(null, "translationY", new float[] { 0.0F, f1 }).setDuration(paramAttributeSet.getDuration(3));
      paramAttributeSet.setAnimator(2, this.f);
      paramAttributeSet.setAnimator(3, this.g);
      this.c.setLayoutTransition(paramAttributeSet);
    }
    addView(this.c, paramContext);
    this.b = ((Button)LayoutInflater.from(getContext()).inflate(R.layout.framework_bottom_bar_button, this, false));
    this.b.setOnClickListener(this.i);
    paramContext = new RelativeLayout.LayoutParams(-2, -1);
    paramContext.addRule(11);
    addView(this.b, paramContext);
  }
  
  private static ObjectAnimator a(View paramView)
  {
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.0F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.0F, 1.0F }) }).setDuration(300L);
  }
  
  private void a(int paramInt, MenuItem paramMenuItem)
  {
    int j = this.c.getChildCount();
    h.a("size:" + j + " index:" + paramInt, new Object[0]);
    View localView;
    ImageView localImageView;
    if ((paramInt >= 0) && (paramInt < j))
    {
      localView = this.c.getChildAt(paramInt);
      if ((localView instanceof LinearLayout))
      {
        TextView localTextView = (TextView)localView.findViewById(R.id.menu_title);
        localImageView = (ImageView)localView.findViewById(R.id.menu_icon);
        localTextView.setText(paramMenuItem.getTitle());
        localTextView.setEnabled(paramMenuItem.isEnabled());
        localImageView.setImageDrawable(paramMenuItem.getIcon());
        localImageView.setEnabled(paramMenuItem.isEnabled());
        if (!paramMenuItem.isEnabled()) {
          break label211;
        }
        localImageView.setAlpha(1.0F);
        localView.setTag(paramMenuItem);
        localView.setEnabled(paramMenuItem.isEnabled());
        if (!paramMenuItem.isVisible()) {
          break label222;
        }
      }
    }
    label211:
    label222:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      h.a("updateIconMenu:" + paramMenuItem, new Object[0]);
      return;
      localImageView.setAlpha(0.5F);
      break;
    }
  }
  
  private void a(MenuItem paramMenuItem)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.framework_bottom_bar_menu_item, this, false);
    Object localObject = (TextView)localLinearLayout.findViewById(R.id.menu_title);
    ((TextView)localObject).setText(paramMenuItem.getTitle());
    ((TextView)localObject).setEnabled(paramMenuItem.isEnabled());
    localObject = (ImageView)localLinearLayout.findViewById(R.id.menu_icon);
    ((ImageView)localObject).setImageDrawable(paramMenuItem.getIcon());
    ((ImageView)localObject).setEnabled(paramMenuItem.isEnabled());
    if (paramMenuItem.isEnabled())
    {
      ((ImageView)localObject).setAlpha(1.0F);
      localLinearLayout.setTag(paramMenuItem);
      localLinearLayout.setEnabled(paramMenuItem.isEnabled());
      if (!paramMenuItem.isVisible()) {
        break label161;
      }
    }
    label161:
    for (int j = 0;; j = 8)
    {
      localLinearLayout.setVisibility(j);
      localLinearLayout.setOnClickListener(this.i);
      this.c.addView(localLinearLayout);
      return;
      ((ImageView)localObject).setAlpha(0.5F);
      break;
    }
  }
  
  private static ObjectAnimator b(View paramView)
  {
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 0.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 0.0F }) }).setDuration(300L);
  }
  
  public final void a(t paramt)
  {
    int j = 0;
    this.a.setVisibility(8);
    if (this.h) {
      b(this.a).start();
    }
    this.b.setVisibility(8);
    if (this.h) {
      b(this.b).start();
    }
    this.c.removeAllViews();
    if (paramt != null)
    {
      int k;
      if (this.e)
      {
        k = paramt.getCount();
        MenuItem localMenuItem;
        if (k > 0)
        {
          localMenuItem = paramt.a(0);
          this.a.setText(localMenuItem.getTitle());
          this.a.setTag(localMenuItem);
          this.a.setEnabled(localMenuItem.isEnabled());
          this.a.setVisibility(0);
          if (this.h) {
            a(this.a).start();
          }
        }
        if (k > 1)
        {
          localMenuItem = paramt.a(1);
          this.b.setText(localMenuItem.getTitle());
          this.b.setTag(localMenuItem);
          this.b.setEnabled(localMenuItem.isEnabled());
          this.b.setVisibility(0);
          if (this.h) {
            a(this.b).start();
          }
        }
        if (k > 2) {
          for (j = 2; j < k; j++) {
            a(paramt.a(j));
          }
        }
      }
      else
      {
        k = paramt.getCount();
        while (j < k)
        {
          a(paramt.a(j));
          j++;
        }
      }
    }
  }
  
  public final void a(b paramb)
  {
    this.d = paramb;
  }
  
  public final void b(t paramt)
  {
    int j = 0;
    int k = 0;
    h.a("onChanged:" + paramt.getCount(), new Object[0]);
    if (this.e)
    {
      int m = paramt.getCount();
      Object localObject1;
      Object localObject2;
      if (m > 0)
      {
        localObject1 = paramt.a(0);
        this.a.setText(((MenuItem)localObject1).getTitle());
        this.a.setTag(localObject1);
        this.a.setEnabled(((MenuItem)localObject1).isEnabled());
        localObject2 = this.a;
        if (((MenuItem)localObject1).isVisible())
        {
          j = 0;
          ((Button)localObject2).setVisibility(j);
        }
      }
      else if (m > 1)
      {
        localObject2 = paramt.a(1);
        this.b.setText(((MenuItem)localObject2).getTitle());
        this.b.setTag(localObject2);
        this.b.setEnabled(((MenuItem)localObject2).isEnabled());
        localObject1 = this.b;
        if (!((MenuItem)localObject2).isVisible()) {
          break label228;
        }
      }
      label228:
      for (j = k;; j = 4)
      {
        ((Button)localObject1).setVisibility(j);
        if (m <= 2) {
          return;
        }
        for (j = 2; j < m; j++) {
          a(j - 2, paramt.a(j));
        }
        j = 4;
        break;
      }
    }
    k = paramt.getCount();
    while (j < k)
    {
      a(j, paramt.a(j));
      j++;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/ActionBottomBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */