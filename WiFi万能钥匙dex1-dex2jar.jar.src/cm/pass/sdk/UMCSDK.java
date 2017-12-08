package cm.pass.sdk;

import android.content.Context;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.l;

public final class UMCSDK
{
  public static final String AUTH_TYPE_DYNAMIC_SMS = "2";
  public static final String AUTH_TYPE_NONE = "-1";
  public static final String AUTH_TYPE_SMS = "4";
  public static final String AUTH_TYPE_WAP = "3";
  public static final String GETMOBILEKEY_TYPE_SMS = "2";
  public static final String GETMOBILEKEY_TYPE_WAP = "1";
  public static final int NETWORK_TYPE_CMNET = 0;
  public static final int NETWORK_TYPE_CMWAP = 1;
  public static final int NETWORK_TYPE_MOBILE = 3;
  public static final int NETWORK_TYPE_NONE = -1;
  public static final int NETWORK_TYPE_WIFI = 2;
  public static final String OPERATOR_CMCC = "1";
  public static final String OPERATOR_CTCC = "3";
  public static final String OPERATOR_CUCC = "2";
  public static final String OPERATOR_NONE = "0";
  private static final UMCSDK a = new UMCSDK();
  private Context b;
  private l c;
  
  private void a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static UMCSDK getInstance()
  {
    return a;
  }
  
  public final Context getContext()
  {
    return this.b;
  }
  
  public final String getSourceId()
  {
    return this.c.e();
  }
  
  public final UMCSDK init(Context paramContext)
  {
    if (paramContext == null) {
      throw new RuntimeException("parameter error");
    }
    a(paramContext);
    if (this.c == null) {
      this.c = l.a(paramContext);
    }
    return a;
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    j.a(paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/UMCSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */