package dev.passerby.numbersgameprojectcourse.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.passerby.numbersgameprojectcourse.R
import dev.passerby.numbersgameprojectcourse.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    private fun launchChooseLevelFragment() {
        parentFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.main_container, ChooseLevelFragment.newInstance()).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}