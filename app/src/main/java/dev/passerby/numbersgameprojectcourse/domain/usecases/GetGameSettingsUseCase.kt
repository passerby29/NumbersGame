package dev.passerby.numbersgameprojectcourse.domain.usecases

import dev.passerby.numbersgameprojectcourse.domain.entity.GameSettings
import dev.passerby.numbersgameprojectcourse.domain.entity.Level
import dev.passerby.numbersgameprojectcourse.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}