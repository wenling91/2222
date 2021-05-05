package com.example.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.recyclerviewexample.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater)

        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        binding.ballName.text = args.name

        when {
            args.name == "Baseball" -> {

                binding.detailImageView.setImageResource(R.drawable.baseball_photo)
            }
            args.name == "Basketball" -> {

                binding.detailImageView.setImageResource(R.drawable.basketball_photo)
            }
            args.name == "Football" -> {

                binding.detailImageView.setImageResource(R.drawable.football_photo)
            }
            else -> {

                binding.detailImageView.setImageResource(R.drawable.other_photo)
            }
        }

        return binding.root
    }

}