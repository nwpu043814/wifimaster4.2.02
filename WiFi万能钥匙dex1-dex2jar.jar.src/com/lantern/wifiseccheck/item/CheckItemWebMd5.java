package com.lantern.wifiseccheck.item;

import com.lantern.wifiseccheck.protocol.WebMd5Result;
import java.util.ArrayList;
import java.util.List;

public class CheckItemWebMd5
  extends ICheckItem
{
  public static final String[] CHECK_DOMAINS = { "http://eval.swaqds.com:8080/WifiSafetyDecisionMaker/static-web/3.html" };
  private int successCount = 0;
  private String[] urls;
  private List<WebMd5Result> webMd5Results;
  
  public CheckItemWebMd5(String[] paramArrayOfString)
  {
    this.urls = paramArrayOfString;
    initDefaultData();
  }
  
  public int getType()
  {
    return 3;
  }
  
  public List<WebMd5Result> getWebMd5Results()
  {
    return this.webMd5Results;
  }
  
  public void initDefaultData()
  {
    this.webMd5Results = new ArrayList();
    for (String str : this.urls)
    {
      WebMd5Result localWebMd5Result = new WebMd5Result();
      localWebMd5Result.setUrl(str);
      localWebMd5Result.setResult(null);
      this.webMd5Results.add(localWebMd5Result);
    }
  }
  
  public boolean isTimeOutType()
  {
    return true;
  }
  
  /* Error */
  public boolean setWebResult(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/lantern/wifiseccheck/item/CheckItemWebMd5:webMd5Results	Ljava/util/List;
    //   6: invokeinterface 67 1 0
    //   11: astore 5
    //   13: aload 5
    //   15: invokeinterface 72 1 0
    //   20: ifeq +77 -> 97
    //   23: aload 5
    //   25: invokeinterface 76 1 0
    //   30: checkcast 45	com/lantern/wifiseccheck/protocol/WebMd5Result
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 80	com/lantern/wifiseccheck/protocol/WebMd5Result:getUrl	()Ljava/lang/String;
    //   40: aload_1
    //   41: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifeq -31 -> 13
    //   47: new 85	java/lang/StringBuilder
    //   50: astore_1
    //   51: aload_1
    //   52: ldc 87
    //   54: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: ldc 91
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 104	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +5 -> 81
    //   79: aconst_null
    //   80: astore_1
    //   81: aload 4
    //   83: aload_1
    //   84: invokevirtual 53	com/lantern/wifiseccheck/protocol/WebMd5Result:setResult	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 27	com/lantern/wifiseccheck/item/CheckItemWebMd5:successCount	I
    //   92: iconst_1
    //   93: iadd
    //   94: putfield 27	com/lantern/wifiseccheck/item/CheckItemWebMd5:successCount	I
    //   97: new 85	java/lang/StringBuilder
    //   100: astore_1
    //   101: aload_1
    //   102: ldc 112
    //   104: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: ldc 91
    //   109: aload_1
    //   110: aload_0
    //   111: getfield 27	com/lantern/wifiseccheck/item/CheckItemWebMd5:successCount	I
    //   114: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 104	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_0
    //   124: getfield 27	com/lantern/wifiseccheck/item/CheckItemWebMd5:successCount	I
    //   127: aload_0
    //   128: getfield 38	com/lantern/wifiseccheck/item/CheckItemWebMd5:webMd5Results	Ljava/util/List;
    //   131: invokeinterface 118 1 0
    //   136: if_icmpne +14 -> 150
    //   139: aload_0
    //   140: iconst_1
    //   141: invokevirtual 122	com/lantern/wifiseccheck/item/CheckItemWebMd5:setFinish	(Z)V
    //   144: iconst_1
    //   145: istore_3
    //   146: aload_0
    //   147: monitorexit
    //   148: iload_3
    //   149: ireturn
    //   150: iconst_0
    //   151: istore_3
    //   152: goto -6 -> 146
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	CheckItemWebMd5
    //   0	160	1	paramString1	String
    //   0	160	2	paramString2	String
    //   145	7	3	bool	boolean
    //   33	49	4	localWebMd5Result	WebMd5Result
    //   11	13	5	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	155	finally
    //   13	70	155	finally
    //   72	79	155	finally
    //   81	97	155	finally
    //   97	144	155	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemWebMd5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */