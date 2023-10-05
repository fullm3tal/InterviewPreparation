package com.fullm3tal.interviewpreparation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Links : Serializable {

    var id: Long? = null

    @SerializedName("mission_patch")
    @Expose
    var missionPatch: String? = null

    @SerializedName("mission_patch_small")
    @Expose
    var missionPatchSmall: String? = null

    @SerializedName("reddit_campaign")
    @Expose
    var redditCampaign: String? = null

    @SerializedName("reddit_launch")
    @Expose
    var redditLaunch: String? = null

    @SerializedName("reddit_recovery")
    @Expose
    var redditRecovery: String? = null

    @SerializedName("reddit_media")
    @Expose
    var redditMedia: String? = null

    @SerializedName("presskit")
    @Expose
    var presskit: String? = null

    @SerializedName("article_link")
    @Expose
    var articleLink: String? = null

    @SerializedName("wikipedia")
    @Expose
    var wikipedia: String? = null

    @SerializedName("video_link")
    @Expose
    var videoLink: String? = null

    @SerializedName("youtube_id")
    @Expose
    var youtubeId: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param articleLink
     * @param missionPatch
     * @param missionPatchSmall
     * @param redditRecovery
     * @param redditMedia
     * @param redditCampaign
     * @param videoLink
     * @param youtubeId
     * @param wikipedia
     * @param presskit
     * @param redditLaunch
     */

    constructor(
        missionPatch: String?,
        missionPatchSmall: String?,
        redditCampaign: String?,
        redditLaunch: String?,
        redditRecovery: String?,
        redditMedia: String?,
        presskit: String?,
        articleLink: String?,
        wikipedia: String?,
        videoLink: String?,
        youtubeId: String?,
        flickrImages: List<String?>?
    ) : super() {
        this.missionPatch = missionPatch
        this.missionPatchSmall = missionPatchSmall
        this.redditCampaign = redditCampaign
        this.redditLaunch = redditLaunch
        this.redditRecovery = redditRecovery
        this.redditMedia = redditMedia
        this.presskit = presskit
        this.articleLink = articleLink
        this.wikipedia = wikipedia
        this.videoLink = videoLink
        this.youtubeId = youtubeId
    }

    companion object {
        private const val serialVersionUID = -3603052743706433193L
    }
}