package com.example.p9.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room3.Entity

class Siswa {
    @Entity(tableName = "tblSiswa")
    data class Siswa(
        @PrimaryKey(AutoGenerate = true)
        val id: Int = 0,
        val nama: String,
        val alamat: String,
        val telpon: String
    )
}