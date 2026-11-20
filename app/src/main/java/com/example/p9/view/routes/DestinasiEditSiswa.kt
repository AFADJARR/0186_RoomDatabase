package com.example.p9.view.routes

import com.example.p9.R
import com.example.p9.uicontroller.DestinasiNavigasi

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}