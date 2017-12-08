package ct;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class cu
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public cy c;
  
  cu() {}
  
  public cu(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new cy(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
              cx localcx = new ct/cx;
              localcx.<init>(localJSONObject);
              this.b.add(localcx);
              i++;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = cy.a;
              b.a.b("DetailsData", "DetailsData: unknown json " + paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          b.a.a("DetailsData", "json error", paramJSONObject);
        }
      }
    }
  }
  
  private static cy a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    Object localObject1;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return (cy)localObject1;
      cy localcy = cy.a(cy.a);
      int j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localcy.b = ((JSONObject)localObject1).optString("n");
        localcy.e = ((JSONObject)localObject1).optString("p");
        localcy.f = ((JSONObject)localObject1).optString("c");
        localcy.g = ((JSONObject)localObject1).optString("d");
        localcy.d = ((JSONObject)localObject1).optString("adcode");
      }
      Object localObject2;
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localcy.l.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localcy.l.putParcelable("addrdesp.landmark", new ct((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localcy.l.putParcelable("addrdesp.second_landmark", new ct((JSONObject)localObject1));
        }
      }
      localObject1 = localcy;
      if (j > 2)
      {
        localObject2 = new ArrayList();
        if (i < j)
        {
          localObject1 = new ct(paramJSONArray.optJSONObject(i));
          ((ArrayList)localObject2).add(localObject1);
          if ("ST".equals(((ct)localObject1).b)) {
            localcy.j = ((ct)localObject1).a;
          }
          for (;;)
          {
            i++;
            break;
            if ("ST_NO".equals(((ct)localObject1).b)) {
              localcy.k = ((ct)localObject1).a;
            }
          }
        }
        localcy.l.putParcelableArrayList("addrdesp.results", (ArrayList)localObject2);
        localObject1 = localcy;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */