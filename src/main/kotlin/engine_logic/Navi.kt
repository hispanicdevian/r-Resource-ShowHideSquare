package engine_logic

//////////////////////////////////////////////////////////// Screen/View Navigation Anchor
sealed class Navi {
    data object Main : Navi()
    data object Settings : Navi()
    data object OnOffBxsSettings : Navi()
}