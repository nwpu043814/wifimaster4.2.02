package com.lantern.wifiseccheck.vpn.server;

public class ClientByteArrayRequest
{
  private String publicKey;
  private byte[] requestBody;
  
  public ClientByteArrayRequest() {}
  
  public ClientByteArrayRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.publicKey = paramString;
    this.requestBody = paramArrayOfByte;
  }
  
  public String getPublicKey()
  {
    return this.publicKey;
  }
  
  public byte[] getRequestBody()
  {
    return this.requestBody;
  }
  
  public void setPublicKey(String paramString)
  {
    this.publicKey = paramString;
  }
  
  public void setRequestBody(byte[] paramArrayOfByte)
  {
    this.requestBody = paramArrayOfByte;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/server/ClientByteArrayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */