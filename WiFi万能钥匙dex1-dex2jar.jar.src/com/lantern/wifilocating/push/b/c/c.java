package com.lantern.wifilocating.push.b.c;

import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.h;
import java.io.BufferedReader;

final class c
  implements Runnable
{
  c(a parama) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localStringBuilder1 = new java/lang/StringBuilder;
        localStringBuilder1.<init>();
        a.a("开始读取");
        char[] arrayOfChar = new char['Ѐ'];
        i = a.d(this.a).read(arrayOfChar);
        if ((i == -1) || (!a.e(this.a))) {
          break label360;
        }
        com.lantern.wifilocating.push.util.b.a("start receiver data~");
        Object localObject1 = new java/lang/String;
        ((String)localObject1).<init>(arrayOfChar, 0, i);
        localStringBuilder1.append((String)localObject1);
        if (localStringBuilder1.indexOf("@$") < 0) {
          continue;
        }
        localObject1 = localStringBuilder1.toString();
        if (!((String)localObject1).endsWith("@$")) {
          break label375;
        }
        i = 1;
        arrayOfString = ((String)localObject1).split("@\\$");
        if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
          continue;
        }
        m = arrayOfString.length;
        if (i != 0)
        {
          j = m;
          int k = 0;
          if (k >= j) {
            continue;
          }
          localObject4 = arrayOfString[k];
          StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
          localStringBuilder2.<init>("receive:");
          if (localObject4 != null)
          {
            localObject1 = localObject4;
            com.lantern.wifilocating.push.util.b.a((String)localObject1);
            com.lantern.wifilocating.push.b.a.b.a().a((String)localObject4);
            k++;
            continue;
          }
        }
        else
        {
          j = m - 1;
          continue;
        }
        localObject1 = "log string is null";
        continue;
        if (i != 0)
        {
          localStringBuilder1.delete(0, localStringBuilder1.length());
          continue;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder1;
        String[] arrayOfString;
        int m;
        h.a(localException);
        Object localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("发生异常 : ");
        a.a(localException.getMessage());
        a.c(this.a);
        a.a("读取完毕");
        if (a.e(this.a)) {
          f.a(new com.lantern.wifilocating.push.f.a.a(a.a.h));
        }
        return;
        Object localObject2 = arrayOfString[(m - 1)];
        int j = localStringBuilder1.length();
        if (localObject2 != null)
        {
          i = ((String)localObject2).length();
          localStringBuilder1.delete(0, j - i);
          continue;
        }
      }
      finally
      {
        a.c(this.a);
      }
      int i = 0;
      continue;
      label360:
      a.a("Socket流关闭");
      a.c(this.a);
      continue;
      label375:
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */