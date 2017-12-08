package com.linksure.apservice.utils.text;

import android.text.util.Linkify.MatchFilter;

final class b
  implements Linkify.MatchFilter
{
  public final boolean acceptMatch(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 == 0) {}
    for (;;)
    {
      return bool;
      if (paramCharSequence.charAt(paramInt1 - 1) == '@') {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/text/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */