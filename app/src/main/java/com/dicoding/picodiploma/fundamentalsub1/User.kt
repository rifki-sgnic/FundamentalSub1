package com.dicoding.picodiploma.fundamentalsub1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var username: String = "",
    var name: String= "",
    var location: String = "",
    var respository: String = "",
    var company: String = "",
    var followers: String = "",
    var following: String = "",
    var avatar: Int = 0
) : Parcelable