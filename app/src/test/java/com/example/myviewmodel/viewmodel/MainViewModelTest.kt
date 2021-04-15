package com.example.myviewmodel.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.jvm.Throws

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    //Annotation @Rule digunakan untuk menjalankan kode sebelum pengujian dilakukan.
    // Jadi jika tidak diberi anotasi
    // @Rule pada thrown, maka kode tersebut tidak akan berjalan.

    @get:Rule
    var thrown = ExpectedException.none()

    //test for double data
    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputCalculateTest() {
        val width = "1"
        val length = "2.4"
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calculate(width,height,length)
    }

    @Test
    fun calculate() {

        val width = "1"
        val length = "2"
        val height = "3"
        mainViewModel.calculate(width ,height, length)
        assertEquals(6, mainViewModel.result)


    }

    //test dengan exception yang telah di kecualikan haha
    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun characterInputCalculateTest() {
        val width = "1"
        val length = "A"
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        mainViewModel.calculate(width, height, length)
    }

    //sama kok uWu
    @Test
    @Throws(java.lang.NumberFormatException::class)
    fun emptyInputCalculateTest() {
        val width = "1"
        val length = ""
        val height = "3"
        thrown.expect(java.lang.NumberFormatException::class.java)
        thrown.expectMessage("For input string \"\"")
        mainViewModel.calculate(width, height, length)
        
    }
}