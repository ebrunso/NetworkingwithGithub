package com.example.networkingwithgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.networkingwithgithub.Datasource.Remote.OkHttpHelper
import com.example.networkingwithgithub.Model.User.User
import com.example.networkingwithgithub.Model.User.Repos
import com.example.networkingwithgithub.View.Adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnGetGitProfile -> executeAsyncOkHttpCall()
        }
    }

    fun executeAsyncOkHttpCall(){
        val gitURL = "https://github.com/ebrunso?tab=repositories"
        val okHttpHelper = OkHttpHelper()
        okHttpHelper.makeAsyncApiCall(gitURL)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onUserResponse(userResponse : Repos) {
//        tvLogin.text = "${userResponse.repos[0].login}"
//        tvID.text = "${userResponse.items[0].id}"
//        tvScore.text = "${userResponse.items[0].score}"
//        Glide.with(this).load(userResponse.items[0].avatar_url).into(ivAvatar)

        Log.d("TAG","UserData loaded")
        rvGitRepos.layoutManager = LinearLayoutManager(this)
        //rvGitRepos.adapter = UserAdapter(userResponse.repo)
    }

}
