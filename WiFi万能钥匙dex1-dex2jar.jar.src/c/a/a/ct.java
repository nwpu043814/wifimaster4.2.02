package c.a.a;

import java.util.HashMap;

public final class ct
{
  private static a a;
  
  static
  {
    a locala = new a();
    a = locala;
    locala.a(1, "A", new e());
    a.a(2, "NS", new bd());
    a.a(3, "MD", new ao());
    a.a(4, "MF", new ap());
    a.a(5, "CNAME", new h());
    a.a(6, "SOA", new cb());
    a.a(7, "MB", new an());
    a.a(8, "MG", new aq());
    a.a(9, "MR", new as());
    a.a(10, "NULL", new be());
    a.a(11, "WKS", new da());
    a.a(12, "PTR", new bl());
    a.a(13, "HINFO", new ab());
    a.a(14, "MINFO", new ar());
    a.a(15, "MX", new at());
    a.a(16, "TXT", new cr());
    a.a(17, "RP", new bo());
    a.a(18, "AFSDB", new c());
    a.a(19, "X25", new dc());
    a.a(20, "ISDN", new ae());
    a.a(21, "RT", new br());
    a.a(22, "NSAP", new ax());
    a.a(23, "NSAP-PTR", new ay());
    a.a(24, "SIG", new ca());
    a.a(25, "KEY", new aj());
    a.a(26, "PX", new bm());
    a.a(27, "GPOS", new z());
    a.a(28, "AAAA", new b());
    a.a(29, "LOC", new al());
    a.a(30, "NXT", new bf());
    a.a(31, "EID");
    a.a(32, "NIMLOC");
    a.a(33, "SRV", new cd());
    a.a(34, "ATMA");
    a.a(35, "NAPTR", new aw());
    a.a(36, "KX", new ak());
    a.a(37, "CERT", new g());
    a.a(38, "A6", new a());
    a.a(39, "DNAME", new p());
    a.a(41, "OPT", new bi());
    a.a(42, "APL", new d());
    a.a(43, "DS", new t());
    a.a(44, "SSHFP", new ce());
    a.a(45, "IPSECKEY", new ad());
    a.a(46, "RRSIG", new bp());
    a.a(47, "NSEC", new bb());
    a.a(48, "DNSKEY", new r());
    a.a(49, "DHCID", new n());
    a.a(50, "NSEC3", new ba());
    a.a(51, "NSEC3PARAM", new az());
    a.a(52, "TLSA", new cm());
    a.a(99, "SPF", new cc());
    a.a(249, "TKEY", new cl());
    a.a(250, "TSIG", new co());
    a.a(251, "IXFR");
    a.a(252, "AXFR");
    a.a(253, "MAILB");
    a.a(254, "MAILA");
    a.a(255, "ANY");
    a.a(256, "URI", new cz());
    a.a(32769, "DLV", new o());
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new ah(paramInt);
    }
  }
  
  public static String b(int paramInt)
  {
    return a.d(paramInt);
  }
  
  static bt c(int paramInt)
  {
    return a.e(paramInt);
  }
  
  public static boolean d(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static final class a
    extends av
  {
    private HashMap a;
    
    public a()
    {
      super(2);
      a("TYPE");
      this.a = new HashMap();
    }
    
    public final void a(int paramInt)
    {
      ct.a(paramInt);
    }
    
    public final void a(int paramInt, String paramString, bt parambt)
    {
      super.a(paramInt, paramString);
      this.a.put(av.c(paramInt), parambt);
    }
    
    public final bt e(int paramInt)
    {
      ct.a(paramInt);
      return (bt)this.a.get(c(paramInt));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */