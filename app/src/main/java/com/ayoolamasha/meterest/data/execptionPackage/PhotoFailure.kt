package com.ayoolamasha.meterest.data.execptionPackage

class PhotoFailure {
    class ListNotAvailable : Failure.FeatureFailure()
    class NonExistentMovie : Failure.FeatureFailure()
}