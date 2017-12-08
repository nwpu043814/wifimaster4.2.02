package com.lantern.popup;

import java.io.IOException;
import java.io.InputStream;

public final class b
  extends InputStream
{
  private InputStream a;
  private int[] b;
  private int c = 0;
  private boolean d = false;
  
  public b(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public final void close()
  {
    this.a.close();
  }
  
  public final int read()
  {
    int n = 1;
    int j;
    if ((this.b == null) || (this.c == this.b.length)) {
      if (this.d) {
        j = -1;
      }
    }
    for (;;)
    {
      return j;
      Object localObject = new char[4];
      j = 0;
      label40:
      int k = this.a.read();
      if (k == -1)
      {
        if (j != 0) {
          throw new IOException("Bad base64 stream");
        }
        this.b = new int[0];
        this.d = true;
      }
      for (;;)
      {
        if (this.b.length != 0) {
          break label355;
        }
        this.b = null;
        j = -1;
        break;
        int i = (char)k;
        if (("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(i) != -1) || (i == 61))
        {
          localObject[j] = i;
          k = j + 1;
          j = k;
          if (k < 4) {
            break label40;
          }
          m = 0;
          j = 0;
        }
        for (;;)
        {
          if (j >= 4) {
            break label214;
          }
          if (localObject[j] != '=')
          {
            k = m;
            if (m == 0) {
              break label205;
            }
            throw new IOException("Bad base64 stream");
            k = j;
            if (i == 13) {
              break;
            }
            k = j;
            if (i == 10) {
              break;
            }
            throw new IOException("Bad base64 stream");
          }
          k = m;
          if (m == 0) {
            k = 1;
          }
          label205:
          j++;
          m = k;
        }
        label214:
        if (localObject[3] == '=')
        {
          this.a.read();
          this.d = true;
          if (localObject[2] == '=') {
            j = n;
          }
        }
        for (;;)
        {
          k = 0;
          m = 0;
          while (m < 4)
          {
            n = k;
            if (localObject[m] != '=') {
              n = k | "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(localObject[m]) << (3 - m) * 6;
            }
            m++;
            k = n;
          }
          j = 2;
          continue;
          j = 3;
        }
        this.b = new int[j];
        for (int m = 0; m < j; m++) {
          this.b[m] = (k >>> (2 - m) * 8 & 0xFF);
        }
      }
      label355:
      this.c = 0;
      localObject = this.b;
      j = this.c;
      this.c = (j + 1);
      j = localObject[j];
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/popup/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */