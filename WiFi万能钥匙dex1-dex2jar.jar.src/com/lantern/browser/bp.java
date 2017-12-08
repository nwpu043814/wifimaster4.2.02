package com.lantern.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.MailTo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.webkit.WebView;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.b;
import com.lantern.browser.c.f;
import com.lantern.core.c;
import com.lantern.core.config.DomainBlackListConf;
import com.lantern.core.config.DomainZenmenConf;
import com.lantern.core.config.SchemeWhiteListConf;
import com.lantern.core.config.SmsDomainWhiteListConf;
import com.lantern.core.config.d;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class bp
{
  public static final String[] a = { "找不到网页", "页面没有找到", "Webpage not available", "网页无法打开", "404 Not Found", "403 Forbidden", "502 Bad Gateway", "703", "Page Not Found" };
  private static int b = 3000;
  private static int c = 3000;
  private static String d = "";
  private static String e = "";
  private static Map<String, Integer> f = null;
  private static List<String> g;
  private static List<Long> h;
  private static File i;
  private static Handler j = new bq();
  
  public static String a()
  {
    return d;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = (WifiManager)paramContext.getSystemService("wifi");
    WifiInfo localWifiInfo = ((WifiManager)localObject1).getConnectionInfo();
    Object localObject2 = c.getServer();
    paramContext = "";
    if (localObject2 != null) {
      paramContext = (String)((o)localObject2).s().get("capSsid");
    }
    localObject2 = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      localObject2 = paramContext;
      if (localWifiInfo != null)
      {
        int k = localWifiInfo.getNetworkId();
        localObject2 = ((WifiManager)localObject1).getConfiguredNetworks();
        localObject1 = paramContext;
        if (localObject2 != null)
        {
          localObject1 = paramContext;
          if (k != -1)
          {
            localObject2 = ((List)localObject2).iterator();
            do
            {
              localObject1 = paramContext;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (WifiConfiguration)((Iterator)localObject2).next();
            } while (((WifiConfiguration)localObject1).networkId != k);
            com.bluefay.b.h.a("getSsid networkid:" + k + " config.networkId:" + ((WifiConfiguration)localObject1).networkId + " config.SSID:" + ((WifiConfiguration)localObject1).SSID, new Object[0]);
            localObject1 = j(((WifiConfiguration)localObject1).SSID);
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = j(localWifiInfo.getSSID());
        }
      }
    }
    if (k((String)localObject2)) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      paramContext = ((String)localObject2).replaceAll("\000|\001|\002|\003|\004|\005|\006|\007", "*");
      com.bluefay.b.h.a("getSsid ssid:" + paramContext, new Object[0]);
    }
  }
  
  public static void a(long paramLong)
  {
    if (h == null) {
      e();
    }
    h.add(Long.valueOf(paramLong));
    f();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    new bw(paramContext, paramString1, paramString2).start();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("startBrowserActivity aUrl:");
      com.bluefay.b.h.a(paramString, new Object[0]);
      localObject = new android/content/Intent;
      ((Intent)localObject).<init>("wifi.intent.action.BROWSER", Uri.parse(paramString));
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("allowdownload", paramBoolean);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramContext);
      }
    }
  }
  
  public static void a(WebView paramWebView, int paramInt)
  {
    if (f == null) {
      i(paramWebView.getContext());
    }
    String str = paramWebView.getUrl();
    paramWebView = (Integer)f.get(str);
    if (((paramWebView == null) && (paramInt != 0)) || ((paramWebView != null) && (paramWebView.intValue() != paramInt))) {
      f.put(str, Integer.valueOf(paramInt));
    }
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  private static boolean a(Activity paramActivity, String paramString)
  {
    bool1 = false;
    try
    {
      localIntent = Intent.parseUri(paramString, 1);
      if (paramActivity.getPackageManager().resolveActivity(localIntent, 0) != null) {
        break label61;
      }
    }
    catch (URISyntaxException paramActivity)
    {
      for (;;)
      {
        Intent localIntent;
        com.bluefay.b.h.c("Bad URI " + paramString + ": " + paramActivity.getMessage());
        continue;
        try
        {
          localIntent.putExtra("disable_url_override", true);
          boolean bool2 = paramActivity.startActivityIfNeeded(localIntent, -1);
          if (bool2) {
            bool1 = true;
          }
        }
        catch (Exception paramActivity) {}
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramString = Uri.parse(paramString).getHost();
    paramContext = ((DomainBlackListConf)d.a(paramContext).a(DomainBlackListConf.class)).d();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (!paramString.contains((String)paramContext.next()));
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean a(WebView paramWebView)
  {
    boolean bool;
    if (paramWebView == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (((paramWebView instanceof WkBrowserWebView)) && (((WkBrowserWebView)paramWebView).f().b())) {
        bool = false;
      } else {
        bool = d(paramWebView.getContext(), paramWebView.getUrl());
      }
    }
  }
  
  public static boolean a(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    int m = 0;
    boolean bool;
    if (paramWkBrowserWebView == null) {
      bool = false;
    }
    Object localObject1;
    label84:
    Object localObject2;
    for (;;)
    {
      return bool;
      com.bluefay.b.h.a("handleScheme url:" + paramString, new Object[0]);
      localObject1 = paramString;
      if (paramString.startsWith("wkb"))
      {
        localObject1 = paramString;
        if (!paramString.startsWith("wkb://"))
        {
          if (!paramString.startsWith("wkb//")) {
            break label220;
          }
          localObject1 = paramString.replaceFirst("//", "://");
        }
        paramString = ((String)localObject1).substring(6);
        localObject1 = paramString;
        if (!a(paramString)) {
          localObject1 = "http://" + paramString;
        }
      }
      if (((String)localObject1).startsWith("wtai://wp/"))
      {
        if (((String)localObject1).startsWith("wtai://wp/mc;"))
        {
          try
          {
            localObject2 = new android/content/Intent;
            paramString = new java/lang/StringBuilder;
            paramString.<init>("tel:");
            ((Intent)localObject2).<init>("android.intent.action.DIAL", Uri.parse(((String)localObject1).substring(13)));
            ((Intent)localObject2).setPackage(paramWkBrowserWebView.getContext().getPackageName());
            ((Intent)localObject2).addFlags(268435456);
            paramWkBrowserWebView.getContext().startActivity((Intent)localObject2);
            bool = true;
            continue;
            label220:
            if ((paramString.startsWith("wkb:/")) && (!paramString.startsWith("wkb://")))
            {
              localObject1 = paramString.replaceFirst(":/", "://");
              break label84;
            }
            localObject1 = paramString.replaceFirst("wkb", "wkb://");
          }
          catch (Exception paramWkBrowserWebView)
          {
            for (;;)
            {
              com.bluefay.b.h.a(paramWkBrowserWebView);
            }
          }
        }
        else if (((String)localObject1).startsWith("wtai://wp/sd;"))
        {
          bool = false;
        }
        else
        {
          if (!((String)localObject1).startsWith("wtai://wp/ap;")) {
            break label1088;
          }
          bool = false;
        }
      }
      else if (((String)localObject1).startsWith("tel:")) {
        try
        {
          paramString = new android/content/Intent;
          paramString.<init>("android.intent.action.DIAL", Uri.parse((String)localObject1));
          paramWkBrowserWebView.getContext().startActivity(paramString);
          bool = true;
        }
        catch (Exception paramWkBrowserWebView)
        {
          for (;;)
          {
            com.bluefay.b.h.a(paramWkBrowserWebView);
          }
        }
      }
    }
    Object localObject3;
    if (((String)localObject1).startsWith("sms:"))
    {
      localObject3 = Uri.parse(paramWkBrowserWebView.getUrl()).getHost();
      paramString = ((SmsDomainWhiteListConf)d.a(paramWkBrowserWebView.getContext()).a(SmsDomainWhiteListConf.class)).d();
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label1226;
      }
      paramString = paramString.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
      } while (!((String)paramString.next()).equalsIgnoreCase((String)localObject3));
    }
    label1088:
    label1221:
    label1226:
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        bool = true;
        break;
      }
      for (;;)
      {
        try
        {
          k = ((String)localObject1).indexOf("?");
          if (k == -1)
          {
            localObject1 = ((String)localObject1).substring(4);
            localObject2 = "";
            paramString = (String)localObject1;
            localObject1 = localObject2;
            int n = ((String)localObject3).length();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject3 = (String)localObject3 + paramWkBrowserWebView.getContext().getResources().getString(R.string.browser_sms_tip1);
            m = ((String)localObject3).length();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject3 = (String)localObject3 + paramString;
            int i1 = ((String)localObject3).length();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject2 = (String)localObject3 + paramWkBrowserWebView.getContext().getResources().getString(R.string.browser_sms_tip2);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1221;
            }
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject3 = (String)localObject2 + ":";
            k = ((String)localObject3).length();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject2 = (String)localObject3 + (String)localObject1;
            localObject3 = new android/text/SpannableStringBuilder;
            ((SpannableStringBuilder)localObject3).<init>((CharSequence)localObject2);
            localObject4 = new android/text/style/ForegroundColorSpan;
            ((ForegroundColorSpan)localObject4).<init>(-16611856);
            ((SpannableStringBuilder)localObject3).setSpan(localObject4, 0, n, 34);
            localObject4 = new android/text/style/ForegroundColorSpan;
            ((ForegroundColorSpan)localObject4).<init>(-16611856);
            ((SpannableStringBuilder)localObject3).setSpan(localObject4, m, i1, 34);
            localObject4 = new android/text/style/ForegroundColorSpan;
            ((ForegroundColorSpan)localObject4).<init>(-16611856);
            ((SpannableStringBuilder)localObject3).setSpan(localObject4, k, ((String)localObject2).length(), 34);
            localObject2 = paramWkBrowserWebView.b();
            if (localObject2 != null) {
              continue;
            }
            bool = false;
            break;
          }
          paramString = ((String)localObject1).substring(4, k);
          localObject2 = Uri.parse((String)localObject1).getQuery();
          localObject1 = paramString;
          if (localObject2 == null) {
            continue;
          }
          if (((String)localObject2).startsWith("body="))
          {
            localObject1 = ((String)localObject2).substring(5);
            continue;
          }
          localObject1 = "";
          continue;
          Object localObject4 = ((cc)localObject2).getActivity();
          if (localObject4 == null)
          {
            bool = false;
            break;
          }
          localObject2 = new bluefay/app/k$a;
          ((k.a)localObject2).<init>((Context)localObject4);
          ((k.a)localObject2).a(R.string.browser_sms_title);
          ((k.a)localObject2).b((CharSequence)localObject3);
          k = R.string.browser_btn_confirm;
          localObject3 = new com/lantern/browser/br;
          ((br)localObject3).<init>(paramString, (String)localObject1, paramWkBrowserWebView);
          ((k.a)localObject2).a(k, (DialogInterface.OnClickListener)localObject3);
          k = R.string.browser_btn_cancel;
          paramWkBrowserWebView = new com/lantern/browser/bs;
          paramWkBrowserWebView.<init>();
          ((k.a)localObject2).b(k, paramWkBrowserWebView);
          ((k.a)localObject2).c();
          ((k.a)localObject2).d();
        }
        catch (Exception paramWkBrowserWebView)
        {
          com.bluefay.b.h.a(paramWkBrowserWebView);
          continue;
        }
        bool = true;
        break;
        if (((String)localObject1).startsWith("mailto:")) {
          try
          {
            localObject1 = MailTo.parse((String)localObject1);
            paramString = new android/content/Intent;
            paramString.<init>("android.intent.action.SEND");
            paramString.setType("text/plain");
            paramString.putExtra("android.intent.extra.EMAIL", new String[] { ((MailTo)localObject1).getTo() });
            paramString.putExtra("android.intent.extra.SUBJECT", ((MailTo)localObject1).getSubject());
            paramString.putExtra("android.intent.extra.CC", ((MailTo)localObject1).getCc());
            paramString.putExtra("android.intent.extra.TEXT", ((MailTo)localObject1).getBody());
            paramWkBrowserWebView.getContext().startActivity(paramString);
            bool = true;
          }
          catch (Exception paramWkBrowserWebView)
          {
            for (;;)
            {
              com.bluefay.b.h.a(paramWkBrowserWebView);
            }
          }
        }
        if (a((String)localObject1))
        {
          bool = false;
          break;
        }
        paramString = ((SchemeWhiteListConf)d.a(paramWkBrowserWebView.getContext()).a(SchemeWhiteListConf.class)).d();
        k = m;
        if (paramString != null)
        {
          k = m;
          if (paramString.size() > 0)
          {
            paramString = paramString.iterator();
            do
            {
              k = m;
              if (!paramString.hasNext()) {
                break;
              }
            } while (!((String)localObject1).startsWith((String)paramString.next()));
            k = 1;
          }
        }
        if (k != 0) {}
        try
        {
          paramWkBrowserWebView = paramWkBrowserWebView.b();
          if (paramWkBrowserWebView != null)
          {
            paramWkBrowserWebView = paramWkBrowserWebView.getActivity();
            if (paramWkBrowserWebView != null) {
              a(paramWkBrowserWebView, (String)localObject1);
            }
          }
        }
        catch (Exception paramWkBrowserWebView)
        {
          for (;;)
          {
            com.bluefay.b.h.a(paramWkBrowserWebView);
          }
        }
        bool = true;
        break;
        k = -1;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      return bool1;
    }
    paramString = paramString.toLowerCase();
    for (int k = 0;; k++)
    {
      bool1 = bool2;
      if (k >= 5) {
        break;
      }
      if (paramString.startsWith(new String[] { "http", "https", "file", "about", "javascript" }[k]))
      {
        bool1 = true;
        break;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("cache", paramString2);
      paramString1 = new Message();
      paramString1.what = 1;
      paramString1.obj = localHashMap;
      j.removeMessages(1);
      j.sendMessageDelayed(paramString1, 60000L);
    }
  }
  
  public static int b(WebView paramWebView)
  {
    if (f == null) {
      i(paramWebView.getContext());
    }
    paramWebView = (Integer)f.get(paramWebView.getUrl());
    if (paramWebView != null) {}
    for (int k = paramWebView.intValue();; k = 0) {
      return k;
    }
  }
  
  /* Error */
  public static ab b(String paramString)
  {
    // Byte code:
    //   0: new 609	com/lantern/browser/ab
    //   3: dup
    //   4: invokespecial 610	com/lantern/browser/ab:<init>	()V
    //   7: astore 5
    //   9: new 612	org/apache/http/params/BasicHttpParams
    //   12: dup
    //   13: invokespecial 613	org/apache/http/params/BasicHttpParams:<init>	()V
    //   16: astore 6
    //   18: aload 6
    //   20: iconst_0
    //   21: invokestatic 619	org/apache/http/params/HttpConnectionParams:setStaleCheckingEnabled	(Lorg/apache/http/params/HttpParams;Z)V
    //   24: aload 6
    //   26: getstatic 50	com/lantern/browser/bp:b	I
    //   29: invokestatic 623	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   32: aload 6
    //   34: getstatic 52	com/lantern/browser/bp:c	I
    //   37: invokestatic 626	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   40: aload 6
    //   42: sipush 8192
    //   45: invokestatic 629	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   48: aload 6
    //   50: iconst_1
    //   51: invokestatic 634	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   54: invokestatic 640	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   57: astore_3
    //   58: invokestatic 645	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   61: invokestatic 649	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   64: astore 4
    //   66: aload 4
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 653	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   73: new 655	com/lantern/browser/b
    //   76: astore_2
    //   77: aload_2
    //   78: aload 4
    //   80: invokespecial 658	com/lantern/browser/b:<init>	(Ljava/security/KeyStore;)V
    //   83: aload_2
    //   84: getstatic 662	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   87: invokevirtual 666	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   90: new 668	org/apache/http/conn/scheme/SchemeRegistry
    //   93: dup
    //   94: invokespecial 669	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   97: astore_3
    //   98: aload_3
    //   99: new 671	org/apache/http/conn/scheme/Scheme
    //   102: dup
    //   103: ldc_w 569
    //   106: invokestatic 676	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   109: bipush 80
    //   111: invokespecial 679	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   114: invokevirtual 683	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   117: pop
    //   118: aload_3
    //   119: new 671	org/apache/http/conn/scheme/Scheme
    //   122: dup
    //   123: ldc_w 571
    //   126: aload_2
    //   127: sipush 443
    //   130: invokespecial 679	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   133: invokevirtual 683	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   136: pop
    //   137: new 685	org/apache/http/impl/client/DefaultHttpClient
    //   140: dup
    //   141: new 687	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   144: dup
    //   145: aload 6
    //   147: aload_3
    //   148: invokespecial 690	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   151: aload 6
    //   153: invokespecial 693	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   156: astore_2
    //   157: new 695	org/apache/http/client/methods/HttpGet
    //   160: astore_3
    //   161: aload_3
    //   162: aload_0
    //   163: invokespecial 696	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   166: aload_3
    //   167: ldc_w 698
    //   170: ldc_w 700
    //   173: invokevirtual 704	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_3
    //   177: ldc_w 706
    //   180: ldc_w 708
    //   183: invokevirtual 704	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_3
    //   187: ldc_w 710
    //   190: ldc_w 712
    //   193: invokevirtual 704	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 716	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   201: astore_0
    //   202: aload_0
    //   203: invokeinterface 722 1 0
    //   208: invokestatic 727	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   211: astore_2
    //   212: aload_0
    //   213: invokeinterface 731 1 0
    //   218: invokeinterface 736 1 0
    //   223: istore_1
    //   224: aload_2
    //   225: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +105 -> 333
    //   231: aload_2
    //   232: ldc_w 738
    //   235: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   238: ifne +13 -> 251
    //   241: aload_2
    //   242: ldc_w 740
    //   245: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   248: ifeq +85 -> 333
    //   251: aload 5
    //   253: iconst_1
    //   254: invokevirtual 743	com/lantern/browser/ab:a	(Z)V
    //   257: aload 5
    //   259: iconst_0
    //   260: invokevirtual 745	com/lantern/browser/ab:b	(Z)V
    //   263: aload 5
    //   265: aload_2
    //   266: invokevirtual 747	com/lantern/browser/ab:a	(Ljava/lang/String;)V
    //   269: new 143	java/lang/StringBuilder
    //   272: dup
    //   273: ldc_w 749
    //   276: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: aload 5
    //   281: invokevirtual 750	com/lantern/browser/ab:toString	()Ljava/lang/String;
    //   284: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 170	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: aload 5
    //   299: areturn
    //   300: astore 4
    //   302: aload_3
    //   303: astore_2
    //   304: aload 4
    //   306: astore_3
    //   307: new 143	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 752
    //   314: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload_3
    //   318: invokevirtual 753	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   321: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 755	com/bluefay/b/h:b	(Ljava/lang/String;)V
    //   330: goto -240 -> 90
    //   333: sipush 200
    //   336: iload_1
    //   337: if_icmpeq +17 -> 354
    //   340: sipush 302
    //   343: iload_1
    //   344: if_icmpeq +10 -> 354
    //   347: sipush 307
    //   350: iload_1
    //   351: if_icmpne +60 -> 411
    //   354: aload 5
    //   356: iconst_1
    //   357: invokevirtual 743	com/lantern/browser/ab:a	(Z)V
    //   360: aload 5
    //   362: iconst_1
    //   363: invokevirtual 745	com/lantern/browser/ab:b	(Z)V
    //   366: invokestatic 760	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   369: ldc_w 762
    //   372: invokevirtual 765	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   375: goto -106 -> 269
    //   378: astore_0
    //   379: new 143	java/lang/StringBuilder
    //   382: dup
    //   383: ldc_w 767
    //   386: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload_0
    //   390: invokevirtual 753	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 327	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   402: aload 5
    //   404: iconst_0
    //   405: invokevirtual 743	com/lantern/browser/ab:a	(Z)V
    //   408: goto -139 -> 269
    //   411: aload 5
    //   413: iconst_0
    //   414: invokevirtual 743	com/lantern/browser/ab:a	(Z)V
    //   417: invokestatic 760	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   420: ldc_w 769
    //   423: invokevirtual 765	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   426: goto -157 -> 269
    //   429: astore_3
    //   430: goto -123 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramString	String
    //   223	129	1	k	int
    //   76	228	2	localObject1	Object
    //   57	261	3	localObject2	Object
    //   429	1	3	localException1	Exception
    //   64	15	4	localKeyStore	java.security.KeyStore
    //   300	5	4	localException2	Exception
    //   7	405	5	localab	ab
    //   16	136	6	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   58	83	300	java/lang/Exception
    //   157	251	378	java/lang/Exception
    //   251	269	378	java/lang/Exception
    //   354	375	378	java/lang/Exception
    //   411	426	378	java/lang/Exception
    //   83	90	429	java/lang/Exception
  }
  
  public static String b(Context paramContext)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    paramContext = c.getServer();
    Object localObject = "";
    if (paramContext != null) {
      localObject = (String)paramContext.s().get("capBssid");
    }
    paramContext = (Context)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = (Context)localObject;
      if (localWifiInfo != null) {
        paramContext = localWifiInfo.getBSSID();
      }
    }
    if (!"\000\000:\000\000:\000\000:\000\000:\000\000:\000\000".equals(paramContext))
    {
      localObject = paramContext;
      if (!"00:00:00:00:00:00".equals(paramContext)) {}
    }
    else
    {
      localObject = "";
    }
    com.bluefay.b.h.a("getcltInfo bssid:" + (String)localObject, new Object[0]);
    return (String)localObject;
  }
  
  public static void b(long paramLong)
  {
    if (h == null) {
      e();
    }
    if ((h != null) && (h.remove(Long.valueOf(paramLong)))) {
      f();
    }
  }
  
  /* Error */
  public static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 612	org/apache/http/params/BasicHttpParams
    //   3: dup
    //   4: invokespecial 613	org/apache/http/params/BasicHttpParams:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: iconst_0
    //   12: invokestatic 619	org/apache/http/params/HttpConnectionParams:setStaleCheckingEnabled	(Lorg/apache/http/params/HttpParams;Z)V
    //   15: aload 6
    //   17: getstatic 50	com/lantern/browser/bp:b	I
    //   20: invokestatic 623	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   23: aload 6
    //   25: getstatic 52	com/lantern/browser/bp:c	I
    //   28: invokestatic 626	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   31: aload 6
    //   33: sipush 8192
    //   36: invokestatic 629	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   39: aload 6
    //   41: iconst_1
    //   42: invokestatic 634	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   45: invokestatic 640	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   48: astore 4
    //   50: invokestatic 645	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   53: invokestatic 649	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   56: astore 5
    //   58: aload 5
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 653	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   65: new 655	com/lantern/browser/b
    //   68: astore_3
    //   69: aload_3
    //   70: aload 5
    //   72: invokespecial 658	com/lantern/browser/b:<init>	(Ljava/security/KeyStore;)V
    //   75: aload_3
    //   76: getstatic 662	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   79: invokevirtual 666	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   82: new 668	org/apache/http/conn/scheme/SchemeRegistry
    //   85: dup
    //   86: invokespecial 669	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   89: astore 4
    //   91: aload 4
    //   93: new 671	org/apache/http/conn/scheme/Scheme
    //   96: dup
    //   97: ldc_w 569
    //   100: invokestatic 676	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   103: bipush 80
    //   105: invokespecial 679	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   108: invokevirtual 683	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   111: pop
    //   112: aload 4
    //   114: new 671	org/apache/http/conn/scheme/Scheme
    //   117: dup
    //   118: ldc_w 571
    //   121: aload_3
    //   122: sipush 443
    //   125: invokespecial 679	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   128: invokevirtual 683	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   131: pop
    //   132: new 685	org/apache/http/impl/client/DefaultHttpClient
    //   135: dup
    //   136: new 687	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   139: dup
    //   140: aload 6
    //   142: aload 4
    //   144: invokespecial 690	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   147: aload 6
    //   149: invokespecial 693	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   152: astore_3
    //   153: new 695	org/apache/http/client/methods/HttpGet
    //   156: astore 4
    //   158: aload 4
    //   160: aload_1
    //   161: invokespecial 696	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   164: aload_3
    //   165: aload 4
    //   167: invokevirtual 716	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   170: astore_3
    //   171: aload_3
    //   172: invokeinterface 722 1 0
    //   177: invokestatic 727	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   180: astore_1
    //   181: aload_3
    //   182: invokeinterface 731 1 0
    //   187: invokeinterface 736 1 0
    //   192: istore_2
    //   193: new 143	java/lang/StringBuilder
    //   196: astore_3
    //   197: aload_3
    //   198: ldc_w 789
    //   201: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_3
    //   205: iload_2
    //   206: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc_w 791
    //   212: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 170	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: sipush 200
    //   232: iload_2
    //   233: if_icmpne +70 -> 303
    //   236: aload_1
    //   237: putstatic 56	com/lantern/browser/bp:d	Ljava/lang/String;
    //   240: new 596	android/os/Handler
    //   243: astore_1
    //   244: aload_1
    //   245: invokestatic 797	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   248: invokespecial 800	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   251: new 802	com/lantern/browser/bt
    //   254: astore_3
    //   255: aload_3
    //   256: aload_0
    //   257: invokespecial 803	com/lantern/browser/bt:<init>	(Landroid/content/Context;)V
    //   260: aload_1
    //   261: aload_3
    //   262: invokevirtual 807	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   265: pop
    //   266: return
    //   267: astore 5
    //   269: aload 4
    //   271: astore_3
    //   272: aload 5
    //   274: astore 4
    //   276: new 143	java/lang/StringBuilder
    //   279: dup
    //   280: ldc_w 752
    //   283: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload 4
    //   288: invokevirtual 753	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 755	com/bluefay/b/h:b	(Ljava/lang/String;)V
    //   300: goto -218 -> 82
    //   303: new 596	android/os/Handler
    //   306: astore_1
    //   307: aload_1
    //   308: invokestatic 797	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   311: invokespecial 800	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   314: new 809	com/lantern/browser/bu
    //   317: astore_3
    //   318: aload_3
    //   319: aload_0
    //   320: invokespecial 810	com/lantern/browser/bu:<init>	(Landroid/content/Context;)V
    //   323: aload_1
    //   324: aload_3
    //   325: invokevirtual 807	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   328: pop
    //   329: goto -63 -> 266
    //   332: astore_1
    //   333: new 596	android/os/Handler
    //   336: dup
    //   337: invokestatic 797	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   340: invokespecial 800	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   343: new 812	com/lantern/browser/bv
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 813	com/lantern/browser/bv:<init>	(Landroid/content/Context;)V
    //   351: invokevirtual 807	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   354: pop
    //   355: goto -89 -> 266
    //   358: astore 4
    //   360: goto -84 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramContext	Context
    //   0	363	1	paramString	String
    //   192	42	2	k	int
    //   68	257	3	localObject1	Object
    //   48	239	4	localObject2	Object
    //   358	1	4	localException1	Exception
    //   56	15	5	localKeyStore	java.security.KeyStore
    //   267	6	5	localException2	Exception
    //   7	141	6	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   50	75	267	java/lang/Exception
    //   153	229	332	java/lang/Exception
    //   236	266	332	java/lang/Exception
    //   303	329	332	java/lang/Exception
    //   75	82	358	java/lang/Exception
  }
  
  public static boolean b()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)c.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo != null) {}
    for (boolean bool = localNetworkInfo.isAvailable();; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    return a(paramWkBrowserWebView, paramString);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("cache", paramString2);
      paramString1 = new Message();
      paramString1.what = 1;
      paramString1.obj = localHashMap;
      j.removeMessages(1);
      j.sendMessage(paramString1);
    }
  }
  
  public static String c(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    WifiInfo localWifiInfo = paramContext.getConnectionInfo();
    if (localWifiInfo != null)
    {
      int k = localWifiInfo.getNetworkId();
      paramContext = paramContext.getConfiguredNetworks();
      if ((paramContext != null) && (k != -1))
      {
        paramContext = paramContext.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            localObject = (WifiConfiguration)paramContext.next();
            if (((WifiConfiguration)localObject).networkId == k)
            {
              com.bluefay.b.h.a("getSsid networkid:" + k + " config.networkId:" + ((WifiConfiguration)localObject).networkId + " config.SSID:" + ((WifiConfiguration)localObject).SSID, new Object[0]);
              paramContext = j(((WifiConfiguration)localObject).SSID);
              localObject = paramContext;
              if (!TextUtils.isEmpty(paramContext)) {
                break;
              }
            }
          }
        }
      }
    }
    for (Object localObject = j(localWifiInfo.getSSID());; localObject = "")
    {
      if (k((String)localObject)) {
        paramContext = "";
      }
      for (;;)
      {
        return paramContext;
        paramContext = ((String)localObject).replaceAll("\000|\001|\002|\003|\004|\005|\006|\007", "*");
        com.bluefay.b.h.a("getSsid ssid:" + paramContext, new Object[0]);
      }
      paramContext = "";
      break;
    }
  }
  
  public static String c(String paramString)
  {
    paramString = e.b(paramString);
    paramString = b.a(new File(d(), paramString + ".wkfeed").getAbsolutePath());
    String str;
    if (paramString != null)
    {
      str = new String(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = str;
        if (!str.contains("javascript:WiFikey.openOrBrowse")) {
          if (!str.contains("/feed.css")) {
            break label88;
          }
        }
      }
    }
    label88:
    for (paramString = str;; paramString = null) {
      return paramString;
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, true);
  }
  
  public static boolean c(long paramLong)
  {
    if (h == null) {
      e();
    }
    if (h != null) {}
    for (boolean bool = h.contains(Long.valueOf(paramLong));; bool = false) {
      return bool;
    }
  }
  
  private static File d()
  {
    if (i == null) {
      i = new File(c.getAppRootDir() + "/feedcache/");
    }
    if (!i.exists()) {
      i.mkdirs();
    }
    return i;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    paramContext = "";
    if (localObject != null) {
      paramContext = ((WifiInfo)localObject).getBSSID();
    }
    if (!"\000\000:\000\000:\000\000:\000\000:\000\000:\000\000".equals(paramContext))
    {
      localObject = paramContext;
      if (!"00:00:00:00:00:00".equals(paramContext)) {}
    }
    else
    {
      localObject = "";
    }
    com.bluefay.b.h.a("getcltInfo bssid:" + (String)localObject, new Object[0]);
    return (String)localObject;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject4 = "";
    }
    for (;;)
    {
      return (String)localObject4;
      Object localObject1 = new z("http://news.51y5.net/news/fa.sec");
      localObject4 = c.getServer();
      Object localObject5 = ((o)localObject4).s();
      ((HashMap)localObject5).put("url", paramString);
      localObject5 = ((o)localObject4).b("00900501", (HashMap)localObject5);
      localObject4 = "";
      try
      {
        localObject1 = ((z)localObject1).a((Map)localObject5);
        localObject5 = new org/json/JSONObject;
        ((JSONObject)localObject5).<init>((String)localObject1);
        localObject1 = localObject4;
        if (((JSONObject)localObject5).has("url")) {
          localObject1 = ((JSONObject)localObject5).getString("url");
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          com.bluefay.b.h.a(localSocketTimeoutException);
          Object localObject2 = localObject4;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.bluefay.b.h.a(localException);
          Object localObject3 = localObject4;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = localObject1;
        if (!paramString.startsWith((String)localObject1)) {}
      }
      else
      {
        localObject4 = paramString;
      }
    }
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramString.startsWith("file:///android_asset/"))
      {
        bool = false;
      }
      else
      {
        paramString = Uri.parse(paramString.replaceAll(" ", "%20")).getHost();
        paramContext = ((DomainZenmenConf)d.a(paramContext).a(DomainZenmenConf.class)).d();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext()) {
              if (paramString.indexOf((String)paramContext.next()) != -1)
              {
                bool = false;
                break;
              }
            }
          }
        }
        bool = true;
      }
    }
  }
  
  public static String e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        if ((!paramContext.startsWith("46000")) && (!paramContext.startsWith("46002"))) {
          continue;
        }
        paramContext = "CMCC";
      }
      catch (Exception paramContext)
      {
        com.bluefay.b.h.a(paramContext);
        paramContext = "Other";
        continue;
      }
      return paramContext;
      if (paramContext.startsWith("46001"))
      {
        paramContext = "Unicom";
      }
      else
      {
        if (!paramContext.startsWith("46003")) {
          continue;
        }
        paramContext = "ChinaNet";
      }
    }
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      int k;
      if (paramString == null) {
        k = -1;
      }
      for (;;)
      {
        if (k != -1) {
          break label48;
        }
        paramString = "";
        break;
        int m = paramString.lastIndexOf(".");
        k = m;
        if (l(paramString) > m) {
          k = -1;
        }
      }
      label48:
      paramString = paramString.substring(k + 1).split("\\?")[0].split("#")[0].split("@")[0];
    }
  }
  
  private static void e()
  {
    if (h != null) {
      h.clear();
    }
    h = new ArrayList();
    Object localObject = f.a(com.bluefay.d.a.getAppContext(), "sdk_common", "appointment_download", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int m = localObject.length;
        int k = 0;
        for (;;)
        {
          if (k < m)
          {
            String str = localObject[k];
            try
            {
              h.add(Long.valueOf(Long.parseLong(str)));
              k++;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.bluefay.b.h.a(localException);
              }
            }
          }
        }
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
      localStringBuilder2.<init>("v=");
      localStringBuilder1.append(k.b(paramContext));
      localStringBuilder2 = new java/lang/StringBuilder;
      localStringBuilder2.<init>("&appid=");
      localStringBuilder1.append(c.getServer().k());
      localStringBuilder2 = new java/lang/StringBuilder;
      localStringBuilder2.<init>("&chanid=");
      localStringBuilder1.append(k.l(paramContext));
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>("&lang=");
      localStringBuilder1.append(k.c());
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>("&uhid=");
      localStringBuilder1.append(p.c(""));
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>("&dhid=");
      localStringBuilder1.append(p.b(""));
      return localStringBuilder1.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramContext);
      }
    }
  }
  
  public static String f(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      String str = Uri.parse(paramString).getPath();
      if (str != null)
      {
        int k = str.indexOf('?');
        paramString = str;
        if (k > 0) {
          paramString = str.substring(0, k);
        }
        paramString = paramString.substring(l(paramString) + 1).split("\\?")[0].split("#")[0].split("@")[0];
      }
      else
      {
        paramString = null;
      }
    }
  }
  
  private static void f()
  {
    int m = 0;
    if (h == null) {}
    for (;;)
    {
      return;
      int n = h.size();
      if (n > 0)
      {
        if (n > 100)
        {
          localObject = h.iterator();
          for (k = 0; (((Iterator)localObject).hasNext()) && (k < n - 100); k++)
          {
            ((Iterator)localObject).next();
            ((Iterator)localObject).remove();
          }
        }
        Object localObject = new StringBuilder();
        n = h.size();
        for (int k = m; k < n; k++)
        {
          ((StringBuilder)localObject).append(h.get(k));
          if (k + 1 < n) {
            ((StringBuilder)localObject).append(",");
          }
        }
        if (((StringBuilder)localObject).length() > 0) {
          f.b(com.bluefay.d.a.getAppContext(), "sdk_common", "appointment_download", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  /* Error */
  public static void g(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   3: ifnull +212 -> 215
    //   6: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   9: astore 6
    //   11: aload 6
    //   13: monitorenter
    //   14: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   17: invokeinterface 1023 1 0
    //   22: istore_2
    //   23: iload_2
    //   24: ifle +188 -> 212
    //   27: iload_2
    //   28: bipush 100
    //   30: if_icmple +55 -> 85
    //   33: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   36: invokeinterface 1027 1 0
    //   41: invokeinterface 1030 1 0
    //   46: astore_3
    //   47: iconst_0
    //   48: istore_1
    //   49: aload_3
    //   50: invokeinterface 132 1 0
    //   55: ifeq +30 -> 85
    //   58: iload_1
    //   59: iload_2
    //   60: bipush 100
    //   62: isub
    //   63: if_icmpge +22 -> 85
    //   66: aload_3
    //   67: invokeinterface 136 1 0
    //   72: pop
    //   73: aload_3
    //   74: invokeinterface 1015 1 0
    //   79: iinc 1 1
    //   82: goto -33 -> 49
    //   85: aconst_null
    //   86: astore 5
    //   88: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   91: invokeinterface 1027 1 0
    //   96: invokeinterface 1030 1 0
    //   101: astore 4
    //   103: aload_0
    //   104: invokevirtual 1033	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   107: ldc_w 1035
    //   110: invokevirtual 1039	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   113: astore_0
    //   114: new 1041	java/io/FileWriter
    //   117: astore_3
    //   118: aload_3
    //   119: aload_0
    //   120: invokespecial 1044	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   123: aload 4
    //   125: invokeinterface 132 1 0
    //   130: ifeq +86 -> 216
    //   133: aload 4
    //   135: invokeinterface 136 1 0
    //   140: checkcast 1046	java/util/Map$Entry
    //   143: astore_0
    //   144: new 143	java/lang/StringBuilder
    //   147: astore 5
    //   149: aload 5
    //   151: invokespecial 430	java/lang/StringBuilder:<init>	()V
    //   154: aload_3
    //   155: aload 5
    //   157: aload_0
    //   158: invokeinterface 1049 1 0
    //   163: checkcast 28	java/lang/String
    //   166: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 1051
    //   172: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokeinterface 1054 1 0
    //   181: invokevirtual 873	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w 1056
    //   187: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 1059	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   196: goto -73 -> 123
    //   199: astore 4
    //   201: aload_3
    //   202: astore_0
    //   203: aload 4
    //   205: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   208: aload_0
    //   209: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   212: aload 6
    //   214: monitorexit
    //   215: return
    //   216: aload_3
    //   217: invokevirtual 1064	java/io/FileWriter:flush	()V
    //   220: aload_3
    //   221: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   224: goto -12 -> 212
    //   227: astore_0
    //   228: aload 6
    //   230: monitorexit
    //   231: aload_0
    //   232: athrow
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_3
    //   236: aload_3
    //   237: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: goto -7 -> 236
    //   246: astore_3
    //   247: aload_0
    //   248: astore 4
    //   250: aload_3
    //   251: astore_0
    //   252: aload 4
    //   254: astore_3
    //   255: goto -19 -> 236
    //   258: astore 4
    //   260: aload 5
    //   262: astore_0
    //   263: goto -60 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramContext	Context
    //   48	32	1	k	int
    //   22	41	2	m	int
    //   46	191	3	localObject1	Object
    //   246	5	3	localObject2	Object
    //   254	1	3	localObject3	Object
    //   101	33	4	localIterator	Iterator
    //   199	5	4	localIOException1	IOException
    //   248	5	4	localContext	Context
    //   258	1	4	localIOException2	IOException
    //   86	175	5	localStringBuilder	StringBuilder
    //   9	220	6	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   123	196	199	java/io/IOException
    //   216	220	199	java/io/IOException
    //   14	23	227	finally
    //   33	47	227	finally
    //   49	58	227	finally
    //   66	79	227	finally
    //   208	212	227	finally
    //   212	215	227	finally
    //   220	224	227	finally
    //   228	231	227	finally
    //   236	242	227	finally
    //   88	123	233	finally
    //   123	196	242	finally
    //   216	220	242	finally
    //   203	208	246	finally
    //   88	123	258	java/io/IOException
  }
  
  public static boolean g(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = a;
      m = arrayOfString.length;
    }
    for (int k = 0;; k++)
    {
      bool1 = bool2;
      if (k < m)
      {
        if (paramString.equals(arrayOfString[k])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  public static String h(Context paramContext)
  {
    NetworkInfo localNetworkInfo;
    String str;
    if (paramContext != null)
    {
      localNetworkInfo = j(paramContext);
      str = "";
      paramContext = str;
      if (localNetworkInfo != null)
      {
        paramContext = str;
        if (localNetworkInfo.isConnected())
        {
          if (localNetworkInfo.getType() != 1) {
            break label41;
          }
          paramContext = "w";
        }
      }
    }
    for (;;)
    {
      return paramContext;
      label41:
      paramContext = str;
      if (localNetworkInfo.getType() == 0) {
        switch (localNetworkInfo.getSubtype())
        {
        default: 
          str = localNetworkInfo.getSubtypeName();
          if ((!str.equalsIgnoreCase("TD-SCDMA")) && (!str.equalsIgnoreCase("WCDMA")))
          {
            paramContext = str;
            if (!str.equalsIgnoreCase("CDMA2000")) {}
          }
          else
          {
            paramContext = "3g";
          }
          break;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          paramContext = "2g";
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          paramContext = "3g";
          break;
        case 13: 
          paramContext = "4g";
          continue;
          paramContext = null;
        }
      }
    }
  }
  
  public static void h(String paramString)
  {
    if (g == null) {
      g = new ArrayList();
    }
    if (!TextUtils.isEmpty(paramString)) {
      g.add(paramString);
    }
  }
  
  /* Error */
  private static void i(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   3: ifnonnull +13 -> 16
    //   6: new 1099	java/util/LinkedHashMap
    //   9: dup
    //   10: invokespecial 1100	java/util/LinkedHashMap:<init>	()V
    //   13: putstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   16: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: aload_0
    //   25: invokevirtual 1033	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   28: ldc_w 1035
    //   31: invokevirtual 1039	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   34: astore_0
    //   35: new 1102	java/io/BufferedReader
    //   38: astore_3
    //   39: new 1104	java/io/FileReader
    //   42: astore 4
    //   44: aload 4
    //   46: aload_0
    //   47: invokespecial 1105	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   50: aload_3
    //   51: aload 4
    //   53: invokespecial 1108	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   56: aload_3
    //   57: astore_0
    //   58: aload_3
    //   59: invokevirtual 1111	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +101 -> 167
    //   69: aload_3
    //   70: astore_0
    //   71: aload 4
    //   73: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne -20 -> 56
    //   79: aload_3
    //   80: astore_0
    //   81: aload 4
    //   83: ldc_w 1051
    //   86: invokevirtual 951	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   89: astore 4
    //   91: aload_3
    //   92: astore_0
    //   93: aload 4
    //   95: arraylength
    //   96: iconst_2
    //   97: if_icmpne -41 -> 56
    //   100: aload_3
    //   101: astore_0
    //   102: aload 4
    //   104: iconst_0
    //   105: aaload
    //   106: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore_2
    //   110: iload_2
    //   111: ifne -55 -> 56
    //   114: aload_3
    //   115: astore_0
    //   116: aload 4
    //   118: iconst_1
    //   119: aaload
    //   120: invokestatic 1114	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   123: istore_1
    //   124: iload_1
    //   125: ifeq -69 -> 56
    //   128: aload_3
    //   129: astore_0
    //   130: getstatic 60	com/lantern/browser/bp:f	Ljava/util/Map;
    //   133: aload 4
    //   135: iconst_0
    //   136: aaload
    //   137: iload_1
    //   138: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: invokeinterface 286 3 0
    //   146: pop
    //   147: goto -91 -> 56
    //   150: astore 4
    //   152: aload_3
    //   153: astore_0
    //   154: aload 4
    //   156: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   159: aload_3
    //   160: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   163: aload 5
    //   165: monitorexit
    //   166: return
    //   167: aload_3
    //   168: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   171: goto -8 -> 163
    //   174: astore_0
    //   175: aload 5
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    //   180: astore_3
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: invokestatic 1061	com/lantern/browser/bp:a	(Ljava/io/Closeable;)V
    //   187: aload_3
    //   188: athrow
    //   189: astore_3
    //   190: goto -7 -> 183
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_3
    //   197: goto -45 -> 152
    //   200: astore_0
    //   201: goto -145 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramContext	Context
    //   123	15	1	k	int
    //   109	2	2	bool	boolean
    //   38	130	3	localBufferedReader	java.io.BufferedReader
    //   180	8	3	localObject1	Object
    //   189	1	3	localObject2	Object
    //   196	1	3	localObject3	Object
    //   42	92	4	localObject4	Object
    //   150	5	4	localIOException1	IOException
    //   193	1	4	localIOException2	IOException
    //   19	157	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   58	64	150	java/io/IOException
    //   71	79	150	java/io/IOException
    //   81	91	150	java/io/IOException
    //   93	100	150	java/io/IOException
    //   102	110	150	java/io/IOException
    //   116	124	150	java/io/IOException
    //   130	147	150	java/io/IOException
    //   159	163	174	finally
    //   163	166	174	finally
    //   167	171	174	finally
    //   175	178	174	finally
    //   183	189	174	finally
    //   24	56	180	finally
    //   58	64	189	finally
    //   71	79	189	finally
    //   81	91	189	finally
    //   93	100	189	finally
    //   102	110	189	finally
    //   116	124	189	finally
    //   130	147	189	finally
    //   154	159	189	finally
    //   24	56	193	java/io/IOException
    //   116	124	200	java/lang/NumberFormatException
  }
  
  public static boolean i(String paramString)
  {
    if ((g == null) || (TextUtils.isEmpty(paramString))) {}
    for (boolean bool = false;; bool = g.contains(paramString)) {
      return bool;
    }
  }
  
  private static NetworkInfo j(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          return paramContext;
        }
        paramContext = null;
        continue;
        paramContext = null;
      }
      catch (Throwable paramContext)
      {
        com.lantern.wifilocating.push.util.h.a(paramContext);
      }
    }
  }
  
  private static String j(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      return str;
      int k = paramString.length();
      str = paramString;
      if (k > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == '"')
        {
          str = paramString;
          if (paramString.charAt(k - 1) == '"') {
            str = paramString.substring(1, k - 1);
          }
        }
      }
    }
  }
  
  private static boolean k(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("0x")) || (paramString.startsWith("0X")) || (paramString.equalsIgnoreCase("<unknown ssid>")) || (paramString.equalsIgnoreCase("null"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int l(String paramString)
  {
    if (paramString == null) {}
    for (int k = -1;; k = Math.max(paramString.lastIndexOf("/"), paramString.lastIndexOf("\\"))) {
      return k;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */