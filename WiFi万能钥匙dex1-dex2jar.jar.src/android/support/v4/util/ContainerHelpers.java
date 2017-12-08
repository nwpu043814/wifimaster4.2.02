package android.support.v4.util;

class ContainerHelpers
{
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt1--;
    int i = 0;
    while (i <= paramInt1)
    {
      int j = i + paramInt1 >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2)
      {
        i = j + 1;
      }
      else
      {
        paramInt1 = j;
        if (k <= paramInt2) {
          return paramInt1;
        }
        paramInt1 = j - 1;
      }
    }
    paramInt1 = i ^ 0xFFFFFFFF;
    return paramInt1;
  }
  
  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = paramInt - 1;
    paramInt = 0;
    while (paramInt <= i)
    {
      int j = paramInt + i >>> 1;
      long l = paramArrayOfLong[j];
      if (l < paramLong)
      {
        paramInt = j + 1;
      }
      else
      {
        i = j;
        if (l <= paramLong) {
          break label67;
        }
        i = j - 1;
      }
    }
    i = paramInt ^ 0xFFFFFFFF;
    label67:
    return i;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    for (int j = 4;; j++)
    {
      int i = paramInt;
      if (j < 32)
      {
        if (paramInt <= (1 << j) - 12) {
          i = (1 << j) - 12;
        }
      }
      else {
        return i;
      }
    }
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/util/ContainerHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */