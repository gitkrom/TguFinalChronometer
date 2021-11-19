package com.example.tgufinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tgufinalchronometer.R
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer


class ChronometerFragment : Fragment() {

    private lateinit var chronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_chronometer, container, false)


        chronometer = view.findViewById(R.id.chronometer_example)
        startButton = view.findViewById(R.id.start_button)
        stopButton = view.findViewById(R.id.stop_button)
        resetButton = view.findViewById(R.id.reset_button)


        startButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.start()
        }

        stopButton.setOnClickListener {
            chronometer.stop()
        }

        resetButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
        }

        return view
    }


}


