package in.kanakuvalakku.app.dataprovider.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manojvivek on 13/10/14.
 */
public class DBBackend extends SQLiteOpenHelper{
    public static final String MEMBER_NAME="member_name",OUTSTANDING_AMOUNT="outstanding_amount",IS_PAID="is_paid";
    String createTables[] = new String[]{"create table report(_id INTEGER PRIMARY KEY AUTOINCREMENT,member_name varchar(100),outstanding_amount integer,is_paid boolean)"};
    // inserting dummy values, need to calculate and update these values whereever a expense has been added by a user.
    String[] insertDummyValues = new String[]{"insert into report('is_paid','outstanding_amount','member_name') values(1,1000,'Manoj');","insert into report('is_paid','outstanding_amount','member_name') values(0,800,'Kavi');"};
    String tables[] = new String[]{"report"};

    public DBBackend(Context context) {
        super(context, "Expenses_DB_new", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for(String createScript : createTables){
            sqLiteDatabase.execSQL(createScript);
        }
       // Cursor cursor = sqLiteDatabase.rawQuery("desc report;",null);
       // cursor.moveToNext();
       // System.out.println("Desc:"+cursor.getString(0));
        for(String insertScript : insertDummyValues){
            sqLiteDatabase.execSQL(insertScript);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        for(String tableName : tables){
            sqLiteDatabase.execSQL("drop table if exists "+tableName);
        }
        onCreate(sqLiteDatabase);
    }
}
