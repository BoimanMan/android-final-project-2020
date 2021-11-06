package com.example.finalproject_c00274244

import android.content.Context
import android.content.Context.*
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.finalproject_c00274244.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_activity.*
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.recyclerview.widget.RecyclerView

var db: SQLiteDatabase? = null
var entryRepository: EntryRepository? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        try{
            db = this.openOrCreateDatabase("/data/data/com.example.finalproject_c00274244/databases/entry_database",
                Context.MODE_PRIVATE, null)
        }catch(e: Exception){
            e.printStackTrace()
        }
        //entryRepository = EntryRepository(application)


    }
}