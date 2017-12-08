package com.linksure.apservice.a.d;

public final class f
{
  public long a;
  public int b;
  public int c;
  public String d;
  public String e;
  public int f;
  public long g;
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{id:").append(this.a).append(",type:").append(this.b).append(",state:").append(this.c).append(",ctg:");
    if (this.f == 1) {}
    for (String str = "send";; str = "receive")
    {
      localStringBuilder2.append(str).append(",content:").append(this.d).append(",thread:").append(this.e).append(",ts:").append(this.g).append("}");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */