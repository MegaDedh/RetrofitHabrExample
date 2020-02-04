package ru.asshands.softwire.retrofithabrexample


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {

    companion object {
        private const val baseUrl = "https://jsonplaceholder.typicode.com"

        fun getJSONApi() = getRetrofitInstance()
            .create(JSONPlaceHolderApi::class.java)!!

        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getOkHttpInstance(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
    }
}