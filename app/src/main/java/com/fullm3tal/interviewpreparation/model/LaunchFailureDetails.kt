package com.fullm3tal.interviewpreparation.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable



class LaunchFailureDetails : Serializable {

    var id: Long? = null

    @SerializedName("time")
    @Expose
    var time: Int? = null

    @SerializedName("altitude")
    @Expose
    var altitude: Int? = null

    @SerializedName("reason")
    @Expose
    var reason: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param altitude
     * @param reason
     * @param time
     */
    constructor(time: Int?, altitude: Int?, reason: String?) : super() {
        this.time = time
        this.altitude = altitude
        this.reason = reason
    }

    companion object {
        private const val serialVersionUID = 621808750342093780L
    }
}