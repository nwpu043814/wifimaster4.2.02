package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.e;

public final class a
{
  public static boolean a(Context paramContext, a parama)
  {
    boolean bool = false;
    if ((paramContext == null) || (parama == null)) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
    }
    for (;;)
    {
      return bool;
      if (e.j(parama.k))
      {
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.k);
      }
      else
      {
        if (e.j(parama.l)) {
          parama.l = (parama.k + ".wxapi.WXEntryActivity");
        }
        com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.k + ", targetClassName = " + parama.l);
        Intent localIntent = new Intent();
        localIntent.setClassName(parama.k, parama.l);
        if (parama.n != null) {
          localIntent.putExtras(parama.n);
        }
        String str = paramContext.getPackageName();
        localIntent.putExtra("_mmessage_sdkVersion", 570490883);
        localIntent.putExtra("_mmessage_appPackage", str);
        localIntent.putExtra("_mmessage_content", parama.m);
        localIntent.putExtra("_mmessage_checksum", b.a(parama.m, 570490883, str));
        if (parama.flags == -1) {
          localIntent.addFlags(268435456).addFlags(134217728);
        }
        for (;;)
        {
          try
          {
            paramContext.startActivity(localIntent);
            com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
            bool = true;
          }
          catch (Exception paramContext)
          {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { paramContext.getMessage() });
          }
          localIntent.setFlags(parama.flags);
        }
      }
    }
  }
  
  public static final class a
  {
    public int flags = -1;
    public String k;
    public String l;
    public String m;
    public Bundle n;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */