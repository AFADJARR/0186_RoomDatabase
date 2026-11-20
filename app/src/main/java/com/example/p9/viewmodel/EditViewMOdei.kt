package com.example.p9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p9.repository.RepositoriSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewMOdei(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa): ViewModel(){

    var uiSTateSiswa by mutableStateOf(UIStateSiswa())
    private set

    private val idSiswa: Int =checkNotNull(savedStateHandle[DestinasiDetailSIswa.ItemIdArg])
        init {
            viewModelScope.launch{
                uiSTateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                    .filterNotNull()
                    .first()
                    .toUiStateSiswa()
            }
            uiSTateSiswa =
                UIStateSiswa(detailSiswa = detailSiswa,
                    isEntryValid = ValidasiInput(detailSiswa))
        }

    private fun validasiInput(uiState: DetailSiswa = uiSTateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}
