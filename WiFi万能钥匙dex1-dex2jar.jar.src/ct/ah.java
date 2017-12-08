package ct;

public final class ah
  extends bf
{
  private static am g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public am f = null;
  
  public final void a(bd parambd)
  {
    this.a = parambd.a(this.a, 0, false);
    this.b = parambd.a(this.b, 1, false);
    this.c = parambd.a(this.c, 2, false);
    this.d = parambd.a(this.d, 3, false);
    this.e = parambd.a(this.e, 4, false);
    if (g == null) {
      g = new am();
    }
    this.f = ((am)parambd.a(g, 5, false));
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.a, 0);
    parambe.a(this.b, 1);
    parambe.a(this.c, 2);
    parambe.a(this.d, 3);
    parambe.a(this.e, 4);
    if (this.f != null) {
      parambe.a(this.f, 5);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */