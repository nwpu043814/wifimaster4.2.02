package com.linksure.apservice.utils.text;

import android.text.SpannableString;
import android.text.util.Linkify.MatchFilter;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static final Linkify.MatchFilter a = new b();
  private static final String[] b = { "http://", "https://", "rtsp://" };
  
  public static SpannableString a(CharSequence paramCharSequence)
  {
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    Matcher localMatcher = Patterns.WEB_URL.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if (a.acceptMatch(paramCharSequence, i, j)) {
        localSpannableString.setSpan(new ApsURLSpan(a(localMatcher.group(0), b)), i, j, 33);
      }
    }
    return localSpannableString;
  }
  
  private static final String a(String paramString, String[] paramArrayOfString)
  {
    int j = 1;
    int i = 0;
    if (i < paramArrayOfString.length) {
      if (paramString.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        if (paramString.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label118;
        }
        paramString = paramArrayOfString[i] + paramString.substring(paramArrayOfString[i].length());
        i = j;
      }
    }
    for (;;)
    {
      String str = paramString;
      if (i == 0) {
        str = paramArrayOfString[0] + paramString;
      }
      return str;
      i++;
      break;
      label118:
      i = j;
      continue;
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/text/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */