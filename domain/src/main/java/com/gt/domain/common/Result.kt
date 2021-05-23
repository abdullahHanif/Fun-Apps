package com.gt.domain.common
//For State flow, this class provide generic wrapper around data.

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T?) : Result<T>()
    class Error(val exception: Exception) : Result<Nothing>()
}
