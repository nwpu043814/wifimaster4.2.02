package com.lantern.wifiseccheck;

import com.lantern.wifiseccheck.protocol.Neighbour;
import java.util.List;

public class NeighbourGroupItem
  implements Comparable<NeighbourGroupItem>
{
  private String groupName;
  private String iconUrl;
  private List<Neighbour> neighbours;
  
  public int compareTo(NeighbourGroupItem paramNeighbourGroupItem)
  {
    if (this.neighbours.size() < paramNeighbourGroupItem.getNeighbours().size()) {}
    for (int i = 1;; i = -1) {
      return i;
    }
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public List<Neighbour> getNeighbours()
  {
    return this.neighbours;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
  
  public void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
  }
  
  public void setNeighbours(List<Neighbour> paramList)
  {
    this.neighbours = paramList;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/NeighbourGroupItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */