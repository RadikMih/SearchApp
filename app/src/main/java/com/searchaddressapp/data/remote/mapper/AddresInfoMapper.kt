package com.searchaddressapp.data.remote.mapper

import com.searchaddressapp.data.remote.model.Feature
import com.searchaddressapp.domain.model.AddressInfo

fun Feature.toAddressInfo(): AddressInfo {
    return AddressInfo(
        label = this.property?.label ?: "",
        longitude = this.geometry?.coordinates?.get(0) ?: 0.0,
        latitude = this.geometry?.coordinates?.get(1) ?: 0.0
    )
}