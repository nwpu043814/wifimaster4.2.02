package com.linksure.apservice.b;

public final class b
{
  public String a;
  public String b;
  public int c;
  public boolean d;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{code:").append(this.a).append(",desc:").append(this.b).append(",indexNo:").append(this.c).append(",isShow:").append(this.d).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */