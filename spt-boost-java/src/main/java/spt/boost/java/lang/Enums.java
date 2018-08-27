/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spt.boost.java.lang;

import lombok.NonNull;
import spt.boost.java.util.Logs;

/**
 * {@link Enum} utilities
 */
public class Enums {
	
	/**
	 * Constructor
	 */
	protected Enums() {
		
		/* NOP */
	}
	
	/**
	 * Of
	 * 
	 * @param clazz {@link Enum}
	 * @param id ID
	 * @param <E> {@link Enum} type
	 * @param <I> ID type
	 * @return {@link Enum}
	 * @throws IllegalStateException if not found
	 */
	public static <E extends Enum<E> & Identifiable<I>, I> E of(@NonNull Class<E> clazz, @NonNull I id)
		throws IllegalStateException {
		
		for (E constant : clazz.getEnumConstants()) {
			
			if (constant.getId().equals(id)) {
				
				return constant;
			}
		}
		
		throw new IllegalStateException(Logs.of("Enum not found").with(clazz, id));
	}
}
