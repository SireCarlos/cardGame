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
    
    var images = ["b0", "r1", "g2", "r3", "r4"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.myCollectionView.delegate = self
        self.myCollectionView.dataSource = self
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return images.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "collection_cell", for: indexPath) as! MyCollectionViewCell
        
        //set images
        cell.MyCardView.image = UIImage(named: images[indexPath.row])
        return cell
    }
}

