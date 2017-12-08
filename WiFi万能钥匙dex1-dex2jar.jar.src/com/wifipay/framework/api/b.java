package com.wifipay.framework.api;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.wifipay.common.a.g;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPCheckBox.OnCheckListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class b
  implements TextWatcher, WPCheckBox.OnCheckListener
{
  private List<TextView> a = new CopyOnWriteArrayList();
  private Set<View> b = new HashSet();
  private Set<WPCheckBox> c = new HashSet();
  
  private void b()
  {
    boolean bool2 = false;
    if ((this.a == null) || (this.a.size() == 0) || (this.b == null) || (this.b.size() == 0)) {
      return;
    }
    boolean bool3 = true;
    Iterator localIterator = this.a.iterator();
    do
    {
      bool1 = bool3;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!g.b(((TextView)localIterator.next()).getText().toString()));
    boolean bool1 = false;
    if (bool1)
    {
      localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (!((WPCheckBox)localIterator.next()).a()) {
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setEnabled(bool1);
      }
      break;
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setEnabled(false);
      this.b.add(paramView);
      b();
    }
  }
  
  public void a(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      paramEditText.addTextChangedListener(this);
      this.a.add(paramEditText);
      b();
    }
  }
  
  public void a(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      this.a.add(paramTextView);
      b();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    b();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onChecked(boolean paramBoolean)
  {
    b();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */