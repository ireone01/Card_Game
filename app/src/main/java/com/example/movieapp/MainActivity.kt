package com.example.movieapp
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import com.example.movieapp.models.BoardSize
import com.example.movieapp.models.MemoryCard
import com.example.movieapp.models.MemoryGame
import com.example.movieapp.utils.DEFAULT
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var clRoot : ConstraintLayout
    private lateinit var rvBoard : RecyclerView
    private lateinit var textView1 : TextView
    private lateinit var textView2 : TextView

    private lateinit var memoryGame: MemoryGame
    private lateinit var adapter : MemoryBoardAdapter
    private var boardSize : BoardSize = BoardSize.EASY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clRoot = findViewById(R.id.clRoot)
        rvBoard = findViewById(R.id.rvBoard)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)


        textView1.setTextColor(ContextCompat.getColor(this,R.color.color_progress_none))
        memoryGame = MemoryGame(boardSize)
        adapter = MemoryBoardAdapter(this,boardSize,memoryGame.cards,object :MemoryBoardAdapter.CardClickListener{
            override fun onCardClicked(position: Int) {
             updateGameWithFlip(position)
            }



        })
        rvBoard.adapter = adapter
        rvBoard.setHasFixedSize(true)  // ??
        rvBoard.layoutManager =GridLayoutManager(this,boardSize.getWidth())
    }
    @SuppressLint("RestrictedApi")
    private fun updateGameWithFlip(position: Int){

        if( memoryGame.haveWonGame()) {
            Snackbar.make(clRoot,"banj da thang", Snackbar.LENGTH_LONG).show()
            return
        }
        if(memoryGame.isCardFaceUp(position)){
            Snackbar.make(clRoot,"banj khong the thuc hien hanh dong nay", Snackbar.LENGTH_LONG).show()
            return
        }
        if(memoryGame.flipCard(position)){
            Log.i(TAG,"ban vua lat 1 cap the , so cap the hien tai : ${memoryGame.numPairFound}")
            val color = ArgbEvaluator().evaluate(
                memoryGame.numPairFound.toFloat() / boardSize.getNumPairs(),
                ContextCompat.getColor(this,R.color.color_progress_none),
                ContextCompat.getColor(this,R.color.color_progress_full)
            ) as Int
            textView1.setTextColor(color)
            textView1.text ="Pair : ${memoryGame.numPairFound}/${boardSize.getNumPairs()}"
            if(memoryGame.haveWonGame()){
                Snackbar.make(clRoot,"banj thangs ",Snackbar.LENGTH_LONG).show()
            }
        }
        textView2.text =" Moves : ${memoryGame.getNummoves()}"
        adapter.notifyDataSetChanged()
    }
}
