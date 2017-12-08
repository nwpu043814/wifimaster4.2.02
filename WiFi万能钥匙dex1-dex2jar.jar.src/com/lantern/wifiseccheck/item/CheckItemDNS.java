package com.lantern.wifiseccheck.item;

import com.lantern.wifiseccheck.protocol.DomainResult;
import java.util.ArrayList;
import java.util.List;

public class CheckItemDNS
  extends ICheckItem
{
  public static final String[] CHECK_DOMAINS = { "www.baidu.com", "www.taobao.com", "www.jd.com", "www.alipay.com" };
  private List<DomainResult> domainResults = new ArrayList();
  private String[] domains;
  
  public CheckItemDNS(String[] paramArrayOfString)
  {
    this.domains = paramArrayOfString;
    initDefaultData();
  }
  
  public List<DomainResult> getDomainResults()
  {
    return this.domainResults;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void initDefaultData()
  {
    for (String str : this.domains)
    {
      DomainResult localDomainResult = new DomainResult();
      localDomainResult.setDomainName(str);
      localDomainResult.setIps(new ArrayList());
      this.domainResults.add(localDomainResult);
    }
  }
  
  public boolean isTimeOutType()
  {
    return true;
  }
  
  public void setDomainResults(List<DomainResult> paramList)
  {
    this.domainResults = paramList;
    setFinish(true);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemDNS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */