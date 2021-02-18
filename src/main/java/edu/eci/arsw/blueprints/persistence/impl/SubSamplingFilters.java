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

@Service("SubSampling")
public class SubSamplingFilters implements FiltersPersistence {
	
    @Override
    public Blueprint Filters(Blueprint bpp) {
    	
        List<Point> list = bpp.getPoints();
        List<Point> out = new ArrayList<Point>();
        
        boolean it=true;
        for(Point p : list){
            if(it) out.add(p);
            it=!it;
        }
        return new Blueprint(bpp.getAuthor(),bpp.getName(),out);
    }
}