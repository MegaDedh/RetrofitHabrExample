package ru.asshands.softwire.retrofithabrexample

import retrofit2.Call
import retrofit2.http.*

interface JSONPlaceHolderApi {

    @GET("/posts/{id}")
    fun getPostWithID(@Path("id") id: Int): Call<Post>


    //Получение списка сообщений
    @GET("/posts")
    fun getAllPosts(): Call<List<Post>>

    //Отправка запроса с параметром
    @GET("/posts")
    fun getPostOfUser(@Query("userId") id: Int): Call<List<Post>>

    //Отправка POST запроса
    //@Body указывает на то, что этот объект должен быть передан в теле запроса.
    @POST("/posts")
    fun postData(@Body data: Post): Call<Post>
}