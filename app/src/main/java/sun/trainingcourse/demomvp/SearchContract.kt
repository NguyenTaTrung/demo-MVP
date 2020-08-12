package sun.trainingcourse.demomvp

import sun.trainingcourse.demomvp.data.Cake

interface SearchContract {
    interface View {
        fun initView(listCake: MutableList<Cake>)

        fun showCakes(newListCake: MutableList<Cake>)
        fun showError(error: String)
    }

    interface Presenter {
        fun initData()

        fun searchCake(value: String?)
    }
}
