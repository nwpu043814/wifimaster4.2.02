package c.a.a;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.security.SecureRandom;

final class cw
  extends j
{
  private static SecureRandom c = new SecureRandom();
  private static volatile boolean d = true;
  private boolean e = false;
  
  static
  {
    new Thread(new cx()).start();
  }
  
  private cw(long paramLong)
  {
    super(DatagramChannel.open(), paramLong);
  }
  
  private void a(SocketAddress paramSocketAddress)
  {
    InetSocketAddress localInetSocketAddress2;
    if ((paramSocketAddress == null) || (((paramSocketAddress instanceof InetSocketAddress)) && (((InetSocketAddress)paramSocketAddress).getPort() == 0)))
    {
      localInetSocketAddress2 = (InetSocketAddress)paramSocketAddress;
      if (!d) {}
    }
    try
    {
      Thread.sleep(2L);
      DatagramChannel localDatagramChannel;
      int i;
      if (!d)
      {
        localDatagramChannel = (DatagramChannel)this.b.channel();
        i = 0;
        if (i >= 1024) {}
      }
      for (;;)
      {
        try
        {
          int j = c.nextInt(64511) + 1024;
          InetSocketAddress localInetSocketAddress1;
          if (localInetSocketAddress2 != null)
          {
            localInetSocketAddress1 = new java/net/InetSocketAddress;
            localInetSocketAddress1.<init>(localInetSocketAddress2.getAddress(), j);
            localDatagramChannel.socket().bind(localInetSocketAddress1);
            this.e = true;
            if (!this.e) {}
          }
          else
          {
            localInetSocketAddress1 = new InetSocketAddress(j);
            continue;
          }
        }
        catch (SocketException localSocketException)
        {
          i++;
        }
        if (paramSocketAddress != null)
        {
          ((DatagramChannel)this.b.channel()).socket().bind(paramSocketAddress);
          this.e = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   4: invokevirtual 71	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   7: checkcast 35	java/nio/channels/DatagramChannel
    //   10: astore 4
    //   12: iload_1
    //   13: newarray <illegal type>
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   21: iconst_1
    //   22: invokevirtual 100	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   25: pop
    //   26: aload_0
    //   27: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   30: invokevirtual 104	java/nio/channels/SelectionKey:isReadable	()Z
    //   33: ifne +41 -> 74
    //   36: aload_0
    //   37: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   40: aload_0
    //   41: getfield 107	c/a/a/cw:a	J
    //   44: invokestatic 110	c/a/a/cw:a	(Ljava/nio/channels/SelectionKey;J)V
    //   47: goto -21 -> 26
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   56: invokevirtual 113	java/nio/channels/SelectionKey:isValid	()Z
    //   59: ifeq +12 -> 71
    //   62: aload_0
    //   63: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   66: iconst_0
    //   67: invokevirtual 100	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   70: pop
    //   71: aload 4
    //   73: athrow
    //   74: aload_0
    //   75: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   78: invokevirtual 113	java/nio/channels/SelectionKey:isValid	()Z
    //   81: ifeq +12 -> 93
    //   84: aload_0
    //   85: getfield 65	c/a/a/cw:b	Ljava/nio/channels/SelectionKey;
    //   88: iconst_0
    //   89: invokevirtual 100	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   92: pop
    //   93: aload 4
    //   95: aload 5
    //   97: invokestatic 119	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   100: invokevirtual 123	java/nio/channels/DatagramChannel:read	(Ljava/nio/ByteBuffer;)I
    //   103: i2l
    //   104: lstore_2
    //   105: lload_2
    //   106: lconst_0
    //   107: lcmp
    //   108: ifgt +11 -> 119
    //   111: new 125	java/io/EOFException
    //   114: dup
    //   115: invokespecial 126	java/io/EOFException:<init>	()V
    //   118: athrow
    //   119: lload_2
    //   120: l2i
    //   121: istore_1
    //   122: iload_1
    //   123: newarray <illegal type>
    //   125: astore 6
    //   127: aload 5
    //   129: iconst_0
    //   130: aload 6
    //   132: iconst_0
    //   133: iload_1
    //   134: invokestatic 132	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   137: aload 4
    //   139: invokevirtual 87	java/nio/channels/DatagramChannel:socket	()Ljava/net/DatagramSocket;
    //   142: invokevirtual 136	java/net/DatagramSocket:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   145: pop
    //   146: aload 4
    //   148: invokevirtual 87	java/nio/channels/DatagramChannel:socket	()Ljava/net/DatagramSocket;
    //   151: invokevirtual 139	java/net/DatagramSocket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   154: pop
    //   155: ldc -115
    //   157: aload 6
    //   159: invokestatic 144	c/a/a/cw:a	(Ljava/lang/String;[B)V
    //   162: aload 6
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	cw
    //   0	165	1	paramInt	int
    //   104	16	2	l	long
    //   10	1	4	localDatagramChannel	DatagramChannel
    //   50	97	4	localObject	Object
    //   15	113	5	arrayOfByte1	byte[]
    //   125	38	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	47	50	finally
  }
  
  static byte[] a(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    cw localcw = new cw(paramLong);
    try
    {
      localcw.a(paramSocketAddress1);
      if (!localcw.e) {
        localcw.a(null);
      }
      ((DatagramChannel)localcw.b.channel()).connect(paramSocketAddress2);
      paramSocketAddress1 = (DatagramChannel)localcw.b.channel();
      paramSocketAddress1.socket().getLocalSocketAddress();
      paramSocketAddress1.socket().getRemoteSocketAddress();
      a("UDP write", paramArrayOfByte);
      paramSocketAddress1.write(ByteBuffer.wrap(paramArrayOfByte));
      paramSocketAddress1 = localcw.a(paramInt);
      return paramSocketAddress1;
    }
    finally
    {
      localcw.a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */