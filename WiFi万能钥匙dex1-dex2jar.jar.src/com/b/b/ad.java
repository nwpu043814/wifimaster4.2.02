package com.b.b;

final class ad
{
  static String a(e parame)
  {
    ae localae = new ae(parame);
    parame = new StringBuilder(localae.a());
    int i = 0;
    if (i < localae.a())
    {
      int j = localae.a(i);
      switch (j)
      {
      default: 
        if ((j >= 32) && (j <= 126)) {
          parame.append((char)j);
        }
        break;
      }
      for (;;)
      {
        i++;
        break;
        parame.append("\\a");
        continue;
        parame.append("\\b");
        continue;
        parame.append("\\f");
        continue;
        parame.append("\\n");
        continue;
        parame.append("\\r");
        continue;
        parame.append("\\t");
        continue;
        parame.append("\\v");
        continue;
        parame.append("\\\\");
        continue;
        parame.append("\\'");
        continue;
        parame.append("\\\"");
        continue;
        parame.append('\\');
        parame.append((char)((j >>> 6 & 0x3) + 48));
        parame.append((char)((j >>> 3 & 0x7) + 48));
        parame.append((char)((j & 0x7) + 48));
      }
    }
    return parame.toString();
  }
  
  private static abstract interface a
  {
    public abstract byte a(int paramInt);
    
    public abstract int a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */