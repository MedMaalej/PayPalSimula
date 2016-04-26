package databaseLib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Payment;
import model.User;

/**
 * Created by root on 6/16/15.
 */
public class DbHelper extends SQLiteOpenHelper{


        // Database Version
        private static final int DATABASE_VERSION = 4;
        // Database Name
        private static final String DATABASE_NAME = "db_transactions";

        // Columns ' names

    //USER
        public static final String idUser = "idUser";
        public static final String userName="userName";
        public static final String userMail="userMail";
        public static final String[] COLUMNS = {idUser,userName,userName};

    //Payments

    public static final String idPayment="idPayment";
    public static final String userId="userId";
    public static final String payPalPaymentId="payPalPaymentId";
    public static final String paymentCreationTime="paymentCreationTime";
    public static final String paymentUpdateTime="paymentUpdateTime";
    public static final String paymentState="paymentState";
    public static final String paymentAmount="paymentAmount";
    public static final String paymentCurrency="paymentCurrency";

    public static final String[] COLUMNS_payments = {idPayment,userId,payPalPaymentId,paymentCreationTime,paymentUpdateTime,paymentState,paymentAmount,paymentCurrency};

    //Tables ' names

        public static final String TABLE_USERS="users";
        public static final String TABLE_PAYMENTS="payments";

        // Constructor

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


    // Override methods
    @Override
    public void onCreate(SQLiteDatabase db) {
/*
        String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_USERS+"( " +
                "idUser INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT, "+
                "userMail TEXT )";
                */
        String CREATE_PAYMENTS_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_PAYMENTS+"( " +
                "idPayment INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userId INTEGER NOT NULL, " +
                "paymentCreationTime TEXT, "+
                "paymentUpdateTime TEXT, "+
                "paymentState INTEGER, "+
                "paymentAmount DOUBLE, "+
                "paymentCurrency TEXT "+
               ")";

        Log.i("PAYMENTS QUERY", CREATE_PAYMENTS_TABLE);


        // create books table
       // db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_PAYMENTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PAYMENTS);
        this.onCreate(db);
    }


    @Override
    public void onConfigure(SQLiteDatabase db){

        db.setForeignKeyConstraintsEnabled(true);

    }
    //****************************** USERS **************************************
    // CRUD Operations

/*
    // add a user
    public void addUser(User u){
        Log.d("addUser", u.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(userName, u.getUserName());
        values.put(userMail, u.getUserMail());

        // 3. insert
        db.insert(TABLE_USERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        Log.i("User inserted","SUCCESS");
        // 4. close
        db.close();
    }
    // get one user
    public User getUser(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_USERS, // a. table
                        COLUMNS, // b. column names
                        " idUser = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        User usr = new User();
        usr.setIdUser(Integer.parseInt(cursor.getString(0)));
        usr.setUserName(cursor.getString(1));
       usr.setUserMail(cursor.getString(2));


        Log.d("User(" + id + ")", usr.toString());

        // 5. return user
        return usr;
    }
// list all users
public List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();

    // 1. build the query
    String query = "SELECT  * FROM " + TABLE_USERS;

    // 2. get reference to writable DB
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(query, null);

    // 3. go over each row, build user and add it to list
    User usr= null;
    if (cursor.moveToFirst()) {
        do {
            usr = new User();
            usr.setIdUser(Integer.parseInt(cursor.getString(0)));
            usr.setUserName(cursor.getString(1));
            usr.setUserMail(cursor.getString(2));



            users.add(usr);
        } while (cursor.moveToNext());
    }

    Log.d("getAllUsers()", users.toString());

    return users;
}


    public int updateUser(User usr) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(userName, usr.getUserName());
        values.put(userMail, usr.getUserMail());

        // 3. updating row
        int i = db.update(TABLE_USERS, //table
                values, // column/value
                idUser+" = ?", // selections
                new String[] { String.valueOf(usr.getIdUser()) }); //selection args

        // 4. close
        db.close();

        return i;

    }
    //Table USER :delete all records
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,null,null);
    }

    // delete one record

    public void deleteUser(int i)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, idUser + "=" + i, null);
    }
    public User findUserByCredentials(String name,String email)
    {
        String selectQuery = "SELECT * FROM "+TABLE_USERS+" WHERE userName=? and userMail=?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{name,email});


        // 3. go over each row, build user and add it to list
        User usr = null;
        if (cursor != null) {
            cursor.moveToFirst();
            usr = new User();
            usr.setIdUser(Integer.parseInt(cursor.getString(0)));
            usr.setUserName(cursor.getString(1));
            usr.setUserMail(cursor.getString(2));

        }
        return usr;




        }
        */
    //********************************** PAYMENTS ***************************************************************
    //ADD
    public void addPayment(Payment p){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(userId,p.getUserId());
        values.put(paymentCreationTime,p.getPaymentCreationTime());
        values.put(paymentUpdateTime,p.getPaymentUpdateTime());
        values.put(paymentState,p.getPaymentState());
        values.put(paymentAmount,p.getPaymentAmount());
        values.put(paymentCurrency,p.getPaymentCurrency());

        // 3. insert
        db.insert(TABLE_PAYMENTS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        Log.i("Payment inserted","SUCCESS");
        // 4. close
        db.close();
    }
    // GET ALL
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<Payment>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_PAYMENTS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build user and add it to list
        Payment pay= null;
        if (cursor.moveToFirst()) {
            do {
                pay = new Payment();
                pay.setIdPayment(cursor.getInt(0));
                pay.setUserId(cursor.getInt(1));
                pay.setPaymentCreationTime(cursor.getString(2));
                pay.setPaymentUpdateTime(cursor.getString(3));
                pay.setPaymentState(cursor.getInt(4));
                pay.setPaymentAmount(cursor.getDouble(5));
                pay.setPaymentCurrency(cursor.getString(6));



               payments.add(pay);
            } while (cursor.moveToNext());
        }

        Log.d("getAllPayments()", payments.toString());

        return payments;
    }

    public int updatePayment(Payment p) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(userId,p.getUserId());
        values.put(paymentCreationTime,p.getPaymentCreationTime());
        values.put(paymentUpdateTime,p.getPaymentUpdateTime());
        values.put(paymentState,p.getPaymentState());
        values.put(paymentAmount,p.getPaymentAmount());
        values.put(paymentCurrency,p.getPaymentCurrency());
        // 3. updating row
        int i = db.update(TABLE_PAYMENTS, //table
                values, // column/value
                idPayment+" = ?", // selections
                new String[] { String.valueOf(p.getIdPayment()) }); //selection args

        // 4. close
        db.close();

        return i;

    }
    public void deletePayment(int i)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PAYMENTS, idPayment + "=" + i, null);
    }
    public void deleteAllPayments()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PAYMENTS,null,null);
    }

    }

