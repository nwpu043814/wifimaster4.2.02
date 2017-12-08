package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class IOUtils
{
  static final char[] DigitOnes = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  static final char[] DigitTens;
  static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  static final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
  
  static
  {
    DigitTens = new char[] { 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57 };
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      for (;;) {}
    }
  }
  
  public static void decode(CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    try
    {
      paramByteBuffer = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, true);
      if (!paramByteBuffer.isUnderflow()) {
        paramByteBuffer.throwException();
      }
      paramCharsetDecoder = paramCharsetDecoder.flush(paramCharBuffer);
      if (!paramCharsetDecoder.isUnderflow()) {
        paramCharsetDecoder.throwException();
      }
      return;
    }
    catch (CharacterCodingException paramCharsetDecoder)
    {
      throw new JSONException(paramCharsetDecoder.getMessage(), paramCharsetDecoder);
    }
  }
  
  public static void getChars(byte paramByte, int paramInt, char[] paramArrayOfChar)
  {
    int i = 0;
    int j = paramByte;
    int k = paramInt;
    if (paramByte < 0)
    {
      i = 45;
      j = -paramByte;
      k = paramInt;
    }
    for (;;)
    {
      paramByte = 52429 * j >>> 19;
      k--;
      paramArrayOfChar[k] = digits[(j - ((paramByte << 3) + (paramByte << 1)))];
      if (paramByte == 0)
      {
        if (i != 0) {
          paramArrayOfChar[(k - 1)] = i;
        }
        return;
      }
      j = paramByte;
    }
  }
  
  public static void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    int j;
    int i;
    if (paramInt1 < 0)
    {
      j = -paramInt1;
      i = 45;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      int k = paramInt1;
      j = paramInt2;
      if (paramInt2 >= 65536)
      {
        j = paramInt2 / 100;
        paramInt2 -= (j << 6) + (j << 5) + (j << 2);
        paramInt1--;
        paramArrayOfChar[paramInt1] = DigitOnes[paramInt2];
        paramInt1--;
        paramArrayOfChar[paramInt1] = DigitTens[paramInt2];
        paramInt2 = j;
      }
      else
      {
        do
        {
          j = paramInt1;
          paramInt1 = 52429 * j >>> 19;
          k--;
          paramArrayOfChar[k] = digits[(j - ((paramInt1 << 3) + (paramInt1 << 1)))];
        } while (paramInt1 != 0);
        if (i != 0) {
          paramArrayOfChar[(k - 1)] = i;
        }
        return;
        i = 0;
        j = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = j;
      }
    }
  }
  
  public static void getChars(long paramLong, int paramInt, char[] paramArrayOfChar)
  {
    int i;
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      i = 45;
    }
    for (;;)
    {
      int j;
      if (paramLong > 2147483647L)
      {
        long l = paramLong / 100L;
        j = (int)(paramLong - ((l << 6) + (l << 5) + (l << 2)));
        paramInt--;
        paramArrayOfChar[paramInt] = DigitOnes[j];
        paramInt--;
        paramArrayOfChar[paramInt] = DigitTens[j];
        paramLong = l;
      }
      else
      {
        int m;
        int k;
        for (j = (int)paramLong;; j = k)
        {
          m = paramInt;
          k = j;
          if (j < 65536) {
            break;
          }
          k = j / 100;
          j -= (k << 6) + (k << 5) + (k << 2);
          paramInt--;
          paramArrayOfChar[paramInt] = DigitOnes[j];
          paramInt--;
          paramArrayOfChar[paramInt] = DigitTens[j];
        }
        do
        {
          k = paramInt;
          paramInt = 52429 * k >>> 19;
          m--;
          paramArrayOfChar[m] = digits[(k - ((paramInt << 3) + (paramInt << 1)))];
        } while (paramInt != 0);
        if (i != 0) {
          paramArrayOfChar[(m - 1)] = i;
        }
        return;
        i = 0;
      }
    }
  }
  
  public static int stringSize(int paramInt)
  {
    for (int i = 0;; i++) {
      if (paramInt <= sizeTable[i]) {
        return i + 1;
      }
    }
  }
  
  public static int stringSize(long paramLong)
  {
    int i = 1;
    long l = 10L;
    if (i < 19) {
      if (paramLong >= l) {}
    }
    for (;;)
    {
      return i;
      l *= 10L;
      i++;
      break;
      i = 19;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */