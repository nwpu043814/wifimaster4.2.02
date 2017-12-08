package c.a.a.a;

public final class e
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(m + "b");
    if (paramString != null) {
      localStringBuffer.append(" (" + paramString + ")");
    }
    localStringBuffer.append(':');
    int n = localStringBuffer.toString().length() + 8 & 0xFFFFFFF8;
    localStringBuffer.append('\t');
    int k = (80 - n) / 3;
    for (int i = 0; i < m; i++)
    {
      if ((i != 0) && (i % k == 0))
      {
        localStringBuffer.append('\n');
        for (j = 0; j < n / 8; j++) {
          localStringBuffer.append('\t');
        }
      }
      int j = paramArrayOfByte[(i + 0)] & 0xFF;
      localStringBuffer.append(a[(j >> 4)]);
      localStringBuffer.append(a[(j & 0xF)]);
      localStringBuffer.append(' ');
    }
    localStringBuffer.append('\n');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */