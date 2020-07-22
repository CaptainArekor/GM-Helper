package com.arekor.gm_helper.monster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Monster
import kotlinx.android.synthetic.main.monster_list_item.view.*

class MonsterAdapter(val monsters: List<Monster>) : RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {

    class MonsterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title = itemView.monster_list_item_title
        lateinit var monster: Monster
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MonsterAdapter.MonsterViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.monster_list_item,parent,false)
        return MonsterViewHolder(v)
    }

    override fun onBindViewHolder(holder: MonsterAdapter.MonsterViewHolder, position: Int) {
        holder.title.text = monsters[position].name
        holder.monster = monsters[position]
    }

    override fun getItemCount(): Int {
        return monsters.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}