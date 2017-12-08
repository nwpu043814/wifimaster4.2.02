package c.a.a;

public final class bs
{
  private static av a = new av("DNS Rcode", 2);
  private static av b = new av("TSIG rcode", 2);
  
  static
  {
    a.b(4095);
    a.a("RESERVED");
    a.a();
    a.a(0, "NOERROR");
    a.a(1, "FORMERR");
    a.a(2, "SERVFAIL");
    a.a(3, "NXDOMAIN");
    a.a(4, "NOTIMP");
    a.b(4, "NOTIMPL");
    a.a(5, "REFUSED");
    a.a(6, "YXDOMAIN");
    a.a(7, "YXRRSET");
    a.a(8, "NXRRSET");
    a.a(9, "NOTAUTH");
    a.a(10, "NOTZONE");
    a.a(16, "BADVERS");
    b.b(65535);
    b.a("RESERVED");
    b.a();
    b.a(a);
    b.a(16, "BADSIG");
    b.a(17, "BADKEY");
    b.a(18, "BADTIME");
    b.a(19, "BADMODE");
  }
  
  public static String a(int paramInt)
  {
    return a.d(paramInt);
  }
  
  public static String b(int paramInt)
  {
    return b.d(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */