package com.example.p9.view.route

import com.example.p9.R

object DestinasiDetailSIswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val ItemIdArg = "itemId"
    val routeWithArgs = "$route/{$ItemIdArg}"
}
