package c.a.a;

import c.a.a.a.e;
import java.io.PrintStream;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

class j
{
  private static bn c = null;
  protected long a;
  protected SelectionKey b;
  
  protected j(SelectableChannel paramSelectableChannel, long paramLong)
  {
    Object localObject1 = null;
    this.a = paramLong;
    try
    {
      Selector localSelector = Selector.open();
      localObject1 = localSelector;
      paramSelectableChannel.configureBlocking(false);
      localObject1 = localSelector;
      this.b = paramSelectableChannel.register(localSelector, 1);
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Selector)localObject1).close();
      }
      paramSelectableChannel.close();
    }
  }
  
  protected static void a(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.a("verbosemsg")) {
      System.err.println(e.a(paramString, paramArrayOfByte));
    }
  }
  
  protected static void a(SelectionKey paramSelectionKey, long paramLong)
  {
    paramLong -= System.currentTimeMillis();
    int i = 0;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    }
    while (i == 0)
    {
      throw new SocketTimeoutException();
      if (paramLong == 0L) {
        i = paramSelectionKey.selector().selectNow();
      }
    }
  }
  
  final void a()
  {
    this.b.selector().close();
    this.b.channel().close();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */