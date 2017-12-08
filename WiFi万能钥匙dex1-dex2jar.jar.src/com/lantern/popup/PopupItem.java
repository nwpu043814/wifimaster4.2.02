package com.lantern.popup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class PopupItem
  implements Parcelable
{
  public static final Parcelable.Creator<PopupItem> CREATOR = new d();
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public PopupItem()
  {
    this.a = "1001";
  }
  
  public PopupItem(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public static PopupItem a(JSONObject paramJSONObject)
  {
    PopupItem localPopupItem = new PopupItem();
    localPopupItem.a = paramJSONObject.getString("id");
    localPopupItem.b = paramJSONObject.getInt("type");
    localPopupItem.c = paramJSONObject.getString("title");
    String str = paramJSONObject.getString("message");
    try
    {
      localPopupItem.d = a.a(str);
      localPopupItem.f = paramJSONObject.optString("negative");
      localPopupItem.e = paramJSONObject.getString("positive");
      localPopupItem.g = paramJSONObject.getString("cmd");
      return localPopupItem;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/popup/PopupItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */