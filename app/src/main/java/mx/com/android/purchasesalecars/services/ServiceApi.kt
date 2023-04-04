package mx.com.android.purchasesalecars.services


import mx.com.android.purchasesalecars.model.CarModel
import mx.com.android.purchasesalecars.model.CarModelDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Creado por Raul Oropeza el 23/01/23 el 14/01/23
 */
interface ServiceApi {

    @GET(EndPoint.GET_CARS)
    fun getCars(
    ): Call<ArrayList<CarModel>>

    @GET("cars/car_detail/{id}")
    fun getCarDetailApiary(
        @Path("id") id: String?
    ): Call<CarModelDetail>

}