// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package db.mapDB;

import java.io.Serializable;
import java.util.NavigableSet;

import org.mapdb.BTreeMap;
import org.mapdb.Bind;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Fun;

/**
 * Example demonstrate 1:N relation between two collections. Secondary set is updated automatically when primary map is
 * modified.
 */
public class Secondary_Values {

    /**
     * Each Person class contains name and coma-separated string of friend names
     */
    static class Person implements Serializable {

        final int id;

        final String name;

        // coma separated list of friends
        final String friends;

        Person(int id, String name, String friends) {
            this.id = id;
            this.name = name;
            this.friends = friends;
        }
    }

    public static void main(String[] args) {
        DB db = DBMaker.newMemoryDB().make();
        // list if friends
        BTreeMap<Integer, Person> friends = db.getTreeMap("friends");

        // secondary collections which lists all friends for given id
        NavigableSet<Fun.Tuple2<Integer, String>> id2friends = db.getTreeSet("id2friends");

        // keep secondary synchronized with primary
        Bind.secondaryValues(friends, id2friends, new Fun.Function2<String[], Integer, Person>() {

            public String[] run(Integer integer, Person person) {
                return person.friends.split(",");
            }
        });

        // add into primary
        friends.put(1, new Person(1, "John", "Karin,Peter"));
        friends.put(2, new Person(2, "Karin", "Peter"));
        // secondary now contains [1,Karin], [1,Peter], [2,Peter]
        System.out.println(id2friends);

        // list all friends associated with John. This does range query on NavigableMap
        for (String name : Fun.filter(id2friends, 1)) {
            System.out.println(name);
        }

    }

}
