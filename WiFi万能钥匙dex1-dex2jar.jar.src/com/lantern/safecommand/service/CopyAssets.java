package com.lantern.safecommand.service;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CopyAssets
{
  public static String getFromAssets(String paramString, Context paramContext)
  {
    try
    {
      Object localObject = new java/io/InputStreamReader;
      ((InputStreamReader)localObject).<init>(paramContext.getResources().getAssets().open(paramString));
      BufferedReader localBufferedReader = new java/io/BufferedReader;
      localBufferedReader.<init>((Reader)localObject);
      for (paramString = "";; paramString = paramString + (String)localObject)
      {
        localObject = localBufferedReader.readLine();
        paramContext = paramString;
        if (localObject == null) {
          break;
        }
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
      }
      return paramContext;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramContext = null;
    }
  }
  
  public static void writeVPNRuleToFile(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getFromAssets("vpn_rule", paramContext);
    }
    paramString = null;
    Context localContext = null;
    for (;;)
    {
      try
      {
        paramContext = paramContext.openFileOutput("vpn_rule", 4);
        localContext = paramContext;
        paramString = paramContext;
        paramContext.write(str.getBytes());
        localContext = paramContext;
        paramString = paramContext;
        paramContext.flush();
        localContext = paramContext;
        paramString = paramContext;
        paramContext.close();
      }
      catch (Exception paramContext)
      {
        paramString = localContext;
        paramContext.printStackTrace();
        if (localContext == null) {
          continue;
        }
        try
        {
          localContext.close();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (paramString == null) {
          break label108;
        }
      }
      try
      {
        paramContext.close();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    try
    {
      paramString.close();
      label108:
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/CopyAssets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */