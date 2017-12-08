package com.snda.wifilocating.wxapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WkWeiXinUtil
{
  private static final int THUMB_SIZE = 100;
  public static final int TYPE_FAVORITE = 2;
  public static final int TYPE_FRIEND = 0;
  public static final int TYPE_TIMELINE = 1;
  private static IWXAPI mWxApi;
  
  private static byte[] compressBitmap(Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      paramBitmap = (Bitmap)localObject;
    }
    for (;;)
    {
      return paramBitmap;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
        localByteArrayOutputStream.<init>();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        paramBitmap = localByteArrayOutputStream.toByteArray();
      }
      catch (Exception paramBitmap)
      {
        paramBitmap = (Bitmap)localObject;
      }
    }
  }
  
  private static byte[] getImage(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setRequestMethod("GET");
    paramString.setReadTimeout(6000);
    if (paramString.getResponseCode() == 200)
    {
      InputStream localInputStream = paramString.getInputStream();
      paramString = readStream(localInputStream);
      localInputStream.close();
    }
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  public static Bitmap getImageFormPath(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("http"))) {}
    for (;;)
    {
      try
      {
        paramString = getImage(paramString);
        localObject1 = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        return (Bitmap)localObject1;
      }
      catch (Exception paramString)
      {
        h.a(paramString);
        localObject1 = localObject2;
        continue;
      }
      localObject1 = BitmapFactory.decodeFile(paramString);
    }
  }
  
  public static IWXAPI getWxApi()
  {
    if (mWxApi == null)
    {
      IWXAPI localIWXAPI = WXAPIFactory.createWXAPI(c.getInstance().getApplicationContext(), "wx13f22259f9bbd047", true);
      mWxApi = localIWXAPI;
      if (localIWXAPI != null) {
        mWxApi.registerApp("wx13f22259f9bbd047");
      }
    }
    return mWxApi;
  }
  
  public static boolean isWXAppInstalledAndSupported()
  {
    if ((getWxApi().isWXAppInstalled()) && (getWxApi().isWXAppSupportAPI())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void openApp()
  {
    getWxApi().openWXApp();
  }
  
  private static byte[] readStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void sentToWeiXinCircle(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      WXTextObject localWXTextObject = new WXTextObject();
      localWXTextObject.text = paramString;
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXTextObject;
      localWXMediaMessage.description = paramString;
      paramString = new SendMessageToWX.Req();
      paramString.transaction = ("text" + System.currentTimeMillis());
      paramString.message = localWXMediaMessage;
      paramString.scene = paramInt;
      getWxApi().sendReq(paramString);
    }
  }
  
  public static void shareToWeiXin(int paramInt, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(localWXWebpageObject);
    localWXWebpageObject.webpageUrl = paramString1;
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.description = paramString3;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localWXMediaMessage.thumbData = compressBitmap(Bitmap.createScaledBitmap(paramBitmap, 100, 100, true));
    }
    paramString1 = new SendMessageToWX.Req();
    paramString1.scene = paramInt;
    paramString1.transaction = System.currentTimeMillis();
    paramString1.message = localWXMediaMessage;
    getWxApi().sendReq(paramString1);
  }
  
  public static void shareToWeiXin(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(localWXWebpageObject);
    localWXWebpageObject.webpageUrl = paramString1;
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.description = paramString3;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2 = getImageFormPath(paramString4);
      if (paramString2 != null)
      {
        paramString1 = Bitmap.createScaledBitmap(paramString2, 100, 100, true);
        paramString2.recycle();
        localWXMediaMessage.thumbData = compressBitmap(paramString1);
      }
    }
    paramString1 = new SendMessageToWX.Req();
    paramString1.scene = paramInt;
    paramString1.transaction = System.currentTimeMillis();
    paramString1.message = localWXMediaMessage;
    getWxApi().sendReq(paramString1);
  }
  
  public static void shareToWeiXin(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      if (localJSONObject.has("url"))
      {
        paramString = localJSONObject.getString("url");
        if (localJSONObject.has("title"))
        {
          str1 = localJSONObject.getString("title");
          if (localJSONObject.has("content"))
          {
            str2 = localJSONObject.getString("content");
            if (localJSONObject.has("img"))
            {
              localBitmap = getImageFormPath(localJSONObject.getString("img"));
              int i = 1;
              if (localJSONObject.has("type")) {
                i = localJSONObject.getInt("type");
              }
              shareToWeiXin(i, paramString, str1, str2, localBitmap);
              if ((localBitmap != null) && (!localBitmap.isRecycled())) {
                localBitmap.recycle();
              }
              return;
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
        continue;
        Bitmap localBitmap = null;
        continue;
        String str2 = "";
        continue;
        String str1 = "";
        continue;
        paramString = "www.wifi.com";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/snda/wifilocating/wxapi/WkWeiXinUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */