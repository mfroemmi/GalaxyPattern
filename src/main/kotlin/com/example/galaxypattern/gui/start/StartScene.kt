package com.example.galaxypattern.gui.start

import com.example.galaxypattern.main.MainViewModel
import com.example.galaxypattern.nav.NavController
import com.example.galaxypattern.util.stringFacadeManager.Language
import com.example.galaxypattern.util.stringFacadeManager.StringManager
import javafx.animation.AnimationTimer
import javafx.scene.layout.StackPane

class StartScene : StackPane() {
    private val navController = NavController.getInstance()
    private val viewModel = StartViewModel.getInstance()
    private val viewModelMain = MainViewModel.getInstance()

    private val scene = this

    private val timer: AnimationTimer = object : AnimationTimer() {
        override fun handle(now: Long) {
            update()
        }
    }

    init {
        scene.children.addAll(viewModel.backgroundView, viewModel.solarSystemView, viewModel.label, viewModel.button, viewModel.language, viewModel.languageLabel)
        start()
        timer.start()
    }

    private fun start() {
        viewModel.button.setOnAction {
            navController.navigateTo("SolarScene")
        }

        viewModel.languageItemEnglish.setOnAction {
            viewModelMain.language = Language.ENGLISH
            StringManager().resetStrings()
        }

        viewModel.languageItemGerman.setOnAction {
            viewModelMain.language = Language.GERMAN
            StringManager().resetStrings()
        }

        viewModel.solarSystemView.update()
    }

    private fun update() {
        viewModel.backgroundView.draw()
        viewModel.solarSystemView.update()

        when (viewModelMain.language) {
            Language.ENGLISH -> viewModel.languageLabel.text = "English"
            Language.GERMAN -> viewModel.languageLabel.text = "German"
        }
    }
}