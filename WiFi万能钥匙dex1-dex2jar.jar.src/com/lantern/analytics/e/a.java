package com.lantern.analytics.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.bluefay.b.h;
import com.lantern.analytics.c.b;
import com.lantern.core.k;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class a
{
  public static b a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        localApplicationInfo = localPackageManager.getApplicationInfo(paramString, 0);
        localb = new com/lantern/analytics/c/b;
        localb.<init>();
        localb.b = localApplicationInfo.packageName;
        localb.c = localApplicationInfo.processName;
        paramContext = localApplicationInfo.loadLabel(localPackageManager);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.toString();
        localb.a = paramContext;
        paramContext = localPackageManager.getPackageInfo(paramString, 0);
        localb.e = paramContext.versionName;
        localb.d = paramContext.versionCode;
        localb.h = localPackageManager.getInstallerPackageName(paramString);
        if ((localApplicationInfo.flags & 0x1) == 0) {
          continue;
        }
        localb.f = true;
        paramContext = localb;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        ApplicationInfo localApplicationInfo;
        b localb;
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      return paramContext;
      paramContext = localApplicationInfo.packageName;
      continue;
      localb.f = false;
      paramContext = localb;
    }
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        localObject2 = a("/proc/version");
        localObject1 = Pattern.compile("Linux version (\\S+) \\((\\S+?)\\) (?:\\(gcc.+? \\)) (#\\d+) (?:.*?)?((Sun|Mon|Tue|Wed|Thu|Fri|Sat).+)").matcher((CharSequence)localObject2);
        if (((Matcher)localObject1).matches()) {
          continue;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Regex did not match on /proc/version: ");
        h.c((String)localObject2);
        localObject1 = "Unavailable";
      }
      catch (IOException localIOException)
      {
        Object localObject2;
        Object localObject1;
        h.a("IO Exception when getting kernel version for Device Info screen", localIOException);
        String str = "Unavailable";
        continue;
      }
      return (String)localObject1;
      if (((Matcher)localObject1).groupCount() < 4)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Regex match on /proc/version only returned ");
        h.c(((Matcher)localObject1).groupCount() + " groups");
        localObject1 = "Unavailable";
      }
      else
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = ((Matcher)localObject1).group(1) + "\n" + ((Matcher)localObject1).group(2) + " " + ((Matcher)localObject1).group(3) + "\n" + ((Matcher)localObject1).group(4);
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    int i = com.bluefay.d.a.getVersionCode();
    Object localObject1 = k.l(paramContext);
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        localJSONObject.put("channel_name", localObject1);
      }
      localJSONObject.put("version_code", i);
      localJSONObject.put("package", paramContext.getPackageName());
      Object localObject2 = Locale.getDefault();
      localObject1 = ((Locale)localObject2).getLanguage();
      paramContext = (Context)localObject1;
      if (localObject1 != null) {
        paramContext = ((String)localObject1).toLowerCase();
      }
      localObject2 = ((Locale)localObject2).getCountry();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).toUpperCase();
      }
      localObject2 = paramContext;
      if (localObject1 != null)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = paramContext + "-" + (String)localObject1;
      }
      localJSONObject.put("locale", localObject2);
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  private static String a(String paramString)
  {
    paramString = new BufferedReader(new FileReader(paramString), 256);
    try
    {
      String str = paramString.readLine();
      return str;
    }
    finally
    {
      paramString.close();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */