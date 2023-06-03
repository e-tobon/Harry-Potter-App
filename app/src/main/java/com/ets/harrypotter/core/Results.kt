package com.ets.harrypotter.core

sealed class Results<out T> {
    class Loading<out T> : Results<T>()

    data class Success<out T>(val data: T) : Results<T>()

    data class Failure(val exception: Exception) : Results<Nothing>()

}