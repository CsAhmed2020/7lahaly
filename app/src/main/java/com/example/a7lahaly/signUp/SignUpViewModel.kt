package com.example.a7lahaly.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a7lahaly.api.Api
import com.example.a7lahaly.api.RetrofitClient
import com.example.a7lahaly.model.User
import com.example.a7lahaly.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {

    lateinit var createNewUserLiveData: MutableLiveData<UserResponse?>
    init {
        createNewUserLiveData = MutableLiveData()
    }
    fun getCreateNewUserObserver(): MutableLiveData<UserResponse?> {
        return createNewUserLiveData
    }

    fun createNewUser(user: User) {
        val retroService  = RetrofitClient.getClientInstance().create(Api::class.java)
        val call = retroService.createUser(user)
        call.enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })
    }
}