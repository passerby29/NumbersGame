package dev.passerby.numbersgameprojectcourse.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.passerby.numbersgameprojectcourse.R
import dev.passerby.numbersgameprojectcourse.databinding.FragmentGameBinding
import dev.passerby.numbersgameprojectcourse.domain.entity.GameResult
import dev.passerby.numbersgameprojectcourse.domain.entity.GameSettings
import dev.passerby.numbersgameprojectcourse.domain.entity.Level

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    private lateinit var level: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.setOnClickListener {
            launchGameFinishedFragment(
                GameResult(
                    true,
                    0,
                    0,
                    GameSettings(0, 0, 0, 0)
                )
            )
        }
    }

    private fun parseArgs() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(KEY_LEVEL, Level::class.java)?.let { level = it }
        } else {
            @Suppress("DEPRECATION")
            requireArguments().getParcelable<Level>(KEY_LEVEL)?.let { level = it }
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        parentFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult)).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val KEY_LEVEL = "level"
        const val NAME = "GameFragment"
        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}