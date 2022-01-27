package com.ayoolamasha.meterest.domain

import android.os.Parcel

data class PhotoView(val photoRegularUiCase: String?): KParcelable{

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::PhotoView)
    }

    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeString(photoRegularUiCase)
        }
    }

}
