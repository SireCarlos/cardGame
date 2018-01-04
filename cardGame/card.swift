//
//  card.swift
//  cardGame
//
//  Created by Robert Halwaß on 04.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

enum Colour{
    case red
    case blue
    case green
}

class Card{
    
    let name : String;
    let number : Int;
    let colour : Colour;
    let value : Int;
    let image : String;

    init(name: String, number: Int, colour: Colour, value: Int, image: String) {
        self.name = name;
        self.number = number;
        self.colour = colour;
        self.value = value;
        self.image = image;
    }
}

