package artist.web.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by User on 8/24/2017.
 */

public class HabitContract {

    private HabitContract(){

    }

    /**inner class that defines the table contents*/

    public static class HabitEntry implements BaseColumns{

        //name of the table
        public static final String TABLE_NAME= "habitsTracker";

        //unique auto increment id
        public static final String _ID = BaseColumns._ID;

        //name of the habit
        public static final String COLUMN_HABIT_NAME = "habit_name";

        //date when it was done
        public static final String COLUMN_HABIT_DATE = "habit_date";

        //day of the week when it was done
        public static final String COLUMN_HABIT_DAY = "habit_dayOfWeek";

        //habit start time
        public static final String COLUMN_HABIT_START_TIME ="habit_startTime";

        //habit finish time
        public static final String COLUMN_HABIT_FINISH_TIME= "habit_finishTime";

        //any notes and comments to be taken
        public static final String COLUMN_HABIT_NOTE = "habit_notes";


        public static final int MONDAY = 1;
        public static final int TUESDAY = 2;
        public static final int WEDNESDAY = 3;
        public static final int THURSDAY = 4;
        public static final int FRIDAY =5;
        public static final int SATURDAY =6;
        public static final int SUNDAY =7;
    }
}
