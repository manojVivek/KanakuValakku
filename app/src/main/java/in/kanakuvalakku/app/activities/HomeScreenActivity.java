package in.kanakuvalakku.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.kanakuvalakku.app.R;

public class HomeScreenActivity extends Activity {
    private static final String TAG = "HomeScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button addDailyExpenseButton = (Button) findViewById(R.id.addDailyExpenseButton);
        Button addMonthlyExpenseButton = (Button) findViewById(R.id.addMonthlyExpenseButton);
        Button generateReportButton = (Button) findViewById(R.id.generateReportButton);

        //registering click handlers
        addDailyExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO open the required activity
                //loadActivity(GenerateReportActivity.class);
            }
        });
        addMonthlyExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO open the required activity
                //loadActivity(GenerateReportActivity.class);
            }
        });
        generateReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadActivity(GenerateReportActivity.class);
            }
        });


    }

    private void loadActivity(Class<?> activityClass) {
        Log.d(TAG,"Opening new activity : "+activityClass.getName());
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
