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
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.kerner.utils.Factory;

/**
 * 
 * A {@link FactorySet} to create instances of {@link LinkedHashSet}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed: 2013-08-07
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-07
 * 
 * @param <E>
 */
public class FactoryLinkedHashSet<E> implements FactorySet<E>, Factory<Set<E>> {

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
	return new LinkedHashSet<E>();
    }

    /**
     * 
     */
    public Set<E> createCollection(final Collection<? extends E> template) {
	return new LinkedHashSet<E>(template);
    }

}
