package com.fullm3tal.interviewpreparation.model


import com.fullm3tal.interviewpreparation.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LaunchInfo : Serializable {

    @SerializedName("flight_number")
    @Expose
    var flightNumber: Int? = null

    @SerializedName("mission_name")
    @Expose
    var missionName: String? = null

    @SerializedName("upcoming")
    @Expose
    var upcoming: Boolean? = null

    @SerializedName("launch_year")
    @Expose
    var launchYear: String? = null

    @SerializedName("launch_date_unix")
    @Expose
    var launchDateUnix: Int? = null

    @SerializedName("launch_date_utc")
    @Expose
    var launchDateUtc: String? = null

    @SerializedName("launch_date_local")
    @Expose
    var launchDateLocal: String? = null

    @SerializedName("is_tentative")
    @Expose
    var isTentative: Boolean? = null

    @SerializedName("tentative_max_precision")
    @Expose
    var tentativeMaxPrecision: String? = null

    @SerializedName("tbd")
    @Expose
    var tbd: Boolean? = null

    @SerializedName("launch_window")
    @Expose
    var launchWindow: Int? = null

    @SerializedName("rocket")
    @Expose
    var rocket: Rocket? = null


    @SerializedName("launch_site")
    @Expose
    var launchSite: LaunchSite? = null

    @SerializedName("launch_success")
    @Expose
    var launchSuccess: Boolean? = null


    @SerializedName("launch_failure_details")
    @Expose
    var launchFailureDetails: LaunchFailureDetails? = null
    var detailLaunchStatus: String? = null


    @SerializedName("links")
    @Expose
    var links: Links? = null

    @SerializedName("details")
    @Expose
    var details: String? = null
    var colorId: Int = R.color.blue
    var favorite = false
    var spaceLaunchStatus: String? = null
    var launchFavorite: Int = R.drawable.ic_launcher_background

    /**
     * No args constructor for use in serialization
     */
    constructor()

    /**
     * @param tentativeMaxPrecision
     * @param launchYear
     * @param isTentative
     * @param rocket
     * @param launchSite
     * @param launchFailureDetails
     * @param launchDateLocal
     * @param flightNumber
     * @param tbd
     * @param missionName
     * @param launchDateUtc
     * @param launchSuccess
     * @param links
     * @param details
     * @param launchDateUnix
     * @param launchWindow
     * @param upcoming
     */
    constructor(
        flightNumber: Int?,
        missionName: String?,
        upcoming: Boolean?,
        launchYear: String?,
        launchDateUnix: Int?,
        launchDateUtc: String?,
        launchDateLocal: String?,
        isTentative: Boolean?,
        tentativeMaxPrecision: String?,
        tbd: Boolean?,
        launchWindow: Int?,
        rocket: Rocket?,
        launchSite: LaunchSite?,
        launchSuccess: Boolean?,
        launchFailureDetails: LaunchFailureDetails?,
        links: Links?,
        details: String?
    ) : super() {
        this.flightNumber = flightNumber
        this.missionName = missionName
        this.upcoming = upcoming
        this.launchYear = launchYear
        this.launchDateUnix = launchDateUnix
        this.launchDateUtc = launchDateUtc
        this.launchDateLocal = launchDateLocal
        this.isTentative = isTentative
        this.tentativeMaxPrecision = tentativeMaxPrecision
        this.tbd = tbd
        this.launchWindow = launchWindow
        this.rocket = rocket
        this.launchSite = launchSite
        this.launchSuccess = launchSuccess
        this.launchFailureDetails = launchFailureDetails
        this.links = links
        this.details = details
    }

    /**
     * Utility method to set Launch Status and color for statuses
     */
    fun updateSpaceLaunchStatus() {
        try {
            if (launchSuccess != null && launchSuccess as Boolean) {
                spaceLaunchStatus = "Success"
                colorId = R.color.green
                detailLaunchStatus = "Success"
            } else if (upcoming != null && upcoming as Boolean) {
                spaceLaunchStatus = "Upcoming"
                colorId = R.color.blue
                detailLaunchStatus = "Upcoming"
            } else {
                spaceLaunchStatus = "Failure"
                if (launchFailureDetails != null && launchFailureDetails!!.reason != null) {
                    detailLaunchStatus = launchFailureDetails!!.reason
                } else {
                    detailLaunchStatus = "Failure"
                }
                colorId = R.color.red
            }
        } catch (e: Exception) {
            colorId = R.color.blue
        }
    }

    companion object {
        private const val serialVersionUID = 7238764591150557943L
    }
}