package com.lantern.a.a;

import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  private static c a(JSONObject paramJSONObject)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.optJSONArray("sub_ads");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
          continue;
        }
        paramJSONObject = null;
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        int k;
        int i;
        h.a(paramJSONObject);
        paramJSONObject = null;
        continue;
      }
      return paramJSONObject;
      localObject2 = ((JSONArray)localObject1).optJSONObject(0);
      if ((localObject2 == null) || (((JSONObject)localObject2).length() == 0))
      {
        paramJSONObject = null;
      }
      else
      {
        localObject3 = paramJSONObject.optJSONObject("open_screen_params");
        if ((localObject3 == null) || (((JSONObject)localObject3).length() == 0))
        {
          paramJSONObject = null;
        }
        else
        {
          localObject1 = new com/lantern/a/a/c;
          ((c)localObject1).<init>();
          localObject4 = paramJSONObject.optJSONObject("inner");
          if (localObject4 != null) {
            ((c)localObject1).a(((JSONObject)localObject4).optInt("creative_id", 0));
          }
          ((c)localObject1).d(paramJSONObject.optString("wifi_show", ""));
          ((c)localObject1).e(paramJSONObject.optString("wifi_click", ""));
          ((c)localObject1).f(((JSONObject)localObject2).optString("landing_url", ""));
          paramJSONObject = ((JSONObject)localObject2).optJSONArray("image_urls");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
            ((c)localObject1).a(paramJSONObject.optString(0, ""));
          }
          ((c)localObject1).a(((JSONObject)localObject3).optLong("start_time"));
          ((c)localObject1).b(((JSONObject)localObject3).optLong("end_time"));
          ((c)localObject1).b(((JSONObject)localObject3).optString("show_mode", "1"));
          ((c)localObject1).b(((JSONObject)localObject3).optInt("duration", 3));
          ((c)localObject1).b(((JSONObject)localObject3).optBoolean("can_skip", true));
          localObject4 = ((JSONObject)localObject2).optJSONArray("show_urls");
          if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
          {
            localObject3 = new java/util/ArrayList;
            ((ArrayList)localObject3).<init>();
            k = ((JSONArray)localObject4).length();
            i = 0;
            if (i < k)
            {
              paramJSONObject = ((JSONArray)localObject4).optString(i);
              if (!TextUtils.isEmpty(paramJSONObject)) {
                ((ArrayList)localObject3).add(paramJSONObject);
              }
              i++;
              continue;
            }
            ((c)localObject1).a((ArrayList)localObject3);
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("click_urls");
          paramJSONObject = (JSONObject)localObject1;
          if (localObject2 != null)
          {
            paramJSONObject = (JSONObject)localObject1;
            if (((JSONArray)localObject2).length() > 0)
            {
              paramJSONObject = new java/util/ArrayList;
              paramJSONObject.<init>();
              k = ((JSONArray)localObject2).length();
              i = j;
              if (i < k)
              {
                localObject3 = ((JSONArray)localObject2).optString(i);
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  paramJSONObject.add(localObject3);
                }
                i++;
              }
              else
              {
                ((c)localObject1).b(paramJSONObject);
                paramJSONObject = (JSONObject)localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  public static d a(String paramString)
  {
    int i = 0;
    d locald = new d();
    for (;;)
    {
      try
      {
        localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>(paramString);
        paramString = localJSONObject1.optJSONArray("ads");
        if (paramString != null) {
          if (paramString.length() != 0) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject1;
        int j;
        ArrayList localArrayList;
        a locala;
        Object localObject;
        JSONObject localJSONObject2;
        h.a(paramString);
        continue;
      }
      return locald;
      j = paramString.length();
      localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      if (i < j)
      {
        locala = new com/lantern/a/a/a;
        locala.<init>();
        localObject = paramString.optJSONObject(i);
        if ((localObject != null) || (((JSONObject)localObject).length() <= 0))
        {
          localJSONObject2 = ((JSONObject)localObject).optJSONObject("inner");
          if (localJSONObject2 != null) {
            locala.b = localJSONObject2.optInt("creative_id", 0);
          }
          locala.d = ((JSONObject)localObject).optString("dsp");
          locala.e = ((JSONObject)localObject).optString("mat_fea_md5");
          localObject = a((JSONObject)localObject);
          if (localObject != null)
          {
            locald.c = ((c)localObject).f();
            locala.c = ((c)localObject).f();
            localArrayList.add(localObject);
            locala.a = localArrayList;
          }
          locald.a.add(locala);
        }
        i++;
      }
      else
      {
        locald.b = localJSONObject1.optBoolean("allowed_reuse", false);
      }
    }
  }
  
  public static List<String> b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains(";")) {
        break label145;
      }
      h.a("splash  constins ; ", new Object[0]);
      paramString = paramString.split(";");
      h.a("splash  imageA.length " + paramString.length, new Object[0]);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = Arrays.asList(paramString);
        paramString = new StringBuilder("splash  imageA !=null list size ");
        if (localObject1 != null) {
          break label135;
        }
        i = 0;
        h.a(i, new Object[0]);
      }
    }
    label102:
    paramString = new StringBuilder("splash  list size ");
    if (localObject1 == null) {}
    for (int i = 0;; i = ((List)localObject1).size())
    {
      h.a(i, new Object[0]);
      return (List<String>)localObject1;
      label135:
      i = ((List)localObject1).size();
      break;
      label145:
      localObject1 = new ArrayList();
      ((List)localObject1).add(paramString);
      break label102;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */