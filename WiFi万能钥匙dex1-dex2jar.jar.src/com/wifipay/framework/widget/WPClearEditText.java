package com.wifipay.framework.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.wifipay.R.drawable;
import com.wifipay.common.a.b;

public class WPClearEditText
  extends EditText
{
  private Drawable a;
  private Drawable b;
  private InputMethodManager c = (InputMethodManager)getContext().getSystemService("input_method");
  private final View.OnFocusChangeListener d = new e(this);
  private final TextWatcher e = new f(this);
  private View.OnLongClickListener f = new g(this);
  
  public WPClearEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public WPClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    requestFocus();
  }
  
  private Drawable a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("getCompoundDrawable() who invaild!");
    }
    return getCompoundDrawables()[paramInt];
  }
  
  private void a(Context paramContext)
  {
    int k = getPaddingLeft();
    int j = getPaddingRight();
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i = j;
    if (j == 0) {
      i = k;
    }
    j = i;
    if (i == 0) {
      j = b.a(paramContext, 20.0F);
    }
    this.a = a(2);
    if (this.a == null) {
      this.a = getResources().getDrawable(R.drawable.wifipay_framework_edit_clear);
    }
    this.a.setBounds(0, 0, this.a.getIntrinsicWidth(), this.a.getIntrinsicHeight());
    this.b = a(0);
    if (this.b != null) {
      this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
    }
    setCompoundDrawablePadding(b.a(paramContext, 20.0F));
    setPadding(k, m, j, n);
    a(true, false);
    setOnFocusChangeListener(this.d);
    addTextChangedListener(this.e);
    setOnLongClickListener(this.f);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable2 = null;
    if (paramBoolean1) {}
    for (Drawable localDrawable1 = this.b;; localDrawable1 = null)
    {
      if (paramBoolean2) {
        localDrawable2 = this.a;
      }
      setCompoundDrawables(localDrawable1, a(1), localDrawable2, a(3));
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (((paramMotionEvent.getAction() & 0xFF) == 1) && (a(2) != null))
    {
      float f1 = paramMotionEvent.getX();
      if ((f1 >= getWidth()) || (f1 <= getWidth() - getCompoundDrawablePadding() - getCompoundPaddingRight())) {
        break label103;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        requestFocusFromTouch();
        setText("");
        if (!this.c.isActive()) {
          this.c.showSoftInput(this, 2);
        }
        setPressed(false);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
      label103:
      i = 0;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    a(true, paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPClearEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */