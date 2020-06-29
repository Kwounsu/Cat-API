package com.example.catapi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.catapi.model.Breeds
import com.example.catapi.model.Images
import com.example.catapi.model.Weight
import com.example.catapi.viewmodel.CatViewModel
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
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
        val list = listOf<String>()
        val images = listOf(Images(list, "coj","https://cdn2.thecatapi.com/images/coj.jpg",427,640))
        Mockito.`when`(this.apiService.getImage()).thenReturn(Observable.just(images))
//        Mockito.`when`(this.apiService.getImage()).thenAnswer { return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Images>()) }

        val testObserver = TestObserver<List<Images>>()
        apiService.getImage().subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val listResult = testObserver.values()[0]
        assertThat(listResult.size, `is`(1))
        assertThat(listResult[0].id, `is`("coj"))
    }

    @Test
    fun getBreeds_positiveResponse() {
        val breeds = listOf(Breeds(Weight("1","2"),"1","1","1","1","1","1","1","1","1","1","1",1,1,"1",1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,"1",1))
        Mockito.`when`(this.apiService.getBreeds()).thenReturn(Observable.just(breeds))
//        Mockito.`when`(this.apiService.getBreeds()).thenAnswer { return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Breeds>()) }
    }
}