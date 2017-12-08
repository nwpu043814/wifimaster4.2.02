package com.lantern.wifilocating.push.b.c;

import com.lantern.wifilocating.push.util.j;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import org.json.JSONObject;

public final class a
{
  private Object a = new Object();
  private Socket b;
  private OutputStream c;
  private BufferedReader d;
  private boolean e;
  private Charset f;
  private Runnable g = new c(this);
  
  public a(Socket paramSocket)
  {
    this.b = paramSocket;
    this.f = Charset.forName("UTF-8");
    this.c = paramSocket.getOutputStream();
    this.d = new BufferedReader(new InputStreamReader(paramSocket.getInputStream(), this.f));
    this.e = true;
    new Thread(this.g).start();
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      j.a(this.c);
      this.c = null;
      j.a(this.d);
      j.a(this.b);
      this.d = null;
      return;
    }
  }
  
  public final void a()
  {
    this.e = false;
    b();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    new b(this, paramJSONObject).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */