package com.zakaria.repositories.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryDTO(var repository: Repository, @SerializedName("created_at")var created:String,@SerializedName("updated_at") var updated:String,@SerializedName("language")var language:String) {


}