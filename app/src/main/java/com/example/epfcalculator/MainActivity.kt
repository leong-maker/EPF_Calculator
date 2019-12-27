package com.example.epfcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtdate.setOnClickListener(){
            val c:Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    txtdate.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())

                    val age: Int = currentYear - year
                    val basicSaving = getSaving(age)
                    txtshowage.text = age.toString()

                    txtshowbasic.text = "RM" + basicSaving.toString()
                    txtshowinvest.text = "RM" + (basicSaving * 0.3)
                }, currentYear,currentMonth,currentDay)
            dpd.show()
        }
    }
fun getSaving(age: Int): Double{
    return when(age){
        16, 17, 18, 19, 20 -> return 5000.00
        21, 22, 23, 24, 25 -> return 14000.00
        26, 27, 28, 29, 30 -> return 29000.00
        31, 32, 33, 34, 35 -> return 50000.00
        36, 37, 38, 39, 40 -> return 78000.00
        41, 42, 43, 44, 45 -> return 116000.00
        46, 47, 48, 49, 50 -> return 165000.00
        51, 52, 53, 54, 55 -> return 228000.00
        else -> 0.00
    }
  }
}

