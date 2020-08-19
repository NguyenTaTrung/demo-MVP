package sun.trainingcourse.demomvp

import sun.trainingcourse.demomvp.data.Cake
import sun.trainingcourse.demomvp.data.source.CakeRepository
import java.util.*

class SearchPresenter(
    private val view: SearchContract.View,
    private val cakeRepository: CakeRepository
) : SearchContract.Presenter {

    override fun initData() {
        view.initView(cakeRepository.getCakeList())
    }

    override fun searchCake(value: String?) {
        val newCakeList = mutableListOf<Cake>()
        var isExistCake = false
        cakeRepository.getCakeList().forEach { cake ->
            if (value!!.toLowerCase(Locale.getDefault())
                    .contains(cake.name.toLowerCase(Locale.getDefault()))
            ) {
                newCakeList.add(cake)
                isExistCake = true
            }
        }
        if (!isExistCake) view.showError("No result!")
        view.showCakes(newCakeList)
    }

}
