package com.lantern.bindapp.b;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private String a;
  private com.lantern.bindapp.a.a b;
  
  public a(com.lantern.bindapp.a.a parama, String paramString)
  {
    this.b = parama;
    this.a = paramString;
  }
  
  private ArrayList<String> a()
  {
    Object localObject1;
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b.i))) {
      localObject1 = null;
    }
    for (;;)
    {
      return (ArrayList<String>)localObject1;
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(this.b.i);
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray(this.a);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          ArrayList localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          for (int i = 0;; i++)
          {
            localObject1 = localArrayList;
            if (i >= localJSONArray.length()) {
              break;
            }
            localObject1 = localJSONArray.getJSONObject(i).getString("url");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        h.a(localException);
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */