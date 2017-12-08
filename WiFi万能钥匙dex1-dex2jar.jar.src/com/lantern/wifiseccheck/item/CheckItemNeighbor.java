package com.lantern.wifiseccheck.item;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.Neighbour;
import java.util.ArrayList;
import java.util.List;

public class CheckItemNeighbor
  extends ICheckItem
{
  private static final String TAG = "CheckItemNeighbor";
  private int neighborCount;
  private List<Neighbour> neighbours = null;
  private int percent = 0;
  
  public CheckItemNeighbor()
  {
    initDefaultData();
  }
  
  public List<Neighbour> getNeighbors()
  {
    return this.neighbours;
  }
  
  public int getPercent()
  {
    return this.percent;
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void initDefaultData()
  {
    this.neighborCount = 1;
    this.neighbours = new ArrayList();
  }
  
  public boolean isTimeOutType()
  {
    return true;
  }
  
  public void putNeighbours(List<Neighbour> paramList)
  {
    LogUtils.d("CheckItemNeighbor", "get neighbor " + paramList.size());
    if ((paramList != null) && (paramList.size() > 0)) {
      this.neighbours = paramList;
    }
    setFinish(true);
  }
  
  public void setPercent(int paramInt)
  {
    this.percent = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemNeighbor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */