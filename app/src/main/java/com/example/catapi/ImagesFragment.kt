package com.example.catapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.catapi.model.Images
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_images.*

class ImagesFragment : Fragment() {
    val apiService by lazy {
        ApiService.buildService()
    }
    private val disposables = CompositeDisposable()
//    var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_images, container, false)
        val disposable1 =
            apiService.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
        val disposable2 =
            apiService.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse2, this::handleError)
        val disposable3 =
            apiService.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse3, this::handleError)
        val disposable4 =
            apiService.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse4, this::handleError)
        disposables.addAll(disposable1, disposable2, disposable3, disposable4)
        return view
    }

    override fun onPause() {
        super.onPause()
        disposables.dispose()
    }

    private fun handleError(t: Throwable) {
        Log.e("Retrofit", t.message.toString())
    }

    private fun handleResponse(response: List<Images>) {
        Log.d("Retrofit", "result1: $response")
        context?.let {
            Glide.with(it)
                .load(response[0].url)
                .into(imageView1)
        }
    }

    private fun handleResponse2(response: List<Images>) {
        Log.d("Retrofit", "result2: $response")
        context?.let {
            Glide.with(it)
                .load(response[0].url)
                .into(imageView2)
        }
    }

    private fun handleResponse3(response: List<Images>) {
        Log.d("Retrofit", "result3: $response")
        context?.let {
            Glide.with(it)
                .load(response[0].url)
                .into(imageView3)
        }
    }

    private fun handleResponse4(response: List<Images>) {
        Log.d("Retrofit", "result4: $response")
        context?.let {
            Glide.with(it)
                .load(response[0].url)
                .into(imageView4)
        }
    }
}