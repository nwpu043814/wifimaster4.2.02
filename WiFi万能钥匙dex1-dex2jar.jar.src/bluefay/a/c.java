package bluefay.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicReference;

public final class c
{
  private static AtomicReference<byte[]> a = new AtomicReference();
  
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[' '];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      i += j;
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    return i;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */