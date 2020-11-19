package thatcodeaddict.github.amongusinreallife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Players = findViewById<TextView>(R.id.Players)
        val Impostors = findViewById<TextView>(R.id.Impostors)

        val Result = findViewById<TextView>(R.id.Result)

        val Submit = findViewById<Button>(R.id.Submit)
        val CTC = findViewById<Button>(R.id.CTC)

        Submit.setOnClickListener{
            val a = Players.text
            val b = Impostors.text
            val listA = mutableListOf<Int>()
            val listB = mutableListOf<Int>()

            Result.setText("")

            if ((b.toString() == "")){
                Result.setText("Error")

            }else if (a.toString() == "") {
                Result.setText("Error")

            }else if (b.toString().toInt() >= 3){
                Result.setText("Imp > 3")
            }else {

                for (i in (1..a.toString().toInt())) {
                    listA.add(i)
                }

                var j = 0

                while (j != b.toString().toInt()) {
                    println(listB.size)
                    val x = Random.nextInt(0, a.toString().toInt())
                    if (listB.size == 0) {
                        listB.add(x.toString().toInt())
                        j = j + 1
                    } else if (j == b.toString().toInt()) {
                        break
                    } else {
                        for (k in listB) {
                            if (k == x + 1) {
                                print("pass")
                            } else {
                                listB.add(x.toString().toInt() + 1)
                                j = j + 1
                            }
                        }
                    }
                }
                CTC.isEnabled = true
                println("This is listB")
                println(listB.size)
                var l = 0
                var i = 0
                CTC.setOnClickListener {
                    l = 0
                    Result.setText("")
                    if (i == listA.size){
                        CTC.isEnabled = false
                    }else{
                        for (j in listB){
                            if (j.toString().toInt() == i){
                                l = 1
                            }
                        }
                        if (l == 1){
                            Result.setText("Impostor")
                            i = i+1
                        }else{
                            Result.setText("Crewmate")
                            i = i+1
                        }
                        println(i)
                    }
                }
            }
        }
    }
}