package com.example.challengechapter5

class Controller(var view: ResultView) {
    var suit = listOf("Batu", "Gunting", "Kertas")

    fun checkResultPemain(firstPlayer:String, secondPlayer: String){
        if (firstPlayer == suit[0] && secondPlayer == suit[1] ||
            firstPlayer == suit[1] && secondPlayer == suit[2] ||
            firstPlayer == suit[2] && secondPlayer == suit[0]){
            view.showResult(R.drawable.p1menang)
        } else if(  firstPlayer == suit[0] && secondPlayer == suit[0] ||
                    firstPlayer == suit[1] && secondPlayer == suit[1] ||
                    firstPlayer == suit[2] && secondPlayer == suit[2]){
            view.showResult(R.drawable.draw)
        } else {
            view.showResult(R.drawable.p2menang)
        }
    }

    fun checkResultCpu(firstPlayer: String, secondPlayer: String){
        if (firstPlayer == suit[0] && secondPlayer == suit[1] ||
            firstPlayer == suit[1] && secondPlayer == suit[2] ||
            firstPlayer == suit[2] && secondPlayer == suit[0]){
            view.showResult(R.drawable.p1menang)
        } else if(  firstPlayer == suit[0] && secondPlayer == suit[0] ||
            firstPlayer == suit[1] && secondPlayer == suit[1] ||
            firstPlayer == suit[2] && secondPlayer == suit[2]){
            view.showResult(R.drawable.draw)
        } else {
            view.showResult(R.drawable.cpumenang)
        }
    }

    fun checkPemenang(firstPlayer: String, secondPlayer: String){
        checkResultPemain(firstPlayer, secondPlayer)
    }

    fun checkPemenangCpu(firstPlayer: String, secondPlayer: String){
        checkResultCpu(firstPlayer, secondPlayer)
    }

}

