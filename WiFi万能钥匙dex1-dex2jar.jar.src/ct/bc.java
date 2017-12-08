package ct;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bc
{
  private static String a = "";
  private static String b = "";
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] << 24 & 0xFF000000) + (paramArrayOfByte[1] << 16 & 0xFF0000) + (paramArrayOfByte[2] << 8 & 0xFF00) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String a()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = a;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = p.a();
          if (localObject != null)
          {
            localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
            if (localObject != null) {
              a = ((TelephonyManager)localObject).getDeviceId();
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int j;
        continue;
      }
      return a;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    int i = 1;
    if (paramContext == null)
    {
      paramContext = null;
      return paramContext;
    }
    for (;;)
    {
      try
      {
        str = a;
        if (str != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            a = paramContext.getDeviceId();
          }
        }
      }
      catch (Exception paramContext)
      {
        String str;
        int j;
        continue;
      }
      paramContext = a;
      break;
      j = str.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String a(Exception paramException)
  {
    String str = Log.getStackTraceString(paramException);
    if (str != null) {
      if ((str.indexOf("\n") != -1) && (str.indexOf("\n") < 100)) {
        paramException = str.substring(0, str.indexOf("\n"));
      }
    }
    for (;;)
    {
      return paramException;
      paramException = str;
      if (str.length() > 100)
      {
        paramException = str.substring(0, 100);
        continue;
        paramException = "";
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {}
    for (;;)
    {
      return bool;
      if (paramString.trim().length() != 0) {
        bool = false;
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    int i = 1;
    if (paramContext == null)
    {
      paramContext = null;
      return paramContext;
    }
    for (;;)
    {
      try
      {
        str = b;
        if (str != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext != null)
          {
            paramContext = paramContext.getConnectionInfo();
            if (paramContext != null) {
              b = paramContext.getMacAddress();
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        String str;
        int j;
        continue;
      }
      paramContext = b;
      break;
      j = str.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    str1 = "";
    Context localContext = p.a();
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("");
      String str2 = a(localContext);
      if (!TextUtils.isEmpty(str2)) {
        localStringBuilder.append(str2);
      }
      str2 = b(localContext);
      if (!TextUtils.isEmpty(str2)) {
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(SystemClock.elapsedRealtime());
      localStringBuilder.append(paramString);
      localStringBuilder.append((int)(Math.random() * 2.147483647E9D));
      paramString = e(localStringBuilder.toString());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = str1;
      }
    }
    return paramString;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return (String)localObject;
    }
    String str = "";
    for (int i = 0;; i++)
    {
      localObject = str;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xF);
    }
  }
  
  public static String c(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = null;
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (!paramString.toLowerCase().startsWith("http://"))
      {
        str = paramString;
        if (!paramString.toLowerCase().startsWith("https://")) {
          str = "http://" + paramString;
        }
      }
    }
  }
  
  public static String d(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = null;
      return str;
    }
    int i = paramString.indexOf("://");
    if (i != -1) {
      i += 3;
    }
    for (;;)
    {
      int j = paramString.indexOf('/', i);
      if (j != -1) {
        paramString = paramString.substring(i, j);
      }
      for (;;)
      {
        i = paramString.indexOf(":");
        str = paramString;
        if (i < 0) {
          break;
        }
        str = paramString.substring(0, i);
        break;
        j = paramString.indexOf('?', i);
        if (j != -1) {
          paramString = paramString.substring(i, j);
        } else {
          paramString = paramString.substring(i);
        }
      }
      i = 0;
    }
  }
  
  private static String e(String paramString)
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      localObject = arrayOfByte;
    }
    for (;;)
    {
      return (String)localObject;
      try
      {
        label19:
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        arrayOfByte = ((MessageDigest)localObject).digest();
        if (arrayOfByte != null) {
          break label58;
        }
        localObject = "";
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString.printStackTrace();
        localObject = arrayOfByte;
      }
      continue;
      label58:
      localObject = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        paramString = Integer.toHexString(arrayOfByte[i] & 0xFF);
        if (paramString.length() == 1) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(paramString);
      }
      localObject = ((StringBuffer)localObject).toString().toUpperCase();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */