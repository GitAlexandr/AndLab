package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RectanglesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rectangles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = GridLayoutManager(requireContext(), getNumberOfColumns())

        viewAdapter = RectanglesAdapter()

        recyclerView = view.findViewById<RecyclerView>(R.id.rectangles_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        view.findViewById<FloatingActionButton>(R.id.add_rectangle_button).setOnClickListener {
            (viewAdapter as RectanglesAdapter).addRectangle()
        }
    }

    private fun getNumberOfColumns(): Int {
        return if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            3
        } else {
            4
        }
    }
}
