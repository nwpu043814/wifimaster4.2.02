package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import java.beans.Introspector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class DeserializeBeanInfo
{
  private final Class<?> clazz;
  private Constructor<?> creatorConstructor;
  private Constructor<?> defaultConstructor;
  private Method factoryMethod;
  private final List<FieldInfo> fieldList = new ArrayList();
  private final List<FieldInfo> sortedFieldList = new ArrayList();
  
  public DeserializeBeanInfo(Class<?> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public static DeserializeBeanInfo computeSetters(Class<?> paramClass, Type paramType)
  {
    DeserializeBeanInfo localDeserializeBeanInfo = new DeserializeBeanInfo(paramClass);
    Object localObject1 = getDefaultConstructor(paramClass);
    if (localObject1 != null)
    {
      ((Constructor)localObject1).setAccessible(true);
      localDeserializeBeanInfo.setDefaultConstructor((Constructor)localObject1);
    }
    Object localObject5;
    int j;
    int i;
    Object localObject4;
    Object localObject3;
    while ((localObject1 != null) || (paramClass.isInterface()) || (Modifier.isAbstract(paramClass.getModifiers())))
    {
      localObject5 = paramClass.getMethods();
      j = localObject5.length;
      for (i = 0;; i++)
      {
        if (i >= j) {
          break label877;
        }
        localObject4 = localObject5[i];
        localObject3 = ((Method)localObject4).getName();
        if ((((String)localObject3).length() >= 4) && (!Modifier.isStatic(((Method)localObject4).getModifiers())) && ((((Method)localObject4).getReturnType().equals(Void.TYPE)) || (((Method)localObject4).getReturnType().equals(paramClass))) && (((Method)localObject4).getParameterTypes().length == 1))
        {
          localObject2 = (JSONField)((Method)localObject4).getAnnotation(JSONField.class);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = TypeUtils.getSupperMethodAnnotation(paramClass, (Method)localObject4);
          }
          if (localObject1 == null) {
            break;
          }
          if (((JSONField)localObject1).deserialize())
          {
            if (((JSONField)localObject1).name().length() == 0) {
              break;
            }
            localDeserializeBeanInfo.add(new FieldInfo(((JSONField)localObject1).name(), (Method)localObject4, null, paramClass, paramType));
            ((Method)localObject4).setAccessible(true);
          }
        }
      }
    }
    Object localObject2 = getCreatorConstructor(paramClass);
    int k;
    if (localObject2 != null)
    {
      ((Constructor)localObject2).setAccessible(true);
      localDeserializeBeanInfo.setCreatorConstructor((Constructor)localObject2);
      for (i = 0; i < ((Constructor)localObject2).getParameterTypes().length; i++)
      {
        localObject3 = localObject2.getParameterAnnotations()[i];
        localObject1 = null;
        k = localObject3.length;
        for (j = 0;; j++)
        {
          paramType = (Type)localObject1;
          if (j < k)
          {
            paramType = localObject3[j];
            if ((paramType instanceof JSONField)) {
              paramType = (JSONField)paramType;
            }
          }
          else
          {
            if (paramType != null) {
              break;
            }
            throw new JSONException("illegal json creator");
          }
        }
        localObject4 = localObject2.getParameterTypes()[i];
        localObject1 = localObject2.getGenericParameterTypes()[i];
        localObject3 = getField(paramClass, paramType.name());
        localDeserializeBeanInfo.add(new FieldInfo(paramType.name(), paramClass, (Class)localObject4, (Type)localObject1, (Field)localObject3));
      }
    }
    for (;;)
    {
      return localDeserializeBeanInfo;
      localObject2 = getFactoryMethod(paramClass);
      if (localObject2 != null)
      {
        ((Method)localObject2).setAccessible(true);
        localDeserializeBeanInfo.setFactoryMethod((Method)localObject2);
        for (i = 0; i < ((Method)localObject2).getParameterTypes().length; i++)
        {
          localObject3 = localObject2.getParameterAnnotations()[i];
          localObject1 = null;
          k = localObject3.length;
          for (j = 0;; j++)
          {
            paramType = (Type)localObject1;
            if (j < k)
            {
              paramType = localObject3[j];
              if ((paramType instanceof JSONField)) {
                paramType = (JSONField)paramType;
              }
            }
            else
            {
              if (paramType != null) {
                break;
              }
              throw new JSONException("illegal json creator");
            }
          }
          localObject4 = localObject2.getParameterTypes()[i];
          localObject1 = localObject2.getGenericParameterTypes()[i];
          localObject3 = getField(paramClass, paramType.name());
          localDeserializeBeanInfo.add(new FieldInfo(paramType.name(), paramClass, (Class)localObject4, (Type)localObject1, (Field)localObject3));
        }
      }
      else
      {
        throw new JSONException("default constructor not found. " + paramClass);
        if (!((String)localObject3).startsWith("set")) {
          break;
        }
        char c = ((String)localObject3).charAt(3);
        if (Character.isUpperCase(c)) {
          if (TypeUtils.compatibleWithJavaBean) {
            localObject1 = Introspector.decapitalize(((String)localObject3).substring(3));
          }
        }
        for (;;)
        {
          localObject3 = getField(paramClass, (String)localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = localObject3;
            if (localObject4.getParameterTypes()[0] == Boolean.TYPE) {
              localObject2 = getField(paramClass, "is" + Character.toUpperCase(((String)localObject1).charAt(0)) + ((String)localObject1).substring(1));
            }
          }
          if (localObject2 == null) {
            break label848;
          }
          localObject3 = (JSONField)((Field)localObject2).getAnnotation(JSONField.class);
          if ((localObject3 == null) || (((JSONField)localObject3).name().length() == 0)) {
            break label848;
          }
          localDeserializeBeanInfo.add(new FieldInfo(((JSONField)localObject3).name(), (Method)localObject4, (Field)localObject2, paramClass, paramType));
          break;
          localObject1 = Character.toLowerCase(((String)localObject3).charAt(3)) + ((String)localObject3).substring(4);
          continue;
          if (c == '_')
          {
            localObject1 = ((String)localObject3).substring(4);
          }
          else
          {
            if (c != 'f') {
              break;
            }
            localObject1 = ((String)localObject3).substring(3);
          }
        }
        label848:
        localDeserializeBeanInfo.add(new FieldInfo((String)localObject1, (Method)localObject4, null, paramClass, paramType));
        ((Method)localObject4).setAccessible(true);
        break;
        label877:
        for (localObject3 : paramClass.getFields()) {
          if (!Modifier.isStatic(((Field)localObject3).getModifiers()))
          {
            localObject1 = localDeserializeBeanInfo.getFieldList().iterator();
            j = 0;
            while (((Iterator)localObject1).hasNext()) {
              if (((FieldInfo)((Iterator)localObject1).next()).getName().equals(((Field)localObject3).getName())) {
                j = 1;
              }
            }
            if (j == 0)
            {
              localObject2 = ((Field)localObject3).getName();
              localObject5 = (JSONField)((Field)localObject3).getAnnotation(JSONField.class);
              localObject1 = localObject2;
              if (localObject5 != null)
              {
                localObject1 = localObject2;
                if (((JSONField)localObject5).name().length() != 0) {
                  localObject1 = ((JSONField)localObject5).name();
                }
              }
              localDeserializeBeanInfo.add(new FieldInfo((String)localObject1, null, (Field)localObject3, paramClass, paramType));
            }
          }
        }
        for (localObject2 : paramClass.getMethods())
        {
          localObject3 = ((Method)localObject2).getName();
          if ((((String)localObject3).length() >= 4) && (!Modifier.isStatic(((Method)localObject2).getModifiers())) && (((String)localObject3).startsWith("get")) && (Character.isUpperCase(((String)localObject3).charAt(3))) && (((Method)localObject2).getParameterTypes().length == 0) && ((Collection.class.isAssignableFrom(((Method)localObject2).getReturnType())) || (Map.class.isAssignableFrom(((Method)localObject2).getReturnType())) || (AtomicBoolean.class == ((Method)localObject2).getReturnType()) || (AtomicInteger.class == ((Method)localObject2).getReturnType()) || (AtomicLong.class == ((Method)localObject2).getReturnType())))
          {
            localObject3 = Character.toLowerCase(((String)localObject3).charAt(3)) + ((String)localObject3).substring(4);
            if (localDeserializeBeanInfo.getField((String)localObject3) == null)
            {
              localDeserializeBeanInfo.add(new FieldInfo((String)localObject3, (Method)localObject2, null, paramClass, paramType));
              ((Method)localObject2).setAccessible(true);
            }
          }
        }
      }
    }
  }
  
  public static Constructor<?> getCreatorConstructor(Class<?> paramClass)
  {
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    if (i < j)
    {
      paramClass = arrayOfConstructor[i];
      if ((JSONCreator)paramClass.getAnnotation(JSONCreator.class) == null) {}
    }
    for (;;)
    {
      return paramClass;
      i++;
      break;
      paramClass = null;
    }
  }
  
  public static Constructor<?> getDefaultConstructor(Class<?> paramClass)
  {
    Object localObject2 = null;
    if (Modifier.isAbstract(paramClass.getModifiers())) {
      return (Constructor<?>)localObject2;
    }
    localObject2 = paramClass.getDeclaredConstructors();
    int j = localObject2.length;
    int i = 0;
    label28:
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject2[i];
      if (((Constructor)localObject1).getParameterTypes().length != 0) {}
    }
    for (;;)
    {
      if ((localObject1 == null) && (paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers())))
      {
        Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
        j = arrayOfConstructor.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            Constructor localConstructor = arrayOfConstructor[i];
            if (localConstructor.getParameterTypes().length == 1)
            {
              localObject2 = localConstructor;
              if (localConstructor.getParameterTypes()[0].equals(paramClass.getDeclaringClass())) {
                break;
              }
            }
            i++;
            continue;
            i++;
            break label28;
          }
        }
      }
      localObject2 = localObject1;
      break;
      localObject1 = null;
    }
  }
  
  public static Method getFactoryMethod(Class<?> paramClass)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Method localMethod;
    if (i < j)
    {
      localMethod = arrayOfMethod[i];
      if ((!Modifier.isStatic(localMethod.getModifiers())) || (!paramClass.isAssignableFrom(localMethod.getReturnType())) || ((JSONCreator)localMethod.getAnnotation(JSONCreator.class) == null)) {}
    }
    for (paramClass = localMethod;; paramClass = null)
    {
      return paramClass;
      i++;
      break;
    }
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  public boolean add(FieldInfo paramFieldInfo)
  {
    Iterator localIterator = this.fieldList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((FieldInfo)localIterator.next()).getName().equals(paramFieldInfo.getName()));
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.fieldList.add(paramFieldInfo);
      this.sortedFieldList.add(paramFieldInfo);
      Collections.sort(this.sortedFieldList);
    }
  }
  
  public Class<?> getClazz()
  {
    return this.clazz;
  }
  
  public Constructor<?> getCreatorConstructor()
  {
    return this.creatorConstructor;
  }
  
  public Constructor<?> getDefaultConstructor()
  {
    return this.defaultConstructor;
  }
  
  public Method getFactoryMethod()
  {
    return this.factoryMethod;
  }
  
  public FieldInfo getField(String paramString)
  {
    Iterator localIterator = this.fieldList.iterator();
    FieldInfo localFieldInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localFieldInfo = (FieldInfo)localIterator.next();
    } while (!localFieldInfo.getName().equals(paramString));
    for (paramString = localFieldInfo;; paramString = null) {
      return paramString;
    }
  }
  
  public List<FieldInfo> getFieldList()
  {
    return this.fieldList;
  }
  
  public List<FieldInfo> getSortedFieldList()
  {
    return this.sortedFieldList;
  }
  
  public void setCreatorConstructor(Constructor<?> paramConstructor)
  {
    this.creatorConstructor = paramConstructor;
  }
  
  public void setDefaultConstructor(Constructor<?> paramConstructor)
  {
    this.defaultConstructor = paramConstructor;
  }
  
  public void setFactoryMethod(Method paramMethod)
  {
    this.factoryMethod = paramMethod;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/DeserializeBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */