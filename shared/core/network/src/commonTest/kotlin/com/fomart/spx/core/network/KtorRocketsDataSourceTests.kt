package com.fomart.spx.core.network

import com.fomart.spx.core.network.data.KtorRocketsDataSource
import com.fomart.spx.core.network.domain.RocketsDataSource
import com.fomart.spx.core.network.http.httpClient
import com.fomart.spx.core.model.domain.Result
import com.fomart.spx.core.model.domain.error.NetworkError
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class KtorRocketsDataSourceIntegrationTests {

    private lateinit var rocketsDataSource: RocketsDataSource

    @BeforeTest
    fun setup() {
        rocketsDataSource = KtorRocketsDataSource(httpClient)
    }

    @Test
    fun `getRocketPreviews returns actual data`() = runBlocking {
        val result = rocketsDataSource.getRocketPreviews()

        assertTrue(result is Result.Success)
        result as Result.Success

        println("Previews result:")
        result.data.forEach { println(it) }

        // Check that we got rockets
        assertTrue(result.data.isNotEmpty())

        // Verify each rocket preview has data
        result.data.forEach { preview ->
            assertTrue(preview.rocketId.isNotEmpty())
            assertTrue(preview.name.isNotEmpty())
        }
    }

    @Test
    fun `getRocketDetails returns complete data`() = runBlocking {
        val result = rocketsDataSource.getRocketDetails("falcon9")

        assertTrue(result is Result.Success)
        result as Result.Success

        val rocket = result.data

        println("Rocket details:")
        println(rocket)

        // Check basic info is present
        assertTrue(rocket.rocketId.isNotEmpty())
        assertTrue(rocket.description.isNotEmpty())

        // Check dimensions are present
        assertTrue(rocket.height > 0)
        assertTrue(rocket.diameter > 0)
        assertTrue(rocket.massKg > 0)

        // Check stages exist and have data
        assertTrue(rocket.stages.isNotEmpty())
        rocket.stages.forEach { stage ->
            assertTrue(stage.engines > 0)
            assertTrue(stage.fuel >= 0)
            assertTrue(stage.burnTime >= 0)
        }

        // Check photos exist
        assertTrue(rocket.photoLinks.isNotEmpty())
    }

    @Test
    fun `getRocketDetails with invalid id returns error`() = runBlocking {
        val result = rocketsDataSource.getRocketDetails("invalid_rocket_id")

        assertTrue(result is Result.Error)
        result as Result.Error

        // Should be a network error
        assertTrue(result.error is NetworkError)
    }
}