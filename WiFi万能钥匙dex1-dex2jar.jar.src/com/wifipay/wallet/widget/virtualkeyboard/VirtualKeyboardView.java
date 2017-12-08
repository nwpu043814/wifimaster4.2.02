package com.wifipay.wallet.widget.virtualkeyboard;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.wifipay.R.anim;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.logging.Logger;
import java.lang.reflect.Method;

public class VirtualKeyboardView
  extends RelativeLayout
{
  private final String a = "VirtualKeyboardView == %s";
  private GridView b;
  private RelativeLayout c;
  private a d;
  private Animation e;
  private Animation f;
  private EditText g;
  private SparseArray<String> h;
  private AdapterView.OnItemClickListener i = new b(this);
  
  public VirtualKeyboardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VirtualKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = View.inflate(paramContext, R.layout.wifipay_virtual_keyboard_layout, null);
    this.c = ((RelativeLayout)paramContext.findViewById(R.id.wifipay_keyboard_layoutBack));
    this.b = ((GridView)paramContext.findViewById(R.id.wifipay_keyboard_gv));
    setLayoutBackClick(this.c);
    this.b.setOnItemClickListener(this.i);
    c();
    a("");
    b();
    addView(paramContext);
  }
  
  private void a(String paramString)
  {
    if ((this.h != null) && (this.h.size() == 12))
    {
      this.h.put(9, paramString);
      return;
    }
    this.h = new SparseArray();
    int j = 0;
    label43:
    if (j < 12)
    {
      if (j >= 9) {
        break label75;
      }
      this.h.put(j, String.valueOf(j + 1));
    }
    for (;;)
    {
      j++;
      break label43;
      break;
      label75:
      if (j == 9) {
        this.h.put(9, paramString);
      } else if (j == 10) {
        this.h.put(10, "0");
      } else if (j == 11) {
        this.h.put(11, "");
      }
    }
  }
  
  private void a(String paramString, EditText paramEditText)
  {
    Logger.i("VirtualKeyboardView == %s", new Object[] { "resetKeyboardView  flag 1=" + paramString });
    if ((this.h != null) && (this.h.size() != 0) && (((String)this.h.get(9)).equals(paramString))) {}
    for (;;)
    {
      return;
      this.g = paramEditText;
      a(paramString);
      this.d.a(this.h);
    }
  }
  
  private void b()
  {
    this.d = new a(getContext(), this.h);
    this.b.setAdapter(this.d);
  }
  
  private void c()
  {
    this.e = AnimationUtils.loadAnimation(getContext(), R.anim.wifipay_anim_up);
    this.f = AnimationUtils.loadAnimation(getContext(), R.anim.wifipay_anim_down);
  }
  
  private void d()
  {
    String str = getEditInputString();
    if ((str.length() > 0) && (this.g != null))
    {
      int k = this.g.getSelectionStart();
      if (k != 0)
      {
        this.g.setText(str.substring(0, k - 1) + str.substring(k));
        int m = this.g.getText().length();
        int j = k;
        if (k - m >= 2) {
          j = m + 1;
        }
        this.g.setSelection(j - 1);
      }
    }
  }
  
  private void e()
  {
    if (getVisibility() != 0)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      startAnimation(getEnterAnim());
      setVisibility(0);
    }
  }
  
  private String getEditInputString()
  {
    if (this.g != null) {}
    for (String str = this.g.getText().toString().trim();; str = "") {
      return str;
    }
  }
  
  private Animation getEnterAnim()
  {
    return this.e;
  }
  
  private Animation getExitAnim()
  {
    return this.f;
  }
  
  private void setEditInput(String paramString)
  {
    int j = 0;
    String str;
    int k;
    int m;
    if ((this.g != null) && (!TextUtils.isEmpty(paramString)))
    {
      str = getEditInputString();
      k = this.g.getSelectionStart();
      m = str.length();
      if (k != 0) {
        break label98;
      }
      paramString = paramString + str;
    }
    for (;;)
    {
      this.g.setText(paramString);
      paramString = this.g.getText();
      if (j != 1) {
        break;
      }
      j = paramString.length();
      this.g.setSelection(j);
      return;
      label98:
      if (k >= m)
      {
        paramString = str + paramString;
        j = 1;
      }
      else
      {
        paramString = str.substring(0, k) + paramString + str.substring(k);
      }
    }
    if ((k == 4) || ((k > 4) && ((k - 4) % 5 == 0))) {}
    for (j = k + 1;; j = k)
    {
      j++;
      break;
    }
  }
  
  private void setInputTypeNull(EditText[] paramArrayOfEditText)
  {
    int j = 0;
    try
    {
      int k = paramArrayOfEditText.length;
      while (j < k)
      {
        paramArrayOfEditText[j].setInputType(0);
        j++;
      }
      return;
    }
    catch (Exception paramArrayOfEditText)
    {
      paramArrayOfEditText.printStackTrace();
    }
  }
  
  private void setLayoutBackClick(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnClickListener(new c(this));
  }
  
  public void a()
  {
    startAnimation(getExitAnim());
    setVisibility(8);
  }
  
  public void a(EditText paramEditText, String paramString)
  {
    this.g = paramEditText;
    paramEditText.setOnClickListener(new d(this, paramString, paramEditText));
    paramEditText.setOnFocusChangeListener(new e(this, paramString, paramEditText));
  }
  
  public void setNotUseSystemKeyBoard(EditText paramEditText)
  {
    setNotUseSystemKeyBoard(new EditText[] { paramEditText });
  }
  
  public void setNotUseSystemKeyBoard(EditText[] paramArrayOfEditText)
  {
    if ((paramArrayOfEditText == null) || (paramArrayOfEditText.length <= 0)) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT <= 10)
      {
        setInputTypeNull(paramArrayOfEditText);
        continue;
      }
      ((Activity)getContext()).getWindow().setSoftInputMode(3);
      try
      {
        Method localMethod = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
        localMethod.setAccessible(true);
        int k = paramArrayOfEditText.length;
        for (int j = 0; j < k; j++) {
          localMethod.invoke(paramArrayOfEditText[j], new Object[] { Boolean.valueOf(false) });
        }
      }
      catch (Exception localException)
      {
        setInputTypeNull(paramArrayOfEditText);
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/widget/virtualkeyboard/VirtualKeyboardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */