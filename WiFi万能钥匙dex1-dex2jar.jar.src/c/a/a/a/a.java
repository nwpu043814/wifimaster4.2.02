package c.a.a.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class a
{
  private MessageDigest a;
  private int b;
  private byte[] c;
  private byte[] d;
  
  public a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      this.a = MessageDigest.getInstance(paramString);
      this.b = paramInt;
      b(paramArrayOfByte);
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new IllegalArgumentException("unknown digest algorithm " + paramString);
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > this.b)
    {
      arrayOfByte = this.a.digest(paramArrayOfByte);
      this.a.reset();
    }
    this.c = new byte[this.b];
    this.d = new byte[this.b];
    int j;
    for (int i = 0;; i++)
    {
      j = i;
      if (i >= arrayOfByte.length) {
        break;
      }
      this.c[i] = ((byte)(arrayOfByte[i] ^ 0x36));
      this.d[i] = ((byte)(arrayOfByte[i] ^ 0x5C));
    }
    while (j < this.b)
    {
      this.c[j] = 54;
      this.d[j] = 92;
      j++;
    }
    this.a.update(this.c);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a.update(paramArrayOfByte);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && (paramArrayOfByte.length < localObject.length))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(localObject, 0, arrayOfByte, 0, arrayOfByte.length);
      localObject = arrayOfByte;
    }
    for (;;)
    {
      return Arrays.equals(paramArrayOfByte, (byte[])localObject);
    }
  }
  
  public final byte[] a()
  {
    byte[] arrayOfByte = this.a.digest();
    this.a.reset();
    this.a.update(this.d);
    return this.a.digest(arrayOfByte);
  }
  
  public final void b()
  {
    this.a.reset();
    this.a.update(this.c);
  }
  
  public final int c()
  {
    return this.a.getDigestLength();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */