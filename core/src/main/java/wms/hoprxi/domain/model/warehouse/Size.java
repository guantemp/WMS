/*
 * Copyright 2019 www.hoprxi.com All rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package wms.hoprxi.domain.model.warehouse;

import java.util.StringJoiner;

/***
 * @author <a href="www.hoprxi.com/authors/guan xiangHuan">guan xiangHuan</a>
 * @since JDK8.0
 * @version 0.0.1 2019-01-07
 */
public class Size {
    private double width;
    private double height;
    private double length;
    private Unit unit;

    public Size(double width, double height, double length, Unit unit) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.unit = unit;
    }

    public double width() {
        return width;
    }


    public double height() {
        return height;
    }


    public double length() {
        return length;
    }


    public Unit unit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (Double.compare(size.width, width) != 0) return false;
        if (Double.compare(size.height, height) != 0) return false;
        if (Double.compare(size.length, length) != 0) return false;
        return unit == size.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Size.class.getSimpleName() + "[", "]")
                .add("width=" + width)
                .add("height=" + height)
                .add("length=" + length)
                .add("unit=" + unit)
                .toString();
    }
}
