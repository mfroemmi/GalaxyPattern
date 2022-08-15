package com.example.galaxypattern.gui.start

import com.example.galaxypattern.gui.start.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SunView
import com.example.galaxypattern.model.Planet
import javafx.scene.control.Button
import javafx.scene.control.Label

class StartViewModel {

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

    var planets: MutableList<Planet> = mutableListOf()

    var label: Label = Label("Galaxy Pattern")
    var button: Button = Button("Solar System")
    val backgroundView = BackgroundView()
    val sunView = SunView()

    init {
        label.apply {
            translateY = -200.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        button.apply {
            translateY = 200.0
            style = "-fx-background-color: #FFFFFF;"
        }

        createPlanets()
    }

    private fun createPlanets() {
        planets.add(Planet("Merkur", 4878.0f, 0.055f, 5.43f))
    }

}