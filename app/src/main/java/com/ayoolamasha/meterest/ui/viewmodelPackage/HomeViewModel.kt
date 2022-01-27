package com.ayoolamasha.meterest.ui.viewmodelPackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.repositoryPackage.GetAllPhotos
import com.ayoolamasha.meterest.domain.BaseUseCase
import com.ayoolamasha.meterest.domain.PhotoUICase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllPhotos: GetAllPhotos): ViewModel(){

    init {
        loadPhotos()
    }

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    private val _empty: MutableLiveData<Any> = MutableLiveData()
    val empty: LiveData<Any> = _empty



    private val _mPhotos: MutableLiveData<List<PhotoUICase>> = MutableLiveData()
    val livePhotos:LiveData<List<PhotoUICase>> = _mPhotos

    private fun loadPhotos() =
        getAllPhotos(BaseUseCase.None(), viewModelScope){
            it.fold(::handleFailure, ::handlePhotoList)
        }

    private fun handlePhotoList(photoUICase: List<PhotoUICase>){
        if (photoUICase.isNullOrEmpty()){
            _empty.value = photoUICase
        }else{
            _mPhotos.value = photoUICase
        }
    }


    private fun handleFailure(failure: Failure){
        _failure.value = failure
    }

}


