package com.example.praktikum10.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.praktikum10.data.dao.MahasiswaDao
import com.example.praktikum10.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDataBase : RoomDatabase() {
    //mengidentufikasi fungsi untuk mengakses data mahasiswa

    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile //Memastikam bahwa nilai variabel instance selalu sama di semua thread
        private var Instance: KrsDataBase? = null


        fun getDatabase(context: Context): KrsDataBase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDataBase::class.java, //class database
                    "KrsDatabase" // Nama database
                )
                    .build().also { Instance = it }
            })
        }

    }
}


