package cm.pass.sdk.utils;

import cm.pass.sdk.interfaces.f;

class d$2
  implements f
{
  private int c = 1;
  
  d$2(d paramd, f paramf) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this.c += 1;
    if (("212".equals(paramString1)) && (this.c <= 3)) {}
    for (;;)
    {
      try
      {
        Thread.sleep(1500L);
        d.a(this.b, d.a(this.b));
        return;
      }
      catch (InterruptedException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      this.a.a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, this.c - 1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */