package mx.com.android.purchasesalecars.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.com.android.purchasesalecars.R
import mx.com.android.purchasesalecars.databinding.FragmentCarBinding
import mx.com.android.purchasesalecars.model.Car
import mx.com.android.purchasesalecars.view.activities.CarDetailActivity
import mx.com.android.purchasesalecars.view.adapter.CarAdapter1

class CarFragment :Fragment(R.layout.fragment_car), CarAdapter1.OnCarClickListener {
    private lateinit var binding: FragmentCarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCarBinding.bind(view)
        val animalAdapter = CarAdapter1(getData(), this@CarFragment)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = animalAdapter
    }

    private fun getData(): List<Car> {

        val data = arrayListOf<Car>()
        data.add(Car("Jirafa", "3 años", R.drawable.gato))
        data.add(Car("Gato", "2 años", R.drawable.gato))
        data.add(Car("Elefante", "12 años", R.drawable.gato))
        data.add(Car("León", "8 años", R.drawable.gato))
        data.add(Car("Oso", "7 años", R.drawable.gato))
        data.add(Car("Pato", "3 años", R.drawable.gato))
        data.add(Car("Zorro", "1 años", R.drawable.gato))
        data.add(Car("Ardilla", "2 años", R.drawable.gato))
        return data
    }


    override fun onCarClick(car: Car) {
        val intent = Intent(context, CarDetailActivity::class.java)
        val animal = Car(car.name, car.age, car.image)
        intent.putExtra("KEY_ANIMAL", animal)
        startActivity(intent)
    }
}