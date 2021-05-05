package com.example.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    //data source
    private val ballList = ArrayList<Balls>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTitleBinding.inflate(inflater, container, false)

        //setup our initial data
        initBallList()

        //configure the recyclerview
//        val layoutManager = LinearLayoutManager(this)
//        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.setHasFixedSize(true)
        val adapter = BallAdapter(ballList)
        //pass by reference
        binding.recyclerview.adapter = adapter

        //add a divider line
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerview.addItemDecoration(dividerItemDecoration)
//        binding.recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) //add a divider line

        return binding.root
    }

    private fun initBallList() {

        ballList.add(Balls("Baseball", R.drawable.baseball))
        ballList.add(Balls("Basketball", R.drawable.basketball))
        ballList.add(Balls("Football", R.drawable.football))
        ballList.add(Balls("Other", R.drawable.other))
    }
}