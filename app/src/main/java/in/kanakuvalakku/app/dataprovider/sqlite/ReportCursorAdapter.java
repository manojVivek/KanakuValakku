package in.kanakuvalakku.app.dataprovider.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import in.kanakuvalakku.app.R;

/**
 * Created by manojvivek on 16/10/14.
 */
public class ReportCursorAdapter extends SimpleCursorAdapter {
    public ReportCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CheckBox isPaid = (CheckBox) view.findViewById(R.id.isPaid);
        TextView outstandingAmount = (TextView) view.findViewById(R.id.outstandingAmount);
        TextView memberName = (TextView) view.findViewById(R.id.memberName);
        isPaid.setChecked(cursor.getInt(cursor.getColumnIndex(DBBackend.IS_PAID)) ==0 ? false : true);
        outstandingAmount.setText(cursor.getString(cursor.getColumnIndex(DBBackend.OUTSTANDING_AMOUNT)));
        memberName.setText(cursor.getString(cursor.getColumnIndex(DBBackend.MEMBER_NAME)));
       // super.bindView(view, context, cursor);
    }
}
