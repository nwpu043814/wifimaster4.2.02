package com.lantern.webox.a.a;

import com.lantern.webox.domain.WebAppConfig;
import java.util.LinkedList;

public final class b
  implements com.lantern.webox.a.b
{
  public final WebAppConfig a(String paramString)
  {
    WebAppConfig localWebAppConfig = new WebAppConfig();
    localWebAppConfig.setDisabled(false);
    localWebAppConfig.setSecurityLevel(3);
    localWebAppConfig.setDomain(paramString);
    localWebAppConfig.setDownloadEnabled(true);
    localWebAppConfig.setDownloadBlackList(new LinkedList());
    return localWebAppConfig;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */