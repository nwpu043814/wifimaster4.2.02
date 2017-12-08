package com.lantern.safecommand.service;

import com.lantern.wifiseccheck.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Timer;

public class DnsTrigger
{
  public static final int FAILED_LIMIT = 10;
  private static final String TAG = "DnsTrigger";
  private List<String> dnsList = new ArrayList();
  Stack<String> dnsStack = new Stack();
  int failedCount = 0;
  
  public DnsTrigger(String paramString)
  {
    prepareList(paramString);
  }
  
  private void prepareList(String paramString)
  {
    LogUtils.d("DnsTrigger", "list =====" + paramString);
    StringReader localStringReader = new StringReader(paramString);
    BufferedReader localBufferedReader = new BufferedReader(localStringReader);
    try
    {
      for (;;)
      {
        paramString = localBufferedReader.readLine();
        if (paramString == null) {
          break;
        }
        this.dnsList.add(paramString);
      }
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      localStringReader.close();
      localBufferedReader.close();
    }
  }
  
  public void start()
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new DnsTrigger.1(this, localTimer), 0L, 1000L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/DnsTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */