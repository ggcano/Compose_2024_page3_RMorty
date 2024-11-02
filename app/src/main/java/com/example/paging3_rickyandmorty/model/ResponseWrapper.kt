package com.example.paging3_rickyandmorty.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper(
    @SerializedName("info") val information:Info,
    @SerializedName("results") val results:List<Result>,
)