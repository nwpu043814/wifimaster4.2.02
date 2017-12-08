package com.wifipay.wallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.pay.activity.WifiPayEntryActivity;
import com.wifipay.wallet.prod.pay.WifiPayReq;

public class WifiPayApiImpl
  implements WifiPayApi
{
  static final Object SYNC = new SyncResp();
  static final Object SYNC_ACT = new SyncResp();
  private boolean checkSignature = false;
  private Context context;
  
  public WifiPayApiImpl(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.checkSignature = paramBoolean;
  }
  
  private SPayResp getResp()
  {
    SPayResp localSPayResp2 = SyncResp.a();
    SPayResp localSPayResp1 = localSPayResp2;
    if (localSPayResp2 == null) {
      localSPayResp1 = SyncResp.c();
    }
    localSPayResp1.wifiToken = b.a().l();
    localSPayResp1.wifiUhid = b.a().m();
    return localSPayResp1;
  }
  
  private void syncSendReq(WifiPayReq paramWifiPayReq, Object paramObject)
  {
    Intent localIntent = new Intent(this.context, WifiPayEntryActivity.class);
    Bundle localBundle = new Bundle();
    paramWifiPayReq.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    this.context.startActivity(localIntent);
    try
    {
      paramObject.wait();
      return;
    }
    catch (InterruptedException paramWifiPayReq)
    {
      for (;;)
      {
        SyncResp.c();
      }
    }
    finally {}
  }
  
  /* Error */
  public final SPayResp sendReq(WifiPayReq paramWifiPayReq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: invokestatic 98	com/wifipay/wallet/pay/SyncResp:a	(Lcom/wifipay/wallet/pay/SPayResp;)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: invokestatic 39	com/wifipay/wallet/pay/SyncResp:c	()Lcom/wifipay/wallet/pay/SPayResp;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: getstatic 22	com/wifipay/wallet/pay/WifiPayApiImpl:SYNC	Ljava/lang/Object;
    //   23: invokespecial 100	com/wifipay/wallet/pay/WifiPayApiImpl:syncSendReq	(Lcom/wifipay/wallet/prod/pay/WifiPayReq;Ljava/lang/Object;)V
    //   26: aload_0
    //   27: invokespecial 102	com/wifipay/wallet/pay/WifiPayApiImpl:getResp	()Lcom/wifipay/wallet/pay/SPayResp;
    //   30: astore_1
    //   31: goto -17 -> 14
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	WifiPayApiImpl
    //   0	39	1	paramWifiPayReq	WifiPayReq
    // Exception table:
    //   from	to	target	type
    //   2	6	34	finally
    //   10	14	34	finally
    //   18	31	34	finally
  }
  
  public SPayResp sendReq(String paramString)
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-2";
    if (a.a(paramString)) {
      localSPayResp = sendReq(a.b(paramString));
    }
    return localSPayResp;
  }
  
  /* Error */
  public final SPayResp sendReqAct(WifiPayReq paramWifiPayReq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: invokestatic 98	com/wifipay/wallet/pay/SyncResp:a	(Lcom/wifipay/wallet/pay/SPayResp;)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: invokestatic 39	com/wifipay/wallet/pay/SyncResp:c	()Lcom/wifipay/wallet/pay/SPayResp;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: getstatic 24	com/wifipay/wallet/pay/WifiPayApiImpl:SYNC_ACT	Ljava/lang/Object;
    //   23: invokespecial 100	com/wifipay/wallet/pay/WifiPayApiImpl:syncSendReq	(Lcom/wifipay/wallet/prod/pay/WifiPayReq;Ljava/lang/Object;)V
    //   26: aload_0
    //   27: invokespecial 102	com/wifipay/wallet/pay/WifiPayApiImpl:getResp	()Lcom/wifipay/wallet/pay/SPayResp;
    //   30: astore_1
    //   31: goto -17 -> 14
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	WifiPayApiImpl
    //   0	39	1	paramWifiPayReq	WifiPayReq
    // Exception table:
    //   from	to	target	type
    //   2	6	34	finally
    //   10	14	34	finally
    //   18	31	34	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/WifiPayApiImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */