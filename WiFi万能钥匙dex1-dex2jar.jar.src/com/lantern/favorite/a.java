package com.lantern.favorite;

import android.content.Context;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.core.p;
import com.lantern.favorite.c.b;
import java.util.ArrayList;

public final class a
{
  private final com.lantern.favorite.a.a a;
  
  public a(Context paramContext)
  {
    this(paramContext, p.c(""));
  }
  
  public a(Context paramContext, String paramString)
  {
    this.a = new com.lantern.favorite.a.b.a(paramContext, paramString);
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(p.c("")).append(":");
    localStringBuilder.append(paramString1).append(":");
    localStringBuilder.append(paramString2).append(":");
    localStringBuilder.append(paramString3);
    return b.a(localStringBuilder.toString());
  }
  
  private int b(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public final WkSceneFavorite a(String paramString)
  {
    paramString = this.a.b(new String[] { paramString });
    if (paramString.size() > 0) {}
    for (paramString = (WkSceneFavorite)paramString.get(0);; paramString = null) {
      return paramString;
    }
  }
  
  public final ArrayList<WkSceneFavorite> a()
  {
    return this.a.b(new Object[0]);
  }
  
  public final ArrayList<WkSceneFavorite> a(int paramInt)
  {
    return this.a.b(new Integer[] { Integer.valueOf(10), Integer.valueOf(paramInt) });
  }
  
  public final ArrayList<WkSceneFavorite> a(int paramInt, String paramString)
  {
    return this.a.b(new String[] { "10", String.valueOf(paramInt), paramString });
  }
  
  public final boolean a(WkSceneFavorite paramWkSceneFavorite)
  {
    String str1;
    String str2;
    if (paramWkSceneFavorite.content == null)
    {
      str1 = "";
      if (paramWkSceneFavorite.contentSrc != null) {
        break label68;
      }
      str2 = "";
      label21:
      paramWkSceneFavorite.favId = a(paramWkSceneFavorite.category, str1, str2);
      if (b(paramWkSceneFavorite.favId) == -1) {
        break label77;
      }
    }
    label68:
    label77:
    for (boolean bool = this.a.b(paramWkSceneFavorite);; bool = this.a.a(paramWkSceneFavorite))
    {
      return bool;
      str1 = paramWkSceneFavorite.content;
      break;
      str2 = paramWkSceneFavorite.contentSrc;
      break label21;
    }
  }
  
  public final boolean b()
  {
    return this.a.a(new Object[0]);
  }
  
  public final boolean b(WkSceneFavorite paramWkSceneFavorite)
  {
    int i = b(paramWkSceneFavorite.favId);
    boolean bool;
    if (i == 1) {
      bool = this.a.b(paramWkSceneFavorite);
    }
    for (;;)
    {
      return bool;
      if ((i == -1) && (paramWkSceneFavorite.state != 2)) {
        bool = this.a.a(paramWkSceneFavorite);
      } else {
        bool = false;
      }
    }
  }
  
  public final void c()
  {
    this.a.a();
  }
  
  public final boolean c(WkSceneFavorite paramWkSceneFavorite)
  {
    return this.a.b(paramWkSceneFavorite);
  }
  
  public final boolean d(WkSceneFavorite paramWkSceneFavorite)
  {
    String str1;
    String str2;
    if (paramWkSceneFavorite.content == null)
    {
      str1 = "";
      if (paramWkSceneFavorite.contentSrc != null) {
        break label58;
      }
      str2 = "";
      label21:
      paramWkSceneFavorite.favId = a(paramWkSceneFavorite.category, str1, str2);
      if (a(paramWkSceneFavorite.favId) == null) {
        break label67;
      }
    }
    label58:
    label67:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      str1 = paramWkSceneFavorite.content;
      break;
      str2 = paramWkSceneFavorite.contentSrc;
      break label21;
    }
  }
  
  public final boolean e(WkSceneFavorite paramWkSceneFavorite)
  {
    String str1;
    if (paramWkSceneFavorite.content == null)
    {
      str1 = "";
      if (paramWkSceneFavorite.contentSrc != null) {
        break label57;
      }
    }
    label57:
    for (String str2 = "";; str2 = paramWkSceneFavorite.contentSrc)
    {
      paramWkSceneFavorite.favId = a(paramWkSceneFavorite.category, str1, str2);
      paramWkSceneFavorite.state = 2;
      paramWkSceneFavorite.syncState = 0;
      return c(paramWkSceneFavorite);
      str1 = paramWkSceneFavorite.content;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */