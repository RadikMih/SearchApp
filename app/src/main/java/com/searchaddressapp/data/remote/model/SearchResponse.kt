package com.searchaddressapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("version")
    var version: String? = null,
    @SerializedName("features")
    var features: List<Feature> = emptyList(),
    @SerializedName("attribution")
    var attribution: String? = null,
    @SerializedName("licence")
    var licence: String? = null,
    @SerializedName("query")
    var query: String? = null,
    @SerializedName("filters")
    var filter: Filter? = Filter(),
    @SerializedName("limit")
    var limit: Int? = null
)

data class Feature(
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("geometry")
    var geometry: Geometry? = Geometry(),
    @SerializedName("properties")
    var property: Property? = Property()
)

data class Property(
    @SerializedName("label")
    var label: String? = null,
    @SerializedName("score")
    var score: Double? = null,
    @SerializedName("housenumber")
    var housenumber: String? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("postcode")
    var postcode: String? = null,
    @SerializedName("citycode")
    var citycode: String? = null,
    @SerializedName("x")
    var x: Double? = null,
    @SerializedName("y")
    var y: Double? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("district")
    var district: String? = null,
    @SerializedName("context")
    var context: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("importance")
    var importance: Double? = null,
    @SerializedName("street")
    var street: String? = null
)

data class Geometry(
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("coordinates")
    var coordinates: List<Double> = emptyList()
)

data class Filter(
    @SerializedName("type")
    var type: String? = null
)