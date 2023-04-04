package mx.com.android.purchasesalecars.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import mx.com.android.purchasesalecars.R
import mx.com.android.purchasesalecars.view.fragment.CarFragment
import mx.com.android.purchasesalecars.view.fragment.PreferencesFragment
import mx.com.android.purchasesalecars.view.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main_list1.*

class MainListActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list1)
        setup()
        loadFragment(CarFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }


    private fun setup()
    {
        bottomNavigation_view.setOnItemSelectedListener {
            val fragment = when(it.itemId)
            {
                R.id.home -> {CarFragment()}
                R.id.preferences ->{
                    PreferencesFragment()
                }
                else-> {
                    ProfileFragment()
                }
            }
            loadFragment(fragment)
            true
        }

    }
}