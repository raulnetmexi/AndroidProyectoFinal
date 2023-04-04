package mx.com.android.purchasesalecars.model

import com.google.gson.annotations.SerializedName

/**
 * Creado por Raul Oropeza el 23/01/23
 */
data class CarModelDetail(

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("make")
    var make: String? = null,

    @SerializedName("model")
    var model: String? = null,

    @SerializedName("cylinders")
    var cylinders: String? = null,

    @SerializedName("transmission")
    var transmission: String? = null,

    @SerializedName("year")
    var year: String? = null,

    @SerializedName("long_desc")
    var longDesc: String? = null,

    @SerializedName("latitude")
    var latitude: String? = null,

    @SerializedName("longitude")
    var longitude: String? = null
)
