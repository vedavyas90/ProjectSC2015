/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsc2015;

import java.util.ArrayList;

/**
 *
 * @author aidb
 */
public class FeatureProcess {

    ArrayList<Feature> features = new ArrayList<>();
    public FeatureProcess(ArrayList<Feature> _features) {
        this.features = _features;
    }
    
    public ArrayList<Feature>getProcessedFeatures(){
        return features;
    }
    
}
