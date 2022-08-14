package com.example.galaxypattern.gui.start

import com.example.galaxypattern.gui.start.view.BackgroundView
import com.example.galaxypattern.gui.start.view.SunView
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

    var label: Label = Label("This is the First Scene")
    var button: Button = Button("Switch scene")
    val backgroundView = BackgroundView()
    val sunView = SunView()

    init {
        label.apply {
            translateY = -200.0
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 24; "
        }
        button.apply {
            translateY = 200.0
            style = "-fx-background-color: #FFFFFF;"
        }
    }

}