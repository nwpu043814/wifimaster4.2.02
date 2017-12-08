package com.lantern.core.g;

import android.text.TextUtils;
import com.lantern.core.d.b.a;
import java.io.File;

final class h
  implements b.a
{
  h(g paramg, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (!g.a(paramString, this.a)) {
        paramString.delete();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */