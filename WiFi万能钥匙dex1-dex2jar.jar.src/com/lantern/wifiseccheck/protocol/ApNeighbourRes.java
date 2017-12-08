package com.lantern.wifiseccheck.protocol;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApNeighbourRes
{
  private String logoRelativePath;
  private int netState;
  private Map<String, String> vendorLogo;
  private Map<String, List<Neighbour>> vendorMap;
  
  public String getLogoRelativePath()
  {
    return this.logoRelativePath;
  }
  
  public int getNetState()
  {
    return this.netState;
  }
  
  public Map<String, String> getVendorLogo()
  {
    return this.vendorLogo;
  }
  
  public Map<String, List<Neighbour>> getVendorMap()
  {
    return this.vendorMap;
  }
  
  public boolean isEmpty()
  {
    if ((this.vendorMap == null) || (this.vendorMap.isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setLogoRelativePath(String paramString)
  {
    this.logoRelativePath = paramString;
  }
  
  public void setNetState(int paramInt)
  {
    this.netState = paramInt;
  }
  
  public void setVendorLogo(Map<String, String> paramMap)
  {
    this.vendorLogo = paramMap;
  }
  
  public void setVendorMap(Map<String, List<Neighbour>> paramMap)
  {
    this.vendorMap = paramMap;
  }
  
  public String toString()
  {
    Object localObject2 = "";
    Iterator localIterator1 = this.vendorMap.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      for (Object localObject1 = localObject2;; localObject1 = (String)localObject1 + ((Neighbour)localObject2).getMac() + ";")
      {
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (Neighbour)localIterator2.next();
      }
    }
    return (String)localObject2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/ApNeighbourRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */