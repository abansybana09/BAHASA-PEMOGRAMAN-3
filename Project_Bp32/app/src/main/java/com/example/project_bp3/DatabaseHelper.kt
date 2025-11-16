package com.example.project_bp3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "WudhuApp.db"
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUsersTable = ("CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT" + ")")
        db?.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(user: User) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_USERNAME, user.username)
        values.put(KEY_PASSWORD, user.password)
        db.insert(TABLE_USERS, null, values)
        db.close()
    }

    fun getUser(username: String): User? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_USERS, arrayOf(KEY_ID, KEY_USERNAME, KEY_PASSWORD),
            "$KEY_USERNAME=?", arrayOf(username), null, null, null, null
        )
        if (cursor != null && cursor.moveToFirst()) {
            val user = User(
                id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)),
                username = cursor.getString(cursor.getColumnIndexOrThrow(KEY_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PASSWORD))
            )
            cursor.close()
            return user
        }
        cursor?.close()
        return null
    }
}

data class User(val id: Int? = null, val username: String, val password: String)
