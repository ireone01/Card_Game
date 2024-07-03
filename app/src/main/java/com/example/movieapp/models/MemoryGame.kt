package com.example.movieapp.models

import android.icu.text.Transliterator.Position
import com.example.movieapp.utils.DEFAULT

class MemoryGame (private val boardSize: BoardSize){
    val cards: List<MemoryCard>
    var numPairFound =0

    private var indexOfSingleSelectedCard : Int? =null
    init{
        val chosenImages =  DEFAULT.shuffled().take(boardSize.getNumPairs())
        val randomzedImages = (chosenImages + chosenImages).shuffled()
        cards = randomzedImages.map { MemoryCard(it) }

    }
    fun flipCard(position: Int): Boolean {
        val card  : MemoryCard = cards[position]

        var foundMatch = false

        if (indexOfSingleSelectedCard == null){
            restoreCards()
            indexOfSingleSelectedCard = position
        }else{
            foundMatch = checkForMatch(indexOfSingleSelectedCard!!,position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
        return foundMatch
    }
    private fun checkForMatch(position1: Int, position2: Int): Boolean{
        if(cards[position1].identifier !=cards[position2].identifier) {
            return false
        }
        cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairFound++
        return true
    }
    private fun restoreCards(){
        for(card in cards){
            if(!card.isMatched){
                card.isFaceUp = false
            }
        }
    }

    fun haveWonGame(): Boolean {
        return numPairFound == boardSize.getNumPairs()
    }

    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }
}