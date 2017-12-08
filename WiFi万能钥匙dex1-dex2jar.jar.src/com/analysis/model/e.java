package com.analysis.model;

import com.analysis.common.b;
import java.io.Serializable;

final class e
  implements Serializable
{
  private static final long b = -8314831258182781324L;
  private String c;
  private String d;
  
  private e(d paramd, String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public final String toString()
  {
    b localb = new b();
    localb.a("{");
    localb.a("\"" + this.c + '"' + ":\"" + this.d + '"');
    localb.a("}");
    return localb.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */