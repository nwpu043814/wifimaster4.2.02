package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

final class d
  extends f
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final boolean a()
  {
    return true;
  }
  
  protected final String b()
  {
    try
    {
      Log.i("MID", "read mid from sharedPreferences");
      String str = PreferenceManager.getDefaultSharedPreferences(this.e).getString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void b(String paramString)
  {
    try
    {
      Log.i("MID", "write mid to sharedPreferences");
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.e).edit();
      localEditor.putString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */