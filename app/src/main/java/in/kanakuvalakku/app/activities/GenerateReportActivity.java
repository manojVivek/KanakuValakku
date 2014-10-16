package in.kanakuvalakku.app.activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import in.kanakuvalakku.app.R;
import in.kanakuvalakku.app.dataprovider.sqlite.DBBackend;
import in.kanakuvalakku.app.dataprovider.sqlite.ReportCursorAdapter;
import in.kanakuvalakku.app.dataprovider.sqlite.ReportDAO;

public class GenerateReportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        ListView reportList = (ListView) findViewById(R.id.reportList);

        ReportDAO reportDAO = new ReportDAO(this);
        Cursor reportCursor = reportDAO.getReportCursor();

        ReportCursorAdapter reportCursorAdapter = new ReportCursorAdapter(this, R.layout.report_list_item, reportCursor,
                new String[]{DBBackend.IS_PAID, DBBackend.OUTSTANDING_AMOUNT, DBBackend.MEMBER_NAME},
                new int[]{R.id.isPaid, R.id.outstandingAmount, R.id.memberName}
        );

        reportList.setAdapter(reportCursorAdapter);

    }
}
