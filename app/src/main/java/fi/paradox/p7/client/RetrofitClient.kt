package fi.paradox.p7.client

import fi.paradox.p7.PokeApiService
import fi.paradox.p7.dbmodels.PokemonDto
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient constructor() {

   private  val pokeApi: PokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getUnsafeOkHttpClient())
            .build()
            .create(PokeApiService::class.java)
    }
    private fun getUnsafeOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.hostnameVerifier(object : HostnameVerifier {
            override fun verify(hostname: String?, session: SSLSession?): Boolean {
                return true // Dôveruje všetkým hostiteľom
            }
        })
        return builder.build()
    }
   suspend fun fetchPokemonData(pokemonName: String): PokemonDto? {
            try {
                val response = pokeApi.getPokemonByName(pokemonName)
                if (response.isSuccessful) {
                    val pokemon = response.body()
                    println(pokemon?.name)
                    return pokemon
                } else {
                    // Spracujte chybovú odpoveď
                    println("Error: ${response.code()}")
                    return null
                }
            } catch (e: Exception) {
                // Spracujte výnimku
                e.printStackTrace()
                return null
            }
        }
}
