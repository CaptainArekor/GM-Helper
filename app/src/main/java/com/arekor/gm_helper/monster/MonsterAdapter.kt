package com.arekor.gm_helper.monster

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Monster
import com.arekor.gm_helper.utils.ConfimationModal
import kotlinx.android.synthetic.main.monster_list_item.view.*
import org.jetbrains.anko.doAsync


class MonsterAdapter(
    private val monsters: List<Monster>,
    monsterListFragment: MonsterListFragment,
    val contextView: View
) : RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {

    var model: MonsterViewModel = ViewModelProviders.of(monsterListFragment).get(MonsterViewModel::class.java)

    class MonsterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.monster_list_item_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MonsterViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.monster_list_item,parent,false)
        val viewHolder = MonsterViewHolder(v)
        v.monster_list_item_delete.setOnClickListener{
            deleteMonster(monsters[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        holder.title.text = monsters[position].name
    }

    override fun getItemCount(): Int {
        return monsters.size
    }

    private fun createMonster(){
        doAsync {
            model.insert( Monster(null, "Monstre") )
        }
    }

    private fun deleteMonster(monster: Monster){

        val alertDialogBuilder = AlertDialog.Builder(contextView.context)
        alertDialogBuilder.setTitle("Delete monster")
        alertDialogBuilder.setMessage(monster.name)
        alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which ->
            doAsync {
                model.delete(monster)
            }
        }
        alertDialogBuilder.setNegativeButton(android.R.string.no) { dialog, which ->
        }
        alertDialogBuilder.show()
    }

}