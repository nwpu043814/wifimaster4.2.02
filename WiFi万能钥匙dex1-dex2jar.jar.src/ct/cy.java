package ct;

import android.os.Bundle;

final class cy
{
  public static final cy a = new cy();
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public final Bundle l = new Bundle();
  
  cy() {}
  
  private cy(cy paramcy)
  {
    if (paramcy.l.size() > 0) {
      this.l.putAll(paramcy.l);
    }
    for (;;)
    {
      return;
      this.b = paramcy.b;
      this.c = paramcy.c;
      this.d = paramcy.d;
      this.e = paramcy.e;
      this.f = paramcy.f;
      this.g = paramcy.g;
      this.h = paramcy.h;
      this.i = paramcy.i;
      this.j = paramcy.j;
      this.k = paramcy.k;
    }
  }
  
  /* Error */
  public cy(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 28	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 30	android/os/Bundle
    //   8: dup
    //   9: invokespecial 31	android/os/Bundle:<init>	()V
    //   12: putfield 33	ct/cy:l	Landroid/os/Bundle;
    //   15: aload_1
    //   16: ldc 67
    //   18: invokevirtual 73	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   21: ifeq +131 -> 152
    //   24: aload_1
    //   25: ldc 75
    //   27: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 7
    //   32: aload_1
    //   33: ldc 67
    //   35: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload_1
    //   41: ldc 81
    //   43: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_1
    //   48: ldc 83
    //   50: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 5
    //   55: aload_1
    //   56: ldc 85
    //   58: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_2
    //   62: aload_1
    //   63: ldc 87
    //   65: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 4
    //   70: aload_1
    //   71: ldc 89
    //   73: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   81: ldc 75
    //   83: aload 7
    //   85: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   92: ldc 67
    //   94: aload 6
    //   96: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   103: ldc 81
    //   105: aload_3
    //   106: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   113: ldc 83
    //   115: aload 5
    //   117: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   124: ldc 85
    //   126: aload_2
    //   127: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   134: ldc 87
    //   136: aload 4
    //   138: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 33	ct/cy:l	Landroid/os/Bundle;
    //   145: ldc 89
    //   147: aload_1
    //   148: invokevirtual 93	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: return
    //   152: aload_0
    //   153: aload_1
    //   154: ldc 95
    //   156: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 46	ct/cy:c	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 97
    //   166: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: putfield 48	ct/cy:d	Ljava/lang/String;
    //   172: aload_0
    //   173: aload_1
    //   174: ldc 75
    //   176: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: putfield 44	ct/cy:b	Ljava/lang/String;
    //   182: aload_0
    //   183: aload_1
    //   184: ldc 99
    //   186: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 50	ct/cy:e	Ljava/lang/String;
    //   192: aload_0
    //   193: aload_1
    //   194: ldc 101
    //   196: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: putfield 52	ct/cy:f	Ljava/lang/String;
    //   202: aload_0
    //   203: aload_1
    //   204: ldc 103
    //   206: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   209: putfield 54	ct/cy:g	Ljava/lang/String;
    //   212: aload_0
    //   213: aload_1
    //   214: ldc 105
    //   216: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 56	ct/cy:h	Ljava/lang/String;
    //   222: aload_0
    //   223: aload_1
    //   224: ldc 107
    //   226: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   229: putfield 58	ct/cy:i	Ljava/lang/String;
    //   232: aload_0
    //   233: aload_1
    //   234: ldc 109
    //   236: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: putfield 60	ct/cy:j	Ljava/lang/String;
    //   242: aload_0
    //   243: aload_1
    //   244: ldc 111
    //   246: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: putfield 62	ct/cy:k	Ljava/lang/String;
    //   252: goto -101 -> 151
    //   255: astore_1
    //   256: ldc 113
    //   258: ldc 115
    //   260: aload_1
    //   261: invokestatic 120	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	cy
    //   0	266	1	paramJSONObject	org.json.JSONObject
    //   61	66	2	str1	String
    //   46	60	3	str2	String
    //   68	69	4	str3	String
    //   53	63	5	str4	String
    //   38	57	6	str5	String
    //   30	54	7	str6	String
    // Exception table:
    //   from	to	target	type
    //   15	151	255	org/json/JSONException
    //   152	252	255	org/json/JSONException
  }
  
  public static cy a(cy paramcy)
  {
    if (paramcy == null) {}
    for (paramcy = null;; paramcy = new cy(paramcy)) {
      return paramcy;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubnationData{");
    localStringBuilder.append("name=").append(this.c).append(",");
    localStringBuilder.append("code=").append(this.d).append(",");
    localStringBuilder.append("nation=").append(this.b).append(",");
    localStringBuilder.append("province=").append(this.e).append(",");
    localStringBuilder.append("city=").append(this.f).append(",");
    localStringBuilder.append("district=").append(this.g).append(",");
    localStringBuilder.append("town=").append(this.h).append(",");
    localStringBuilder.append("village=").append(this.i).append(",");
    localStringBuilder.append("street=").append(this.j).append(",");
    localStringBuilder.append("street_no=").append(this.k).append(",");
    localStringBuilder.append("bundle").append(this.l).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */