package com.a.a.c;

import android.content.Context;
import com.a.a.a.a.d;
import com.a.a.a.a.e;
import java.util.zip.Adler32;

public final class b
{
  static String a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
  static final Object b = new Object();
  private static a c = null;
  
  public static a a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (c != null)
        {
          paramContext = c;
          return paramContext;
        }
        if (paramContext != null)
        {
          paramContext = b(paramContext);
          c = paramContext;
        }
        else
        {
          paramContext = null;
        }
      }
      finally {}
    }
  }
  
  private static a b(Context paramContext)
  {
    if (paramContext != null) {
      new a();
    }
    for (;;)
    {
      synchronized (b)
      {
        Object localObject1 = c.a(paramContext).a();
        if (!e.a((String)localObject1))
        {
          if (((String)localObject1).endsWith("\n"))
          {
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
            a locala = new com/a/a/c/a;
            locala.<init>();
            long l = System.currentTimeMillis();
            String str = d.a(paramContext);
            paramContext = d.b(paramContext);
            locala.c(str);
            locala.a(str);
            locala.b(l);
            locala.b(paramContext);
            locala.d((String)localObject1);
            paramContext = String.format("%s%s%s%s%s", new Object[] { locala.e(), locala.d(), Long.valueOf(locala.a()), locala.c(), locala.b() });
            if (!e.a(paramContext))
            {
              localObject1 = new java/util/zip/Adler32;
              ((Adler32)localObject1).<init>();
              ((Adler32)localObject1).reset();
              ((Adler32)localObject1).update(paramContext.getBytes());
              l = ((Adler32)localObject1).getValue();
              locala.a(l);
              paramContext = locala;
              return paramContext;
            }
            l = 0L;
          }
        }
        else {
          paramContext = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */