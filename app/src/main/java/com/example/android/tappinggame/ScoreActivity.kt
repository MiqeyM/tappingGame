package com.example.android.tappinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.recycler.ScoreAdapter
import com.example.android.tappinggame.viewmodel.ScoreViewModel

class ScoreActivity : AppCompatActivity() {

//    private val viewModel by lazy(::provideViewModel)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.score_recycler_view)
        val adapter = ScoreAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }

//
//    private fun provideViewModel(): = ViewModelProviders
//        .of(this, ViewModelFactory(requireActivity().application))
//        .get(ScoreViewModel::class.java)
}
