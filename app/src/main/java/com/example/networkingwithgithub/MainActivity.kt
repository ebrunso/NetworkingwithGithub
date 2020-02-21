package com.example.networkingwithgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun executeAsyncOkHttpCall(){
        val randomUserURL = "https://github.com/ebrunso?tab=repositories"
    //    val okHttpHelper = OkHttpHelper()
    //    okHttpHelper.makeAsyncApiCall(randomUserURL)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    //fun onUserResponse(userResponse : UserResponse) {
        //rvUserList.layoutManager = LinearLayoutManager(this)
        //rvUserList.adapter = UserAdapter(userResponse.results)
    //}

    fun executeHttpUrlConnCall() {
        val randomUserURL = "https://github.com/ebrunso?tab=repositories"
      //  val httpUrlConnectionHelper = HttpUrlConnectionHelper()
        var jsonString = ""
        Thread (
            Runnable{
          //      jsonString = httpUrlConnectionHelper.getResponse(randomUserURL)
                Log.d("TAG", jsonString)

                if(jsonString.isNotBlank()){
              //      val userResponse = Gson().fromJson<UserResponse>(jsonString, UserResponse::class.java)
              //      Log.d("TAG", "FIRST RESPONSES FIRST NAME = ${userResponse.results[0].name.first}")
                    runOnUiThread{
               //         rvUserList.layoutManager = LinearLayoutManager(this)
               //         rvUserList.adapter = UserAdapter(userResponse.results)
                    }
                }
            }
        ).start()

    }
}
