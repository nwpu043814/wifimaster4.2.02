package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo
  implements Comparable<FieldInfo>
{
  private final Class<?> declaringClass;
  private final Field field;
  private final Class<?> fieldClass;
  private final Type fieldType;
  private boolean getOnly = false;
  private final Method method;
  private final String name;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField)
  {
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    if (paramField != null) {
      paramField.setAccessible(true);
    }
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField)
  {
    this(paramString, paramMethod, paramField, null, null);
  }
  
  public FieldInfo(String paramString, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType)
  {
    this.name = paramString;
    this.method = paramMethod;
    this.field = paramField;
    if (paramMethod != null) {
      paramMethod.setAccessible(true);
    }
    if (paramField != null) {
      paramField.setAccessible(true);
    }
    if (paramMethod != null) {
      if (paramMethod.getParameterTypes().length == 1)
      {
        paramField = paramMethod.getParameterTypes()[0];
        paramString = paramMethod.getGenericParameterTypes()[0];
        this.declaringClass = paramMethod.getDeclaringClass();
        paramMethod = paramField;
      }
    }
    for (;;)
    {
      if ((paramClass == null) || (paramMethod != Object.class) || (!(paramString instanceof TypeVariable))) {
        break label164;
      }
      paramField = getInheritGenericType(paramClass, (TypeVariable)paramString);
      if (paramField == null) {
        break label164;
      }
      this.fieldClass = TypeUtils.getClass(paramField);
      this.fieldType = paramField;
      return;
      paramField = paramMethod.getReturnType();
      paramString = paramMethod.getGenericReturnType();
      this.getOnly = true;
      break;
      paramMethod = paramField.getType();
      paramString = paramField.getGenericType();
      this.declaringClass = paramField.getDeclaringClass();
    }
    label164:
    paramField = getFieldType(paramClass, paramType, paramString);
    if (paramField != paramString) {
      if ((paramField instanceof ParameterizedType)) {
        paramString = TypeUtils.getClass(paramField);
      }
    }
    for (;;)
    {
      this.fieldType = paramField;
      this.fieldClass = paramString;
      break;
      if ((paramField instanceof Class)) {
        paramString = TypeUtils.getClass(paramField);
      } else {
        paramString = paramMethod;
      }
    }
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2)
  {
    Object localObject1 = paramType2;
    if (paramClass != null)
    {
      if (paramType1 != null) {
        break label17;
      }
      localObject1 = paramType2;
    }
    label17:
    label101:
    do
    {
      do
      {
        return (Type)localObject1;
        localObject1 = paramType2;
      } while (!(paramType1 instanceof ParameterizedType));
      if ((paramType2 instanceof TypeVariable))
      {
        localObject2 = (ParameterizedType)paramType1;
        localObject1 = (TypeVariable)paramType2;
        for (i = 0;; i++)
        {
          if (i >= paramClass.getTypeParameters().length) {
            break label101;
          }
          if (paramClass.getTypeParameters()[i].getName().equals(((TypeVariable)localObject1).getName()))
          {
            localObject1 = localObject2.getActualTypeArguments()[i];
            break;
          }
        }
      }
      localObject1 = paramType2;
    } while (!(paramType2 instanceof ParameterizedType));
    ParameterizedType localParameterizedType1 = (ParameterizedType)paramType2;
    Object localObject2 = localParameterizedType1.getActualTypeArguments();
    int j = 0;
    int i = 0;
    label131:
    if (j < localObject2.length)
    {
      localObject1 = localObject2[j];
      if (!(localObject1 instanceof TypeVariable)) {
        break label276;
      }
      localObject1 = (TypeVariable)localObject1;
      if (!(paramType1 instanceof ParameterizedType)) {
        break label276;
      }
      ParameterizedType localParameterizedType2 = (ParameterizedType)paramType1;
      for (int k = 0; k < paramClass.getTypeParameters().length; k++) {
        if (paramClass.getTypeParameters()[k].getName().equals(((TypeVariable)localObject1).getName()))
        {
          localObject2[j] = localParameterizedType2.getActualTypeArguments()[k];
          i = 1;
        }
      }
    }
    label276:
    for (;;)
    {
      j++;
      break label131;
      localObject1 = paramType2;
      if (i == 0) {
        break;
      }
      localObject1 = new ParameterizedTypeImpl((Type[])localObject2, localParameterizedType1.getOwnerType(), localParameterizedType1.getRawType());
      break;
    }
  }
  
  public static Type getInheritGenericType(Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Object localObject = paramTypeVariable.getGenericDeclaration();
    Type localType = paramClass.getGenericSuperclass();
    if (localType == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      if ((localType instanceof ParameterizedType))
      {
        paramClass = (ParameterizedType)localType;
        if (paramClass.getRawType() == localObject)
        {
          localObject = ((GenericDeclaration)localObject).getTypeParameters();
          paramClass = paramClass.getActualTypeArguments();
          for (int i = 0;; i++)
          {
            if (i >= localObject.length) {
              break label88;
            }
            if (localObject[i] == paramTypeVariable)
            {
              paramClass = paramClass[i];
              break;
            }
          }
          label88:
          paramClass = null;
          continue;
        }
      }
      paramClass = TypeUtils.getClass(localType);
      if (localType != null) {
        break;
      }
      paramClass = null;
    }
  }
  
  public int compareTo(FieldInfo paramFieldInfo)
  {
    return this.name.compareTo(paramFieldInfo.name);
  }
  
  public Object get(Object paramObject)
  {
    if (this.method != null) {}
    for (paramObject = this.method.invoke(paramObject, new Object[0]);; paramObject = this.field.get(paramObject)) {
      return paramObject;
    }
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Annotation localAnnotation1 = null;
    if (this.method != null) {
      localAnnotation1 = this.method.getAnnotation(paramClass);
    }
    Annotation localAnnotation2 = localAnnotation1;
    if (localAnnotation1 == null)
    {
      localAnnotation2 = localAnnotation1;
      if (this.field != null) {
        localAnnotation2 = this.field.getAnnotation(paramClass);
      }
    }
    return localAnnotation2;
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.declaringClass;
  }
  
  public Field getField()
  {
    return this.field;
  }
  
  public Class<?> getFieldClass()
  {
    return this.fieldClass;
  }
  
  public Type getFieldType()
  {
    return this.fieldType;
  }
  
  public String getFormat()
  {
    Object localObject = (JSONField)getAnnotation(JSONField.class);
    if (localObject != null)
    {
      String str = ((JSONField)localObject).format();
      localObject = str;
      if (str.trim().length() != 0) {}
    }
    for (localObject = null;; localObject = null) {
      return (String)localObject;
    }
  }
  
  public Method getMethod()
  {
    return this.method;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isGetOnly()
  {
    return this.getOnly;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    if (this.method != null) {
      this.method.invoke(paramObject1, new Object[] { paramObject2 });
    }
    for (;;)
    {
      return;
      this.field.set(paramObject1, paramObject2);
    }
  }
  
  public void setAccessible(boolean paramBoolean)
  {
    if (this.method != null) {
      this.method.setAccessible(paramBoolean);
    }
    for (;;)
    {
      return;
      this.field.setAccessible(paramBoolean);
    }
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */