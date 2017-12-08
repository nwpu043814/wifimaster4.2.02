package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder
  extends CharsetDecoder
{
  private static final Charset charset = Charset.forName("UTF-8");
  
  public UTF8Decoder()
  {
    super(charset, 1.0F, 1.0F);
  }
  
  private CoderResult decodeArrayLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset();
    int k = paramByteBuffer.position() + i;
    i = paramByteBuffer.arrayOffset();
    int i1 = paramByteBuffer.limit() + i;
    char[] arrayOfChar = paramCharBuffer.array();
    int n = paramCharBuffer.arrayOffset() + paramCharBuffer.position();
    int i2 = paramCharBuffer.arrayOffset() + paramCharBuffer.limit();
    int i3 = Math.min(i1 - k, i2 - n);
    i = n;
    int m;
    int j;
    for (;;)
    {
      m = i;
      i = k;
      j = m;
      if (m >= n + i3) {
        break;
      }
      i = k;
      j = m;
      if (arrayOfByte[k] < 0) {
        break;
      }
      arrayOfChar[m] = ((char)arrayOfByte[k]);
      i = m + 1;
      k++;
    }
    do
    {
      arrayOfChar[j] = ((char)k);
      i++;
      j++;
      if (i >= i1) {
        break label580;
      }
      k = arrayOfByte[i];
      if (k < 0) {
        break;
      }
    } while (j < i2);
    paramByteBuffer = xflow(paramByteBuffer, i, i1, paramCharBuffer, j, 1);
    for (;;)
    {
      return paramByteBuffer;
      if (k >> 5 == -2)
      {
        if ((i1 - i < 2) || (j >= i2))
        {
          paramByteBuffer = xflow(paramByteBuffer, i, i1, paramCharBuffer, j, 2);
          continue;
        }
        m = arrayOfByte[(i + 1)];
        if (isMalformed2(k, m))
        {
          paramByteBuffer = malformed(paramByteBuffer, i, paramCharBuffer, j, 2);
          continue;
        }
        arrayOfChar[j] = ((char)(k << 6 ^ m ^ 0xF80));
        i += 2;
        j++;
        break;
      }
      if (k >> 4 == -2)
      {
        if ((i1 - i < 3) || (j >= i2))
        {
          paramByteBuffer = xflow(paramByteBuffer, i, i1, paramCharBuffer, j, 3);
          continue;
        }
        m = arrayOfByte[(i + 1)];
        n = arrayOfByte[(i + 2)];
        if (isMalformed3(k, m, n))
        {
          paramByteBuffer = malformed(paramByteBuffer, i, paramCharBuffer, j, 3);
          continue;
        }
        arrayOfChar[j] = ((char)(k << 12 ^ m << 6 ^ n ^ 0x1F80));
        i += 3;
        j++;
        break;
      }
      if (k >> 3 == -2)
      {
        if ((i1 - i < 4) || (i2 - j < 2))
        {
          paramByteBuffer = xflow(paramByteBuffer, i, i1, paramCharBuffer, j, 4);
          continue;
        }
        m = arrayOfByte[(i + 1)];
        n = arrayOfByte[(i + 2)];
        i3 = arrayOfByte[(i + 3)];
        k = (k & 0x7) << 18 | (m & 0x3F) << 12 | (n & 0x3F) << 6 | i3 & 0x3F;
        if ((isMalformed4(m, n, i3)) || (!Surrogate.neededFor(k)))
        {
          paramByteBuffer = malformed(paramByteBuffer, i, paramCharBuffer, j, 4);
          continue;
        }
        m = j + 1;
        arrayOfChar[j] = Surrogate.high(k);
        j = m + 1;
        arrayOfChar[m] = Surrogate.low(k);
        i += 4;
        break;
      }
      paramByteBuffer = malformed(paramByteBuffer, i, paramCharBuffer, j, 1);
      continue;
      label580:
      paramByteBuffer = xflow(paramByteBuffer, i, i1, paramCharBuffer, j, 0);
    }
  }
  
  private static final boolean isMalformed2(int paramInt1, int paramInt2)
  {
    if (((paramInt1 & 0x1E) == 0) || ((paramInt2 & 0xC0) != 128)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isMalformed3(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt1 == -32) && ((paramInt2 & 0xE0) == 128)) || ((paramInt2 & 0xC0) != 128) || ((paramInt3 & 0xC0) != 128)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static final boolean isMalformed4(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt1 & 0xC0) != 128) || ((paramInt2 & 0xC0) != 128) || ((paramInt3 & 0xC0) != 128)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isNotContinuation(int paramInt)
  {
    if ((paramInt & 0xC0) != 128) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static CoderResult lookupN(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = 1;
    if (i < paramInt) {
      if (!isNotContinuation(paramByteBuffer.get())) {}
    }
    for (paramByteBuffer = CoderResult.malformedForLength(i);; paramByteBuffer = CoderResult.malformedForLength(paramInt))
    {
      return paramByteBuffer;
      i++;
      break;
    }
  }
  
  private static CoderResult malformed(ByteBuffer paramByteBuffer, int paramInt1, CharBuffer paramCharBuffer, int paramInt2, int paramInt3)
  {
    paramByteBuffer.position(paramInt1 - paramByteBuffer.arrayOffset());
    CoderResult localCoderResult = malformedN(paramByteBuffer, paramInt3);
    updatePositions(paramByteBuffer, paramInt1, paramCharBuffer, paramInt2);
    return localCoderResult;
  }
  
  public static CoderResult malformedN(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = 2;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      paramInt = paramByteBuffer.get();
      if (paramInt >> 2 == -2) {
        if (paramByteBuffer.remaining() < 4) {
          paramByteBuffer = CoderResult.UNDERFLOW;
        }
      }
      break;
    }
    for (;;)
    {
      return paramByteBuffer;
      paramByteBuffer = lookupN(paramByteBuffer, 5);
      continue;
      if (paramInt >> 1 == -2)
      {
        if (paramByteBuffer.remaining() < 5) {
          paramByteBuffer = CoderResult.UNDERFLOW;
        } else {
          paramByteBuffer = lookupN(paramByteBuffer, 6);
        }
      }
      else
      {
        paramByteBuffer = CoderResult.malformedForLength(1);
        continue;
        paramByteBuffer = CoderResult.malformedForLength(1);
        continue;
        paramInt = paramByteBuffer.get();
        int j = paramByteBuffer.get();
        if ((paramInt != -32) || ((j & 0xE0) != 128))
        {
          paramInt = i;
          if (!isNotContinuation(j)) {}
        }
        else
        {
          paramInt = 1;
        }
        paramByteBuffer = CoderResult.malformedForLength(paramInt);
        continue;
        paramInt = paramByteBuffer.get() & 0xFF;
        i = paramByteBuffer.get() & 0xFF;
        if ((paramInt > 244) || ((paramInt == 240) && ((i < 144) || (i > 191))) || ((paramInt == 244) && ((i & 0xF0) != 128)) || (isNotContinuation(i))) {
          paramByteBuffer = CoderResult.malformedForLength(1);
        } else if (isNotContinuation(paramByteBuffer.get())) {
          paramByteBuffer = CoderResult.malformedForLength(2);
        } else {
          paramByteBuffer = CoderResult.malformedForLength(3);
        }
      }
    }
  }
  
  static final void updatePositions(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2)
  {
    paramBuffer1.position(paramInt1);
    paramBuffer2.position(paramInt2);
  }
  
  private static CoderResult xflow(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4)
  {
    updatePositions(paramBuffer1, paramInt1, paramBuffer2, paramInt3);
    if ((paramInt4 == 0) || (paramInt2 - paramInt1 < paramInt4)) {}
    for (paramBuffer1 = CoderResult.UNDERFLOW;; paramBuffer1 = CoderResult.OVERFLOW) {
      return paramBuffer1;
    }
  }
  
  protected CoderResult decodeLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    return decodeArrayLoop(paramByteBuffer, paramCharBuffer);
  }
  
  private static class Surrogate
  {
    public static final int UCS4_MAX = 1114111;
    public static final int UCS4_MIN = 65536;
    
    static
    {
      if (!UTF8Decoder.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public static char high(int paramInt)
    {
      assert (neededFor(paramInt));
      return (char)(0xD800 | paramInt - 65536 >> 10 & 0x3FF);
    }
    
    public static char low(int paramInt)
    {
      assert (neededFor(paramInt));
      return (char)(0xDC00 | paramInt - 65536 & 0x3FF);
    }
    
    public static boolean neededFor(int paramInt)
    {
      if ((paramInt >= 65536) && (paramInt <= 1114111)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/UTF8Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */