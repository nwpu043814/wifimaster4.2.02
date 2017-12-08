package cm.pass.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class i
{
  public static ConnectivityManager a;
  public static Network b;
  private static i c = null;
  
  private i(Context paramContext)
  {
    a = (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString);
      paramString = paramString.getAddress();
      int j = paramString[3];
      int k = paramString[2];
      i = paramString[1];
      i = paramString[0] & 0xFF | (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i & 0xFF) << 8;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return i;
  }
  
  public static Network a()
  {
    return b;
  }
  
  public static i a(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null)
      {
        i locali = new cm/pass/sdk/utils/i;
        locali.<init>(paramContext);
        c = locali;
      }
      return c;
    }
    finally {}
  }
  
  public static void a(ConnectivityManager.NetworkCallback paramNetworkCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addCapability(12);
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      localObject = ((NetworkRequest.Builder)localObject).build();
      a.requestNetwork((NetworkRequest)localObject, paramNetworkCallback);
    }
  }
  
  public static void a(Network paramNetwork)
  {
    b = paramNetwork;
  }
  
  public static String b(String paramString)
  {
    int i = paramString.indexOf("://");
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i + 3);
    }
    i = str1.indexOf(':');
    String str2 = str1;
    if (i >= 0) {
      str2 = str1.substring(0, i);
    }
    i = str2.indexOf('/');
    paramString = str2;
    if (i >= 0) {
      paramString = str2.substring(0, i);
    }
    i = paramString.indexOf('?');
    str1 = paramString;
    if (i >= 0) {
      str1 = paramString.substring(0, i);
    }
    return str1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */