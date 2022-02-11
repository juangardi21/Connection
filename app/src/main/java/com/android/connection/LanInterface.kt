package com.android.connection

sealed class LanInterface{

    data class Ethernet(
        val speedInMB: Float,
    ): LanInterface()

    data class Wifi(
        val speedInMB: Float,
        val band: Band = Band.LOW_FREQUENCY,
        val rssi: Float = 0F,
    ): LanInterface()

    data class Unknown(
        val speedInMB: Float,
    ) : LanInterface()
}


enum class Band {
    LOW_FREQUENCY,
    HIGH_FREQUENCY
}

fun Band.toValue() =
    when(this) {
        Band.LOW_FREQUENCY -> { 2.4F }
        Band.HIGH_FREQUENCY -> { 5F }
    }