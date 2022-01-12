package com.example.a7lahaly.model

 data class User(val Name:String,val Age:String,
           val Email:String, val Phone :String ,
           val Password:String,val Government_Id:Int,
           val College_Id:Int,
           val field:String,
           val Level:String
           )

data class UserResponse(val code: Int?, val meta: String?, val data: User?)