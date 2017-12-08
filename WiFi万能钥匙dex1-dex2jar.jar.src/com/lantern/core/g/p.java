package com.lantern.core.g;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import bluefay.app.k.a;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.lantern.core.R.string;
import com.lantern.core.n;
import java.security.MessageDigest;
import java.util.Locale;

public final class p
{
  private static String a(PackageInfo paramPackageInfo)
  {
    try
    {
      Object localObject = paramPackageInfo.signatures;
      paramPackageInfo = MessageDigest.getInstance("SHA-1");
      int j = localObject.length;
      for (int i = 0; i < j; i++) {
        paramPackageInfo.update(localObject[i].toByteArray());
      }
      byte[] arrayOfByte = paramPackageInfo.digest();
      localObject = "";
      i = 0;
      if (i < arrayOfByte.length)
      {
        paramPackageInfo = Integer.toHexString(arrayOfByte[i] & 0xFF);
        StringBuilder localStringBuilder;
        if (paramPackageInfo.length() == 1)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
        for (paramPackageInfo = (String)localObject + "0" + paramPackageInfo;; paramPackageInfo = (String)localObject + paramPackageInfo)
        {
          localObject = paramPackageInfo;
          if (i < arrayOfByte.length - 1)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            localObject = paramPackageInfo + ":";
          }
          i++;
          break;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
      }
      paramPackageInfo = ((String)localObject).toUpperCase(Locale.getDefault());
    }
    catch (Exception paramPackageInfo)
    {
      for (;;)
      {
        h.a(paramPackageInfo);
        paramPackageInfo = "";
      }
    }
    return paramPackageInfo;
  }
  
  public static boolean a(Activity paramActivity, a parama)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        long l2 = System.currentTimeMillis();
        String str1 = a(paramActivity.getPackageManager().getPackageInfo("com.snda.wifilocating", 64));
        localObject = n.c("49A6DE8CD82DC9ED75EEA4E9BF919A6F8F376AFBE172E6918A340429B25B7C20183855878BAE864B60FB095DB0E56ABD76C0BB4FD48721C4A9450EDC4CBC4DE8", "ZFm8T!uw2Wo^Yi+=", "M0%mLFHpo%AYm$)(");
        String str2 = n.c("698E7131BC6365F3E3C3DFC905BF7A550E69019093283A5310D95FEEB8EE6D97E98E9081F48DEB206D92CF128EE3149793B78D380A7BD3F4B7B4FF8973C3E6FB", "ZFm8T!uw2Wo^Yi+=", "M0%mLFHpo%AYm$)(");
        if ((str1 == null) || ((!str1.equals(((String)localObject).trim())) && (!str1.equals(str2.trim())))) {
          continue;
        }
        long l1 = System.currentTimeMillis();
        paramActivity = new java/lang/StringBuilder;
        paramActivity.<init>("---WkVerifyManager--");
        h.a(l1 - l2, new Object[0]);
        bool = true;
      }
      catch (Exception paramActivity)
      {
        Object localObject;
        paramActivity.printStackTrace();
        continue;
      }
      return bool;
      localObject = new bluefay/app/k$a;
      ((k.a)localObject).<init>(paramActivity);
      ((k.a)localObject).a(paramActivity.getString(R.string.launcher_lower_version_tip_title));
      ((k.a)localObject).b(paramActivity.getString(R.string.launcher_verify_msg));
      ((k.a)localObject).b();
      paramActivity = new com/lantern/core/g/q;
      paramActivity.<init>(parama);
      ((k.a)localObject).a(17039370, paramActivity);
      ((k.a)localObject).d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */