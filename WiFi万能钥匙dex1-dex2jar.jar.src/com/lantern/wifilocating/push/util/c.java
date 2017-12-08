package com.lantern.wifilocating.push.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */