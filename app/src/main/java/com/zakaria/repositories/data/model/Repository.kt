package com.zakaria.repositories.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Zakaria on 05/02/2018.
 */

data class Repository(@SerializedName("name") var name:String,
                      @SerializedName("description") var description:String,
                      @SerializedName("owner") var owner:Owner,
                      @SerializedName("stargazers_count")var nbStars:Int=0)


