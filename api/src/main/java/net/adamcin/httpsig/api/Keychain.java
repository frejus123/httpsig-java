/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package net.adamcin.httpsig.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Immutable interface for a list of {@link Key}s
 */
public interface Keychain extends Iterable<Key> {

    /**
     * @return a {@link Set} containing the union of all algorithms supported by each {@link Key} in this {@link Keychain}
     */
    Set<Algorithm> getAlgorithms();

    /**
     * Filter this keychain by a {@link Collection} of supported {@link Algorithm}s
     * @param algorithms
     * @return a new {@link Keychain} containing only those keys which support at least one of the provided algorithms
     */
    Keychain filterAlgorithms(Collection<Algorithm> algorithms);

    /**
     * @return a reference to a {@link Keychain} which excludes the current {@link Key}.
     */
    Keychain discard();

    /**
     * @return a reference to the current {@link Key}.
     */
    Key currentKey();

    /**
     * @param keyId
     * @return a {@link Map} where the values are the {@link Key}s and the map entry keys are the keyId's generated by the {@link KeyId}, o
     */
    Map<String, Key> toMap(KeyId keyId);

    /**
     * @return true if this {@link Keychain} has no more keys
     */
    boolean isEmpty();
}
