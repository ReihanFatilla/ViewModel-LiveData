package com.reift.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.reift.viewmodel_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var listener: View.OnClickListener
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getScoreA()?.observe(this){
            binding.tvScoreTeamA.text = it.toString()
        }

        viewModel.getScoreB()?.observe(this){
            binding.tvScoreTeamB.text = it.toString()
        }

        setUpOnViewClick()
        binding.btnMinusScoreTeamA.setOnClickListener(listener)
        binding.btnMinusScoreTeamB.setOnClickListener(listener)
        binding.btnPlusScoreTeamA.setOnClickListener(listener)
        binding.btnPlusScoreTeamB.setOnClickListener(listener)
        binding.btnReset.setOnClickListener(listener)

    }

    private fun setUpOnViewClick() {
        listener = View.OnClickListener { view ->
            when(view?.id){
                R.id.btnPlusScoreTeamA -> {
                    viewModel.addScoreA()
                }
                R.id.btnPlusScoreTeamB -> {
                    viewModel.addScoreB()
                }
                R.id.btnMinusScoreTeamA -> {
                    viewModel.minScoreA()
                }
                R.id.btnMinusScoreTeamB -> {
                    viewModel.minScoreB()
                }
                R.id.btnReset -> {
                    viewModel.resetScore()
                }
            }
        }
    }

//    private fun addScoreA(){
//        scoreA += 1
//        binding.tvScoreTeamA.text = scoreA.toString()
//    }
//
//    private fun addScoreB(){
//        scoreB += 1
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }
//
//    private fun minScoreA(){
//        scoreA -= 1
//        binding.tvScoreTeamA.text = scoreA.toString()
//    }
//
//    private fun minScoreB(){
//        scoreB -= 1
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }
//
//    private fun resetScore(){
//        scoreA = 0
//        scoreB = 0
//
//        binding.tvScoreTeamA.text = scoreA.toString()
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }

//    override fun onClick(view: View?) {
//        when(view?.id){
//            R.id.btnPlusScoreTeamA -> {
//
//            }
//            R.id.btnPlusScoreTeamB -> {
//
//            }
//            R.id.btnMinusScoreTeamA -> {
//
//            }
//            R.id.btnMinusScoreTeamB -> {
//
//            }
//            R.id.btnReset -> {
//
//            }
//        }
//    }
}