package com.alipay.c.a.a.e;

import com.alipay.c.a.a.c.b.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public final class b
{
  private File a = null;
  private a b = null;
  
  public b(String paramString, a parama)
  {
    this.a = new File(paramString);
    this.b = parama;
  }
  
  private static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "id");
      localJSONObject.put("error", paramString);
      paramString = localJSONObject.toString();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private void b()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
        if ((this.a.exists()) && (this.a.isDirectory()) && (this.a.list().length != 0))
        {
          ArrayList localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          localObject1 = this.a.list();
          int k = localObject1.length;
          int i = 0;
          if (i < k)
          {
            localArrayList.add(localObject1[i]);
            i++;
          }
          else
          {
            Collections.sort(localArrayList);
            localObject1 = (String)localArrayList.get(localArrayList.size() - 1);
            i = localArrayList.size();
            Object localObject3 = Calendar.getInstance().getTime();
            Object localObject4 = new java/text/SimpleDateFormat;
            ((SimpleDateFormat)localObject4).<init>("yyyyMMdd");
            localObject4 = ((SimpleDateFormat)localObject4).format((Date)localObject3);
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            if (((String)localObject1).equals((String)localObject4 + ".log")) {
              if (localArrayList.size() >= 2)
              {
                localObject1 = (String)localArrayList.get(localArrayList.size() - 2);
                i--;
                localObject1 = a(com.alipay.c.a.a.a.b.a(this.a.getAbsolutePath(), (String)localObject1));
                if (!this.b.a((String)localObject1))
                {
                  i--;
                  if (j < i)
                  {
                    localObject3 = (String)localArrayList.get(j);
                    localObject1 = new java/io/File;
                    ((File)localObject1).<init>(this.a, (String)localObject3);
                    ((File)localObject1).delete();
                    j++;
                    continue;
                  }
                }
                else
                {
                  continue;
                }
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public final void a()
  {
    new Thread(new c(this)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */