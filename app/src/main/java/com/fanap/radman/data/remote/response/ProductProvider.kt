package com.fanap.radman.data.remote.response

data class ProductProvider(
    val businessId: Int,
    val deepLink: String,
    val packageName: String,
    val tableData: TableData
)