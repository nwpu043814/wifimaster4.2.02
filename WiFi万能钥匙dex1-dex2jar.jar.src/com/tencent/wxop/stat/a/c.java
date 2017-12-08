package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public final class c
  extends d
{
  private String a;
  private int ay;
  private int bn = 100;
  private Thread bo = null;
  
  public c(Context paramContext, int paramInt, Throwable paramThrowable, f paramf)
  {
    super(paramContext, paramInt, paramf);
    a(99, paramThrowable);
  }
  
  public c(Context paramContext, int paramInt, Throwable paramThrowable, Thread paramThread)
  {
    super(paramContext, paramInt, null);
    a(2, paramThrowable);
    this.bo = paramThread;
  }
  
  private void a(int paramInt, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      this.a = localStringWriter.toString();
      this.ay = paramInt;
      localPrintWriter.close();
    }
  }
  
  public final e ac()
  {
    return e.bz;
  }
  
  public final boolean b(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "er", this.a);
    paramJSONObject.put("ea", this.ay);
    if ((this.ay == 2) || (this.ay == 3)) {
      new com.tencent.wxop.stat.b.d(this.bv).a(paramJSONObject, this.bo);
    }
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */