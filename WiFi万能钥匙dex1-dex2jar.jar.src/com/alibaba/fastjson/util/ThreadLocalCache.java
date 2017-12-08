package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

public class ThreadLocalCache
{
  public static final int BYTES_CACH_INIT_SIZE = 1024;
  public static final int BYTeS_CACH_MAX_SIZE = 131072;
  public static final int CHARS_CACH_INIT_SIZE = 1024;
  public static final int CHARS_CACH_MAX_SIZE = 131072;
  private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal();
  private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal();
  private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal();
  
  private static char[] allocate(int paramInt)
  {
    int i = getAllocateLength(1024, 131072, paramInt);
    char[] arrayOfChar;
    if (i <= 131072)
    {
      arrayOfChar = new char[i];
      charsBufLocal.set(new SoftReference(arrayOfChar));
    }
    for (;;)
    {
      return arrayOfChar;
      arrayOfChar = new char[paramInt];
    }
  }
  
  private static byte[] allocateBytes(int paramInt)
  {
    int i = getAllocateLength(1024, 131072, paramInt);
    byte[] arrayOfByte;
    if (i <= 131072)
    {
      arrayOfByte = new byte[i];
      bytesBufLocal.set(new SoftReference(arrayOfByte));
    }
    for (;;)
    {
      return arrayOfByte;
      arrayOfByte = new byte[paramInt];
    }
  }
  
  public static void clearBytes()
  {
    bytesBufLocal.set(null);
  }
  
  public static void clearChars()
  {
    charsBufLocal.set(null);
  }
  
  private static int getAllocateLength(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= paramInt3) {}
    for (;;)
    {
      return paramInt1;
      int i = paramInt1 * 2;
      paramInt1 = i;
      if (i <= paramInt2) {
        break;
      }
      paramInt1 = paramInt3;
    }
  }
  
  public static byte[] getBytes(int paramInt)
  {
    Object localObject = (SoftReference)bytesBufLocal.get();
    if (localObject == null) {
      localObject = allocateBytes(paramInt);
    }
    for (;;)
    {
      return (byte[])localObject;
      byte[] arrayOfByte = (byte[])((SoftReference)localObject).get();
      if (arrayOfByte == null)
      {
        localObject = allocateBytes(paramInt);
      }
      else
      {
        localObject = arrayOfByte;
        if (arrayOfByte.length < paramInt) {
          localObject = allocateBytes(paramInt);
        }
      }
    }
  }
  
  public static char[] getChars(int paramInt)
  {
    Object localObject = (SoftReference)charsBufLocal.get();
    if (localObject == null) {
      localObject = allocate(paramInt);
    }
    for (;;)
    {
      return (char[])localObject;
      char[] arrayOfChar = (char[])((SoftReference)localObject).get();
      if (arrayOfChar == null)
      {
        localObject = allocate(paramInt);
      }
      else
      {
        localObject = arrayOfChar;
        if (arrayOfChar.length < paramInt) {
          localObject = allocate(paramInt);
        }
      }
    }
  }
  
  public static CharsetDecoder getUTF8Decoder()
  {
    CharsetDecoder localCharsetDecoder = (CharsetDecoder)decoderLocal.get();
    Object localObject = localCharsetDecoder;
    if (localCharsetDecoder == null)
    {
      localObject = new UTF8Decoder();
      decoderLocal.set(localObject);
    }
    return (CharsetDecoder)localObject;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/ThreadLocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */