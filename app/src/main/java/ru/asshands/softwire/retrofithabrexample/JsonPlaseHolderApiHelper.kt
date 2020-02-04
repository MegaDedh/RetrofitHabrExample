package ru.asshands.softwire.retrofithabrexample

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val jsonPlaceHolderApi = RetrofitFactory.getJSONApi()


fun getPostWithID(id: Int) {

    jsonPlaceHolderApi
        .getPostWithID(id)
        .enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (response.isSuccessful){
                    // запрос выполнился успешно, сервер вернул Status 200
                    val post = response.body()

                    Log.d("TEXT-JSON:", "${post?.id}")
                    Log.d("TEXT-JSON:", "${post?.userId}")
                    Log.d("TEXT-JSON:", post?.title)
                    Log.d("TEXT-JSON:", post?.body)
                } else {
                    // сервер вернул ошибку
                    Log.d("TEXT-JSON:", "Server error!")
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                //// ошибка во время выполнения запроса
                t.printStackTrace()
                Log.d("TEXT-JSON:", "Error occurred while getting request!")
            }
        })
}

fun getAllPosts() {
    jsonPlaceHolderApi
        .getAllPosts()
        .enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val allPosts = response.body()
                Log.d("TEXT-JSON_getAllPosts", "${allPosts?.toString()}")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
                Log.d("TEXT-JSON_getAllPosts", "Error occurred while getting request!")
            }
        })
}

fun getPostOfUser(userId: Int) {
    jsonPlaceHolderApi
        .getPostOfUser(userId)
        .enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val allPosts = response.body()
                Log.d("TEXT-JSON_getPostOfUser", "${allPosts?.toString()}")
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
                Log.d("TEXT-JSON_getPostOfUser", "Error occurred while getting request!")
            }
        })
}

fun postData(data: Post) {
    jsonPlaceHolderApi
        .postData(data)
        .enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                val allPosts = response.body()
                Log.d("TEXT-JSON_postData", "${allPosts?.toString()}")
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                t.printStackTrace()
                Log.d("TEXT-JSON_postData", "Error occurred while getting request!")
            }
        })
}