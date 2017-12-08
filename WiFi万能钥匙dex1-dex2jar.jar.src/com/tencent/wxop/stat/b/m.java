package com.tencent.wxop.stat.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class m
{
  static int D()
  {
    j = 0;
    String str = "";
    try
    {
      Object localObject = new java/lang/ProcessBuilder;
      ((ProcessBuilder)localObject).<init>(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" });
      InputStream localInputStream = ((ProcessBuilder)localObject).start().getInputStream();
      localObject = new byte[24];
      while (localInputStream.read((byte[])localObject) != -1)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder = localStringBuilder.append(str);
        str = new java/lang/String;
        str.<init>((byte[])localObject);
        str = str;
      }
      localInputStream.close();
      str = str.trim();
      i = j;
      if (str.length() > 0) {
        i = Integer.valueOf(str).intValue();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l.K().b(localThrowable);
        int i = j;
      }
    }
    return i * 1000;
  }
  
  static int aA()
  {
    j = 0;
    Object localObject1 = "";
    try
    {
      Object localObject2 = new java/lang/ProcessBuilder;
      ((ProcessBuilder)localObject2).<init>(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" });
      localObject2 = ((ProcessBuilder)localObject2).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (((InputStream)localObject2).read(arrayOfByte) != -1)
      {
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject1 = ((StringBuilder)localObject3).append((String)localObject1);
        localObject3 = new java/lang/String;
        ((String)localObject3).<init>(arrayOfByte);
        localObject1 = (String)localObject3;
      }
      ((InputStream)localObject2).close();
      localObject1 = ((String)localObject1).trim();
      i = j;
      if (((String)localObject1).length() > 0) {
        i = Integer.valueOf((String)localObject1).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l.K().b(localException);
        int i = j;
      }
    }
    return i * 1000;
  }
  
  static String ax()
  {
    int i = 2;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "";
    arrayOfString1[1] = "";
    try
    {
      Object localObject = new java/io/FileReader;
      ((FileReader)localObject).<init>("/proc/cpuinfo");
      BufferedReader localBufferedReader = new java/io/BufferedReader;
      localBufferedReader.<init>((Reader)localObject, 8192);
      String[] arrayOfString2 = localBufferedReader.readLine().split("\\s+");
      while (i < arrayOfString2.length)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        arrayOfString1[0] = (arrayOfString1[0] + arrayOfString2[i] + " ");
        i++;
      }
      localBufferedReader.close();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return arrayOfString1[0];
  }
  
  static int r()
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>("/sys/devices/system/cpu/");
      n localn = new com/tencent/wxop/stat/b/n;
      localn.<init>();
      i = localFile.listFiles(localn).length;
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */