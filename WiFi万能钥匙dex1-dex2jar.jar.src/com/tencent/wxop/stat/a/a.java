package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends d
{
  protected b bj = new b();
  private long bk = -1L;
  
  public a(Context paramContext, int paramInt, String paramString, f paramf)
  {
    super(paramContext, paramInt, paramf);
    this.bj.a = paramString;
  }
  
  public final b ab()
  {
    return this.bj;
  }
  
  public final e ac()
  {
    return e.bA;
  }
  
  public final boolean b(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ei", this.bj.a);
    if (this.bk > 0L) {
      paramJSONObject.put("du", this.bk);
    }
    Object localObject;
    if (this.bj.bl == null)
    {
      if (this.bj.a != null)
      {
        localObject = com.tencent.wxop.stat.e.p(this.bj.a);
        if ((localObject != null) && (((Properties)localObject).size() > 0))
        {
          if ((this.bj.bm != null) && (this.bj.bm.length() != 0)) {
            break label130;
          }
          this.bj.bm = new JSONObject((Map)localObject);
        }
      }
      paramJSONObject.put("kv", this.bj.bm);
    }
    for (;;)
    {
      return true;
      label130:
      localObject = ((Properties)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        try
        {
          this.bj.bm.put(localEntry.getKey().toString(), localEntry.getValue());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      break;
      paramJSONObject.put("ar", this.bj.bl);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */