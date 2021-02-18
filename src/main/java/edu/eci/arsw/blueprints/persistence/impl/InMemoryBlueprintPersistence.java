/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service("InMemoryBlueprintPersistence")
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<Tuple<String,String>,Blueprint> blueprints=new HashMap<>();
    
    public InMemoryBlueprintPersistence() {
        //plano 1
        Point[] point1=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp1=new Blueprint("Daniel", "bp1 ",point1);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        // plano 2
        Point[] point2=new Point[]{new Point(12, 13),new Point(14, 15)};
        Blueprint bp2=new Blueprint("Sebastian", "bp2 ",point2);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        // plano 3
        Point[] point3=new Point[]{new Point(26, 27),new Point(28, 29)};
        Blueprint bp3=new Blueprint("Daniel", "bp3 ",point3);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);
        
        
    }    
    
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
        	
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
    	Blueprint blpr=blueprints.get(new Tuple<>(author, bprintname));
    	if(blpr==null) {
    		throw new BlueprintNotFoundException("Este plano esta mal");
    	}
        return blpr;
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        Set<Tuple<String,String>> tuple = blueprints.keySet();
        Set<Blueprint> bpauthor = new HashSet<>();
        for(Tuple<String,String> x : tuple){
            if(author.equals(x.getElem1())){ 
                bpauthor.add(blueprints.get(x));
            }
        }
        if(bpauthor.size()==0) {
        	throw new BlueprintNotFoundException("Este usuario es incorrecto");
        }
        
        return bpauthor;
}

	
	@Override
	public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
		//Set<Blueprint> list = new HashSet(.);
		return new HashSet<Blueprint>(blueprints.values());
	}
}
