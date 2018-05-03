package com.nagomiya.mypasslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.nagomiya.mypasslist.db.PassOpenHelper
import com.nagomiya.mypasslist.db.PasswordRowParser

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import java.sql.Struct

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivity<RegistPassActivity>()
        }
    }

    override fun onResume() {
        super.onResume()

        val helper = PassOpenHelper(applicationContext)

        helper.use {
            val list = select(PassOpenHelper.TABLE_NAME)
                    .orderBy("_id", SqlOrderDirection.DESC)
                    .parseList(PasswordRowParser())

            // ListViewのAdapterに情報をセット
            passList.adapter = ArrayAdapter<String>(
                    this@MainActivity,
                    R.layout.pass_row,
                    list.map { "${it.title}:\n${it.uid} / ${it.password}" }
            )

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
