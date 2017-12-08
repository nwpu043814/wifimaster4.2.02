package com.lantern.wifiseccheck;

import com.lantern.wifiseccheck.protocol.Neighbour;
import java.util.ArrayList;
import java.util.List;

public class ExtraInfo
{
  private String bssid;
  private List<Neighbour> neighbours = new ArrayList();
  private String ssid;
  
  public String getBssid()
  {
    return this.bssid;
  }
  
  public List<Neighbour> getNeighbours()
  {
    return this.neighbours;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public void setBssid(String paramString)
  {
    this.bssid = paramString;
  }
  
  public void setNeighbours(List<Neighbour> paramList)
  {
    this.neighbours = new ArrayList(paramList);
    paramList.clear();
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/ExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */