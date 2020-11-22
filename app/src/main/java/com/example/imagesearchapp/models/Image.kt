package com.example.imagesearchapp.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Image(
    @get:JsonProperty("account_id")
    @set:JsonProperty("account_id")
    @JsonProperty("account_id")
    var account_id: String,
    @get:JsonProperty("account_url")
    @set:JsonProperty("account_url")
    @JsonProperty("account_url")
    var account_url: String,
    @get:JsonProperty("ad_type")
    @set:JsonProperty("ad_type")
    @JsonProperty("ad_type")
    var ad_type: Int,
    @get:JsonProperty("ad_url")
    @set:JsonProperty("ad_url")
    @JsonProperty("ad_url")
    var ad_url: String,
    @get:JsonProperty("animated")
    @set:JsonProperty("animated")
    @JsonProperty("animated")
    var animated: Boolean,
    @get:JsonProperty("bandwidth")
    @set:JsonProperty("bandwidth")
    @JsonProperty("bandwidth")
    var bandwidth: Long,
    @get:JsonProperty("comment_count")
    @set:JsonProperty("comment_count")
    @JsonProperty("comment_count")
    var comment_count: String,
    @get:JsonProperty("datetime")
    @set:JsonProperty("datetime")
    @JsonProperty("datetime")
    var datetime: Int,
    @get:JsonProperty("description")
    @set:JsonProperty("description")
    @JsonProperty("description")
    var description: String,
    @get:JsonProperty("downs")
    @set:JsonProperty("downs")
    @JsonProperty("downs")
    var downs: String,
    @get:JsonProperty("edited")
    @set:JsonProperty("edited")
    @JsonProperty("edited")
    var edited: String,
    @get:JsonProperty("favorite")
    @set:JsonProperty("favorite")
    @JsonProperty("favorite")
    var favorite: Boolean,
    @get:JsonProperty("favorite_count")
    @set:JsonProperty("favorite_count")
    @JsonProperty("favorite_count")
    var favorite_count: String,
    @get:JsonProperty("gifv")
    @set:JsonProperty("gifv")
    @JsonProperty("gifv")
    var gifv: String,
    @get:JsonProperty("has_sound")
    @set:JsonProperty("has_sound")
    @JsonProperty("has_sound")
    var has_sound: Boolean,
    @get:JsonProperty("height")
    @set:JsonProperty("height")
    @JsonProperty("height")
    var height: Int,
    @get:JsonProperty("hls")
    @set:JsonProperty("hls")
    @JsonProperty("hls")
    var hls: String,
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: String,
    @get:JsonProperty("in_gallery")
    @set:JsonProperty("in_gallery")
    @JsonProperty("in_gallery")
    var in_gallery: Boolean,
    @get:JsonProperty("in_most_viral")
    @set:JsonProperty("in_most_viral")
    @JsonProperty("in_most_viral")
    var in_most_viral: Boolean,
    @get:JsonProperty("is_ad")
    @set:JsonProperty("is_ad")
    @JsonProperty("is_ad")
    var is_ad: Boolean,
    @get:JsonProperty("link")
    @set:JsonProperty("link")
    @JsonProperty("link")
    var link: String,
    @get:JsonProperty("mp4")
    @set:JsonProperty("mp4")
    @JsonProperty("mp4")
    var mp4: String,
    @get:JsonProperty("mp4_size")
    @set:JsonProperty("mp4_size")
    @JsonProperty("mp4_size")
    var mp4_size: Int,
    @get:JsonProperty("nsfw")
    @set:JsonProperty("nsfw")
    @JsonProperty("nsfw")
    var nsfw: String,
    @get:JsonProperty("points")
    @set:JsonProperty("points")
    @JsonProperty("points")
    var points: String,
    @get:JsonProperty("score")
    @set:JsonProperty("score")
    @JsonProperty("score")
    var score: String,
    @get:JsonProperty("section")
    @set:JsonProperty("section")
    @JsonProperty("section")
    var section: String,
    @get:JsonProperty("size")
    @set:JsonProperty("size")
    @JsonProperty("size")
    var size: Int,
    @get:JsonProperty("tags")
    @set:JsonProperty("tags")
    @JsonProperty("tags")
    var tags: List<String>,
    @get:JsonProperty("title")
    @set:JsonProperty("title")
    @JsonProperty("title")
    var title: String,
    @get:JsonProperty("type")
    @set:JsonProperty("type")
    @JsonProperty("type")
    var type: String,
    @get:JsonProperty("ups")
    @set:JsonProperty("ups")
    @JsonProperty("ups")
    var ups: String,
    @get:JsonProperty("views")
    @set:JsonProperty("views")
    @JsonProperty("views")
    var views: Int,
    @get:JsonProperty("vote")
    @set:JsonProperty("vote")
    @JsonProperty("vote")
    var vote: String,
    @get:JsonProperty("width")
    @set:JsonProperty("width")
    @JsonProperty("width")
    var width: Int
) : Serializable {}