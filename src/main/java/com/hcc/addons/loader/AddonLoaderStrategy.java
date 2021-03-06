/*
 *     Hypixel Community Client, Client optimized for Hypixel Network
 *     Copyright (C) 2018  HCC Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hcc.addons.loader;

import com.hcc.addons.annotations.Instance;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Base for AddonLoader
 */
public class AddonLoaderStrategy {

    public static void assignInstances(Object instance) throws IllegalAccessException {
        Class<?> clazz = instance.getClass();
        Field fields[] = clazz.getFields();
        for (Field field : fields) {

            Annotation annotation = field.getAnnotation(Instance.class);

            if (annotation != null) {
                field.setAccessible(true);
                field.set(instance, instance);
            }
        }
    }

    /**
     * Override this method in the AddonLoader
     * @param file file to load
     * @throws Exception when exception occurs
     */
    public void load(File file) throws Exception {
    }
}
