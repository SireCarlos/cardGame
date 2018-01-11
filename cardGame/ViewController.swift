//
//  ViewController.swift
//  cardGame
//
//  Created by Robert Halwaß on 04.01.18.
//  Copyright © 2018 Robert Halwaß. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource {

    @IBOutlet var myCollectionView: UICollectionView!
    @IBOutlet weak var tableView: UIImageView!
    
    let game = Game()
    
    var turnCounter = 1;
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.myCollectionView.delegate = self
        self.myCollectionView.dataSource = self
        updateTable()
        startComputer()
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return game.players[Players.player1.rawValue].cards.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "collection_cell", for: indexPath) as! MyCollectionViewCell
        cell.MyCardView.image = UIImage(named: game.players[0].cards[indexPath.row].name)
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didHighlightItemAt indexPath: IndexPath) {
        if game.currentPlayer == Players.player1{
            game.playCard(index: indexPath.row)
        }
        else{
            return
        }
    }
    
    func startComputer(){
        let computer = game.players[Players.computer.rawValue] as! Computer
        while(game.gameOver == false){
            if game.currentPlayer == .computer{
                let selectedCard = computer.selectCard()
                game.playCard(index: selectedCard)
            }
            else{
                continue
            }
        }
    }
    
    func updateTable(){
        while(game.gameOver == false){
            if game.turnCounter > turnCounter{
                tableView.image = UIImage(named: (game.table.cards.first?.image)!)
            }
        }
    }
}

