package com.example.roomsiswa.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class DatabaseSiswa: RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    companion object{
        @Volatile
        private var INSTANCE: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa{
            return(INSTANCE?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabaseSiswa::class.java,
                    "siswa_database")
                    .build().also { INSTANCE = it }
            })
        }
    }
}