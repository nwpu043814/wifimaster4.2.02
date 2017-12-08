package com.analysis.model;

import org.json.JSONArray;

public final class h
  extends g
{
  public h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(new JSONArray(paramString1), paramString2, paramString3, paramString4);
  }
  
  private h(JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3)
  {
    a(paramJSONArray, paramString1, paramString2, paramString3);
  }
  
  private void a(JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3)
  {
    this.f = paramString1;
    this.j = paramString2;
    this.k = paramString3;
    this.g = paramJSONArray.getString(0);
    this.h = paramJSONArray.getLong(1);
    this.i = paramJSONArray.getLong(2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */