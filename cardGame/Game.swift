//
//  Game.swift
//  cardGame
//
//  Created by Robert Halwaß on 11.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

class Game{
    var players : [Player] = []
    let deck = Deck()
    let table = Table()
    var turnCounter : Int = 1
    var gameOver = false
    var currentPlayer = Players.none
    var winner = Players.none
    
    
    init(){
        players = [Player(name: "Spieler1"), Computer(name: "Computer")]
        for player in players{
            for _ in 0...4{
                let tempCard = deck.cards.removeFirst()
                player.cards.append(tempCard)
            }
        }
        let start = Int(arc4random_uniform(UInt32(players.count)))
        if start == 0{
            currentPlayer = .player1
        }
        else{
            currentPlayer = .computer
        }
        //TODO GUI: player[start] starts
    }
    
    
    
    func nextPlayer(){
        if currentPlayer == .player1{
            currentPlayer = .computer
        }
        else if currentPlayer == .computer{
            currentPlayer = .player1
        }
    }
    
    func playCard(index: Int){
        let playedCard = players[currentPlayer.rawValue].cards.remove(at: index)
        table.cards.append(playedCard)
        checkWinner()
        nextPlayer()
        turnCounter += 1
    }
    
    func checkWinner(){
        for player in players{
            if player.cards.count == 0{
                winner = currentPlayer
            }
        }
    }
    
}
