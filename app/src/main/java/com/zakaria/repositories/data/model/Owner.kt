package com.zakaria.repositories.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Zakaria on 05/02/2018.
 */
data class Owner(@SerializedName("login") var name:String,
                 @SerializedName("avatar_url") var image:String)