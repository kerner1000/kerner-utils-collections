package net.sf.kerner.utils.collections;

import java.util.Collection;

import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.impl.UtilCollection;
import net.sf.kerner.utils.math.point.Point3D;

public class ViewPoint3DX implements Transformer<Point3D, Double>, TransformerCollection<Point3D, Double> {

    public Double transform(final Point3D element) {
        if (element == null) {
            return null;
        }
        return element.getX();
    }

    public Collection<Double> transformCollection(final Collection<? extends Point3D> element) {
        final Collection<Double> result = UtilCollection.newCollection();
        for (final Point3D p : element) {
            result.add(transform(p));
        }
        return result;
    }

}
