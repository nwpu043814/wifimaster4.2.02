package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter
{
  private static final int DEFAULT_FLAGS = 2;
  private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final int DIR_LTR = -1;
  private static final int DIR_RTL = 1;
  private static final int DIR_UNKNOWN = 0;
  private static final String EMPTY_STRING = "";
  private static final int FLAG_STEREO_RESET = 2;
  private static final char LRE = '‪';
  private static final char LRM = '‎';
  private static final String LRM_STRING = Character.toString('‎');
  private static final char PDF = '‬';
  private static final char RLE = '‫';
  private static final char RLM = '‏';
  private static final String RLM_STRING = Character.toString('‏');
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  private final int mFlags;
  private final boolean mIsRtlContext;
  
  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(String paramString)
  {
    return new DirectionalityEstimator(paramString, false).getEntryDir();
  }
  
  private static int getExitDir(String paramString)
  {
    return new DirectionalityEstimator(paramString, false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new Builder().build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new Builder(paramLocale).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new Builder(paramBoolean).build();
  }
  
  private static boolean isRtlLocale(Locale paramLocale)
  {
    boolean bool = true;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private String markAfter(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    if ((!this.mIsRtlContext) && ((bool) || (getExitDir(paramString) == 1))) {
      paramString = LRM_STRING;
    }
    for (;;)
    {
      return paramString;
      if ((this.mIsRtlContext) && ((!bool) || (getExitDir(paramString) == -1))) {
        paramString = RLM_STRING;
      } else {
        paramString = "";
      }
    }
  }
  
  private String markBefore(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    if ((!this.mIsRtlContext) && ((bool) || (getEntryDir(paramString) == 1))) {
      paramString = LRM_STRING;
    }
    for (;;)
    {
      return paramString;
      if ((this.mIsRtlContext) && ((!bool) || (getEntryDir(paramString) == -1))) {
        paramString = RLM_STRING;
      } else {
        paramString = "";
      }
    }
  }
  
  public final boolean getStereoReset()
  {
    if ((this.mFlags & 0x2) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean isRtl(String paramString)
  {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
  }
  
  public final boolean isRtlContext()
  {
    return this.mIsRtlContext;
  }
  
  public final String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public final String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public final String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    char c;
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool)
      {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
        localStringBuilder.append(markBefore(paramString, paramTextDirectionHeuristicCompat));
      }
    }
    else
    {
      if (bool == this.mIsRtlContext) {
        break label144;
      }
      if (!bool) {
        break label136;
      }
      c = '‫';
      label74:
      localStringBuilder.append(c);
      localStringBuilder.append(paramString);
      localStringBuilder.append('‬');
      label98:
      if (paramBoolean) {
        if (!bool) {
          break label154;
        }
      }
    }
    label136:
    label144:
    label154:
    for (paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;; paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR)
    {
      localStringBuilder.append(markAfter(paramString, paramTextDirectionHeuristicCompat));
      return localStringBuilder.toString();
      paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      break;
      c = '‪';
      break label74;
      localStringBuilder.append(paramString);
      break label98;
    }
  }
  
  public final String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public static final class Builder
  {
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public Builder()
    {
      initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
    }
    
    public Builder(Locale paramLocale)
    {
      initialize(BidiFormatter.isRtlLocale(paramLocale));
    }
    
    public Builder(boolean paramBoolean)
    {
      initialize(paramBoolean);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (BidiFormatter localBidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;; localBidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE) {
        return localBidiFormatter;
      }
    }
    
    private void initialize(boolean paramBoolean)
    {
      this.mIsRtlContext = paramBoolean;
      this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
      this.mFlags = 2;
    }
    
    public final BidiFormatter build()
    {
      if ((this.mFlags == 2) && (this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC)) {}
      for (BidiFormatter localBidiFormatter = getDefaultInstanceFromContext(this.mIsRtlContext);; localBidiFormatter = new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null)) {
        return localBidiFormatter;
      }
    }
    
    public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
    {
      this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
      return this;
    }
    
    public final Builder stereoReset(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (this.mFlags |= 0x2;; this.mFlags &= 0xFFFFFFFD) {
        return this;
      }
    }
  }
  
  private static class DirectionalityEstimator
  {
    private static final byte[] DIR_TYPE_CACHE = new byte['܀'];
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final String text;
    
    static
    {
      for (int i = 0; i < 1792; i++) {
        DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
      }
    }
    
    DirectionalityEstimator(String paramString, boolean paramBoolean)
    {
      this.text = paramString;
      this.isHtml = paramBoolean;
      this.length = paramString.length();
    }
    
    private static byte getCachedDirectionality(char paramChar)
    {
      if (paramChar < '܀') {}
      for (byte b = DIR_TYPE_CACHE[paramChar];; b = Character.getDirectionality(paramChar)) {
        return b;
      }
    }
    
    private byte skipEntityBackward()
    {
      int j = this.charIndex;
      if (this.charIndex > 0)
      {
        String str = this.text;
        int i = this.charIndex - 1;
        this.charIndex = i;
        this.lastChar = str.charAt(i);
        if (this.lastChar != '&') {}
      }
      for (byte b = 12;; b = 13)
      {
        return b;
        if (this.lastChar != ';') {
          break;
        }
        this.charIndex = j;
        this.lastChar = ';';
      }
    }
    
    private byte skipEntityForward()
    {
      char c;
      do
      {
        if (this.charIndex >= this.length) {
          break;
        }
        String str = this.text;
        int i = this.charIndex;
        this.charIndex = (i + 1);
        c = str.charAt(i);
        this.lastChar = c;
      } while (c != ';');
      return 12;
    }
    
    private byte skipTagBackward()
    {
      int i = this.charIndex;
      break label90;
      label5:
      String str;
      int j;
      if (this.charIndex > 0)
      {
        str = this.text;
        j = this.charIndex - 1;
        this.charIndex = j;
        this.lastChar = str.charAt(j);
        if (this.lastChar != '<') {}
      }
      for (byte b = 12;; b = 13)
      {
        return b;
        if (this.lastChar != '>')
        {
          if ((this.lastChar != '"') && (this.lastChar != '\'')) {
            break label5;
          }
          int k = this.lastChar;
          label90:
          if (this.charIndex <= 0) {
            break label5;
          }
          str = this.text;
          j = this.charIndex - 1;
          this.charIndex = j;
          char c = str.charAt(j);
          this.lastChar = c;
          if (c != k) {
            break;
          }
          break label5;
        }
        this.charIndex = i;
        this.lastChar = '>';
      }
    }
    
    private byte skipTagForward()
    {
      int j = this.charIndex;
      break label85;
      label5:
      String str;
      int k;
      if (this.charIndex < this.length)
      {
        str = this.text;
        k = this.charIndex;
        this.charIndex = (k + 1);
        this.lastChar = str.charAt(k);
        if (this.lastChar != '>') {}
      }
      for (byte b = 12;; b = 13)
      {
        return b;
        if ((this.lastChar != '"') && (this.lastChar != '\'')) {
          break label5;
        }
        k = this.lastChar;
        label85:
        if (this.charIndex >= this.length) {
          break label5;
        }
        str = this.text;
        int m = this.charIndex;
        this.charIndex = (m + 1);
        int i = str.charAt(m);
        this.lastChar = i;
        if (i != k) {
          break;
        }
        break label5;
        this.charIndex = j;
        this.lastChar = '<';
      }
    }
    
    byte dirTypeBackward()
    {
      this.lastChar = this.text.charAt(this.charIndex - 1);
      byte b1;
      if (Character.isLowSurrogate(this.lastChar))
      {
        int i = Character.codePointBefore(this.text, this.charIndex);
        this.charIndex -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      for (;;)
      {
        return b1;
        this.charIndex -= 1;
        byte b2 = getCachedDirectionality(this.lastChar);
        b1 = b2;
        if (this.isHtml) {
          if (this.lastChar == '>')
          {
            b1 = skipTagBackward();
          }
          else
          {
            b1 = b2;
            if (this.lastChar == ';') {
              b1 = skipEntityBackward();
            }
          }
        }
      }
    }
    
    byte dirTypeForward()
    {
      this.lastChar = this.text.charAt(this.charIndex);
      byte b1;
      if (Character.isHighSurrogate(this.lastChar))
      {
        int i = Character.codePointAt(this.text, this.charIndex);
        this.charIndex += Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      for (;;)
      {
        return b1;
        this.charIndex += 1;
        byte b2 = getCachedDirectionality(this.lastChar);
        b1 = b2;
        if (this.isHtml) {
          if (this.lastChar == '<')
          {
            b1 = skipTagForward();
          }
          else
          {
            b1 = b2;
            if (this.lastChar == '&') {
              b1 = skipEntityForward();
            }
          }
        }
      }
    }
    
    int getEntryDir()
    {
      int n = -1;
      this.charIndex = 0;
      int k = 0;
      int j = 0;
      int i = 0;
      for (;;)
      {
        if ((this.charIndex < this.length) && (k == 0)) {
          switch (dirTypeForward())
          {
          case 9: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          default: 
            k = i;
            break;
          case 14: 
          case 15: 
            i++;
            j = -1;
            break;
          case 16: 
          case 17: 
            i++;
            j = 1;
            break;
          case 18: 
            i--;
            j = 0;
            break;
          case 0: 
            if (i == 0) {
              i = n;
            }
            break;
          }
        }
      }
      for (;;)
      {
        return i;
        k = i;
        break;
        if (i == 0)
        {
          i = 1;
        }
        else
        {
          k = i;
          break;
          if (k == 0)
          {
            i = 0;
          }
          else
          {
            int m = i;
            if (j != 0)
            {
              i = j;
            }
            else
            {
              for (;;)
              {
                if (this.charIndex <= 0) {
                  break label289;
                }
                switch (dirTypeBackward())
                {
                default: 
                  break;
                case 14: 
                case 15: 
                  i = n;
                  if (k == m) {
                    break;
                  }
                  m--;
                  break;
                case 16: 
                case 17: 
                  if (k == m)
                  {
                    i = 1;
                    break;
                  }
                  m--;
                  break;
                case 18: 
                  m++;
                }
              }
              label289:
              i = 0;
            }
          }
        }
      }
    }
    
    int getExitDir()
    {
      int m = 0;
      this.charIndex = this.length;
      int k = 0;
      int i = 0;
      for (;;)
      {
        int j = m;
        if (this.charIndex > 0) {}
        switch (dirTypeBackward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (k == 0) {
            k = i;
          }
          break;
        case 0: 
          if (i == 0) {
            j = -1;
          }
        case 14: 
        case 15: 
        case 1: 
        case 2: 
        case 16: 
        case 17: 
          for (;;)
          {
            return j;
            if (k != 0) {
              break;
            }
            k = i;
            break;
            if (k == i)
            {
              j = -1;
            }
            else
            {
              i--;
              break;
              if (i == 0)
              {
                j = 1;
              }
              else
              {
                if (k != 0) {
                  break;
                }
                k = i;
                break;
                if (k != i) {
                  break label190;
                }
                j = 1;
              }
            }
          }
          i--;
          break;
        case 18: 
          label190:
          i++;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/text/BidiFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */