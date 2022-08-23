package com.example.galaxypattern.gui.start

import com.example.galaxypattern.main.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SolarSystemView
import javafx.scene.control.Button
import javafx.scene.control.Label

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
    val backgroundView = BackgroundView()
    val solarSystemView = SolarSystemView()

    init {
        label.apply {
            translateY = -200.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        button.apply {
            translateY = 200.0
            style = "-fx-background-color: #FFFFFF;"
        }
    }
}