package com.wifipay.framework.api;

import java.util.Arrays;

final class a
  implements BackgroundExecutor.WrongThreadListener
{
  public final void onBgExpected(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      throw new IllegalStateException("Method invocation is expected from a background thread, but it was called from the UI thread");
    }
    throw new IllegalStateException("Method invocation is expected from one of serials " + Arrays.toString(paramVarArgs) + ", but it was called from the UI thread");
  }
  
  public final void onUiExpected()
  {
    throw new IllegalStateException("Method invocation is expected from the UI thread");
  }
  
  public final void onWrongBgSerial(String paramString, String... paramVarArgs)
  {
    String str = paramString;
    if (paramString == null) {
      str = "anonymous";
    }
    throw new IllegalStateException("Method invocation is expected from one of serials " + Arrays.toString(paramVarArgs) + ", but it was called from " + str + " serial");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */