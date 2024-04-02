package fi.paradox.p7

import fi.paradox.p7.dbmodels.PokemonDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{name}")
suspend fun getPokemonByName(@Path("name") name: String): Response<PokemonDto>

}