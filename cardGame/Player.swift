//
//  Player.swift
//  cardGame
//
//  Created by Robert Halwaß on 11.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

class Player {
    let name : String
    var cards : [Card] = []
    
    init(name: String){
        self.name = name
    }
}
