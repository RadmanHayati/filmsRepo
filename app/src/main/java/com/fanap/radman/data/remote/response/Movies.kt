package com.fanap.radman.data.remote.response

data class Movies(
    val count: Int,
    val hasError: Boolean,
    val result: List<Result>,
    val statusCode: Int
)