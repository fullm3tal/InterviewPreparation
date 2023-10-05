package com.fullm3tal.interviewpreparation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Core : Serializable {
    var id: Long? = null

    @SerializedName("core_serial")
    @Expose
    var coreSerial: String? = null

    @SerializedName("flight")
    @Expose
    var flight: Int? = null

    @SerializedName("block")
    @Expose
    var block: Int? = null

    @SerializedName("gridfins")
    @Expose
    var gridfins: Boolean? = null

    @SerializedName("legs")
    @Expose
    var legs: Boolean? = null

    @SerializedName("reused")
    @Expose
    var reused: Boolean? = null

    @SerializedName("land_success")
    @Expose
    var landSuccess: Boolean? = null

    @SerializedName("landing_intent")
    @Expose
    var landingIntent: Boolean? = null

    @SerializedName("landing_type")
    @Expose
    var landingType: String? = null

    @SerializedName("landing_vehicle")
    @Expose
    var landingVehicle: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param flight
     * @param landSuccess
     * @param landingType
     * @param gridfins
     * @param landingIntent
     * @param coreSerial
     * @param legs
     * @param landingVehicle
     * @param block
     * @param reused
     */
    constructor(
        coreSerial: String?,
        flight: Int?,
        block: Int?,
        gridfins: Boolean?,
        legs: Boolean?,
        reused: Boolean?,
        landSuccess: Boolean?,
        landingIntent: Boolean?,
        landingType: String?,
        landingVehicle: String?
    ) : super() {
        this.coreSerial = coreSerial
        this.flight = flight
        this.block = block
        this.gridfins = gridfins
        this.legs = legs
        this.reused = reused
        this.landSuccess = landSuccess
        this.landingIntent = landingIntent
        this.landingType = landingType
        this.landingVehicle = landingVehicle
    }

}