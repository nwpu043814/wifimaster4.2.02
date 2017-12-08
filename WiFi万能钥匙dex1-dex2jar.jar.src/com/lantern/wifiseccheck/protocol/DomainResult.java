package com.lantern.wifiseccheck.protocol;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DomainResult
{
  private String domainName;
  private List<String> ips;
  
  public DomainResult() {}
  
  public DomainResult(String paramString)
  {
    this.domainName = paramString;
  }
  
  public void addIp(String paramString)
  {
    if (this.ips == null) {
      this.ips = new LinkedList();
    }
    this.ips.add(paramString);
  }
  
  public String getDomainName()
  {
    return this.domainName;
  }
  
  public List<String> getIps()
  {
    return this.ips;
  }
  
  public void setDomainName(String paramString)
  {
    this.domainName = paramString;
  }
  
  public void setIps(List<String> paramList)
  {
    this.ips = paramList;
  }
  
  public String toString()
  {
    String str1 = this.domainName + "||";
    String str2 = str1;
    if (this.ips != null)
    {
      Iterator localIterator = this.ips.iterator();
      for (;;)
      {
        str2 = str1;
        if (!localIterator.hasNext()) {
          break;
        }
        str1 = str1 + (String)localIterator.next() + ";";
      }
    }
    return str2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/DomainResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */