package com.lantern.dynamictab.d;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.e;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Void, Integer>
{
  private JSONObject a;
  private JSONObject b = new JSONObject();
  
  public a()
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("v", "1");
      this.b.put("friendtab", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private Integer a()
  {
    com.lantern.analytics.a.e().onEvent("dy_get_config");
    try
    {
      localObject3 = ((ConnectivityManager)c.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject3 != null) || (((NetworkInfo)localObject3).isAvailable())) {
        break label80;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("net available:");
      h.a("Friends %s", new Object[] { localObject3 });
      com.lantern.analytics.a.e().onEvent("dy_get_config_no_net");
      localObject1 = Integer.valueOf(0);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        c.getServer().f("00100103");
        Object localObject3 = c.getServer();
        Object localObject2 = com.lantern.core.c.a.a();
        localObject3 = ((o)localObject3).s();
        ((HashMap)localObject3).put("pid", "00100103");
        ((HashMap)localObject3).put("cate", "config");
        ((HashMap)localObject3).put("fp", this.b.toString());
        Object localObject4 = e.a((String)localObject2, c.getServer().a("00100103", (HashMap)localObject3));
        if ((localObject4 == null) || (((String)localObject4).length() == 0))
        {
          com.lantern.analytics.a.e().onEvent("dy_get_config_err_noresult");
          localObject2 = Integer.valueOf(0);
        }
        else
        {
          h.a("JSON:" + (String)localObject4, new Object[0]);
          localObject2 = "server";
          try
          {
            localObject3 = new org/json/JSONObject;
            ((JSONObject)localObject3).<init>((String)localObject4);
            if (!"0".equals(((JSONObject)localObject3).getString("retCd")))
            {
              if (((JSONObject)localObject3).has("retMsg")) {
                localObject2 = ((JSONObject)localObject3).getString("retMsg");
              }
              localObject3 = com.lantern.analytics.a.e();
              localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>("dy_get_config_err_");
              ((com.lantern.analytics.a)localObject3).onEvent((String)localObject2);
              localObject2 = Integer.valueOf(0);
            }
            else
            {
              com.lantern.analytics.a.e().onEvent("dy_got_config");
              localObject2 = ((JSONObject)localObject3).optJSONObject("config");
              if ((localObject2 == null) || (((JSONObject)localObject2).length() == 0))
              {
                com.lantern.analytics.a.e().onEvent("dy_get_config_err_json");
                localObject2 = Integer.valueOf(0);
              }
              else
              {
                this.a = ((JSONObject)localObject2).optJSONObject("friendtab");
                if ((this.a == null) || (this.a.length() == 0))
                {
                  com.lantern.analytics.a.e().onEvent("dy_get_config_err_json");
                  localObject2 = Integer.valueOf(0);
                }
                else if (this.a.optInt("cv") == -1)
                {
                  com.lantern.analytics.a.e().onEvent("dy_config_rm");
                  localObject2 = Integer.valueOf(2);
                }
                else
                {
                  localObject2 = this.a.optJSONObject("tab");
                  if ((localObject2 == null) || (((JSONObject)localObject2).length() == 0))
                  {
                    com.lantern.analytics.a.e().onEvent("dy_get_config_err_json");
                    localObject2 = Integer.valueOf(0);
                  }
                  else
                  {
                    localObject2 = Integer.valueOf(1);
                  }
                }
              }
            }
          }
          catch (Exception localException2)
          {
            h.a(localException2);
            com.lantern.analytics.a.e().onEvent("dy_get_config_err_json");
            Integer localInteger = Integer.valueOf(0);
          }
        }
      }
    }
    return (Integer)localObject1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */