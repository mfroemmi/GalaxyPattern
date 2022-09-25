package com.example.galaxypattern.util.planetFactory

/**
 * Factory pattern
 *
 * @see IPlanetParamHelper
 * @see PlanetType
 * @see AllParams
 * @see NoAtmosphere
 * @see NoMoons
 * @see NoMoonsAtmosphere
 */
interface IPlanetParamHelper {
    fun name(): String
    fun diameter(): String
    fun mass(): String
    fun density(): String
    fun distance(): String
    fun period(): String
    fun rotation(): String
    fun atmosphere(): String
    fun moons(): String
    fun inclination(): String
}