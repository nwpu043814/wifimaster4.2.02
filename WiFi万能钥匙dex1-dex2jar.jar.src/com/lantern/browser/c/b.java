package com.lantern.browser.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.core.c;

public final class b
{
  private static String a;
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(a)) {
      a = c.getInstance().getString(R.string.comment_user_name);
    }
    if (paramString1 != null)
    {
      String str = paramString1.trim();
      paramString1 = str;
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label91;
      }
      int i = paramString2.length();
      paramString1 = paramString2;
      if (i > 6) {
        paramString1 = paramString2.substring(i - 6);
      }
    }
    label91:
    for (paramString1 = a + paramString1;; paramString1 = a) {
      return paramString1;
    }
  }
  
  public static final void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {}
    for (Object localObject = paramContext.getResources().getDrawable(paramInt1);; localObject = null)
    {
      if (paramInt2 != -1) {}
      for (String str = paramContext.getResources().getString(paramInt2);; str = null)
      {
        Toast localToast = new Toast(paramContext);
        localToast.setDuration(0);
        View localView = LayoutInflater.from(paramContext).inflate(R.layout.comment_custome_toast, null);
        ImageView localImageView = (ImageView)localView.findViewById(R.id.stateImage);
        if (localObject == null)
        {
          localImageView.setVisibility(8);
          localObject = (TextView)localView.findViewById(R.id.stateText);
          if (!TextUtils.isEmpty(str)) {
            break label155;
          }
          ((TextView)localObject).setVisibility(8);
        }
        for (;;)
        {
          localToast.setView(localView);
          paramInt1 = e.a(paramContext, 80.0F);
          localToast.setGravity(17, 0, (e.a(paramContext) >> 1) - paramInt1 >> 1);
          localToast.show();
          return;
          localImageView.setImageDrawable((Drawable)localObject);
          break;
          label155:
          ((TextView)localObject).setText(str);
        }
      }
    }
  }
  
  public static final void a(Context paramContext, View paramView)
  {
    try
    {
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      paramView.requestFocus();
      paramContext.toggleSoftInput(2, 0);
      paramContext.showSoftInputFromInputMethod(paramView.getWindowToken(), 0);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = Uri.parse(paramString1).getQueryParameter(paramString2);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        h.a(paramString1);
        paramString1 = null;
      }
    }
  }
  
  public static final void b(Context paramContext, View paramView)
  {
    try
    {
      ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */