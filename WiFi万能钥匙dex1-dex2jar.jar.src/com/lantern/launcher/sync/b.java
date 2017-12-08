package com.lantern.launcher.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import com.bluefay.b.h;
import com.lantern.core.c;

public final class b
  extends AbstractThreadedSyncAdapter
{
  public b(Context paramContext)
  {
    super(paramContext, true);
  }
  
  public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    paramBundle = c.getAppContext();
    paramAccount = new Intent("wifi.intent.action.STICKY_SERVICE");
    paramAccount.setPackage(paramBundle.getPackageName());
    paramAccount.putExtra("source", "sync");
    try
    {
      paramBundle.startService(paramAccount);
      return;
    }
    catch (SecurityException paramAccount)
    {
      for (;;)
      {
        h.a(paramAccount);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/sync/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */