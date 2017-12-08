package com.linksure.apservice.integration.photochoose.b;

import android.content.Context;
import android.content.res.Resources;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.IOException;

public final class f
{
  public static final int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static final File a(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      File localFile = paramString.getParentFile();
      if ((!localFile.exists()) || (!localFile.isDirectory())) {
        localFile.mkdirs();
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt, Object... paramVarArgs)
  {
    paramContext = paramContext.getResources().getString(paramInt);
    if (TextUtils.isEmpty(paramContext)) {}
    for (paramContext = null;; paramContext = String.format(paramContext, paramVarArgs)) {
      return paramContext;
    }
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new android/media/ExifInterface;
        localExifInterface.<init>(paramString);
        j = localExifInterface.getAttributeInt("Orientation", -1);
        if (j != 6) {
          continue;
        }
        i = 90;
      }
      catch (IOException paramString)
      {
        int j;
        paramString.printStackTrace();
        continue;
      }
      return i;
      if (j == 3) {
        i = 180;
      } else if (j == 8) {
        i = 270;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */