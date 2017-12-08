package com.analysis.model.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class c
  extends b
{
  public c(Context paramContext)
  {
    this.g = com.analysis.common.c.c();
    this.h = "android";
    this.i = com.analysis.common.c.d();
    this.j = com.analysis.common.c.c(paramContext);
    this.k = com.analysis.common.c.j(paramContext);
    this.l = com.analysis.common.c.b();
    this.m = com.analysis.common.c.a();
    this.n = Build.BRAND;
    this.o = Build.MODEL;
    this.p = com.analysis.common.c.n(paramContext);
    this.q = com.analysis.common.c.m(paramContext);
    paramContext = paramContext.getSharedPreferences("sp_general_config", 0);
    this.s = paramContext.getString("session_id", "null");
    this.t = paramContext.getString("login_name", "null");
    this.u = paramContext.getString("app_1d", "null");
  }
  
  public static String a(Throwable paramThrowable)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramThrowable == null) {
      paramThrowable = (Throwable)localObject1;
    }
    for (;;)
    {
      return paramThrowable;
      localObject1 = localObject2;
      try
      {
        StringWriter localStringWriter = new java/io/StringWriter;
        localObject1 = localObject2;
        localStringWriter.<init>();
        localObject1 = localObject2;
        PrintWriter localPrintWriter = new java/io/PrintWriter;
        localObject1 = localObject2;
        localPrintWriter.<init>(localStringWriter);
        localObject1 = localObject2;
        paramThrowable.printStackTrace(localPrintWriter);
        localObject1 = localObject2;
        paramThrowable = localStringWriter.toString();
        localObject1 = paramThrowable;
        localPrintWriter.close();
        localObject1 = paramThrowable;
        localStringWriter.close();
        localObject1 = paramThrowable;
      }
      catch (IOException paramThrowable)
      {
        for (;;)
        {
          paramThrowable.printStackTrace();
        }
      }
      paramThrowable = (Throwable)localObject1;
      if (((String)localObject1).length() > 524288) {
        paramThrowable = ((String)localObject1).substring(0, 524288);
      }
    }
  }
  
  private void b(Throwable paramThrowable)
  {
    String[] arrayOfString = paramThrowable.getClass().getName().split("\\.");
    this.f = arrayOfString[(arrayOfString.length - 1)];
    this.r = a(paramThrowable);
  }
  
  public final String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/crash/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */