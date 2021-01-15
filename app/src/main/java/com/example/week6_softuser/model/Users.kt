package com.example.week6_softuser.model

import android.os.Parcel
import android.os.Parcelable

data class Users(
        val userImg : String? =null,
        val userName : String? = null,
        val userAge : Int? = null,
        val userAddress : String? = null,
        val userGender : String? = null,
):Parcelable{
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(userImg)
                parcel.writeString(userName)
                parcel.writeValue(userAge)
                parcel.writeString(userAddress)
                parcel.writeString(userGender)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Users> {
                override fun createFromParcel(parcel: Parcel): Users {
                        return Users(parcel)
                }

                override fun newArray(size: Int): Array<Users?> {
                        return arrayOfNulls(size)
                }
        }
}