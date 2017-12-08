package com.lantern.wifilocating.push.util.process;

import com.lantern.wifilocating.push.util.process.models.AndroidAppProcess;
import com.lantern.wifilocating.push.util.process.models.AndroidAppProcess.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static List<AndroidAppProcess> a()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = new File("/proc").listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < j)
      {
        localObject = arrayOfFile[i];
        if (!((File)localObject).isDirectory()) {}
      }
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((File)localObject).getName());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int k;
          continue;
        }
        try
        {
          localObject = new com/lantern/wifilocating/push/util/process/models/AndroidAppProcess;
          ((AndroidAppProcess)localObject).<init>(k);
          localArrayList.add(localObject);
          i++;
          break;
          return localArrayList;
        }
        catch (IOException localIOException) {}catch (AndroidAppProcess.a locala) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */