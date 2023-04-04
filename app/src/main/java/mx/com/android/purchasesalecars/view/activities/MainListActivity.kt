package mx.com.android.purchasesalecars.view.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_list1.*


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import mx.com.android.purchasesalecars.R
import mx.com.android.purchasesalecars.databinding.ActivityMainBinding
import mx.com.android.purchasesalecars.databinding.ActivityMainListBinding
import mx.com.android.purchasesalecars.model.Car

import mx.com.android.purchasesalecars.model.CarModel
import mx.com.android.purchasesalecars.services.ServiceApi

import mx.com.android.purchasesalecars.services.RetrofitService
import mx.com.android.purchasesalecars.util.Constants
import mx.com.android.purchasesalecars.view.adapter.CarAdapter
import mx.com.android.purchasesalecars.view.fragment.CarFragment
import mx.com.android.purchasesalecars.view.fragment.PreferencesFragment
import mx.com.android.purchasesalecars.view.fragment.ProfileFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainListActivity : AppCompatActivity(),CarAdapter.OnCarsClickListener  {

    private lateinit var binding: ActivityMainListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        title = "Autos en Venta"
        CoroutineScope(Dispatchers.IO).launch {

            Log.d(Constants.LOGTAG, "Hilo al iniciar la corrutina: ${Thread.currentThread().name}")

            val call =
                RetrofitService.getRetrofit().create(ServiceApi::class.java).getCars()  //Con Apiary

            call.enqueue(object : Callback<ArrayList<CarModel>> {
                override fun onResponse(
                    call: Call<ArrayList<CarModel>>,
                    response: Response<ArrayList<CarModel>>
                ) {
                    Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()}")
                    Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")
                    Log.d(Constants.LOGTAG, "Hilo en el onResponse: ${Thread.currentThread().name}")

                    binding.pbConexion.visibility = View.GONE
                    binding.rvMenu.layoutManager = LinearLayoutManager(this@MainListActivity)
                    binding.rvMenu.adapter=CarAdapter(response.body()!!,this@MainListActivity)
                }

                override fun onFailure(call: Call<ArrayList<CarModel>>, t: Throwable) {
                    Toast.makeText(
                        this@MainListActivity,
                        "No hay conexión. Error: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                 //   binding.pbConexion.visibility = View.GONE
                }
            })

        }

    }
    override fun onCarClick(car: CarModel) {
        val parametros = Bundle().apply {
            putString("id", car.id)
        }
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtras(parametros)
        }
        startActivity(intent)
    }




    private fun setup()
    {
        bottomNavigation_view.setOnItemSelectedListener {
            val activity = when(it.itemId)
            {
                R.id.home -> {
                    val intent = Intent(this, DetailsActivity::class.java).apply {
                        startActivity(intent)
                    }

                }
                R.id.preferences ->{
                    val intent = Intent(this, CarDetailActivity::class.java)
                    startActivity(intent)
                }
                else-> {
                    ProfileFragment()
                }
            }

            true
        }

    }
}