package dev.passerby.numbersgameprojectcourse.domain.repository

import dev.passerby.numbersgameprojectcourse.domain.entity.GameSettings
import dev.passerby.numbersgameprojectcourse.domain.entity.Level
import dev.passerby.numbersgameprojectcourse.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}