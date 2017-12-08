package bluefay.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class CheckedTextView
  extends android.widget.CheckedTextView
{
  private static final int[] a = { 16842912 };
  private Drawable b;
  private boolean c;
  
  public CheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.b != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.b.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public boolean isChecked()
  {
    return this.c;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.b != null) {
      this.b.jumpToCurrentState();
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null)
    {
      super.onDraw(paramCanvas);
      return;
    }
    int k = getPaddingLeft();
    int i = getPaddingTop();
    int j = this.b.getIntrinsicHeight();
    if ((this.b.getCurrent() instanceof NinePatchDrawable)) {
      j = getHeight() - i - getPaddingBottom();
    }
    switch (getGravity() & 0x70)
    {
    }
    for (;;)
    {
      this.b.setBounds(k, i, this.b.getIntrinsicWidth() + k, j + i);
      this.b.draw(paramCanvas);
      paramCanvas.save();
      paramCanvas.translate(this.b.getIntrinsicWidth() + 10, 0.0F);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      break;
      i = (getHeight() - j) / 2;
      continue;
      i = getHeight() - j;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(CheckedTextView.class.getName());
    paramAccessibilityEvent.setChecked(this.c);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(CheckedTextView.class.getName());
    paramAccessibilityNodeInfo.setCheckable(true);
    paramAccessibilityNodeInfo.setChecked(this.c);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b != null)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      paramInt2 = getMeasuredWidth();
      int i = getMeasuredHeight();
      paramInt1 = paramInt2;
      if (j != 1073741824) {
        paramInt1 = paramInt2 + this.b.getIntrinsicWidth() + 10;
      }
      setMeasuredDimension(paramInt1, i);
    }
  }
  
  public void setCheckMarkDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (this.b != null)
      {
        this.b.setCallback(null);
        unscheduleDrawable(this.b);
      }
      paramDrawable.setCallback(this);
      paramDrawable.setState(getDrawableState());
      if (getVisibility() == 0) {
        break label83;
      }
    }
    label83:
    for (boolean bool = false;; bool = true)
    {
      paramDrawable.setVisible(bool, false);
      this.b = paramDrawable;
      this.b.setState(null);
      setMinHeight(this.b.getIntrinsicHeight());
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void toggle()
  {
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/widget/CheckedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */