package com.linksure.apservice.a.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linksure.apservice.a.b.e;

public final class b
  implements e
{
  private final SharedPreferences a;
  
  public b(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public final int a(String paramString)
  {
    return this.a.getInt(paramString, 0);
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.a.edit().putInt(paramString, paramInt).commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */