package com.b.b;

import java.io.IOException;

public final class o
  extends IOException
{
  private u a = null;
  
  public o(String paramString)
  {
    super(paramString);
  }
  
  static o a()
  {
    return new o("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static o b()
  {
    return new o("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static o c()
  {
    return new o("CodedInputStream encountered a malformed varint.");
  }
  
  static o d()
  {
    return new o("Protocol message contained an invalid tag (zero).");
  }
  
  static o e()
  {
    return new o("Protocol message end-group tag did not match expected tag.");
  }
  
  static o f()
  {
    return new o("Protocol message tag had invalid wire type.");
  }
  
  static o g()
  {
    return new o("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static o h()
  {
    return new o("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static o i()
  {
    return new o("Protocol message had invalid UTF-8.");
  }
  
  public final o a(u paramu)
  {
    this.a = paramu;
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */