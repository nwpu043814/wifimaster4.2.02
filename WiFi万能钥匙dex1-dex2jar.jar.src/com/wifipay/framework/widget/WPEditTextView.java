package com.wifipay.framework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.styleable;
import com.wifipay.common.a.g;
import java.lang.ref.WeakReference;

public class WPEditTextView
  extends WPLinearLayout
{
  private static final InputFilter[] a = new InputFilter[0];
  private TextView b;
  private EditText c;
  
  public WPEditTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WPEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    setOrientation(1);
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.wifipay_framework_edit_text_view, this, true);
    this.b = ((TextView)paramContext.findViewById(R.id.wifipay_text_view_title));
    if (2 == paramInt) {}
    for (paramInt = R.id.wifipay_view_stub_eye;; paramInt = R.id.wifipay_view_stub_clear)
    {
      this.c = ((EditText)((ViewStub)paramContext.findViewById(paramInt)).inflate());
      return;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WPEditTextView);
    a(paramContext, paramAttributeSet.getInt(R.styleable.WPEditTextView_wifipay_mode, 1));
    this.b.setText(paramAttributeSet.getText(R.styleable.WPEditTextView_wifipay_barTitle));
    paramContext = paramAttributeSet.getText(R.styleable.WPEditTextView_wifipay_barContent);
    int i;
    if (g.a(paramContext))
    {
      setHint(paramAttributeSet.getText(R.styleable.WPEditTextView_android_hint));
      i = paramAttributeSet.getInt(R.styleable.WPEditTextView_android_maxLength, -1);
      if (i < 0) {
        break label127;
      }
      this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
    }
    for (;;)
    {
      i = paramAttributeSet.getInt(R.styleable.WPEditTextView_android_inputType, 0);
      this.c.setInputType(i);
      paramAttributeSet.recycle();
      return;
      setText(paramContext);
      break;
      label127:
      this.c.setFilters(a);
    }
  }
  
  public EditText getEditText()
  {
    return this.c;
  }
  
  public String getText()
  {
    return this.c.getText().toString();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }
  
  public void setHint(int paramInt)
  {
    this.c.setHint(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    this.c.setHint(paramCharSequence);
  }
  
  public void setText(int paramInt)
  {
    this.c.setText(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void setTextChangedListener(ITextChangedListener paramITextChangedListener)
  {
    if (paramITextChangedListener != null) {
      this.c.addTextChangedListener(new a(this, paramITextChangedListener));
    }
  }
  
  public void setWPTextAppearance(int paramInt)
  {
    this.c.setTextAppearance(getContext(), paramInt);
  }
  
  public static abstract interface ITextChangedListener
  {
    public abstract void onTextChanged(WPEditTextView paramWPEditTextView, String paramString);
  }
  
  private static class a
    implements TextWatcher
  {
    private WeakReference<WPEditTextView.ITextChangedListener> a;
    private WeakReference<WPEditTextView> b;
    
    public a(WPEditTextView paramWPEditTextView, WPEditTextView.ITextChangedListener paramITextChangedListener)
    {
      this.b = new WeakReference(paramWPEditTextView);
      this.a = new WeakReference(paramITextChangedListener);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      WPEditTextView.ITextChangedListener localITextChangedListener = (WPEditTextView.ITextChangedListener)this.a.get();
      WPEditTextView localWPEditTextView = (WPEditTextView)this.b.get();
      if ((localITextChangedListener != null) && (localWPEditTextView != null)) {
        localITextChangedListener.onTextChanged(localWPEditTextView, paramEditable.toString());
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPEditTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */