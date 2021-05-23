package com.gt.funapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.gt.data.datasource.remote.api.SocialChannelService
import com.gt.data.datasource.remote.network.socialchannel.SocialChannelRemoteDataSourceImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //just for testing api and GSON parser direct hit and print reposnse to test data layer
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apps-ivacy.s3.amazonaws.com/staging/android/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()

        GlobalScope.launch {
            val call = SocialChannelRemoteDataSourceImpl(retrofit.create(SocialChannelService::class.java))
            print(call.getSocialChannelList())
        }
    }
}