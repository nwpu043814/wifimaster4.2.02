package com.b.a;

import com.b.a.b.a;
import com.b.a.b.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class l
{
  private static final c<ax<Class<?>, String>, Collection<Annotation>> a = new an(g());
  private final Class<?> b;
  private final Field c;
  private final Class<?> d;
  private final boolean e;
  private final int f;
  private final String g;
  private final Type h;
  private Type i;
  private Collection<Annotation> j;
  
  l(Class<?> paramClass, Field paramField, Type paramType)
  {
    this.b = ((Class)a.a(paramClass));
    this.g = paramField.getName();
    this.d = paramField.getType();
    this.e = paramField.isSynthetic();
    this.f = paramField.getModifiers();
    this.c = paramField;
    paramClass = b.b(paramType);
    if (!paramField.getDeclaringClass().isAssignableFrom(paramClass)) {}
    for (paramClass = paramField.getGenericType();; paramClass = b.a(paramType, paramClass, paramField.getGenericType()))
    {
      this.h = paramClass;
      return;
    }
  }
  
  private static int g()
  {
    try
    {
      k = Integer.parseInt(System.getProperty("com.google.gson.annotation_cache_size_hint", "2000"));
      return k;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int k = 2000;
      }
    }
  }
  
  final Object a(Object paramObject)
  {
    return this.c.get(paramObject);
  }
  
  public final String a()
  {
    return this.g;
  }
  
  public final <T extends Annotation> T a(Class<T> paramClass)
  {
    Iterator localIterator = d().iterator();
    Annotation localAnnotation;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localAnnotation = (Annotation)localIterator.next();
    } while (localAnnotation.annotationType() != paramClass);
    for (paramClass = localAnnotation;; paramClass = null) {
      return paramClass;
    }
  }
  
  final void a(Object paramObject1, Object paramObject2)
  {
    this.c.set(paramObject1, paramObject2);
  }
  
  public final boolean a(int paramInt)
  {
    if ((this.f & paramInt) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Type b()
  {
    if (this.i == null) {
      this.i = this.c.getGenericType();
    }
    return this.i;
  }
  
  public final Class<?> c()
  {
    return this.d;
  }
  
  public final Collection<Annotation> d()
  {
    if (this.j == null)
    {
      ax localax = new ax(this.b, this.g);
      this.j = ((Collection)a.a(localax));
      if (this.j == null)
      {
        this.j = Collections.unmodifiableCollection(Arrays.asList(this.c.getAnnotations()));
        a.a(localax, this.j);
      }
    }
    return this.j;
  }
  
  final boolean e()
  {
    return this.e;
  }
  
  final Type f()
  {
    return this.h;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */