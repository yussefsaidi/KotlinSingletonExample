package com.yussef.kotlinsingletonexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yussef.kotlinsingletonexample.models.User
import com.yussef.kotlinsingletonexample.repository.Repository

class MainViewModel: ViewModel(){

    private val _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userId){userId ->
            Repository.getUser(userId)
        }

    fun setUserId(userId: String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJobs(){
        Repository.cancelJobs()
    }

}