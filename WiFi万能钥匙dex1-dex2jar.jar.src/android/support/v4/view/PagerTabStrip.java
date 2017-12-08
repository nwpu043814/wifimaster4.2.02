package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private static final int FULL_UNDERLINE_HEIGHT = 1;
  private static final int INDICATOR_HEIGHT = 3;
  private static final int MIN_PADDING_BOTTOM = 6;
  private static final int MIN_STRIP_HEIGHT = 32;
  private static final int MIN_TEXT_SPACING = 64;
  private static final int TAB_PADDING = 16;
  private static final int TAB_SPACING = 32;
  private static final String TAG = "PagerTabStrip";
  private boolean mDrawFullUnderline = false;
  private boolean mDrawFullUnderlineSet = false;
  private int mFullUnderlineHeight;
  private boolean mIgnoreTap;
  private int mIndicatorColor = this.mTextColor;
  private int mIndicatorHeight;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private int mMinPaddingBottom;
  private int mMinStripHeight;
  private int mMinTextSpacing;
  private int mTabAlpha = 255;
  private int mTabPadding;
  private final Paint mTabPaint = new Paint();
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTabPaint.setColor(this.mIndicatorColor);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mIndicatorHeight = ((int)(3.0F * f + 0.5F));
    this.mMinPaddingBottom = ((int)(6.0F * f + 0.5F));
    this.mMinTextSpacing = ((int)(64.0F * f));
    this.mTabPadding = ((int)(16.0F * f + 0.5F));
    this.mFullUnderlineHeight = ((int)(1.0F * f + 0.5F));
    this.mMinStripHeight = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.mPrevText.setFocusable(true);
    this.mPrevText.setOnClickListener(new PagerTabStrip.1(this));
    this.mNextText.setFocusable(true);
    this.mNextText.setOnClickListener(new PagerTabStrip.2(this));
    if (getBackground() == null) {
      this.mDrawFullUnderline = true;
    }
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.mDrawFullUnderline;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.mMinStripHeight);
  }
  
  public int getTabIndicatorColor()
  {
    return this.mIndicatorColor;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    int m = this.mCurrText.getLeft();
    int n = this.mTabPadding;
    int j = this.mCurrText.getRight();
    int k = this.mTabPadding;
    int i = this.mIndicatorHeight;
    this.mTabPaint.setColor(this.mTabAlpha << 24 | this.mIndicatorColor & 0xFFFFFF);
    paramCanvas.drawRect(m - n, i1 - i, j + k, i1, this.mTabPaint);
    if (this.mDrawFullUnderline)
    {
      this.mTabPaint.setColor(0xFF000000 | this.mIndicatorColor & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i1 - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), i1, this.mTabPaint);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.mIgnoreTap)) {
      return bool;
    }
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      bool = true;
      break;
      this.mInitialMotionX = f2;
      this.mInitialMotionY = f1;
      this.mIgnoreTap = false;
      continue;
      if ((Math.abs(f2 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f1 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.mIgnoreTap = true;
        continue;
        if (f2 < this.mCurrText.getLeft() - this.mTabPadding) {
          this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
        } else if (f2 > this.mCurrText.getRight() + this.mTabPadding) {
          this.mPager.setCurrentItem(this.mPager.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.mDrawFullUnderlineSet) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.mDrawFullUnderline = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.mDrawFullUnderlineSet) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.mDrawFullUnderline = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.mDrawFullUnderlineSet) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.mDrawFullUnderline = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.mDrawFullUnderline = paramBoolean;
    this.mDrawFullUnderlineSet = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.mMinPaddingBottom) {
      i = this.mMinPaddingBottom;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.mIndicatorColor = paramInt;
    this.mTabPaint.setColor(this.mIndicatorColor);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.mMinTextSpacing) {
      i = this.mMinTextSpacing;
    }
    super.setTextSpacing(i);
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int n = getHeight();
    int i1 = this.mCurrText.getLeft();
    int m = this.mTabPadding;
    int j = this.mCurrText.getRight();
    int i = this.mTabPadding;
    int k = n - this.mIndicatorHeight;
    localRect.set(i1 - m, k, j + i, n);
    super.updateTextPositions(paramInt, paramFloat, paramBoolean);
    this.mTabAlpha = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.mCurrText.getLeft() - this.mTabPadding, k, this.mCurrText.getRight() + this.mTabPadding, n);
    invalidate(localRect);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/PagerTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */