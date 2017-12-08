package com.bluefay.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bluefay.app.t;
import bluefay.app.u;
import bluefay.b.a;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;

public class ActionTopBarView
  extends LinearLayout
{
  private ImageButton a;
  private ImageButton b;
  private View c;
  private View d;
  private Button e;
  private ViewGroup f;
  private LinearLayout g;
  private b h;
  private int i = 3;
  private View.OnClickListener j = new c(this);
  private View.OnClickListener k = new d(this);
  
  public ActionTopBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionTopBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(R.drawable.framework_actionbar_bg_dark);
    this.a = ((ImageButton)LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_icon_button, this, false));
    paramContext = new a(16908332);
    this.a.setImageResource(R.drawable.framework_title_bar_back_button);
    this.a.setBackgroundResource(R.drawable.framework_topbar_item_bg);
    this.a.setTag(paramContext);
    this.a.setOnClickListener(this.j);
    addView(this.a);
    this.c = LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_divider, this, false);
    addView(this.c);
    this.b = ((ImageButton)LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_icon_button, this, false));
    paramContext = new a(16908310);
    this.b.setImageResource(R.drawable.framework_title_bar_close_button);
    this.b.setBackgroundResource(R.drawable.framework_topbar_item_bg);
    this.b.setTag(paramContext);
    this.b.setOnClickListener(this.j);
    addView(this.b);
    c(8);
    this.d = LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_title_button, this, false);
    this.e = ((Button)this.d.findViewById(R.id.title_panel));
    this.f = ((FrameLayout)this.d.findViewById(R.id.custom_panel));
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.weight = 1.0F;
    int m = getContext().getResources().getDimensionPixelSize(R.dimen.framework_title_padding_left);
    paramContext.leftMargin = m;
    paramContext.rightMargin = m;
    paramContext.weight = 1.0F;
    paramAttributeSet = new a(16908310);
    this.e.setTag(paramAttributeSet);
    this.e.setOnClickListener(this.j);
    addView(this.d, paramContext);
    this.g = new LinearLayout(getContext());
    addView(this.g);
  }
  
  private void a(int paramInt, MenuItem paramMenuItem)
  {
    int m = this.g.getChildCount();
    Object localObject;
    if ((paramInt >= 0) && (paramInt < m))
    {
      localObject = this.g.getChildAt(paramInt);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        ((TextView)localObject).setText(paramMenuItem.getTitle());
        ((TextView)localObject).setEnabled(paramMenuItem.isEnabled());
        ((TextView)localObject).setTag(paramMenuItem);
        if (!paramMenuItem.isVisible()) {
          break label88;
        }
      }
    }
    label88:
    for (paramInt = 0;; paramInt = 8)
    {
      ((TextView)localObject).setVisibility(paramInt);
      return;
    }
  }
  
  private void a(MenuItem paramMenuItem)
  {
    ImageButton localImageButton = (ImageButton)LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_icon_button, this, false);
    Drawable localDrawable = paramMenuItem.getIcon();
    if ((localDrawable instanceof StateListDrawable))
    {
      localImageButton.setBackgroundDrawable(null);
      localImageButton.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      localImageButton.setTag(paramMenuItem);
      localImageButton.setOnClickListener(this.j);
      this.g.addView(localImageButton);
      return;
      localImageButton.setBackgroundResource(R.drawable.framework_topbar_item_bg);
      localImageButton.setImageDrawable(localDrawable);
    }
  }
  
  private void b(int paramInt, MenuItem paramMenuItem)
  {
    int m = this.g.getChildCount();
    Object localObject;
    if ((paramInt >= 0) && (paramInt < m))
    {
      localObject = this.g.getChildAt(paramInt);
      if ((localObject instanceof ImageView))
      {
        localObject = (ImageView)localObject;
        ((ImageView)localObject).setImageDrawable(paramMenuItem.getIcon());
        ((ImageView)localObject).setEnabled(paramMenuItem.isEnabled());
        ((ImageView)localObject).setTag(paramMenuItem);
        ((ImageView)localObject).setEnabled(paramMenuItem.isEnabled());
        if (!paramMenuItem.isVisible()) {
          break label99;
        }
      }
    }
    label99:
    for (paramInt = 0;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      return;
    }
  }
  
  private void b(MenuItem paramMenuItem)
  {
    Button localButton = (Button)LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_text_button, this, false);
    localButton.setText(paramMenuItem.getTitle());
    localButton.setTag(paramMenuItem);
    localButton.setOnClickListener(this.j);
    this.g.addView(localButton);
  }
  
  public final void a()
  {
    this.e.setEnabled(false);
  }
  
  public final void a(int paramInt)
  {
    this.c.setBackgroundColor(paramInt);
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    this.e.setTextColor(paramColorStateList);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public final void a(View paramView)
  {
    if (paramView != null)
    {
      this.e.setVisibility(8);
      this.f.addView(paramView);
      this.f.setVisibility(0);
    }
  }
  
  public final void a(t paramt)
  {
    int m = 0;
    this.g.removeAllViews();
    int n;
    Object localObject1;
    u localu;
    Object localObject2;
    if (paramt != null)
    {
      n = paramt.getCount();
      if (n <= this.i) {
        break label275;
      }
      m = 0;
      if (m < this.i - 1)
      {
        localObject1 = paramt.a(m);
        if (((MenuItem)localObject1).getIcon() != null) {
          a((MenuItem)localObject1);
        }
        for (;;)
        {
          m++;
          break;
          b((MenuItem)localObject1);
        }
      }
      localObject1 = paramt.a(this.i - 1).getIcon();
      localu = new u(getContext());
      for (m = this.i; m < n; m++)
      {
        localObject2 = paramt.a(m);
        localu.add(((MenuItem)localObject2).getGroupId(), ((MenuItem)localObject2).getItemId(), ((MenuItem)localObject2).getOrder(), ((MenuItem)localObject2).getTitle()).setIcon(((MenuItem)localObject2).getIcon());
      }
      localObject2 = (ImageButton)LayoutInflater.from(getContext()).inflate(R.layout.framework_action_bar_icon_button, this, false);
      if (localObject1 != null) {
        break label318;
      }
    }
    label275:
    label309:
    label318:
    for (paramt = getResources().getDrawable(R.drawable.framework_title_bar_back_button_normal);; paramt = (t)localObject1)
    {
      if ((paramt instanceof StateListDrawable))
      {
        ((ImageButton)localObject2).setBackgroundDrawable(null);
        ((ImageButton)localObject2).setImageDrawable(paramt);
      }
      for (;;)
      {
        ((ImageButton)localObject2).setTag(localu);
        ((ImageButton)localObject2).setOnClickListener(this.k);
        this.g.addView((View)localObject2);
        return;
        ((ImageButton)localObject2).setBackgroundResource(R.drawable.framework_topbar_item_bg);
        ((ImageButton)localObject2).setImageDrawable(paramt);
      }
      if (m < n)
      {
        localObject1 = paramt.a(m);
        if (((MenuItem)localObject1).getIcon() == null) {
          break label309;
        }
        a((MenuItem)localObject1);
      }
      for (;;)
      {
        m++;
        break label275;
        break;
        b((MenuItem)localObject1);
      }
    }
  }
  
  public final void a(b paramb)
  {
    this.h = paramb;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
    if (this.a.getVisibility() == 8) {
      this.e.setPadding(30, 0, 0, 0);
    }
    for (;;)
    {
      return;
      this.e.setPadding(0, 0, 0, 0);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.b.setAlpha(1.0F);
    }
    for (;;)
    {
      return;
      this.b.setAlpha(0.5F);
    }
  }
  
  public final void b()
  {
    this.a.setEnabled(false);
  }
  
  public final void b(int paramInt)
  {
    this.c.setVisibility(paramInt);
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      paramInt = getContext().getResources().getDimensionPixelSize(R.dimen.framework_title_padding_left);
      localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.leftMargin += paramInt;
      localLayoutParams.rightMargin = (paramInt + localLayoutParams.rightMargin);
      localLayoutParams.weight = 1.0F;
      this.d.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return;
      paramInt = getContext().getResources().getDimensionPixelSize(R.dimen.framework_title_padding_left);
      localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.leftMargin -= paramInt;
      localLayoutParams.rightMargin -= paramInt;
      localLayoutParams.weight = 1.0F;
      this.d.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void b(View paramView)
  {
    if (paramView != null)
    {
      this.e.setVisibility(0);
      this.f.removeView(paramView);
      this.f.setVisibility(8);
    }
  }
  
  public final void b(t paramt)
  {
    int m = 0;
    int n = 0;
    int i1 = paramt.getCount();
    Object localObject;
    if (i1 > this.i)
    {
      m = n;
      if (m < this.i - 1)
      {
        localObject = paramt.a(m);
        if (((MenuItem)localObject).getIcon() != null) {
          b(m, (MenuItem)localObject);
        }
        for (;;)
        {
          m++;
          break;
          a(m, (MenuItem)localObject);
        }
      }
      Drawable localDrawable = paramt.a(this.i - 1).getIcon();
      localObject = new u(getContext());
      for (m = this.i; m < i1; m++)
      {
        MenuItem localMenuItem = paramt.a(m);
        ((Menu)localObject).add(localMenuItem.getGroupId(), localMenuItem.getItemId(), localMenuItem.getOrder(), localMenuItem.getTitle()).setIcon(localMenuItem.getIcon());
      }
      n = this.g.getChildCount();
      m = this.i - 1;
      if ((m >= 0) && (m < n))
      {
        paramt = this.g.getChildAt(m);
        if ((paramt instanceof ImageView))
        {
          paramt = (ImageView)paramt;
          paramt.setImageDrawable(localDrawable);
          paramt.setTag(localObject);
        }
      }
      return;
    }
    label231:
    if (m < i1)
    {
      localObject = paramt.a(m);
      if (((MenuItem)localObject).getIcon() == null) {
        break label267;
      }
      b(m, (MenuItem)localObject);
    }
    for (;;)
    {
      m++;
      break label231;
      break;
      label267:
      a(m, (MenuItem)localObject);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.a.setAlpha(1.0F);
    }
    for (;;)
    {
      return;
      this.a.setAlpha(0.5F);
    }
  }
  
  public final void c(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public final void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void e(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }
  
  public final void f(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }
  
  public final void g(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public final void h(int paramInt)
  {
    this.e.setText(paramInt);
    if (this.a.getVisibility() == 8) {
      this.e.setPadding(30, 0, 0, 0);
    }
    for (;;)
    {
      return;
      this.e.setPadding(0, 0, 0, 0);
    }
  }
  
  public final void i(int paramInt)
  {
    this.e.setTextColor(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/ActionTopBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */