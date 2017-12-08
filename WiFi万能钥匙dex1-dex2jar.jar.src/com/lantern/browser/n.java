package com.lantern.browser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Toast;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.d.a.c;
import com.lantern.core.g;
import com.lantern.webox.d;
import com.lantern.webox.event.WebEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public static final String a = Environment.getExternalStorageDirectory() + "/WifiMasterKey/apk";
  public static final String b = Environment.getExternalStorageDirectory() + "/WifiMasterKey/WiFiMasterPic";
  private static n d;
  private com.lantern.core.d.a c;
  private List<Long> e = new ArrayList();
  private List<Long> f = new ArrayList();
  private Context g;
  private File h;
  private w i;
  private BroadcastReceiver j;
  private BroadcastReceiver k;
  private boolean l;
  private HashMap<Long, j> m = new HashMap();
  private com.lantern.browser.a.a n;
  
  private long a(k paramk, String paramString1, String paramString2)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    String str2 = paramk.c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = URLUtil.guessFileName(paramk.e(), paramString1, paramString2);
    }
    paramString1 = Uri.parse(paramk.e().replaceAll(" ", "%20"));
    try
    {
      paramString2 = new com/lantern/core/d/a$c;
      paramString2.<init>(paramString1);
      paramString2.a(paramk.g());
      paramString2.b("/WifiMasterKey/apk", str1);
      l1 = a().a(paramString2);
    }
    catch (Exception paramk)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
    return l1;
  }
  
  private long a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = URLUtil.guessFileName(paramString2, paramString3, paramString4);
    }
    paramString2 = Uri.parse(paramString2.replaceAll(" ", "%20"));
    try
    {
      paramString1 = new com/lantern/core/d/a$c;
      paramString1.<init>(paramString2);
      if (!TextUtils.isEmpty(paramString4)) {
        paramString1.a(paramString4);
      }
      if (!paramBoolean) {
        break label140;
      }
      paramString1.b("/WifiMasterKey/WiFiMasterPic", str);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        paramString1.b("/WifiMasterKey/apk", str);
        continue;
        boolean bool1 = false;
        continue;
        paramBoolean = false;
      }
    }
    if (!paramBoolean)
    {
      bool1 = true;
      paramString1.a(bool1);
      if (paramBoolean) {
        break label158;
      }
      paramBoolean = bool2;
      paramString1.b(paramBoolean);
      l1 = a().a(paramString1);
      return l1;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    String str2 = bp.f(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(bp.e(str2))) {
      str1 = URLUtil.guessFileName(paramString1, paramString2, paramString3);
    }
    CookieManager.getInstance().getCookie(paramString1);
    long l1 = a(str1, paramString1, paramString2, paramString3, paramBoolean);
    if (paramBoolean) {
      this.f.add(Long.valueOf(l1));
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("udl0000");
      return l1;
      this.e.add(Long.valueOf(l1));
    }
  }
  
  public static void a(j paramj)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "appChange");
    localHashMap.put("status", paramj.h());
    localHashMap.put("packageName", paramj.c());
    localHashMap.put("appHid", paramj.g());
    localHashMap.put("progress", Integer.valueOf(paramj.i()));
    ((com.lantern.webox.event.a)d.a(com.lantern.webox.event.a.class)).a(new WebEvent(null, 200, localHashMap));
  }
  
  public static void a(k paramk)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "appChange");
    localHashMap.put("status", paramk.f());
    localHashMap.put("packageName", paramk.d());
    localHashMap.put("appHid", paramk.a());
    ((com.lantern.webox.event.a)d.a(com.lantern.webox.event.a.class)).a(new WebEvent(null, 200, localHashMap));
  }
  
  private long b(j paramj)
  {
    boolean bool2 = true;
    Object localObject1 = Uri.parse(paramj.a());
    try
    {
      localObject2 = new com/lantern/core/d/a$c;
      ((a.c)localObject2).<init>((Uri)localObject1);
      ((a.c)localObject2).b("/WifiMasterKey/apk", paramj.e());
      if (paramj.d()) {
        break label242;
      }
      bool1 = true;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        Object localObject2;
        long l1 = -1L;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        Toast.makeText(this.g, R.string.browser_download_fail, 0).show();
        continue;
        ((HashMap)localObject2).put("funId", "brosldsta");
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject((Map)localObject2)));
      }
    }
    ((a.c)localObject2).a(bool1);
    if (!paramj.d())
    {
      bool1 = bool2;
      ((a.c)localObject2).b(bool1);
      c.getAppContext();
      l1 = a().a((a.c)localObject2);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("url", paramj.a());
      ((HashMap)localObject2).put("pkg", paramj.c());
      localObject1 = new JSONObject((Map)localObject2).toString();
      ((HashMap)localObject2).clear();
      ((HashMap)localObject2).put("ext", localObject1);
      ((HashMap)localObject2).put("cts", String.valueOf(System.currentTimeMillis()));
      if (paramj.d()) {
        break label269;
      }
      if (l1 <= 0L) {
        break label252;
      }
      Toast.makeText(this.g, R.string.browser_download_start, 0).show();
      ((HashMap)localObject2).put("funId", "brostdsta");
      com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject((Map)localObject2)));
      return l1;
    }
  }
  
  public static n b()
  {
    try
    {
      if (d == null)
      {
        localn = new com/lantern/browser/n;
        localn.<init>();
        d = localn;
      }
      n localn = d;
      return localn;
    }
    finally {}
  }
  
  private void b(Activity paramActivity, j paramj)
  {
    Object localObject = c.getAppContext();
    HashMap localHashMap = new HashMap();
    ContentResolver localContentResolver = ((Context)localObject).getContentResolver();
    Cursor localCursor = localContentResolver.query(com.lantern.core.model.a.a, null, "status!='200'", null, null);
    long l1;
    int i1;
    int i2;
    int i3;
    for (;;)
    {
      if ((localCursor != null) && (localCursor.moveToNext()))
      {
        localObject = localCursor.getString(localCursor.getColumnIndex("uri"));
        l1 = localCursor.getLong(localCursor.getColumnIndex("_id"));
        if (((String)localObject).equals(paramj.a()))
        {
          paramj.a(l1);
          localObject = c(l1);
          if (localObject != null)
          {
            paramj.a(((j)localObject).h());
            paramj.a(((j)localObject).i());
          }
          i1 = localCursor.getInt(localCursor.getColumnIndex("status"));
          i2 = localCursor.getInt(localCursor.getColumnIndex("is_visible_in_downloads_ui"));
          i3 = localCursor.getInt(localCursor.getColumnIndex("visibility"));
          if ((i1 != 190) && (i1 != 192)) {
            if ((i2 == 0) || (i3 == 2))
            {
              localObject = "slpau";
              localHashMap.clear();
              localHashMap.put("url", paramj.a());
              localHashMap.put("pkg", paramj.c());
              localHashMap.put("status", localObject);
              localObject = new JSONObject(localHashMap).toString();
              localHashMap.clear();
              localHashMap.put("funId", "brocalisding");
              localHashMap.put("ext", localObject);
              localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
              com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
              if (!e.b(this.g)) {
                break label526;
              }
              if (paramj.d()) {
                break label516;
              }
              if (paramActivity != null) {
                break label394;
              }
              Toast.makeText(this.g, R.string.browser_download_fail, 0).show();
            }
          }
        }
      }
    }
    for (;;)
    {
      return;
      localObject = "stpau";
      break;
      label394:
      localObject = c.getAppContext().getResources().getString(R.string.browser_download_mobile_network) + "\n\n";
      localObject = (String)localObject + paramj.e();
      paramActivity = new k.a(paramActivity);
      paramActivity.a(R.string.browser_download_tip_title);
      paramActivity.b((CharSequence)localObject);
      paramActivity.a(R.string.browser_download_confirm, new t(this, paramj, i2, i3)).b(R.string.browser_download_cancel, new s(this, paramj));
      paramActivity.d();
      label516:
      localCursor.close();
      continue;
      label526:
      c.getAppContext();
      a().c(new long[] { l1 });
      if ((!this.m.containsKey(Long.valueOf(paramj.b()))) || (!paramj.d())) {
        this.m.put(Long.valueOf(paramj.b()), paramj);
      }
      i1 = 1;
      if (!paramj.d())
      {
        if ((i2 != 0) && (i3 != 2)) {
          break label1077;
        }
        paramActivity = new ContentValues();
        paramActivity.put("is_visible_in_downloads_ui", Boolean.valueOf(true));
        paramActivity.put("visibility", Integer.valueOf(0));
        localContentResolver.update(com.lantern.core.model.a.a, paramActivity, "_id= ?", new String[] { String.valueOf(l1) });
        localHashMap.clear();
        localHashMap.put("url", paramj.a());
        localHashMap.put("pkg", paramj.c());
        paramActivity = new JSONObject(localHashMap).toString();
        localHashMap.clear();
        localHashMap.put("funId", "brostdsta");
        localHashMap.put("ext", paramActivity);
        localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
        localHashMap.clear();
        localHashMap.put("funId", "brosltfst");
        localHashMap.put("ext", paramActivity);
        localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
        Toast.makeText(this.g, R.string.browser_download_start, 0).show();
      }
      for (;;)
      {
        localCursor.close();
        break;
        if ((i2 == 0) || (i3 == 2)) {}
        for (paramActivity = "sling";; paramActivity = "sting")
        {
          localHashMap.clear();
          localHashMap.put("url", paramj.a());
          localHashMap.put("pkg", paramj.c());
          localHashMap.put("status", paramActivity);
          paramActivity = new JSONObject(localHashMap).toString();
          localHashMap.clear();
          localHashMap.put("funId", "brocalisding");
          localHashMap.put("ext", paramActivity);
          localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
          com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
          c.getAppContext();
          a().c(new long[] { l1 });
          if ((!this.m.containsKey(Long.valueOf(paramj.b()))) || (!paramj.d())) {
            this.m.put(Long.valueOf(paramj.b()), paramj);
          }
          i1 = 0;
          break;
        }
        label1077:
        if (i1 != 0) {
          Toast.makeText(this.g, R.string.browser_download_start, 0).show();
        } else {
          Toast.makeText(this.g, R.string.browser_downloading, 0).show();
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (e.b(this.g))
      {
        if (!paramj.d()) {
          if (paramActivity == null)
          {
            Toast.makeText(this.g, R.string.browser_download_fail, 0).show();
          }
          else
          {
            localObject = c.getAppContext().getResources().getString(R.string.browser_download_mobile_network) + "\n\n";
            localObject = (String)localObject + paramj.e();
            paramActivity = new k.a(paramActivity);
            paramActivity.a(R.string.browser_download_tip_title);
            paramActivity.b((CharSequence)localObject);
            paramActivity.a(R.string.browser_download_confirm, new v(this, paramj)).b(R.string.browser_download_cancel, new u(this, paramj));
            paramActivity.d();
          }
        }
      }
      else
      {
        paramj.a(b(paramj));
        this.m.put(Long.valueOf(paramj.b()), paramj);
      }
    }
  }
  
  public static void c() {}
  
  private void d()
  {
    Object localObject1 = l.a().b();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        try
        {
          localObject1 = this.g.getPackageManager().getPackageInfo(localk.d(), 0);
          if (localObject1 != null)
          {
            if (localk.f().equals("INSTALLED")) {
              continue;
            }
            l.a().b(localk.a(), "INSTALLED");
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
        if ((localk.f().equals("DOWNLOADED")) || (localk.f().equals("INSTALLED"))) {
          if ((!TextUtils.isEmpty(localk.c())) && (new File(a, localk.c()).exists()))
          {
            if (localk.f().equals("INSTALLED")) {
              l.a().b(localk.a(), "DOWNLOADED");
            }
          }
          else {
            l.a().b(localk.a(), "NOT_DOWNLOAD");
          }
        }
      }
    }
  }
  
  private void e()
  {
    int i1 = 0;
    Object localObject = c.getAppContext().getSharedPreferences("activateApp", 0).getString("activateApp", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>((String)localObject);
        while (i1 < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.optJSONObject(i1);
          localObject = new com/lantern/browser/j;
          ((j)localObject).<init>();
          ((j)localObject).a(localJSONObject);
          this.m.put(Long.valueOf(((j)localObject).b()), localObject);
          i1++;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    if (this.m.size() > 0)
    {
      SharedPreferences localSharedPreferences = c.getAppContext().getSharedPreferences("activateApp", 0);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.m.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        localObject = ((j)this.m.get(localObject)).j();
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
      localSharedPreferences.edit().putString("activateApp", localJSONArray.toString()).apply();
    }
  }
  
  public final long a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, false);
  }
  
  public final com.lantern.core.d.a a()
  {
    if (this.c == null) {
      this.c = new com.lantern.core.d.a(this.g);
    }
    return this.c;
  }
  
  public final void a(Activity paramActivity, j paramj)
  {
    if (!this.l) {
      a(c.getAppContext());
    }
    Object localObject2 = c.getAppContext();
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramj.a());
    localHashMap.put("pkg", paramj.c());
    localHashMap.put("netModel", com.lantern.core.k.n((Context)localObject2));
    int i1;
    Object localObject1;
    if (paramj.d())
    {
      i1 = 1;
      localHashMap.put("quiet", String.valueOf(i1));
      localObject1 = new JSONObject(localHashMap).toString();
      localHashMap.clear();
      localHashMap.put("funId", "brocalsld");
      localHashMap.put("ext", localObject1);
      localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
      com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
      localObject1 = ((Context)localObject2).getContentResolver().query(com.lantern.core.model.a.a, null, "status='200'", null, null);
      localObject2 = new ArrayList();
      label203:
      do
      {
        if ((localObject1 == null) || (!((Cursor)localObject1).moveToNext())) {
          break;
        }
      } while (!((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("uri")).equals(paramj.a()));
    }
    for (;;)
    {
      try
      {
        Object localObject4 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_data"));
        Object localObject3 = new java/io/File;
        ((File)localObject3).<init>((String)localObject4);
        localObject3 = Uri.parse(Uri.fromFile((File)localObject3).toString());
        localObject4 = new java/io/File;
        ((File)localObject4).<init>(((Uri)localObject3).getPath());
        if (((File)localObject4).exists())
        {
          localObject4 = g.a((File)localObject4);
          if ((!TextUtils.isEmpty(paramj.f())) && (!((String)localObject4).equals(paramj.f()))) {
            break label203;
          }
          if (!paramj.d())
          {
            localObject4 = new android/content/Intent;
            ((Intent)localObject4).<init>("android.intent.action.VIEW");
            ((Intent)localObject4).setDataAndType((Uri)localObject3, "application/vnd.android.package-archive");
            ((Intent)localObject4).setFlags(268435457);
            this.g.startActivity((Intent)localObject4);
            localHashMap.clear();
            localHashMap.put("url", paramj.a());
            localHashMap.put("pkg", paramj.c());
            localHashMap.put("install", "manual");
            localObject3 = new org/json/JSONObject;
            ((JSONObject)localObject3).<init>(localHashMap);
            localObject3 = ((JSONObject)localObject3).toString();
            localHashMap.clear();
            localHashMap.put("funId", "brocalint");
            localHashMap.put("ext", localObject3);
            localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
            localObject3 = com.lantern.analytics.a.e();
            JSONArray localJSONArray = new org/json/JSONArray;
            localJSONArray.<init>();
            localObject4 = new org/json/JSONObject;
            ((JSONObject)localObject4).<init>(localHashMap);
            ((com.lantern.analytics.a)localObject3).a("005012", localJSONArray.put(localObject4));
          }
          i1 = 1;
          if (((ArrayList)localObject2).size() <= 0) {
            break label656;
          }
          localObject3 = ((ArrayList)localObject2).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label656;
          }
          localObject2 = (Long)((Iterator)localObject3).next();
          c.getAppContext();
          a().a(new long[] { ((Long)localObject2).longValue() });
          this.m.remove(localObject2);
          continue;
          i1 = 0;
          break;
        }
        ((ArrayList)localObject2).add(Long.valueOf(((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("_id"))));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break label203;
      label656:
      if (i1 != 0)
      {
        localHashMap.clear();
        localHashMap.put("url", paramj.a());
        localHashMap.put("pkg", paramj.c());
        localHashMap.put("apk", "y");
        paramActivity = new JSONObject(localHashMap).toString();
        localHashMap.clear();
        localHashMap.put("funId", "brocalisded");
        localHashMap.put("ext", paramActivity);
        localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      for (;;)
      {
        return;
        localHashMap.clear();
        localHashMap.put("url", paramj.a());
        localHashMap.put("pkg", paramj.c());
        localHashMap.put("apk", "n");
        localObject2 = new JSONObject(localHashMap).toString();
        localHashMap.clear();
        localHashMap.put("funId", "brocalisded");
        localHashMap.put("ext", localObject2);
        localHashMap.put("cts", String.valueOf(System.currentTimeMillis()));
        com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(localHashMap)));
        if ((!e.b(c.getAppContext())) || (!paramj.d()))
        {
          b(paramActivity, paramj);
          f();
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      i1 = 0;
    }
  }
  
  public final void a(Context paramContext)
  {
    if (this.l) {}
    for (;;)
    {
      return;
      this.l = true;
      this.g = paramContext;
      this.h = new File(a);
      if (!this.h.exists()) {
        this.h.mkdirs();
      }
      paramContext = new File(b);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.DOWNLOAD_COMPLETE");
      paramContext.addAction("android.intent.action.DOWNLOAD_STATUS_CHANGED");
      this.i = new w();
      this.g.registerReceiver(this.i, paramContext);
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.PACKAGE_ADDED");
      paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
      paramContext.addDataScheme("package");
      this.j = new o(this);
      this.g.registerReceiver(this.j, paramContext);
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.DOWNLOAD_REMOVE");
      this.k = new q(this);
      this.g.registerReceiver(this.k, paramContext);
      d();
      e();
      this.n = new com.lantern.browser.a.a();
    }
  }
  
  public final void a(String paramString)
  {
    a(paramString, false);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      String str = Environment.getExternalStorageState();
      if (!str.equals("mounted"))
      {
        if (str.equals("shared")) {
          Toast.makeText(this.g, R.string.browser_download_sdcard_busy, 0).show();
        } else {
          Toast.makeText(this.g, R.string.browser_download_no_sdcard, 0).show();
        }
      }
      else
      {
        if (!paramBoolean) {
          Toast.makeText(this.g, R.string.browser_download_start, 0).show();
        }
        a(paramString, "", "", paramBoolean);
      }
    }
  }
  
  public final boolean a(long paramLong)
  {
    return this.e.contains(Long.valueOf(paramLong));
  }
  
  public final void b(k paramk)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    String str = Environment.getExternalStorageState();
    if (!str.equals("mounted"))
    {
      if (str.equals("shared")) {
        Toast.makeText(this.g, R.string.browser_download_sdcard_busy, 0).show();
      }
      for (;;)
      {
        return;
        Toast.makeText(this.g, R.string.browser_download_no_sdcard, 0).show();
      }
    }
    long l1 = a(paramk, "", "");
    if (l1 > 0L)
    {
      paramk.f("DOWNLOADING");
      paramk.b(String.valueOf(l1));
    }
    for (;;)
    {
      l.a().a(paramk);
      a(paramk);
      com.lantern.analytics.a.e().onEvent("bdlsta", paramk.a());
      break;
      paramk.f("DOWNLOAD_FAIL");
    }
  }
  
  public final void b(String paramString)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    paramString = new File(this.h + File.separator + paramString);
    Object localObject;
    int i1;
    if (paramString.exists())
    {
      localObject = paramString.getName();
      i1 = ((String)localObject).lastIndexOf(".");
      if ((i1 < 0) || (!".apk".equals(((String)localObject).substring(i1, ((String)localObject).length()).toLowerCase()))) {
        break label104;
      }
      i1 = 1;
      if (i1 != 0) {
        break label109;
      }
    }
    for (;;)
    {
      return;
      label104:
      i1 = 0;
      break;
      label109:
      localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setDataAndType(Uri.fromFile(paramString), "application/vnd.android.package-archive");
      this.g.startActivity((Intent)localObject);
    }
  }
  
  public final boolean b(long paramLong)
  {
    return this.f.contains(Long.valueOf(paramLong));
  }
  
  public final j c(long paramLong)
  {
    Object localObject;
    if (paramLong <= 0L) {
      localObject = null;
    }
    for (;;)
    {
      return (j)localObject;
      localObject = this.m.keySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          if (paramLong == localLong.longValue())
          {
            localObject = (j)this.m.get(localLong);
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final void c(k paramk)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    try
    {
      a().b(new long[] { Long.valueOf(paramk.b()).longValue() });
      paramk.f("PAUSED");
      l.a().b(paramk.a(), "PAUSED");
      a(paramk);
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
  
  public final void c(String paramString)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      PackageInfo localPackageInfo = this.g.getPackageManager().getPackageInfo(paramString, 0);
      if (localPackageInfo == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        paramString = this.g.getPackageManager().getLaunchIntentForPackage(paramString);
        this.g.startActivity(paramString);
        for (;;)
        {
          return;
          localNameNotFoundException = localNameNotFoundException;
          Object localObject = null;
          break;
          Toast.makeText(this.g, R.string.browser_download_app_no_install, 0).show();
          paramString = l.a().b(paramString);
          if (paramString != null)
          {
            paramString.f("NOT_DOWNLOAD");
            l.a().b(paramString.a(), "NOT_DOWNLOAD");
            a(paramString);
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
  
  public final j d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Iterator localIterator = this.m.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          if (paramString.equals(localj.g()))
          {
            paramString = localj;
            break;
          }
        }
      }
      paramString = null;
    }
  }
  
  public final void d(k paramk)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    try
    {
      a().c(new long[] { Long.valueOf(paramk.b()).longValue() });
      paramk.f("DOWNLOADING");
      l.a().b(paramk.a(), "DOWNLOADING");
      a(paramk);
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
  
  public final List<j> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      Iterator localIterator = this.m.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        localObject = (j)this.m.get(localObject);
        if (paramString.equals(((j)localObject).c())) {
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  public final void e(k paramk)
  {
    if (!this.l) {
      a(c.getInstance().getApplicationContext());
    }
    File localFile = new File(this.h, paramk.c());
    if (!localFile.exists())
    {
      Toast.makeText(this.g, R.string.browser_download_file_no_exist, 0).show();
      paramk.f("NOT_DOWNLOAD");
      l.a().b(paramk.a(), "NOT_DOWNLOAD");
      a(paramk);
    }
    for (;;)
    {
      return;
      paramk = new Intent();
      paramk.addFlags(268435456);
      paramk.setAction("android.intent.action.VIEW");
      paramk.setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
      this.g.startActivity(paramk);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */