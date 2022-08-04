package com.reift.viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var scoreA: MutableLiveData<Int>? = MutableLiveData(0)
    var scoreB: MutableLiveData<Int>? = MutableLiveData(0)

    fun addScoreA(){
        scoreA?.value = scoreA?.value?.plus(1)
    }

    fun addScoreB(){
        scoreB?.value = scoreB?.value?.plus(1)
    }

    fun minScoreA(){
        val result = scoreA?.value?.minus(1)
        if(result!! < 0){
            scoreA?.value = 0
        } else {
            scoreA?.value = result
        }
    }

    fun minScoreB(){
        val result = scoreB?.value?.minus(1)
        if(result!! < 0){
            scoreB?.value = 0
        } else {
            scoreB?.value = result
        }
    }

    fun resetScore(){
        scoreA?.value = 0
        scoreB?.value = 0
    }

    fun getScoreA(): LiveData<Int>?{
        if(scoreA == null){
            scoreA?.value = 0
        }
        return scoreA
    }

    fun getScoreB(): LiveData<Int>?{
        if(scoreB == null){
            scoreB?.value = 0
        }
        return scoreB
    }
}