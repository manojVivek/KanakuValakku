package in.kanakuvalakku.app.dataprovider.sqlite;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by manojvivek on 13/10/14.
 */
public class ReportDAO {

    DBBackend dbBackend;

    public ReportDAO(Context context){
        dbBackend = new DBBackend(context);
    }

    public Cursor getReportCursor(){
        Cursor cursor = dbBackend.getReadableDatabase().query("report", null, null, null, null, null, null);
        cursor.moveToNext();
        System.out.println("Values:"+cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" ");
        cursor = dbBackend.getReadableDatabase().query("report", null, null, null, null, null, null);
        return  cursor;
    }

}
