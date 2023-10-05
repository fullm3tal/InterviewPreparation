package com.fullm3tal.interviewpreparation.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Fairings : Serializable {

    var id: Long? = null

    @SerializedName("reused")
    @Expose
    var reused: Boolean? = null

    @SerializedName("recovery_attempt")
    @Expose
    var recoveryAttempt: Boolean? = null

    @SerializedName("recovered")
    @Expose
    var recovered: Boolean? = null

    @SerializedName("ship")
    @Expose
    var ship: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param recovered
     * @param recoveryAttempt
     * @param ship
     * @param reused
     */
    constructor(
        reused: Boolean?,
        recoveryAttempt: Boolean?,
        recovered: Boolean?,
        ship: String?
    ) : super() {
        this.reused = reused
        this.recoveryAttempt = recoveryAttempt
        this.recovered = recovered
        this.ship = ship
    }

    companion object {
        private const val serialVersionUID = 51770051369617186L
    }
}