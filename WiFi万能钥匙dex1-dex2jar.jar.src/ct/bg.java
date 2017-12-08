package ct;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class bg
{
  private static HashMap e = null;
  private HashMap a = new HashMap();
  private bd b = new bd();
  private String c = "GBK";
  private bh d = new bh();
  
  public final void a(int paramInt)
  {
    this.d.b = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.d.d = paramString;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramObject instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new be();
    ((be)localObject).a(this.c);
    ((be)localObject).a(paramObject, 0);
    paramObject = ((be)localObject).a();
    localObject = new byte[((ByteBuffer)paramObject).position()];
    System.arraycopy(((ByteBuffer)paramObject).array(), 0, localObject, 0, localObject.length);
    this.a.put(paramString, localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      Object localObject = new ct/bd;
      ((bd)localObject).<init>(paramArrayOfByte, (byte)0);
      ((bd)localObject).b = this.c;
      this.d.a((bd)localObject);
      paramArrayOfByte = new ct/bd;
      paramArrayOfByte.<init>(this.d.e);
      paramArrayOfByte.b = this.c;
      if (e == null)
      {
        localObject = new java/util/HashMap;
        ((HashMap)localObject).<init>();
        e = (HashMap)localObject;
        ((HashMap)localObject).put("", new byte[0]);
      }
      HashMap localHashMap = e;
      localObject = new java/util/HashMap;
      ((HashMap)localObject).<init>();
      this.a = ((HashMap)paramArrayOfByte.a((Map)localObject, localHashMap, 0, false));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject2 = new be(0);
    ((be)localObject2).a(this.c);
    ((be)localObject2).a(this.a, 0);
    this.d.a = 3;
    Object localObject1 = this.d;
    localObject2 = ((be)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((bh)localObject1).e = arrayOfByte;
    localObject1 = new be(0);
    ((be)localObject1).a(this.c);
    this.d.a((be)localObject1);
    localObject2 = ((be)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final Object b(String paramString, Object paramObject)
  {
    if (!this.a.containsKey(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      paramString = (byte[])this.a.get(paramString);
      try
      {
        this.b.a = ByteBuffer.wrap(paramString);
        this.b.b = this.c;
        paramString = this.b.a(paramObject, 0, true);
      }
      catch (Exception paramString)
      {
        throw new Exception(paramString);
      }
    }
  }
  
  public final void b(String paramString)
  {
    this.d.c = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */