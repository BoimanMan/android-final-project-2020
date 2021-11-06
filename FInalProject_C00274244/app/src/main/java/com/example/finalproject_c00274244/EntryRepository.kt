package com.example.finalproject_c00274244
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class EntryRepository(application: Application){
    private var entryDao: EntryDao?
    val allEntries: LiveData<List<Entry>>?
    init{
        val db: EntryDatabase? = EntryDatabase.getDatabase(application)
        entryDao = db?.entryDao()
        allEntries = entryDao?.getAllEntries()
    }
    fun insertEntry(newEntry: Entry){
        val task = InsertAsyncTask(entryDao)
        task.execute(newEntry)
    }
    fun deleteEntry(user: String, game: String){
        val task = DeleteAsyncTask(entryDao)
        task.execute(user, game)
    }
    fun findEntry(game: String, username: String) : MutableLiveData<List<Entry>>{
        val task = QueryAsyncTask(entryDao)
        task.delegate = this
        task.execute(game, username)
        return searchResults
    }
    val searchResults = MutableLiveData<List<Entry>>()
    fun asyncFinished(results: List<Entry>){
        searchResults.value = results
    }
    private class QueryAsyncTask constructor(val asyncTaskDao: EntryDao?) :
        AsyncTask<String, Void, List<Entry>>() {
        var delegate :EntryRepository? = null
        override fun doInBackground(vararg params: String): List<Entry>?{
            return asyncTaskDao?.findEntry(params[0],params[1])
        }
        override fun onPostExecute(result: List<Entry>) {
            delegate?.asyncFinished(result)
        }
    }
    private class InsertAsyncTask constructor(private val asyncTaskDao:
                                              EntryDao?) : AsyncTask<Entry, Void, Void>() {
        override fun doInBackground(vararg params: Entry): Void? {
            asyncTaskDao?.insertEntry(params[0])
            return null
        }
    }
    private class DeleteAsyncTask constructor(private val asyncTaskDao:
                                              EntryDao?) : AsyncTask<String, Void, Void>() {
        override fun doInBackground(vararg params: String): Void? {
            asyncTaskDao?.deleteEntry(params[0], params[1])
            return null
        }
    }

}