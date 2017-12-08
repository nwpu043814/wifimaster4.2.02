package com.wifi.connect.plugin.magickey.b;

public final class a
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public int f;
  public int g;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pwdid:" + this.a + "\n");
    localStringBuilder.append("pwd:" + this.b + "\n");
    localStringBuilder.append("apid:" + this.c + "\n");
    localStringBuilder.append("ccId:" + this.d + "\n");
    localStringBuilder.append("keystatus:" + this.e + "\n");
    localStringBuilder.append("authType:" + this.f + "\n");
    localStringBuilder.append("security:" + this.g);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */