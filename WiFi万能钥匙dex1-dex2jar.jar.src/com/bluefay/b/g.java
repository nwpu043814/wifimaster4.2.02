package com.bluefay.b;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class g
  implements d.b
{
  g(Map paramMap, String paramString1, List paramList1, List paramList2, String paramString2) {}
  
  public final void a(OutputStream paramOutputStream)
  {
    StringBuilder localStringBuilder;
    Object localObject;
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = this.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localStringBuilder.append("--");
        localStringBuilder.append(this.b);
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Content-Disposition: form-data; name=\"" + (String)localEntry.getKey() + "\"\r\n");
        localStringBuilder.append("Content-Type: text/plain; charset=UTF-8\r\n");
        localStringBuilder.append("Content-Transfer-Encoding: 8bit\r\n");
        localStringBuilder.append("\r\n");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("\r\n");
      }
      paramOutputStream.write(localStringBuilder.toString().getBytes("UTF-8"));
    }
    int j = this.c.size();
    for (int i = 0; i < j; i++)
    {
      localObject = b.c((String)this.c.get(i));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--");
      localStringBuilder.append(this.b);
      localStringBuilder.append("\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + (String)localObject + "\"\r\n");
      localStringBuilder.append("Content-Type: " + (String)this.d.get(i) + "\r\n");
      localStringBuilder.append("Content-Transfer-Encoding: binary\r\n");
      localStringBuilder.append("\r\n");
      paramOutputStream.write(localStringBuilder.toString().getBytes("UTF-8"));
      d.a(new FileInputStream((String)this.c.get(i)), paramOutputStream);
      paramOutputStream.write("\r\n".getBytes());
      paramOutputStream.write(this.e.getBytes());
      paramOutputStream.flush();
    }
    paramOutputStream.close();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */