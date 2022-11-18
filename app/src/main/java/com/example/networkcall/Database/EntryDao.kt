package com.example.networkcall.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.networkcall.Model.Entry

@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(entry: List<Entry>)

    @Query("SELECT * FROM entrytable")
    fun fetchAllData(): LiveData<List<Entry>>

    @Query("DELETE FROM entrytable")
    fun deleteTable()
}