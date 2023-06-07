package com.ets.harrypotter.ui.profesores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ets.harrypotter.R
import com.ets.harrypotter.data.model.HpProfesor
import com.ets.harrypotter.databinding.ProfesorItemBinding

class ProfesresAdapter(private val context: Context,private val listProfesores:List<HpProfesor>, private val profesorClick:(HpProfesor)->Unit):  RecyclerView.Adapter<ProfesresAdapter.ViewHolder>() {

    class ViewHolder(view:ProfesorItemBinding):RecyclerView.ViewHolder(view.root){
        val tvNombreProfesor = view.tvName
        val tvActor = view.tvActor
        val ivImagenProfesor = view.ivProfesorPhoto

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProfesorItemBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listProfesores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombreProfesor.text = listProfesores[position].name
        holder.tvActor.text = listProfesores[position].actor
        if(listProfesores[position].image == ""){
            holder.ivImagenProfesor.setImageResource(R.drawable.ic_profesores_minerva)
        }else{
            Glide.with(context).load(listProfesores[position].image)
                .into(holder.ivImagenProfesor)
        }

        holder.itemView.setOnClickListener {
            profesorClick(listProfesores[position])
        }
    }
}