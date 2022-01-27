package com.ayoolamasha.meterest.data.responsePackage

import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.domain.PhotoUICase
import com.ayoolamasha.meterest.utlis.rawDateToString
import com.google.gson.annotations.SerializedName

//class GetPhotoListResponse(val photoItems: List<Photos>)

data class GetPhotoListResponse(
    @SerializedName("id")
    val photoId:String?,
    @SerializedName("created_at")
    val photoDate:String?,
    @SerializedName("likes")
    val photoLikes:String?,
    @SerializedName("description")
    val photoDescription:String?,
    @SerializedName("user")
    val accountUserName:User?,
    @SerializedName("urls")
    val picturesUrls:Urls?
){

//    fun fromApiToPhotoEntity() = PhotosEntity(roomPhotoId = photoId,
//        roomPhotoDate = rawDateToString(photoDate), roomPhotoLikes = photoLikes, roomPhotoDescription = photoDescription,
//        roomUserName = accountUserName?.userName, roomUserFullName = accountUserName?.userFullName,
//        roomRawImage = picturesUrls?.rawImage, roomFullImage = picturesUrls?.fullImage, roomRegularImage = picturesUrls?.regularImage,
//        roomSmallImage = picturesUrls?.smallImage, roomThumbImage = picturesUrls?.thumbImage)

    fun toPhotoUiCase() = PhotoUICase(photoIdUiCase = photoId, photoLikesUiCase = photoLikes,
        photoDateUiCase = rawDateToString(photoDate), photoRegularUiCase = picturesUrls?.fullImage,
        photoSmallUiCase = picturesUrls?.smallImage,
        photoOwnerNameUiCase = accountUserName?.userFullName, photoDescriptionUiCase = photoDescription, photoOwnerProfileImage = accountUserName?.userProfileImage?.userProfileImageSmall)
}

data class User(
    @SerializedName("id")
    val userId:String?,
    @SerializedName("username")
    val userName:String?,
    @SerializedName("name")
    val userFullName:String?,
    @SerializedName("profile_image")
    val userProfileImage: ProfileImage?
)

data class ProfileImage (
    @SerializedName("small")
    val userProfileImageSmall:String,
    @SerializedName("medium")
    val userProfileImageMedium:String,
    @SerializedName("large")
    val userProfileImageLarge:String

    )

data class Urls(
    @SerializedName("raw")
    val rawImage:String?,
    @SerializedName("full")
    val fullImage:String?,
    @SerializedName("regular")
    val regularImage:String?,
    @SerializedName("small")
    val smallImage:String?,
    @SerializedName("thumb")
    val thumbImage:String?
)


