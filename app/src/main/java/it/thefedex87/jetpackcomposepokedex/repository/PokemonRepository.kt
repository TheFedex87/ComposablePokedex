package it.thefedex87.jetpackcomposepokedex.repository

import dagger.hilt.android.scopes.ActivityScoped
import it.thefedex87.jetpackcomposepokedex.data.remote.PokeApi
import it.thefedex87.jetpackcomposepokedex.data.remote.responses.Pokemon
import it.thefedex87.jetpackcomposepokedex.data.remote.responses.PokemonList
import it.thefedex87.jetpackcomposepokedex.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}