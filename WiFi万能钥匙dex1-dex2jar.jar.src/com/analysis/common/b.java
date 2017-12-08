package com.analysis.common;

import com.analysis.common.tools.c;

public final class b
  implements a
{
  public StringBuilder f;
  
  public b()
  {
    this.f = new StringBuilder();
  }
  
  private b(int paramInt)
  {
    this.f = new StringBuilder(paramInt);
  }
  
  private b(CharSequence paramCharSequence)
  {
    this.f = new StringBuilder(paramCharSequence);
  }
  
  private b(String paramString)
  {
    this.f = new StringBuilder(paramString);
  }
  
  private int a()
  {
    return this.f.length();
  }
  
  private StringBuilder a(char paramChar)
  {
    if (Character.isWhitespace(paramChar)) {}
    for (StringBuilder localStringBuilder = this.f.append("null");; localStringBuilder = this.f.append(paramChar)) {
      return localStringBuilder;
    }
  }
  
  private StringBuilder a(double paramDouble)
  {
    return this.f.append(paramDouble);
  }
  
  private StringBuilder a(float paramFloat)
  {
    return this.f.append(paramFloat);
  }
  
  private StringBuilder a(int paramInt)
  {
    if (paramInt == Integer.MIN_VALUE) {}
    for (StringBuilder localStringBuilder = this.f.append("null");; localStringBuilder = this.f.append(paramInt)) {
      return localStringBuilder;
    }
  }
  
  private StringBuilder a(int paramInt1, int paramInt2)
  {
    return this.f.delete(paramInt1, paramInt2);
  }
  
  private StringBuilder a(int paramInt1, int paramInt2, String paramString)
  {
    return this.f.replace(paramInt1, paramInt2, paramString);
  }
  
  private StringBuilder a(long paramLong)
  {
    if (paramLong == Long.MIN_VALUE) {}
    for (StringBuilder localStringBuilder = this.f.append("null");; localStringBuilder = this.f.append(paramLong)) {
      return localStringBuilder;
    }
  }
  
  private StringBuilder a(CharSequence paramCharSequence)
  {
    if (c.a(paramCharSequence.toString())) {}
    for (paramCharSequence = this.f.append("null");; paramCharSequence = this.f.append(paramCharSequence)) {
      return paramCharSequence;
    }
  }
  
  private StringBuilder a(Object paramObject)
  {
    if (c.a(paramObject)) {}
    for (paramObject = this.f.append("null");; paramObject = this.f.append(paramObject)) {
      return (StringBuilder)paramObject;
    }
  }
  
  private StringBuilder a(StringBuffer paramStringBuffer)
  {
    if ((c.a(paramStringBuffer)) || (paramStringBuffer.length() <= 0)) {}
    for (paramStringBuffer = this.f.append("null");; paramStringBuffer = this.f.append(paramStringBuffer)) {
      return paramStringBuffer;
    }
  }
  
  private StringBuilder a(boolean paramBoolean)
  {
    return this.f.append(paramBoolean);
  }
  
  private StringBuilder a(char[] paramArrayOfChar)
  {
    if ((c.a(paramArrayOfChar)) || (paramArrayOfChar.length <= 0)) {}
    for (paramArrayOfChar = this.f.append("null");; paramArrayOfChar = this.f.append(paramArrayOfChar)) {
      return paramArrayOfChar;
    }
  }
  
  private StringBuilder b(int paramInt)
  {
    return this.f.deleteCharAt(paramInt);
  }
  
  public final StringBuilder a(String paramString)
  {
    if (c.a(paramString)) {}
    for (paramString = this.f.append("null");; paramString = this.f.append(paramString)) {
      return paramString;
    }
  }
  
  public final String toString()
  {
    return this.f.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */