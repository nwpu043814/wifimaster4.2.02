package c.a.a;

import java.io.EOFException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

final class ck
  extends j
{
  public ck(long paramLong)
  {
    super(SocketChannel.open(), paramLong);
  }
  
  private byte[] a(int paramInt)
  {
    SocketChannel localSocketChannel = (SocketChannel)this.b.channel();
    Object localObject1 = new byte[paramInt];
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject1);
    this.b.interestOps(1);
    int i = 0;
    SocketTimeoutException localSocketTimeoutException;
    while (i < paramInt)
    {
      long l;
      try
      {
        if (!this.b.isReadable()) {
          break label143;
        }
        l = localSocketChannel.read(localByteBuffer);
        if (l < 0L)
        {
          localObject1 = new java/io/EOFException;
          ((EOFException)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        if (this.b.isValid()) {
          this.b.interestOps(0);
        }
      }
      int j = i + (int)l;
      i = j;
      if (j < paramInt)
      {
        i = j;
        if (System.currentTimeMillis() > this.a)
        {
          localSocketTimeoutException = new java/net/SocketTimeoutException;
          localSocketTimeoutException.<init>();
          throw localSocketTimeoutException;
          label143:
          a(this.b, this.a);
        }
      }
    }
    if (this.b.isValid()) {
      this.b.interestOps(0);
    }
    return localSocketTimeoutException;
  }
  
  static byte[] a(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, byte[] paramArrayOfByte, long paramLong)
  {
    ck localck = new ck(paramLong);
    if (paramSocketAddress1 != null) {}
    try
    {
      localck.a(paramSocketAddress1);
      localck.b(paramSocketAddress2);
      localck.a(paramArrayOfByte);
      paramSocketAddress1 = localck.b();
      return paramSocketAddress1;
    }
    finally
    {
      localck.a();
    }
  }
  
  final void a(SocketAddress paramSocketAddress)
  {
    ((SocketChannel)this.b.channel()).socket().bind(paramSocketAddress);
  }
  
  final void a(byte[] paramArrayOfByte)
  {
    SocketChannel localSocketChannel = (SocketChannel)this.b.channel();
    localSocketChannel.socket().getLocalSocketAddress();
    localSocketChannel.socket().getRemoteSocketAddress();
    a("TCP write", paramArrayOfByte);
    ByteBuffer localByteBuffer2 = ByteBuffer.wrap(new byte[] { (byte)(paramArrayOfByte.length >>> 8), (byte)(paramArrayOfByte.length & 0xFF) });
    ByteBuffer localByteBuffer1 = ByteBuffer.wrap(paramArrayOfByte);
    this.b.interestOps(4);
    int i = 0;
    for (;;)
    {
      long l;
      try
      {
        if (i >= paramArrayOfByte.length + 2) {
          break;
        }
        if (!this.b.isWritable()) {
          break label197;
        }
        l = localSocketChannel.write(new ByteBuffer[] { localByteBuffer2, localByteBuffer1 });
        if (l < 0L)
        {
          paramArrayOfByte = new java/io/EOFException;
          paramArrayOfByte.<init>();
          throw paramArrayOfByte;
        }
      }
      finally
      {
        if (this.b.isValid()) {
          this.b.interestOps(0);
        }
      }
      int j = i + (int)l;
      i = j;
      if (j < paramArrayOfByte.length + 2)
      {
        i = j;
        if (System.currentTimeMillis() > this.a)
        {
          paramArrayOfByte = new java/net/SocketTimeoutException;
          paramArrayOfByte.<init>();
          throw paramArrayOfByte;
          label197:
          a(this.b, this.a);
        }
      }
    }
    if (this.b.isValid()) {
      this.b.interestOps(0);
    }
  }
  
  final void b(SocketAddress paramSocketAddress)
  {
    SocketChannel localSocketChannel = (SocketChannel)this.b.channel();
    if (localSocketChannel.connect(paramSocketAddress)) {}
    for (;;)
    {
      return;
      this.b.interestOps(8);
      try
      {
        while (!localSocketChannel.finishConnect()) {
          if (!this.b.isConnectable()) {
            a(this.b, this.a);
          }
        }
      }
      finally
      {
        if (this.b.isValid()) {
          this.b.interestOps(0);
        }
      }
    }
  }
  
  final byte[] b()
  {
    Object localObject = a(2);
    int i = localObject[0];
    byte[] arrayOfByte = a((localObject[1] & 0xFF) + ((i & 0xFF) << 8));
    localObject = (SocketChannel)this.b.channel();
    ((SocketChannel)localObject).socket().getLocalSocketAddress();
    ((SocketChannel)localObject).socket().getRemoteSocketAddress();
    a("TCP read", arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */