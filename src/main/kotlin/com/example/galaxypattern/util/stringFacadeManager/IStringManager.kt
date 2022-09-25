package com.example.galaxypattern.util.stringFacadeManager

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
 */
interface IStringManager {
    fun getString(string: StringParam) : String
}