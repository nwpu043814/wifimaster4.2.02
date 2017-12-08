package c.a.a.a;

import java.io.ByteArrayOutputStream;

public final class d
{
  public static String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int i = 0; i < (paramArrayOfByte.length + 2) / 3; i++)
    {
      short[] arrayOfShort2 = new short[3];
      short[] arrayOfShort1 = new short[4];
      int j = 0;
      if (j < 3)
      {
        if (i * 3 + j < paramArrayOfByte.length) {
          arrayOfShort2[j] = ((short)(paramArrayOfByte[(i * 3 + j)] & 0xFF));
        }
        for (;;)
        {
          j++;
          break;
          arrayOfShort2[j] = -1;
        }
      }
      arrayOfShort1[0] = ((short)(arrayOfShort2[0] >> 2));
      if (arrayOfShort2[1] == -1)
      {
        arrayOfShort1[1] = ((short)((arrayOfShort2[0] & 0x3) << 4));
        if (arrayOfShort2[1] != -1) {
          break label178;
        }
        arrayOfShort1[3] = 64;
        arrayOfShort1[2] = 64;
      }
      for (;;)
      {
        for (j = 0; j < 4; j++) {
          localByteArrayOutputStream.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(arrayOfShort1[j]));
        }
        arrayOfShort1[1] = ((short)(((arrayOfShort2[0] & 0x3) << 4) + (arrayOfShort2[1] >> 4)));
        break;
        label178:
        if (arrayOfShort2[2] == -1)
        {
          arrayOfShort1[2] = ((short)((arrayOfShort2[1] & 0xF) << 2));
          arrayOfShort1[3] = 64;
        }
        else
        {
          arrayOfShort1[2] = ((short)(((arrayOfShort2[1] & 0xF) << 2) + (arrayOfShort2[2] >> 6)));
          arrayOfShort1[3] = ((short)(arrayOfShort2[2] & 0x3F));
        }
      }
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    String str = a(paramArrayOfByte);
    paramArrayOfByte = new StringBuffer();
    int i = 0;
    if (i < str.length())
    {
      paramArrayOfByte.append(paramString);
      if (i + 64 >= str.length())
      {
        paramArrayOfByte.append(str.substring(i));
        if (paramBoolean) {
          paramArrayOfByte.append(" )");
        }
      }
      for (;;)
      {
        i += 64;
        break;
        paramArrayOfByte.append(str.substring(i, i + 64));
        paramArrayOfByte.append("\n");
      }
    }
    return paramArrayOfByte.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */