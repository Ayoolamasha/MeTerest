package com.ayoolamasha.meterest.ui.fragmentPackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ayoolamasha.meterest.R
import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.execptionPackage.PhotoFailure
import com.ayoolamasha.meterest.data.extensionsPackage.empty
import com.ayoolamasha.meterest.data.extensionsPackage.failure
import com.ayoolamasha.meterest.data.extensionsPackage.success
import com.ayoolamasha.meterest.databinding.HomeFragmentBinding
import com.ayoolamasha.meterest.domain.PhotoUICase
import com.ayoolamasha.meterest.ui.adapterPackage.PhotoAdapter
import com.ayoolamasha.meterest.ui.viewmodelPackage.HomeViewModel
import com.google.protobuf.Empty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var photoAdapter: PhotoAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        with(homeViewModel) {
            success(livePhotos, ::renderPhotoList)
            failure(failure, ::handleFailure)
            empty(empty,::handleEmpty)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoAdapter = PhotoAdapter()
        loadMoviesList()
        initializeRecyclerView()

    }

    private fun initializeRecyclerView(){
        binding.photoRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            itemAnimator= DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
            adapter = photoAdapter
        }
    }

    private fun renderPhotoList(photoUICase: List<PhotoUICase>?){
        photoAdapter.submitList(photoUICase)
        binding.progressLoading.visibility= View.GONE
        binding.photoRecycler.visibility = View.VISIBLE

    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is PhotoFailure.ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
            else -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        binding.photoRecycler.visibility = View.GONE
        binding.progressLoading.visibility= View.VISIBLE
        //hideProgress()
        //Snackbar.make(message, R.string.action_refresh, ::loadMoviesList)
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

    }

    private fun loadMoviesList() {
        binding.progressLoading.visibility= View.VISIBLE
        binding.photoRecycler.visibility = View.GONE

    }

    private fun handleEmpty(empty: Any?){
        Toast.makeText(activity, "Empty List", Toast.LENGTH_SHORT).show()
    }

}