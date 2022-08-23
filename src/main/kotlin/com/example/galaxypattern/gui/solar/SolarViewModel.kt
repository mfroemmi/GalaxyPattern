package com.example.galaxypattern.gui.solar

import com.example.galaxypattern.gui.solar.view.SolarSystemView
import com.example.galaxypattern.main.view.BackgroundView
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider

class SolarViewModel {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: SolarViewModel

        fun getInstance(): SolarViewModel {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = SolarViewModel()
                }
                return instance
            }
        }
    }

    var label: Label = Label("Solar System")
    var button: Button = Button("Start")
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