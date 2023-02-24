package dev.passerby.numbersgameprojectcourse.domain.usecases

import dev.passerby.numbersgameprojectcourse.domain.entity.Question
import dev.passerby.numbersgameprojectcourse.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question{
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}
