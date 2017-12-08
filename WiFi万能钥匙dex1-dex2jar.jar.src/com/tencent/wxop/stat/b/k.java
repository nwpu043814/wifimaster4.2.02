package com.tencent.wxop.stat.b;

final class k
  extends i
{
  private static final byte[] cM;
  private static final byte[] cN;
  public final boolean ba = true;
  public final boolean bb = true;
  private final byte[] cO = new byte[2];
  public final boolean cP = false;
  private final byte[] cQ = cM;
  private int cc;
  int cp = 0;
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      ad = bool;
      cM = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      cN = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      return;
    }
  }
  
  public k()
  {
    this.cI = null;
    if (this.bb) {}
    for (int i = 19;; i = -1)
    {
      this.cc = i;
      return;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    byte[] arrayOfByte2 = this.cQ;
    byte[] arrayOfByte1 = this.cI;
    int j = this.cc;
    int i1 = paramInt + 0;
    int i;
    label60:
    int m;
    switch (this.cp)
    {
    default: 
      paramInt = -1;
      i = 0;
      if (paramInt != -1)
      {
        arrayOfByte1[0] = arrayOfByte2[(paramInt >> 18 & 0x3F)];
        arrayOfByte1[1] = arrayOfByte2[(paramInt >> 12 & 0x3F)];
        arrayOfByte1[2] = arrayOfByte2[(paramInt >> 6 & 0x3F)];
        m = 4;
        arrayOfByte1[3] = arrayOfByte2[(paramInt & 0x3F)];
        j--;
        if (j == 0)
        {
          paramInt = m;
          if (this.cP)
          {
            paramInt = 5;
            arrayOfByte1[4] = 13;
          }
          m = paramInt + 1;
          arrayOfByte1[paramInt] = 10;
          j = 19;
          paramInt = m;
        }
      }
      break;
    }
    for (;;)
    {
      label165:
      if (i + 3 <= i1)
      {
        m = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
        arrayOfByte1[paramInt] = arrayOfByte2[(m >> 18 & 0x3F)];
        arrayOfByte1[(paramInt + 1)] = arrayOfByte2[(m >> 12 & 0x3F)];
        arrayOfByte1[(paramInt + 2)] = arrayOfByte2[(m >> 6 & 0x3F)];
        arrayOfByte1[(paramInt + 3)] = arrayOfByte2[(m & 0x3F)];
        i += 3;
        paramInt += 4;
        j--;
        if (j != 0) {
          break label1009;
        }
        if (!this.cP) {
          break label1006;
        }
        j = paramInt + 1;
        arrayOfByte1[paramInt] = 13;
        paramInt = j;
      }
      label691:
      label710:
      label880:
      label1003:
      label1006:
      for (;;)
      {
        j = paramInt + 1;
        arrayOfByte1[paramInt] = 10;
        m = 19;
        paramInt = j;
        j = m;
        break label165;
        paramInt = -1;
        i = 0;
        break label60;
        if (2 > i1) {
          break;
        }
        i = this.cO[0];
        paramInt = paramArrayOfByte[0];
        m = paramArrayOfByte[1];
        this.cp = 0;
        paramInt = (i & 0xFF) << 16 | (paramInt & 0xFF) << 8 | m & 0xFF;
        i = 2;
        break label60;
        if (i1 <= 0) {
          break;
        }
        m = this.cO[0];
        i = this.cO[1];
        paramInt = paramArrayOfByte[0];
        this.cp = 0;
        paramInt = (m & 0xFF) << 16 | (i & 0xFF) << 8 | paramInt & 0xFF;
        i = 1;
        break label60;
        int n;
        if (i - this.cp == i1 - 1)
        {
          if (this.cp > 0) {
            m = this.cO[0];
          }
          for (k = 1;; k = 0)
          {
            m = (m & 0xFF) << 4;
            this.cp -= k;
            n = paramInt + 1;
            arrayOfByte1[paramInt] = arrayOfByte2[(m >> 6 & 0x3F)];
            k = n + 1;
            arrayOfByte1[n] = arrayOfByte2[(m & 0x3F)];
            paramInt = k;
            if (this.ba)
            {
              m = k + 1;
              arrayOfByte1[k] = 61;
              paramInt = m + 1;
              arrayOfByte1[m] = 61;
            }
            k = paramInt;
            if (this.bb)
            {
              k = paramInt;
              if (this.cP)
              {
                arrayOfByte1[paramInt] = 13;
                k = paramInt + 1;
              }
              arrayOfByte1[k] = 10;
              k++;
            }
            m = i;
            if ((ad) || (this.cp == 0)) {
              break;
            }
            throw new AssertionError();
            m = paramArrayOfByte[i];
            i++;
          }
        }
        if (i - this.cp == i1 - 2) {
          if (this.cp > 1)
          {
            m = this.cO[0];
            k = 1;
            if (this.cp <= 0) {
              break label880;
            }
            n = this.cO[k];
            k++;
            m = (n & 0xFF) << 2 | (m & 0xFF) << 10;
            this.cp -= k;
            n = paramInt + 1;
            arrayOfByte1[paramInt] = arrayOfByte2[(m >> 12 & 0x3F)];
            k = n + 1;
            arrayOfByte1[n] = arrayOfByte2[(m >> 6 & 0x3F)];
            paramInt = k + 1;
            arrayOfByte1[k] = arrayOfByte2[(m & 0x3F)];
            if (!this.ba) {
              break label1003;
            }
            k = paramInt + 1;
            arrayOfByte1[paramInt] = 61;
            paramInt = k;
          }
        }
        for (;;)
        {
          k = paramInt;
          if (this.bb)
          {
            k = paramInt;
            if (this.cP)
            {
              arrayOfByte1[paramInt] = 13;
              k = paramInt + 1;
            }
            arrayOfByte1[k] = 10;
            k++;
          }
          m = i;
          break;
          m = paramArrayOfByte[i];
          i++;
          break label691;
          n = paramArrayOfByte[i];
          i++;
          break label710;
          m = i;
          k = paramInt;
          if (!this.bb) {
            break;
          }
          m = i;
          k = paramInt;
          if (paramInt <= 0) {
            break;
          }
          m = i;
          k = paramInt;
          if (j == 19) {
            break;
          }
          if (this.cP)
          {
            k = paramInt + 1;
            arrayOfByte1[paramInt] = 13;
            paramInt = k;
          }
          for (;;)
          {
            k = paramInt + 1;
            arrayOfByte1[paramInt] = 10;
            m = i;
            break;
            if ((!ad) && (m != i1)) {
              throw new AssertionError();
            }
            this.g = k;
            this.cc = j;
            return true;
          }
        }
      }
      label1009:
      continue;
      paramInt = 4;
      continue;
      paramInt = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */