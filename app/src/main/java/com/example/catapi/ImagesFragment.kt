package com.example.catapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_images.*

class ImagesFragment : Fragment() {
    val apiService by lazy {
        ApiService.buildService()
    }
    var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_images, container, false)
        disposable =
            apiService.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
        return view
    }

    private fun handleError(t: Throwable) {
        Log.e("Retrofit", t.message.toString())
    }

    private fun handleResponse(response: List<Images>) {
        Log.d("Retrofit", "result: $response")
        context?.let {
            Glide.with(it)
                .load(response[0].url)
                .into(imageView)
        }
    }
}