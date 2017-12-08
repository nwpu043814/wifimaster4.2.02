package com.lantern.dm.a;

import java.io.File;

public abstract class a
{
  private String a = a();
  
  public a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public abstract String a();
  
  public abstract String a(String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */