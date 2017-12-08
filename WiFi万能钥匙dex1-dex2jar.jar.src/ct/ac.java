package ct;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class ac
{
  public int a = 1;
  public byte[] b = null;
  public int c = 0;
  public int d = 0;
  public HttpResponse e;
  public int f = 0;
  
  public final int a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    if (this.e != null)
    {
      paramString = this.e.getFirstHeader(paramString);
      if (paramString == null) {}
    }
    for (paramString = paramString.getValue();; paramString = null) {
      return paramString;
    }
  }
  
  public final byte[] b()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */