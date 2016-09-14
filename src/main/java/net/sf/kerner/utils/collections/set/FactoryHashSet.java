/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.kerner.utils.collections.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.sf.kerner.utils.Factory;

/**
 * 
 * A {@link FactorySet} to create instances of {@link HashSet}.
 * 
 * 
 * @param <E>
 */
public class FactoryHashSet<E> implements FactorySet<E>, Factory<Set<E>> {

    /**
     * 
     */
    public Set<E> create() {
	return createCollection();
    }

    /** 
     * 
     */
    public Set<E> createCollection() {
	return new HashSet<E>();
    }

    /**
     * 
     */
    public Set<E> createCollection(final Collection<? extends E> template) {
	return new HashSet<E>(template);
    }

}
