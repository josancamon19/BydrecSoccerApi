package com.josancamon19.bydrecsoccerapi.models

import com.josancamon19.bydrecsoccerapi.models.match.CompetitionStage
import com.josancamon19.bydrecsoccerapi.models.match.Score
import com.josancamon19.bydrecsoccerapi.models.match.Team
import com.josancamon19.bydrecsoccerapi.models.match.Venue

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