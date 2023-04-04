package mx.com.android.purchasesalecars.view.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.com.android.purchasesalecars.databinding.ItemCarBinding
import mx.com.android.purchasesalecars.model.CarModel

/**
 * Creado por Raul Oropeza el 23/01/23
 */
class CarAdapter(private val carList: List<CarModel>,
                 private val  itemClickListener: OnCarsClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {
    //class ViewHolder(view: ItemCarBinding): RecyclerView.ViewHolder(view.root) {
    //    val ivThumbnail = view.ivThumbnail
      //  val tvTitle = view.tvTitle
   // }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =  ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = CarsViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onCarClick(carList[position])
        }
        return holder
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CarsViewHolder -> holder.bind(carList[position])
        }
    }

    private inner class CarsViewHolder(
            val binding: ItemCarBinding,
            val context: Context
        ) : BaseViewHolder<CarModel>(binding.root) {
            override fun bind(item: CarModel) {
                binding.carModel.text=item.title.toString()
                binding.carMark.text=item.year.toString()
                binding.carTypeDoc.text=item.Type_document.toString()
                binding.carAnio.text=item.cilindradas.toString()
                Glide.with(context).load(item.thumbnail).centerCrop().into(binding.carImage)

            }
        }

    interface OnCarsClickListener {
        fun onCarClick(car: CarModel)
    }
}