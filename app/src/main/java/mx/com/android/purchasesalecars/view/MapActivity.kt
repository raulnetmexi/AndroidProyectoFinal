package mx.com.android.purchasesalecars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import mx.com.android.purchasesalecars.R
import mx.com.android.purchasesalecars.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity(),OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var maps:ActivityMapBinding
    companion object {
        var latitude:String?=""
        var longitude:String?=""
        var make:String?=""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        maps=ActivityMapBinding.inflate(layoutInflater)
        setContentView(maps.root)
        val bundle = intent.extras

         latitude = bundle?.getString("latitude", "0")
         longitude = bundle?.getString("longitude", "0")
        make = bundle?.getString("make", "")
        createFragment()
    }


    private fun createFragment()
    {
        val mapFragment:SupportMapFragment=supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        if (p0 != null) {
            map=p0
            createMarker()
        }
    }
    private fun createMarker()
    {
        val bundle = intent.extras
        latitude = bundle?.getString("latitude", "0")
        longitude = bundle?.getString("longitude", "0")
        make = bundle?.getString("make", "")
        val coordinates=LatLng(latitude?.toDouble() ?:0.0 , longitude?.toDouble()?:0.0)
        val marker:MarkerOptions=MarkerOptions().position(coordinates).title(make.toString())
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

}