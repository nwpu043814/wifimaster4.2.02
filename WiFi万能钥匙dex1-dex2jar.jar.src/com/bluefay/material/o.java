package com.bluefay.material;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class o
{
  static final c a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 5) {}
    for (a = new b();; a = new a()) {
      return;
    }
  }
  
  public static int a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }
  
  public static int a(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.a(paramMotionEvent, paramInt);
  }
  
  public static int b(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.b(paramMotionEvent, paramInt);
  }
  
  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.c(paramMotionEvent, paramInt);
  }
  
  static final class a
    implements o.c
  {
    public final int a(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {}
      for (paramInt = 0;; paramInt = -1) {
        return paramInt;
      }
    }
    
    public final int b(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public final float c(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getY();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
  }
  
  static final class b
    implements o.c
  {
    public final int a(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.findPointerIndex(paramInt);
    }
    
    public final int b(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getPointerId(paramInt);
    }
    
    public final float c(MotionEvent paramMotionEvent, int paramInt)
    {
      return paramMotionEvent.getY(paramInt);
    }
  }
  
  static abstract interface c
  {
    public abstract int a(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int b(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float c(MotionEvent paramMotionEvent, int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */