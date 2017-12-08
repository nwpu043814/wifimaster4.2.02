package com.alipay.sdk.j;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.app.a.a;
import com.alipay.sdk.app.b;
import com.alipay.sdk.app.j;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
{
  public static WebView a(Activity paramActivity, String paramString1, String paramString2)
  {
    Context localContext = paramActivity.getApplicationContext();
    if (!TextUtils.isEmpty(paramString2))
    {
      CookieSyncManager.createInstance(localContext).sync();
      CookieManager.getInstance().setCookie(paramString1, paramString2);
      CookieSyncManager.getInstance().sync();
    }
    paramString2 = new LinearLayout(localContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramString2.setOrientation(1);
    paramActivity.setContentView(paramString2, localLayoutParams);
    paramActivity = new WebView(localContext);
    localLayoutParams.weight = 1.0F;
    paramActivity.setVisibility(0);
    paramString2.addView(paramActivity, localLayoutParams);
    paramString2 = paramActivity.getSettings();
    paramString2.setUserAgentString(paramString2.getUserAgentString() + e(localContext));
    paramString2.setRenderPriority(WebSettings.RenderPriority.HIGH);
    paramString2.setSupportMultipleWindows(true);
    paramString2.setJavaScriptEnabled(true);
    paramString2.setSavePassword(false);
    paramString2.setJavaScriptCanOpenWindowsAutomatically(true);
    paramString2.setMinimumFontSize(paramString2.getMinimumFontSize() + 8);
    paramString2.setAllowFileAccess(false);
    paramString2.setTextSize(WebSettings.TextSize.NORMAL);
    paramActivity.setVerticalScrollbarOverlay(true);
    paramActivity.setDownloadListener(new l(localContext));
    if (Build.VERSION.SDK_INT >= 7) {}
    for (;;)
    {
      try
      {
        paramString2 = paramActivity.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
        if (paramString2 != null) {
          paramString2.invoke(paramActivity.getSettings(), new Object[] { Boolean.valueOf(true) });
        }
      }
      catch (Exception paramString2)
      {
        continue;
      }
      try
      {
        paramActivity.removeJavascriptInterface("searchBoxJavaBridge_");
        paramActivity.removeJavascriptInterface("accessibility");
        paramActivity.removeJavascriptInterface("accessibilityTraversal");
        if (Build.VERSION.SDK_INT >= 19) {
          paramActivity.getSettings().setCacheMode(1);
        }
        paramActivity.loadUrl(paramString1);
        return paramActivity;
      }
      catch (Throwable paramString2)
      {
        try
        {
          paramString2 = paramActivity.getClass().getMethod("removeJavascriptInterface", new Class[0]);
          if (paramString2 == null) {
            continue;
          }
          paramString2.invoke(paramActivity, new Object[] { "searchBoxJavaBridge_" });
          paramString2.invoke(paramActivity, new Object[] { "accessibility" });
          paramString2.invoke(paramActivity, new Object[] { "accessibilityTraversal" });
        }
        catch (Throwable paramString2) {}
      }
    }
  }
  
  public static a a(Context paramContext)
  {
    return a(paramContext, a());
  }
  
  private static a a(Context paramContext, String paramString)
  {
    localObject3 = null;
    for (;;)
    {
      try
      {
        localPackageInfo3 = paramContext.getPackageManager().getPackageInfo(paramString, 192);
        localPackageInfo1 = localPackageInfo3;
        if (a(localPackageInfo3)) {}
      }
      catch (Throwable localThrowable)
      {
        PackageInfo localPackageInfo3;
        PackageInfo localPackageInfo1;
        a.a("auth", "GetPackageInfoEx", localThrowable);
        if (a(null)) {
          continue;
        }
        try
        {
          localPackageInfo2 = b(paramContext, paramString);
        }
        catch (Throwable paramContext)
        {
          a.a("auth", "GetInstalledPackagesEx", paramContext);
          PackageInfo localPackageInfo2 = null;
        }
        continue;
      }
      finally
      {
        if (a(null)) {
          continue;
        }
        try
        {
          b(paramContext, paramString);
          throw ((Throwable)localObject1);
        }
        catch (Throwable paramContext)
        {
          a.a("auth", "GetInstalledPackagesEx", paramContext);
          continue;
        }
        paramContext = (Context)localObject3;
        if (localObject1 == null) {
          continue;
        }
        paramContext = new a();
        paramContext.a = ((PackageInfo)localObject1).signatures;
        paramContext.b = ((PackageInfo)localObject1).versionCode;
        continue;
        Object localObject2 = null;
        continue;
      }
      try
      {
        localPackageInfo1 = b(paramContext, paramString);
        if (!a(localPackageInfo1))
        {
          paramContext = (Context)localObject3;
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        a.a("auth", "GetInstalledPackagesEx", paramContext);
        localPackageInfo1 = localPackageInfo3;
      }
    }
  }
  
  public static String a()
  {
    if (b.a()) {}
    for (String str = "com.eg.android.AlipayGphoneRC";; str = "com.eg.android.AlipayGphone") {
      return str;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        i = paramString3.indexOf(paramString1);
        j = paramString1.length() + i;
        if (j > paramString1.length()) {
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramString1)
      {
        int i;
        int j;
        paramString1 = "";
        continue;
      }
      return paramString1;
      i = 0;
      if (!TextUtils.isEmpty(paramString2)) {
        i = paramString3.indexOf(paramString2, j);
      }
      if (i <= 0) {
        paramString1 = paramString3.substring(j);
      } else {
        paramString1 = paramString3.substring(j, i);
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(paramArrayOfByte);
      paramArrayOfByte = ((X509Certificate)localCertificateFactory.generateCertificate(localByteArrayInputStream)).getPublicKey().toString();
      if (paramArrayOfByte.indexOf("modulus") != -1)
      {
        paramArrayOfByte = paramArrayOfByte.substring(paramArrayOfByte.indexOf("modulus") + 8, paramArrayOfByte.lastIndexOf(",")).trim();
        return paramArrayOfByte;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        a.a("auth", "GetPublicKeyFromSignEx", paramArrayOfByte);
        paramArrayOfByte = null;
      }
    }
  }
  
  public static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (paramString : paramString.split("&"))
    {
      int k = paramString.indexOf("=", 1);
      localHashMap.put(paramString.substring(0, k), URLDecoder.decode(paramString.substring(k + 1)));
    }
    return localHashMap;
  }
  
  private static boolean a(PackageInfo paramPackageInfo)
  {
    String str = "";
    boolean bool = false;
    if (paramPackageInfo == null) {
      paramPackageInfo = "" + "info == null";
    }
    for (;;)
    {
      if (!bool) {
        a.a("auth", "NotIncludeSignatures", paramPackageInfo);
      }
      return bool;
      if (paramPackageInfo.signatures == null)
      {
        paramPackageInfo = "" + "info.signatures == null";
      }
      else if (paramPackageInfo.signatures.length <= 0)
      {
        paramPackageInfo = "" + "info.signatures.length <= 0";
      }
      else
      {
        bool = true;
        paramPackageInfo = str;
      }
    }
  }
  
  public static boolean a(WebView paramWebView, String paramString, Activity paramActivity)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return true;
      if ((paramString.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase())) || (paramString.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())))
      {
        try
        {
          paramWebView = a(paramActivity);
          if ((paramWebView == null) || (paramWebView.a())) {
            continue;
          }
          paramWebView = paramString;
          if (paramString.startsWith("intent://platformapi/startapp")) {
            paramWebView = paramString.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
          }
          paramString = new android/content/Intent;
          paramString.<init>("android.intent.action.VIEW", Uri.parse(paramWebView));
          paramActivity.startActivity(paramString);
        }
        catch (Throwable paramWebView) {}
      }
      else if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
      {
        j.a = j.a();
        paramActivity.finish();
      }
      else
      {
        if (paramString.startsWith("sdklite://h5quit?result=")) {
          for (;;)
          {
            try
            {
              paramWebView = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
              int i = Integer.parseInt(paramWebView.substring(paramWebView.lastIndexOf("&end_code=") + 10));
              if ((i != com.alipay.sdk.app.k.a.h) && (i != com.alipay.sdk.app.k.g.h)) {
                continue;
              }
              paramWebView = URLDecoder.decode(paramString);
              paramString = paramWebView.substring(paramWebView.indexOf("sdklite://h5quit?result=") + 24, paramWebView.lastIndexOf("&end_code="));
              paramWebView = com.alipay.sdk.app.k.a(i);
              j.a = j.a(paramWebView.h, paramWebView.i, paramString);
            }
            catch (Exception paramWebView)
            {
              paramWebView = com.alipay.sdk.app.k.a(com.alipay.sdk.app.k.e.h);
              j.a = j.a(paramWebView.h, paramWebView.i, "");
              continue;
            }
            paramActivity.runOnUiThread(new m(paramActivity));
            break;
            paramWebView = com.alipay.sdk.app.k.a(com.alipay.sdk.app.k.b.h);
            j.a = j.a(paramWebView.h, paramWebView.i, "");
          }
        }
        paramWebView.loadUrl(paramString);
      }
    }
  }
  
  private static PackageInfo b(Context paramContext, String paramString)
  {
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(192).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramContext = (PackageInfo)localIterator.next();
    } while (!paramContext.packageName.equals(paramString));
    for (;;)
    {
      return paramContext;
      paramContext = null;
    }
  }
  
  public static String b()
  {
    return "Android " + Build.VERSION.RELEASE;
  }
  
  public static boolean b(Context paramContext)
  {
    for (boolean bool = false;; bool = true)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128);
        if (paramContext != null) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(paramString).matches();
  }
  
  public static String c()
  {
    Object localObject2 = e();
    int i = ((String)localObject2).indexOf("-");
    Object localObject1 = localObject2;
    if (i != -1) {
      localObject1 = ((String)localObject2).substring(0, i);
    }
    i = ((String)localObject1).indexOf("\n");
    localObject2 = localObject1;
    if (i != -1) {
      localObject2 = ((String)localObject1).substring(0, i);
    }
    return "Linux " + (String)localObject2;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        String str = a();
        paramContext = paramContext.getPackageManager().getPackageInfo(str, 128);
        if (paramContext != null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        int i;
        a.a("biz", "CheckClientExistEx", paramContext);
        continue;
      }
      return bool;
      i = paramContext.versionCode;
      if (i > 73) {
        bool = true;
      }
    }
  }
  
  public static String d()
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < 24)
    {
      switch (localRandom.nextInt(3))
      {
      }
      for (;;)
      {
        i++;
        break;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 65.0D)));
        continue;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 97.0D)));
        continue;
        localStringBuilder.append(String.valueOf(new Random().nextInt(10)));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(a(), 128);
        if (paramContext != null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        int i;
        continue;
      }
      return bool;
      i = paramContext.versionCode;
      if (i < 99) {
        bool = true;
      }
    }
  }
  
  private static String e()
  {
    for (;;)
    {
      try
      {
        localObject1 = new java/io/BufferedReader;
        localObject2 = new java/io/FileReader;
        ((FileReader)localObject2).<init>("/proc/version");
        ((BufferedReader)localObject1).<init>((Reader)localObject2, 256);
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Object localObject2;
        String str = "Unavailable";
        continue;
        if (str.groupCount() >= 4) {
          continue;
        }
        str = "Unavailable";
        continue;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(str.group(1));
        str = "\n" + str.group(2) + " " + str.group(3) + "\n" + str.group(4);
        continue;
      }
      try
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        ((BufferedReader)localObject1).close();
        localObject1 = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher((CharSequence)localObject2);
        if (!((Matcher)localObject1).matches())
        {
          localObject1 = "Unavailable";
          return (String)localObject1;
        }
      }
      finally
      {
        ((BufferedReader)localObject1).close();
      }
    }
  }
  
  public static String e(Context paramContext)
  {
    String str3 = b();
    String str1 = c();
    String str2 = f(paramContext);
    paramContext = g(paramContext);
    return " (" + str3 + ";" + str1 + ";" + str2 + ";;" + paramContext + ")(sdk android)";
  }
  
  public static String f(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString();
  }
  
  public static String g(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    paramContext = new StringBuilder();
    paramContext.append(localDisplayMetrics.widthPixels);
    paramContext.append("*");
    paramContext.append(localDisplayMetrics.heightPixels);
    return paramContext.toString();
  }
  
  public static String h(Context paramContext)
  {
    Object localObject1 = "";
    try
    {
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      for (paramContext = (Context)localObject1;; paramContext = paramContext + "#M")
      {
        localObject1 = paramContext;
        if (!localIterator.hasNext()) {
          break label195;
        }
        localObject1 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (!((ActivityManager.RunningAppProcessInfo)localObject1).processName.equals(a())) {
          break;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
      }
      String str = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      if (str.startsWith(a() + ":"))
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        paramContext = ((StringBuilder)localObject2).append(paramContext).append("#");
        localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        paramContext = ((String)localObject2).replace(((StringBuilder)localObject1).append(a()).append(":").toString(), "");
      }
      label195:
      for (;;)
      {
        break;
      }
    }
    catch (Throwable paramContext)
    {
      localObject1 = "";
      paramContext = (Context)localObject1;
      if (((String)localObject1).length() > 0) {
        paramContext = ((String)localObject1).substring(1);
      }
      localObject1 = paramContext;
      if (paramContext.length() == 0) {
        localObject1 = "N";
      }
      return (String)localObject1;
    }
  }
  
  public static String i(Context paramContext)
  {
    StringBuilder localStringBuilder;
    try
    {
      List localList = paramContext.getPackageManager().getInstalledPackages(0);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      int i = 0;
      if (i < localList.size())
      {
        paramContext = (PackageInfo)localList.get(i);
        int j = paramContext.applicationInfo.flags;
        if (((j & 0x1) == 0) && ((j & 0x80) == 0))
        {
          j = 1;
          label67:
          if (j != 0)
          {
            if (!paramContext.packageName.equals(a())) {
              break label117;
            }
            localStringBuilder.append(paramContext.packageName).append(paramContext.versionCode).append("-");
          }
        }
        for (;;)
        {
          i++;
          break;
          j = 0;
          break label67;
          label117:
          if ((!paramContext.packageName.contains("theme")) && (!paramContext.packageName.startsWith("com.google.")) && (!paramContext.packageName.startsWith("com.android."))) {
            localStringBuilder.append(paramContext.packageName).append("-");
          }
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      a.a("biz", "GetInstalledAppEx", paramContext);
      paramContext = "";
    }
    for (;;)
    {
      paramContext = localStringBuilder.toString();
    }
  }
  
  public static final class a
  {
    public Signature[] a;
    public int b;
    
    public final boolean a()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.a != null)
      {
        if (this.a.length <= 0) {
          bool1 = bool2;
        }
      }
      else {
        return bool1;
      }
      for (int i = 0;; i++)
      {
        bool1 = bool2;
        if (i >= this.a.length) {
          break;
        }
        String str = k.a(this.a[i].toByteArray());
        if ((str != null) && (!TextUtils.equals(str, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")))
        {
          bool1 = true;
          a.a("biz", "PublicKeyUnmatch", str);
          break;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */