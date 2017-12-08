package com.lantern.base.a;

import java.util.Arrays;
import java.util.List;

public final class b
{
  private String a;
  private String b;
  private List<String> c;
  private String d;
  
  public b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.a = paramString1;
    this.b = paramString2;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (this.c = Arrays.asList(paramArrayOfString);; this.c = null) {
      return;
    }
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    if ((this.b == null) || (this.b.length() == 0)) {
      this.b = (this.a + "_TEMP");
    }
    return this.b;
  }
  
  public final String c()
  {
    Object localObject;
    if (((this.d == null) || (this.d.length() == 0)) && (this.c != null) && (!this.c.isEmpty()))
    {
      String[] arrayOfString = (String[])this.c.toArray();
      if (arrayOfString == null) {
        break label131;
      }
      localObject = new StringBuilder();
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++)
      {
        String str = arrayOfString[i];
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).append(",");
        }
        ((StringBuilder)localObject).append(str);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((StringBuilder)localObject).toString();; localObject = null)
      {
        this.d = ((String)localObject);
        return this.d;
      }
      label131:
      localObject = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/base/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */