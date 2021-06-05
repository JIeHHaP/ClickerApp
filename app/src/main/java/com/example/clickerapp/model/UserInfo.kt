package com.example.clickerapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Request(
    var action: String = "",
   var user: Map<String?, String?> = mapOf("name" to null, "pass" to null)
)

@Serializable
data class Response(
    var code: Int = 0,
    var data: Map<String, Int?> = mapOf("id" to null),
    var msg: String? = null
)

