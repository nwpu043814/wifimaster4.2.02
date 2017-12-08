package com.lantern.settings.b;

import android.net.Uri;
import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.n;
import com.lantern.core.o;

public final class e
{
  public static final String a(String paramString)
  {
    return n.a(paramString, "ajdgakldsiayweqd", "j#bd0@vposj!3jnv");
  }
  
  public static final boolean a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.indexOf("-") != -1))
    {
      localObject = paramString.split("-");
      if ((localObject != null) && (localObject.length == 2) && (!TextUtils.isEmpty(localObject[1]))) {
        paramString = localObject[1];
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString != null)
      {
        localObject = paramString;
        if (paramString.length() >= 8) {
          localObject = paramString.substring(0, paramString.length() - 8) + "****" + paramString.substring(paramString.length() - 4);
        }
      }
      return (String)localObject;
    }
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = n.a(Uri.encode(paramString.trim(), "UTF-8"), c.getServer().l(), c.getServer().m());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */