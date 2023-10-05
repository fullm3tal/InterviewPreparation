package com.fullm3tal.interviewpreparation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
class Rocket : Serializable {

    var id: Long? = null

    @SerializedName("rocket_id")
    @Expose
    var rocketId: String? = null

    @SerializedName("rocket_name")
    @Expose
    var rocketName: String? = null

    @SerializedName("rocket_type")
    @Expose
    var rocketType: String? = null

    @SerializedName("fairings")
    @Expose
    var fairings: Fairings? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param rocketId
     * @param fairings
     * @param rocketType
     * @param rocketName
     */

    constructor(
        rocketId: String?,
        rocketName: String?,
        rocketType: String?,
        fairings: Fairings?
    ) : super() {
        this.rocketId = rocketId
        this.rocketName = rocketName
        this.rocketType = rocketType
        this.fairings = fairings
    }

    companion object {
        private const val serialVersionUID = 6194551240326071552L
    }
}