package com.lantern.webox.browser;

import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebView;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.k;
import com.lantern.webox.a.t;
import com.lantern.webox.a.u;
import com.lantern.webox.domain.AppStoreQuery;
import com.lantern.webox.domain.InvokeResult;
import com.lantern.webox.domain.WebAppConfig;
import com.lantern.webox.event.WebEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class BrowserJsInterface
{
  private static final int ERROR_CODE_CANCEL = 0;
  private com.lantern.webox.b.c scriptBridge;
  private WkBrowserWebView webox;
  
  public BrowserJsInterface(WkBrowserWebView paramWkBrowserWebView)
  {
    this.webox = paramWkBrowserWebView;
    this.scriptBridge = new com.lantern.webox.b.c();
    this.scriptBridge.a(true);
  }
  
  private Map<String, Object> buildError(int paramInt, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", Integer.valueOf(paramInt));
    if (paramObject != null) {
      localHashMap.put("msg", paramObject.toString());
    }
    return localHashMap;
  }
  
  private Map<String, Object> decodeParams(String paramString)
  {
    return com.lantern.webox.c.b.a(paramString.toString());
  }
  
  private boolean securityCheck(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.webox.e() == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!this.webox.e().isDisabled()) {
        if (this.webox.e().getSecurityLevel() < paramInt)
        {
          new AlertDialog.Builder(this.webox.getContext()).setCancelable(false).setMessage("your web app has not the security level to invoke this api").setPositiveButton(17039370, null).show();
          bool1 = bool2;
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public void activateApp(String paramString)
  {
    com.bluefay.b.h.a("activateApp " + paramString, new Object[0]);
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      ((com.lantern.webox.a.a)com.lantern.webox.d.a(com.lantern.webox.a.a.class)).a(this.webox, paramString);
    }
  }
  
  public String addEventListener(String paramString)
  {
    if (!securityCheck(2)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Object localObject = decodeParams(paramString);
      paramString = (String)((Map)localObject).get("type");
      localObject = (String)((Map)localObject).get("listener");
      if ((paramString == null) || (localObject == null)) {
        paramString = null;
      } else {
        paramString = ((com.lantern.webox.handler.d)this.webox.a("eventBridge")).a(paramString, new r(this, (String)localObject)).toString();
      }
    }
  }
  
  public void appointmentDownload(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      ((k)com.lantern.webox.d.a(k.class)).a(paramString);
    }
  }
  
  public void backward(String paramString)
  {
    paramString = decodeParams(paramString).get("step");
    if (paramString != null) {}
    for (int i = Integer.parseInt(paramString.toString());; i = 1)
    {
      ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).a(this.webox, i);
      return;
    }
  }
  
  public void checkJsApi(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        paramString = ((JSONObject)localObject).optString("onResult");
        com.bluefay.b.h.a(localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str2 = ((JSONObject)localObject).optString("data");
          localObject = paramString;
          paramString = str2;
          str2 = paramString;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2))) {
            break label60;
          }
          return;
        }
        catch (Exception localException2)
        {
          String str2;
          String str1;
          for (;;) {}
        }
        localException1 = localException1;
        paramString = "";
      }
      str2 = "";
      str1 = paramString;
      continue;
      label60:
      ((com.lantern.webox.a.h)com.lantern.webox.d.a(com.lantern.webox.a.h.class)).a(this.webox, str2, new j(this, str1));
    }
  }
  
  public void closeBannerAd(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).b(this.webox);
  }
  
  public void closeBrowser(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).a(this.webox);
  }
  
  public void createShortCut(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      try
      {
        ((com.lantern.webox.a.i)com.lantern.webox.d.a(com.lantern.webox.a.i.class)).b(this.webox, paramString);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a(paramString);
      }
    }
  }
  
  public void dispatchEvent(String paramString)
  {
    com.lantern.webox.event.a locala = (com.lantern.webox.event.a)com.lantern.webox.d.a(com.lantern.webox.event.a.class);
    paramString = decodeParams(paramString);
    locala.a(new WebEvent(this.webox, 300, paramString));
  }
  
  public void downloadApp(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      com.lantern.webox.a.d locald = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(paramString);
        locald.a(this.webox, localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app store download error", paramString);
      }
    }
  }
  
  public void fetchInfo(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      Object localObject = paramString.get("onResult");
      if (localObject != null) {
        ((com.lantern.webox.a.q)com.lantern.webox.d.a(com.lantern.webox.a.q.class)).a(this.webox, paramString, new g(this, localObject));
      }
    }
  }
  
  public void forward(String paramString)
  {
    paramString = decodeParams(paramString).get("step");
    if (paramString != null) {}
    for (int i = Integer.parseInt(paramString.toString());; i = 1)
    {
      ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).b(this.webox, i);
      return;
    }
  }
  
  /* Error */
  public void getAppStatus(String paramString)
  {
    // Byte code:
    //   0: new 123	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 280
    //   7: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 137	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_0
    //   25: iconst_2
    //   26: invokespecial 139	com/lantern/webox/browser/BrowserJsInterface:securityCheck	(I)Z
    //   29: ifne +4 -> 33
    //   32: return
    //   33: new 197	org/json/JSONObject
    //   36: astore_2
    //   37: aload_2
    //   38: aload_1
    //   39: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: aload_2
    //   43: ldc -56
    //   45: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_2
    //   50: ldc -51
    //   52: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: astore_1
    //   60: aload_2
    //   61: astore_3
    //   62: aload_1
    //   63: astore_2
    //   64: aload_3
    //   65: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne -36 -> 32
    //   71: aload_2
    //   72: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne -43 -> 32
    //   78: ldc -115
    //   80: invokestatic 146	com/lantern/webox/d:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   83: checkcast 141	com/lantern/webox/a/a
    //   86: aload_0
    //   87: getfield 18	com/lantern/webox/browser/BrowserJsInterface:webox	Lcom/lantern/browser/WkBrowserWebView;
    //   90: aload_2
    //   91: new 282	com/lantern/webox/browser/k
    //   94: dup
    //   95: aload_0
    //   96: aload_3
    //   97: invokespecial 283	com/lantern/webox/browser/k:<init>	(Lcom/lantern/webox/browser/BrowserJsInterface;Ljava/lang/String;)V
    //   100: invokeinterface 286 4 0
    //   105: goto -73 -> 32
    //   108: astore_2
    //   109: ldc -43
    //   111: astore_1
    //   112: aload_2
    //   113: invokestatic 216	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   116: ldc -43
    //   118: astore_2
    //   119: aload_1
    //   120: astore_3
    //   121: goto -57 -> 64
    //   124: astore_2
    //   125: goto -13 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	BrowserJsInterface
    //   0	128	1	paramString	String
    //   36	55	2	localObject1	Object
    //   108	5	2	localException1	Exception
    //   118	1	2	str	String
    //   124	1	2	localException2	Exception
    //   55	66	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	49	108	java/lang/Exception
    //   49	56	124	java/lang/Exception
  }
  
  public void getDeviceInfo(String paramString)
  {
    if (!securityCheck(0)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null)
      {
        Object localObject = ((com.lantern.webox.a.j)com.lantern.webox.d.a(com.lantern.webox.a.j.class)).a(this.webox);
        this.scriptBridge.a(this.webox, paramString, new InvokeResult(0, localObject));
      }
    }
  }
  
  public String getJsApiVersion(String paramString)
  {
    return "0.0.4";
  }
  
  public void getLalo(String paramString)
  {
    if (!securityCheck(0)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((com.lantern.webox.a.l)com.lantern.webox.d.a(com.lantern.webox.a.l.class)).b(new b(this, paramString));
      }
    }
  }
  
  public void getLocation(String paramString)
  {
    if (!securityCheck(0)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((com.lantern.webox.a.l)com.lantern.webox.d.a(com.lantern.webox.a.l.class)).a(new s(this, paramString));
      }
    }
  }
  
  public void getNetworkStatus(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((com.lantern.webox.a.m)com.lantern.webox.d.a(com.lantern.webox.a.m.class)).a(this.webox, new p(this, paramString));
      }
    }
  }
  
  public String getShareData(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = (String)com.lantern.webox.c.b.a(paramString, String.class);
    }
    for (paramString = PreferenceManager.getDefaultSharedPreferences(this.webox.getContext()).getString(paramString, "");; paramString = "") {
      return paramString;
    }
  }
  
  public void getUserInfo(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString);
      paramString = (t)com.lantern.webox.d.a(t.class);
      localObject = ((Map)localObject).get("onResult");
      if (localObject != null) {
        paramString.a(this.webox, new m(this, localObject));
      }
    }
  }
  
  public void getWifiNodes(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((u)com.lantern.webox.d.a(u.class)).a(this.webox, new f(this, paramString));
      }
    }
  }
  
  public void hasUserLogin(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((t)com.lantern.webox.d.a(t.class)).a(this.webox, new n(this, paramString));
      }
    }
  }
  
  public void hideActionBar(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).f(this.webox);
  }
  
  public void hideOptionMenu(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).d(this.webox);
  }
  
  public void init(String paramString)
  {
    paramString = decodeParams(paramString);
    Object localObject = paramString.get("success");
    String str2;
    String str1;
    if (localObject != null)
    {
      if (this.webox.e() != null) {
        this.scriptBridge.a(this.webox, localObject, null);
      }
    }
    else
    {
      localObject = paramString.get("auth");
      if (localObject != null)
      {
        str2 = (String)paramString.get("appId");
        str1 = (String)paramString.get("timestamp");
        paramString = (String)paramString.get("sign");
        if (this.webox.e() == null) {
          break label164;
        }
        boolean bool = this.webox.f().a(str2, str1, paramString);
        this.scriptBridge.a(this.webox, localObject, Boolean.valueOf(bool));
      }
    }
    for (;;)
    {
      return;
      localObject = new a(this, localObject);
      this.webox.a((com.lantern.webox.event.c)localObject);
      break;
      label164:
      paramString = new l(this, str2, str1, paramString, localObject);
      this.webox.a(paramString);
    }
  }
  
  public void installApp(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      com.lantern.webox.a.d locald = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(paramString);
        locald.b(localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app store installApp error", paramString);
      }
    }
  }
  
  public void isAppInstalled(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString);
      paramString = ((Map)localObject).get("onResult");
      localObject = ((Map)localObject).get("packageName");
      if (paramString != null) {
        if (localObject == null)
        {
          this.scriptBridge.a(this.webox, paramString, new InvokeResult(0, Boolean.valueOf(false)));
        }
        else
        {
          boolean bool = ((com.lantern.webox.a.c)com.lantern.webox.d.a(com.lantern.webox.a.c.class)).a(this.webox, (String)localObject);
          this.scriptBridge.a(this.webox, paramString, new InvokeResult(0, Boolean.valueOf(bool)));
        }
      }
    }
  }
  
  public void isGuest(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null)
      {
        com.lantern.webox.d.a(t.class);
        this.scriptBridge.a(this.webox, paramString, new InvokeResult(0, Boolean.valueOf(false)));
      }
    }
  }
  
  public void isWXSupported(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString).get("onResult");
      if (localObject != null)
      {
        paramString = (com.lantern.webox.a.r)com.lantern.webox.d.a(com.lantern.webox.a.r.class);
        this.scriptBridge.a(this.webox, localObject, new InvokeResult(0, Boolean.valueOf(paramString.a())));
      }
    }
  }
  
  public void openApp(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      com.lantern.webox.a.d locald = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(paramString);
        locald.c(localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app store openApp error", paramString);
      }
    }
  }
  
  public void openAppDetail(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      com.lantern.webox.a.d locald = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(paramString);
        locald.c(this.webox, localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app detal error", paramString);
      }
    }
  }
  
  public void openAppStore(String paramString)
  {
    paramString = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
    try
    {
      paramString.a(this.webox);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.bluefay.b.h.a("app store open error", paramString);
      }
    }
  }
  
  public void openBrowser(String paramString)
  {
    paramString = decodeParams(paramString);
    com.lantern.webox.a.g localg = (com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class);
    paramString = paramString.get("url");
    WkBrowserWebView localWkBrowserWebView = this.webox;
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      localg.a(localWkBrowserWebView, paramString);
      return;
    }
  }
  
  public void order(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((com.lantern.webox.a.n)com.lantern.webox.d.a(com.lantern.webox.a.n.class)).a(new d(this, paramString));
      }
    }
  }
  
  public void pauseDownload(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      Map localMap = decodeParams(paramString);
      paramString = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(localMap);
        paramString.a(localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app store pauseDownload error", paramString);
      }
    }
  }
  
  public void readAppStatus(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      Object localObject2 = decodeParams(paramString);
      paramString = ((Map)localObject2).get("onResult");
      if (paramString != null)
      {
        com.lantern.webox.a.d locald = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
        try
        {
          localObject1 = new java/util/LinkedList;
          ((LinkedList)localObject1).<init>();
          localObject3 = ((List)((Map)localObject2).get("apps")).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = ((Iterator)localObject3).next();
            AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
            localAppStoreQuery.<init>((Map)localObject2);
            ((List)localObject1).add(localAppStoreQuery);
          }
        }
        catch (Exception localException)
        {
          com.bluefay.b.h.a("app store read status error", localException);
          this.scriptBridge.a(this.webox, paramString, new InvokeResult(1, buildError(1, localException)));
        }
        Object localObject1 = localException.a(this.webox, (List)localObject1);
        com.lantern.webox.b.c localc = this.scriptBridge;
        Object localObject3 = this.webox;
        localObject2 = new com/lantern/webox/domain/InvokeResult;
        ((InvokeResult)localObject2).<init>(0, localObject1);
        localc.a((WebView)localObject3, paramString, localObject2);
      }
    }
  }
  
  public void register(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString);
      paramString = (t)com.lantern.webox.d.a(t.class);
      localObject = ((Map)localObject).get("onResult");
      if (localObject != null) {
        paramString.a(new o(this, localObject));
      }
    }
  }
  
  public void removeEventListener(String paramString)
  {
    paramString = decodeParams(paramString).get("id");
    ((com.lantern.webox.handler.d)this.webox.a("eventBridge")).a(paramString);
  }
  
  public void resumeDownload(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      Map localMap = decodeParams(paramString);
      paramString = (com.lantern.webox.a.d)com.lantern.webox.d.a(com.lantern.webox.a.d.class);
      try
      {
        AppStoreQuery localAppStoreQuery = new com/lantern/webox/domain/AppStoreQuery;
        localAppStoreQuery.<init>(localMap);
        paramString.b(this.webox, localAppStoreQuery);
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a("app store resumeDownload error", paramString);
      }
    }
  }
  
  public void scanBarcode(String paramString)
  {
    if (!securityCheck(0)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString).get("onResult");
      if (paramString != null) {
        ((com.lantern.webox.a.f)com.lantern.webox.d.a(com.lantern.webox.a.f.class)).a(new c(this, paramString));
      }
    }
  }
  
  public void sendSMS(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString);
      paramString = (String)((Map)localObject).get("phoNum");
      String str = (String)((Map)localObject).get("msg");
      if ((paramString != null) && (str != null))
      {
        com.lantern.webox.a.p localp = (com.lantern.webox.a.p)com.lantern.webox.d.a(com.lantern.webox.a.p.class);
        if (((Map)localObject).get("withUI") != null)
        {
          localp.a(this.webox, paramString, str);
        }
        else
        {
          localObject = ((Map)localObject).get("onResult");
          localp.a(this.webox, paramString, str, new e(this, localObject));
        }
      }
    }
  }
  
  public void setShareData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = com.lantern.webox.c.b.a(paramString);
      paramString = PreferenceManager.getDefaultSharedPreferences(this.webox.getContext()).edit();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        try
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          paramString.putString((String)localEntry.getKey(), String.valueOf(localEntry.getValue()));
        }
        catch (Exception localException) {}
      }
      paramString.commit();
    }
  }
  
  public void shareInfo(String paramString)
  {
    if (!securityCheck(1)) {}
    for (;;)
    {
      return;
      Map localMap = decodeParams(paramString);
      paramString = localMap.get("onResult");
      ((com.lantern.webox.a.r)com.lantern.webox.d.a(com.lantern.webox.a.r.class)).a(this.webox, localMap, new q(this, paramString));
    }
  }
  
  public void showActionBar(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).e(this.webox);
  }
  
  public void showOptionMenu(String paramString)
  {
    ((com.lantern.webox.a.g)com.lantern.webox.d.a(com.lantern.webox.a.g.class)).c(this.webox);
  }
  
  public void signCustomParams(String paramString)
  {
    if (!securityCheck(2)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        paramString = ((JSONObject)localObject).optString("onResult");
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject = ((JSONObject)localObject).optString("data");
          str2 = paramString;
          paramString = (String)localObject;
          if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramString))) {
            break;
          }
          ((com.lantern.webox.a.q)com.lantern.webox.d.a(com.lantern.webox.a.q.class)).b(paramString, new i(this, str2));
        }
        catch (Exception localException2)
        {
          String str2;
          String str1;
          for (;;) {}
        }
        localException1 = localException1;
        paramString = "";
      }
      com.bluefay.b.h.a(localException1);
      str1 = paramString;
      paramString = "";
      str2 = str1;
    }
  }
  
  /* Error */
  public void signParams(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokespecial 139	com/lantern/webox/browser/BrowserJsInterface:securityCheck	(I)Z
    //   5: ifne +4 -> 9
    //   8: return
    //   9: new 197	org/json/JSONObject
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: invokespecial 198	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: ldc -56
    //   21: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_2
    //   26: ldc -51
    //   28: invokevirtual 203	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_1
    //   33: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne -28 -> 8
    //   39: aload_2
    //   40: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne -35 -> 8
    //   46: ldc_w 266
    //   49: invokestatic 146	com/lantern/webox/d:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   52: checkcast 266	com/lantern/webox/a/q
    //   55: aload_2
    //   56: new 589	com/lantern/webox/browser/h
    //   59: dup
    //   60: aload_0
    //   61: aload_1
    //   62: invokespecial 590	com/lantern/webox/browser/h:<init>	(Lcom/lantern/webox/browser/BrowserJsInterface;Ljava/lang/String;)V
    //   65: invokeinterface 592 3 0
    //   70: goto -62 -> 8
    //   73: astore_2
    //   74: ldc -43
    //   76: astore_1
    //   77: aload_2
    //   78: invokestatic 216	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   81: ldc -43
    //   83: astore_2
    //   84: goto -52 -> 32
    //   87: astore_2
    //   88: goto -11 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	BrowserJsInterface
    //   0	91	1	paramString	String
    //   12	44	2	localObject	Object
    //   73	5	2	localException1	Exception
    //   83	1	2	str	String
    //   87	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	25	73	java/lang/Exception
    //   25	32	87	java/lang/Exception
  }
  
  public void startComponent(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      ((com.lantern.webox.a.i)com.lantern.webox.d.a(com.lantern.webox.a.i.class)).a(this.webox, paramString);
    }
  }
  
  public void trace(String paramString)
  {
    if (!securityCheck(2)) {}
    for (;;)
    {
      return;
      Object localObject = decodeParams(paramString);
      paramString = ((Map)localObject).get("type");
      localObject = ((Map)localObject).get("data");
      ((com.lantern.webox.a.s)com.lantern.webox.d.a(com.lantern.webox.a.s.class)).a(paramString.toString(), localObject.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/browser/BrowserJsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */