package com.oroarmor.core.opengl;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import com.oroarmor.core.Bindable;
import com.oroarmor.core.Destructable;
import com.oroarmor.core.Destructor;

public class VertexBufferObject implements Bindable, Destructable {
	private int vbo_id;

	public VertexBufferObject(float[] data) {
		vbo_id = glGenBuffers();

		bind();
		glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
		Destructor.addDestructable(this);
	}

	@Override
	public void bind() {
		glBindBuffer(GL_ARRAY_BUFFER, vbo_id);
	}

	@Override
	public void destroy() {
		glDeleteBuffers(vbo_id);
	}

	@Override
	public void unbind() {
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
}
