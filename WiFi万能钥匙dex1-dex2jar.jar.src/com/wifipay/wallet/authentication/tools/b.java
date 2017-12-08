package com.wifipay.wallet.authentication.tools;

import java.io.File;
import java.io.IOException;

public class b
{
  public static boolean a(File paramFile)
  {
    if (paramFile != null) {
      if (paramFile.exists()) {
        if (!paramFile.isDirectory()) {
          break label29;
        }
      }
    }
    label29:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (paramFile.mkdirs()) {
        break;
      }
    }
  }
  
  public static boolean b(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFile == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (paramFile.exists())
      {
        bool1 = paramFile.isFile();
      }
      else
      {
        bool1 = bool2;
        if (a(paramFile.getParentFile())) {
          try
          {
            bool1 = paramFile.createNewFile();
          }
          catch (IOException paramFile)
          {
            paramFile.printStackTrace();
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/tools/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */