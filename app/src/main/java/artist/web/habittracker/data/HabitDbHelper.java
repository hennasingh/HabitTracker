package artist.web.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 8/24/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String TAG = HabitDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habitTracker.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String NOT_NULL = " NOT NULL";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                    HabitContract.HabitEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    HabitContract.HabitEntry.COLUMN_HABIT_NAME + TEXT_TYPE + NOT_NULL + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_DATE + TEXT_TYPE + NOT_NULL + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_DAY + INTEGER_TYPE + NOT_NULL + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_START_TIME + TEXT_TYPE + NOT_NULL + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_FINISH_TIME + TEXT_TYPE + NOT_NULL + COMMA_SEP +
                    HabitContract.HabitEntry.COLUMN_HABIT_NOTE + TEXT_TYPE + " )";


    public HabitDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("SYNTAX: ",SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so no action needed here
    }

    public void insertHabit(String name, String date, int day, String start,String finish, String note) {

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, name);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DATE, date);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DAY, day);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_START_TIME, start);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_FINISH_TIME, finish);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NOTE, note);

        SQLiteDatabase writableDatabase = getWritableDatabase();

        long result = writableDatabase.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        if (result != -1) {
            Log.i(TAG, "Insert row succesful ID = " + result);
        } else {
            Log.i(TAG, "Insert row unsuccesful");
        }
    }

    /**
     * Method to read and print(in Logs) records present in database.
     *
     * @return Cursor object
     */
    public Cursor readHabit() {
        SQLiteDatabase readableDatabase = getReadableDatabase();

        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_DATE,
                HabitContract.HabitEntry.COLUMN_HABIT_DAY,
                HabitContract.HabitEntry.COLUMN_HABIT_START_TIME,
                HabitContract.HabitEntry.COLUMN_HABIT_FINISH_TIME,
                HabitContract.HabitEntry.COLUMN_HABIT_NOTE
        };

        Cursor cursor = readableDatabase.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }
}
