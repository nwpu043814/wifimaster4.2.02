package ct;

import android.text.TextUtils;

public final class s
{
  public String a = "";
  public int b = -1;
  
  public s() {}
  
  public s(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public final String a()
  {
    return this.a + ":" + this.b;
  }
  
  public final boolean a(s params)
  {
    if ((params != null) && (this.a.equals(params.a)) && (this.b == params.b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramString = paramString.split(":");
      bool1 = bool2;
      if (paramString.length == 2)
      {
        this.a = paramString[0];
        try
        {
          this.b = Integer.parseInt(paramString[1]);
          bool1 = true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  public final String toString()
  {
    if (this.b == -1) {}
    for (String str = this.a;; str = a()) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */