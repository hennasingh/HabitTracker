package artist.web.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import artist.web.habittracker.data.HabitContract;
import artist.web.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        //Insert record 1
        mDbHelper.insertHabit("Yoga",
                "25-08-2017",
                HabitContract.HabitEntry.FRIDAY,
                "6 AM",
                "7 AM",
                "Body Sculpting Asans");

        //Insert record 2
        mDbHelper.insertHabit("Study Cloud Architecture",
                "25-08-2017",
                HabitContract.HabitEntry.SATURDAY,
                "8 AM",
                "10 AM",
                "Deployment and Service Models");


        //Reading from database and printing them in Logs
        Cursor readCursor = mDbHelper.readHabit();

           try {
                int idColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry._ID);
                int nameColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_NAME);
                int dateColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_DATE);
                int dayColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_DAY);
                int startColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_START_TIME);
                int finishColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_FINISH_TIME);
               int noteColumnIndex = readCursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_NOTE);

               Log.i(LOG_TAG, "ID | NAME | DATE | DAY | START TIME | FINISH TIME | NOTES ");
               while (readCursor.moveToNext()) {
                   int id = readCursor.getInt(idColumnIndex);
                   String name = readCursor.getString(nameColumnIndex);
                   String date = readCursor.getString(dateColumnIndex);
                   int day = readCursor.getInt(dayColumnIndex);
                   String startTime = readCursor.getString(startColumnIndex);
                   String finishTime = readCursor.getString(finishColumnIndex);
                   String notes = readCursor.getString(noteColumnIndex);

                   Log.d(LOG_TAG, id + " " +
                           name + " " +
                           date + " " +
                           day + " " +
                           startTime + " " +
                           finishTime + " " +
                           notes);
               }

           } finally {
                readCursor.close();
            }
        }
    }
