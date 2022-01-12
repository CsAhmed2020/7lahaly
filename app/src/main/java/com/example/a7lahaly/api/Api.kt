package com.example.a7lahaly.api

import com.example.a7lahaly.model.User
import com.example.a7lahaly.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("ClientRegister")
    fun createUser(@Body params: User): Call<UserResponse>

}

/*fun createUser(
        @Field("Id") id:Int,
        @Field("Name") name:String,
        @Field("Age") age:String,
        @Field("Email") email:String,
        @Field("Phone") phone:String,
        @Field("Password") password:String,
        @Field("Government_Id") government_id:String,
        @Field("Government_Name") government_name:String,
        @Field("College_Id") college_id:String,
        @Field("College_Name") college_name:String,
        @Field("field") field:String,
        @Field("Level") level:String,
        @Field("QuestionAnswer") question_answer:Int,
        @Field("QuestionAvailable") question_available:Int,
        @Field("Credit") credit:Int
    ): Call<DefaultResponse>*/