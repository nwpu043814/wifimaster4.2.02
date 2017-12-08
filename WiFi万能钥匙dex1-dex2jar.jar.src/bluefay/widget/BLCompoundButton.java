package bluefay.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import com.bluefay.a.e;

public abstract class BLCompoundButton
  extends Button
  implements Checkable
{
  private static final int[] f = { 16842912 };
  private boolean a;
  private boolean b;
  private Drawable c;
  private a d;
  private a e;
  
  public BLCompoundButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BLCompoundButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BLCompoundButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "CompoundButton");
    if (localObject == null) {
      return;
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
    int i = ((Integer)e.a("com.android.internal.R$styleable", "CompoundButton_button")).intValue();
    paramInt = ((Integer)e.a("com.android.internal.R$styleable", "CompoundButton_checked")).intValue();
    paramContext = paramAttributeSet.getDrawable(i);
    if (paramContext != null) {
      if (paramContext != null)
      {
        if (this.c != null)
        {
          this.c.setCallback(null);
          unscheduleDrawable(this.c);
        }
        paramContext.setCallback(this);
        if (getVisibility() != 0) {
          break label162;
        }
      }
    }
    label162:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible(bool, false);
      this.c = paramContext;
      setMinHeight(this.c.getIntrinsicHeight());
      refreshDrawableState();
      setChecked(paramAttributeSet.getBoolean(paramInt, false));
      paramAttributeSet.recycle();
      break;
    }
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.c != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.c.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    Drawable localDrawable = this.c;
    int i = j;
    if (localDrawable != null) {
      i = j + localDrawable.getIntrinsicWidth();
    }
    return i;
  }
  
  public int getCompoundPaddingRight()
  {
    return super.getCompoundPaddingRight();
  }
  
  @ViewDebug.ExportedProperty
  public boolean isChecked()
  {
    return this.a;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.c != null) {
      this.c.jumpToCurrentState();
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, f);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.c;
    int i;
    int k;
    int j;
    if (localDrawable != null)
    {
      i = getGravity();
      k = localDrawable.getIntrinsicHeight();
      j = localDrawable.getIntrinsicWidth();
      switch (i & 0x70)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      localDrawable.setBounds(0, i, j, k + i);
      localDrawable.draw(paramCanvas);
      return;
      i = getHeight() - k;
      continue;
      i = (getHeight() - k) / 2;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(BLCompoundButton.class.getName());
    paramAccessibilityEvent.setChecked(this.a);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(BLCompoundButton.class.getName());
    paramAccessibilityNodeInfo.setCheckable(true);
    paramAccessibilityNodeInfo.setChecked(this.a);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setChecked(paramParcelable.a);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    setFreezesText(true);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = isChecked();
    return localSavedState;
  }
  
  public boolean performClick()
  {
    toggle();
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      refreshDrawableState();
      if (!this.b) {
        break label25;
      }
    }
    for (;;)
    {
      return;
      label25:
      this.b = true;
      if (this.d != null) {
        this.d.a(this.a);
      }
      if (this.e != null) {
        this.e.a(this.a);
      }
      this.b = false;
    }
  }
  
  public void toggle()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean a;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.a + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.a));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/widget/BLCompoundButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */