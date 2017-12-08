package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper
  implements View.OnTouchListener
{
  private static final int DEFAULT_ACTIVATION_DELAY = ;
  private static final int DEFAULT_EDGE_TYPE = 1;
  private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
  private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
  private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
  private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
  private static final int DEFAULT_RAMP_UP_DURATION = 500;
  private static final float DEFAULT_RELATIVE_EDGE = 0.2F;
  private static final float DEFAULT_RELATIVE_VELOCITY = 1.0F;
  public static final int EDGE_TYPE_INSIDE = 0;
  public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
  public static final int EDGE_TYPE_OUTSIDE = 2;
  private static final int HORIZONTAL = 0;
  public static final float NO_MAX = Float.MAX_VALUE;
  public static final float NO_MIN = 0.0F;
  public static final float RELATIVE_UNSPECIFIED = 0.0F;
  private static final int VERTICAL = 1;
  private int mActivationDelay;
  private boolean mAlreadyDelayed;
  private boolean mAnimating;
  private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
  private int mEdgeType;
  private boolean mEnabled;
  private boolean mExclusive;
  private float[] mMaximumEdges = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] mMaximumVelocity = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] mMinimumVelocity = { 0.0F, 0.0F };
  private boolean mNeedsCancel;
  private boolean mNeedsReset;
  private float[] mRelativeEdges = { 0.0F, 0.0F };
  private float[] mRelativeVelocity = { 0.0F, 0.0F };
  private Runnable mRunnable;
  private final ClampedScroller mScroller = new ClampedScroller();
  private final View mTarget;
  
  public AutoScrollHelper(View paramView)
  {
    this.mTarget = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int j = (int)(1575.0F * paramView.density + 0.5F);
    int i = (int)(paramView.density * 315.0F + 0.5F);
    setMaximumVelocity(j, j);
    setMinimumVelocity(i, i);
    setEdgeType(1);
    setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
    setRelativeEdges(0.2F, 0.2F);
    setRelativeVelocity(1.0F, 1.0F);
    setActivationDelay(DEFAULT_ACTIVATION_DELAY);
    setRampUpDuration(500);
    setRampDownDuration(500);
  }
  
  private void cancelTargetTouch()
  {
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    this.mTarget.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private float computeTargetVelocity(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    paramFloat1 = getEdgeValue(this.mRelativeEdges[paramInt], paramFloat2, this.mMaximumEdges[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      paramFloat1 = f1;
    }
    for (;;)
    {
      return paramFloat1;
      float f2 = this.mRelativeVelocity[paramInt];
      paramFloat2 = this.mMinimumVelocity[paramInt];
      f1 = this.mMaximumVelocity[paramInt];
      paramFloat3 = f2 * paramFloat3;
      if (paramFloat1 > 0.0F) {
        paramFloat1 = constrain(paramFloat1 * paramFloat3, paramFloat2, f1);
      } else {
        paramFloat1 = -constrain(-paramFloat1 * paramFloat3, paramFloat2, f1);
      }
    }
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {}
    for (;;)
    {
      return paramFloat3;
      if (paramFloat1 < paramFloat2) {
        paramFloat3 = paramFloat2;
      } else {
        paramFloat3 = paramFloat1;
      }
    }
  }
  
  private static int constrain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      return paramInt3;
      if (paramInt1 < paramInt2) {
        paramInt3 = paramInt2;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private float constrainEdgeValue(float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    float f1;
    if (paramFloat2 == 0.0F) {
      f1 = f2;
    }
    for (;;)
    {
      return f1;
      switch (this.mEdgeType)
      {
      default: 
        f1 = f2;
        break;
      case 0: 
      case 1: 
        f1 = f2;
        if (paramFloat1 < paramFloat2) {
          if (paramFloat1 >= 0.0F)
          {
            f1 = 1.0F - paramFloat1 / paramFloat2;
          }
          else
          {
            f1 = f2;
            if (this.mAnimating)
            {
              f1 = f2;
              if (this.mEdgeType == 1) {
                f1 = 1.0F;
              }
            }
          }
        }
        break;
      case 2: 
        f1 = f2;
        if (paramFloat1 < 0.0F) {
          f1 = paramFloat1 / -paramFloat2;
        }
        break;
      }
    }
  }
  
  private float getEdgeValue(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = 0.0F;
    paramFloat3 = constrain(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat1 = constrainEdgeValue(paramFloat4, paramFloat3);
    paramFloat2 = constrainEdgeValue(paramFloat2 - paramFloat4, paramFloat3) - paramFloat1;
    if (paramFloat2 < 0.0F) {}
    for (paramFloat1 = -this.mEdgeInterpolator.getInterpolation(-paramFloat2);; paramFloat1 = this.mEdgeInterpolator.getInterpolation(paramFloat2))
    {
      paramFloat1 = constrain(paramFloat1, -1.0F, 1.0F);
      do
      {
        return paramFloat1;
        paramFloat1 = f;
      } while (paramFloat2 <= 0.0F);
    }
  }
  
  private void requestStop()
  {
    if (this.mNeedsReset) {
      this.mAnimating = false;
    }
    for (;;)
    {
      return;
      this.mScroller.requestStop();
    }
  }
  
  private boolean shouldAnimate()
  {
    ClampedScroller localClampedScroller = this.mScroller;
    int i = localClampedScroller.getVerticalDirection();
    int j = localClampedScroller.getHorizontalDirection();
    if (((i != 0) && (canTargetScrollVertically(i))) || ((j != 0) && (canTargetScrollHorizontally(j)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void startAnimating()
  {
    if (this.mRunnable == null) {
      this.mRunnable = new ScrollAnimationRunnable(null);
    }
    this.mAnimating = true;
    this.mNeedsReset = true;
    if ((!this.mAlreadyDelayed) && (this.mActivationDelay > 0)) {
      ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, this.mActivationDelay);
    }
    for (;;)
    {
      this.mAlreadyDelayed = true;
      return;
      this.mRunnable.run();
    }
  }
  
  public abstract boolean canTargetScrollHorizontally(int paramInt);
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public boolean isExclusive()
  {
    return this.mExclusive;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.mEnabled)
    {
      bool1 = bool2;
      return bool1;
    }
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      bool1 = bool2;
      if (!this.mExclusive) {
        break;
      }
      bool1 = bool2;
      if (!this.mAnimating) {
        break;
      }
      bool1 = true;
      break;
      this.mNeedsCancel = true;
      this.mAlreadyDelayed = false;
      float f2 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), this.mTarget.getWidth());
      float f1 = computeTargetVelocity(1, paramMotionEvent.getY(), paramView.getHeight(), this.mTarget.getHeight());
      this.mScroller.setTargetVelocity(f2, f1);
      if ((!this.mAnimating) && (shouldAnimate()))
      {
        startAnimating();
        continue;
        requestStop();
      }
    }
  }
  
  public abstract void scrollTargetBy(int paramInt1, int paramInt2);
  
  public AutoScrollHelper setActivationDelay(int paramInt)
  {
    this.mActivationDelay = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEdgeType(int paramInt)
  {
    this.mEdgeType = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEnabled(boolean paramBoolean)
  {
    if ((this.mEnabled) && (!paramBoolean)) {
      requestStop();
    }
    this.mEnabled = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setExclusive(boolean paramBoolean)
  {
    this.mExclusive = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setMaximumEdges(float paramFloat1, float paramFloat2)
  {
    this.mMaximumEdges[0] = paramFloat1;
    this.mMaximumEdges[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setMaximumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMaximumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMaximumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public AutoScrollHelper setMinimumVelocity(float paramFloat1, float paramFloat2)
  {
    this.mMinimumVelocity[0] = (paramFloat1 / 1000.0F);
    this.mMinimumVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public AutoScrollHelper setRampDownDuration(int paramInt)
  {
    this.mScroller.setRampDownDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRampUpDuration(int paramInt)
  {
    this.mScroller.setRampUpDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRelativeEdges(float paramFloat1, float paramFloat2)
  {
    this.mRelativeEdges[0] = paramFloat1;
    this.mRelativeEdges[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setRelativeVelocity(float paramFloat1, float paramFloat2)
  {
    this.mRelativeVelocity[0] = (paramFloat1 / 1000.0F);
    this.mRelativeVelocity[1] = (paramFloat2 / 1000.0F);
    return this;
  }
  
  private static class ClampedScroller
  {
    private long mDeltaTime = 0L;
    private int mDeltaX = 0;
    private int mDeltaY = 0;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime = Long.MIN_VALUE;
    private long mStopTime = -1L;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;
    
    private float getValueAt(long paramLong)
    {
      float f1 = 0.0F;
      if (paramLong < this.mStartTime) {}
      for (;;)
      {
        return f1;
        if ((this.mStopTime < 0L) || (paramLong < this.mStopTime))
        {
          f1 = AutoScrollHelper.constrain((float)(paramLong - this.mStartTime) / this.mRampUpDuration, 0.0F, 1.0F) * 0.5F;
        }
        else
        {
          long l = this.mStopTime;
          float f2 = this.mStopValue;
          f1 = this.mStopValue;
          f1 = AutoScrollHelper.constrain((float)(paramLong - l) / this.mEffectiveRampDown, 0.0F, 1.0F) * f1 + (1.0F - f2);
        }
      }
    }
    
    private float interpolateValue(float paramFloat)
    {
      return -4.0F * paramFloat * paramFloat + 4.0F * paramFloat;
    }
    
    public void computeScrollDelta()
    {
      if (this.mDeltaTime == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l2 = AnimationUtils.currentAnimationTimeMillis();
      float f = interpolateValue(getValueAt(l2));
      long l1 = l2 - this.mDeltaTime;
      this.mDeltaTime = l2;
      this.mDeltaX = ((int)((float)l1 * f * this.mTargetVelocityX));
      this.mDeltaY = ((int)((float)l1 * f * this.mTargetVelocityY));
    }
    
    public int getDeltaX()
    {
      return this.mDeltaX;
    }
    
    public int getDeltaY()
    {
      return this.mDeltaY;
    }
    
    public int getHorizontalDirection()
    {
      return (int)(this.mTargetVelocityX / Math.abs(this.mTargetVelocityX));
    }
    
    public int getVerticalDirection()
    {
      return (int)(this.mTargetVelocityY / Math.abs(this.mTargetVelocityY));
    }
    
    public boolean isFinished()
    {
      if ((this.mStopTime > 0L) && (AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public void requestStop()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.mEffectiveRampDown = AutoScrollHelper.constrain((int)(l - this.mStartTime), 0, this.mRampDownDuration);
      this.mStopValue = getValueAt(l);
      this.mStopTime = l;
    }
    
    public void setRampDownDuration(int paramInt)
    {
      this.mRampDownDuration = paramInt;
    }
    
    public void setRampUpDuration(int paramInt)
    {
      this.mRampUpDuration = paramInt;
    }
    
    public void setTargetVelocity(float paramFloat1, float paramFloat2)
    {
      this.mTargetVelocityX = paramFloat1;
      this.mTargetVelocityY = paramFloat2;
    }
    
    public void start()
    {
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStopTime = -1L;
      this.mDeltaTime = this.mStartTime;
      this.mStopValue = 0.5F;
      this.mDeltaX = 0;
      this.mDeltaY = 0;
    }
  }
  
  private class ScrollAnimationRunnable
    implements Runnable
  {
    private ScrollAnimationRunnable() {}
    
    public void run()
    {
      if (!AutoScrollHelper.this.mAnimating) {}
      for (;;)
      {
        return;
        if (AutoScrollHelper.this.mNeedsReset)
        {
          AutoScrollHelper.access$202(AutoScrollHelper.this, false);
          AutoScrollHelper.this.mScroller.start();
        }
        AutoScrollHelper.ClampedScroller localClampedScroller = AutoScrollHelper.this.mScroller;
        if ((localClampedScroller.isFinished()) || (!AutoScrollHelper.this.shouldAnimate()))
        {
          AutoScrollHelper.access$102(AutoScrollHelper.this, false);
        }
        else
        {
          if (AutoScrollHelper.this.mNeedsCancel)
          {
            AutoScrollHelper.access$502(AutoScrollHelper.this, false);
            AutoScrollHelper.this.cancelTargetTouch();
          }
          localClampedScroller.computeScrollDelta();
          int i = localClampedScroller.getDeltaX();
          int j = localClampedScroller.getDeltaY();
          AutoScrollHelper.this.scrollTargetBy(i, j);
          ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/AutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */