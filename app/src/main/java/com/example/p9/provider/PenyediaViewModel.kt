package com.example.p9.provider

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.p9.viewmodel.DetailViewModel
import com.example.p9.viewmodel.EditViewModei
import com.example.p9.viewmodel.EntrySiswaViewModel
import com.example.p9.viewmodel.HomeViewModel
import com.example.p9.viewmodel.aplikasiSiswa

object PenyediaViewModel{
    val factory = viewModelFactory {
        initializer{
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer{
            EntrySiswaViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer{
            DetailViewModel(this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer{
            EditViewModei(this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}