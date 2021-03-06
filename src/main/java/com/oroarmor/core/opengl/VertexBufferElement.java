package com.oroarmor.core.opengl;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;

/**
 * This class represents one element of a Vertex when passed into OpenGL
 * 
 * @author OroArmor
 *
 */
public class VertexBufferElement {
	/**
	 * 
	 * @param type The type of the {@link VertexBufferElement}
	 * @return The size in bytes of the type
	 */
	public static int getSize(int type) {
		switch (type) {
		case GL_FLOAT:
			return 4;
		case GL_UNSIGNED_INT:
			return 4;
		case GL_UNSIGNED_BYTE:
			return 1;
		default:
			return 0;
		}
	}

	/**
	 * The count of bytes
	 */
	private int count;

	/**
	 * If the data is normalized
	 */
	private boolean normalized;

	/**
	 * The type of the {@link VertexBufferElement}. One of the OpenGL data types.
	 */
	private int type;

	/**
	 * 
	 * @param count      The count in bytes of the data
	 * @param type       The type of the data
	 * @param normalized If the data is normalized
	 */
	public VertexBufferElement(int count, int type, boolean normalized) {
		this.count = count;
		this.type = type;
		this.normalized = normalized;
	}

	/**
	 * 
	 * @return The count in bytes
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @return The type of the data
	 */
	public int getType() {
		return type;
	}

	/**
	 * 
	 * @return True the data is normalize
	 */
	public boolean isNormalized() {
		return normalized;
	}
}