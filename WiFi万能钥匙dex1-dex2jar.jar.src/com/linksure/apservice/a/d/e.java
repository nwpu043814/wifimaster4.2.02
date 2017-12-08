package com.linksure.apservice.a.d;

import java.util.Iterator;
import java.util.List;

public final class e
{
  public String a;
  public String b;
  public String c;
  public List<e> d;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{id:").append(this.a).append(",name:").append(this.b).append(",url:").append(this.c).append(",");
    if ((this.d != null) && (!this.d.isEmpty()))
    {
      localStringBuilder.append("children:[");
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((e)localIterator.next());
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */