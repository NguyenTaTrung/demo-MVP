package sun.trainingcourse.demomvp.data.source

import sun.trainingcourse.demomvp.data.Cake

class CakeRepository : CakeDataSource {

    override fun getCakeList(): MutableList<Cake> {

        return mutableListOf(
            Cake("Oreo"),
            Cake("Chocolate"),
            Cake("One One"),
            Cake("Hibiscus"),
            Cake("Apple"),
            Cake("Banana"),
            Cake("Calamine")
        )
    }

}
