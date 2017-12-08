package bluefay.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.bluefay.framework.R.attr;
import com.bluefay.framework.R.styleable;

public class ActionSheet
  extends Fragment
  implements View.OnClickListener
{
  private boolean g = true;
  private a h;
  private View i;
  private LinearLayout j;
  private ViewGroup k;
  private View l;
  private b m;
  private boolean n = true;
  
  private void c()
  {
    Object localObject2 = getArguments().getStringArray("other_button_titles");
    if (localObject2 != null)
    {
      int i1 = 0;
      if (i1 < localObject2.length)
      {
        Button localButton = new Button(getActivity());
        localButton.setId(i1 + 100 + 1);
        localButton.setOnClickListener(this);
        if (localObject2.length == 1)
        {
          localObject1 = this.m.f;
          localButton.setBackgroundDrawable((Drawable)localObject1);
          localButton.setText(localObject2[i1]);
          localButton.setTextColor(this.m.h);
          localButton.setTextSize(0, this.m.l);
          if (i1 <= 0) {
            break label246;
          }
          localObject1 = d();
          ((LinearLayout.LayoutParams)localObject1).topMargin = this.m.j;
          this.j.addView(localButton, (ViewGroup.LayoutParams)localObject1);
        }
        for (;;)
        {
          i1++;
          break;
          if (localObject2.length == 2) {}
          switch (i1)
          {
          default: 
            if (localObject2.length > 2) {
              if (i1 == 0) {
                localObject1 = this.m.c;
              }
            }
            break;
          case 0: 
            localObject1 = this.m.c;
            break;
          case 1: 
            localObject1 = this.m.e;
            break;
            if (i1 == localObject2.length - 1)
            {
              localObject1 = this.m.e;
              break;
            }
            localObject1 = this.m.a();
            break;
            localObject1 = null;
            break;
            label246:
            this.j.addView(localButton);
          }
        }
      }
    }
    Object localObject1 = new Button(getActivity());
    ((Button)localObject1).getPaint().setFakeBoldText(true);
    ((Button)localObject1).setTextSize(0, this.m.l);
    ((Button)localObject1).setId(100);
    ((Button)localObject1).setBackgroundDrawable(this.m.b);
    ((Button)localObject1).setText(getArguments().getString("cancel_button_title"));
    ((Button)localObject1).setTextColor(this.m.g);
    ((Button)localObject1).setOnClickListener(this);
    localObject2 = d();
    ((LinearLayout.LayoutParams)localObject2).topMargin = this.m.k;
    this.j.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.j.setBackgroundDrawable(this.m.a);
    this.j.setPadding(this.m.i, this.m.i, this.m.i, this.m.i);
  }
  
  private static LinearLayout.LayoutParams d()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 10) && (!getArguments().getBoolean("cancelable_ontouchoutside"))) {}
    for (;;)
    {
      return;
      if (!this.g)
      {
        this.g = true;
        getFragmentManager().popBackStack();
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        localFragmentTransaction.remove(this);
        localFragmentTransaction.commit();
      }
      if ((paramView.getId() != 100) && (paramView.getId() != 10))
      {
        if (this.h != null) {
          paramView.getId();
        }
        this.n = false;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject2 = (InputMethodManager)getActivity().getSystemService("input_method");
    if (((InputMethodManager)localObject2).isActive())
    {
      localObject1 = getActivity().getCurrentFocus();
      if (localObject1 != null) {
        ((InputMethodManager)localObject2).hideSoftInputFromWindow(((View)localObject1).getWindowToken(), 0);
      }
    }
    Object localObject1 = new b(getActivity());
    localObject2 = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.ActionSheet, R.attr.actionSheetStyle, 0);
    Drawable localDrawable = ((TypedArray)localObject2).getDrawable(0);
    if (localDrawable != null) {
      ((b)localObject1).a = localDrawable;
    }
    localDrawable = ((TypedArray)localObject2).getDrawable(1);
    if (localDrawable != null) {
      ((b)localObject1).b = localDrawable;
    }
    localDrawable = ((TypedArray)localObject2).getDrawable(2);
    if (localDrawable != null) {
      ((b)localObject1).c = localDrawable;
    }
    localDrawable = ((TypedArray)localObject2).getDrawable(3);
    if (localDrawable != null) {
      ((b)localObject1).d = localDrawable;
    }
    localDrawable = ((TypedArray)localObject2).getDrawable(4);
    if (localDrawable != null) {
      ((b)localObject1).e = localDrawable;
    }
    localDrawable = ((TypedArray)localObject2).getDrawable(5);
    if (localDrawable != null) {
      ((b)localObject1).f = localDrawable;
    }
    ((b)localObject1).g = ((TypedArray)localObject2).getColor(6, ((b)localObject1).g);
    ((b)localObject1).h = ((TypedArray)localObject2).getColor(7, ((b)localObject1).h);
    ((b)localObject1).i = ((int)((TypedArray)localObject2).getDimension(8, ((b)localObject1).i));
    ((b)localObject1).j = ((int)((TypedArray)localObject2).getDimension(9, ((b)localObject1).j));
    ((b)localObject1).k = ((int)((TypedArray)localObject2).getDimension(10, ((b)localObject1).k));
    ((b)localObject1).l = ((TypedArray)localObject2).getDimensionPixelSize(11, (int)((b)localObject1).l);
    ((TypedArray)localObject2).recycle();
    this.m = ((b)localObject1);
    localObject2 = new FrameLayout(getActivity());
    ((FrameLayout)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.l = new View(getActivity());
    this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.l.setBackgroundColor(Color.argb(136, 0, 0, 0));
    this.l.setId(10);
    this.l.setOnClickListener(this);
    this.j = new LinearLayout(getActivity());
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.j.setOrientation(1);
    ((FrameLayout)localObject2).addView(this.l);
    ((FrameLayout)localObject2).addView(this.j);
    this.i = ((View)localObject2);
    this.k = ((ViewGroup)getActivity().getWindow().getDecorView());
    c();
    this.k.addView(this.i);
    localObject2 = this.l;
    localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(300L);
    ((View)localObject2).startAnimation((Animation)localObject1);
    localObject1 = this.j;
    localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(200L);
    ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    Object localObject2 = this.j;
    Object localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    ((LinearLayout)localObject2).startAnimation((Animation)localObject1);
    localObject2 = this.l;
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setDuration(300L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    ((View)localObject2).startAnimation((Animation)localObject1);
    this.i.postDelayed(new a(this), 300L);
    super.onDestroyView();
  }
  
  public static abstract interface a {}
  
  private static final class b
  {
    Drawable a;
    Drawable b;
    Drawable c;
    Drawable d;
    Drawable e;
    Drawable f;
    int g;
    int h;
    int i;
    int j;
    int k;
    float l;
    private Context m;
    
    public b(Context paramContext)
    {
      this.m = paramContext;
      this.a = new ColorDrawable(0);
      this.b = new ColorDrawable(-16777216);
      paramContext = new ColorDrawable(-7829368);
      this.c = paramContext;
      this.d = paramContext;
      this.e = paramContext;
      this.f = paramContext;
      this.g = -1;
      this.h = -16777216;
      this.i = a(20);
      this.j = a(2);
      this.k = a(10);
      this.l = a(16);
    }
    
    private int a(int paramInt)
    {
      return (int)TypedValue.applyDimension(1, paramInt, this.m.getResources().getDisplayMetrics());
    }
    
    public final Drawable a()
    {
      if ((this.d instanceof StateListDrawable))
      {
        TypedArray localTypedArray = this.m.getTheme().obtainStyledAttributes(null, R.styleable.ActionSheet, R.attr.actionSheetStyle, 0);
        this.d = localTypedArray.getDrawable(3);
        localTypedArray.recycle();
      }
      return this.d;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/ActionSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */