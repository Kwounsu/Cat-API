package com.example.catapi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.catapi.model.Breeds
import com.example.catapi.model.Images
import com.example.catapi.viewmodel.CatViewModel
import io.reactivex.Maybe
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class CatViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService
    lateinit var catViewModel: CatViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.catViewModel = CatViewModel()
    }

    @Test
    fun getImage_positiveResponse() {
        Mockito.`when`(this.apiService.getImage()).thenAnswer {
            return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Images>())
        }
    }

    @Test
    fun getBreeds_positiveResponse() {
        Mockito.`when`(this.apiService.getBreeds()).thenAnswer {
            return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Breeds>())
        }
    }
}