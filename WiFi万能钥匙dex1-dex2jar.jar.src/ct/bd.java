package ct;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bd
{
  ByteBuffer a;
  String b = "GBK";
  
  public bd() {}
  
  public bd(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public bd(byte[] paramArrayOfByte, byte paramByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramDouble;
        paramDouble = this.a.getFloat();
        continue;
        paramDouble = this.a.getDouble();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramFloat;
        paramFloat = this.a.getFloat();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15) {
      parama.b = (paramByteBuffer.get() & 0xFF);
    }
    for (i = 2;; i = 1) {
      return i;
    }
  }
  
  private void a()
  {
    a locala = new a();
    do
    {
      a(locala, this.a);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new RuntimeException("invalid type.");
    case 0: 
      this.a.position(this.a.position() + 1);
    }
    for (;;)
    {
      return;
      this.a.position(this.a.position() + 2);
      continue;
      this.a.position(this.a.position() + 4);
      continue;
      this.a.position(this.a.position() + 8);
      continue;
      this.a.position(this.a.position() + 4);
      continue;
      this.a.position(this.a.position() + 8);
      continue;
      b1 = this.a.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      this.a.position(paramByte + this.a.position());
      continue;
      paramByte = this.a.getInt();
      this.a.position(paramByte + this.a.position());
      continue;
      b2 = a(0, 0, true);
      for (paramByte = b1; paramByte < b2 << 1; paramByte++)
      {
        locala = new a();
        a(locala, this.a);
        a(locala.a);
      }
      continue;
      b1 = a(0, 0, true);
      for (paramByte = b2; paramByte < b1; paramByte++)
      {
        locala = new a();
        a(locala, this.a);
        a(locala.a);
      }
      continue;
      a locala = new a();
      a(locala, this.a);
      if (locala.a != 0) {
        throw new RuntimeException("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
      }
      paramByte = a(0, 0, true);
      this.a.position(paramByte + this.a.position());
      continue;
      a();
    }
  }
  
  private boolean a(int paramInt)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        locala = new ct/bd$a;
        locala.<init>();
        i = a(locala, this.a.duplicate());
        if (locala.a != 11) {
          continue;
        }
        bool1 = bool2;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        a locala;
        int i;
        bool1 = bool2;
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool1 = bool2;
        continue;
      }
      return bool1;
      if (paramInt <= locala.b)
      {
        bool1 = bool2;
        if (paramInt == locala.b) {
          bool1 = true;
        }
      }
      else
      {
        this.a.position(i + this.a.position());
        a(locala.a);
      }
    }
  }
  
  private Object[] b(Object paramObject, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramObject.getClass(), i);
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfObject;
        if (paramInt >= i) {
          break;
        }
        arrayOfObject[paramInt] = a(paramObject, 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    Object localObject = null;
    return (Object[])localObject;
  }
  
  private boolean[] c(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      localObject = new boolean[i];
      paramInt = 0;
      if (paramInt < i)
      {
        if (a((byte)0, 0, true) != 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localObject[paramInt] = paramBoolean;
          paramInt++;
          break;
        }
      }
    }
    while (!paramBoolean)
    {
      int i;
      return (boolean[])localObject;
    }
    throw new RuntimeException("require field not exist.");
  }
  
  private short[] d(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      short[] arrayOfShort = new short[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfShort;
        if (paramInt >= i) {
          break;
        }
        arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return (short[])localObject;
  }
  
  private int[] e(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      int[] arrayOfInt = new int[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfInt;
        if (paramInt >= i) {
          break;
        }
        arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return (int[])localObject;
  }
  
  private long[] f(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      long[] arrayOfLong = new long[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfLong;
        if (paramInt >= i) {
          break;
        }
        arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return (long[])localObject;
  }
  
  private float[] g(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      float[] arrayOfFloat = new float[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfFloat;
        if (paramInt >= i) {
          break;
        }
        arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return (float[])localObject;
  }
  
  private double[] h(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new RuntimeException("size invalid: " + i);
      }
      double[] arrayOfDouble = new double[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfDouble;
        if (paramInt >= i) {
          break;
        }
        arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
      }
    }
    if (paramBoolean) {
      throw new RuntimeException("require field not exist.");
    }
    return (double[])localObject;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramByte;
        paramByte = this.a.get();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramInt1;
        paramInt1 = this.a.get();
        continue;
        paramInt1 = this.a.getShort();
        continue;
        paramInt1 = this.a.getInt();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramLong;
        paramLong = this.a.get();
        continue;
        paramLong = this.a.getShort();
        continue;
        paramLong = this.a.getInt();
        continue;
        paramLong = this.a.getLong();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final bf a(bf parambf, int paramInt, boolean paramBoolean)
  {
    a locala = null;
    if (a(paramInt))
    {
      try
      {
        parambf = (bf)parambf.getClass().newInstance();
        locala = new a();
        a(locala, this.a);
        if (locala.a != 10) {
          throw new RuntimeException("type mismatch.");
        }
      }
      catch (Exception parambf)
      {
        throw new RuntimeException(parambf.getMessage());
      }
      parambf.a(this);
      a();
    }
    do
    {
      return parambf;
      parambf = locala;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  public final Object a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = false;
    if ((paramObject instanceof Byte)) {
      paramObject = Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof Boolean))
      {
        if (a((byte)0, paramInt, paramBoolean) != 0) {
          bool = true;
        }
        paramObject = Boolean.valueOf(bool);
      }
      else if ((paramObject instanceof Short))
      {
        paramObject = Short.valueOf(a((short)0, paramInt, paramBoolean));
      }
      else if ((paramObject instanceof Integer))
      {
        paramObject = Integer.valueOf(a(0, paramInt, paramBoolean));
      }
      else if ((paramObject instanceof Long))
      {
        paramObject = Long.valueOf(a(0L, paramInt, paramBoolean));
      }
      else if ((paramObject instanceof Float))
      {
        paramObject = Float.valueOf(a(0.0F, paramInt, paramBoolean));
      }
      else if ((paramObject instanceof Double))
      {
        paramObject = Double.valueOf(a(0.0D, paramInt, paramBoolean));
      }
      else if ((paramObject instanceof String))
      {
        paramObject = a(paramInt, paramBoolean);
      }
      else if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        paramObject = (HashMap)a(new HashMap(), (Map)paramObject, paramInt, paramBoolean);
      }
      else if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if ((paramObject == null) || (((List)paramObject).isEmpty()))
        {
          paramObject = new ArrayList();
        }
        else
        {
          Object[] arrayOfObject = b(((List)paramObject).get(0), paramInt, paramBoolean);
          if (arrayOfObject == null)
          {
            paramObject = null;
          }
          else
          {
            paramObject = new ArrayList();
            for (paramInt = i; paramInt < arrayOfObject.length; paramInt++) {
              ((ArrayList)paramObject).add(arrayOfObject[paramInt]);
            }
          }
        }
      }
      else if ((paramObject instanceof bf))
      {
        paramObject = a((bf)paramObject, paramInt, paramBoolean);
      }
      else
      {
        if (!paramObject.getClass().isArray()) {
          break;
        }
        if (((paramObject instanceof byte[])) || ((paramObject instanceof Byte[])))
        {
          paramObject = b(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof boolean[]))
        {
          paramObject = c(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof short[]))
        {
          paramObject = d(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof int[]))
        {
          paramObject = e(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof long[]))
        {
          paramObject = f(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof float[]))
        {
          paramObject = g(paramInt, paramBoolean);
        }
        else if ((paramObject instanceof double[]))
        {
          paramObject = h(paramInt, paramBoolean);
        }
        else
        {
          paramObject = (Object[])paramObject;
          if ((paramObject == null) || (paramObject.length == 0)) {
            throw new RuntimeException("unable to get type of key and value.");
          }
          paramObject = b(paramObject[0], paramInt, paramBoolean);
        }
      }
    }
    throw new RuntimeException("read object error: unsupport type.");
  }
  
  public final String a(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (a(paramInt))
    {
      localObject = new a();
      a((a)localObject, this.a);
      switch (((a)localObject).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 6: 
        i = this.a.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        arrayOfByte = new byte[paramInt];
        this.a.get(arrayOfByte);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        String str1;
        try
        {
          int i;
          localObject = new java/lang/String;
          ((String)localObject).<init>(arrayOfByte, this.b);
          return (String)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          str1 = new String(arrayOfByte);
          continue;
        }
        paramInt = this.a.getInt();
        if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.a.capacity())) {
          throw new RuntimeException("String too long: " + paramInt);
        }
        byte[] arrayOfByte = new byte[paramInt];
        this.a.get(arrayOfByte);
        try
        {
          str1 = new java/lang/String;
          str1.<init>(arrayOfByte, this.b);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          String str2 = new String(arrayOfByte);
        }
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  final Map a(Map paramMap1, Map paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (a(paramInt))
      {
        paramMap2 = new a();
        a(paramMap2, this.a);
        switch (paramMap2.a)
        {
        default: 
          throw new RuntimeException("type mismatch.");
        }
        int i = a(0, 0, true);
        if (i < 0) {
          throw new RuntimeException("size invalid: " + i);
        }
        for (paramInt = 0;; paramInt++)
        {
          paramMap2 = paramMap1;
          if (paramInt >= i) {
            break;
          }
          paramMap1.put(a(localObject1, 0, true), a(localObject2, 1, true));
        }
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new RuntimeException("require field not exist.");
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new a();
      a(locala, this.a);
      switch (locala.a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        a locala;
        return paramShort;
        paramShort = (short)this.a.get();
        continue;
        paramShort = this.a.getShort();
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public final byte[] b(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (a(paramInt))
    {
      localObject2 = new a();
      a((a)localObject2, this.a);
      switch (((a)localObject2).a)
      {
      default: 
        throw new RuntimeException("type mismatch.");
      case 13: 
        localObject1 = new a();
        a((a)localObject1, this.a);
        if (((a)localObject1).a != 0) {
          throw new RuntimeException("type mismatch, tag: " + paramInt + ", type: " + ((a)localObject2).a + ", " + ((a)localObject1).a);
        }
        i = a(0, 0, true);
        if ((i < 0) || (i > this.a.capacity())) {
          throw new RuntimeException("invalid size, tag: " + paramInt + ", type: " + ((a)localObject2).a + ", " + ((a)localObject1).a + ", size: " + i);
        }
        localObject1 = new byte[i];
        this.a.get((byte[])localObject1);
      }
    }
    while (!paramBoolean)
    {
      return (byte[])localObject1;
      int i = a(0, 0, true);
      if ((i < 0) || (i > this.a.capacity())) {
        throw new RuntimeException("size invalid: " + i);
      }
      Object localObject2 = new byte[i];
      for (paramInt = 0;; paramInt++)
      {
        localObject1 = localObject2;
        if (paramInt >= i) {
          break;
        }
        localObject2[paramInt] = a(localObject2[0], 0, true);
      }
    }
    throw new RuntimeException("require field not exist.");
  }
  
  public static final class a
  {
    public byte a;
    public int b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */