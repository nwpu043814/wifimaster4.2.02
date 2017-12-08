package com.wifipay.wallet.home.bill.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.shengpay.crypto.JNICrypto;
import com.wifipay.common.a.g;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static volatile a f = null;
  ArrayList<a> a = new ArrayList();
  ArrayList<a> b = new ArrayList();
  private final String c = "billDetails";
  private final int d = 20;
  private b e;
  private final String g = "(id integer primary key autoincrement ,bizDesc varchar(128) ,orderId varchar(64) ,amount varchar(64) ,party varchar(64) ,partyName varchar(64) ,bizCode varchar(64) ,status varchar(8) ,cardNo varchar(8) ,statusDesc varchar(128) ,tradeTime long ,transType varchar(64) ,direction varchar(8))";
  
  private a(Context paramContext)
  {
    this.e = new b(paramContext.getApplicationContext());
  }
  
  private long a(SQLiteStatement paramSQLiteStatement, BillDetails.Bills paramBills)
  {
    paramSQLiteStatement.bindString(1, d(paramBills.bizDesc));
    paramSQLiteStatement.bindString(2, d(paramBills.orderId));
    paramSQLiteStatement.bindString(3, d(paramBills.amount));
    paramSQLiteStatement.bindString(4, d(paramBills.party));
    paramSQLiteStatement.bindString(5, d(paramBills.partyName));
    paramSQLiteStatement.bindString(6, d(paramBills.bizCode));
    paramSQLiteStatement.bindString(7, d(paramBills.status));
    paramSQLiteStatement.bindString(8, d(paramBills.cardNo));
    paramSQLiteStatement.bindString(9, d(paramBills.statusDesc));
    paramSQLiteStatement.bindLong(10, com.wifipay.wallet.home.bill.b.a(paramBills.tradeTime));
    paramSQLiteStatement.bindString(11, d(paramBills.transType));
    paramSQLiteStatement.bindString(12, d(paramBills.direction));
    paramSQLiteStatement.bindString(13, d(paramBills.detailUrl));
    paramSQLiteStatement.bindString(14, d(paramBills.memo));
    paramSQLiteStatement.bindString(15, d(paramBills.goodsInfo));
    paramSQLiteStatement.bindString(16, d(paramBills.merchantOrderNo));
    paramSQLiteStatement.bindString(17, d(paramBills.reductionAmount));
    paramSQLiteStatement.bindString(18, d(paramBills.feeAmount));
    paramSQLiteStatement.bindString(19, d(paramBills.isOncentActivity));
    paramSQLiteStatement.bindString(20, d(paramBills.oncentCardNo));
    paramSQLiteStatement.bindString(21, d(paramBills.oncentPasswd));
    return paramSQLiteStatement.executeInsert();
  }
  
  private long a(BillDetails.Bills paramBills, SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.update(f(), a(paramBills), " orderId = ? ", new String[] { paramBills.orderId });
  }
  
  private ContentValues a(BillDetails.Bills paramBills)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("bizDesc", paramBills.bizDesc);
    localContentValues.put("orderId", paramBills.orderId);
    localContentValues.put("amount", paramBills.amount);
    localContentValues.put("party", paramBills.party);
    localContentValues.put("status", paramBills.status);
    localContentValues.put("partyName", paramBills.partyName);
    localContentValues.put("statusDesc", paramBills.statusDesc);
    localContentValues.put("tradeTime", Long.valueOf(com.wifipay.wallet.home.bill.b.a(paramBills.tradeTime)));
    localContentValues.put("direction", paramBills.direction);
    localContentValues.put("bizCode", paramBills.bizCode);
    localContentValues.put("cardNo", paramBills.cardNo);
    localContentValues.put("transType", paramBills.transType);
    localContentValues.put("detailUrl", paramBills.detailUrl);
    localContentValues.put("memo", paramBills.memo);
    localContentValues.put("goodsInfo", paramBills.goodsInfo);
    localContentValues.put("merchantId", paramBills.merchantOrderNo);
    localContentValues.put("reductionAmount", paramBills.reductionAmount);
    localContentValues.put("feeAmount", paramBills.feeAmount);
    localContentValues.put("isOncentActivity", paramBills.isOncentActivity);
    localContentValues.put("oncentCardNo", paramBills.oncentCardNo);
    localContentValues.put("oncentPasswd", paramBills.oncentPasswd);
    return localContentValues;
  }
  
  private SQLiteStatement a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("INSERT INTO " + f() + "(bizDesc, orderId, amount, party, partyName, bizCode, status, cardNo, statusDesc, tradeTime, transType, direction, detailUrl,memo,goodsInfo,merchantId,reductionAmount, feeAmount, isOncentActivity, oncentCardNo, oncentPasswd) ");
    localStringBuffer.append(" VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    return paramSQLiteDatabase.compileStatement(localStringBuffer.toString());
  }
  
  public static a a(Context paramContext)
  {
    if (f == null) {}
    try
    {
      if (f == null)
      {
        a locala = new com/wifipay/wallet/home/bill/b/a;
        locala.<init>(paramContext);
        f = locala;
      }
      return f;
    }
    finally {}
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ALTER TABLE ");
      paramSQLiteDatabase.execSQL(f() + " ADD COLUMN " + paramString + " VARCHAR(128) ");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;) {}
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists " + f() + "(id integer primary key autoincrement ,bizDesc varchar(128) ,orderId varchar(64) ,amount varchar(64) ,party varchar(64) ,partyName varchar(64) ,bizCode varchar(64) ,status varchar(8) ,cardNo varchar(8) ,statusDesc varchar(128) ,tradeTime long ,transType varchar(64) ,direction varchar(8))");
  }
  
  /* Error */
  private boolean b(BillDetails.Bills paramBills)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/wifipay/wallet/home/bill/b/a:e	Lcom/wifipay/wallet/home/bill/b/b;
    //   4: invokevirtual 252	com/wifipay/wallet/home/bill/b/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: aload_0
    //   9: invokespecial 149	com/wifipay/wallet/home/bill/b/a:f	()Ljava/lang/String;
    //   12: astore 4
    //   14: aload_1
    //   15: getfield 75	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:orderId	Ljava/lang/String;
    //   18: astore_1
    //   19: aload_3
    //   20: aload 4
    //   22: iconst_2
    //   23: anewarray 156	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc -90
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc -85
    //   35: aastore
    //   36: ldc -2
    //   38: iconst_1
    //   39: anewarray 156	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 258	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +28 -> 82
    //   57: aload_1
    //   58: invokeinterface 264 1 0
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +17 -> 82
    //   68: aload_1
    //   69: ifnull +9 -> 78
    //   72: aload_1
    //   73: invokeinterface 267 1 0
    //   78: iconst_1
    //   79: istore_2
    //   80: iload_2
    //   81: ireturn
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 267 1 0
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -14 -> 80
    //   97: astore_3
    //   98: aload_1
    //   99: ifnull +9 -> 108
    //   102: aload_1
    //   103: invokeinterface 267 1 0
    //   108: aload_3
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	a
    //   0	110	1	paramBills	BillDetails.Bills
    //   63	31	2	bool	boolean
    //   7	13	3	localSQLiteDatabase	SQLiteDatabase
    //   97	12	3	localObject	Object
    //   12	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   57	64	97	finally
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ALTER TABLE ");
      paramSQLiteDatabase.execSQL(f() + " ADD COLUMN memo VARCHAR(128) ");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;) {}
    }
  }
  
  private String d(String paramString)
  {
    String str = paramString;
    if (g.a(paramString)) {
      str = "";
    }
    return str;
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ALTER TABLE ");
      paramSQLiteDatabase.execSQL(f() + " ADD COLUMN goodsInfo VARCHAR(128) ");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;) {}
    }
  }
  
  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ALTER TABLE ");
      paramSQLiteDatabase.execSQL(f() + " ADD COLUMN merchantId VARCHAR(128) ");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;) {}
    }
  }
  
  private String f()
  {
    String str = JNICrypto.sdpEnc1(com.wifipay.wallet.common.info.b.a().e());
    return "billDetails_" + str;
  }
  
  private void f(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ALTER TABLE ");
      paramSQLiteDatabase.execSQL(f() + " ADD COLUMN detailUrl VARCHAR(128) ");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;) {}
    }
  }
  
  public float a(String paramString)
  {
    this.a.clear();
    Object localObject2 = this.e.getReadableDatabase();
    Object localObject1 = ((SQLiteDatabase)localObject2).rawQuery("select * from " + f() + " WHERE status = '2' AND bizCode in ('transfer','deposit') ", null);
    if (localObject1 != null) {}
    try
    {
      while ((((Cursor)localObject1).moveToNext()) && (((SQLiteDatabase)localObject2).isOpen()))
      {
        a locala = new com/wifipay/wallet/home/bill/b/a$a;
        locala.<init>(this);
        locala.a = com.wifipay.wallet.home.bill.b.a(((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("tradeTime"))).substring(0, 7);
        locala.b = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("amount"));
        locala.d = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("direction"));
        locala.e = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("bizCode"));
        if ((g.a(paramString, locala.a)) && ((g.a("2", locala.d)) || (g.a(locala.e, "deposit")))) {
          this.a.add(locala);
        }
      }
      float f1;
      return paramString.floatValue();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      ((SQLiteDatabase)localObject2).close();
      for (;;)
      {
        localObject1 = this.a.iterator();
        for (paramString = Float.valueOf(0.0F); ((Iterator)localObject1).hasNext(); paramString = Float.valueOf(Float.valueOf(((a)localObject2).b).floatValue() + f1))
        {
          localObject2 = (a)((Iterator)localObject1).next();
          f1 = paramString.floatValue();
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        ((SQLiteDatabase)localObject2).close();
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      ((SQLiteDatabase)localObject2).close();
    }
  }
  
  public long a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    SimpleDateFormat localSimpleDateFormat;
    Date localDate;
    if (!g.a(paramString))
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      localDate = new Date();
    }
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      paramString = localSimpleDateFormat.format(paramString).split("-");
      int i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      if (j - 2 <= 0)
      {
        j = j + 12 - 2;
        i--;
        long l = com.wifipay.wallet.home.bill.b.a(i + "-" + j + "-01 00:00:00");
        paramSQLiteDatabase.execSQL("delete from " + f() + " where tradeTime < " + l);
        return 0L;
      }
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        int j;
        paramString.printStackTrace();
        paramString = localDate;
        continue;
        j -= 2;
      }
    }
  }
  
  /* Error */
  public List<BillDetails.Bills> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/wifipay/wallet/home/bill/b/a:e	Lcom/wifipay/wallet/home/bill/b/b;
    //   4: invokevirtual 252	com/wifipay/wallet/home/bill/b/b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: new 36	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 37	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload_2
    //   18: new 206	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 304
    //   25: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokespecial 149	com/wifipay/wallet/home/bill/b/a:f	()Ljava/lang/String;
    //   32: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 430
    //   38: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_1
    //   42: bipush 20
    //   44: imul
    //   45: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aconst_null
    //   52: invokevirtual 310	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +468 -> 525
    //   60: aload_3
    //   61: invokeinterface 264 1 0
    //   66: ifeq +459 -> 525
    //   69: aload_2
    //   70: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   73: ifeq +452 -> 525
    //   76: new 60	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills
    //   79: astore 5
    //   81: aload 5
    //   83: invokespecial 431	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:<init>	()V
    //   86: aload 5
    //   88: aload_3
    //   89: aload_3
    //   90: ldc -90
    //   92: invokeinterface 320 2 0
    //   97: invokeinterface 337 2 0
    //   102: putfield 63	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:bizDesc	Ljava/lang/String;
    //   105: aload 5
    //   107: aload_3
    //   108: aload_3
    //   109: ldc -85
    //   111: invokeinterface 320 2 0
    //   116: invokeinterface 337 2 0
    //   121: putfield 75	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:orderId	Ljava/lang/String;
    //   124: aload 5
    //   126: aload_3
    //   127: aload_3
    //   128: ldc -84
    //   130: invokeinterface 320 2 0
    //   135: invokeinterface 337 2 0
    //   140: putfield 78	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:amount	Ljava/lang/String;
    //   143: aload 5
    //   145: aload_3
    //   146: aload_3
    //   147: ldc -83
    //   149: invokeinterface 320 2 0
    //   154: invokeinterface 337 2 0
    //   159: putfield 81	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:party	Ljava/lang/String;
    //   162: aload 5
    //   164: aload_3
    //   165: aload_3
    //   166: ldc -82
    //   168: invokeinterface 320 2 0
    //   173: invokeinterface 337 2 0
    //   178: putfield 90	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:status	Ljava/lang/String;
    //   181: aload 5
    //   183: aload_3
    //   184: aload_3
    //   185: ldc -81
    //   187: invokeinterface 320 2 0
    //   192: invokeinterface 337 2 0
    //   197: putfield 84	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:partyName	Ljava/lang/String;
    //   200: aload 5
    //   202: aload_3
    //   203: aload_3
    //   204: ldc -80
    //   206: invokeinterface 320 2 0
    //   211: invokeinterface 337 2 0
    //   216: putfield 96	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:statusDesc	Ljava/lang/String;
    //   219: aload 5
    //   221: aload_3
    //   222: aload_3
    //   223: ldc -68
    //   225: invokeinterface 320 2 0
    //   230: invokeinterface 337 2 0
    //   235: putfield 87	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:bizCode	Ljava/lang/String;
    //   238: aload 5
    //   240: aload_3
    //   241: aload_3
    //   242: ldc -79
    //   244: invokeinterface 320 2 0
    //   249: invokeinterface 324 2 0
    //   254: invokestatic 327	com/wifipay/wallet/home/bill/b:a	(J)Ljava/lang/String;
    //   257: putfield 99	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:tradeTime	Ljava/lang/String;
    //   260: aload 5
    //   262: aload_3
    //   263: aload_3
    //   264: ldc -69
    //   266: invokeinterface 320 2 0
    //   271: invokeinterface 337 2 0
    //   276: putfield 114	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:direction	Ljava/lang/String;
    //   279: aload 5
    //   281: aload_3
    //   282: aload_3
    //   283: ldc -67
    //   285: invokeinterface 320 2 0
    //   290: invokeinterface 337 2 0
    //   295: putfield 93	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:cardNo	Ljava/lang/String;
    //   298: aload 5
    //   300: aload_3
    //   301: aload_3
    //   302: ldc -66
    //   304: invokeinterface 320 2 0
    //   309: invokeinterface 337 2 0
    //   314: putfield 111	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:transType	Ljava/lang/String;
    //   317: aload 5
    //   319: aload_3
    //   320: aload_3
    //   321: ldc -65
    //   323: invokeinterface 320 2 0
    //   328: invokeinterface 337 2 0
    //   333: putfield 117	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:detailUrl	Ljava/lang/String;
    //   336: aload 5
    //   338: aload_3
    //   339: aload_3
    //   340: ldc -64
    //   342: invokeinterface 320 2 0
    //   347: invokeinterface 337 2 0
    //   352: putfield 120	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:memo	Ljava/lang/String;
    //   355: aload 5
    //   357: aload_3
    //   358: aload_3
    //   359: ldc -63
    //   361: invokeinterface 320 2 0
    //   366: invokeinterface 337 2 0
    //   371: putfield 123	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:goodsInfo	Ljava/lang/String;
    //   374: aload 5
    //   376: aload_3
    //   377: aload_3
    //   378: ldc -61
    //   380: invokeinterface 320 2 0
    //   385: invokeinterface 337 2 0
    //   390: putfield 126	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:merchantOrderNo	Ljava/lang/String;
    //   393: aload 5
    //   395: aload_3
    //   396: aload_3
    //   397: ldc -60
    //   399: invokeinterface 320 2 0
    //   404: invokeinterface 337 2 0
    //   409: putfield 129	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:reductionAmount	Ljava/lang/String;
    //   412: aload 5
    //   414: aload_3
    //   415: aload_3
    //   416: ldc -59
    //   418: invokeinterface 320 2 0
    //   423: invokeinterface 337 2 0
    //   428: putfield 132	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:feeAmount	Ljava/lang/String;
    //   431: aload 5
    //   433: aload_3
    //   434: aload_3
    //   435: ldc -58
    //   437: invokeinterface 320 2 0
    //   442: invokeinterface 337 2 0
    //   447: putfield 135	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:isOncentActivity	Ljava/lang/String;
    //   450: aload 5
    //   452: aload_3
    //   453: aload_3
    //   454: ldc -57
    //   456: invokeinterface 320 2 0
    //   461: invokeinterface 337 2 0
    //   466: putfield 138	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:oncentCardNo	Ljava/lang/String;
    //   469: aload 5
    //   471: aload_3
    //   472: aload_3
    //   473: ldc -56
    //   475: invokeinterface 320 2 0
    //   480: invokeinterface 337 2 0
    //   485: putfield 141	com/wifipay/wallet/home/bill/net/dto/BillDetails$Bills:oncentPasswd	Ljava/lang/String;
    //   488: aload 4
    //   490: aload 5
    //   492: invokeinterface 434 2 0
    //   497: pop
    //   498: goto -438 -> 60
    //   501: astore 5
    //   503: aload 5
    //   505: invokevirtual 357	java/lang/Exception:printStackTrace	()V
    //   508: aload_3
    //   509: ifnull +9 -> 518
    //   512: aload_3
    //   513: invokeinterface 267 1 0
    //   518: aload_2
    //   519: invokevirtual 358	android/database/sqlite/SQLiteDatabase:close	()V
    //   522: aload 4
    //   524: areturn
    //   525: aload_3
    //   526: ifnull +9 -> 535
    //   529: aload_3
    //   530: invokeinterface 267 1 0
    //   535: aload_2
    //   536: invokevirtual 358	android/database/sqlite/SQLiteDatabase:close	()V
    //   539: goto -17 -> 522
    //   542: astore 4
    //   544: aload_3
    //   545: ifnull +9 -> 554
    //   548: aload_3
    //   549: invokeinterface 267 1 0
    //   554: aload_2
    //   555: invokevirtual 358	android/database/sqlite/SQLiteDatabase:close	()V
    //   558: aload 4
    //   560: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	a
    //   0	561	1	paramInt	int
    //   7	548	2	localSQLiteDatabase	SQLiteDatabase
    //   55	494	3	localCursor	Cursor
    //   15	508	4	localArrayList	ArrayList
    //   542	17	4	localObject	Object
    //   79	412	5	localBills	BillDetails.Bills
    //   501	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   60	498	501	java/lang/Exception
    //   60	498	542	finally
    //   503	508	542	finally
  }
  
  public void a()
  {
    b(this.e.getWritableDatabase());
  }
  
  public boolean a(List<BillDetails.Bills> paramList, String paramString)
  {
    boolean bool1;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      bool1 = false;
      return bool1;
    }
    SQLiteDatabase localSQLiteDatabase = this.e.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    for (;;)
    {
      try
      {
        localSQLiteStatement = a(localSQLiteDatabase);
        boolean bool2 = paramString.equals("0");
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramString = (BillDetails.Bills)localIterator.next();
          if (bool2)
          {
            bool1 = false;
            if (!bool1) {
              continue;
            }
            a(paramString, localSQLiteDatabase);
          }
        }
      }
      catch (Exception paramList)
      {
        SQLiteStatement localSQLiteStatement;
        paramList.printStackTrace();
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
        bool1 = true;
        break;
        bool1 = b(paramString);
        continue;
        a(localSQLiteStatement, paramString);
        continue;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
      }
      a(((BillDetails.Bills)paramList.get(0)).tradeTime, localSQLiteDatabase);
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
    }
  }
  
  public float b(String paramString)
  {
    this.b.clear();
    Object localObject2 = this.e.getReadableDatabase();
    Object localObject1 = ((SQLiteDatabase)localObject2).rawQuery("select * from " + f() + " WHERE status = '2' AND bizCode in ('transfer','expense','withdraw','spm_wifi_payment')", null);
    if (localObject1 != null) {}
    try
    {
      while ((((Cursor)localObject1).moveToNext()) && (((SQLiteDatabase)localObject2).isOpen()))
      {
        a locala = new com/wifipay/wallet/home/bill/b/a$a;
        locala.<init>(this);
        locala.a = com.wifipay.wallet.home.bill.b.a(((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("tradeTime"))).substring(0, 7);
        locala.c = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("amount"));
        locala.d = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("direction"));
        locala.e = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("bizCode"));
        if ((g.a(paramString, locala.a)) && ((g.a("1", locala.d)) || (g.a(locala.e, "expense")))) {
          this.b.add(locala);
        }
      }
      float f1;
      return paramString.floatValue();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      ((SQLiteDatabase)localObject2).close();
      for (;;)
      {
        localObject1 = this.b.iterator();
        for (paramString = Float.valueOf(0.0F); ((Iterator)localObject1).hasNext(); paramString = Float.valueOf(Float.valueOf(((a)localObject2).c).floatValue() + f1))
        {
          localObject2 = (a)((Iterator)localObject1).next();
          f1 = paramString.floatValue();
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        ((SQLiteDatabase)localObject2).close();
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      ((SQLiteDatabase)localObject2).close();
    }
  }
  
  public void b()
  {
    c(this.e.getWritableDatabase());
  }
  
  public void c()
  {
    d(this.e.getWritableDatabase());
  }
  
  public void c(String paramString)
  {
    a(this.e.getWritableDatabase(), paramString);
  }
  
  public void d()
  {
    e(this.e.getWritableDatabase());
  }
  
  public void e()
  {
    f(this.e.getWritableDatabase());
  }
  
  class a
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    
    a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */