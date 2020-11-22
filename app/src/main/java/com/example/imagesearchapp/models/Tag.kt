package com.example.imagesearchapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Tag(
    @get:JsonProperty("accent")
    @set:JsonProperty("accent")
    @JsonProperty("accent")
    var accent: String,
    @get:JsonProperty("background_hash")
    @set:JsonProperty("background_hash")
    @JsonProperty("background_hash")
    var background_hash: String,
    @get:JsonProperty("background_is_animated")
    @set:JsonProperty("background_is_animated")
    @JsonProperty("background_is_animated")
    var background_is_animated: Boolean,
    @get:JsonProperty("description")
    @set:JsonProperty("description")
    @JsonProperty("description")
    var description: String,
    @get:JsonProperty("description_annotations")
    @set:JsonProperty("description_annotations")
    @JsonProperty("description_annotations")
    var description_annotations: DescriptionAnnotations,
    @get:JsonProperty("display_name")
    @set:JsonProperty("display_name")
    @JsonProperty("display_name")
    var display_name: String,
    @get:JsonProperty("followers")
    @set:JsonProperty("followers")
    @JsonProperty("followers")
    var followers: Int,
    @get:JsonProperty("following")
    @set:JsonProperty("following")
    @JsonProperty("following")
    var following: Boolean,
    @get:JsonProperty("is_promoted")
    @set:JsonProperty("is_promoted")
    @JsonProperty("is_promoted")
    var is_promoted: Boolean,
    @get:JsonProperty("is_whitelisted")
    @set:JsonProperty("is_whitelisted")
    @JsonProperty("is_whitelisted")
    var is_whitelisted: Boolean,
    @get:JsonProperty("logo_destination_url")
    @set:JsonProperty("logo_destination_url")
    @JsonProperty("logo_destination_url")
    var logo_destination_url: String,
    @get:JsonProperty("logo_hash")
    @set:JsonProperty("logo_hash")
    @JsonProperty("logo_hash")
    var logo_hash: String,
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    var name: String,
    @get:JsonProperty("thumbnail_hash")
    @set:JsonProperty("thumbnail_hash")
    @JsonProperty("thumbnail_hash")
    var thumbnail_hash: String,
    @get:JsonProperty("thumbnail_is_animated")
    @set:JsonProperty("thumbnail_is_animated")
    @JsonProperty("thumbnail_is_animated")
    var thumbnail_is_animated: Boolean,
    @get:JsonProperty("total_items")
    @set:JsonProperty("total_items")
    @JsonProperty("total_items")
    var total_items: Int
) : Serializable {}