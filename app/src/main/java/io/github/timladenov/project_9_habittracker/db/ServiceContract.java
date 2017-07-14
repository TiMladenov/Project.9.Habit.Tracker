package io.github.timladenov.project_9_habittracker.db;

import android.provider.BaseColumns;

/**
 * Created by tmladenov on 14.07.17.
 */

public class ServiceContract {
    private ServiceContract() {
    }

    public static final class ServiceEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ACTION = "action";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_SERV_NAME = "service_name";
        public static String TABLE_NAME = "service";
    }
}
