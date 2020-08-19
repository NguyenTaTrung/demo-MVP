package sun.trainingcourse.demomvp.data.source

import sun.trainingcourse.demomvp.data.Cake

interface CakeDataSource {
    fun getCakeList(): MutableList<Cake>
}
