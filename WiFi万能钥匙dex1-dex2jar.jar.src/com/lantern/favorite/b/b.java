package com.lantern.favorite.b;

import android.content.Context;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends Thread
{
  private Context a;
  private com.lantern.favorite.a b;
  private com.bluefay.b.a c;
  
  public b(Context paramContext, com.lantern.favorite.a parama, com.bluefay.b.a parama1)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = parama1;
  }
  
  public final void run()
  {
    if (!com.bluefay.a.a.c(this.a)) {
      this.c.a(0, null, null);
    }
    for (;;)
    {
      return;
      com.lantern.core.c.getServer().f("10000102");
      Object localObject1 = this.b.a();
      Object localObject2 = new JSONArray();
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((JSONArray)localObject2).put(((WkSceneFavorite)((Iterator)localObject3).next()).getJSONObject());
      }
      h.a("push=" + ((ArrayList)localObject1).size(), new Object[0]);
      localObject3 = com.lantern.core.c.getServer().s();
      ((HashMap)localObject3).put("data", ((JSONArray)localObject2).toString());
      ((HashMap)localObject3).put("syncTag", com.lantern.favorite.c.c.a());
      localObject3 = d.a("http://fav-api.51y5.net/fav/fa.sec", com.lantern.core.c.getServer().b("10000102", (HashMap)localObject3));
      if ((localObject3 == null) || (((String)localObject3).length() == 0))
      {
        this.c.a(0, null, null);
        continue;
      }
      h.a("json" + (String)localObject3, new Object[0]);
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject3);
        if (((JSONObject)localObject2).has("syncTag"))
        {
          com.lantern.favorite.c.c.b(((JSONObject)localObject2).getString("syncTag"));
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WkSceneFavorite)((Iterator)localObject1).next();
            ((WkSceneFavorite)localObject2).syncState = 1;
            this.b.c((WkSceneFavorite)localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.c.a(1, null, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */