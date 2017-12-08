package com.lantern.wifiseccheck;

import java.util.ArrayList;

public class FIFOList<E>
{
  private ArrayList<E> mList = new ArrayList();
  
  public void clear()
  {
    this.mList.clear();
  }
  
  public boolean contains(E paramE)
  {
    return this.mList.contains(paramE);
  }
  
  public E getItem()
  {
    if (this.mList.isEmpty()) {}
    for (Object localObject = null;; localObject = this.mList.remove(0)) {
      return (E)localObject;
    }
  }
  
  public boolean isEmpty()
  {
    return this.mList.isEmpty();
  }
  
  public void put(E paramE)
  {
    if (this.mList.contains(paramE)) {
      this.mList.remove(paramE);
    }
    this.mList.add(paramE);
  }
  
  public boolean remove(E paramE)
  {
    return this.mList.remove(paramE);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/FIFOList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */