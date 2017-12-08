package com.wifipay.wallet.home.bill.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class b
  extends SQLiteOpenHelper
{
  public b(Context paramContext)
  {
    super(paramContext, "sp_wallet.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table loginHistory(loginAccount varchar(64) PRIMARY KEY ,loginToken varchar(64) ,loginMemberId varchar(128) ,loginType varchar(64) ,loginTime long)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */