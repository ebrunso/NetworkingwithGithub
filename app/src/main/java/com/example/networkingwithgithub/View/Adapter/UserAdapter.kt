package com.example.networkingwithgithub.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networkingwithgithub.Model.User.Item
import com.example.networkingwithgithub.Model.User.Repos
import com.example.networkingwithgithub.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class UserAdapter(val repoList: List<Repos>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
//, val itemList: List<Item>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.populateRepo(repoList[position])
        //holder.populateItem(itemList[position])
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        fun populateItem(item: Item){
//            itemView.tvLogin.text = "${item.login}"
//            itemView.tvID.text = item.node_id
//            itemView.tvScore.text = "${item.score}"
//            Glide
//                .with(itemView)
//                .load(item.avatar_url)
//                .into(itemView.ivAvatar)
//        }


        fun populateRepo(repo: Repos) {
            itemView.tvName.text = repo.name
            itemView.tvRepoID.text = "Repo ID: ${repo.id}"
            itemView.tvPrivate.text = "Private: ${repo.private}"
        }
    }
}