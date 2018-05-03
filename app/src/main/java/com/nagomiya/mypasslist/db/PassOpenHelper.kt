package com.nagomiya.mypasslist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class PassOpenHelper(context: Context): ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)  {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // DBとテーブルを作成
        db?.createTable(
                TABLE_NAME,
                true,
                "_id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "title" to TEXT,
                "uid" to TEXT,
                "password" to TEXT
        )
    }

    // 定数
    companion object {
        private val DB_NAME = "PassEntity"
        private  val DB_VERSION = 1
        val TABLE_NAME = "Password"

        // 自分自身のオブジェクトを保持する変数
        private var instance: PassOpenHelper? = null

        // 自分自身のオブジェクトを返すメソッド
        @Synchronized
        fun getInstace(context: Context): PassOpenHelper{
            return instance ?: PassOpenHelper(context.applicationContext)
        }
    }

}