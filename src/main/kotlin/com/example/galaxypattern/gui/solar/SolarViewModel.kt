package com.example.galaxypattern.gui.solar

import com.example.galaxypattern.gui.solar.view.SolarSystemView
import com.example.galaxypattern.gui.solar.view.infobox.InfoBoxView
import com.example.galaxypattern.main.view.BackgroundView
import com.example.galaxypattern.main.view.MainMenuView
import com.example.galaxypattern.main.view.PlanetView
import javafx.scene.control.Label
import javax.swing.plaf.synth.Region

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
    val backgroundView = BackgroundView()
    val solarSystemView = SolarSystemView()
    val mainMenuView = MainMenuView(700.0, 50.0)

    var planetInfoBoxes: MutableList<InfoBoxView> = mutableListOf()

    var isRotate = false

    init {
        label.apply {
            translateY = -300.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        mainMenuView.apply {
            translateY = 300.0
            setMaxSize(700.0, 50.0)
        }
    }
}