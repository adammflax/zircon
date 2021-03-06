package org.codetome.zircon.api.game

import org.codetome.zircon.api.Beta
import org.codetome.zircon.api.Size
import org.codetome.zircon.api.TextCharacter
import org.codetome.zircon.api.graphics.TextImage

/**
 * Note that this class is in **BETA**!
 * It's API is subject to change!
 */
@Beta
interface GameArea {

    /**
     * Returns the size of the 3D space this [GameArea] represents.
     */
    fun getSize(): Size3D

    /**
     * Returns a 2D segment of 3D space at a given 3D position and of a given
     * 2D size.
     */
    fun getSegmentAt(offset: Position3D, size: Size): GameAreaSegment

    /**
     * Returns the [TextCharacter]s at the given [Position3D].
     * Since there can be multiple layers on the same height a [List] is returned
     * instead of a single [TextCharacter].
     * Note that the returned [TextCharacter]s are ordered from bottom to top.
     */
    fun getCharactersAt(position: Position3D): List<TextCharacter>

    /**
     * Returns the layer as a [TextImage] at a given level and index.
     */
    fun getLayerAt(level: Int, layerIdx: Int): TextImage

    /**
     * Returns the number of levels this [GameArea] has.
     */
    fun getLevelCount() = getSize().height


    /**
     * Sets the [TextCharacter]s at the given position. Text characters are ordered
     * as layers from bottom to top.
     */
    fun setCharactersAt(position: Position3D, characters: List<TextCharacter>)

    /**
     * Sets the [TextCharacter]s at the given position and layer. Text characters are ordered
     * as layers from bottom to top.
     */
    fun setCharacterAt(position: Position3D, layerIdx: Int, character: TextCharacter)

}