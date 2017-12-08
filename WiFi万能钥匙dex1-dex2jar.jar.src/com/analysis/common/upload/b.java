package com.analysis.common.upload;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

final class b
  implements j
{
  b(a parama) {}
  
  public final boolean a(File paramFile)
  {
    for (boolean bool1 = false;; bool1 = bool2)
    {
      try
      {
        localObject1 = new java/io/BufferedReader;
        localObject2 = new java/io/FileReader;
        ((FileReader)localObject2).<init>(paramFile);
        ((BufferedReader)localObject1).<init>((Reader)localObject2);
        paramFile = "";
        for (;;)
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((String)localObject2).trim();
          if (!com.analysis.common.tools.c.a((String)localObject2))
          {
            int i = ((String)localObject2).indexOf(":");
            this.a.e = ((String)localObject2).substring(0, i);
            this.a.l = ((String)localObject2).substring(i + 1);
            this.a.i = ((String)localObject2).getBytes().length;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject2 = ((StringBuilder)localObject2).append(paramFile);
            a locala = this.a;
            paramFile = new java/lang/StringBuilder;
            paramFile.<init>();
            paramFile = paramFile.append(locala.a).append("\t").append(locala.b).append("\t").append(locala.c).append("\t").append(locala.d).append("\t").append(locala.e).append("\t").append(locala.f).append("\t").append(locala.g).append("\t").append(locala.m.getSharedPreferences("sp_general_config", 0).getInt("app_city", 33)).append("\t").append(locala.h).append("\t").append(locala.i).append("\t").append(locala.j).append("\t").append(locala.k).append("\t").append(locala.l).append("\n").toString();
          }
        }
        if (!com.analysis.common.tools.c.a(paramFile)) {
          break label346;
        }
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          label346:
          boolean bool2;
          paramFile.printStackTrace();
        }
      }
      return bool1;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("forceUploadlog params: ");
      com.analysis.common.tools.a.b("kyo", paramFile);
      localObject2 = com.analysis.common.http.a.b;
      localObject1 = new java/util/HashMap;
      ((HashMap)localObject1).<init>();
      ((Map)localObject1).put("v=2&c", paramFile);
      bool2 = com.analysis.common.http.c.a((String)localObject2, (Map)localObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */