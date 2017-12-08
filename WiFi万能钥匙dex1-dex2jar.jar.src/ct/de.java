package ct;

import java.util.Iterator;

public final class de
{
  private final String a;
  
  private de(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a = paramString;
  }
  
  public static de a(String paramString)
  {
    return new de(paramString);
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    Object localObject;
    if (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramStringBuilder.append(localObject.toString());
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramStringBuilder.append(this.a);
        paramStringBuilder.append(localObject.toString());
      }
    }
    return paramStringBuilder;
  }
  
  public final String a(Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    return a(new StringBuilder(), paramIterable).toString();
  }
  
  public final String a(Object paramObject1, Object paramObject2, Object... paramVarArgs)
  {
    return a(new de.1(paramObject1, paramObject2, paramVarArgs));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */