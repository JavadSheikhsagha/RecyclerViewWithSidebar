package ir.nikapps.recyclerviewsnappedtoside

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.nikapps.recyclerviewsnappedtoside.databinding.RvitemMainRvBinding

class RvMainAdapter(
    private val list: MutableList<MainItemModel>,
    val getItemPosition : (Int) -> Unit
) : RecyclerView.Adapter<RvMainAdapter.RvMainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvMainViewHolder {
        val binding = RvitemMainRvBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.rvitem_main_rv,parent,false))
        return RvMainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvMainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class RvMainViewHolder(var binding: RvitemMainRvBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(mainItemModel: MainItemModel){

            binding.apply {

                getItemPosition.invoke(mainItemModel.number)

                txtMainRvItemNumber.text = mainItemModel.number.toString()

                txTMainRvItemText.text = mainItemModel.title
            }
        }
    }

    fun getPositionOfItemWithNumber(number : Int): Int? {
        list.forEachIndexed { index, mainItemModel ->
            if (mainItemModel.number == number)
                return index
        }
        return null
    }

}