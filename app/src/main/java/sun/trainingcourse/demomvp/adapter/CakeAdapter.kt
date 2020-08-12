package sun.trainingcourse.demomvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sun.trainingcourse.demomvp.R
import sun.trainingcourse.demomvp.data.Cake

class CakeAdapter : RecyclerView.Adapter<CakeHolder>() {

    private val cakes = mutableListOf<Cake>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeHolder {
        return CakeHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cake_list, parent, false)
        )
    }

    override fun getItemCount(): Int = cakes.size

    override fun onBindViewHolder(holder: CakeHolder, position: Int) {
        holder.bindData(cakes[position])
    }

    fun updateCakeList(newCakeList: MutableList<Cake>) {
        cakes.clear()
        cakes.addAll(newCakeList)
        notifyDataSetChanged()
    }
}
