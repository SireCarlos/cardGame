//
//  card.swift
//  cardGame
//
//  Created by Robert Halwaß on 04.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import Foundation

class Card{
    
    let name : String;
    let id : Int;
    let colour : Colour;
    let value : Int;
    let image : String;
    
    init(name: String, id: Int, colour: Colour, value: Int, image: String) {
        self.name = name;
        self.id = id;
        self.colour = colour;
        self.value = value;
        self.image = image;
    }
}

