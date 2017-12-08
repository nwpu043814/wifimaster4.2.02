package com.tencent.a.a.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class a
{
  static File a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (;;)
    {
      return paramString;
      if (!paramString.getParentFile().exists()) {
        a(paramString.getParentFile().getAbsolutePath());
      }
      paramString.mkdir();
    }
  }
  
  static List<String> a(File paramFile)
  {
    FileReader localFileReader = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(localFileReader);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramFile = localBufferedReader.readLine();
      if (paramFile == null) {
        break;
      }
      localArrayList.add(paramFile.trim());
    }
    localFileReader.close();
    localBufferedReader.close();
    return localArrayList;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */