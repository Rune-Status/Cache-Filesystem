/*
   Copyright 2018 Bart van Helvert

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package io.github.runedata.cache.filesystem.crypto

import java.math.BigInteger
import java.nio.ByteBuffer

fun rsaCrypt(buffer: ByteBuffer, modulus: BigInteger, key: BigInteger): ByteBuffer {
    val bytes = ByteArray(buffer.limit())
    buffer.get(bytes)
    val inb = BigInteger(bytes)
    val out = inb.modPow(key, modulus)
    return ByteBuffer.wrap(out.toByteArray())
}

object Xtea {
    const val GOLDEN_RATIO = -0x61c88647
    const val ROUNDS = 32
    const val KEY_SIZE = 4
    val NULL_KEYS = IntArray(KEY_SIZE)
}