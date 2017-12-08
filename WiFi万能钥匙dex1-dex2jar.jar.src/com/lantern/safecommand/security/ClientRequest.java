package com.lantern.safecommand.security;

public class ClientRequest
{
  private String publicKey;
  private String requestBody;
  
  public ClientRequest(String paramString1, String paramString2)
  {
    this.publicKey = paramString1;
    this.requestBody = paramString2;
  }
  
  public String getPublicKey()
  {
    return this.publicKey;
  }
  
  public String getRequestBody()
  {
    return this.requestBody;
  }
  
  public void setPublicKey(String paramString)
  {
    this.publicKey = paramString;
  }
  
  public void setRequestBody(String paramString)
  {
    this.requestBody = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/security/ClientRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */