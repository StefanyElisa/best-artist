//Stefany Elisa
//Maria Eduarda Anunciato

package com.example.bestartist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bestartist.ui.theme.BestArtistTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BestArtistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoriteArtist(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true)
@Composable
fun FavoriteArtist(modifier: Modifier = Modifier) {
    var BTS by remember { mutableStateOf(0) }
    var ImagineDragons by remember { mutableStateOf(0) }
    var TheCure by remember { mutableStateOf(0) }
    var Livinho by remember { mutableStateOf(0) }
    var Nanjoon by remember { mutableStateOf(0) }
    var totalVotes by remember { mutableStateOf(0) }

    val selectedArtist = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),

    ) {
        Text(
            text = "Who is your favorite artist?",
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                VoteButton(artist = "BTS", image = R.drawable.bts, onVote = { BTS++; totalVotes++; selectedArtist.value = "BTS" })
            }
            Column(
                modifier = Modifier.width(40.dp)
            ) {
                Text(text = "$BTS", textAlign = TextAlign.Center)
            }
            Column {
                Text(text = "${percentage(BTS, totalVotes)}%", textAlign = TextAlign.End)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                VoteButton(artist = "ImagineDragons", image = R.drawable.imag__dragons, onVote = { ImagineDragons++; totalVotes++; selectedArtist.value = "ImagineDragons" })
            }
            Column(
                modifier = Modifier.width(40.dp)
            ) {
                Text(text = "$ImagineDragons", textAlign = TextAlign.Center)
            }
            Column {
                Text(text = "${percentage(ImagineDragons, totalVotes)}%", textAlign = TextAlign.End)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                VoteButton(artist = "TheCure", image = R.drawable.the_cure, onVote = { TheCure++; totalVotes++; selectedArtist.value = "TheCure" })
            }
            Column(
                modifier = Modifier.width(40.dp)
            ) {
                Text(text = "$TheCure", textAlign = TextAlign.Center)
            }
            Column {
                Text(text = "${percentage(TheCure, totalVotes)}%", textAlign = TextAlign.End)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                VoteButton(artist = "Livinho", image = R.drawable.livinho, onVote = { Livinho++; totalVotes++; selectedArtist.value = "Livinho" })
            }
            Column(
                modifier = Modifier.width(40.dp)
            ) {
                Text(text = "$Livinho", textAlign = TextAlign.Center)
            }
            Column {
                Text(text = "${percentage(Livinho, totalVotes)}%", textAlign = TextAlign.End)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                VoteButton(artist = "Nanjoon", image = R.drawable.rmmylove, onVote = { Nanjoon++; totalVotes++; selectedArtist.value = "Nanjoon" })
            }
            Column(
                modifier = Modifier.width(40.dp)
            ) {
                Text(text = "$Nanjoon", textAlign = TextAlign.Center)
            }
            Column {
                Text(text = "${percentage(Nanjoon, totalVotes)}%", textAlign = TextAlign.End)
            }
        }

        Text(text = "Total de votos: $totalVotes", fontSize = 20.sp)
    }
}

@Composable
fun VoteButton(artist: String, image: Int, onVote: () -> Unit) {
    Button(
        onClick = { onVote() },
        ) {
        Column {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Foto de $artist",
                modifier = Modifier.size(100.dp),

            )
            Text(text = artist)
        }
    }
}

fun percentage(votes: Int, totalVotes: Int): Float {
    return if (totalVotes > 0) ((votes.toFloat() / totalVotes.toFloat()) * 100).toFloat().roundTo(2) else 0f
}

fun Float.roundTo(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

