package com.example.pleasework

import android.provider.MediaStore.Images
import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data") val res: List<DataObject>
)

data class DataObject(
    @SerializedName("images") val images: DataImage
)

data class DataImage(
    @SerializedName("original") val ogImage: ogImage
)

data class ogImage(
    val url: String
)