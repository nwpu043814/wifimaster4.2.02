package com.lantern.wifiseccheck;

public class WifiCheckItemMessage
{
  private boolean checkFinish;
  private String messageContent;
  private boolean messageResult = true;
  private int messageType;
  
  public String getMessageContent()
  {
    return this.messageContent;
  }
  
  public int getMessageType()
  {
    return this.messageType;
  }
  
  public boolean isCheckFinish()
  {
    return this.checkFinish;
  }
  
  public boolean isMessageResult()
  {
    return this.messageResult;
  }
  
  public void setCheckFinish(boolean paramBoolean)
  {
    this.checkFinish = paramBoolean;
  }
  
  public void setMessageContent(String paramString)
  {
    this.messageContent = paramString;
  }
  
  public void setMessageResult(boolean paramBoolean)
  {
    this.messageResult = paramBoolean;
  }
  
  public void setMessageType(int paramInt)
  {
    this.messageType = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiCheckItemMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */