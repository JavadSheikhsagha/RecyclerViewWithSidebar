package ir.nikapps.recyclerviewsnappedtoside

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.nikapps.recyclerviewsnappedtoside.databinding.RvitemMainSidebarBinding

class RvSidebarAdapter(
    private val list: List<String>,
    val onTouchDown: (String) -> Unit,
    val onTouchUp : (String) -> Unit
) : RecyclerView.Adapter<RvSidebarAdapter.RvSidebarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvSidebarViewHolder {
        val binding = RvitemMainSidebarBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rvitem_main_sidebar, parent, false)
        )
        return RvSidebarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvSidebarViewHolder, position: Int) {
        holder.bind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    inner class RvSidebarViewHolder(val binding: RvitemMainSidebarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ClickableViewAccessibility")
        fun bind(text: String, position: Int) {
            binding.txtSideBarItemTag.text = text

            binding.root.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN)
                    onTouchDown.invoke(text)
                else if (event.action == MotionEvent.ACTION_UP)
                    onTouchUp.invoke(text)
                return@setOnTouchListener false
            }

//            binding.root.setOnClickListener {
//                onTouchDown.invoke(text)
//            }

        }
    }
}