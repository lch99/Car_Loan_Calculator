package com.example.carloancalculator

import android.icu.text.LocaleDisplayNames
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()

        }


    }
    private fun calculateLoan(){
        //TODO get all inputs and display outputs

        //Validation
        if(editTextCarPrice.text.isBlank()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }

        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val rate: Double = editTextInterestRate.text.toString().toDouble()
        val loan: Int = (carPrice - downPayment)
        val interest: Double = (loan * (rate/100) * loanPeriod)
        val monthly: Double = ((loan+interest)/loanPeriod/12)
        val country = Locale.getDefault()
        val currency = Currency.getInstance(country).getSymbol()

        textViewLoan.setText(getString(R.string.loan) + currency + "${loan}")
        textViewInterest.setText(getString(R.string.interest) + currency + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + currency + "${monthly}")

        Toast.makeText(this, "Calculate Loan",Toast.LENGTH_SHORT).show()
    }

    fun reset(view: View){
        //TODO clear all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.setText(R.string.loan)
        textViewInterest.setText(R.string.interest)
        textViewMonthlyRepayment.setText(R.string.monthly_repayment)

        Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()

    }
}
