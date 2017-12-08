package com.analysis.common.upload;

import android.content.Context;
import android.content.SharedPreferences;

public final class m
{
  private static final String a = "success_request";
  private static final String b = "fail_request";
  private static final String c = "last_request_time";
  private static final String d = "first_request_time";
  private Context e;
  private int f;
  private int g;
  private long h;
  private long i;
  
  public m(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("sp_general_config", 0);
    this.f = paramContext.getInt("success_request", 0);
    this.g = paramContext.getInt("fail_request", 0);
    this.h = paramContext.getLong("last_request_time", 0L);
    this.i = paramContext.getLong("first_request_time", 0L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */