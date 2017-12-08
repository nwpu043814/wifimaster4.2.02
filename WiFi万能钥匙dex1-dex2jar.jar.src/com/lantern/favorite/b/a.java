package com.lantern.favorite.b;

import android.os.AsyncTask;
import com.bluefay.b.d;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.core.o;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Integer, Integer>
{
  private int a = 1;
  private int b = 0;
  private com.lantern.favorite.a c;
  private int d = 0;
  private int e = 0;
  private com.bluefay.b.a f;
  private String g = "";
  private a h;
  private ArrayList<WkSceneFavorite> i;
  
  public a(com.lantern.favorite.a parama, int paramInt1, int paramInt2, com.bluefay.b.a parama1)
  {
    this.c = parama;
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = parama1;
  }
  
  private Integer a()
  {
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {}
    for (Object localObject1 = Integer.valueOf(10);; localObject1 = Integer.valueOf(10))
    {
      return (Integer)localObject1;
      com.lantern.core.c.getServer().f("10000101");
      localObject1 = com.lantern.core.c.getServer().s();
      ((HashMap)localObject1).put("syncTag", com.lantern.favorite.c.c.a());
      ((HashMap)localObject1).put("isNew", String.valueOf(this.a));
      ((HashMap)localObject1).put("offset", String.valueOf(this.b));
      ((HashMap)localObject1).put("count", "10");
      localObject1 = d.a("http://fav-api.51y5.net/fav/fa.sec", com.lantern.core.c.getServer().b("10000101", (HashMap)localObject1));
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        break;
      }
    }
    Object localObject2;
    int j;
    label227:
    JSONObject localJSONObject;
    WkSceneFavorite localWkSceneFavorite;
    Field localField;
    try
    {
      localObject2 = new org/json/JSONObject;
      ((JSONObject)localObject2).<init>((String)localObject1);
      if (((JSONObject)localObject2).has("syncTag")) {
        this.g = ((JSONObject)localObject2).getString("syncTag");
      }
      if ((((JSONObject)localObject2).has("total")) && (((JSONObject)localObject2).has("data")))
      {
        localObject1 = ((JSONObject)localObject2).getJSONArray("data");
        this.d = ((JSONObject)localObject2).getInt("total");
        this.e = ((JSONArray)localObject1).length();
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        this.i = ((ArrayList)localObject2);
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localJSONObject = (JSONObject)((JSONArray)localObject1).get(j);
          localWkSceneFavorite = (WkSceneFavorite)WkSceneFavorite.class.newInstance();
          Field[] arrayOfField = WkSceneFavorite.class.getDeclaredFields();
          int m = arrayOfField.length;
          int k = 0;
          if (k < m)
          {
            localField = arrayOfField[k];
            localField.setAccessible(true);
            localObject2 = localField.getType().getName();
            if (((String)localObject2).contains("String")) {
              if (localJSONObject.has(localField.getName())) {
                localField.set(localWkSceneFavorite, localJSONObject.getString(localField.getName()));
              }
            }
            for (;;)
            {
              label337:
              localWkSceneFavorite.syncState = 1;
              k++;
              break;
              if (!((String)localObject2).contains("int")) {
                break label409;
              }
              if (localJSONObject.has(localField.getName())) {
                localField.set(localWkSceneFavorite, Integer.valueOf(localJSONObject.getInt(localField.getName())));
              }
            }
            localInteger = Integer.valueOf(j);
          }
        }
      }
    }
    catch (Exception localException)
    {
      j = 30;
    }
    for (;;)
    {
      Integer localInteger;
      break;
      label409:
      if ((!((String)localObject2).contains("long")) || (!localJSONObject.has(localField.getName()))) {
        break label337;
      }
      localField.set(localWkSceneFavorite, Long.valueOf(localJSONObject.getLong(localField.getName())));
      break label337;
      this.i.add(localWkSceneFavorite);
      this.c.b(localWkSceneFavorite);
      j++;
      break label227;
      j = 1;
    }
  }
  
  public final void a(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(ArrayList<WkSceneFavorite> paramArrayList);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */