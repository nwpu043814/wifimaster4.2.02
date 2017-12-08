package com.alibaba.fastjson.util;

public class IdentityHashMap<K, V>
{
  public static final int DEFAULT_TABLE_SIZE = 1024;
  private final Entry<K, V>[] buckets;
  private final int indexMask;
  
  public IdentityHashMap()
  {
    this(1024);
  }
  
  public IdentityHashMap(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new Entry[paramInt];
  }
  
  public final V get(K paramK)
  {
    int j = System.identityHashCode(paramK);
    int i = this.indexMask;
    Entry localEntry = this.buckets[(j & i)];
    if (localEntry != null) {
      if (paramK != localEntry.key) {}
    }
    for (paramK = localEntry.value;; paramK = null)
    {
      return paramK;
      localEntry = localEntry.next;
      break;
    }
  }
  
  public boolean put(K paramK, V paramV)
  {
    int j = System.identityHashCode(paramK);
    int i = j & this.indexMask;
    Entry localEntry = this.buckets[i];
    if (localEntry != null) {
      if (paramK == localEntry.key) {
        localEntry.value = paramV;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localEntry = localEntry.next;
      break;
      paramK = new Entry(paramK, paramV, j, this.buckets[i]);
      this.buckets[i] = paramK;
    }
  }
  
  public int size()
  {
    int i = 0;
    int j = 0;
    while (i < this.buckets.length)
    {
      Entry localEntry = this.buckets[i];
      while (localEntry != null)
      {
        localEntry = localEntry.next;
        j++;
      }
      i++;
    }
    return j;
  }
  
  protected static final class Entry<K, V>
  {
    public final int hashCode;
    public final K key;
    public final Entry<K, V> next;
    public V value;
    
    public Entry(K paramK, V paramV, int paramInt, Entry<K, V> paramEntry)
    {
      this.key = paramK;
      this.value = paramV;
      this.next = paramEntry;
      this.hashCode = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/IdentityHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */