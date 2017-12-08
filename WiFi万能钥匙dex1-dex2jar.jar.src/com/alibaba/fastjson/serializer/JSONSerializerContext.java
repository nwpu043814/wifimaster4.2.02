package com.alibaba.fastjson.serializer;

public final class JSONSerializerContext
{
  public static final int DEFAULT_TABLE_SIZE = 128;
  private final Entry[] buckets;
  private final int indexMask;
  
  public JSONSerializerContext()
  {
    this(128);
  }
  
  public JSONSerializerContext(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new Entry[paramInt];
  }
  
  public final boolean put(Object paramObject)
  {
    int j = System.identityHashCode(paramObject);
    int i = j & this.indexMask;
    Entry localEntry = this.buckets[i];
    if (localEntry != null) {
      if (paramObject != localEntry.object) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localEntry = localEntry.next;
      break;
      paramObject = new Entry(paramObject, j, this.buckets[i]);
      this.buckets[i] = paramObject;
    }
  }
  
  protected static final class Entry
  {
    public final int hashCode;
    public Entry next;
    public final Object object;
    
    public Entry(Object paramObject, int paramInt, Entry paramEntry)
    {
      this.object = paramObject;
      this.next = paramEntry;
      this.hashCode = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONSerializerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */