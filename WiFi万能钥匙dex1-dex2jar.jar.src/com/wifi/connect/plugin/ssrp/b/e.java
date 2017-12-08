package com.wifi.connect.plugin.ssrp.b;

import android.content.Context;
import android.text.TextUtils;
import com.bluefay.b.a;
import com.bluefay.b.b;
import com.bluefay.b.h;
import com.bluefay.b.i;
import java.io.File;

public final class e
{
  private static e c;
  private boolean a = false;
  private File b;
  private a d = new f(this);
  
  private e(Context paramContext)
  {
    this.b = new File(paramContext.getFilesDir(), "dialogbg");
    if (!this.b.exists()) {
      this.b.mkdir();
    }
  }
  
  public static e a(Context paramContext)
  {
    if (c == null) {
      c = new e(paramContext);
    }
    return c;
  }
  
  private File b(String paramString)
  {
    String str = String.format("%s.%s", new Object[] { b.d(paramString), b.b(paramString) });
    File localFile = new File(this.b, str);
    paramString = localFile;
    if (!localFile.exists()) {
      paramString = new File(this.b, str);
    }
    return paramString;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    int i = 1;
    paramString1 = b(paramString1).getAbsolutePath();
    String str = i.a(new File(paramString1));
    if (str.equals(paramString2.toUpperCase())) {}
    for (;;)
    {
      if (i == 0) {
        paramString1 = null;
      }
      h.a("getImagePath file:" + paramString1, new Object[0]);
      return paramString1;
      h.b("file sign:%s expect:%s", new Object[] { str, paramString2 });
      i = 0;
    }
  }
  
  public final void a(String paramString)
  {
    if (this.a) {}
    for (;;)
    {
      return;
      String str = b(paramString).getAbsolutePath();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)))
      {
        this.a = true;
        new g(paramString, str, this.d).execute(new String[0]);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */