package com.example.raul_carricoba_examen2tdual.ui.tresEnRaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.raul_carricoba_examen2tdual.databinding.FragmentGanadorBinding

class TresEnRayaGanadorFragment : Fragment() {
    private var _binding: FragmentGanadorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGanadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TresEnRayaGanadorFragmentArgs.fromBundle(requireArguments()).ganador?.let {
            binding.tvGanador.visibility = View.VISIBLE
            binding.textSlideshow.text = it
        }

    }


}