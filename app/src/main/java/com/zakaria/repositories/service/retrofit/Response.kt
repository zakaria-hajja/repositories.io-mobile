package com.zakaria.repositories.service.retrofit

import com.google.gson.annotations.SerializedName
import com.zakaria.repositories.model.Repository
import java.io.Serializable

/**
 * Created by Zakaria on 11/02/2018.
 */
class Response: Serializable {

    @SerializedName("items")
    lateinit var repositories:List<Repository>



}