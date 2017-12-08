package com.wifipay.framework.api;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPCheckBox.OnCheckListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class c
  implements TextWatcher, WPCheckBox.OnCheckListener
{
  private HashMap<EditText, View> a = new HashMap();
  private final Button b;
  private WPCheckBox c;
  
  public c(Button paramButton)
  {
    this.b = paramButton;
  }
  
  private void a()
  {
    boolean bool2 = true;
    Iterator localIterator = this.a.keySet().iterator();
    int i = 1;
    Object localObject;
    int j;
    if (localIterator.hasNext())
    {
      localObject = (EditText)localIterator.next();
      View localView = (View)this.a.get(localObject);
      if (localView != null)
      {
        if (TextUtils.isEmpty(((EditText)localObject).getText().toString().trim()))
        {
          j = 0;
          label79:
          localView.setVisibility(j);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(((EditText)localObject).getText().toString().trim())) {
          break label165;
        }
        i = 0;
      }
    }
    label160:
    label165:
    for (;;)
    {
      break;
      j = 8;
      break label79;
      if (this.b != null)
      {
        localObject = this.b;
        if (i == 0) {
          break label160;
        }
        bool1 = bool2;
        if (this.c != null) {
          if (!this.c.a()) {
            break label160;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((Button)localObject).setEnabled(bool1);
        return;
      }
    }
  }
  
  public void a(EditText paramEditText)
  {
    a(paramEditText, null);
  }
  
  public void a(EditText paramEditText, View paramView)
  {
    if (paramEditText != null)
    {
      paramEditText.addTextChangedListener(this);
      this.a.put(paramEditText, paramView);
    }
  }
  
  public void a(WPCheckBox paramWPCheckBox)
  {
    if (paramWPCheckBox != null)
    {
      paramWPCheckBox.setListener(this);
      this.c = paramWPCheckBox;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onChecked(boolean paramBoolean)
  {
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */