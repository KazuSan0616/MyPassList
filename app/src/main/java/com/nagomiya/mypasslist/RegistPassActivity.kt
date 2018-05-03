package com.nagomiya.mypasslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nagomiya.mypasslist.db.PassOpenHelper
import kotlinx.android.synthetic.main.activity_regist_pass.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class RegistPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist_pass)
    }

    fun addPass(view:View) {
        val helper = PassOpenHelper(applicationContext)

        helper.use {
            insert(PassOpenHelper.TABLE_NAME,
                    "title" to titleEditText.text.toString(),
                    "uid" to userIdEditText.text.toString(),
                    "password" to passEditText.text.toString())
        }

        toast("データを追加しました。")
        finish()
    }
}
