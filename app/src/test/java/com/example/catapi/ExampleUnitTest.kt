package com.example.catapi

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun baseUrl_isCorrect() {
        var urlStart = ""
        urlStart += ApiService.BASE_URL[0]
        urlStart += ApiService.BASE_URL[1]
        urlStart += ApiService.BASE_URL[2]
        urlStart += ApiService.BASE_URL[3]
        urlStart += ApiService.BASE_URL[4]
        urlStart += ApiService.BASE_URL[5]
        urlStart += ApiService.BASE_URL[6]
        urlStart += ApiService.BASE_URL[7]

        assertEquals("https://", urlStart)
    }
    @Test
    fun add_isCorrect() {
        assertEquals(4, 2+2)
    }
    @Test
    fun subtract_isCorrect() {
        assertEquals(1,2-1)
    }
    @Test
    fun multiply_isCorrect() {
        assertEquals(8,4*2)
    }
    @Test
    fun divide_isCorrect() {
        assertEquals(8,16/2)
    }
    @Test
    fun array_isCorrect() {
        val arrayList = arrayListOf(1,2,3)
        assertEquals(3,arrayList.size)
    }
    @Test
    fun arrayAddition_isCorrect() {
        val arrayList = arrayListOf(1,2,3)
        arrayList.add(4)
        assertEquals(4,arrayList.size)
    }
    @Test
    fun set_isCorrect() {
        val set = setOf(1,2,3)
        assertEquals(3,set.size)
    }
    @Test
    fun setAddition_isCorrect() {
        val mutableSet = mutableSetOf(1,2,3)
        mutableSet.add(4)
        assertEquals(4,mutableSet.size)
    }
    @Test
    fun setAddDuplicate_isCorrect() {
        val mutableSet = mutableSetOf(1,2,3)
        mutableSet.add(2)
        assertEquals(3,mutableSet.size)
    }
}