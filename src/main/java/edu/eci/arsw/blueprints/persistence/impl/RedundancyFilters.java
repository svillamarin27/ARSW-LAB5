package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.FiltersPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Vargas
 * @author Sebastian Villamarin
 */
@Service("Redundancy")
public class RedundancyFilters implements FiltersPersistence {

    @Override
    public Blueprint Filters(Blueprint bpp) {
        List<Point> list =bpp.getPoints();
        List<Point> out = new ArrayList<>();

        for (int x=0; x<list.size(); x++) {
            if (list.get(x)!=null){
            	
               out.add(list.get(x));
            }
            
            if(list.get(x)!=null) {
            	
                for (int y=x+1; y<list.size(); y++) {
                    if (list.get(y) != null) {
                    	
                        if (list.get(x).getX() == list.get(y).getX() && list.get(x).getY() == list.get(y).getY())
                            list.set(y, null);
                    }
                }
            }
        }
        return new Blueprint(bpp.getAuthor(), bpp.getName(), out);

    }
}