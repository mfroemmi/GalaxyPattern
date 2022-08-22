package com.example.galaxypattern.gui.start

import com.example.galaxypattern.gui.start.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SolarSystemView
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider

class StartViewModel {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: StartViewModel

        fun getInstance(): StartViewModel {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = StartViewModel()
                }
                return instance
            }
        }
    }

    var label: Label = Label("Galaxy Pattern")
    var button: Button = Button("Solar System")
    var btnPlayStop: Button = Button("Play/Stop")
    var slider: Slider = Slider(0.0, 100.0, 0.0)
    val backgroundView = BackgroundView()
    val solarSystemView = SolarSystemView()

    var isRotate = false

    init {
        label.apply {
            translateY = -200.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        button.apply {
            translateY = 200.0
            style = "-fx-background-color: #FFFFFF;"
        }
        btnPlayStop.apply {
            translateX = -200.0
            translateY = 300.0
            style = "-fx-background-color: #FFFFFF;"
        }
        slider.apply {
            translateX = 200.0
            translateY = 300.0
            maxWidth = 200.0
            majorTickUnit = 25.0;
            blockIncrement = 10.0;
            isShowTickLabels = true;
            isShowTickMarks = true;
            isSnapToTicks = true
        }
    }
}