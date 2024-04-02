package fi.paradox.p7.dbmodels

data class PokemonDto(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val weight: Int
    // Pridajte ďalšie polia podľa potreby
)