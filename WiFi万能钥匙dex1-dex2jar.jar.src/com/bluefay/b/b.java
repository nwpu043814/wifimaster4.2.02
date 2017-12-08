package com.bluefay.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class b
{
  public static String a(File paramFile, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "UTF-8";
    }
    try
    {
      paramString = new java/io/FileInputStream;
      paramString.<init>(paramFile);
      paramString = a(paramString);
      paramFile = new java/lang/String;
      paramFile.<init>(paramString, str);
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = "";
      }
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFile1 == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        FileInputStream localFileInputStream = new java/io/FileInputStream;
        localFileInputStream.<init>(paramFile1);
        paramFile1 = new java/io/FileOutputStream;
        paramFile1.<init>(paramFile2);
        bool1 = a(localFileInputStream, paramFile1);
      }
      catch (FileNotFoundException paramFile1)
      {
        paramFile1.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject3 = paramInputStream;
      OutputStream localOutputStream2 = paramOutputStream;
      Object localObject2 = paramInputStream;
      OutputStream localOutputStream1 = paramOutputStream;
      try
      {
        byte[] arrayOfByte = new byte[' '];
        if (paramInputStream == null)
        {
          localObject1 = null;
          localObject3 = localObject1;
          localOutputStream2 = paramOutputStream;
          localObject2 = localObject1;
          localOutputStream1 = paramOutputStream;
          if (!(paramOutputStream instanceof BufferedOutputStream)) {
            break label227;
          }
          for (;;)
          {
            localObject3 = localObject1;
            localOutputStream2 = paramOutputStream;
            localObject2 = localObject1;
            localOutputStream1 = paramOutputStream;
            int i = ((InputStream)localObject1).read(arrayOfByte, 0, 8192);
            if (i == -1) {
              break;
            }
            localObject3 = localObject1;
            localOutputStream2 = paramOutputStream;
            localObject2 = localObject1;
            localOutputStream1 = paramOutputStream;
            paramOutputStream.write(arrayOfByte, 0, i);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        Object localObject1;
        for (;;)
        {
          localObject2 = localObject3;
          localOutputStream1 = localOutputStream2;
          paramOutputStream = new java/lang/StringBuilder;
          localObject2 = localObject3;
          localOutputStream1 = localOutputStream2;
          paramOutputStream.<init>("Exception while copying: ");
          localObject2 = localObject3;
          localOutputStream1 = localOutputStream2;
          h.c(paramInputStream);
          try
          {
            localOutputStream2.close();
            if (localObject3 == null) {}
          }
          catch (IOException paramInputStream)
          {
            bool = false;
            h.c("Exception while closing the stream: " + paramInputStream);
          }
          try
          {
            ((InputStream)localObject3).close();
            bool = true;
          }
          catch (IOException paramInputStream)
          {
            bool = true;
            break label321;
          }
          localObject1 = paramInputStream;
          localObject3 = paramInputStream;
          localOutputStream2 = paramOutputStream;
          localObject2 = paramInputStream;
          localOutputStream1 = paramOutputStream;
          if (!(paramInputStream instanceof BufferedInputStream))
          {
            localObject3 = paramInputStream;
            localOutputStream2 = paramOutputStream;
            localObject2 = paramInputStream;
            localOutputStream1 = paramOutputStream;
            localObject1 = new BufferedInputStream(paramInputStream, 8192);
            continue;
            label227:
            localObject3 = localObject1;
            localOutputStream2 = paramOutputStream;
            localObject2 = localObject1;
            localOutputStream1 = paramOutputStream;
            paramOutputStream = new BufferedOutputStream(paramOutputStream, 8192);
          }
        }
        localObject3 = localObject1;
        localOutputStream2 = paramOutputStream;
        localObject2 = localObject1;
        localOutputStream1 = paramOutputStream;
        paramOutputStream.flush();
        try
        {
          paramOutputStream.close();
          if (localObject1 == null) {}
        }
        catch (IOException paramInputStream)
        {
          try
          {
            ((InputStream)localObject1).close();
            bool = true;
          }
          catch (IOException paramInputStream)
          {
            for (;;)
            {
              bool = true;
            }
          }
          paramInputStream = paramInputStream;
          bool = false;
        }
        h.c("Exception while closing the stream: " + paramInputStream);
        continue;
      }
      finally
      {
        try
        {
          label321:
          localOutputStream1.close();
          if (localObject2 != null) {
            ((InputStream)localObject2).close();
          }
        }
        catch (IOException paramOutputStream)
        {
          for (;;)
          {
            h.c("Exception while closing the stream: " + paramOutputStream);
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label32;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      i = 0;
      break;
      label32:
      String str = paramString3;
      if (paramString3.length() == 0) {
        str = "UTF-8";
      }
      try
      {
        bool1 = a(paramString1, paramString2.getBytes(str));
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      h.c("data is empty:" + paramArrayOfByte);
    }
    for (;;)
    {
      return bool;
      String str = paramString;
      try
      {
        if (paramString.startsWith("file://")) {
          str = paramString.substring(7);
        }
        paramString = new java/io/FileOutputStream;
        paramString.<init>(str);
        paramString.write(paramArrayOfByte);
        paramString.close();
        bool = true;
      }
      catch (FileNotFoundException paramString)
      {
        h.c("FileNotFoundException:" + paramString.getMessage());
      }
      catch (IOException paramString)
      {
        h.c("IOException:" + paramString.getMessage());
      }
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[' '];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramInputStream.close();
    localByteArrayOutputStream.close();
    return arrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = new java/io/FileInputStream;
      localFileInputStream.<init>(paramString);
      paramString = a(localFileInputStream);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        h.c("FileNotFoundException:" + paramString.getMessage());
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        h.c("IOException:" + paramString.getMessage());
      }
    }
  }
  
  public static String b(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.lastIndexOf(".");
      if (i < 0) {}
    }
    for (paramString = paramString.substring(i + 1);; paramString = "") {
      return paramString;
    }
  }
  
  public static String c(String paramString)
  {
    String str = File.separator;
    int i;
    if (paramString != null)
    {
      if (paramString.startsWith("http://")) {
        str = "/";
      }
      i = paramString.lastIndexOf(str);
      if (i < 0) {}
    }
    for (paramString = paramString.substring(i + 1);; paramString = "") {
      return paramString;
    }
  }
  
  public static String d(String paramString)
  {
    String str = File.separator;
    int i;
    if (paramString != null)
    {
      if (paramString.startsWith("http://")) {
        str = "/";
      }
      i = paramString.lastIndexOf(str);
      if (i >= 0)
      {
        int j = paramString.lastIndexOf(".");
        if ((j > 0) && (j > i)) {
          paramString = paramString.substring(i + 1, j);
        }
      }
    }
    for (;;)
    {
      return paramString;
      paramString = paramString.substring(i + 1);
      continue;
      paramString = "";
    }
  }
  
  public static boolean e(String paramString)
  {
    return new File(paramString).exists();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */