package io.github.timladenov.project_9_habittracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import io.github.timladenov.project_9_habittracker.db.ServiceContract.*;


/**
 * Created by tmladenov on 14.07.17.
 */

public class ServiceHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "service.db";
    private static final int DBVER = 1;

    public ServiceHelper(Context context) {
        super(context, DBNAME, null, DBVER);
    }

    public ServiceHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE_service = "create table " + ServiceEntry.TABLE_NAME + "("
                + ServiceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ServiceEntry.COLUMN_DATE + " TEXT NOT NULL, "
                + ServiceEntry.COLUMN_ACTION + " TEXT NOT NULL, "
                + ServiceEntry.COLUMN_PRICE + " INTEGER NOT NULL DEFAULT 0, "
                + ServiceEntry.COLUMN_SERV_NAME + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TABLE_service);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
