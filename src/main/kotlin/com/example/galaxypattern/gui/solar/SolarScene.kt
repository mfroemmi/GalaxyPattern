package com.example.galaxypattern.gui.solar

import com.example.galaxypattern.gui.solar.view.infobox.InfoBoxView
import com.example.galaxypattern.model.Planet
import com.example.galaxypattern.nav.NavController
import javafx.animation.AnimationTimer
import javafx.scene.layout.StackPane

class SolarScene : StackPane() {
    private val navController = NavController.getInstance()
    private val viewModel = SolarViewModel.getInstance()

    private val scene = this

    private val timer: AnimationTimer = object : AnimationTimer() {
        override fun handle(now: Long) {
            update()
        }
    }

    init {
        scene.children.addAll(viewModel.backgroundView, viewModel.solarSystemView, viewModel.label, viewModel.mainMenuView)
        start()
        timer.start()
    }

    private fun start() {
        viewModel.mainMenuView.button.setOnAction {
            navController.navigateTo("StartScene")
        }
        viewModel.mainMenuView.btnPlayStop.setOnAction {
            viewModel.isRotate = !viewModel.isRotate
        }
        viewModel.solarSystemView.sun.setOnMouseClicked {
            println("Sun")
        }
        viewModel.solarSystemView.mercury.setOnMouseClicked {
            println("Mercury")
            createInfoBox(viewModel.solarSystemView.mercury.planet)
        }
        viewModel.solarSystemView.venus.setOnMouseClicked {
            println("Venus")
            createInfoBox(viewModel.solarSystemView.venus.planet)
        }
        viewModel.solarSystemView.earth.setOnMouseClicked {
            println("Earth")
            createInfoBox(viewModel.solarSystemView.earth.planet)
        }
        viewModel.solarSystemView.mars.setOnMouseClicked {
            println("Mars")
            createInfoBox(viewModel.solarSystemView.mars.planet)
        }
        viewModel.solarSystemView.jupiter.setOnMouseClicked {
            println("Jupiter")
            createInfoBox(viewModel.solarSystemView.jupiter.planet)
        }
        viewModel.solarSystemView.saturn.setOnMouseClicked {
            println("Saturn")
            createInfoBox(viewModel.solarSystemView.saturn.planet)
        }
        viewModel.solarSystemView.uranus.setOnMouseClicked {
            println("Uranus")
            createInfoBox(viewModel.solarSystemView.uranus.planet)
        }
        viewModel.solarSystemView.neptune.setOnMouseClicked {
            println("Neptune")
            createInfoBox(viewModel.solarSystemView.neptune.planet)
        }

        viewModel.solarSystemView.update()
    }

    private fun update() {
        viewModel.backgroundView.draw()
        viewModel.mainMenuView.update()
        if (viewModel.isRotate) {
            viewModel.solarSystemView.update(getRotationSpeed())
        }

        val removeList: MutableList<InfoBoxView> = mutableListOf()
        viewModel.planetInfoBoxes.forEach { infoBox ->
            if (infoBox.remove) {
                removeList.add(infoBox)
            }
            infoBox.update()
        }
        removeList.forEach {
            removeInfoBox(it)
        }
    }

    private fun getRotationSpeed(): Double {
        return if (viewModel.mainMenuView.slider.value < 1.0) {
            1.0
        } else {
            viewModel.mainMenuView.slider.value
        }
    }

    private fun createInfoBox(planet: Planet) {
        val newInfoBox = InfoBoxView(planet)

        viewModel.planetInfoBoxes.add(newInfoBox)
        scene.children.add(newInfoBox)
    }

    private fun removeInfoBox(infoBox: InfoBoxView) {
        viewModel.planetInfoBoxes.remove(infoBox)
        scene.children.remove(infoBox)
    }
}