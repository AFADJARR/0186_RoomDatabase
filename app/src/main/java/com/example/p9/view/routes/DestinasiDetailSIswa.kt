package com.example.p9.view.routes

import com.example.p9.R
import com.example.p9.uicontroller.DestinasiNavigasi

object DestinasiDetailSIswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val ItemIdArg = "itemId"
    val routeWithArgs = "$route/{$ItemIdArg}"
}
