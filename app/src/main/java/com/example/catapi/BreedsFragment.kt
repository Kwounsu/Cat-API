package com.example.catapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catapi.model.Breeds
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_breeds.*

class BreedsFragment : Fragment() {
    val apiService by lazy {
        ApiService.buildService()
    }
    var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_breeds, container, false)
        disposable =
            apiService.getbreeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
        return view
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    private fun handleError(t: Throwable) {
        Log.e("Retrofit", t.message.toString())
    }

    private fun handleResponse(response: List<Breeds>) {
        Log.d("Retrofit", "result: $response")
        breedsRV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = BreedsAdapter(response)
        }
    }
}