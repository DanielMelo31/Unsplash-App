package com.example.imagesearchapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
        val id: String,
        val description: String?,
        val urls: UnspalsPhotoUrls,
        val user: UnsplashPhotoUser
): Parcelable {

    @Parcelize
    data class UnspalsPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ): Parcelable

    @Parcelize
    data class UnsplashPhotoUser(
            val name: String,
            val username: String
    ): Parcelable
}
