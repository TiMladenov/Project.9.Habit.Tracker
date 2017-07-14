package io.github.timladenov.project_9_habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.timladenov.project_9_habittracker.db.ServiceContract.ServiceEntry;
import io.github.timladenov.project_9_habittracker.db.ServiceHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // This App aims at providing a few basic fields for the user to enter info on the maintenance that he did to his vehicle

    EditText date;
    EditText action;
    EditText price;
    EditText serviceName;
    Button submitButton;
    View dbContents;
    ServiceHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText) findViewById(R.id.date);
        action = (EditText) findViewById(R.id.action);
        price = (EditText) findViewById(R.id.price);
        serviceName = (EditText) findViewById(R.id.service_name);
        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(this);

        // Hides the Layout which will display the current information in the DB
        dbContents = findViewById(R.id.db_read);
        dbContents.setVisibility(View.GONE);

        // Initiates the check if the DB exists and has entries
        showDataBase();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showDataBase();
    }

    // Checks if all EditText fields are filled, if they are the date is inserted into the DB, else a Toast warning message is thrown
    @Override
    public void onClick(View v) {
        if ((isEmpty(date) || isEmpty(action)) || (isEmpty(price) || isEmpty(serviceName))) {
            Toast.makeText(this, getString(R.string.fill_all), Toast.LENGTH_SHORT).show();
        } else {
            insertDateInDb();
        }
    }

    // Checks if an EditText is empty
    private boolean isEmpty(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    // Inserts tha received data from the EditText into the DB. Throws an error message if insertion cannot be done.
    private void insertDateInDb() {
        helper = new ServiceHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ServiceEntry.COLUMN_DATE, date.getText().toString().trim());
        values.put(ServiceEntry.COLUMN_ACTION, action.getText().toString().trim());
        values.put(ServiceEntry.COLUMN_PRICE, price.getText().toString().trim());
        values.put(ServiceEntry.COLUMN_SERV_NAME, serviceName.getText().toString().trim());

        long newID = db.insert(ServiceEntry.TABLE_NAME, null, values);

        if (newID == -1) {
            Toast.makeText(this, getString(R.string.error_save), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.success_save) + newID, Toast.LENGTH_SHORT).show();
        }
    }

    // If there's a DB and there's data in it, the Layout @param dbContents is displayed and the
    // TextView that is contained within gets populated with the DB contents

    private void showDataBase() {
        helper = new ServiceHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                ServiceEntry._ID,
                ServiceEntry.COLUMN_DATE,
                ServiceEntry.COLUMN_ACTION,
                ServiceEntry.COLUMN_PRICE,
                ServiceEntry.COLUMN_SERV_NAME
        };

        Cursor cursor = db.query(ServiceEntry.TABLE_NAME, projection, null, null, null, null, null);
        TextView textView = (TextView) findViewById(R.id.db_contains);

        try {
            if (cursor.getCount() > 0) {
                dbContents.setVisibility(View.VISIBLE);
                textView.setText(getString(R.string.db_contains_text) + cursor.getCount() + getString(R.string.db_contains_text_0));
                textView.append(ServiceEntry._ID + " | "
                        + ServiceEntry.COLUMN_DATE + " | "
                        + ServiceEntry.COLUMN_ACTION + " | "
                        + ServiceEntry.COLUMN_PRICE + " | "
                        + ServiceEntry.COLUMN_SERV_NAME + ";\n");

                int idIndex = cursor.getColumnIndex(ServiceEntry._ID);
                int dateIndex = cursor.getColumnIndex(ServiceEntry.COLUMN_DATE);
                int actionIndex = cursor.getColumnIndex(ServiceEntry.COLUMN_ACTION);
                int priceIndex = cursor.getColumnIndex(ServiceEntry.COLUMN_PRICE);
                int serviceIndex = cursor.getColumnIndex(ServiceEntry.COLUMN_SERV_NAME);

                while (cursor.moveToNext()) {

                    int id = cursor.getInt(idIndex);
                    String dateInd = cursor.getString(dateIndex);
                    String actInd = cursor.getString(actionIndex);
                    int prInd = cursor.getInt(priceIndex);
                    String servInd = cursor.getString(serviceIndex);

                    textView.append("\n" + id + " | " + dateInd + " | " + actInd + " | "
                            + prInd + " | " + servInd + ";");
                }
            }
        } finally {
            cursor.close();
        }
    }
}
