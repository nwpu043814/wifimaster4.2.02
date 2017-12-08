package com.lantern.launcher.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bluefay.a.b;
import com.bluefay.a.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.popup.PopupActivity;
import com.lantern.popup.PopupItem;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    if (!f.a().a("showmsg", true)) {}
    for (;;)
    {
      return;
      Object localObject = paramIntent.getAction();
      h.a((String)localObject);
      if ("com.lantern.wifilocating.push.action.TRANSFER".equals(localObject))
      {
        paramIntent = paramIntent.getStringExtra("push_msg");
        h.a("transfer message : " + paramIntent, new Object[0]);
        String str;
        for (;;)
        {
          try
          {
            localObject = new org/json/JSONObject;
            ((JSONObject)localObject).<init>(paramIntent);
            if (!((JSONObject)localObject).has("funid")) {
              break;
            }
            str = ((JSONObject)localObject).getString("funid");
            if (!"showmsg".equals(str)) {
              break label331;
            }
            paramIntent = PopupItem.a((JSONObject)localObject);
            i = j;
            if (paramIntent.b > 0)
            {
              if (paramIntent.b <= 3) {
                break label191;
              }
              i = j;
            }
            if (i == 0) {
              break;
            }
            localObject = new android/content/Intent;
            ((Intent)localObject).<init>();
            ((Intent)localObject).setClass(paramContext, PopupActivity.class);
            ((Intent)localObject).setFlags(268435456);
            ((Intent)localObject).putExtra("popup", paramIntent);
            com.bluefay.a.e.a(paramContext, (Intent)localObject);
          }
          catch (JSONException paramContext)
          {
            h.a(paramContext);
          }
          break;
          label191:
          int i = j;
          if (paramIntent.g != null)
          {
            i = j;
            if (paramIntent.g.length() != 0) {
              if (paramIntent.b == 3)
              {
                localObject = paramIntent.g.split(":");
                i = j;
                if (localObject != null)
                {
                  i = j;
                  if (localObject.length == 2)
                  {
                    i = j;
                    if (!b.a(paramContext, localObject[1])) {}
                  }
                }
              }
              else
              {
                do
                {
                  do
                  {
                    i = 1;
                    break;
                  } while (paramIntent.b != 2);
                  localObject = paramIntent.g.split(":");
                  i = j;
                  if (localObject == null) {
                    break;
                  }
                  i = j;
                  if (localObject.length != 2) {
                    break;
                  }
                } while (b.a(paramContext, localObject[1].split("/")[0]));
                i = j;
              }
            }
          }
        }
        label331:
        if ("mailbox".equals(str))
        {
          paramContext = ((JSONObject)localObject).optJSONArray("messages");
          if (paramContext.length() > 0)
          {
            paramContext = com.lantern.mailbox.e.a.a(com.lantern.mailbox.c.a.a().b(), paramContext);
            paramIntent = paramContext.iterator();
            while (paramIntent.hasNext()) {
              if ("1".equals(((com.lantern.mailbox.d.a)paramIntent.next()).a())) {
                paramIntent.remove();
              }
            }
            com.lantern.mailbox.b.a.a().a(paramContext);
          }
        }
        else
        {
          boolean bool;
          if ("ad".equals(str))
          {
            bool = ((JSONObject)localObject).optBoolean("getSplCon", false);
            paramContext = new java/lang/StringBuilder;
            paramContext.<init>("splash  transfer getsplcon ");
            h.a(bool, new Object[0]);
            if (bool)
            {
              h.a("splash  transfer update ", new Object[0]);
              com.lantern.a.a.e.a().e();
            }
          }
          else if ("loc".equals(str))
          {
            paramContext = ((JSONObject)localObject).optString("longi");
            str = ((JSONObject)localObject).optString("lati");
            localObject = ((JSONObject)localObject).optString("mapSP");
            c.getServer().a(paramContext, str);
            c.getServer().e((String)localObject);
            d.b(com.bluefay.d.a.getAppContext().getPackageName(), "wk_sdk_loc", paramIntent);
          }
          else if ("ws_me".equals(str))
          {
            com.lantern.core.g.o.a().a(((JSONObject)localObject).toString());
          }
          else if ("feed".equals(str))
          {
            paramContext = ((JSONObject)localObject).optString("msg");
            if (!TextUtils.isEmpty(paramContext))
            {
              paramIntent = Message.obtain();
              paramIntent.what = 128401;
              paramIntent.obj = paramContext;
              c.dispatch(paramIntent);
            }
          }
          else
          {
            bool = "ws_msg".equals(str);
            if (bool)
            {
              try
              {
                localObject = new android/content/Intent;
                ((Intent)localObject).<init>("com.linksure.aps.action.PUSH_MSG");
                ((Intent)localObject).putExtra("push_msg", paramIntent);
                ((Intent)localObject).setPackage(paramContext.getPackageName());
                paramContext.startService((Intent)localObject);
              }
              catch (Exception paramContext)
              {
                h.a(paramContext);
              }
            }
            else
            {
              bool = "cwvc".equals(str);
              if (bool)
              {
                try
                {
                  paramIntent = new android/webkit/WebView;
                  paramIntent.<init>(paramContext);
                  paramIntent.clearCache(true);
                  paramIntent.destroy();
                }
                catch (Exception paramContext)
                {
                  h.a(paramContext);
                }
              }
              else if ("bindCfg".equals(str))
              {
                paramIntent = ((JSONObject)localObject).optString("msg");
                if (!TextUtils.isEmpty(paramIntent))
                {
                  paramContext = Message.obtain();
                  paramContext.what = 128501;
                  paramContext.obj = paramIntent;
                  c.dispatch(paramContext);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/receiver/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */