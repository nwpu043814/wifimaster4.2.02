package ct;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class da
  implements Parcelable, TencentLocation
{
  public static final da a = new da(-1);
  private cw b;
  private int c;
  private String d;
  private cu e;
  private final Bundle f = new Bundle();
  private String g = "network";
  private Location h;
  private final long i;
  private long j;
  
  static
  {
    new da.1();
  }
  
  private da(int paramInt)
  {
    this.c = paramInt;
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
  }
  
  private da(String paramString)
  {
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
    paramString = new JSONObject(paramString);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramString.getJSONObject("location");
        cw localcw = new ct/cw;
        localcw.<init>(localJSONObject);
        this.b = localcw;
        this.d = paramString.optString("bearing");
        int k = paramString.optInt("icontrol", -1);
        if (k >= 0) {
          this.f.putInt("icontrol", k);
        }
        localJSONObject = paramString.optJSONObject("details");
        if (localJSONObject != null) {}
        paramString = paramString.optJSONObject("addrdesp");
      }
      catch (JSONException paramString)
      {
        try
        {
          paramString = new ct/cu;
          paramString.<init>(localJSONObject);
          this.e = paramString;
          if ((this.e != null) && (this.e.c != null)) {
            this.f.putAll(this.e.c.l);
          }
          return;
        }
        catch (JSONException paramString)
        {
          b.a.a("TxLocation", "details object not found", paramString);
          throw paramString;
        }
        paramString = paramString;
        throw paramString;
      }
      if ((paramString != null) && (paramString.has("detail"))) {
        this.e = new cu(paramString.optJSONObject("detail"));
      }
    }
  }
  
  public static da a(da paramda, ck paramck)
  {
    int n;
    int k;
    if ((paramda != null) && (paramck != null) && (paramda.d != null))
    {
      String str = paramda.d;
      int m = 0;
      n = paramck.f;
      k = m;
      if (str != null)
      {
        k = m;
        if (str.split(",").length > 1) {
          k = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramck = paramda.b;
      if (paramck == null) {}
    }
    try
    {
      paramck.d = ((float)e.r(paramck.d, k, n));
      return paramda;
    }
    catch (UnsatisfiedLinkError paramck)
    {
      for (;;) {}
    }
  }
  
  public static void a(da paramda)
  {
    if (paramda == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final int a()
  {
    String str = this.d;
    if ((str != null) && (str.length() > 0) && (str.split(",").length > 1)) {}
    for (;;)
    {
      try
      {
        k = Integer.parseInt(str.split(",")[1]);
        return k;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        b.a.a("TxLocation", localNumberFormatException.getMessage(), localNumberFormatException);
      }
      int k = 0;
    }
  }
  
  public final da a(long paramLong)
  {
    this.j = paramLong;
    return this;
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    this.b.a = (Math.round(paramDouble1 * 1000000.0D) / 1000000.0D);
    this.b.b = (Math.round(paramDouble2 * 1000000.0D) / 1000000.0D);
  }
  
  public final void a(Location paramLocation)
  {
    if ((paramLocation != null) && (this.b != null))
    {
      double d1 = paramLocation.getLatitude();
      double d2 = paramLocation.getLongitude();
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      this.b.a = d1;
      this.b.b = d2;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {}
    for (float f1 = this.b.d;; f1 = 0.0F) {
      return f1;
    }
  }
  
  public final String getAddress()
  {
    String str;
    if (this.c == 5) {
      str = this.f.getString("addrdesp.name");
    }
    for (;;)
    {
      return str;
      if (this.b != null) {
        str = this.b.f;
      } else {
        str = "";
      }
    }
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {}
    for (double d1 = this.b.c;; d1 = 0.0D) {
      return d1;
    }
  }
  
  public final Integer getAreaStat()
  {
    if (this.e != null) {}
    for (Integer localInteger = Integer.valueOf(this.e.a);; localInteger = null) {
      return localInteger;
    }
  }
  
  public final float getBearing()
  {
    if (this.h == null) {}
    for (float f1 = 0.0F;; f1 = this.h.getBearing()) {
      return f1;
    }
  }
  
  public final String getCity()
  {
    if (this.e != null) {}
    for (String str = this.e.c.f;; str = "") {
      return str;
    }
  }
  
  public final String getCityCode()
  {
    if (this.e != null) {}
    for (String str = this.e.c.d;; str = "") {
      return str;
    }
  }
  
  public final String getDistrict()
  {
    if (this.e != null) {}
    for (String str = this.e.c.g;; str = "") {
      return str;
    }
  }
  
  public final long getElapsedRealtime()
  {
    return this.i;
  }
  
  public final Bundle getExtra()
  {
    return this.f;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {}
    for (double d1 = this.b.a;; d1 = 0.0D) {
      return d1;
    }
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {}
    for (double d1 = this.b.b;; d1 = 0.0D) {
      return d1;
    }
  }
  
  public final String getName()
  {
    String str;
    if (this.c == 5) {
      str = this.f.getString("addrdesp.name");
    }
    for (;;)
    {
      return str;
      if (this.b != null) {
        str = this.b.e;
      } else {
        str = "";
      }
    }
  }
  
  public final String getNation()
  {
    if (this.e != null) {}
    for (String str = this.e.c.b;; str = "") {
      return str;
    }
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.e != null) {}
    for (Object localObject = new ArrayList(this.e.b);; localObject = Collections.emptyList()) {
      return (List<TencentPoi>)localObject;
    }
  }
  
  public final String getProvider()
  {
    return this.g;
  }
  
  public final String getProvince()
  {
    if (this.e != null) {}
    for (String str = this.e.c.e;; str = "") {
      return str;
    }
  }
  
  public final float getSpeed()
  {
    if (this.h == null) {}
    for (float f1 = 0.0F;; f1 = this.h.getSpeed()) {
      return f1;
    }
  }
  
  public final String getStreet()
  {
    if (this.e != null) {}
    for (String str = this.e.c.j;; str = "") {
      return str;
    }
  }
  
  public final String getStreetNo()
  {
    if (this.e != null) {}
    for (String str = this.e.c.k;; str = "") {
      return str;
    }
  }
  
  public final long getTime()
  {
    return this.j;
  }
  
  public final String getTown()
  {
    if (this.e != null) {}
    for (String str = this.e.c.h;; str = "") {
      return str;
    }
  }
  
  public final String getVillage()
  {
    if (this.e != null) {}
    for (String str = this.e.c.i;; str = "") {
      return str;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.c).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.e != null) {}
    for (String str = this.e.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.j);
      paramParcel.writeBundle(this.f);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public da b;
    public int c;
    public String d = "network";
    private Location e;
    
    public final a a(Location paramLocation)
    {
      this.e = new Location(paramLocation);
      return this;
    }
    
    public final da a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          localda1 = new ct/da;
          localda1.<init>(this.a, (byte)0);
          da.a(da.b(da.a(localda1, this.c), this.d), this.e);
          cp.b();
        }
        catch (JSONException localJSONException)
        {
          da localda1;
          b.a.a("TxLocation", "build: ", localJSONException);
          localda2 = da.a;
          continue;
        }
        return localda1;
        da localda2 = da.c(this.b);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */