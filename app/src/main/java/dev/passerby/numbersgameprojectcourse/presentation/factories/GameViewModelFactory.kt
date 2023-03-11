package dev.passerby.numbersgameprojectcourse.presentation.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.passerby.numbersgameprojectcourse.domain.entity.Level
import dev.passerby.numbersgameprojectcourse.presentation.viewmodels.GameViewModel

class GameViewModelFactory(
    private val level: Level,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)){
            return GameViewModel(application, level) as T
        } else {
            throw RuntimeException("Unknown view model class")
        }
    }
}