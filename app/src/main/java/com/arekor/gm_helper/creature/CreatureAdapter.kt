package com.arekor.gm_helper.creature

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Creature
import kotlinx.android.synthetic.main.monster_list_item.view.*
import org.jetbrains.anko.doAsync


class CreatureAdapter(
    private val creatures: List<Creature>,
    creatureListFragment: CreatureListFragment,
    private val contextView: View
) : RecyclerView.Adapter<CreatureAdapter.MonsterViewHolder>() {

    var model: CreatureViewModel = ViewModelProviders.of(creatureListFragment).get(CreatureViewModel::class.java)

    class MonsterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.monster_list_item_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MonsterViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.monster_list_item,parent,false)
        val viewHolder = MonsterViewHolder(v)
        v.monster_list_item_delete.setOnClickListener{
            deleteCreature(creatures[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        holder.title.text = creatures[position].name
    }

    override fun getItemCount(): Int {
        return creatures.size
    }

    private fun createCreature(){
        doAsync {
            model.insert( Creature(null, "Monstre") )
        }
    }

    private fun deleteCreature(creature: Creature){

        val alertDialogBuilder = AlertDialog.Builder(contextView.context)
        alertDialogBuilder.setTitle("Delete creature")
        alertDialogBuilder.setMessage(creature.name)
        alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which ->
            doAsync {
                model.delete(creature)
            }
        }
        alertDialogBuilder.setNegativeButton(android.R.string.no) { dialog, which ->
        }
        alertDialogBuilder.show()
    }

}