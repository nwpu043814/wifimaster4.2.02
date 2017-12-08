package com.lantern.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bluefay.b.h;
import com.lantern.core.d.a.b;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    Object localObject1;
    int i;
    long l;
    do
    {
      for (;;)
      {
        return;
        localObject1 = paramIntent.getAction();
        h.a("WkBrowserDownloadReceiver action:" + (String)localObject1, new Object[0]);
        if (!"android.intent.action.DOWNLOAD_STATUS_CHANGED".equals(localObject1)) {
          break;
        }
        i = paramIntent.getIntExtra("status", -1);
        l = paramIntent.getLongExtra("extra_download_id", 0L);
        if (i != 200) {
          if ((i == 190) || (i == 192))
          {
            paramContext = l.a().a(String.valueOf(l));
            if ((paramContext != null) && (!"DOWNLOADING".equals(paramContext.f())))
            {
              h.a("ACTION_DOWNLOAD_RESUME getFileName:" + paramContext.c(), new Object[0]);
              paramContext.f("DOWNLOADING");
              l.a().a(String.valueOf(l), "DOWNLOADING");
              n.a(paramContext);
              com.lantern.analytics.a.e().onEvent("bctcli", paramContext.a());
              paramContext = new HashMap();
              paramContext.put("status", "res");
              paramIntent = new JSONObject(paramContext).toString();
              paramContext.clear();
              paramContext.put("funId", "brostodp");
              paramContext.put("ext", paramIntent);
              paramContext.put("cts", String.valueOf(System.currentTimeMillis()));
              com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramContext)));
            }
            paramContext = n.b().c(l);
            if (paramContext != null)
            {
              paramContext.a("DOWNLOADING");
              n.a(paramContext);
              paramIntent = new HashMap();
              paramIntent.put("status", "res");
              paramContext = new JSONObject(paramIntent).toString();
              paramIntent.clear();
              paramIntent.put("funId", "brostattf");
              paramIntent.put("ext", paramContext);
              paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
              com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramIntent)));
            }
          }
          else
          {
            paramContext = l.a().a(String.valueOf(l));
            if ((paramContext != null) && (!"PAUSED".equals(paramContext.f())))
            {
              h.a("ACTION_DOWNLOAD_PAUSE getFileName:" + paramContext.c(), new Object[0]);
              paramContext.f("PAUSED");
              l.a().a(String.valueOf(l), "PAUSED");
              n.a(paramContext);
              com.lantern.analytics.a.e().onEvent("bpaucli", paramContext.a());
              paramIntent = new HashMap();
              paramIntent.put("status", "pau");
              paramContext = new JSONObject(paramIntent).toString();
              paramIntent.clear();
              paramIntent.put("funId", "brostodp");
              paramIntent.put("ext", paramContext);
              paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
              com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramIntent)));
            }
            paramContext = n.b().c(l);
            if (paramContext != null)
            {
              paramContext.a("PAUSED");
              n.a(paramContext);
              paramContext = new HashMap();
              paramContext.put("status", "pau");
              paramIntent = new JSONObject(paramContext).toString();
              paramContext.clear();
              paramContext.put("funId", "brostattf");
              paramContext.put("ext", paramIntent);
              paramContext.put("cts", String.valueOf(System.currentTimeMillis()));
              com.lantern.analytics.a.e().a("005012", new JSONArray().put(new JSONObject(paramContext)));
            }
          }
        }
      }
    } while (!"android.intent.action.DOWNLOAD_COMPLETE".equals(localObject1));
    for (;;)
    {
      try
      {
        l = paramIntent.getLongExtra("extra_download_id", 0L);
        paramIntent = new java/lang/StringBuilder;
        paramIntent.<init>("WkBrowserDownloadReceiver ACTION_DOWNLOAD_COMPLETE id:");
        h.a(l, new Object[0]);
        localj = n.b().c(l);
        bool1 = n.b().a(l);
        bool2 = n.b().b(l);
        if ((bool1) || (bool2) || (localj != null)) {
          break label2354;
        }
        localk = l.a().a(String.valueOf(l));
        if ((localk == null) && (localj == null) && (!bool1) && (!bool2)) {
          break;
        }
        paramIntent = new com/lantern/core/d/a;
        paramIntent.<init>(paramContext);
        localObject1 = new com/lantern/core/d/a$b;
        ((a.b)localObject1).<init>();
        ((a.b)localObject1).a(new long[] { l });
        localCursor = paramIntent.a((a.b)localObject1);
        localObject1 = "";
        if (localCursor == null) {
          break;
        }
        try
        {
          if (!localCursor.moveToFirst()) {
            break;
          }
          i = localCursor.getInt(localCursor.getColumnIndex("status"));
          if (!com.lantern.core.model.a.a(i)) {
            continue;
          }
          if (!bool1) {
            continue;
          }
          com.lantern.analytics.a.e().onEvent("udl0002");
        }
        catch (Exception paramContext)
        {
          paramIntent = localCursor;
          h.a(paramContext);
        }
        if (paramIntent == null) {
          break;
        }
        paramIntent.close();
        break;
        if (bool2)
        {
          com.lantern.analytics.a.e().onEvent("udl0002");
          Toast.makeText(paramContext, R.string.browser_download_fail, 0).show();
          break;
        }
        if (localk == null) {
          break;
        }
        i = localCursor.getColumnIndex("reason");
        paramContext = new java/util/HashMap;
        paramContext.<init>();
        paramContext.put("appid", localk.a());
        if (i != -1) {
          paramContext.put("reason", String.valueOf(localCursor.getInt(i)));
        }
        paramIntent = com.lantern.analytics.a.e();
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramContext);
        paramIntent.onEvent("bdlfai", ((JSONObject)localObject1).toString());
        break;
        switch (i)
        {
        default: 
          paramIntent = (Intent)localObject1;
          i = localCursor.getColumnIndex("_data");
          localObject2 = "";
          localObject4 = "";
          localObject3 = localObject4;
          localObject1 = localObject2;
          if (i != -1)
          {
            localObject3 = localObject4;
            localObject1 = localObject2;
          }
          break;
        }
      }
      catch (Exception paramContext)
      {
        j localj;
        boolean bool1;
        boolean bool2;
        Cursor localCursor;
        try
        {
          localObject4 = localCursor.getString(i);
          localObject3 = localObject4;
          localObject1 = localObject2;
          Object localObject5 = Uri.parse((String)localObject4).getPath();
          localObject2 = localObject5;
          localObject3 = localObject4;
          localObject1 = localObject5;
          if (((String)localObject5).indexOf("/") != -1)
          {
            localObject3 = localObject4;
            localObject1 = localObject5;
            i = ((String)localObject5).lastIndexOf('/') + 1;
            localObject2 = localObject5;
            if (i > 0)
            {
              localObject3 = localObject4;
              localObject1 = localObject5;
              localObject2 = ((String)localObject5).substring(i);
            }
          }
          localObject3 = localObject4;
          localObject1 = localObject2;
          localObject5 = new java/lang/StringBuilder;
          localObject3 = localObject4;
          localObject1 = localObject2;
          ((StringBuilder)localObject5).<init>("WkBrowserDownloadReceiver ACTION_DOWNLOAD_COMPLETE fileName:");
          localObject3 = localObject4;
          localObject1 = localObject2;
          h.a((String)localObject2, new Object[0]);
          localObject1 = localObject2;
          localObject3 = localObject4;
          if ((localk != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localk.c((String)localObject1);
            }
            localk.f(paramIntent);
            l.a().a(String.valueOf(l), localk.c(), paramIntent);
            n.a(localk);
          }
          if ((localj != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            localj.a(paramIntent);
            n.a(localj);
          }
          localCursor.close();
          if (!"DOWNLOADED".equals(paramIntent)) {
            break;
          }
          h.a("WkBrowserDownloadReceiver ACTION_DOWNLOAD_COMPLETE installDownloadAPk", new Object[0]);
          if (localk == null) {
            continue;
          }
          com.lantern.analytics.a.e().onEvent("binssta", localk.a());
          n.b().b((String)localObject1);
        }
        catch (Exception localException) {}
        paramIntent = null;
        paramContext = paramContext;
        continue;
        paramIntent = "PAUSED";
        continue;
        paramIntent = "";
        continue;
        paramIntent = "DOWNLOADED";
        if ((bool1) || (bool2))
        {
          com.lantern.analytics.a.e().onEvent("udl0001");
          if (localj == null) {
            continue;
          }
          paramIntent = new java/util/HashMap;
          paramIntent.<init>();
          paramIntent.put("url", localj.a());
          paramIntent.put("pkg", localj.c());
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(paramIntent);
          localObject1 = ((JSONObject)localObject1).toString();
          paramIntent.clear();
          paramIntent.put("ext", localObject1);
          paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
          if (localj.d())
          {
            paramIntent.put("funId", "brosldend");
            localObject2 = com.lantern.analytics.a.e();
            localObject3 = new org/json/JSONArray;
            ((JSONArray)localObject3).<init>();
            localObject1 = new org/json/JSONObject;
            ((JSONObject)localObject1).<init>(paramIntent);
            ((com.lantern.analytics.a)localObject2).a("005012", ((JSONArray)localObject3).put(localObject1));
            localj.a(100);
            paramIntent = "DOWNLOADED";
          }
        }
        else
        {
          if (localk == null) {
            continue;
          }
          com.lantern.analytics.a.e().onEvent("bdlfin", localk.a());
          localObject3 = localk.h();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          localObject2 = new java/lang/Thread;
          localObject1 = new com/lantern/browser/x;
          ((x)localObject1).<init>(this, (String)localObject3);
          ((Thread)localObject2).<init>((Runnable)localObject1);
          ((Thread)localObject2).start();
          continue;
        }
        paramIntent.put("funId", "brostdend");
        Object localObject3 = com.lantern.analytics.a.e();
        localObject1 = new org/json/JSONArray;
        ((JSONArray)localObject1).<init>();
        Object localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramIntent);
        ((com.lantern.analytics.a)localObject3).a("005012", ((JSONArray)localObject1).put(localObject2));
        continue;
        if (bool1)
        {
          com.lantern.analytics.a.e().onEvent("udl0002");
          paramIntent = "";
          continue;
        }
        if (bool2)
        {
          com.lantern.analytics.a.e().onEvent("udl0002");
          Toast.makeText(paramContext, R.string.browser_download_fail, 0).show();
          paramIntent = "";
          continue;
        }
        if (localk != null)
        {
          i = localCursor.getColumnIndex("reason");
          paramIntent = new java/util/HashMap;
          paramIntent.<init>();
          if (i != -1) {
            paramIntent.put("reason", String.valueOf(localCursor.getInt(i)));
          }
          paramIntent.put("appid", localk.a());
          localObject2 = com.lantern.analytics.a.e();
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(paramIntent);
          ((com.lantern.analytics.a)localObject2).onEvent("bdlfai", ((JSONObject)localObject1).toString());
          Toast.makeText(paramContext, R.string.browser_download_fail_app, 0).show();
          paramIntent.clear();
          paramIntent.put("status", "fail");
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(paramIntent);
          localObject1 = ((JSONObject)localObject1).toString();
          paramIntent.clear();
          paramIntent.put("funId", "brostodp");
          paramIntent.put("ext", localObject1);
          paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
          localObject3 = com.lantern.analytics.a.e();
          localObject1 = new org/json/JSONArray;
          ((JSONArray)localObject1).<init>();
          localObject2 = new org/json/JSONObject;
          ((JSONObject)localObject2).<init>(paramIntent);
          ((com.lantern.analytics.a)localObject3).a("005012", ((JSONArray)localObject1).put(localObject2));
          paramIntent = "";
          continue;
        }
        paramIntent = (Intent)localObject1;
        if (localj == null) {
          continue;
        }
        paramIntent = new java/util/HashMap;
        paramIntent.<init>();
        paramIntent.put("status", "fail");
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramIntent);
        localObject2 = ((JSONObject)localObject2).toString();
        paramIntent.clear();
        paramIntent.put("funId", "brostattf");
        paramIntent.put("ext", localObject2);
        paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
        localObject3 = com.lantern.analytics.a.e();
        localObject2 = new org/json/JSONArray;
        ((JSONArray)localObject2).<init>();
        Object localObject4 = new org/json/JSONObject;
        ((JSONObject)localObject4).<init>(paramIntent);
        ((com.lantern.analytics.a)localObject3).a("005012", ((JSONArray)localObject2).put(localObject4));
        paramIntent = (Intent)localObject1;
        continue;
        continue;
        if (bool2)
        {
          bool1 = TextUtils.isEmpty((CharSequence)localObject3);
          if (!bool1) {
            try
            {
              paramIntent = new com/lantern/browser/aa;
              paramIntent.<init>(paramContext, Uri.parse((String)localObject3).getPath());
              paramIntent.a();
              Toast.makeText(paramContext, R.string.browser_download_success, 0).show();
            }
            catch (Exception paramIntent)
            {
              h.a(paramIntent);
              continue;
            }
          }
        }
        if (localj != null)
        {
          if (localj.d()) {
            break;
          }
          paramContext = new java/util/HashMap;
          paramContext.<init>();
          paramContext.put("url", localj.a());
          paramContext.put("pkg", localj.c());
          paramContext.put("install", "auto");
          paramIntent = new org/json/JSONObject;
          paramIntent.<init>(paramContext);
          paramIntent = paramIntent.toString();
          paramContext.clear();
          paramContext.put("funId", "brocalint");
          paramContext.put("ext", paramIntent);
          paramContext.put("cts", String.valueOf(System.currentTimeMillis()));
          localObject3 = com.lantern.analytics.a.e();
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          paramIntent = new org/json/JSONObject;
          paramIntent.<init>(paramContext);
          ((com.lantern.analytics.a)localObject3).a("005012", localJSONArray.put(paramIntent));
          n.b().b((String)localObject1);
          break;
        }
        n.b().b((String)localObject1);
      }
      break;
      label2354:
      k localk = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */