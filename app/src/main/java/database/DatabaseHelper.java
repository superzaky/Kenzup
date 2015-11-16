package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import model.User;

/**
 * Created by yomac_000 on 7-11-2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Kenzup.db";

    public static final String TABLE_USERS = "users";



    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    DatabaseEntry.KEY_ID + " INTEGER PRIMARY KEY, " +
                    DatabaseEntry.KEY_NAME + " TEXT, " +
                    DatabaseEntry.KEY_EMAIL + "TEXT, " +
                    DatabaseEntry.KEY_PASSWORD + "TEXT" +
                    DatabaseEntry.KEY_CREATED_AT + "DATETIME" +
                    DatabaseEntry.KEY_UPDATED_AT + "DATETIME" + ");";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Adding new user
    public void addUser(User user) {
        System.out.println("adding user");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseEntry.KEY_NAME, user.getName());
//        values.put(KEY_PH_NO, user.getEmail());
//        values.put(KEY_EMAIL, user.getPassword());
        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        //db.close(); // Closing database connection
        System.out.println("adding user DONE");
    }

    // Get all users
//    public void getUsers() {
//        System.out.println("adding user");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DatabaseEntry.KEY_NAME, user.getName());
////        values.put(KEY_PH_NO, user.getEmail());
////        values.put(KEY_EMAIL, user.getPassword());
//        // Inserting Row
//        db.insert(TABLE_USERS, null, values);
//        //db.close(); // Closing database connection
//        System.out.println("adding user DONE");
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // create new tables
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /* Inner class that defines the table contents */
    public static abstract class DatabaseEntry implements BaseColumns {
        // Common column names
        private static final String KEY_ID = "id";
        private static final String KEY_CREATED_AT = "created_at";
        private static final String KEY_UPDATED_AT = "updated_at";

        // USERS Table - column names
        private static final String KEY_NAME = "name";
        private static final String KEY_EMAIL = "email";
        private static final String KEY_PASSWORD = "password";

    }
}
