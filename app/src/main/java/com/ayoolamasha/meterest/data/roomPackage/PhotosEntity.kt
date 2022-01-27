package com.ayoolamasha.meterest.data.roomPackage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ayoolamasha.meterest.data.PHOTOS_TABLE
import com.ayoolamasha.meterest.domain.PhotoUICase
import com.ayoolamasha.meterest.utlis.rawDateToString

@Entity(tableName = PHOTOS_TABLE)
data class PhotosEntity(
    @PrimaryKey @ColumnInfo(name = "photoId")
    val roomPhotoId:String,
    val roomPhotoDate:String?,
    val roomPhotoLikes:String?,
    val roomPhotoDescription:String?,
    val roomUserName:String?,
    val roomUserFullName:String?,
    val roomRawImage:String?,
    val roomFullImage:String?,
    val roomRegularImage:String?,
    val roomSmallImage:String?,
    val roomThumbImage:String?,
    val roomUserProfileImageSmall:String?
){
//    @PrimaryKey(autoGenerate = true)
//    var id:Int? = 0

    fun fromRoomToPhotoUiCase() = PhotoUICase(photoIdUiCase = roomPhotoId, photoLikesUiCase = roomPhotoLikes,
        photoDateUiCase = roomPhotoDate, photoRegularUiCase = roomFullImage,
        photoSmallUiCase =roomRegularImage,
        photoOwnerNameUiCase = roomUserFullName, photoDescriptionUiCase = roomPhotoDescription, photoOwnerProfileImage = roomUserProfileImageSmall)
}
