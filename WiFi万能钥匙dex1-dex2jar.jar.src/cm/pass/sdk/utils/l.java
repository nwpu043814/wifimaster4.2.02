package cm.pass.sdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import java.security.MessageDigest;

public class l
{
  private static l a;
  private static Context c;
  private PackageManager b;
  
  private l(Context paramContext)
  {
    c = paramContext.getApplicationContext();
  }
  
  public static l a(Context paramContext)
  {
    if (a == null)
    {
      paramContext = new l(paramContext);
      a = paramContext;
      paramContext.a();
    }
    return a;
  }
  
  public PackageManager a()
  {
    if (this.b == null) {
      this.b = c.getPackageManager();
    }
    return this.b;
  }
  
  public final String a(String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = a().getApplicationInfo(c.getPackageName(), 128);
      if ((localApplicationInfo == null) || (localApplicationInfo.metaData == null)) {
        break label47;
      }
      paramString = String.valueOf(localApplicationInfo.metaData.get(paramString));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        label47:
        paramString = "";
      }
    }
    return paramString;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    int j = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 97;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 98;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 99;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 100;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 101;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 102;
    tmp94_88;
    for (;;)
    {
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        int k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        if (i < k) {
          continue;
        }
        paramArrayOfByte = new java/lang/String;
        paramArrayOfByte.<init>((char[])localObject);
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        int i;
        int n;
        int m;
        paramArrayOfByte = null;
        continue;
      }
      return paramArrayOfByte;
      n = paramArrayOfByte[i];
      m = j + 1;
      localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
      j = m + 1;
      localObject[m] = arrayOfChar[(n & 0xF)];
      i++;
    }
  }
  
  public PackageInfo b()
  {
    try
    {
      PackageInfo localPackageInfo = this.b.getPackageInfo(c.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (a().checkPermission(paramString, c()) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String c()
  {
    return b().packageName;
  }
  
  public boolean c(String paramString)
  {
    if (c.checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String d()
  {
    return b().versionName;
  }
  
  public final String e()
  {
    return "8888";
  }
  
  public String f()
  {
    try
    {
      String str1 = a(a().getPackageInfo(c.getPackageName(), 64).signatures[0].toByteArray());
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  public final String g()
  {
    return a("UMCSDK_SMSLOGIN_FLAG");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */