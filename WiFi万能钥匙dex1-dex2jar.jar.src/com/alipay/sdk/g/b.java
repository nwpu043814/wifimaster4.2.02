package com.alipay.sdk.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class b
{
  public a a;
  public String[] b;
  private String c;
  
  private b(String paramString, a parama)
  {
    this.c = paramString;
    this.a = parama;
  }
  
  public static List a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {}
    for (;;)
    {
      return localArrayList;
      Object localObject = paramJSONObject.optString("name", "");
      paramJSONObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramJSONObject = ((String)localObject).split(";");
      }
      for (int i = 0; i < paramJSONObject.length; i++)
      {
        localObject = a.a(paramJSONObject[i]);
        if (localObject != a.a)
        {
          localObject = new b(paramJSONObject[i], (a)localObject);
          ((b)localObject).b = a(paramJSONObject[i]);
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  private static String[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramString.indexOf('(');
    int i = paramString.lastIndexOf(')');
    if ((j == -1) || (i == -1) || (i <= j)) {}
    for (paramString = null;; paramString = (String[])localArrayList.toArray(new String[0]))
    {
      return paramString;
      paramString = paramString.substring(j + 1, i).split(",");
      if (paramString != null) {
        for (i = 0; i < paramString.length; i++) {
          if (!TextUtils.isEmpty(paramString[i])) {
            localArrayList.add(paramString[i].trim().replaceAll("'", "").replaceAll("\"", ""));
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */