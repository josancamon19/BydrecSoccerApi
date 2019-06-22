package com.josancamon19.bydrecsoccerapi.models

data class Match(
    val id: Int,
    val type: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val date: String,
    val competitionStage: CompetitionStage,
    val venue: Venue,
    val state: String,
    val score: Score
)