package com.example.galaxypattern.util.stringFacadeManager

import com.example.galaxypattern.gui.solar.SolarViewModel
import com.example.galaxypattern.gui.start.StartViewModel
import com.example.galaxypattern.main.MainViewModel
import com.example.galaxypattern.util.stringFacadeManager.strings.EnglishStrings
import com.example.galaxypattern.util.stringFacadeManager.strings.GermanStrings

/**
 * Facade pattern
 *
 * @see IStringManager
 * @see StringManager
 * @see StringParam
 * @see Language
 * @see EnglishStrings
 * @see GermanStrings
 *
 * @return String
 */
class StringManager : IStringManager {
    private val viewModel = MainViewModel.getInstance()
    private val viewModelStart = StartViewModel.getInstance()
    private val viewModelSolar = SolarViewModel.getInstance()

    override fun getString(string: StringParam) : String {
        return when (viewModel.language) {
            Language.ENGLISH -> EnglishStrings().getString(string)
            Language.GERMAN -> GermanStrings().getString(string)
        }
    }

    fun resetStrings() {
        viewModelStart.resetStrings()
        viewModelSolar.resetStrings()
    }
}