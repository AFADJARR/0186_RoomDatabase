package com.example.p9.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.example.p9.repository.RepositoriSiswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa) : ViewMOdel(){

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.ItemIdArg])

    val uiDetailState: StateFlow<DetailSiswaUiState> =
        repositoriSiswa.getSiswaStream(idSiswa)
            .filterNotNull()
            .map{
                DetailSiswaUiState(detailSiswa = it.toDetailSiswa())
            }.StateIn(
                scope = vewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailSiswaUiState()
            )
}
