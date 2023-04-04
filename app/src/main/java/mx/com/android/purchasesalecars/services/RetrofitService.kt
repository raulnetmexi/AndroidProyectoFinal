package mx.com.android.purchasesalecars.services


import mx.com.android.purchasesalecars.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Creado por Raul Oropeza el 23/01/23 el 18/01/23
 */
object RetrofitService{
    private var INSTANCE: Retrofit? = null

    fun getRetrofit(): Retrofit{
        return INSTANCE ?: synchronized(this){
            val instance = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            INSTANCE = instance

            instance
        }
    }
}