package com.example.compose_list_sample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose_list_sample.data.GenshinChar

class GenshinCharViewModel : ViewModel() {

    val charList = MutableLiveData<ArrayList<GenshinChar>>()
    var selectedChar = GenshinChar()

    fun getChars() {
        val tempCharList = ArrayList<GenshinChar>()
        val bennett = GenshinChar()
        bennett.id = 1
        bennett.name = "Bennett"
        bennett.vision = "Pyro"
        bennett.weaponType = "Sword"
        bennett.region = "Mondstadt"
        bennett.imgUrl =
            "https://static.wikia.nocookie.net/gensin-impact/images/2/27/Character_Bennett_Full_Wish.png/revision/latest/scale-to-width-down/1000?cb=20220507132108"
        tempCharList.add(bennett)

        val xingqiu = GenshinChar()
        xingqiu.id = 2
        xingqiu.name = "Xingqiu"
        xingqiu.vision = "Hydro"
        xingqiu.weaponType = "Sword"
        xingqiu.region = "Liyue"
        xingqiu.imgUrl =
            "https://static.wikia.nocookie.net/gensin-impact/images/a/ad/Character_Xingqiu_Full_Wish.png/revision/latest/scale-to-width-down/1000?cb=20220507161206"
        tempCharList.add(xingqiu)

        val kazuha = GenshinChar()
        kazuha.id = 3
        kazuha.name = "Kazuha"
        kazuha.vision = "Anemo"
        kazuha.weaponType = "Sword"
        kazuha.region = "Inazuma"
        kazuha.imgUrl =
            "https://static.wikia.nocookie.net/gensin-impact/images/5/57/Character_Kaedehara_Kazuha_Full_Wish.png/revision/latest/scale-to-width-down/1000?cb=20220507131548"
        tempCharList.add(kazuha)

        val ayaka = GenshinChar()
        ayaka.id = 4
        ayaka.name = "Ayaka"
        ayaka.vision = "Cryo"
        ayaka.weaponType = "Sword"
        ayaka.region = "Inazuma"
        ayaka.imgUrl =
            "https://static.wikia.nocookie.net/gensin-impact/images/d/d0/Character_Kamisato_Ayaka_Full_Wish.png/revision/latest/scale-to-width-down/1000?cb=20220507132731"
        tempCharList.add(ayaka)

        charList.value = tempCharList
    }
}