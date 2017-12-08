package com.alibaba.fastjson.util;

import java.util.Arrays;

public class Base64
{
  public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  public static final int[] IA;
  
  static
  {
    int[] arrayOfInt = new int['Ā'];
    IA = arrayOfInt;
    Arrays.fill(arrayOfInt, -1);
    int j = CA.length;
    for (int i = 0; i < j; i++) {
      IA[CA[i]] = i;
    }
    IA[61] = 0;
  }
  
  public static final byte[] decodeFast(String paramString)
  {
    int i2 = 0;
    int k = paramString.length();
    if (k == 0)
    {
      paramString = new byte[0];
      return paramString;
    }
    int n = k - 1;
    for (int i = 0; (i < n) && (IA[(paramString.charAt(i) & 0xFF)] < 0); i++) {}
    for (;;)
    {
      if ((n > 0) && (IA[(paramString.charAt(n) & 0xFF)] < 0))
      {
        n--;
      }
      else
      {
        int j;
        int m;
        if (paramString.charAt(n) == '=') {
          if (paramString.charAt(n - 1) == '=')
          {
            j = 2;
            m = n - i + 1;
            if (k <= 76) {
              break label386;
            }
            if (paramString.charAt(76) != '\r') {
              break label381;
            }
            k = m / 78;
          }
        }
        label138:
        int i6;
        byte[] arrayOfByte;
        int i3;
        label381:
        label386:
        for (int i1 = k << 1;; i1 = 0)
        {
          i6 = ((m - i1) * 6 >> 3) - j;
          arrayOfByte = new byte[i6];
          int i7 = i6 / 3;
          m = 0;
          k = 0;
          while (k < i7 * 3)
          {
            int[] arrayOfInt = IA;
            int i4 = i + 1;
            i = arrayOfInt[paramString.charAt(i)];
            arrayOfInt = IA;
            i3 = i4 + 1;
            int i5 = arrayOfInt[paramString.charAt(i4)];
            arrayOfInt = IA;
            i4 = i3 + 1;
            int i8 = arrayOfInt[paramString.charAt(i3)];
            arrayOfInt = IA;
            i3 = i4 + 1;
            i = i8 << 6 | i << 18 | i5 << 12 | arrayOfInt[paramString.charAt(i4)];
            i4 = k + 1;
            arrayOfByte[k] = ((byte)(i >> 16));
            k = i4 + 1;
            arrayOfByte[i4] = ((byte)(i >> 8));
            i4 = k + 1;
            arrayOfByte[k] = ((byte)i);
            i = i3;
            k = i4;
            if (i1 > 0)
            {
              i5 = m + 1;
              m = i5;
              i = i3;
              k = i4;
              if (i5 == 19)
              {
                i = i3 + 2;
                m = 0;
                k = i4;
              }
            }
          }
          j = 1;
          break;
          j = 0;
          break;
          k = 0;
          break label138;
        }
        if (k < i6)
        {
          i1 = i;
          m = 0;
          i = i2;
          for (;;)
          {
            i2 = i;
            if (i1 > n - j) {
              break;
            }
            i3 = IA[paramString.charAt(i1)];
            i = i2 + 1;
            m = i3 << 18 - i2 * 6 | m;
            i1++;
          }
          j = 16;
          for (i = k; i < i6; i++)
          {
            arrayOfByte[i] = ((byte)(m >> j));
            j -= 8;
          }
        }
        paramString = arrayOfByte;
        break;
      }
    }
  }
  
  public static final byte[] decodeFast(String paramString, int paramInt1, int paramInt2)
  {
    int n = 0;
    if (paramInt2 == 0)
    {
      paramString = new byte[0];
      return paramString;
    }
    int k = paramInt1 + paramInt2 - 1;
    while ((paramInt1 < k) && (IA[paramString.charAt(paramInt1)] < 0)) {
      paramInt1++;
    }
    for (;;)
    {
      if ((k > 0) && (IA[paramString.charAt(k)] < 0))
      {
        k--;
      }
      else
      {
        int i;
        int j;
        if (paramString.charAt(k) == '=') {
          if (paramString.charAt(k - 1) == '=')
          {
            i = 2;
            j = k - paramInt1 + 1;
            if (paramInt2 <= 76) {
              break label373;
            }
            if (paramString.charAt(76) != '\r') {
              break label368;
            }
            paramInt2 = j / 78;
          }
        }
        label125:
        int i4;
        byte[] arrayOfByte;
        int i1;
        label368:
        label373:
        for (int m = paramInt2 << 1;; m = 0)
        {
          i4 = ((j - m) * 6 >> 3) - i;
          arrayOfByte = new byte[i4];
          int i5 = i4 / 3;
          j = 0;
          paramInt2 = 0;
          while (paramInt2 < i5 * 3)
          {
            int[] arrayOfInt = IA;
            int i2 = paramInt1 + 1;
            paramInt1 = arrayOfInt[paramString.charAt(paramInt1)];
            arrayOfInt = IA;
            i1 = i2 + 1;
            int i3 = arrayOfInt[paramString.charAt(i2)];
            arrayOfInt = IA;
            i2 = i1 + 1;
            int i6 = arrayOfInt[paramString.charAt(i1)];
            arrayOfInt = IA;
            i1 = i2 + 1;
            paramInt1 = i6 << 6 | paramInt1 << 18 | i3 << 12 | arrayOfInt[paramString.charAt(i2)];
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16));
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = ((byte)(paramInt1 >> 8));
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)paramInt1);
            paramInt1 = i1;
            paramInt2 = i2;
            if (m > 0)
            {
              i3 = j + 1;
              j = i3;
              paramInt1 = i1;
              paramInt2 = i2;
              if (i3 == 19)
              {
                paramInt1 = i1 + 2;
                j = 0;
                paramInt2 = i2;
              }
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          paramInt2 = 0;
          break label125;
        }
        if (paramInt2 < i4)
        {
          m = paramInt1;
          j = 0;
          paramInt1 = n;
          for (;;)
          {
            n = paramInt1;
            if (m > k - i) {
              break;
            }
            i1 = IA[paramString.charAt(m)];
            paramInt1 = n + 1;
            j = i1 << 18 - n * 6 | j;
            m++;
          }
          i = 16;
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt1 < i4)
          {
            arrayOfByte[paramInt1] = ((byte)(j >> paramInt2));
            paramInt2 -= 8;
            paramInt1++;
          }
        }
        paramString = arrayOfByte;
        break;
      }
    }
  }
  
  public static final byte[] decodeFast(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int n = 0;
    if (paramInt2 == 0)
    {
      paramArrayOfChar = new byte[0];
      return paramArrayOfChar;
    }
    int k = paramInt1 + paramInt2 - 1;
    while ((paramInt1 < k) && (IA[paramArrayOfChar[paramInt1]] < 0)) {
      paramInt1++;
    }
    for (;;)
    {
      if ((k > 0) && (IA[paramArrayOfChar[k]] < 0))
      {
        k--;
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfChar[k] == '=') {
          if (paramArrayOfChar[(k - 1)] == '=')
          {
            i = 2;
            j = k - paramInt1 + 1;
            if (paramInt2 <= 76) {
              break label355;
            }
            if (paramArrayOfChar[76] != '\r') {
              break label350;
            }
            paramInt2 = j / 78;
          }
        }
        label115:
        int i4;
        byte[] arrayOfByte;
        int i1;
        label350:
        label355:
        for (int m = paramInt2 << 1;; m = 0)
        {
          i4 = ((j - m) * 6 >> 3) - i;
          arrayOfByte = new byte[i4];
          int i5 = i4 / 3;
          j = 0;
          paramInt2 = 0;
          while (paramInt2 < i5 * 3)
          {
            int[] arrayOfInt = IA;
            int i2 = paramInt1 + 1;
            paramInt1 = arrayOfInt[paramArrayOfChar[paramInt1]];
            arrayOfInt = IA;
            i1 = i2 + 1;
            i2 = arrayOfInt[paramArrayOfChar[i2]];
            arrayOfInt = IA;
            int i3 = i1 + 1;
            int i6 = arrayOfInt[paramArrayOfChar[i1]];
            arrayOfInt = IA;
            i1 = i3 + 1;
            paramInt1 = i6 << 6 | paramInt1 << 18 | i2 << 12 | arrayOfInt[paramArrayOfChar[i3]];
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16));
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = ((byte)(paramInt1 >> 8));
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)paramInt1);
            paramInt1 = i1;
            paramInt2 = i2;
            if (m > 0)
            {
              i3 = j + 1;
              j = i3;
              paramInt1 = i1;
              paramInt2 = i2;
              if (i3 == 19)
              {
                paramInt1 = i1 + 2;
                j = 0;
                paramInt2 = i2;
              }
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          paramInt2 = 0;
          break label115;
        }
        if (paramInt2 < i4)
        {
          m = paramInt1;
          j = 0;
          paramInt1 = n;
          for (;;)
          {
            n = paramInt1;
            if (m > k - i) {
              break;
            }
            i1 = IA[paramArrayOfChar[m]];
            paramInt1 = n + 1;
            j = i1 << 18 - n * 6 | j;
            m++;
          }
          i = 16;
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt1 < i4)
          {
            arrayOfByte[paramInt1] = ((byte)(j >> paramInt2));
            paramInt2 -= 8;
            paramInt1++;
          }
        }
        paramArrayOfChar = arrayOfByte;
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */