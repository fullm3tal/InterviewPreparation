package com.fullm3tal.interviewpreparation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Payload : Serializable {

    var id: Long? = null

    @SerializedName("payload_id")
    @Expose
    var payloadId: String? = null

    @SerializedName("reused")
    @Expose
    var reused: Boolean? = null

    @SerializedName("nationality")
    @Expose
    var nationality: String? = null

    @SerializedName("manufacturer")
    @Expose
    var manufacturer: String? = null

    @SerializedName("payload_type")
    @Expose
    var payloadType: String? = null

    @SerializedName("payload_mass_kg")
    @Expose
    var payloadMassKg: Double? = null

    @SerializedName("payload_mass_lbs")
    @Expose
    var payloadMassLbs: Double? = null

    @SerializedName("orbit")
    @Expose
    var orbit: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param payloadId
     * @param payloadMassLbs
     * @param nationality
     * @param payloadType
     * @param payloadMassKg
     * @param reused
     * @param manufacturer
     */

    constructor(
        payloadId: String?,
        reused: Boolean?,
        nationality: String?,
        manufacturer: String?,
        payloadType: String?,
        payloadMassKg: Double?,
        payloadMassLbs: Double?
    ) : super() {
        this.payloadId = payloadId
        this.reused = reused
        this.nationality = nationality
        this.manufacturer = manufacturer
        this.payloadType = payloadType
        this.payloadMassKg = payloadMassKg
        this.payloadMassLbs = payloadMassLbs
    }

    companion object {
        private const val serialVersionUID = -8306574962610614685L
    }
}