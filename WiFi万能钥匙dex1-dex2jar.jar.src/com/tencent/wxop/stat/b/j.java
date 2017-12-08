package com.tencent.wxop.stat.b;

final class j
  extends i
{
  private static final int[] cJ = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] cK = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int bf;
  private final int[] cL;
  private int cu;
  
  public j(byte[] paramArrayOfByte)
  {
    this.cI = paramArrayOfByte;
    this.cL = cJ;
    this.cu = 0;
    this.bf = 0;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if (this.cu == 6) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i2 = paramInt + 0;
      int i = this.cu;
      int j = this.bf;
      byte[] arrayOfByte = this.cI;
      int[] arrayOfInt = this.cL;
      paramInt = 0;
      int k = 0;
      label48:
      int n = k;
      int i1 = j;
      if (paramInt < i2)
      {
        int m = k;
        n = j;
        i1 = paramInt;
        if (i == 0)
        {
          m = paramInt;
          for (paramInt = j; m + 4 <= i2; paramInt = j)
          {
            j = arrayOfInt[(paramArrayOfByte[m] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(m + 3)] & 0xFF)];
            paramInt = j;
            if (j < 0) {
              break;
            }
            arrayOfByte[(k + 2)] = ((byte)j);
            arrayOfByte[(k + 1)] = ((byte)(j >> 8));
            arrayOfByte[k] = ((byte)(j >> 16));
            k += 3;
            m += 4;
          }
          n = k;
          i1 = paramInt;
          if (m < i2)
          {
            i1 = m;
            n = paramInt;
            m = k;
          }
        }
        else
        {
          paramInt = i1 + 1;
          j = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
          switch (i)
          {
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      k = m;
                      j = n;
                      break;
                      if (j >= 0)
                      {
                        i++;
                        k = m;
                        break;
                      }
                    } while (j == -1);
                    this.cu = 6;
                    bool = false;
                    break;
                    if (j >= 0)
                    {
                      j = n << 6 | j;
                      i++;
                      k = m;
                      break label48;
                    }
                  } while (j == -1);
                  this.cu = 6;
                  bool = false;
                  break;
                  if (j >= 0)
                  {
                    j = n << 6 | j;
                    i++;
                    k = m;
                    break label48;
                  }
                  if (j == -2)
                  {
                    arrayOfByte[m] = ((byte)(n >> 4));
                    i = 4;
                    k = m + 1;
                    j = n;
                    break label48;
                  }
                } while (j == -1);
                this.cu = 6;
                bool = false;
                break;
                if (j >= 0)
                {
                  j = n << 6 | j;
                  arrayOfByte[(m + 2)] = ((byte)j);
                  arrayOfByte[(m + 1)] = ((byte)(j >> 8));
                  arrayOfByte[m] = ((byte)(j >> 16));
                  k = m + 3;
                  i = 0;
                  break label48;
                }
                if (j == -2)
                {
                  arrayOfByte[(m + 1)] = ((byte)(n >> 2));
                  arrayOfByte[m] = ((byte)(n >> 10));
                  k = m + 2;
                  i = 5;
                  j = n;
                  break label48;
                }
              } while (j == -1);
              this.cu = 6;
              bool = false;
              break;
              if (j == -2)
              {
                i++;
                k = m;
                j = n;
                break label48;
              }
            } while (j == -1);
            this.cu = 6;
            bool = false;
            break;
          } while (j == -1);
          this.cu = 6;
          bool = false;
          continue;
        }
      }
      paramInt = n;
      switch (i)
      {
      default: 
        paramInt = n;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.cu = i;
          this.g = paramInt;
          bool = true;
          break;
          this.cu = 6;
          bool = false;
          break;
          arrayOfByte[n] = ((byte)(i1 >> 4));
          paramInt = n + 1;
          continue;
          j = n + 1;
          arrayOfByte[n] = ((byte)(i1 >> 10));
          paramInt = j + 1;
          arrayOfByte[j] = ((byte)(i1 >> 2));
        }
      }
      this.cu = 6;
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */