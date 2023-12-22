package com.paw.ecocycle.model.remote.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(

    @field:SerializedName("No-Rust")
    val noRust: Any,

    @field:SerializedName("Rusty")
    val rusty: Any
)
