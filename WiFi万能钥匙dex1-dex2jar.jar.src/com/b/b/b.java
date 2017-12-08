package com.b.b;

public abstract class b<MessageType extends u>
  implements x<MessageType>
{
  private static final j a = ;
  
  /* Error */
  private MessageType b(e parame, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 32	com/b/b/e:c	()Lcom/b/b/g;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 35	com/b/b/b:a	(Lcom/b/b/g;Lcom/b/b/j;)Ljava/lang/Object;
    //   11: checkcast 37	com/b/b/u
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 42	com/b/b/g:a	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 45	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	b
    //   0	32	1	parame	e
    //   0	32	2	paramj	j
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/b/b/o
    //   0	15	29	com/b/b/o
    //   23	29	29	com/b/b/o
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */