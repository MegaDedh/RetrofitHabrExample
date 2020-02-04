package ru.asshands.softwire.retrofithabrexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPostWithID(1)
        getAllPosts()
        getPostOfUser(1)
        val myPost = Post(1,1,"Title","SomeText")
        postData(myPost)
    }
}