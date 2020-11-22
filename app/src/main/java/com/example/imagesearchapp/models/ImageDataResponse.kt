package com.example.imagesearchapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class
ImageDataResponse(
    @get:JsonProperty("data")
    @set:JsonProperty("data")
    @JsonProperty("data")
    var data: ArrayList<Data>? = null,
    @get:JsonProperty("status")
    @set:JsonProperty("status")
    @JsonProperty("status")
    var status: Int,
    @get:JsonProperty("success")
    @set:JsonProperty("success")
    @JsonProperty("success")
    var success: Boolean
) : Serializable {}