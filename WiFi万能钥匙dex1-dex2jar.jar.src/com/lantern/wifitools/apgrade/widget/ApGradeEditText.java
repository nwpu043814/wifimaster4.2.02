package com.lantern.wifitools.apgrade.widget;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;

public class ApGradeEditText
  extends FrameLayout
{
  TextWatcher a = new a(this);
  private View b;
  private EditText c;
  private TextView d;
  private CharSequence e = "";
  
  public ApGradeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = LayoutInflater.from(paramContext).inflate(R.layout.wifitools_apgrade_edittext_layout, this);
    this.c = ((EditText)this.b.findViewById(R.id.apgrade_edittext));
    this.d = ((TextView)this.b.findViewById(R.id.count_text));
    this.c.addTextChangedListener(this.a);
  }
  
  public final String a()
  {
    return this.c.getText().toString();
  }
  
  public final void a(String paramString)
  {
    this.c.setText(paramString);
    if (paramString != null) {
      this.c.setSelection(paramString.length());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/widget/ApGradeEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */