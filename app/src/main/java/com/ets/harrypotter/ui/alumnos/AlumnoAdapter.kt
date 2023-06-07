package com.ets.harrypotter.ui.alumnos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ets.harrypotter.R
import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.databinding.AlumnoItemBinding

class AlumnoAdapter(private val context: Context, private val alumnoList:List<HpAlumno>, private val alumnoClick:(HpAlumno)->Unit) : RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {
    class ViewHolder(view:AlumnoItemBinding): RecyclerView.ViewHolder(view.root){
        val tvNombre = view.tvName
        val tvActor = view.tvActor
        val ivImagen = view.ivAlumnoPhoto
        val tvHouse = view.tvCasa

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlumnoItemBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = alumnoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = alumnoList[position].name
        holder.tvActor.text = alumnoList[position].actor
        holder.tvHouse.text = alumnoList[position].house
        if(alumnoList[position].image == ""){
            holder.ivImagen.setImageResource(R.drawable.ic_alumno)
        }
        else{
            Glide.with(context).load(alumnoList[position].image)
                .into(holder.ivImagen)
        }

        holder.itemView.setOnClickListener {
            alumnoClick(alumnoList[position])
        }


    }
}