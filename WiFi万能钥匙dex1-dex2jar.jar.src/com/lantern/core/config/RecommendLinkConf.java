package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.core.g;
import com.lantern.core.g.k;
import com.lantern.core.g.k.b;
import java.io.File;
import org.json.JSONObject;

public class RecommendLinkConf
  extends a
{
  private String e;
  private String f;
  private String g;
  private String h;
  
  public RecommendLinkConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {}
    for (this.h = "";; this.h = paramString)
    {
      b.b(this.b, "re_icon_path", this.h);
      return;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optString("link", "http://act1.lianwifi.com/appsearch/index.html?ref=bbx");
      this.f = paramJSONObject.optString("title", "");
      this.g = paramJSONObject.optString("icon", "");
    }
  }
  
  private void g()
  {
    String str2 = g.a(this.g);
    String str1 = this.b.getFilesDir().getAbsolutePath();
    com.lantern.core.d.b.a(this.g, str1, str2, new f(this));
  }
  
  protected final void a()
  {
    super.a();
    this.e = "http://act1.lianwifi.com/appsearch/index.html?ref=bbx";
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    this.h = b.a(this.b, "re_icon_path", "");
    if ((!TextUtils.isEmpty(this.g)) && (TextUtils.isEmpty(this.h))) {
      g();
    }
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    a(null);
    if (!TextUtils.isEmpty(this.g)) {
      g();
    }
    k.a().a(k.b.u);
  }
  
  public final String d()
  {
    return this.e;
  }
  
  public final String e()
  {
    return this.f;
  }
  
  public final String f()
  {
    return this.h;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/RecommendLinkConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */