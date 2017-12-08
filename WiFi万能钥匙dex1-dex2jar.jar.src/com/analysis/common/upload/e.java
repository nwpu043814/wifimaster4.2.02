package com.analysis.common.upload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.common.http.a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class e
  implements j
{
  e(d paramd) {}
  
  public final boolean a(File paramFile)
  {
    for (;;)
    {
      try
      {
        paramFile = i.a(paramFile);
        if (!com.analysis.common.tools.c.a(paramFile)) {
          continue;
        }
        bool1 = true;
      }
      catch (IOException paramFile)
      {
        Object localObject;
        int i;
        String str;
        StringBuilder localStringBuilder;
        boolean bool2;
        paramFile.printStackTrace();
        boolean bool1 = false;
        continue;
      }
      return bool1;
      localObject = Pattern.compile("(?i)(?<=crashType:)(\\S*)(?=;).*?").matcher(paramFile);
      if (((Matcher)localObject).find()) {
        this.a.e = ((Matcher)localObject).group();
      }
      i = paramFile.indexOf("memo:");
      this.a.g = paramFile.substring(0, i);
      this.a.h = paramFile.substring(i + 5);
      str = a.c;
      paramFile = this.a;
      localObject = new java/util/HashMap;
      ((HashMap)localObject).<init>();
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      ((Map)localObject).put("mt", paramFile.a);
      ((Map)localObject).put("av", paramFile.b);
      ((Map)localObject).put("pv", paramFile.c);
      ((Map)localObject).put("m", paramFile.d);
      ((Map)localObject).put("msg", paramFile.e);
      ((Map)localObject).put("l", paramFile.f);
      ((Map)localObject).put("d", paramFile.g);
      ((Map)localObject).put("memo", paramFile.h);
      bool2 = com.analysis.common.http.c.a(str, (Map)localObject);
      bool1 = bool2;
      if (bool2)
      {
        this.a.i.getSharedPreferences("sp_general_config", 0).edit().putString("crash_date", "null").commit();
        bool1 = bool2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */