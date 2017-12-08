package com.lantern.favorite.c;

import org.json.JSONArray;

public final class d
{
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      if (paramString.equals("[]")) {
        paramString = "";
      } else {
        try
        {
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>(paramString);
          int j = localJSONArray.length();
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          for (int i = 0; i < j; i++) {
            paramString.append((String)localJSONArray.get(i)).append(", ");
          }
          paramString.replace(paramString.length() - 2, paramString.length(), "");
          paramString = paramString.toString();
        }
        catch (Exception paramString)
        {
          paramString = "";
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */