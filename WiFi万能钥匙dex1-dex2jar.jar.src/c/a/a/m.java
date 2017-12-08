package c.a.a;

public final class m
{
  private static av a;
  
  static
  {
    a locala = new a();
    a = locala;
    locala.a(1, "IN");
    a.a(3, "CH");
    a.b(3, "CHAOS");
    a.a(4, "HS");
    a.b(4, "HESIOD");
    a.a(254, "NONE");
    a.a(255, "ANY");
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new af(paramInt);
    }
  }
  
  public static String b(int paramInt)
  {
    return a.d(paramInt);
  }
  
  private static final class a
    extends av
  {
    public a()
    {
      super(2);
      a("CLASS");
    }
    
    public final void a(int paramInt)
    {
      m.a(paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */