package com.example.raul_carricoba_examen2tdual.ui.adivinaPalabra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navGraphViewModels
import com.example.raul_carricoba_examen2tdual.R
import com.example.raul_carricoba_examen2tdual.databinding.FragmentAdivinaBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class AdivinaFragment : Fragment() {

    private var _binding: FragmentAdivinaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AdivinaViewModel
            by navGraphViewModels(R.id.mobile_navigation) {
                defaultViewModelProviderFactory
            }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAdivinaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.correctButton.setOnClickListener { viewModel.onCorrect() }
        binding.skipButton.setOnClickListener { viewModel.onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }


        viewModel.word.observe(viewLifecycleOwner) {
            binding.wordText.text = it
        }

        viewModel.score.observe(viewLifecycleOwner) {
            binding.scoreText.text = it.toString()
        }

        viewModel.finished.observe(viewLifecycleOwner) {
            /*
            Snackbar.make(viewModel, "No quedan más palabras", Snackbar.LENGTH_LONG)
                .setAction("Reiniciar") {
                    onReiniciar()
                }
                .show()

             */
        }
    }

    private fun onEndGame() {
        Toast.makeText(activity, "La partida ha terminado", Toast.LENGTH_SHORT).show()
        NavHostFragment.findNavController(this)
            .navigate(AdivinaFragmentDirections.actionGameToScore())
    }

}