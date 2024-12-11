package com.example.praktikum10.dependeciesinjection

import android.content.Context
import com.example.praktikum10.data.database.KrsDataBase
import com.example.praktikum10.repository.LocalRepositoryMhs
import com.example.praktikum10.repository.RepositoryMhs


interface InterfaceCountainerApp{
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private  val context: Context) : InterfaceCountainerApp{
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDataBase.getDatabase(context).mahasiswaDao())
    }
}

