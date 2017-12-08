package com.lantern.dynamictab.b;

import android.text.TextUtils;
import com.lantern.core.model.f;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements Serializable
{
  public ArrayList<a> a = new ArrayList();
  public int b = 1;
  public String c;
  
  public static a a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = null;
    Object localObject1 = localJSONArray;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() != 0) {
        break label19;
      }
      localObject1 = localJSONArray;
    }
    for (;;)
    {
      return (a)localObject1;
      label19:
      Object localObject2 = paramJSONObject.optString("n");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        com.lantern.analytics.a.e().onEvent("friend_menu_notitle");
        localObject1 = localJSONArray;
      }
      else
      {
        localObject1 = new a();
        ((a)localObject1).c = ((String)localObject2);
        localJSONArray = paramJSONObject.optJSONArray("m");
        if (localJSONArray == null)
        {
          com.lantern.analytics.a.e().onEvent("friend_tab_hide");
        }
        else
        {
          ((a)localObject1).b = paramJSONObject.optInt("o", 1);
          if (localJSONArray.length() > 0)
          {
            int i = 0;
            if (i < localJSONArray.length())
            {
              JSONObject localJSONObject = localJSONArray.optJSONObject(i);
              if ((localJSONObject == null) || (!localJSONObject.has("type")) || (TextUtils.isEmpty(localJSONObject.optString("pkg"))) || (TextUtils.isEmpty(localJSONObject.optString("sec")))) {
                com.lantern.analytics.a.e().onEvent("friend_menu_noappid");
              }
              for (;;)
              {
                i++;
                break;
                localObject2 = new a();
                ((a)localObject1).a.add(localObject2);
                ((a)localObject2).a = localJSONObject.optString("pkg");
                paramJSONObject = com.lantern.core.g.n.a();
                ((a)localObject2).b = com.lantern.core.n.c(localJSONObject.optString("sec"), paramJSONObject.b, paramJSONObject.c).trim();
                ((a)localObject2).c = localJSONObject.optString("i");
                ((a)localObject2).d = localJSONObject.optString("t");
                ((a)localObject2).e = localJSONObject.optString("s");
                ((a)localObject2).f = localJSONObject.optString("p");
                ((a)localObject2).g = localJSONObject.optString("rh");
                ((a)localObject2).h = localJSONObject.optString("rn");
                ((a)localObject2).i = localJSONObject.optInt("h");
                com.lantern.analytics.a.e().onEvent("dy_config_" + ((a)localObject2).a);
              }
            }
          }
        }
      }
    }
  }
  
  public static final class a
    implements Serializable
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */