package it.thefedex87.jetpackcomposepokedex.pokemondetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import it.thefedex87.jetpackcomposepokedex.data.remote.responses.Pokemon
import it.thefedex87.jetpackcomposepokedex.repository.PokemonRepository
import it.thefedex87.jetpackcomposepokedex.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}