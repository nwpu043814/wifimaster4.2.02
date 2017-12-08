package bluefay.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

abstract class d<T, P extends b>
{
  private static final Class[] d = { Context.class, AttributeSet.class };
  private static final HashMap e = new HashMap();
  protected final Context a;
  private a<T> b;
  private final Object[] c = new Object[2];
  private String f;
  
  protected d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  private final T a(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 55	bluefay/preference/d:b	Lbluefay/preference/d$a;
    //   6: ifnonnull +35 -> 41
    //   9: aload_3
    //   10: astore 4
    //   12: aload_3
    //   13: ifnonnull +25 -> 38
    //   16: iconst_m1
    //   17: aload_1
    //   18: bipush 46
    //   20: invokevirtual 61	java/lang/String:indexOf	(I)I
    //   23: if_icmpne +31 -> 54
    //   26: aload_0
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 63	bluefay/preference/d:f	Ljava/lang/String;
    //   32: aload_2
    //   33: invokespecial 66	bluefay/preference/d:a	(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Ljava/lang/Object;
    //   36: astore 4
    //   38: aload 4
    //   40: areturn
    //   41: aload_0
    //   42: getfield 55	bluefay/preference/d:b	Lbluefay/preference/d$a;
    //   45: invokeinterface 69 1 0
    //   50: astore_3
    //   51: goto -42 -> 9
    //   54: aload_0
    //   55: aload_1
    //   56: aconst_null
    //   57: aload_2
    //   58: invokespecial 66	bluefay/preference/d:a	(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Ljava/lang/Object;
    //   61: astore 4
    //   63: goto -25 -> 38
    //   66: astore_1
    //   67: aload_1
    //   68: athrow
    //   69: astore_3
    //   70: new 49	android/view/InflateException
    //   73: dup
    //   74: new 71	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   81: aload_2
    //   82: invokeinterface 76 1 0
    //   87: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 82
    //   92: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 88	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_1
    //   107: aload_3
    //   108: invokevirtual 92	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   111: pop
    //   112: aload_1
    //   113: athrow
    //   114: astore_3
    //   115: new 49	android/view/InflateException
    //   118: dup
    //   119: new 71	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   126: aload_2
    //   127: invokeinterface 76 1 0
    //   132: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 82
    //   137: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 88	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   150: astore_1
    //   151: aload_1
    //   152: aload_3
    //   153: invokevirtual 92	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   156: pop
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	d
    //   0	159	1	paramString	String
    //   0	159	2	paramAttributeSet	AttributeSet
    //   1	50	3	localObject1	Object
    //   69	39	3	localClassNotFoundException	ClassNotFoundException
    //   114	39	3	localException	Exception
    //   10	52	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	66	android/view/InflateException
    //   16	38	66	android/view/InflateException
    //   41	51	66	android/view/InflateException
    //   54	63	66	android/view/InflateException
    //   2	9	69	java/lang/ClassNotFoundException
    //   16	38	69	java/lang/ClassNotFoundException
    //   41	51	69	java/lang/ClassNotFoundException
    //   54	63	69	java/lang/ClassNotFoundException
    //   2	9	114	java/lang/Exception
    //   16	38	114	java/lang/Exception
    //   41	51	114	java/lang/Exception
    //   54	63	114	java/lang/Exception
  }
  
  /* Error */
  private T a(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: getstatic 39	bluefay/preference/d:e	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 102	java/lang/reflect/Constructor
    //   10: astore 5
    //   12: aload 5
    //   14: astore 4
    //   16: aload 5
    //   18: ifnonnull +66 -> 84
    //   21: aload_0
    //   22: getfield 46	bluefay/preference/d:a	Landroid/content/Context;
    //   25: invokevirtual 106	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   28: astore 5
    //   30: aload_2
    //   31: ifnull +76 -> 107
    //   34: new 71	java/lang/StringBuilder
    //   37: astore 4
    //   39: aload 4
    //   41: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   44: aload 4
    //   46: aload_2
    //   47: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload 5
    //   61: aload 4
    //   63: invokevirtual 112	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   66: getstatic 32	bluefay/preference/d:d	[Ljava/lang/Class;
    //   69: invokevirtual 116	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   72: astore 4
    //   74: getstatic 39	bluefay/preference/d:e	Ljava/util/HashMap;
    //   77: aload_1
    //   78: aload 4
    //   80: invokevirtual 120	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_0
    //   85: getfield 44	bluefay/preference/d:c	[Ljava/lang/Object;
    //   88: astore 5
    //   90: aload 5
    //   92: iconst_1
    //   93: aload_3
    //   94: aastore
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 124	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 4
    //   104: aload 4
    //   106: areturn
    //   107: aload_1
    //   108: astore 4
    //   110: goto -51 -> 59
    //   113: astore 4
    //   115: new 71	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   122: aload_3
    //   123: invokeinterface 76 1 0
    //   128: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 82
    //   133: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: astore 5
    //   138: aload_1
    //   139: astore_3
    //   140: aload_2
    //   141: ifnull +22 -> 163
    //   144: new 71	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   151: aload_2
    //   152: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_3
    //   163: new 49	android/view/InflateException
    //   166: dup
    //   167: aload 5
    //   169: aload_3
    //   170: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 88	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload 4
    //   183: invokevirtual 92	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   186: pop
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: aload_1
    //   191: athrow
    //   192: astore 4
    //   194: new 71	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   201: aload_3
    //   202: invokeinterface 76 1 0
    //   207: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc 82
    //   212: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: astore 5
    //   217: aload_1
    //   218: astore_3
    //   219: aload_2
    //   220: ifnull +22 -> 242
    //   223: new 71	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   230: aload_2
    //   231: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_3
    //   242: new 49	android/view/InflateException
    //   245: dup
    //   246: aload 5
    //   248: aload_3
    //   249: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokespecial 88	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   258: astore_1
    //   259: aload_1
    //   260: aload 4
    //   262: invokevirtual 92	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   265: pop
    //   266: aload_1
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	d
    //   0	268	1	paramString1	String
    //   0	268	2	paramString2	String
    //   0	268	3	paramAttributeSet	AttributeSet
    //   14	95	4	localObject1	Object
    //   113	69	4	localNoSuchMethodException	NoSuchMethodException
    //   192	69	4	localException	Exception
    //   10	237	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	30	113	java/lang/NoSuchMethodException
    //   34	59	113	java/lang/NoSuchMethodException
    //   59	84	113	java/lang/NoSuchMethodException
    //   84	90	113	java/lang/NoSuchMethodException
    //   95	104	113	java/lang/NoSuchMethodException
    //   21	30	189	java/lang/ClassNotFoundException
    //   34	59	189	java/lang/ClassNotFoundException
    //   59	84	189	java/lang/ClassNotFoundException
    //   84	90	189	java/lang/ClassNotFoundException
    //   95	104	189	java/lang/ClassNotFoundException
    //   21	30	192	java/lang/Exception
    //   34	59	192	java/lang/Exception
    //   59	84	192	java/lang/Exception
    //   84	90	192	java/lang/Exception
    //   95	104	192	java/lang/Exception
  }
  
  private T a(XmlPullParser paramXmlPullParser, P paramP)
  {
    Object localObject;
    synchronized (this.c)
    {
      localObject = Xml.asAttributeSet(paramXmlPullParser);
      this.c[0] = this.a;
    }
    try
    {
      int i;
      do
      {
        i = paramXmlPullParser.next();
      } while ((i != 2) && (i != 1));
      if (i != 2)
      {
        paramP = new android/view/InflateException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        paramP.<init>(paramXmlPullParser.getPositionDescription() + ": No start tag found!");
        throw paramP;
      }
    }
    catch (InflateException paramXmlPullParser)
    {
      throw paramXmlPullParser;
      paramXmlPullParser = finally;
      throw paramXmlPullParser;
      paramP = a(paramP, (b)a(paramXmlPullParser.getName(), (AttributeSet)localObject));
      b(paramXmlPullParser, paramP, (AttributeSet)localObject);
      return paramP;
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      paramP = new android/view/InflateException;
      paramP.<init>(paramXmlPullParser.getMessage());
      paramP.initCause(paramXmlPullParser);
      throw paramP;
    }
    catch (IOException localIOException)
    {
      localObject = new android/view/InflateException;
      paramP = new java/lang/StringBuilder;
      paramP.<init>();
      ((InflateException)localObject).<init>(paramXmlPullParser.getPositionDescription() + ": " + localIOException.getMessage());
      ((InflateException)localObject).initCause(localIOException);
      throw ((Throwable)localObject);
    }
  }
  
  private void b(XmlPullParser paramXmlPullParser, T paramT, AttributeSet paramAttributeSet)
  {
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break;
      }
      if ((j == 2) && (!a(paramXmlPullParser, paramT, paramAttributeSet)))
      {
        Object localObject = a(paramXmlPullParser.getName(), paramAttributeSet);
        ((b)paramT).a(localObject);
        b(paramXmlPullParser, localObject, paramAttributeSet);
      }
    }
  }
  
  public final Context a()
  {
    return this.a;
  }
  
  protected P a(P paramP1, P paramP2)
  {
    return paramP2;
  }
  
  public final T a(int paramInt, P paramP)
  {
    XmlResourceParser localXmlResourceParser = this.a.getResources().getXml(paramInt);
    try
    {
      paramP = a(localXmlResourceParser, paramP);
      return paramP;
    }
    finally
    {
      localXmlResourceParser.close();
    }
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
  
  protected boolean a(XmlPullParser paramXmlPullParser, T paramT, AttributeSet paramAttributeSet)
  {
    return false;
  }
  
  public static abstract interface a<T>
  {
    public abstract T a();
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */