package com.lantern.traffic.monitor.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  protected IvParameterSpec a;
  protected SecretKeySpec b;
  protected Cipher c;
  protected String d;
  protected String e;
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: invokestatic 27	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 5
    //   15: astore_1
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 29	com/lantern/traffic/monitor/a/a:c	Ljavax/crypto/Cipher;
    //   22: iconst_2
    //   23: aload_0
    //   24: getfield 31	com/lantern/traffic/monitor/a/a:b	Ljavax/crypto/spec/SecretKeySpec;
    //   27: aload_0
    //   28: getfield 33	com/lantern/traffic/monitor/a/a:a	Ljavax/crypto/spec/IvParameterSpec;
    //   31: invokevirtual 39	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   34: aload_0
    //   35: getfield 29	com/lantern/traffic/monitor/a/a:c	Ljavax/crypto/Cipher;
    //   38: astore 6
    //   40: aload_1
    //   41: ifnonnull +23 -> 64
    //   44: aload 6
    //   46: aload 4
    //   48: invokevirtual 43	javax/crypto/Cipher:doFinal	([B)[B
    //   51: astore_1
    //   52: new 45	java/lang/String
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 48	java/lang/String:<init>	([B)V
    //   60: astore_1
    //   61: goto -45 -> 16
    //   64: aload_1
    //   65: invokevirtual 52	java/lang/String:length	()I
    //   68: iconst_2
    //   69: if_icmplt -25 -> 44
    //   72: aload_1
    //   73: invokevirtual 52	java/lang/String:length	()I
    //   76: iconst_2
    //   77: idiv
    //   78: istore_3
    //   79: iload_3
    //   80: newarray <illegal type>
    //   82: astore 5
    //   84: iconst_0
    //   85: istore_2
    //   86: aload 5
    //   88: astore 4
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmpge -48 -> 44
    //   95: aload 5
    //   97: iload_2
    //   98: aload_1
    //   99: iload_2
    //   100: iconst_2
    //   101: imul
    //   102: iload_2
    //   103: iconst_2
    //   104: imul
    //   105: iconst_2
    //   106: iadd
    //   107: invokevirtual 56	java/lang/String:substring	(II)Ljava/lang/String;
    //   110: bipush 16
    //   112: invokestatic 62	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   115: i2b
    //   116: bastore
    //   117: iinc 2 1
    //   120: goto -34 -> 86
    //   123: astore_1
    //   124: new 21	java/lang/Exception
    //   127: dup
    //   128: new 64	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 66
    //   134: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_1
    //   138: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 81	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	a
    //   0	151	1	paramString	String
    //   85	33	2	i	int
    //   78	15	3	j	int
    //   1	88	4	localObject	Object
    //   4	92	5	arrayOfByte	byte[]
    //   38	7	6	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   18	40	123	java/lang/Exception
    //   44	52	123	java/lang/Exception
    //   64	84	123	java/lang/Exception
    //   95	117	123	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */