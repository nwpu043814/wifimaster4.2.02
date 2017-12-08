package com.wifipay.common.a;

import android.widget.Button;
import android.widget.EditText;

public class g
{
  public static String a(EditText paramEditText, String paramString, Button paramButton)
  {
    if (a(paramString))
    {
      if (paramButton != null) {
        paramButton.setEnabled(false);
      }
      paramEditText = "";
    }
    for (;;)
    {
      return paramEditText;
      Object localObject = paramEditText.getEditableText();
      paramString = (String)localObject;
      if (((CharSequence)localObject).toString().contains("."))
      {
        paramString = (String)localObject;
        if (((CharSequence)localObject).length() - 1 - ((CharSequence)localObject).toString().indexOf(".") > 2)
        {
          paramString = ((CharSequence)localObject).toString().subSequence(0, ((CharSequence)localObject).toString().indexOf(".") + 3);
          paramEditText.setText(paramString);
          paramEditText.setSelection(paramString.length());
        }
      }
      localObject = paramString;
      if (paramString.toString().trim().substring(0).equals("."))
      {
        localObject = "0" + paramString;
        paramEditText.setText((CharSequence)localObject);
        paramEditText.setSelection(2);
      }
      paramString = (String)localObject;
      if (((CharSequence)localObject).toString().startsWith("0"))
      {
        paramString = (String)localObject;
        if (((CharSequence)localObject).toString().trim().length() > 1)
        {
          paramString = (String)localObject;
          if (!((CharSequence)localObject).toString().substring(1, 2).equals("."))
          {
            paramEditText.setText(((CharSequence)localObject).subSequence(0, 1));
            paramEditText.setSelection(1);
            paramString = ((CharSequence)localObject).subSequence(0, 1);
          }
        }
      }
      if (paramButton != null) {}
      try
      {
        if (100.0F * Float.valueOf(paramString.toString()).floatValue() >= 1.0F) {
          paramButton.setEnabled(true);
        }
        for (;;)
        {
          paramEditText = paramString.toString();
          break;
          paramButton.setEnabled(false);
        }
      }
      catch (Exception paramEditText)
      {
        for (;;)
        {
          paramButton.setEnabled(false);
        }
      }
    }
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramCharSequence1 == paramCharSequence2) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
      {
        int j = paramCharSequence1.length();
        if (j == paramCharSequence2.length())
        {
          if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
          {
            bool1 = paramCharSequence1.equals(paramCharSequence2);
            continue;
          }
          for (int i = 0;; i++)
          {
            bool1 = bool2;
            if (i >= j) {
              break;
            }
            if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i))
            {
              bool1 = false;
              break;
            }
          }
        }
      }
      bool1 = false;
    }
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label51;
        }
        bool1 = bool2;
        if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
          break;
        }
      }
      label51:
      bool1 = true;
    }
  }
  
  public static boolean c(CharSequence paramCharSequence)
  {
    if (!b(paramCharSequence)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */