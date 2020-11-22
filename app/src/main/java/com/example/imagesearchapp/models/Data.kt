package com.example.imagesearchapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
data class Data(
    @PrimaryKey(autoGenerate = true)
    @get:JsonProperty("account_id")
    @set:JsonProperty("account_id")
    @JsonProperty("account_id")
    var account_id: Int? = null,
    @get:JsonProperty("account_url")
    @set:JsonProperty("account_url")
    @JsonProperty("account_url")
    var account_url: String? = null,
    @get:JsonProperty("ad_type")
    @set:JsonProperty("ad_type")
    @JsonProperty("ad_type")
    var ad_type: Int? = null,
    @get:JsonProperty("ad_url")
    @set:JsonProperty("ad_url")
    @JsonProperty("ad_url")
    var ad_url: String? = null,
    @get:JsonProperty("animated")
    @set:JsonProperty("animated")
    @JsonProperty("animated")
    var animated: Boolean? = null,
    @get:JsonProperty("bandwidth")
    @set:JsonProperty("bandwidth")
    @JsonProperty("bandwidth")
    var bandwidth: Long? = null,
    @get:JsonProperty("comment_count")
    @set:JsonProperty("comment_count")
    @JsonProperty("comment_count")
    var comment_count: Int? = null,
    @get:JsonProperty("cover")
    @set:JsonProperty("cover")
    @JsonProperty("cover")
    var cover: String? = null,
    @get:JsonProperty("cover_height")
    @set:JsonProperty("cover_height")
    @JsonProperty("cover_height")
    var cover_height: Int? = null,
    @get:JsonProperty("cover_width")
    @set:JsonProperty("cover_width")
    @JsonProperty("cover_width")
    var cover_width: Int? = null,
    @get:JsonProperty("datetime")
    @set:JsonProperty("datetime")
    @JsonProperty("datetime")
    var datetime: Int? = null,
    @get:JsonProperty("description")
    @set:JsonProperty("description")
    @JsonProperty("description")
    var description: String? = null,
    @get:JsonProperty("downs")
    @set:JsonProperty("downs")
    @JsonProperty("downs")
    var downs: Int? = null,
    @get:JsonProperty("edited")
    @set:JsonProperty("edited")
    @JsonProperty("edited")
    var edited: Int? = null,
    @get:JsonProperty("favorite")
    @set:JsonProperty("favorite")
    @JsonProperty("favorite")
    var favorite: Boolean? = null,
    @get:JsonProperty("favorite_count")
    @set:JsonProperty("favorite_count")
    @JsonProperty("favorite_count")
    var favorite_count: Int? = null,
    @get:JsonProperty("gifv")
    @set:JsonProperty("gifv")
    @JsonProperty("gifv")
    var gifv: String? = null,
    @get:JsonProperty("has_sound")
    @set:JsonProperty("has_sound")
    @JsonProperty("has_sound")
    var has_sound: Boolean? = null,
    @get:JsonProperty("height")
    @set:JsonProperty("height")
    @JsonProperty("height")
    var height: Int? = null,
    @get:JsonProperty("hls")
    @set:JsonProperty("hls")
    @JsonProperty("hls")
    var hls: String? = null,
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: String? = null,
    @get:JsonProperty("images_count")
    @set:JsonProperty("images_count")
    @JsonProperty("images_count")
    var images_count: Int? = null,
    @get:JsonProperty("in_gallery")
    @set:JsonProperty("in_gallery")
    @JsonProperty("in_gallery")
    var in_gallery: Boolean? = null,
    @get:JsonProperty("in_most_viral")
    @set:JsonProperty("in_most_viral")
    @JsonProperty("in_most_viral")
    var in_most_viral: Boolean? = null,
    @get:JsonProperty("include_album_ads")
    @set:JsonProperty("include_album_ads")
    @JsonProperty("include_album_ads")
    var include_album_ads: Boolean? = null,
    @get:JsonProperty("is_ad")
    @set:JsonProperty("is_ad")
    @JsonProperty("is_ad")
    var is_ad: Boolean? = null,
    @get:JsonProperty("is_album")
    @set:JsonProperty("is_album")
    @JsonProperty("is_album")
    var is_album: Boolean? = null,
    @get:JsonProperty("layout")
    @set:JsonProperty("layout")
    @JsonProperty("layout")
    var layout: String? = null,
    @get:JsonProperty("link")
    @set:JsonProperty("link")
    @JsonProperty("link")
    var link: String? = null,
    @get:JsonProperty("looping")
    @set:JsonProperty("looping")
    @JsonProperty("looping")
    var looping: Boolean? = null,
    @get:JsonProperty("mp4")
    @set:JsonProperty("mp4")
    @JsonProperty("mp4")
    var mp4: String? = null,
    @get:JsonProperty("mp4_size")
    @set:JsonProperty("mp4_size")
    @JsonProperty("mp4_size")
    var mp4_size: Int? = null,
    @get:JsonProperty("nsfw")
    @set:JsonProperty("nsfw")
    @JsonProperty("nsfw")
    var nsfw: Boolean? = null,
    @get:JsonProperty("points")
    @set:JsonProperty("points")
    @JsonProperty("points")
    var points: Int? = null,
    @get:JsonProperty("privacy")
    @set:JsonProperty("privacy")
    @JsonProperty("privacy")
    var privacy: String? = null,
    /*@get:JsonProperty("processing")
    @set:JsonProperty("processing")
    @JsonProperty("processing")
    var processing: ProcessingX,*/
    @get:JsonProperty("score")
    @set:JsonProperty("score")
    @JsonProperty("score")
    var score: Int? = null,
    @get:JsonProperty("section")
    @set:JsonProperty("section")
    @JsonProperty("section")
    var section: String? = null,
    @get:JsonProperty("size")
    @set:JsonProperty("size")
    @JsonProperty("size")
    var size: Int? = null,
    @get:JsonProperty("title")
    @set:JsonProperty("title")
    @JsonProperty("title")
    var title: String? = null,
    @get:JsonProperty("topic")
    @set:JsonProperty("topic")
    @JsonProperty("topic")
    var topic: String? = null,
    @get:JsonProperty("topic_id")
    @set:JsonProperty("topic_id")
    @JsonProperty("topic_id")
    var topic_id: Int? = null,
    @get:JsonProperty("type")
    @set:JsonProperty("type")
    @JsonProperty("type")
    var type: String? = null,
    @get:JsonProperty("ups")
    @set:JsonProperty("ups")
    @JsonProperty("ups")
    var ups: Int? = null,
    @get:JsonProperty("views")
    @set:JsonProperty("views")
    @JsonProperty("views")
    var views: Int? = null,
    @get:JsonProperty("vote")
    @set:JsonProperty("vote")
    @JsonProperty("vote")
    var vote: String? = null,
    @get:JsonProperty("width")
    @set:JsonProperty("width")
    @JsonProperty("width")
    var width: Int? = null
) : Serializable {}