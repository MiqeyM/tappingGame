package com.example.android.tappinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.recycler.ScoreAdapter


class ScoreActivity : AppCompatActivity() {

//    private val viewModel by lazy(::provideViewModel)

private val scoreViewModel by lazy { ViewModelProviders.of(this)}
private val adapter = ScoreAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.score_recycler_view)
        recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(this)



    }

//
//    private fun provideViewModel(): = ViewModelProviders
//        .of(this, ViewModelFactory(requireActivity().application))
//        .get(ScoreViewModel::class.java)
}
