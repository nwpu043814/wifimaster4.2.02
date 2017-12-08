package com.lantern.launcher.task;

import android.content.Context;
import com.lantern.core.config.a;
import org.json.JSONObject;

public class XunfeiCorpConf
  extends a
{
  private int e;
  
  public XunfeiCorpConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optInt("send_login_req", 0);
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public final int d()
  {
    return this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/task/XunfeiCorpConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */