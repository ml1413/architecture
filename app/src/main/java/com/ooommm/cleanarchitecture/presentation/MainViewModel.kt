package com.ooommm.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ooommm.cleanarchitecture.domain.models.SaveUserNameParem
import com.ooommm.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.ooommm.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData


    init {
        Log.e("AAA", "VM created")
    }

    fun getResultLive(): LiveData<String> {
        return resultMutableLiveData
    }

    override fun onCleared() {
        Log.e("AAA", "VM clear")

        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParem(name = text)
        val recult = saveUserNameUseCase.execute(param = params)
        resultMutableLiveData.value = "Save result $recult"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultMutableLiveData.value = "${userName.firstName} ${userName.lastName}"
    }
}