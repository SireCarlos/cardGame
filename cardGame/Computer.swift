//
//  Computer.swift
//  cardGame
//
//  Created by Robert Halwaß on 11.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

class Computer: Player{
    
    func selectCard()->Card{
        return cards.removeFirst()
    }
}


