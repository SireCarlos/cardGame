//
//  deck.swift
//  cardGame
//
//  Created by Robert Halwaß on 04.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

class Deck{
    
    var cards : [Card]
    
    let g9 = Card(name: "Bisaflor", id: 1, colour: Colour.green , value: 9, image: "bisaflor.png")
    let g8 = Card(name: "Rexblisar", id: 2, colour: Colour.green , value: 8, image: "bisaflor.png")
    let g7 = Card(name: "Shaymin", id: 3, colour: Colour.green , value: 7, image: "bisaflor.png")
    let g6 = Card(name: "Tengulist", id: 4, colour: Colour.green , value: 6, image: "bisaflor.png")
    let g5 = Card(name: "Giflor", id: 5, colour: Colour.green , value: 5, image: "bisaflor.png")
    let g4 = Card(name: "Kapilz", id: 6, colour: Colour.green , value: 4, image: "bisaflor.png")
    let g3 = Card(name: "Tropius", id: 7, colour: Colour.green , value: 3, image: "bisaflor.png")
    let g2 = Card(name: "Folipurba", id: 8, colour: Colour.green , value: 2, image: "bisaflor.png")
    let g1 = Card(name: "Tangela", id: 9, colour: Colour.green , value: 1, image: "bisaflor.png")
    let g0 = Card(name: "Knofensa", id: 10, colour: Colour.green , value: 0, image: "bisaflor.png")
    
    let b9 = Card(name: "Turtok", id: 11, colour: Colour.blue , value: 9, image: "bisaflor.png")
    let b8 = Card(name: "Gyarados", id: 12, colour: Colour.blue , value: 8, image: "bisaflor.png")
    let b7 = Card(name: "Manaphy", id: 13, colour: Colour.blue , value: 7, image: "bisaflor.png")
    let b6 = Card(name: "Austos", id: 14, colour: Colour.blue , value: 6, image: "bisaflor.png")
    let b5 = Card(name: "Wallord", id: 15, colour: Colour.blue , value: 5, image: "bisaflor.png")
    let b4 = Card(name: "Octillery", id: 16, colour: Colour.blue , value: 4, image: "bisaflor.png")
    let b3 = Card(name: "Relicanth", id: 17, colour: Colour.blue , value: 3, image: "bisaflor.png")
    let b2 = Card(name: "Aquana", id: 18, colour: Colour.blue , value: 2, image: "bisaflor.png")
    let b1 = Card(name: "Lampi", id: 19, colour: Colour.blue , value: 1, image: "bisaflor.png")
    let b0 = Card(name: "Tentacha", id: 20, colour: Colour.blue , value: 0, image: "bisaflor.png")
    
    let r9 = Card(name: "Glurak", id: 21, colour: Colour.red , value: 9, image: "bisaflor.png")
    let r8 = Card(name: "Arkani", id: 22, colour: Colour.red , value: 8, image: "bisaflor.png")
    let r7 = Card(name: "Victini", id: 23, colour: Colour.red , value: 7, image: "bisaflor.png")
    let r6 = Card(name: "Camerupt", id: 24, colour: Colour.red , value: 6, image: "bisaflor.png")
    let r5 = Card(name: "Flampivian", id: 25, colour: Colour.red , value: 5, image: "bisaflor.png")
    let r4 = Card(name: "Houndoom", id: 26, colour: Colour.red , value: 4, image: "bisaflor.png")
    let r3 = Card(name: "Heatmor", id: 27, colour: Colour.red , value: 3, image: "bisaflor.png")
    let r2 = Card(name: "Flamara", id: 28, colour: Colour.red , value: 2, image: "bisaflor.png")
    let r1 = Card(name: "Ponita", id: 29, colour: Colour.red , value: 1, image: "bisaflor.png")
    let r0 = Card(name: "Vulpix", id: 29, colour: Colour.red , value: 0, image: "bisaflor.png")
    
    init(){
        cards = [g9, g8,g7,g6,g5,g4,g3,g2,g1,g0,b9,b8,b7,b6,b5,b4,b3,b2,b1,b0,r9,r8,r7,r6,r5,r4,r3,r2,r1,r0]
        shuffleDeck()
    }
    
    func shuffleDeck(){
        let numberOfCards = UInt32(cards.count)
        for _ in 0...300{
            let randnum1 = Int(arc4random_uniform(numberOfCards))
            let randnum2 = Int(arc4random_uniform(numberOfCards))
            let temp = cards[randnum1]
            cards[randnum1] = cards[randnum2]
            cards[randnum2] = temp
        }
    }
}
