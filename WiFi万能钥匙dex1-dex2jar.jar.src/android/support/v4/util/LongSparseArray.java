package android.support.v4.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private long[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
    }
    for (this.mValues = ContainerHelpers.EMPTY_OBJECTS;; this.mValues = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[paramInt];
    }
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    int j;
    for (int k = 0; i < m; k = j)
    {
      Object localObject = arrayOfObject[i];
      j = k;
      if (localObject != DELETED)
      {
        if (i != k)
        {
          arrayOfLong[k] = arrayOfLong[i];
          arrayOfObject[k] = localObject;
          arrayOfObject[i] = null;
        }
        j = k + 1;
      }
      i++;
    }
    this.mGarbage = false;
    this.mSize = k;
  }
  
  public void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.mKeys[(this.mSize - 1)])) {
      put(paramLong, paramE);
    }
    for (;;)
    {
      return;
      if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
        gc();
      }
      int j = this.mSize;
      if (j >= this.mKeys.length)
      {
        int i = ContainerHelpers.idealLongArraySize(j + 1);
        long[] arrayOfLong = new long[i];
        Object[] arrayOfObject = new Object[i];
        System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
        System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
        this.mKeys = arrayOfLong;
        this.mValues = arrayOfObject;
      }
      this.mKeys[j] = paramLong;
      this.mValues[j] = paramE;
      this.mSize = (j + 1);
    }
  }
  
  public void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0; i < j; i++) {
      arrayOfObject[i] = null;
    }
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  /* Error */
  public LongSparseArray<E> clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 72	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	android/support/v4/util/LongSparseArray
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 37	android/support/v4/util/LongSparseArray:mKeys	[J
    //   13: invokevirtual 74	[J:clone	()Ljava/lang/Object;
    //   16: checkcast 73	[J
    //   19: putfield 37	android/support/v4/util/LongSparseArray:mKeys	[J
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 42	android/support/v4/util/LongSparseArray:mValues	[Ljava/lang/Object;
    //   27: invokevirtual 76	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 75	[Ljava/lang/Object;
    //   33: putfield 42	android/support/v4/util/LongSparseArray:mValues	[Ljava/lang/Object;
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -5 -> 36
    //   44: astore_2
    //   45: goto -9 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	LongSparseArray
    //   7	30	1	localLongSparseArray	LongSparseArray
    //   38	1	1	localCloneNotSupportedException1	CloneNotSupportedException
    //   40	1	1	localObject	Object
    //   44	1	2	localCloneNotSupportedException2	CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   0	8	38	java/lang/CloneNotSupportedException
    //   8	36	44	java/lang/CloneNotSupportedException
  }
  
  public void delete(long paramLong)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public E get(long paramLong)
  {
    return (E)get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    Object localObject = paramE;
    if (i >= 0) {
      if (this.mValues[i] != DELETED) {
        break label41;
      }
    }
    label41:
    for (localObject = paramE;; localObject = this.mValues[i]) {
      return (E)localObject;
    }
  }
  
  public int indexOfKey(long paramLong)
  {
    if (this.mGarbage) {
      gc();
    }
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
  }
  
  public int indexOfValue(E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    int i = 0;
    if (i < this.mSize) {
      if (this.mValues[i] != paramE) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  public long keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0) {
      this.mValues[i] = paramE;
    }
    for (;;)
    {
      return;
      int j = i ^ 0xFFFFFFFF;
      if ((j < this.mSize) && (this.mValues[j] == DELETED))
      {
        this.mKeys[j] = paramLong;
        this.mValues[j] = paramE;
      }
      else
      {
        i = j;
        if (this.mGarbage)
        {
          i = j;
          if (this.mSize >= this.mKeys.length)
          {
            gc();
            i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong) ^ 0xFFFFFFFF;
          }
        }
        if (this.mSize >= this.mKeys.length)
        {
          j = ContainerHelpers.idealLongArraySize(this.mSize + 1);
          long[] arrayOfLong = new long[j];
          Object[] arrayOfObject = new Object[j];
          System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfLong;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - i != 0)
        {
          System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
          System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mKeys[i] = paramLong;
        this.mValues[i] = paramE;
        this.mSize += 1;
      }
    }
  }
  
  public void remove(long paramLong)
  {
    delete(paramLong);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    this.mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
  
  public String toString()
  {
    if (size() <= 0) {}
    for (Object localObject1 = "{}";; localObject1 = ((StringBuilder)localObject1).toString())
    {
      return (String)localObject1;
      localObject1 = new StringBuilder(this.mSize * 28);
      ((StringBuilder)localObject1).append('{');
      int i = 0;
      if (i < this.mSize)
      {
        if (i > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(keyAt(i));
        ((StringBuilder)localObject1).append('=');
        Object localObject2 = valueAt(i);
        if (localObject2 != this) {
          ((StringBuilder)localObject1).append(localObject2);
        }
        for (;;)
        {
          i++;
          break;
          ((StringBuilder)localObject1).append("(this Map)");
        }
      }
      ((StringBuilder)localObject1).append('}');
    }
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return (E)this.mValues[paramInt];
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/util/LongSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */