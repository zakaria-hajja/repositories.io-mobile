package com.zakaria.repositories.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Zakaria on 05/02/2018.
 */

 data class Repository(@SerializedName("name") var name:String,
                      @SerializedName("description") var description:String,
                      @SerializedName("owner") var owner:Owner,
                      @SerializedName("stargazers_count")var nbStars:Int=0):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString(),parcel.readString(),Owner(),parcel.readInt()) {
            this.owner= parcel.readParcelable(javaClass.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(nbStars)
        parcel.writeParcelable(owner,flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Repository> {
        override fun createFromParcel(parcel: Parcel): Repository {
            return Repository(parcel)
        }

        override fun newArray(size: Int): Array<Repository?> {
            return arrayOfNulls(size)
        }
    }
}


