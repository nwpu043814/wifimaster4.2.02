package com.b.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b
{
  static final Type[] a = new Type[0];
  
  public static Type a(Type paramType)
  {
    Object localObject;
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      localObject = paramType;
      if (paramType.isArray()) {
        localObject = new a(a(paramType.getComponentType()));
      }
    }
    for (;;)
    {
      return (Type)localObject;
      if ((paramType instanceof ParameterizedType))
      {
        paramType = (ParameterizedType)paramType;
        localObject = new b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localObject = new a(((GenericArrayType)paramType).getGenericComponentType());
      }
      else
      {
        localObject = paramType;
        if ((paramType instanceof WildcardType))
        {
          paramType = (WildcardType)paramType;
          localObject = new c(paramType.getUpperBounds(), paramType.getLowerBounds());
        }
      }
    }
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    return ((ParameterizedType)b(paramType, paramClass, java.util.Collection.class)).getActualTypeArguments()[0];
  }
  
  private static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject = paramClass1;
    paramClass1 = paramType;
    paramType = (Type)localObject;
    if (paramClass2 == paramType) {}
    label13:
    label91:
    do
    {
      return paramClass1;
      if (paramClass2.isInterface())
      {
        localObject = paramType.getInterfaces();
        int i = 0;
        int j = localObject.length;
        for (;;)
        {
          if (i >= j) {
            break label91;
          }
          if (localObject[i] == paramClass2)
          {
            paramClass1 = paramType.getGenericInterfaces()[i];
            break label13;
          }
          if (paramClass2.isAssignableFrom(localObject[i]))
          {
            paramClass1 = paramType.getGenericInterfaces()[i];
            paramType = localObject[i];
            break;
          }
          i++;
        }
      }
      paramClass1 = paramClass2;
    } while (paramType.isInterface());
    for (localObject = paramType;; localObject = paramType)
    {
      paramClass1 = paramClass2;
      if (localObject == Object.class) {
        break label13;
      }
      paramType = ((Class)localObject).getSuperclass();
      if (paramType == paramClass2)
      {
        paramClass1 = ((Class)localObject).getGenericSuperclass();
        break label13;
      }
      if (paramClass2.isAssignableFrom(paramType))
      {
        paramClass1 = ((Class)localObject).getGenericSuperclass();
        break;
      }
    }
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    int k = 0;
    Object localObject1 = paramType2;
    Object localObject2;
    int i;
    label68:
    label98:
    do
    {
      if (!(localObject1 instanceof TypeVariable)) {
        break label134;
      }
      localObject2 = (TypeVariable)localObject1;
      paramType2 = ((TypeVariable)localObject2).getGenericDeclaration();
      if (!(paramType2 instanceof Class)) {
        break;
      }
      paramType2 = (Class)paramType2;
      if (paramType2 == null) {
        break label128;
      }
      localObject1 = a(paramType1, paramClass, paramType2);
      if (!(localObject1 instanceof ParameterizedType)) {
        break label128;
      }
      paramType2 = paramType2.getTypeParameters();
      i = 0;
      if (i >= paramType2.length) {
        break label120;
      }
      if (!localObject2.equals(paramType2[i])) {
        break label114;
      }
      paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments()[i];
      localObject1 = paramType2;
    } while (paramType2 != localObject2);
    for (;;)
    {
      return paramType2;
      paramType2 = null;
      break;
      label114:
      i++;
      break label68;
      label120:
      throw new NoSuchElementException();
      label128:
      paramType2 = (Type)localObject2;
      break label98;
      label134:
      if (((localObject1 instanceof Class)) && (((Class)localObject1).isArray()))
      {
        paramType2 = (Class)localObject1;
        localObject1 = paramType2.getComponentType();
        paramType1 = a(paramType1, paramClass, (Type)localObject1);
        if (localObject1 != paramType1) {
          paramType2 = g(paramType1);
        }
      }
      else if ((localObject1 instanceof GenericArrayType))
      {
        paramType2 = (GenericArrayType)localObject1;
        localObject1 = paramType2.getGenericComponentType();
        paramType1 = a(paramType1, paramClass, (Type)localObject1);
        if (localObject1 != paramType1) {
          paramType2 = g(paramType1);
        }
      }
      else
      {
        Object localObject3;
        if ((localObject1 instanceof ParameterizedType))
        {
          localObject2 = (ParameterizedType)localObject1;
          paramType2 = ((ParameterizedType)localObject2).getOwnerType();
          localObject3 = a(paramType1, paramClass, paramType2);
          if (localObject3 != paramType2) {}
          for (i = 1;; i = 0)
          {
            localObject1 = ((ParameterizedType)localObject2).getActualTypeArguments();
            int m = localObject1.length;
            while (k < m)
            {
              Type localType = a(paramType1, paramClass, localObject1[k]);
              int j = i;
              paramType2 = (Type)localObject1;
              if (localType != localObject1[k])
              {
                j = i;
                paramType2 = (Type)localObject1;
                if (i == 0)
                {
                  paramType2 = (Type[])((Type[])localObject1).clone();
                  j = 1;
                }
                paramType2[k] = localType;
              }
              k++;
              i = j;
              localObject1 = paramType2;
            }
          }
          paramType2 = (Type)localObject2;
          if (i != 0) {
            paramType2 = new b((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), (Type[])localObject1);
          }
        }
        else
        {
          paramType2 = (Type)localObject1;
          if ((localObject1 instanceof WildcardType))
          {
            localObject1 = (WildcardType)localObject1;
            localObject3 = ((WildcardType)localObject1).getLowerBounds();
            localObject2 = ((WildcardType)localObject1).getUpperBounds();
            if (localObject3.length == 1)
            {
              paramType1 = a(paramType1, paramClass, localObject3[0]);
              paramType2 = (Type)localObject1;
              if (paramType1 != localObject3[0]) {
                paramType2 = new c(new Type[] { Object.class }, new Type[] { paramType1 });
              }
            }
            else
            {
              paramType2 = (Type)localObject1;
              if (localObject2.length == 1)
              {
                paramType1 = a(paramType1, paramClass, localObject2[0]);
                paramType2 = (Type)localObject1;
                if (paramType1 != localObject2[0])
                {
                  paramClass = a;
                  paramType2 = new c(new Type[] { paramType1 }, paramClass);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    Object localObject = paramType2;
    paramType2 = paramType1;
    paramType1 = (Type)localObject;
    boolean bool;
    if (paramType2 == paramType1) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramType2 instanceof Class))
      {
        bool = paramType2.equals(paramType1);
      }
      else if ((paramType2 instanceof ParameterizedType))
      {
        if (!(paramType1 instanceof ParameterizedType))
        {
          bool = false;
        }
        else
        {
          paramType2 = (ParameterizedType)paramType2;
          localObject = (ParameterizedType)paramType1;
          Type localType = paramType2.getOwnerType();
          paramType1 = ((ParameterizedType)localObject).getOwnerType();
          if ((localType == paramType1) || ((localType != null) && (localType.equals(paramType1)))) {}
          for (int i = 1;; i = 0)
          {
            if ((i == 0) || (!paramType2.getRawType().equals(((ParameterizedType)localObject).getRawType())) || (!Arrays.equals(paramType2.getActualTypeArguments(), ((ParameterizedType)localObject).getActualTypeArguments()))) {
              break label153;
            }
            bool = true;
            break;
          }
          label153:
          bool = false;
        }
      }
      else
      {
        if ((paramType2 instanceof GenericArrayType))
        {
          if (!(paramType1 instanceof GenericArrayType))
          {
            bool = false;
            continue;
          }
          paramType2 = (GenericArrayType)paramType2;
          paramType1 = (GenericArrayType)paramType1;
          paramType2 = paramType2.getGenericComponentType();
          paramType1 = paramType1.getGenericComponentType();
          break;
        }
        if ((paramType2 instanceof WildcardType))
        {
          if (!(paramType1 instanceof WildcardType))
          {
            bool = false;
          }
          else
          {
            paramType2 = (WildcardType)paramType2;
            paramType1 = (WildcardType)paramType1;
            if ((Arrays.equals(paramType2.getUpperBounds(), paramType1.getUpperBounds())) && (Arrays.equals(paramType2.getLowerBounds(), paramType1.getLowerBounds()))) {
              bool = true;
            } else {
              bool = false;
            }
          }
        }
        else if ((paramType2 instanceof TypeVariable))
        {
          if (!(paramType1 instanceof TypeVariable))
          {
            bool = false;
          }
          else
          {
            paramType2 = (TypeVariable)paramType2;
            paramType1 = (TypeVariable)paramType1;
            if ((paramType2.getGenericDeclaration() == paramType1.getGenericDeclaration()) && (paramType2.getName().equals(paramType1.getName()))) {
              bool = true;
            } else {
              bool = false;
            }
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  public static Class<?> b(Type paramType)
  {
    for (;;)
    {
      if ((paramType instanceof Class)) {
        paramType = (Class)paramType;
      }
      for (;;)
      {
        return paramType;
        if ((paramType instanceof ParameterizedType))
        {
          paramType = ((ParameterizedType)paramType).getRawType();
          a.a(paramType instanceof Class);
          paramType = (Class)paramType;
        }
        else if ((paramType instanceof GenericArrayType))
        {
          paramType = Array.newInstance(b(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
        }
        else
        {
          if (!(paramType instanceof TypeVariable)) {
            break;
          }
          paramType = Object.class;
        }
      }
      if (!(paramType instanceof WildcardType)) {
        break;
      }
      paramType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName()) {
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
    }
  }
  
  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    a.a(paramClass2.isAssignableFrom(paramClass1));
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class)
    {
      paramType = new Type[2];
      paramType[0] = String.class;
      paramType[1] = String.class;
    }
    for (;;)
    {
      return paramType;
      paramType = ((ParameterizedType)b(paramType, paramClass, Map.class)).getActualTypeArguments();
    }
  }
  
  public static String c(Type paramType)
  {
    if ((paramType instanceof Class)) {}
    for (paramType = ((Class)paramType).getName();; paramType = paramType.toString()) {
      return paramType;
    }
  }
  
  public static boolean d(Type paramType)
  {
    if (((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Type e(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {}
    for (paramType = ((GenericArrayType)paramType).getGenericComponentType();; paramType = ((Class)paramType).getComponentType()) {
      return paramType;
    }
  }
  
  private static GenericArrayType g(Type paramType)
  {
    return new a(paramType);
  }
  
  private static final class a
    implements Serializable, GenericArrayType
  {
    private final Type a;
    
    public a(Type paramType)
    {
      this.a = b.a(paramType);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (((paramObject instanceof GenericArrayType)) && (b.a(this, (GenericArrayType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final Type getGenericComponentType()
    {
      return this.a;
    }
    
    public final int hashCode()
    {
      return this.a.hashCode();
    }
    
    public final String toString()
    {
      return b.c(this.a) + "[]";
    }
  }
  
  private static final class b
    implements Serializable, ParameterizedType
  {
    private final Type a;
    private final Type b;
    private final Type[] c;
    
    public b(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
        {
          bool1 = true;
          a.a(bool1);
          bool1 = bool2;
          if (paramType1 != null)
          {
            if (localClass.getEnclosingClass() == null) {
              break label158;
            }
            bool1 = bool2;
          }
          label63:
          a.a(bool1);
        }
      }
      else
      {
        if (paramType1 != null) {
          break label164;
        }
      }
      label158:
      label164:
      for (paramType1 = null;; paramType1 = b.a(paramType1))
      {
        this.a = paramType1;
        this.b = b.a(paramType2);
        this.c = ((Type[])paramVarArgs.clone());
        while (i < this.c.length)
        {
          a.a(this.c[i]);
          b.f(this.c[i]);
          this.c[i] = b.a(this.c[i]);
          i++;
        }
        bool1 = false;
        break;
        bool1 = false;
        break label63;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (((paramObject instanceof ParameterizedType)) && (b.a(this, (ParameterizedType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final Type[] getActualTypeArguments()
    {
      return (Type[])this.c.clone();
    }
    
    public final Type getOwnerType()
    {
      return this.a;
    }
    
    public final Type getRawType()
    {
      return this.b;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ b.a(this.a);
    }
    
    public final String toString()
    {
      Object localObject = new StringBuilder((this.c.length + 1) * 30);
      ((StringBuilder)localObject).append(b.c(this.b));
      if (this.c.length == 0) {}
      for (localObject = ((StringBuilder)localObject).toString();; localObject = ">")
      {
        return (String)localObject;
        ((StringBuilder)localObject).append("<").append(b.c(this.c[0]));
        for (int i = 1; i < this.c.length; i++) {
          ((StringBuilder)localObject).append(", ").append(b.c(this.c[i]));
        }
      }
    }
  }
  
  private static final class c
    implements Serializable, WildcardType
  {
    private final Type a;
    private final Type b;
    
    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      boolean bool1;
      if (paramArrayOfType2.length <= 1)
      {
        bool1 = true;
        a.a(bool1);
        if (paramArrayOfType1.length != 1) {
          break label87;
        }
        bool1 = true;
        label27:
        a.a(bool1);
        if (paramArrayOfType2.length != 1) {
          break label97;
        }
        a.a(paramArrayOfType2[0]);
        b.f(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          break label92;
        }
        bool1 = bool2;
        label61:
        a.a(bool1);
        this.b = b.a(paramArrayOfType2[0]);
      }
      for (this.a = Object.class;; this.a = b.a(paramArrayOfType1[0]))
      {
        return;
        bool1 = false;
        break;
        label87:
        bool1 = false;
        break label27;
        label92:
        bool1 = false;
        break label61;
        label97:
        a.a(paramArrayOfType1[0]);
        b.f(paramArrayOfType1[0]);
        this.b = null;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (((paramObject instanceof WildcardType)) && (b.a(this, (WildcardType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final Type[] getLowerBounds()
    {
      Type[] arrayOfType;
      if (this.b != null)
      {
        arrayOfType = new Type[1];
        arrayOfType[0] = this.b;
      }
      for (;;)
      {
        return arrayOfType;
        arrayOfType = b.a;
      }
    }
    
    public final Type[] getUpperBounds()
    {
      return new Type[] { this.a };
    }
    
    public final int hashCode()
    {
      if (this.b != null) {}
      for (int i = this.b.hashCode() + 31;; i = 1) {
        return i ^ this.a.hashCode() + 31;
      }
    }
    
    public final String toString()
    {
      String str;
      if (this.b != null) {
        str = "? super " + b.c(this.b);
      }
      for (;;)
      {
        return str;
        if (this.a == Object.class) {
          str = "?";
        } else {
          str = "? extends " + b.c(this.a);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */