package sun.trainingcourse.demomvp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cake_list.view.*
import sun.trainingcourse.demomvp.data.Cake

class CakeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var itemData: Cake? = null

    fun bindData(cake: Cake) {
        itemData = cake
        itemView.run {
            textCakeName.text = cake.name
        }
    }
}