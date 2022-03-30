package com.example.raul_carricoba_examen2tdual.ui.tresEnRaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.raul_carricoba_examen2tdual.databinding.FragmentAdivinaBinding
import com.example.raul_carricoba_examen2tdual.databinding.FragmentTresenrayaBinding

class TresEnRayaFragment : Fragment() {

    private var _binding: FragmentTresenrayaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTresenrayaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(TresEnRayaFragmentDirections.actionNavTresToNavJuego())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}