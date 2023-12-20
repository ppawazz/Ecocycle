package com.paw.ecocycle.model.remote.response

import com.google.gson.annotations.SerializedName

data class ModelResponse(

	@field:SerializedName("No-Rust")
	val noRust: Any? = null,

	@field:SerializedName("Rusty")
	val rusty: Any? = null
)
