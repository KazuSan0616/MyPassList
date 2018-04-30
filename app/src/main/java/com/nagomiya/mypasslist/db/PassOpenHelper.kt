package com.nagomiya.mypasslist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

class PassOpenHelper(context: Context): ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)  {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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