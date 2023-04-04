package mx.com.android.purchasesalecars.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import mx.com.android.purchasesalecars.databinding.ItemCarBinding
import mx.com.android.purchasesalecars.model.Car


class CarAdapter1(private val carList:List<Car>,
                  private val  itemClickListener: OnCarClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =  ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = CarsViewHolder(itemBinding)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onCarClick(carList[position])
        }

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CarsViewHolder -> holder.bind(carList[position])
        }
    }

    override fun getItemCount(): Int = carList.size

    private inner class CarsViewHolder(
        val binding: ItemCarBinding
    ) : BaseViewHolder<Car>(binding.root) {
        override fun bind(item: Car) {
      //      binding.tvTitle .text=item.name
        //    binding.tvTitle.text=item.age
          //  binding.ivThumbnail.setImageResource(item.image)
        }
    }
                    }