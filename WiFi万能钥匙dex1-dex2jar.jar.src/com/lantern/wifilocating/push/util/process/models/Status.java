package com.lantern.wifilocating.push.util.process.models;

public final class Status
  extends ProcFile
{
  private Status(String paramString)
  {
    super(paramString);
  }
  
  public static Status a(int paramInt)
  {
    return new Status(String.format("/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final int a()
  {
    i = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.b.split("\n");
        int j = arrayOfString.length;
        if (i >= j) {
          continue;
        }
        str = arrayOfString[i];
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        if (!str.startsWith("Uid" + ":")) {
          continue;
        }
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        str = str.split("Uid" + ":")[1].trim();
        i = Integer.parseInt(str.split("\\s+")[0]);
      }
      catch (Exception localException)
      {
        String str;
        i = -1;
        continue;
      }
      return i;
      i++;
      continue;
      str = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/process/models/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */