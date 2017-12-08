package com.lantern.browser.search.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;

public class WkSearchTitleBar
  extends FrameLayout
{
  private Context a;
  private EditText b;
  private ImageView c;
  private TextView d;
  private boolean e;
  
  public WkSearchTitleBar(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public WkSearchTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public WkSearchTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b()
  {
    inflate(this.a, R.layout.search_titlebar, this);
    this.b = ((EditText)findViewById(R.id.searchEditText));
    this.b.addTextChangedListener(new h(this));
    this.b.setOnFocusChangeListener(new i(this));
    this.b.setOnEditorActionListener(new j(this));
    this.c = ((ImageView)findViewById(R.id.searchDel));
    this.c.setOnClickListener(new k(this));
    this.d = ((TextView)findViewById(R.id.searchStart));
    this.d.setOnTouchListener(new l(this));
    this.d.setOnClickListener(new m(this));
  }
  
  private void c()
  {
    try
    {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
  }
  
  public final void a()
  {
    setFocusable(true);
    setFocusableInTouchMode(true);
    c();
    this.b.clearFocus();
  }
  
  public final void a(String paramString)
  {
    if (!paramString.equals(this.b.getText().toString().trim()))
    {
      this.b.setText(paramString);
      this.b.setSelection(this.b.length());
    }
  }
  
  public final void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setHint(paramString);
      this.d.setTextColor(-1);
      this.e = true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchTitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */