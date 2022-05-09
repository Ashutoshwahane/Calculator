package xyz.cybernerd404.madscalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import xyz.cybernerd404.madscalculator.Calculator
import xyz.cybernerd404.madscalculator.History
import xyz.cybernerd404.madscalculator.calculateResults
import xyz.cybernerd404.madscalculator.databinding.ActivityMainBinding
import xyz.cybernerd404.madscalculator.debug

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var canAddOperation = false
    private var canAddDecimal = true
    private lateinit var historyList: MutableList<History>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        historyList = arrayListOf()

    }

    fun equalsAction(view: View) {
        val history = History()
        val final = Calculator.evaluate(binding.workingsTV.text.toString())
        var result = Calculator.evaluate(binding.workingsTV.text.toString())
        debug("$result")
        binding.resultsTV.text = "$final"
        if (historyList.size >= 10){
            historyList.remove(historyList.first())
            history.equation = binding.workingsTV.text.toString()
            history.ans = final.toString()
            historyList.add(history)
        }else {
            history.equation = binding.workingsTV.text.toString()
            history.ans = final.toString()
            historyList.add(history)
        }


    }

    fun backSpaceAction(view: View) {
        binding.apply {
            if (workingsTV.text.isNotEmpty()) {
                workingsTV.text = workingsTV.text.subSequence(0, workingsTV.length() - 1)
            }
        }

    }

    fun allClearAction(view: View) {
        binding.apply {
            workingsTV.text = ""
            resultsTV.text = ""
        }

    }

    fun historyAction(view: View) {
        if (historyList.isEmpty()) {
            Toast.makeText(this, "There is no History", Toast.LENGTH_SHORT).show()
        } else {
            BottomFragment(historyList).apply {
                show(supportFragmentManager, BottomFragment.TAG)
            }
        }

    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal)
                    binding.workingsTV.append(view.text)

                canAddDecimal = false
            } else
                binding.workingsTV.append(view.text)

            canAddOperation = true
        }
    }

    fun operationAction(view: View) {
        if (view is Button && canAddOperation) {
            binding.workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }
}