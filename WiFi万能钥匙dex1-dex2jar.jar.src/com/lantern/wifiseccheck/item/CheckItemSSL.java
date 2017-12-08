package com.lantern.wifiseccheck.item;

import com.lantern.wifiseccheck.protocol.SslCertResult;
import java.util.ArrayList;
import java.util.List;

public class CheckItemSSL
  extends ICheckItem
{
  public static String[] SSL_URL = { "https://www.baidu.com/", "https://www.taobao.com/", "https://www.alipay.com", "https://www.jd.com/" };
  private List<SslCertResult> resultList = new ArrayList();
  private int successCount = 0;
  private String[] url = null;
  
  public CheckItemSSL(String[] paramArrayOfString)
  {
    this.url = paramArrayOfString;
    initDefaultData();
  }
  
  public List<SslCertResult> getSSLCertResults()
  {
    return this.resultList;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public void initDefaultData()
  {
    for (String str : this.url)
    {
      SslCertResult localSslCertResult = new SslCertResult();
      localSslCertResult.setHostCert(null);
      localSslCertResult.setUrl(str);
      this.resultList.add(localSslCertResult);
    }
  }
  
  public boolean isTimeOutType()
  {
    return true;
  }
  
  /* Error */
  public boolean setSSLCert(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 71	java/lang/StringBuilder
    //   5: astore 4
    //   7: aload 4
    //   9: ldc 73
    //   11: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: ldc 77
    //   16: aload 4
    //   18: aload_2
    //   19: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 91	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_2
    //   29: astore 4
    //   31: aload_2
    //   32: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +6 -> 41
    //   38: aconst_null
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 38	com/lantern/wifiseccheck/item/CheckItemSSL:resultList	Ljava/util/List;
    //   45: invokeinterface 101 1 0
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 106 1 0
    //   57: ifeq +43 -> 100
    //   60: aload_2
    //   61: invokeinterface 110 1 0
    //   66: checkcast 51	com/lantern/wifiseccheck/protocol/SslCertResult
    //   69: astore 5
    //   71: aload 5
    //   73: invokevirtual 113	com/lantern/wifiseccheck/protocol/SslCertResult:getUrl	()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq -29 -> 51
    //   83: aload 5
    //   85: aload 4
    //   87: invokevirtual 56	com/lantern/wifiseccheck/protocol/SslCertResult:setHostCert	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 40	com/lantern/wifiseccheck/item/CheckItemSSL:successCount	I
    //   95: iconst_1
    //   96: iadd
    //   97: putfield 40	com/lantern/wifiseccheck/item/CheckItemSSL:successCount	I
    //   100: aload_0
    //   101: getfield 40	com/lantern/wifiseccheck/item/CheckItemSSL:successCount	I
    //   104: aload_0
    //   105: getfield 38	com/lantern/wifiseccheck/item/CheckItemSSL:resultList	Ljava/util/List;
    //   108: invokeinterface 119 1 0
    //   113: if_icmpne +14 -> 127
    //   116: aload_0
    //   117: iconst_1
    //   118: invokevirtual 123	com/lantern/wifiseccheck/item/CheckItemSSL:setFinish	(Z)V
    //   121: iconst_1
    //   122: istore_3
    //   123: aload_0
    //   124: monitorexit
    //   125: iload_3
    //   126: ireturn
    //   127: iconst_0
    //   128: istore_3
    //   129: goto -6 -> 123
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	CheckItemSSL
    //   0	137	1	paramString1	String
    //   0	137	2	paramString2	String
    //   122	7	3	bool	boolean
    //   5	81	4	localObject	Object
    //   69	15	5	localSslCertResult	SslCertResult
    // Exception table:
    //   from	to	target	type
    //   2	28	132	finally
    //   31	38	132	finally
    //   41	51	132	finally
    //   51	100	132	finally
    //   100	121	132	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemSSL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */