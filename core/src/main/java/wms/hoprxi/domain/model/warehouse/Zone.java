/*
 * Copyright 2019 www.foxtail.cc All rights Reserved.
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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringJoiner;

/***
 * @author <a href="www.foxtail.cc/authors/guan xiangHuan">guan xiangHuan</a>
 * @since JDK8.0
 * @version 0.0.1 2019-01-07
 */
public class Zone {
    private static final int DEPTH = 5;
    private String id;
    private String name;
    private Deque<String> treePath;

    public Zone(String id, String name) {
        setId(id);
        setName(name);
    }

    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "id required").trim();
    }

    private void setName(String name) {
        name = Objects.requireNonNull(name, "name is required").trim();
        if (name.isEmpty())
            throw new IllegalArgumentException("Names cannot be empty");
        this.name = name;
    }

    public void rename(String name) {
        name = Objects.requireNonNull(name, "name is required").trim();
        if (!this.name.equals(name))
            this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zone zone = (Zone) o;

        return id != null ? id.equals(zone.id) : zone.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Zone.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .toString();
    }

    public void assignTo(Zone parent) {
        if (parent != null) {
            treePath = new ArrayDeque<>();
            if (parent.treePath != null && parent.treePath.size() < DEPTH) {
                for (String s : parent.treePath) {
                    treePath.offerLast(s);
                }
            }
            treePath.offerLast(parent.id);
        }
    }

    public void unassign() {
        treePath = null;
    }
}
