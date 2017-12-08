package com.lantern.launcher.sync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.os.Bundle;

public final class a
  extends AbstractAccountAuthenticator
{
  public Context a;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    return new Bundle();
  }
  
  public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    return null;
  }
  
  public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String getAuthTokenLabel(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/sync/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */