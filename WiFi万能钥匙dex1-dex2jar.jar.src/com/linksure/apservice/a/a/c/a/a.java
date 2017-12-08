package com.linksure.apservice.a.a.c.a;

import com.linksure.apservice.a.a.c.b;
import org.json.JSONObject;

public final class a
{
  public static final class a
    extends com.linksure.apservice.a.a.a.a
  {
    private String a;
    private String b;
    
    public a(String paramString)
    {
      this.a = paramString;
      if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".JPG"))) {
        this.b = "image/jpg";
      }
      for (;;)
      {
        return;
        if ((paramString.endsWith(".png")) || (paramString.endsWith(".PNG"))) {
          this.b = "image/png";
        } else {
          this.b = "image/png";
        }
      }
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final String b()
    {
      return this.b;
    }
    
    public final String c()
    {
      return "wk_0004";
    }
    
    public final String d()
    {
      return "https://fs.51y5.net/fs/uploadImg.action";
    }
    
    public final String e()
    {
      return "";
    }
  }
  
  public static class b
    extends b<String>
  {
    public final void a(JSONObject paramJSONObject)
    {
      this.c = paramJSONObject.optString("url");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */