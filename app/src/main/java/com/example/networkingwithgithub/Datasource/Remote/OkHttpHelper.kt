package com.example.networkingwithgithub.Datasource.Remote

import android.util.Log
import com.example.networkingwithgithub.Model.User.Item
import com.example.networkingwithgithub.Model.User.Repos
import org.greenrobot.eventbus.EventBus
import java.io.IOException
import com.google.gson.Gson
import okhttp3.*

class OkHttpHelper {
    private fun getClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().build()
        return okHttpClient
    }

    fun makeAsyncApiCall(url: String) {
        val request = Request.Builder().url(url).build()
        getClient().newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {

                val json1 = response.body?.string()
                val itemResults = Gson().fromJson<Item>(json1, Item::class.java)
                EventBus.getDefault().post(itemResults)
                Log.d("TAG", json1)

                val json2 = response.body?.string()
                val repoResults = Gson().fromJson<Repos>(json2, Repos::class.java)
                EventBus.getDefault().post(repoResults)
                Log.d("TAG", json2)
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.e("ERROR_TAG", "Error in makeAsyncApiCall --->", e)

            }
        })

    }

    fun makeSyncApiCall(url: String): String {
        return ""
    }

}