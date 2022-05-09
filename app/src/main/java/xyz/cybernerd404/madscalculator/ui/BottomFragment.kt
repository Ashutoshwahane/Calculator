package xyz.cybernerd404.madscalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import xyz.cybernerd404.madscalculator.History
import xyz.cybernerd404.madscalculator.adapter.HistoryAdapter
import xyz.cybernerd404.madscalculator.databinding.BottomFragmentBinding

class BottomFragment(private val list: MutableList<History>) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomFragmentBinding
    private lateinit var adapter: HistoryAdapter

    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        binding.apply {
            historyRV.layoutManager = LinearLayoutManager(requireContext())
            historyRV.adapter = adapter
        }

        adapter.setHistory(list)


    }
}