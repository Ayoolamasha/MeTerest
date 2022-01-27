package com.ayoolamasha.meterest.data.execptionPackage

sealed class Failure{
    object NetworkConnection: Failure()
    object ServerError: Failure()

    abstract class FeatureFailure : Failure()
}
