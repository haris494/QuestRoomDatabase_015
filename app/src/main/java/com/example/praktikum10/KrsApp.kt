package com.example.praktikum10

import android.app.Application
import com.example.praktikum10.dependeciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp //Fungsinya untuk menyimpan instance

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)// membuat instance containerApp
        // instance adalah object yang dibuat dari class
    }
}