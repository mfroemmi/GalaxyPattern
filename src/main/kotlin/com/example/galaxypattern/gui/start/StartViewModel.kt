package com.example.galaxypattern.gui.start

import com.example.galaxypattern.main.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SolarSystemView
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

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
    var language: MenuButton = MenuButton("Language")
    var languageLabel: Label = Label("English")
    val backgroundView = BackgroundView()
    val solarSystemView = SolarSystemView()

    val languageItemEnglish = MenuItem("English")
    val languageItemGerman = MenuItem("German")

    init {
        language.items.addAll(languageItemEnglish, languageItemGerman)

        label.apply {
            translateY = -300.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 48; "
        }
        languageLabel.apply {
            translateY = 300.0
            translateX = 250.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 16; "
        }
        button.apply {
            maxWidth = 100.0
            translateY = 300.0
            style = "-fx-background-color: #99CCFF;"
        }
        language.apply {
            maxWidth = 100.0
            translateY = 300.0
            translateX = 150.0
            style = "-fx-background-color: #99CCFF;"
        }
    }
}