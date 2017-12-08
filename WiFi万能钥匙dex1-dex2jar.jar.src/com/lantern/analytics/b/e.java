package com.lantern.analytics.b;

import android.app.ApplicationErrorReport;
import android.app.ApplicationErrorReport.AnrInfo;
import android.app.ApplicationErrorReport.CrashInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.lantern.analytics.c.b;
import com.lantern.analytics.c.c;
import com.lantern.analytics.c.d;
import com.lantern.analytics.c.f;
import com.lantern.analytics.c.h;
import com.lantern.core.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  private f a;
  private Context b;
  
  public e(Context paramContext, ApplicationErrorReport paramApplicationErrorReport)
  {
    this.b = paramContext;
    f localf = new f();
    localf.c = p.b(this.b, "");
    localf.a = paramApplicationErrorReport.type;
    localf.b = paramApplicationErrorReport.time;
    localf.f = new c();
    localf.h = new h();
    Object localObject = localf.f;
    ((c)localObject).a = Build.DEVICE;
    ((c)localObject).j = Build.DISPLAY;
    ((c)localObject).k = Build.TYPE;
    ((c)localObject).b = Build.MODEL;
    ((c)localObject).c = Build.PRODUCT;
    ((c)localObject).f = Build.VERSION.SDK_INT;
    ((c)localObject).e = Build.VERSION.RELEASE;
    ((c)localObject).i = Build.VERSION.INCREMENTAL;
    ((c)localObject).d = Build.BOARD;
    ((c)localObject).l = Build.FINGERPRINT;
    ((c)localObject).h = com.lantern.analytics.e.a.a();
    paramContext = com.bluefay.a.e.a("android.os.SystemProperties", "get", new Object[] { "gsm.version.baseband", "unknown" });
    if ((paramContext instanceof String)) {}
    for (paramContext = (String)paramContext;; paramContext = "unknown")
    {
      ((c)localObject).g = paramContext;
      ((c)localObject).m = Build.SERIAL;
      localObject = this.b;
      paramContext = localf.h;
      localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
      paramContext.a = ((TelephonyManager)localObject).getPhoneType();
      paramContext.c = ((TelephonyManager)localObject).getNetworkOperatorName();
      paramContext.b = ((TelephonyManager)localObject).getNetworkType();
      localf.e = com.lantern.analytics.e.a.a(this.b, paramApplicationErrorReport.packageName);
      localf.e.h = paramApplicationErrorReport.installerPackageName;
      if (paramApplicationErrorReport.crashInfo != null)
      {
        localf.i = new d();
        localf.i.a = paramApplicationErrorReport.crashInfo.exceptionClassName;
        localf.i.b = paramApplicationErrorReport.crashInfo.exceptionMessage;
        localf.i.c = paramApplicationErrorReport.crashInfo.throwFileName;
        localf.i.d = paramApplicationErrorReport.crashInfo.throwClassName;
        localf.i.e = paramApplicationErrorReport.crashInfo.throwMethodName;
        localf.i.f = paramApplicationErrorReport.crashInfo.throwLineNumber;
        localf.i.g = paramApplicationErrorReport.crashInfo.stackTrace;
      }
      if (paramApplicationErrorReport.anrInfo != null)
      {
        localf.j = new com.lantern.analytics.c.a();
        localf.j.a = paramApplicationErrorReport.anrInfo.activity;
        localf.j.b = paramApplicationErrorReport.anrInfo.cause;
        localf.j.c = paramApplicationErrorReport.anrInfo.info;
      }
      this.a = localf;
      return;
    }
  }
  
  public final String a()
  {
    Object localObject1;
    if (this.a != null)
    {
      Object localObject2 = this.a;
      if (((f)localObject2).a == 1)
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("type", String.valueOf(((f)localObject2).a));
        ((HashMap)localObject1).put("time", String.valueOf(((f)localObject2).b));
        ((HashMap)localObject1).put("dhid", ((f)localObject2).c);
        Object localObject3;
        if (((f)localObject2).e != null)
        {
          localObject3 = ((f)localObject2).e;
          if (((b)localObject3).a != null) {
            ((HashMap)localObject1).put("name", ((b)localObject3).a);
          }
          if (((b)localObject3).b != null) {
            ((HashMap)localObject1).put("packageName", ((b)localObject3).b);
          }
          if (((b)localObject3).c != null) {
            ((HashMap)localObject1).put("processName", ((b)localObject3).c);
          }
          ((HashMap)localObject1).put("versioncode", String.valueOf(((b)localObject3).d));
          if (((b)localObject3).e != null) {
            ((HashMap)localObject1).put("versionName", ((b)localObject3).e);
          }
          if (((b)localObject3).h != null) {
            ((HashMap)localObject1).put("installer", ((b)localObject3).h);
          }
        }
        if (((f)localObject2).f != null)
        {
          localObject3 = ((f)localObject2).f;
          if (((c)localObject3).a != null) {
            ((HashMap)localObject1).put("device", ((c)localObject3).a);
          }
          if (((c)localObject3).b != null) {
            ((HashMap)localObject1).put("model", ((c)localObject3).b);
          }
          if (((c)localObject3).c != null) {
            ((HashMap)localObject1).put("product", ((c)localObject3).c);
          }
          if (((c)localObject3).d != null) {
            ((HashMap)localObject1).put("board", ((c)localObject3).d);
          }
          if (((c)localObject3).e != null) {
            ((HashMap)localObject1).put("firmware", ((c)localObject3).e);
          }
          ((HashMap)localObject1).put("sdk_int", String.valueOf(((c)localObject3).f));
          if (((c)localObject3).g != null) {
            ((HashMap)localObject1).put("baseband", ((c)localObject3).g);
          }
          if (((c)localObject3).h != null) {
            ((HashMap)localObject1).put("kernel", ((c)localObject3).h);
          }
          if (((c)localObject3).i != null) {
            ((HashMap)localObject1).put("buildIncremental", ((c)localObject3).i);
          }
          if (((c)localObject3).j != null) {
            ((HashMap)localObject1).put("buildDisplay", ((c)localObject3).j);
          }
          if (((c)localObject3).k != null) {
            ((HashMap)localObject1).put("buildType", ((c)localObject3).k);
          }
          if (((c)localObject3).m != null) {
            ((HashMap)localObject1).put("serial", ((c)localObject3).m);
          }
        }
        if (((f)localObject2).i != null)
        {
          localObject2 = ((f)localObject2).i;
          if (((d)localObject2).a != null) {
            ((HashMap)localObject1).put("exceptionClassName", ((d)localObject2).a);
          }
          if (((d)localObject2).b != null) {
            ((HashMap)localObject1).put("exceptionMessage", ((d)localObject2).b);
          }
          if (((d)localObject2).c != null) {
            ((HashMap)localObject1).put("throwFileName", ((d)localObject2).c);
          }
          if (((d)localObject2).d != null) {
            ((HashMap)localObject1).put("throwClassName", ((d)localObject2).d);
          }
          if (((d)localObject2).e != null) {
            ((HashMap)localObject1).put("throwMethodName", ((d)localObject2).e);
          }
          ((HashMap)localObject1).put("throwLineNumber", String.valueOf(((d)localObject2).f));
          if (((d)localObject2).g != null) {
            ((HashMap)localObject1).put("stackTrace", ((d)localObject2).g);
          }
        }
        localObject1 = new JSONObject((Map)localObject1).toString();
      }
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = "{}";
      continue;
      localObject1 = "{}";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */