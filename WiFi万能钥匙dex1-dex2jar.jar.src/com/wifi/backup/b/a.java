package com.wifi.backup.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class a
{
  private SharedPreferences a;
  private String b = "privateList";
  private String c = "saveTime";
  
  public a(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("BACKUPLIST", 0);
  }
  
  public final String a()
  {
    return this.a.getString(this.c, "");
  }
  
  public final void a(String paramString)
  {
    this.a.edit().putString(this.c, paramString).commit();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */