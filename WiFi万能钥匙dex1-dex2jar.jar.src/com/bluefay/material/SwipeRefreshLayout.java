package com.bluefay.material;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout
  extends ViewGroup
{
  private static final String c = SwipeRefreshLayout.class.getSimpleName();
  private static final int[] r = { 16842766 };
  private Animation A;
  private float B;
  private boolean C;
  private int D;
  private int E;
  private boolean F;
  private Animation.AnimationListener G = new q(this);
  private final Animation H = new v(this);
  private final Animation I = new w(this);
  protected int a;
  protected int b;
  private View d;
  private a e;
  private boolean f = false;
  private int g;
  private float h = -1.0F;
  private int i;
  private int j;
  private boolean k = false;
  private float l;
  private boolean m;
  private int n = -1;
  private boolean o;
  private boolean p;
  private final DecelerateInterpolator q;
  private b s;
  private int t = -1;
  private float u;
  private i v;
  private Animation w;
  private Animation x;
  private Animation y;
  private Animation z;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.i = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.q = new DecelerateInterpolator(2.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, r);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    paramContext = getResources().getDisplayMetrics();
    this.D = ((int)(paramContext.density * 40.0F));
    this.E = ((int)(paramContext.density * 40.0F));
    this.s = new b(getContext());
    this.v = new i(getContext(), this);
    this.v.a();
    this.s.setImageDrawable(this.v);
    this.s.setVisibility(8);
    addView(this.s);
    setChildrenDrawingOrderEnabled(true);
    this.B = (paramContext.density * 64.0F);
    this.h = this.B;
  }
  
  private static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = o.a(paramMotionEvent, paramInt);
    if (paramInt < 0) {}
    for (float f1 = -1.0F;; f1 = o.c(paramMotionEvent, paramInt)) {
      return f1;
    }
  }
  
  private Animation a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if ((this.o) && (b())) {}
    for (;;)
    {
      return (Animation)localObject;
      localObject = new t(this, paramInt1, paramInt2);
      ((Animation)localObject).setDuration(300L);
      this.s.a(null);
      this.s.clearAnimation();
      this.s.startAnimation((Animation)localObject);
    }
  }
  
  private void a(float paramFloat)
  {
    if (b()) {
      a((int)(255.0F * paramFloat));
    }
    for (;;)
    {
      return;
      this.s.setScaleX(paramFloat);
      this.s.setScaleY(paramFloat);
    }
  }
  
  private void a(int paramInt)
  {
    this.s.getBackground().setAlpha(paramInt);
    this.v.setAlpha(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.s.bringToFront();
    this.s.offsetTopAndBottom(paramInt);
    this.j = this.s.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11)) {
      invalidate();
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = o.b(paramMotionEvent);
    if (o.b(paramMotionEvent, i1) == this.n) {
      if (i1 != 0) {
        break label33;
      }
    }
    label33:
    for (i1 = 1;; i1 = 0)
    {
      this.n = o.b(paramMotionEvent, i1);
      return;
    }
  }
  
  private void a(Animation.AnimationListener paramAnimationListener)
  {
    this.x = new s(this);
    this.x.setDuration(150L);
    this.s.a(paramAnimationListener);
    this.s.clearAnimation();
    this.s.startAnimation(this.x);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f != paramBoolean1)
    {
      this.C = paramBoolean2;
      c();
      this.f = paramBoolean1;
      if (!this.f) {
        break label106;
      }
      int i1 = this.j;
      Animation.AnimationListener localAnimationListener = this.G;
      this.a = i1;
      this.H.reset();
      this.H.setDuration(200L);
      this.H.setInterpolator(this.q);
      if (localAnimationListener != null) {
        this.s.a(localAnimationListener);
      }
      this.s.clearAnimation();
      this.s.startAnimation(this.H);
    }
    for (;;)
    {
      return;
      label106:
      a(this.G);
    }
  }
  
  private static boolean a(Animation paramAnimation)
  {
    if ((paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean b()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    if (this.d == null) {}
    for (int i1 = 0;; i1++) {
      if (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (!localView.equals(this.s)) {
          this.d = localView;
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private boolean d()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 14) {
      if ((this.d instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.d;
        if ((localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (this.d.getScrollY() > 0)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        bool = this.d.canScrollVertically(-1);
      }
    }
  }
  
  public final void a(a parama)
  {
    this.e = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1;
    if ((paramBoolean) && (this.f != paramBoolean))
    {
      this.f = paramBoolean;
      if (!this.F)
      {
        i1 = (int)(this.B + this.b);
        a(i1 - this.j, true);
        this.C = false;
        Animation.AnimationListener localAnimationListener = this.G;
        this.s.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
          this.v.setAlpha(255);
        }
        this.w = new r(this);
        this.w.setDuration(this.i);
        if (localAnimationListener != null) {
          this.s.a(localAnimationListener);
        }
        this.s.clearAnimation();
        this.s.startAnimation(this.w);
      }
    }
    for (;;)
    {
      return;
      i1 = (int)this.B;
      break;
      a(paramBoolean, false);
    }
  }
  
  public final boolean a()
  {
    return this.f;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.t < 0) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      return paramInt1;
      if (paramInt2 == paramInt1 - 1)
      {
        paramInt1 = this.t;
      }
      else
      {
        paramInt1 = paramInt2;
        if (paramInt2 >= this.t) {
          paramInt1 = paramInt2 + 1;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    c();
    int i1 = o.a(paramMotionEvent);
    if ((this.p) && (i1 == 0)) {
      this.p = false;
    }
    boolean bool1 = bool2;
    if (isEnabled())
    {
      bool1 = bool2;
      if (!this.p)
      {
        bool1 = bool2;
        if (!d())
        {
          if (!this.f) {
            break label75;
          }
          bool1 = bool2;
        }
      }
    }
    return bool1;
    label75:
    switch (i1)
    {
    }
    for (;;)
    {
      bool1 = this.m;
      break;
      a(this.b - this.s.getTop(), true);
      this.n = o.b(paramMotionEvent, 0);
      this.m = false;
      float f1 = a(paramMotionEvent, this.n);
      bool1 = bool2;
      if (f1 == -1.0F) {
        break;
      }
      this.l = f1;
      if (this.e != null) {
        this.e.b();
      }
      if (this.n == -1)
      {
        Log.e(c, "Got ACTION_MOVE event but don't have an active pointer id.");
        bool1 = bool2;
        break;
      }
      f1 = a(paramMotionEvent, this.n);
      bool1 = bool2;
      if (f1 == -1.0F) {
        break;
      }
      if ((f1 - this.l > this.g) && (!this.m))
      {
        this.m = true;
        this.v.setAlpha(76);
        continue;
        a(paramMotionEvent);
        continue;
        this.m = false;
        this.n = -1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt4 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    for (;;)
    {
      return;
      if (this.d == null) {
        c();
      }
      if (this.d != null)
      {
        View localView = this.d;
        paramInt2 = getPaddingLeft();
        paramInt3 = getPaddingTop();
        localView.layout(paramInt2, paramInt3, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt2, paramInt4 - getPaddingTop() - getPaddingBottom() + paramInt3);
        paramInt2 = this.s.getMeasuredWidth();
        paramInt3 = this.s.getMeasuredHeight();
        this.s.layout(paramInt1 / 2 - paramInt2 / 2, this.j, paramInt1 / 2 + paramInt2 / 2, this.j + paramInt3);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.d == null) {
      c();
    }
    if (this.d == null) {}
    label176:
    for (;;)
    {
      return;
      this.d.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.s.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
      if ((!this.F) && (!this.k))
      {
        this.k = true;
        paramInt1 = -this.s.getMeasuredHeight();
        this.b = paramInt1;
        this.j = paramInt1;
      }
      this.t = -1;
      for (paramInt1 = 0;; paramInt1++)
      {
        if (paramInt1 >= getChildCount()) {
          break label176;
        }
        if (getChildAt(paramInt1) == this.s)
        {
          this.t = paramInt1;
          break;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = o.a(paramMotionEvent);
    if ((this.p) && (i1 == 0)) {
      this.p = false;
    }
    boolean bool;
    if ((!isEnabled()) || (this.p) || (d())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      float f2;
      float f1;
      switch (i1)
      {
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        for (;;)
        {
          bool = true;
          break;
          this.n = o.b(paramMotionEvent, 0);
          this.m = false;
          continue;
          i1 = o.a(paramMotionEvent, this.n);
          if (i1 < 0)
          {
            Log.e(c, "Got ACTION_MOVE event but have an invalid active pointer id.");
            bool = false;
            break;
          }
          f2 = 0.5F * (o.c(paramMotionEvent, i1) - this.l);
          if (this.m)
          {
            this.v.a(true);
            f1 = f2 / this.h;
            if (f1 < 0.0F)
            {
              bool = false;
              break;
            }
            float f4 = Math.min(1.0F, Math.abs(f1));
            float f3 = (float)Math.max(f4 - 0.4D, 0.0D) * 5.0F / 3.0F;
            float f6 = Math.abs(f2);
            float f5 = this.h;
            label262:
            int i2;
            if (this.F)
            {
              f1 = this.B - this.b;
              f5 = Math.max(0.0F, Math.min(f6 - f5, 2.0F * f1) / f1);
              f5 = (float)(f5 / 4.0F - Math.pow(f5 / 4.0F, 2.0D)) * 2.0F;
              i1 = this.b;
              i2 = (int)(f1 * f4 + f1 * f5 * 2.0F);
              if (this.s.getVisibility() != 0) {
                this.s.setVisibility(0);
              }
              if (!this.o)
              {
                this.s.setScaleX(1.0F);
                this.s.setScaleY(1.0F);
              }
              if (f2 >= this.h) {
                break label517;
              }
              if (this.o) {
                a(f2 / this.h);
              }
              if ((this.v.b() > 76) && (!a(this.y))) {
                this.y = a(this.v.b(), 76);
              }
              this.v.b(Math.min(0.8F, 0.8F * f3));
              this.v.a(Math.min(1.0F, f3));
            }
            for (;;)
            {
              this.v.c((-0.25F + 0.4F * f3 + 2.0F * f5) * 0.5F);
              a(i2 + i1 - this.j, true);
              break;
              f1 = this.B;
              break label262;
              label517:
              if ((this.v.b() < 255) && (!a(this.z))) {
                this.z = a(this.v.b(), 255);
              }
            }
            this.n = o.b(paramMotionEvent, o.b(paramMotionEvent));
            continue;
            a(paramMotionEvent);
          }
        }
      }
      if (this.n == -1)
      {
        if (i1 == 1) {
          Log.e(c, "Got ACTION_UP event but don't have an active pointer id.");
        }
        bool = false;
      }
      else
      {
        f1 = o.c(paramMotionEvent, o.a(paramMotionEvent, this.n));
        f2 = this.l;
        this.m = false;
        if ((f1 - f2) * 0.5F <= this.h) {
          break;
        }
        a(true, true);
        this.n = -1;
        bool = false;
      }
    }
    this.f = false;
    this.v.b(0.0F);
    paramMotionEvent = null;
    if (!this.o) {
      paramMotionEvent = new u(this);
    }
    i1 = this.j;
    if (this.o)
    {
      this.a = i1;
      if (b())
      {
        this.u = this.v.b();
        label737:
        this.A = new x(this);
        this.A.setDuration(150L);
        if (paramMotionEvent != null) {
          this.s.a(paramMotionEvent);
        }
        this.s.clearAnimation();
        this.s.startAnimation(this.A);
      }
    }
    for (;;)
    {
      this.v.a(false);
      break;
      this.u = this.s.getScaleX();
      break label737;
      this.a = i1;
      this.I.reset();
      this.I.setDuration(200L);
      this.I.setInterpolator(this.q);
      if (paramMotionEvent != null) {
        this.s.a(paramMotionEvent);
      }
      this.s.clearAnimation();
      this.s.startAnimation(this.I);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */