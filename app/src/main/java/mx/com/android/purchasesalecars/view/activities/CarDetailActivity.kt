package mx.com.android.purchasesalecars.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.android.purchasesalecars.databinding.ActivityCarDetailBinding
import mx.com.android.purchasesalecars.model.Car

class CarDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCarDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Detalle Animal"
        intent.extras.let { it
            if (it != null) {
                if(it.containsKey("KEY_ANIMAL")) {
                    val car: Car =it.getSerializable("KEY_ANIMAL") as Car
                    binding.nameAnimal.text=car.name
                    binding.imgAnimal.setImageResource(car.image)

                }
            }
        }

    }
}
