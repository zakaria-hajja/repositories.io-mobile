package com.zakaria.repositories.data.model

/**
 * Created by Zakaria on 05/02/2018.
 */

data class Repository(var name:String,var description:String,var owner:Owner,var nbStars:Int=0) {
    constructor(name: String, description: String) : this(name,description,Owner())
}