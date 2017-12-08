package com.lantern.feed.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import org.json.JSONObject;

public final class q
{
  private String a;
  private int b;
  private boolean c;
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    String str1;
    SharedPreferences localSharedPreferences;
    Object localObject;
    if (this.c)
    {
      str1 = this.a;
      localSharedPreferences = c.getAppContext().getSharedPreferences("wkfeed", 0);
      if (!TextUtils.isEmpty(str1)) {
        localObject = localSharedPreferences.getString("transfer_reddot", "");
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>((String)localObject);
        String str2 = localJSONObject.optString(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(str2);
          ((JSONObject)localObject).put("show", 1);
          localJSONObject.put(str1, ((JSONObject)localObject).toString());
          localSharedPreferences.edit().putString("transfer_reddot", localJSONObject.toString()).apply();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */