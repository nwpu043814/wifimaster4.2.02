package com.b.a;

final class d
  extends RuntimeException
{
  private final Object a;
  
  d(Object paramObject)
  {
    super("circular reference error");
    this.a = paramObject;
  }
  
  public final IllegalStateException a(l paraml)
  {
    StringBuilder localStringBuilder = new StringBuilder(getMessage());
    if (paraml != null) {
      localStringBuilder.append("\n  Offending field: ").append(paraml.a() + "\n");
    }
    if (this.a != null) {
      localStringBuilder.append("\n  Offending object: ").append(this.a);
    }
    return new IllegalStateException(localStringBuilder.toString(), this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */