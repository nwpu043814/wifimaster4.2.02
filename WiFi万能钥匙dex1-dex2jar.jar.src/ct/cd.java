package ct;

import android.content.Context;
import android.util.Pair;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class cd
  implements cq
{
  private static final List<String> a = Arrays.asList(new String[] { "lbs.map.qq.com", "lbssp.map.qq.com" });
  private z b;
  
  public cd(Context paramContext, String paramString)
  {
    try
    {
      b.a.a(paramContext, "0M3006CS7U0ZC2K3", paramString, "test_uuid", a);
      this.b = b.a.a();
      return;
    }
    catch (m paramContext)
    {
      for (;;)
      {
        b.a.a("TxNewHttpClient", "<init>", paramContext);
      }
    }
  }
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
    }
    for (int i = 0;; i++)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
    }
  }
  
  public final Pair<byte[], String> a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.b == null) {
      throw new IOException("can not init net sdk");
    }
    try
    {
      localObject = this.b;
      paramString = ((z)localObject).a(paramString, paramArrayOfByte);
      paramString.a();
      paramString.a(20000);
      paramString.b(30000);
      paramString.b();
      paramString = ((z)localObject).a(paramString);
      if (paramString == null)
      {
        paramString = new java/io/IOException;
        paramString.<init>("null response");
        throw paramString;
      }
    }
    catch (ag paramString)
    {
      Object localObject;
      throw new IOException(paramString.getMessage());
      switch (paramString.a())
      {
      case -1: 
      default: 
        localObject = new java/io/IOException;
        paramArrayOfByte = new java/lang/StringBuilder;
        paramArrayOfByte.<init>("net sdk error: ");
        ((IOException)localObject).<init>(paramString.a());
        throw ((Throwable)localObject);
      }
    }
    catch (Exception paramString)
    {
      throw new IOException(paramString.getMessage());
    }
    paramArrayOfByte = a(paramString.a("content-type"));
    for (paramString = Pair.create(paramString.b(), paramArrayOfByte);; paramString = Pair.create("{}".getBytes(), "utf-8")) {
      return paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */