package bluefay.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.CheckBox;
import com.bluefay.framework.R.style;
import com.bluefay.framework.R.styleable;

public class SlidingButton
  extends CheckBox
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private boolean F;
  private int G;
  private boolean H = false;
  private boolean a = false;
  private BitmapDrawable b;
  private int[] c;
  private float d = 150.0F;
  private boolean e = false;
  private long f;
  private float g;
  private int[] h;
  private long i;
  private long j;
  private Drawable k;
  private final Handler l = new b((byte)0);
  private int m;
  private int n;
  private BitmapDrawable o;
  private a p = null;
  private BitmapDrawable q;
  private int r;
  private BitmapDrawable s;
  private Drawable t;
  private Bitmap u;
  private Paint v;
  private Bitmap w;
  private Paint x;
  private BitmapDrawable y;
  private boolean z;
  
  public SlidingButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i1 = R.style.BL_Widget_SlidingButton;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlidingButton, paramInt, i1);
    setDrawingCacheEnabled(false);
    this.E = ((int)(0.5F + 6.0F * getResources().getDisplayMetrics().density));
    this.k = paramContext.getDrawable(0);
    this.y = ((BitmapDrawable)paramContext.getDrawable(1));
    this.s = ((BitmapDrawable)paramContext.getDrawable(2));
    this.q = ((BitmapDrawable)paramContext.getDrawable(3));
    this.o = ((BitmapDrawable)paramContext.getDrawable(4));
    this.G = this.k.getIntrinsicWidth();
    this.m = this.k.getIntrinsicHeight();
    this.b = this.y;
    this.D = Math.min(this.G, this.y.getIntrinsicWidth());
    this.C = 0;
    this.B = (this.G - this.D);
    this.A = this.C;
    paramAttributeSet = new TypedValue();
    paramContext.getValue(7, paramAttributeSet);
    Object localObject = new TypedValue();
    paramContext.getValue(8, (TypedValue)localObject);
    this.u = Bitmap.createScaledBitmap(((BitmapDrawable)paramContext.getDrawable(7)).getBitmap(), this.G * 2 - this.D, this.m, true);
    if ((paramAttributeSet.type == ((TypedValue)localObject).type) && (paramAttributeSet.data == ((TypedValue)localObject).data) && (paramAttributeSet.resourceId == ((TypedValue)localObject).resourceId)) {}
    for (this.w = this.u;; this.w = Bitmap.createScaledBitmap(((BitmapDrawable)paramContext.getDrawable(8)).getBitmap(), this.G * 2 - this.D, this.m, true))
    {
      this.t = paramContext.getDrawable(5);
      this.k.setBounds(0, 0, this.G, this.m);
      this.q.setBounds(0, 0, this.G, this.m);
      this.o.setBounds(0, 0, this.G, this.m);
      this.c = new int[this.G * this.m];
      localObject = ((BitmapDrawable)paramContext.getDrawable(5)).getBitmap();
      paramAttributeSet = Bitmap.createScaledBitmap((Bitmap)localObject, this.G, this.m, false);
      paramAttributeSet.getPixels(this.c, 0, this.G, 0, 0, this.G, this.m);
      if (paramAttributeSet != localObject) {
        paramAttributeSet.recycle();
      }
      this.h = new int[this.G * this.m];
      this.v = new Paint();
      this.x = new Paint();
      paramContext.recycle();
      return;
    }
  }
  
  private void a(float paramFloat)
  {
    this.e = true;
    this.g = 0.0F;
    this.d = paramFloat;
    long l1 = SystemClock.uptimeMillis();
    this.f = l1;
    this.i = (l1 + 16L);
    this.l.removeMessages(1000);
    this.l.sendMessageAtTime(this.l.obtainMessage(1000), this.i);
  }
  
  private void a(int paramInt)
  {
    if (this.w == this.u) {
      return;
    }
    this.l.removeMessages(1001);
    if (paramInt == 0) {
      this.j = SystemClock.uptimeMillis();
    }
    int i1 = paramInt;
    if (paramInt < 20)
    {
      i1 = paramInt + 1;
      paramInt = i1 * 255 / 20;
      if (isChecked()) {
        break label131;
      }
      this.v.setAlpha(paramInt);
      this.x.setAlpha(255 - paramInt);
    }
    for (;;)
    {
      this.j = (16L + this.j);
      Message localMessage = this.l.obtainMessage(1001, i1, 0);
      this.l.sendMessageAtTime(localMessage, this.j);
      invalidate();
      this.a = false;
      break;
      label131:
      this.v.setAlpha(255 - paramInt);
      this.x.setAlpha(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    for (paramInt1 = paramInt1 * paramInt2 - 1; paramInt1 >= 0; paramInt1--) {
      paramArrayOfInt[paramInt1] &= 16777215 + ((paramArrayOfInt[paramInt1] >>> 24) * (this.c[paramInt1] >>> 24) / 255 << 24);
    }
  }
  
  private void b()
  {
    a(-150.0F);
    invalidate();
  }
  
  private void b(int paramInt)
  {
    this.A += paramInt;
    if (this.A < this.C) {
      this.A = this.C;
    }
    for (;;)
    {
      invalidate();
      return;
      if (this.A > this.B) {
        this.A = this.B;
      }
    }
  }
  
  private void c()
  {
    a(150.0F);
    invalidate();
  }
  
  public final void a()
  {
    this.H = true;
  }
  
  public final void a(a parama)
  {
    this.p = parama;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isEnabled()) {
      if (isChecked()) {
        this.q.draw(paramCanvas);
      }
    }
    for (;;)
    {
      return;
      this.o.draw(paramCanvas);
      continue;
      int i1 = this.B - this.A;
      if (this.x.getAlpha() != 0)
      {
        this.w.getPixels(this.h, 0, this.G, i1, 0, this.G, this.m);
        a(this.G, this.m, this.h);
        paramCanvas.drawBitmap(this.h, 0, this.G, 0, 0, this.G, this.m, true, this.x);
        Log.d("SlidingButton", "drawSlidingBar mSlideOnPaint");
      }
      if (this.v.getAlpha() != 0)
      {
        this.u.getPixels(this.h, 0, this.G, i1, 0, this.G, this.m);
        a(this.G, this.m, this.h);
        paramCanvas.drawBitmap(this.h, 0, this.G, 0, 0, this.G, this.m, true, this.v);
        Log.d("SlidingButton", "drawSlidingBar mSlideOffPaint");
      }
      this.k.draw(paramCanvas);
      this.t.draw(paramCanvas);
      this.b.setBounds(this.A, 0, this.D + this.A, this.m);
      this.b.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.G, this.m);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!isEnabled()) {}
    while (this.H) {
      return bool;
    }
    int i1 = paramMotionEvent.getAction();
    int i3 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    paramMotionEvent = new Rect(this.A, 0, this.A + this.D, this.m);
    switch (i1)
    {
    }
    for (;;)
    {
      bool = true;
      break;
      Log.d("SlidingButton", "ACTION_DOWN");
      if (paramMotionEvent.contains(i3, i2))
      {
        this.F = true;
        this.b = this.s;
        invalidate();
      }
      for (;;)
      {
        this.n = i3;
        this.r = i3;
        this.z = false;
        break;
        this.F = false;
      }
      Log.d("SlidingButton", "ACTION_DOWN mTracking:" + this.F);
      if (this.F)
      {
        b(i3 - this.n);
        this.n = i3;
        if (Math.abs(i3 - this.r) >= this.E)
        {
          Log.d("SlidingButton", "mSliderMoved true");
          this.z = true;
          getParent().requestDisallowInterceptTouchEvent(true);
          continue;
          Log.d("SlidingButton", "ACTION_UP mTracking:" + this.F);
          if ((this.F) && (this.z)) {
            if ((this.A >= this.C) && (this.A <= this.B / 2)) {
              b();
            }
          }
          for (;;)
          {
            this.F = false;
            this.z = false;
            break;
            c();
            continue;
            if (isChecked()) {
              b();
            } else {
              c();
            }
          }
          Log.d("SlidingButton", "ACTION_UP mTracking:" + this.F);
          this.F = false;
          this.z = false;
        }
      }
    }
  }
  
  public void setButtonDrawable(Drawable paramDrawable) {}
  
  public void setChecked(boolean paramBoolean)
  {
    boolean bool = isChecked();
    Log.d("SlidingButton", "isChecked:" + bool + " set checked:" + paramBoolean);
    super.setChecked(paramBoolean);
    this.b = this.y;
    if (paramBoolean) {}
    for (this.A = this.B;; this.A = this.C)
    {
      Log.d("SlidingButton", "bDoAlphaAnimation:" + this.a);
      if (bool != paramBoolean)
      {
        if (!this.a) {
          break;
        }
        a(0);
      }
      return;
    }
    Log.d("SlidingButton", "OK1");
    if (paramBoolean)
    {
      this.x.setAlpha(255);
      this.v.setAlpha(0);
    }
    for (;;)
    {
      Log.d("SlidingButton", "OK2");
      invalidate();
      break;
      this.x.setAlpha(0);
      this.v.setAlpha(255);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  private final class b
    extends Handler
  {
    private b() {}
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        SlidingButton.b(SlidingButton.this);
        continue;
        SlidingButton.a(SlidingButton.this, paramMessage.arg1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/widget/SlidingButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */