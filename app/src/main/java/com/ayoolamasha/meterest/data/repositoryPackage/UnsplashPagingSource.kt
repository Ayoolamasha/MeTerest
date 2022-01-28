package com.ayoolamasha.meterest.data.repositoryPackage

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ayoolamasha.meterest.data.apiPackage.PhotoApiServiceHelper
import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import com.ayoolamasha.meterest.domain.PhotoUICase

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

//class UnsplashPagingSource(
//    private val photoApiServiceHelper: PhotoApiServiceHelper,
//
//):PagingSource<Int, PhotoUICase>() {
//
//    override fun getRefreshKey(state: PagingState<Int, PhotoUICase>): Int? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoUICase> {
//        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
//        return try{
//            val response = photoApiServiceHelper.getAllPhotosPaging(page = page, perPage = params.loadSize, orderBy = null)
//            val photos = response.body()?.size
//            LoadResult.Page(
//                data = photos,
//        prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
//        nextKey = if (page == response.totalPages) null else page + 1
//        )
//    }
//    }
//}