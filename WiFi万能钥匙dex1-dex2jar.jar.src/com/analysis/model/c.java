package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.analysis.common.upload.o;
import java.util.Map;

public final class c
{
  private static final String a = "sp_event_trace";
  private SharedPreferences b;
  private boolean c = false;
  private o d;
  private Context e;
  
  public c(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("sp_general_config", 0);
    this.d = o.a(paramContext);
    this.e = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    paramString = new d(this.e, paramString, paramInt, paramMap, this.b.getString("session_id", "null"), this.b.getString("login_name", "null"), this.b.getString("app_1d", "null"));
    this.d.a(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */