package com.b.a;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class h
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final Set<Character> b;
  private static final Set<Character> c;
  private final boolean d = false;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(Character.valueOf('"'));
    localHashSet.add(Character.valueOf('\\'));
    b = Collections.unmodifiableSet(localHashSet);
    localHashSet = new HashSet();
    localHashSet.add(Character.valueOf('<'));
    localHashSet.add(Character.valueOf('>'));
    localHashSet.add(Character.valueOf('&'));
    localHashSet.add(Character.valueOf('='));
    localHashSet.add(Character.valueOf('\''));
    c = Collections.unmodifiableSet(localHashSet);
  }
  
  private static void a(int paramInt, Appendable paramAppendable)
  {
    while (Character.isSupplementaryCodePoint(paramInt))
    {
      char[] arrayOfChar = Character.toChars(paramInt);
      a(arrayOfChar[0], paramAppendable);
      paramInt = arrayOfChar[1];
    }
    paramAppendable.append("\\u").append(a[(paramInt >>> 12 & 0xF)]).append(a[(paramInt >>> 8 & 0xF)]).append(a[(paramInt >>> 4 & 0xF)]).append(a[(paramInt & 0xF)]);
  }
  
  private void a(CharSequence paramCharSequence, StringBuilder paramStringBuilder)
  {
    int n = paramCharSequence.length();
    int j = 0;
    int k = 0;
    if (j < n)
    {
      int i2 = Character.codePointAt(paramCharSequence, j);
      int i1 = Character.charCount(i2);
      int i;
      label77:
      label134:
      int m;
      if ((i2 < 32) || (i2 == 8232) || (i2 == 8233) || ((i2 >= 127) && (i2 <= 159)))
      {
        i = 1;
        if (i == 0)
        {
          if (Character.isSupplementaryCodePoint(i2)) {
            break label268;
          }
          char c1 = (char)i2;
          if ((!b.contains(Character.valueOf(c1))) && ((!this.d) || (!c.contains(Character.valueOf(c1))))) {
            break label262;
          }
          i = 1;
          m = k;
          if (i == 0) {}
        }
        else
        {
          paramStringBuilder.append(paramCharSequence, k, j);
          m = j + i1;
          switch (i2)
          {
          default: 
            a(i2, paramStringBuilder);
          }
        }
      }
      for (;;)
      {
        j += i1;
        k = m;
        break;
        i = 0;
        break label77;
        label262:
        i = 0;
        break label134;
        label268:
        i = 0;
        break label134;
        paramStringBuilder.append("\\b");
        continue;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        paramStringBuilder.append("\\\\");
        continue;
        paramStringBuilder.append("\\/");
        continue;
        paramStringBuilder.append("\\\"");
      }
    }
    paramStringBuilder.append(paramCharSequence, k, n);
  }
  
  public final String a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() + 20);
    try
    {
      a(paramCharSequence, localStringBuilder);
      return localStringBuilder.toString();
    }
    catch (IOException paramCharSequence)
    {
      throw new RuntimeException(paramCharSequence);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */