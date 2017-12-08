package com.lantern.a.a;

import com.lantern.core.d.b.a;
import com.lantern.core.g;
import java.io.File;

final class h
  implements b.a
{
  h(e parame, c paramc) {}
  
  public final void a(boolean paramBoolean, String paramString)
  {
    File localFile;
    if (paramBoolean)
    {
      localFile = new File(paramString);
      paramString = this.a.h();
      if ((paramString == null) || (paramString.equals(""))) {
        break label93;
      }
      String str = g.a(localFile);
      if (paramString.equalsIgnoreCase(str)) {
        break label78;
      }
      com.bluefay.b.h.c("the md5 verify failed;fileMd5:" + str + "-----serverMd5:" + paramString);
    }
    for (;;)
    {
      return;
      label78:
      this.a.c(localFile.getAbsolutePath());
      continue;
      label93:
      this.a.c(localFile.getAbsolutePath());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */