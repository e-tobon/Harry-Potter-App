package com.ets.harrypotter.data.model

import com.google.gson.annotations.SerializedName

data class HpAlumno(
    val id: String?,
    val name: String?,
    val actor: String?,
    val image: String?,
    val house: String?,
    val species:String?,
    val gender:String?,
    val dateOfBirth:String?,
    val yerOfBirth:String?,
    val wand:Wand?,
    val patronus:String?,
    val alternate_names: ArrayList<String>?

)

data class Wand(
    val wood: String?,
    val core: String?,
    val length: String?
)


